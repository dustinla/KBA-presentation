package de.htwberlin.webservicekba.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Konfigurationdatei für Hiberante.
 * Mehr konfiguration passiert im Hintergrund durch Spring Boot.
 */
@Configuration
public class DBConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.hikari.maximum-pool-size}")
    private int maxPool;

    @Value("${spring.datasource.hikari.minimum-idle}")
    private int minPool;

    @Bean
    public DataSource dataSource() {
        if (dbUrl == null || dbUrl.isEmpty()) {
            return new HikariDataSource();
        } else {
            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(dbUrl);
            config.setMaximumPoolSize(maxPool);
            config.setMinimumIdle(minPool);
            return new HikariDataSource(config);
        }


    }
}
