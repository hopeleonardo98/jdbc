package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private static DataSource instance;
    private final String HOSTNAME = "localhost";
    private final int PORT = 3306;
    private final String DATABASE = "jdbc";
    private final String USERNAME = "root";
    private final String PASSWORD = "H240bo#3JBn4";
    private Connection connection;

    private DataSource() {
        try {
            String url = "jdbc:mysql:/"+HOSTNAME+":"+PORT+"/"+DATABASE;
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(url, USERNAME, PASSWORD);
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static DataSource getInstance() {
        return instance == null ? new DataSource() : instance;
    }

    public Connection startSession() {
        return this.connection;
    }

    public void closeSession() throws SQLException {
        connection.close();
    }
}
