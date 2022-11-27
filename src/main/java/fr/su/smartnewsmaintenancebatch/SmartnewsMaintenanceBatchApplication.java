package fr.su.smartnewsmaintenancebatch;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "fr.su.smartnewsmaintenancebatch", "fr.su.smartnewscommun", "fr.su.back" })
@EntityScan(basePackageClasses = { SmartnewsMaintenanceBatchApplication.class, Jsr310JpaConverters.class }, basePackages = { "fr.su.smartnewscommun" })
@EnableJpaRepositories(basePackages = { "fr.su.smartnewsmaintenancebatch", "fr.su.smartnewscommun" })
public class SmartnewsMaintenanceBatchApplication {
    private static final Logger LOGGER = LogManager.getLogger(SmartnewsMaintenanceBatchApplication.class);

    public static void main(String[] args) {
        try {
            LOGGER.info("Debut du batch");
            System.exit(SpringApplication.exit(SpringApplication.run(SmartnewsMaintenanceBatchApplication.class, args)));
        } catch (Exception e) {
            LOGGER.error("Impossible d'executer le batch", e);
            System.exit(-1);
        }
    }

    @Configuration
    @Profile("dev")
    @PropertySource("classpath:env.properties")
    static class DevProperty {
    }
}
