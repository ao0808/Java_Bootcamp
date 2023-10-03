package ex02.Chat.src.main.java.edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class JdbcDataSource {
    private HikariDataSource dataSource;
    public JdbcDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/template1");
        config.setUsername("postgres");
        config.setPassword("postgres");
        dataSource = new HikariDataSource(config);
    }

    public HikariDataSource getDataSource() {
        return dataSource;
    }
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
