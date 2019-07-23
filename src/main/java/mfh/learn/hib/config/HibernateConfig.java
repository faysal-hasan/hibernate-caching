package mfh.learn.hib.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
@ComponentScan(value = "mfh.learn.hib.*")
public class HibernateConfig {

    @Autowired
    private Environment env;

    @Bean
    public DataSource getDataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl(env.getProperty("database.url"));
        dataSource.setUser(env.getProperty("database.username"));
        dataSource.setPassword(env.getProperty("database.password"));
        dataSource.setIdleConnectionTestPeriod(60 * 5);
        dataSource.setMinPoolSize(3);
        dataSource.setInitialPoolSize(3);
        dataSource.setAcquireIncrement(1);
        dataSource.setMaxPoolSize(10);
        try {
            Class.forName(env.getProperty("database.driverClass"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dataSource;

    }

    private Properties getProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        hibernateProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        hibernateProperties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
        hibernateProperties.put("hibernate.cache.use_second_level_cache", env.getProperty("hibernate.cache.use_second_level_cache"));
        hibernateProperties.put("hibernate.cache.use_query_cache", env.getProperty("hibernate.cache.use_query_cache"));
        hibernateProperties.put("hibernate.globally_quoted_identifiers", env.getProperty("hibernate.globally_quoted_identifiers"));
        hibernateProperties.put("hibernate.cache.region.factory_class", env.getProperty("hibernate.cache.region.factory_class"));
        hibernateProperties.put("hibernate.javax.cache.provider", env.getProperty("hibernate.javax.cache.provider"));
        return hibernateProperties;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(getDataSource());

        sessionFactoryBean.setHibernateProperties(getProperties());
//        sessionFactoryBean.setAnnotatedPackages("mfh.spring.api.mfh.learn.hib.model");
        sessionFactoryBean.setPackagesToScan(new String[]{"mfh.learn.hib.model"});
//        sessionFactoryBean.setAnnotatedClasses(Customer.class);
        return sessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
}