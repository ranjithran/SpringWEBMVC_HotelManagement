package com.cap.hotelMangement.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfig {
	private final String ENITYPACKAGEPATH = "com.cap.hotelMangement.Model";

	@Value("${database.username}")
	private String username;
	@Value("${database.password}")
	private String password;
	@Value("${database.url}")
	private String url;
	@Value("${database.drivername}")
	private String drivername;

	@Bean
	public DriverManagerDataSource getDriverManger() {
		DriverManagerDataSource dm = new DriverManagerDataSource();
		dm.setDriverClassName(drivername);
		dm.setUrl(url);
		dm.setUsername(username);
		dm.setPassword(password);
		return dm;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(getDriverManger());
		localSessionFactoryBean.setPackagesToScan(ENITYPACKAGEPATH);
		localSessionFactoryBean.setHibernateProperties(hibernateProperties());
		return localSessionFactoryBean;
	}

	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}

	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update ");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		hibernateProperties.setProperty("hibernate.show_sql", "true");
		hibernateProperties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
		return hibernateProperties;
	}
}
