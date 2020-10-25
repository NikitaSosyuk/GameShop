package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public Connection getNewConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/NNGamingShopDB?useUnicode=true&serverTimezone=Europe/Moscow";
            String user = "root";
            String password = "rootpassword";
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("error with connection");
            throw new IllegalArgumentException(e);
        }
    }
}
