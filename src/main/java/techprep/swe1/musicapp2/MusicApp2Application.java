package techprep.swe1.musicapp2;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import techprep.swe1.musicapp2.config.FlywayMigrationCheck;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class MusicApp2Application {
    public static void main(String[] args) {
        SpringApplication.run(MusicApp2Application.class, args);
    }
}
