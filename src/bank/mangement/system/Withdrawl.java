package bank.mangement.system;

import java.util.Date;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener {
    
    JLabel label,swithdrawl;
    JButton withdrawl,back;
    JTextField amount;
    String pinpass;
    
    Withdrawl(String pinpass) {
        
        this.pinpass = pinpass; 
        
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
        
        swithdrawl = new JLabel("Enter the Amount you want to Withdraw");
        swithdrawl.setBounds(185, 250, 305, 35);
        swithdrawl.setForeground(Color.WHITE);
        swithdrawl.setFont(new Font("Raleway", Font.BOLD, 16));
        label.add(swithdrawl);
        
        amount = new JTextField();
        amount.setBounds(190, 300, 290, 30);
        amount.setForeground(Color.black);
        amount.setFont(new Font("Raleway", Font.BOLD, 18));
        label.add(amount);
        
        withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(365, 435, 150, 30);
        withdrawl.setForeground(Color.black);
        withdrawl.setFont(new Font("Raleway", Font.BOLD, 14));
        withdrawl.addActionListener(this);
        label.add(withdrawl);
        
        back = new JButton("Back");
        back.setBounds(365, 470, 150, 30);
        back.setForeground(Color.black);
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.addActionListener(this);
        label.add(back);
        
        setSize(900, 800);
        setLocation(350, 10);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdrawl){
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdraw");
            }else {
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinpass+"'");
                    int balance = 0;
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit")) {
                            balance +=Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if(balance < Integer.parseInt(number)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return ;
                    }
                    else{
                        String query = "insert into bank values('"+pinpass+"','"+date+"','Withdrawl','"+number+"')";
                        c.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Rs "+number+" Withdraw Successfully");
                    }
                    setVisible(false);
                    new Transaction(pinpass).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }else if (ae.getSource() == back){
            setVisible(false);
            new Transaction(pinpass).setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new Withdrawl(""); 
    }
}
