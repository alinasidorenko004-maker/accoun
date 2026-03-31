package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class DbConnection {

    private static String url;
    private static String login;
    private static String password;

    static {
        try {
            Properties props = new Properties();

            InputStream is = DbConnection.class
                    .getClassLoader()
                    .getResourceAsStream("config/config.properties");

            if (is == null) {
                throw new RuntimeException("config.properties not found");
            }

            props.load(is);

            String driver = props.getProperty("db.driver.class");
            url = props.getProperty("db.url");
            login = props.getProperty("db.login");
            password = props.getProperty("db.password");

            Class.forName(driver);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, login, password);
    }
}