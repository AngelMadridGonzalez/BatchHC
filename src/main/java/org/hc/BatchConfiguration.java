package org.hc;

import javax.sql.DataSource;

import org.hc.dtos.in.CuentasClientesOld;
import org.hc.dtos.out.CuentasClientesNew;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfiguration {

	@Value("${file.input}")
	private String fileInput;

	@Bean
	public FlatFileItemReader<CuentasClientesOld> reader() {
		return new FlatFileItemReaderBuilder<CuentasClientesOld>().name("cuentasClientesOldItemReader")
				.resource(new ClassPathResource(fileInput)).delimited()
				.names(new String[] { "lnk_idcliente", "direccion", "fecha" })
				.fieldSetMapper(new BeanWrapperFieldSetMapper<CuentasClientesOld>() {
					{
						setTargetType(CuentasClientesOld.class);
					}
				}).build();
	}

	@Bean
	public CuentasClientesItemProcessor processor() {
		return new CuentasClientesItemProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<CuentasClientesNew> writer(DataSource dataSource) {
		return new JdbcBatchItemWriterBuilder<CuentasClientesNew>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				// FIXME Aqui metemos la query
				.sql("INSERT INTO CuentasClientesNew (id, idCliente, idTicketCobro, tarjeta, importe, estado) VALUES (:id, :idCliente, :idTicketCobro, :tarjeta, :importe, :estado)")
				.dataSource(dataSource).build();
	}

	@Bean
	public Job importUserJob(JobRepository jobRepository, JobCompletionNotificationListener listener, Step step1) {
		return new JobBuilder("importUserJob", jobRepository).incrementer(new RunIdIncrementer()).listener(listener)
				.flow(step1).end().build();
	}

	@Bean
	public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager,
			JdbcBatchItemWriter<CuentasClientesNew> writer) {
		return new StepBuilder("step1", jobRepository)
				.<CuentasClientesOld, CuentasClientesNew>chunk(10, transactionManager).reader(reader())
				.processor(processor()).writer(writer).build();
	}

}
