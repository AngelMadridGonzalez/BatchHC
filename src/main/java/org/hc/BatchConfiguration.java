package org.hc;

import javax.sql.DataSource;

import org.hc.model.in.CuentasClientesOld;
import org.hc.model.out.CuentasClientesNew;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.validation.BindException;

@Configuration
public class BatchConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(BatchConfiguration.class);

	@Value("${file.input}")
	private String fileInput;

	@Bean
	public FlatFileItemReader<CuentasClientesOld> reader() {
		LOGGER.info("*******INI reader *******");
		FlatFileItemReader<CuentasClientesOld> reader = new FlatFileItemReaderBuilder<CuentasClientesOld>()
				.name("cuentasClientesOldItemReader")
				.resource(new ClassPathResource("cuentasclientes.csv"))
				.delimited()
				.names(new String[] { "lnk_idcliente", "direccion", "fecha" })
				.encoding("ISO_8859_1")
				.fieldSetMapper(new BeanWrapperFieldSetMapper<CuentasClientesOld>() {
					{
						this.setTargetType(CuentasClientesOld.class);
					}
//					@Override
//					public CuentasClientesOld mapFieldSet(FieldSet fs) throws BindException {
//
//						CuentasClientesOld tmp= super.mapFieldSet(fs);
//						tmp.setIdCliente(fs.readRawString(0).replaceAll("\uFFFD", ""));
//						tmp.setFecha(fs.readRawString(1));
//						tmp.setDireccion(fs.readRawString(2));
//
//
//						return tmp;
//					}
				})
				.build();

		LOGGER.info("******* END reader *******");
		return reader;
	}

	@Bean
	public CuentasClientesItemProcessor processor() {
		return new CuentasClientesItemProcessor();
	}

	@Bean
	public JdbcBatchItemWriter<CuentasClientesNew> writer(DataSource dataSource) {
		LOGGER.info("*******INI JdbcBatchItemWriter *******");
		return new JdbcBatchItemWriterBuilder<CuentasClientesNew>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				// FIXME Aqui metemos la query
				.sql("INSERT INTO CuentasClientesNew (id, idCliente, idTicketCobro, tarjeta, importe, estado) VALUES (:id, :idCliente, :idTicketCobro, :tarjeta, :importe, :estado)")
				.dataSource(dataSource).build();
	}

	@Bean
	public Job importUserJob(JobRepository jobRepository, JobCompletionNotificationListener listener, Step step1) {
		LOGGER.info("*******INI importUserJob *******");
		return new JobBuilder("importUserJob", jobRepository).incrementer(new RunIdIncrementer()).listener(listener)
				.flow(step1).end().build();
	}

	@Bean
	public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager,
			JdbcBatchItemWriter<CuentasClientesNew> writer) {
		LOGGER.info("*******INI step1 *******");
		LOGGER.info("**************  jobRepository ( {} ) transactionManager ( {} ) writer ( {} ) ",
				jobRepository, transactionManager, writer);

		Step step1 =  new StepBuilder("step1", jobRepository)
				.<CuentasClientesOld, CuentasClientesNew>chunk(10, transactionManager).reader(reader())
				.processor(processor())
				.writer(writer)
				.faultTolerant()
				.skip(FlatFileParseException.class)
				.skipLimit(10)
				.build();

		return step1;
	}
}
