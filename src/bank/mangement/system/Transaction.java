package bank.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {
    
    JButton deposit,fastcash,pinchange,cashWithdrwa,ministmt,balance,exit;
    JLabel label,text,card; 
    String pinpass;
   
    Transaction(String pinpass) {
        
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
        card=new JLabel(c3);
        card.setBounds(638,360,200,230);
        label.add(card);
        
        text = new JLabel("Please Select Your Transaction");
        text.setBounds(220, 270, 250, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        label.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(157, 367, 150, 30);
        deposit.setForeground(Color.black);
        deposit.setFont(new Font("Raleway" ,Font.BOLD,14));
        deposit.addActionListener(this);
        label.add(deposit);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(157, 402, 150, 30);
        fastcash.setForeground(Color.black);
        fastcash.setFont(new Font("Raleway" ,Font.BOLD,14));
        fastcash.addActionListener(this);
        label.add(fastcash);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(157, 437, 150, 30);
        pinchange.setForeground(Color.black);
        pinchange.setFont(new Font("Raleway" ,Font.BOLD,14));
        pinchange.addActionListener(this);
        label.add(pinchange);
        
        cashWithdrwa = new JButton("Cash Withdrawl");
        cashWithdrwa.setBounds(365, 365, 150, 30);
        cashWithdrwa.setForeground(Color.black);
        cashWithdrwa.setFont(new Font("Raleway" ,Font.BOLD,14));
        cashWithdrwa.addActionListener(this);
        label.add(cashWithdrwa);
        
        ministmt = new JButton("Mini Statement");
        ministmt.setBounds(365, 400, 150, 30);
        ministmt.setForeground(Color.black);
        ministmt.setFont(new Font("Raleway" ,Font.BOLD,14));
        ministmt.addActionListener(this);
        label.add(ministmt);
        
        balance = new JButton("Balance Enquiry");
        balance.setBounds(365, 435, 150, 30);
        balance.setForeground(Color.black);
        balance.setFont(new Font("Raleway" ,Font.BOLD,14));
        balance.addActionListener(this);
        label.add(balance);
        
        exit = new JButton("Exit");
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
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pinpass).setVisible(true);
        }else if(ae.getSource() == cashWithdrwa){
            setVisible(false);
            new Withdrawl(pinpass).setVisible(true);
        }else if(ae.getSource() == fastcash) {
            setVisible(false);
            new Fastcash(pinpass).setVisible(true);
        }else if(ae.getSource() == pinchange) {
            setVisible(false);
            new Pinchange(pinpass).setVisible(true);
        }else if(ae.getSource() == balance) {
            setVisible(false);
            new BalanceEnquiry(pinpass).setVisible(true);
        }else if(ae.getSource() == ministmt){
            new MiniStatement(pinpass).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Transaction("");
    }
}
