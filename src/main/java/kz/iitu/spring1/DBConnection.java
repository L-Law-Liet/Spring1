package kz.iitu.spring1;

import java.sql.*;

public class DBConnection {
    private String url = "jdbc:mysql://localhost:3306/spring_atm";
    private String username = "root";
    private String password = "root";
    public Connection conn;
//
//    private DBConnection() {}
//
//    public DBConnection getConn(){
//        if ()
//    }

    public void init(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void destroy() throws SQLException {
        conn.close();
    }
}
