package bank.mangement.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JLabel label,text;
    JButton exit;
    String pinpass;

    BalanceEnquiry(String pinpass) {
        
        this.pinpass = pinpass;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        label = new JLabel(i3);
        label.setBounds(0, 0, 900, 800);
        add(label);
        
        ImageIcon c1=new ImageIcon(ClassLoader.getSystemResource("icons/debitcard.png"));
        Image c2=c1.getImage().getScaledInstance(250,350,Image.SCALE_DEFAULT);
        ImageIcon c3=new ImageIcon(c2);
        JLabel card=new JLabel(c3);
        card.setBounds(638,360,200,230);
        label.add(card);
        
        exit = new JButton("Back");
        exit.setBounds(365, 435, 150, 30);
        exit.setForeground(Color.black);
        exit.setFont(new Font("Raleway" ,Font.BOLD,14));
        exit.addActionListener(this);
        label.add(exit);
        
        Conn c = new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinpass+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")) {
                    balance +=Integer.parseInt(rs.getString("amount"));
                } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
        }catch (Exception e){
           System.out.println(e);
        }
        
        text = new JLabel("Your Current Account Balance is RS: "+balance);
        text.setForeground(Color.white);
        text.setBounds(170, 300, 400, 30);
        text.setFont(new Font("Raleway", Font.BOLD, 15));
        label.add(text);

        setSize(900, 800);
        setLocation(350, 10);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit){
            setVisible(false);
            new Transaction(pinpass).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
