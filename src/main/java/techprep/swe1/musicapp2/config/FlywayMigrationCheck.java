package techprep.swe1.musicapp2.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import techprep.swe1.musicapp2.MusicApp2Application;


public class FlywayMigrationCheck {
    private final Flyway checkMigrate;

    public FlywayMigrationCheck(Flyway checkMigrate) {
        this.checkMigrate = checkMigrate;
    }

    public void checkMigration() {
        System.out.println("Current version: " + checkMigrate.info().current().getVersion());
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MusicApp2Application.class, args);
        FlywayMigrationCheck flywayCheck = context.getBean(FlywayMigrationCheck.class);
        flywayCheck.checkMigration();
    }
}


