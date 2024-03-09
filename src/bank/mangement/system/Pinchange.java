package bank.mangement.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener {
    
    JLabel label,text,npin,repin;
    JTextField pintxt,repintxt;
    JButton change,exit;
    String pinpass;
    
    Pinchange(String pinpass){
    
        setLayout(null);
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
        
        text = new JLabel("Change Your PIN");
        text.setBounds(265, 255, 250, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        label.add(text);
        
        npin = new JLabel("New PIN:");
        npin.setBounds(235, 320, 100, 30);
        npin.setForeground(Color.WHITE);
        npin.setFont(new Font("Raleway",Font.BOLD,16));
        label.add(npin);
        
        pintxt = new JTextField();
        pintxt.setBounds(330, 320, 170, 25);
        pintxt.setFont(new Font("Raleway",Font.BOLD,16));
        label.add(pintxt);
        
        repin = new JLabel("Re-Enter New PIN:");
        repin.setBounds(165, 360, 150, 30);
        repin.setForeground(Color.WHITE);
        repin.setFont(new Font("Raleway",Font.BOLD,16));
        label.add(repin);
        
        repintxt = new JTextField("");
        repintxt.setBounds(330, 360, 170, 25);
        repintxt.setFont(new Font("Raleway",Font.BOLD,16));
        label.add(repintxt);
        
        change = new JButton("Change");
        change.setBounds(365, 435, 150, 30);
        change.setForeground(Color.black);
        change.setFont(new Font("Raleway" ,Font.BOLD,14));
        change.addActionListener(this);
        label.add(change);
        
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
        if(ae.getSource() == change){
        
            try {
                String npin  = pintxt.getText();
                String repin = repintxt.getText();

                if(!npin.equals(repin)){
                    JOptionPane.showMessageDialog(null, "Pin doesn't matched");
                    return;
                }
                
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter your PIN");
                    return;
                }
                
                if(repin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter your Renew PIN");
                    return;
                }
                
                Conn c = new Conn();
                String query1 = "update bank set pin = '"+repin+"' where pin = '"+pinpass+"'";
                String query2 = "update login set pin = '"+repin+"' where pin = '"+pinpass+"'";
                System.out.println(query2);
                String query3 = "update signupthree set pin = '"+repin+"' where pin = '"+pinpass+"'";
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                
                setVisible(false);
                new Transaction(repin).setVisible(true);

            }catch (Exception e) {
                System.out.println(e);
            }
        }else if(ae.getSource() == exit) {
            setVisible(false);
            new Transaction(pinpass).setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Pinchange("").setVisible(true);
    }
}
