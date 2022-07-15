package sample.DBConnector;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConector {
    Connection connection ;

    public Connection getConnectionDB(){
        String username = "root";
        String passord = "";
        String dbname  = "user";
        String url = "jdbc:mysql://169.254.225.114/phpmyadmin/" + dbname;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager. getConnection(url,username,passord);
            System.out.print("connected");
        } catch (Exception e) {
            System.out.print("not connected");
            System.out.print(e);
        }
        return connection;

    }
}
