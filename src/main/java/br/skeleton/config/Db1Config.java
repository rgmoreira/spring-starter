package br.skeleton.config;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Rafael Moreira <rafael.moreira@datainfo.inf.br>
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "emf1",
        transactionManagerRef = "tm1",
        basePackages = {"br.skeleton.db1.repository"}
)
public class Db1Config {

    @Primary
    @Bean(name = "datasource1")
    @ConfigurationProperties("spring.datasource.db1")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "emf1")
    public LocalContainerEntityManagerFactoryBean
            emf1(
                    EntityManagerFactoryBuilder builder,
                    @Qualifier("datasource1") DataSource dataSource
            ) {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        return builder
                .dataSource(dataSource)
                .packages("br.skeleton.db1.model")
                .persistenceUnit("db1")
                .properties(properties)
                .build();
    }

    @Primary
    @Bean(name = "tm1")
    public PlatformTransactionManager tm1(
            @Qualifier("emf1") EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
