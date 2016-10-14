package by.bsu.fpm.barbuk.connector;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * Created by VVV on 20.07.2016.
 */
public class DBConnector {
    private static DBConnector datasource;
    private Connection connection;
    Logger logger = Logger.getLogger(DBConnector.class.getName());

    private DBConnector() throws IOException, SQLException, PropertyVetoException {
        Locale.setDefault(Locale.ENGLISH);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            logger.info(e.getMessage());
        }
        connection= DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE", "angelina",
                "angelina");
        System.out.println("Load JDBC");

    }

    public static DBConnector getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            datasource = new DBConnector();
            return datasource;
        } else {
            return datasource;
        }
    }

    public Connection getConnection() throws SQLException {
        return connection;
    }

}
