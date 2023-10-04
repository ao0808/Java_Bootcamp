package ex02.Test.src.test.java.edu.school21.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import javax.sql.DataSource;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;

public class EmbeddedDataSourceTest {
    private DataSource dataSource;

    @BeforeEach
    public void init() {
        dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).
                addScript("/ex02/Tests/src/test/resources/schema.sql").
                addScript("/ex02/Tests/src/test/resources/data.sql").build();
    }

    @Test
    public void getConnection() throws SQLException {
        assertNotNull(dataSource.getConnection());
    }
}
