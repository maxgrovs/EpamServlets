package by.epam.grovs.servlet.util;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    public static final String URL = "db.url";
    public static final String USER = "db.user";
    public static final String PASSWORD = "db.password";

    static {
        initDriver();
    }


    private static void initDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection get() throws SQLException {

        return DriverManager.getConnection(
                PropertiesHelper.get(URL),
                PropertiesHelper.get(USER),
                PropertiesHelper.get(PASSWORD)
        );


}

}
