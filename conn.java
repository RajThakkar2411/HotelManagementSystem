package hotel.management.system;

import java.sql.*;

public class conn {

    Connection c;    // Connection is an interface present in sql package ,& we are declaring an object of it
    Statement  s;    // Statement is an interface present in sql package ,& we are declaring an object of it

    public conn(){

        try {

            Class.forName("com.mysql.cj.jdbc.Driver"); // Registering a driver
            c = DriverManager.getConnection("jdbc:mysql:///projecthms" , "root", "Raj@t2411"); // DriverManager is the class and getConnection is the method inside it. This line is for establishing connection between java and database.
            s = c.createStatement();
        } catch (Exception e){
           e.printStackTrace();
        }


    }
}

