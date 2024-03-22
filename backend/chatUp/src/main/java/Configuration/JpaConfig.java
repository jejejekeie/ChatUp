package Configuration;

import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
@ComponentScan(basePackages = "com.example.chatup")
@Configuration
public class JpaConfig {

     final JpaProperties jpaProperties;

    public JpaConfig(JpaProperties jpaProperties) {
        this.jpaProperties = jpaProperties;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.chatup")
                .persistenceUnit("default")
                .properties(jpaProperties.getProperties())
                .build();
    }
}
