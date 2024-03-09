package bank.mangement.system;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn() {
        try{
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Stranger@1");
            s = c.createStatement();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
