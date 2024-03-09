package bank.mangement.system;

import java.awt.*;
import javax.swing.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {
    
    JLabel mini,bank,card;
    
    MiniStatement(String pinpass){
        setTitle("Mini Statement");
        
        setLayout(null);
        
        mini = new JLabel();
        mini.setBounds(20,140,400,60);
        add(mini);
        
        bank = new JLabel("PNC Bank");
        bank.setBounds(150,20,100,20);
        bank.setFont(new Font("Osward", Font.BOLD,20));
        add(bank);
        
        card = new JLabel("Card No. :");
        card.setBounds(20, 80, 300, 20);
        card.setFont(new Font("Osward", Font.BOLD,20));
        add(card);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from login where pin = '"+pinpass+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" +rs.getString("cardnumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinpass+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");                                 
             }  
        }catch (Exception e){
            System.out.println(e);
        }
        
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.yellow);
        setVisible(true);
        
    }
    
    public static void main(String[] args){
        new MiniStatement("");
    }
}
