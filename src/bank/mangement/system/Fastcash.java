package bank.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;

public class Fastcash extends JFrame implements ActionListener {
    
    JButton p1,p2,p3,p4,p5,p6,exit;
    JLabel label,text;
    String pinpass;
   
    Fastcash(String pinpass) {
        
        this.pinpass = pinpass;
        
        getContentPane().setBackground(Color.white);
        setTitle("Welcome to ATM");
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        label=new JLabel(i3);
        label.setBounds(0,0,900,800);
        add (label);
        
        ImageIcon c1=new ImageIcon(ClassLoader.getSystemResource("icons/debitcard.png"));
        Image c2=c1.getImage().getScaledInstance(250,350,Image.SCALE_DEFAULT);
        ImageIcon c3=new ImageIcon(c2);
        JLabel card=new JLabel(c3);
        card.setBounds(638,360,200,230);
        label.add(card);
        
        text = new JLabel("Please Select Your FastCash");
        text.setBounds(225, 270, 250, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        label.add(text);
        
        p1 = new JButton("Rs 500");
        p1.setBounds(157, 367, 150, 30);
        p1.setForeground(Color.black);
        p1.setFont(new Font("Raleway" ,Font.BOLD,14));
        p1.addActionListener(this);
        label.add(p1);
        
        p2 = new JButton("Rs 1000");
        p2.setBounds(157, 402, 150, 30);
        p2.setForeground(Color.black);
        p2.setFont(new Font("Raleway" ,Font.BOLD,14));
        p2.addActionListener(this);
        label.add(p2);
        
        p3 = new JButton("Rs 1500");
        p3.setBounds(157, 437, 150, 30);
        p3.setForeground(Color.black);
        p3.setFont(new Font("Raleway" ,Font.BOLD,14));
        p3.addActionListener(this);
        label.add(p3);
        
        p4 = new JButton("Rs 2000");
        p4.setBounds(365, 367, 150, 30);
        p4.setForeground(Color.black);
        p4.setFont(new Font("Raleway" ,Font.BOLD,14));
        p4.addActionListener(this);
        label.add(p4);
        
        p5 = new JButton("Rs 2500");
        p5.setBounds(365, 402, 150, 30);
        p5.setForeground(Color.black);
        p5.setFont(new Font("Raleway" ,Font.BOLD,14));
        p5.addActionListener(this);
        label.add(p5);
        
        p6 = new JButton("Rs 3000");
        p6.setBounds(365, 437, 150, 30);
        p6.setForeground(Color.black);
        p6.setFont(new Font("Raleway" ,Font.BOLD,14));
        p6.addActionListener(this);
        label.add(p6);
        
        
        exit = new JButton("Back");
        exit.setBounds(365, 470, 150, 30);
        exit.setForeground(Color.black);
        exit.setFont(new Font("Raleway" ,Font.BOLD,14));
        exit.addActionListener(this);
        label.add(exit);
        
        setSize(900, 800);
        setLocation(350, 10);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit){
            setVisible(false);
            new Transaction(pinpass).setVisible(true);
        }else {
            String amount;
            if(ae.getSource() == p1){
                amount = p1.getText().substring(3,6);
            }else if(ae.getSource() == p2){
                amount = p2.getText().substring(3,7);
            }else if(ae.getSource() == p3){
                amount = p3.getText().substring(3,7);
            }else if(ae.getSource() == p4){
                amount = p4.getText().substring(3,7);
            }else if(ae.getSource() == p5){
                amount = p5.getText().substring(3,7);
            }else{
                amount = p6.getText().substring(3,7);
            }
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinpass+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")) {
                        balance +=Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return ;
            }
                
                Date date = new Date();
                String query = "insert into bank values ('"+pinpass+"', '"+date+"', 'FastCash', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amount+".00 Withdraw Successfully");
                
                setVisible(false);
                new Transaction(pinpass).setVisible(true);
                
            }catch (Exception e){
                System.out.println(e);
            }
        }
         
    }
    
    public static void main(String args[]){
        new Fastcash("");
    }
}
