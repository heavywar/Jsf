package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Database {



    public static Connection getConnection() throws SQLException, NamingException {
        InitialContext initialContext = new InitialContext();
        DataSource dataSource = (DataSource) initialContext
                .lookup("bydb");
        Connection connection = dataSource.getConnection();

        return connection;
    }

}