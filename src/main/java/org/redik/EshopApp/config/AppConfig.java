package org.redik.EshopApp.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.CacheControl;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("org.redik.EshopApp")
@PropertySource("classpath:mysql.properties")

public class AppConfig implements WebMvcConfigurer {

	@Autowired
	private Environment env;

	private Logger logger = Logger.getLogger(getClass().getName());

	// Define DataSource Bean
	@Bean
	public DataSource dataSource() {

		// create connection pool
		ComboPooledDataSource myDataSource = new ComboPooledDataSource();

		// set jdbc driver
		try {
			myDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}

		// set jdbc props
		myDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		myDataSource.setUser(env.getProperty("jdbc.user"));
		myDataSource.setPassword(env.getProperty("jdbc.password"));
		logger.info("<<<<<<<< JDBC DRIVER : " + env.getProperty("jdbc.driver"));
		logger.info("<<<<<<<< JDBC URL : " + env.getProperty("jdbc.url"));
		// set pool props
		myDataSource.setInitialPoolSize(propIntoInteger("connection.pool.InitialPoolSize"));
		myDataSource.setMinPoolSize(propIntoInteger("connection.pool.MinPoolSize"));
		myDataSource.setMaxPoolSize(propIntoInteger("connection.pool.MaxPoolSize"));
		myDataSource.setMaxIdleTime(propIntoInteger("connection.pool.MaxIdleTime"));
		return myDataSource;
	}

	// Hibernate properties
	private Properties HibernateProperties() {
		Properties props = new Properties();
		props.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		return props;
	}

	@Bean
	// define SessionFactory
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(HibernateProperties());
		return sessionFactory;
	}

	// method to convert String property into Int
	public int propIntoInteger(String propName) {
		String propValue = env.getProperty(propName);
		int intProp = Integer.parseInt(propValue);
		return intProp;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {

		// setup transaction manager based on session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		// txManager.setSessionFactory(sessionFactory);
		txManager.setSessionFactory(sessionFactory().getObject());
		return txManager;
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		// Register resource handler for CSS and JS
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/")
				.setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	}

}
