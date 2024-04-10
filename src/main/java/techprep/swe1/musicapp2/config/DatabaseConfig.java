package techprep.swe1.musicapp2.config;

import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    private final Environment env;
    public DatabaseConfig(Environment env) {
        this.env = env;
    }
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public HikariDataSource hikariDataSource() {        //Creates DataSource object injection using HikariDataSource
        return DataSourceBuilder
                .create()                               //Creates DataSourceBuilder
                .type(HikariDataSource.class)
                .build();
    }

    @Bean
    public Flyway flyway(final DataSource dataSource) {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations(env.getProperty("spring.flyway.locations"))
                .table(env.getProperty("spring.flyway.table"))
                .load();

        System.out.println("Current version: " + flyway.info().current().getVersion());
        flyway.migrate();

        return flyway;
    }

    @Bean //Creates JdbcTemplate
    public JdbcTemplate jdbcTemplate(final DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}

