package org.hc;

import javax.sql.DataSource;

import org.hc.model.in.CuentasClientesLineasOld;
import org.hc.model.in.CuentasClientesOld;
import org.hc.model.in.TicketCobrosOld;
import org.hc.model.out.CuentasClientesNew;
import org.hc.model.out.TicketCobrosNew;
import org.hc.processors.CuentasClientesLineasOldItemProcessor;
import org.hc.processors.CuentasClientesOldItemProcessor;
import org.hc.processors.TicketCobrosOldItemProcessor;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(BatchConfiguration.class);

	@Value("${file.cuentasClientes}")
	private String fileInputCuentasCliente;
	@Value("${file.cuentasclienteslineas}")
	private String fileCuentasclienteslineas;
	@Value("${file.ticketcobros}")
	private String fileTicketcobros;

	@Bean
	public FlatFileItemReader<CuentasClientesOld> readerCuentasCliente() {
		LOGGER.info("*******INI readerCuentasCliente *******");
		FlatFileItemReader<CuentasClientesOld> reader = new FlatFileItemReaderBuilder<CuentasClientesOld>()
				.name("cuentasClientesOldItemReader")
				.resource(new ClassPathResource(fileInputCuentasCliente))
				.delimited()
				.names(new String[] { "lnk_idcliente", "direccion", "fecha" })
				.encoding("ISO_8859_1")
				.fieldSetMapper(new BeanWrapperFieldSetMapper<CuentasClientesOld>() {
					{
						this.setTargetType(CuentasClientesOld.class);
					}
				})
				.build();

		LOGGER.info("******* END reader *******");
		return reader;
	}

	@Bean
	public FlatFileItemReader<CuentasClientesLineasOld> readerCuentasClienteLineas() {
		LOGGER.info("*******INI readerCuentasClienteLineas *******");
		FlatFileItemReader<CuentasClientesLineasOld> reader = new FlatFileItemReaderBuilder<CuentasClientesLineasOld>()
				.name("cuentasClientesLineasOldItemReader")
				.resource(new ClassPathResource(fileCuentasclienteslineas))
				.delimited()
				.names(new String[] { "idCliente","fecha","idTipoCobros","importe","descripcion" })
				.encoding("ISO_8859_1")
				.fieldSetMapper(new BeanWrapperFieldSetMapper<CuentasClientesLineasOld>() {
					{
						this.setTargetType(CuentasClientesLineasOld.class);
					}
				})
				.build();

		LOGGER.info("******* END reader *******");
		return reader;
	}

	@Bean
	public FlatFileItemReader<TicketCobrosOld> readerTicketCobrosOld() {
		LOGGER.info("*******INI readerTicketCobrosOld *******");
		FlatFileItemReader<TicketCobrosOld> reader = new FlatFileItemReaderBuilder<TicketCobrosOld>()
				.name("TicketCobrosOldReader")
				.resource(new ClassPathResource(fileTicketcobros))
				.delimited()
				.names(new String[] { "idReserva","idTipoCobros","numTicket","importe","fecha","fechaPago","idTipoCobrosPago" })
				.encoding("ISO_8859_1")
				.fieldSetMapper(new BeanWrapperFieldSetMapper<TicketCobrosOld>() {
					{
						this.setTargetType(TicketCobrosOld.class);
					}
				})
				.build();

		LOGGER.info("******* END reader *******");
		return reader;
	}

	@Bean
	public CuentasClientesOldItemProcessor cuentasClientesItemProcessor() {
		return new CuentasClientesOldItemProcessor();
	}

	@Bean
	public CuentasClientesLineasOldItemProcessor cuentasClientesLineasOldItemProcessor() {
		return new CuentasClientesLineasOldItemProcessor();
	}

	@Bean
	public TicketCobrosOldItemProcessor ticketCobrosOldItemProcessor() {
		return new TicketCobrosOldItemProcessor();
	}


	@Bean
	public JdbcBatchItemWriter<CuentasClientesNew> writerCuentasCliente(DataSource dataSource) {
		LOGGER.info("*******INI JdbcBatchItemWriter *******");
		return new JdbcBatchItemWriterBuilder<CuentasClientesNew>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO CuentasClientesNew (idCliente) VALUES (:idCliente)")
				.dataSource(dataSource).build();
	}

	@Bean
	public JdbcBatchItemWriter<TicketCobrosNew> writerTicketCobros(DataSource dataSource) {
		LOGGER.info("*******INI JdbcBatchItemWriter *******");
		return new JdbcBatchItemWriterBuilder<TicketCobrosNew>()
				.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
				.sql("INSERT INTO TicketCobrosNew (idOcupacion) VALUES (:idOcupacion)")
				.dataSource(dataSource).build();
	}

	@Bean
	public Job importUserJob(JobRepository jobRepository, JobCompletionNotificationListener listener, Step stepCuentasCliente, Step stepCuentasClientesLineas, Step stepTicketCobros) {
		LOGGER.info("*******INI importUserJob *******");
		return new JobBuilder("importUserJob", jobRepository).incrementer(new RunIdIncrementer()).listener(listener)
				.start(stepCuentasCliente).next(stepCuentasClientesLineas).next(stepTicketCobros).build();
	}

	@Bean
	public Step stepCuentasCliente(JobRepository jobRepository, PlatformTransactionManager transactionManager,
			JdbcBatchItemWriter<CuentasClientesNew> writerCuentasCliente) {
		LOGGER.info("*******INI stepCuentasCliente *******");
		Step stepCuentasCliente =  new StepBuilder("stepCuentasCliente", jobRepository)
				.<CuentasClientesOld, CuentasClientesNew>chunk(10, transactionManager).reader(readerCuentasCliente())
				.processor(cuentasClientesItemProcessor())
				.writer(writerCuentasCliente)
				.faultTolerant()
				.skip(FlatFileParseException.class)
				.skipLimit(10)
				.build();
		return stepCuentasCliente;
	}
	@Bean
	public Step stepCuentasClientesLineas(JobRepository jobRepository, PlatformTransactionManager transactionManager,
								   JdbcBatchItemWriter<CuentasClientesNew> writerCuentasCliente) {
		LOGGER.info("*******INI stepCuentasClientesLineas *******");
		Step stepCuentasClientesLineas =  new StepBuilder("stepCuentasClientesLineas", jobRepository)
				.<CuentasClientesLineasOld, CuentasClientesNew>chunk(10, transactionManager).reader(readerCuentasClienteLineas())
				.processor(cuentasClientesLineasOldItemProcessor())
				.writer(writerCuentasCliente)
				.faultTolerant()
				.skip(FlatFileParseException.class)
				.skipLimit(10)
				.build();
		return stepCuentasClientesLineas;
	}
	@Bean
	public Step stepTicketCobros(JobRepository jobRepository, PlatformTransactionManager transactionManager,
										  JdbcBatchItemWriter<TicketCobrosNew> writerTicketCobros) {
		LOGGER.info("*******INI stepTicketCobros *******");
		Step stepTicketCobros =  new StepBuilder("stepTicketCobros", jobRepository)
				.<TicketCobrosOld, TicketCobrosNew>chunk(10, transactionManager).reader(readerTicketCobrosOld())
				.processor(ticketCobrosOldItemProcessor())
				.writer(writerTicketCobros)
				.faultTolerant()
				.skip(FlatFileParseException.class)
				.skipLimit(10)
				.build();
		return stepTicketCobros;
	}
}
