package bank.management.system;

import java.sql.*;

public class Conn {
    
    Connection c; 
    Statement s;
    
    public Conn(){
        try{
            // Class.forName(com.mysql.cj.jdbc.Driver);no need to write this line as we don't need to register the driver
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "P@55w0rd1");
            s = c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
