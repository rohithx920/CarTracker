package Project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class JPAConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean emf(){
        LocalContainerEntityManagerFactoryBean emf=new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(getDatasource());
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf.setPackagesToScan("Project");
        Properties properties=new Properties();
        properties.put("hibernate.hbm2ddl.auto","update");
        properties.put("hibernate.show_sql", "true");
        //properties.put("hibernate.dialect", "org.hibernate.dialect.MYSQL57Dialect");
        emf.setJpaProperties(properties);

        return emf;
    }
    @Bean
    public DataSource getDatasource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/cartracker");
        ds.setUsername("root");
        ds.setPassword("");
        return ds;
    }
    @Bean
    public PlatformTransactionManager txManager(EntityManagerFactory emf){
        JpaTransactionManager txm=new JpaTransactionManager(emf);
        return txm;
    }
}
