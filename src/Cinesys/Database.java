package Cinesys;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    public static Connection connect(){

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/cinesys", "root", "");
            //System.out.println("Success");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return con;

    }
}
