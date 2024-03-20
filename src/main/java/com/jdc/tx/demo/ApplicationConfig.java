package com.jdc.tx.demo;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.jdc.tx.demo.model" })
@EnableTransactionManagement
public class ApplicationConfig {

	@Bean
	public DataSource getDataSource() {
		var dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:mysql://localhost:3306/transfer_db");
		dataSource.setUsername("transfer");
		dataSource.setPassword("transfer");
		return dataSource;
	}

	@Bean
	public TransactionManager getTransactionManager(DataSource source) {
		return new DataSourceTransactionManager(source);
	}
}
