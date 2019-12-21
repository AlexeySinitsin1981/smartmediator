package stc21.smartmediator.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    private static final String POSTGRESQL_DRIVER = "org.postgresql.Driver";
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String nameOfDatabase = "postgres";
    private static final String password = "postgres";
    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(POSTGRESQL_DRIVER);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(nameOfDatabase);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }
}
