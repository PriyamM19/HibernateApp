package com.learning.HibernateApp.DAOConfig;

import java.util.Properties;


import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.learning.HibernateApp")
@EnableTransactionManagement

public class DB_Config
{

	@Autowired
	@Bean(name = "dataSource")
	public DataSource getDataSource()
	{
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName("org.h2.Driver");
		source.setUrl("jdbc:h2:tcp://localhost/~/test");
		source.setUsername("sa");
		source.setPassword("");
		
		System.out.println("dataSource : "+source);
		return source;
		
	}

	
	private Properties getHibernateProperties() 
	{
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.setProperty("show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		
		System.out.println("HibernateProperties : "+properties);
		return properties;
	}
	
	
	@Autowired
	@Bean(name = "sessionFactory")
	public LocalSessionFactoryBean getSessionfactory(DataSource dataSource)
	{
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setHibernateProperties(getHibernateProperties());
		factoryBean.setDataSource(dataSource);
		factoryBean.setPackagesToScan("com.learning.HibernateApp");
		
		System.out.println("factoryBean : " +factoryBean);
		return factoryBean;
	}
	



	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager Manager = new HibernateTransactionManager(sessionFactory);
		
		System.out.println("HibernateTransactionManager"+Manager);
		return Manager;
	}
	
	
}
