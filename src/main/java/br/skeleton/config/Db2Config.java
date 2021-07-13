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
        entityManagerFactoryRef = "emf2",
        transactionManagerRef = "tm2",
        basePackages = {"br.skeleton.db2.repository"}
)
public class Db2Config {

    @Bean(name = "datasource2")
    @ConfigurationProperties("spring.datasource.db2")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "emf2")
    public LocalContainerEntityManagerFactoryBean
            emf2(
                    EntityManagerFactoryBuilder builder,
                    @Qualifier("datasource2") DataSource dataSource
            ) {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        return builder
                .dataSource(dataSource)
                .packages("br.skeleton.db2.model")
                .persistenceUnit("db2")
                .properties(properties)
                .build();
    }

    @Bean(name = "tm2")
    public PlatformTransactionManager tm2(
            @Qualifier("emf2") EntityManagerFactory entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
