package main.java.spring.h2.dao.config;

import java.util.Properties;

import org.h2.Driver;
import org.h2.jdbcx.JdbcDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import main.java.spring.h2.dao.model.Book;

@Configuration
public class DBConfig {
	
	@Value("${datasource.dataSourceClassName}")
	String dataSourceClassName;
	@Value("${datasource.url}")
	String dataSourceUrl;
	@Value("${datasource.username}")
	String dataSourceUser;
	@Value("${datasource.password}")
	String dataSourcePassword;
	@Value("${datasource.databaseName}")
	String dataSrouceDatabaseName;
	@Value("${datasource.driverClassName}")
	String dataSourceDriverClassName;

	@Bean
	public HikariConfig getHikariConfig() {
		
		Properties props = new Properties();
//		props.setProperty("dataSourceClassName", dataSourceClassName);
//		props.setProperty("dataSource.url", dataSourceUrl);
//		props.setProperty("dataSource.user", dataSourceUser);
//		props.setProperty("dataSource.password", dataSourcePassword);	
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDataSourceClassName(dataSourceClassName);
//		hikariConfig.addDataSourceProperty("URL", "jdbc:h2:~/testdb;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false;MODE=MSSQLServer");
		hikariConfig.addDataSourceProperty("URL", dataSourceUrl);
		hikariConfig.setUsername(dataSourceUser);
		hikariConfig.setPassword(dataSourcePassword);
		return hikariConfig;
	}
	
	@Bean
	public HikariDataSource getHikariDataSource() {
		return new HikariDataSource(getHikariConfig());
	}
	
	@Bean
	public LocalSessionFactoryBean getH2SessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getHikariDataSource());
		Properties props = new Properties();
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "validate");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		sessionFactory.setHibernateProperties(props);
		sessionFactory.setAnnotatedClasses(Book.class);
		return sessionFactory;
	}
	
//	@Bean
	public SessionFactory getH2SessionFactoryObject() {
		return getH2SessionFactory().getObject();
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getH2SessionFactory().getObject());
		return transactionManager;
	}
}
