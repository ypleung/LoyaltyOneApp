package com.jcodeshare.webtemplate.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:application.properties" })
@ComponentScan({ "com.jcodeshare.webtemplate.data.service", "com.jcodeshare.webtemplate.data.dao" })
public class TestHibernateConfig {
    
    @Autowired
    private Environment env;
  
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
       LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
       sessionFactory.setDataSource(this.dataSource());
       sessionFactory.setPackagesToScan(new String[] { "com.jcodeshare.webtemplate.data.model", "com.jcodeshare.webtemplate.data.dao" });
       sessionFactory.setHibernateProperties(hibernateProperties());
  
       return sessionFactory;
    }
    
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
       dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
       dataSource.setUrl(env.getProperty("jdbc.url"));
       dataSource.setUsername(env.getProperty("jdbc.user"));
       dataSource.setPassword(env.getProperty("jdbc.pass"));
  
       return dataSource;
    }
  
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(sessionFactory);
       return txManager;
    }
  
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
       return new PersistenceExceptionTranslationPostProcessor();
    }
  
    Properties hibernateProperties() {
       return new Properties() {
          {
             setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
             setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
             setProperty("hibernate.globally_quoted_identifiers", "true");
          }
       };
    }  
    
}
