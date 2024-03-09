package bank.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {

    String formno;
    JLabel line,formNumberLabel, additionalDetail, accountType, card, cardno, digitcardno, appearon, pin, pinpass, yourpinpas,services;

    JRadioButton saving, fixdepo, curracc, recurrdepo;
    JButton submit, cancel, back;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;

    SignupThree(String formno) {

        this.formno = formno;
        setTitle("Signup Form 3");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(90, 90, 100);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(150, 8, 100, 100);
        add(label);

        formNumberLabel = new JLabel("Form Number: " + formno);
        formNumberLabel.setFont(new Font("Raleway", Font.BOLD, 15));
        formNumberLabel.setBounds(630, 20, 300, 30);
        add(formNumberLabel);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");

        additionalDetail = new JLabel("Page 3: Account Details");
        additionalDetail.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetail.setBounds(290, 60, 400, 30);
        add(additionalDetail);

        line = new JLabel();
        line.setBounds(50,100,1000,30);
        line.setFont(new Font("Raleway", Font.BOLD, 15));
        add(line);
        
        accountType = new JLabel("Account Type:");
        accountType.setFont(new Font("Raleway", Font.BOLD, 18));
        accountType.setBounds(100, 130, 200, 30);
        add(accountType);

        saving = new JRadioButton("Saving Account");
        saving.setBounds(110, 160, 200, 30);
        saving.setBackground(Color.white);
        saving.setFont(new Font("Raleway", Font.BOLD, 15));
        add(saving);

        fixdepo = new JRadioButton("Fixed Deposit Account");
        fixdepo.setBounds(340, 160, 270, 30);
        fixdepo.setBackground(Color.white);
        fixdepo.setFont(new Font("Raleway", Font.BOLD, 15));
        add(fixdepo);

        curracc = new JRadioButton("Current Account");
        curracc.setBounds(110, 190, 200, 30);
        curracc.setBackground(Color.white);
        curracc.setFont(new Font("Raleway", Font.BOLD, 15));
        add(curracc);

        recurrdepo = new JRadioButton("Recurring Deposit Account");
        recurrdepo.setBounds(340, 190, 280, 30);
        recurrdepo.setBackground(Color.white);
        recurrdepo.setFont(new Font("Raleway", Font.BOLD, 15));
        add(recurrdepo);

        ButtonGroup accountch = new ButtonGroup();
        accountch.add(saving);
        accountch.add(fixdepo);
        accountch.add(curracc);
        accountch.add(recurrdepo);

        card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 18));
        card.setBounds(100, 240, 200, 30);
        add(card);

        cardno = new JLabel("5040-XXXX-XXXX-XXXX");
        cardno.setFont(new Font("Raleway", Font.BOLD, 18));
        cardno.setBounds(320, 240, 300, 30);
        add(cardno);

        digitcardno = new JLabel("(Your 16-digit Card number)");
        digitcardno.setFont(new Font("Raleway", Font.BOLD, 12));
        digitcardno.setBounds(100, 265, 300, 30);
        add(digitcardno);

        appearon = new JLabel("It would be appear on ATM/Cheque Book and Statement");
        appearon.setFont(new Font("Raleway", Font.BOLD, 12));
        appearon.setBounds(320, 265, 350, 30);
        add(appearon);

        pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 18));
        pin.setBounds(100, 320, 50, 30);
        add(pin);

        pinpass = new JLabel("XXXX");
        pinpass.setFont(new Font("Raleway", Font.BOLD, 18));
        pinpass.setBounds(320, 320, 90, 30);
        add(pinpass);

        yourpinpas = new JLabel("(4-digit Password)");
        yourpinpas.setFont(new Font("Raleway", Font.BOLD, 12));
        yourpinpas.setBounds(100, 340, 120, 30);
        add(yourpinpas);
        
        services = new JLabel("Services Required:");
        services.setFont(new Font("Raleway", Font.BOLD, 18));
        services.setBounds(100, 390, 200, 30);
        add(services);
        
        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.white);
        c1.setBounds(100,430,200,30);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setBounds(330,430,200,30);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setBounds(100,480,200,30);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        add(c3);
        
        c4 = new JCheckBox("Email Alert");
        c4.setBackground(Color.white);
        c4.setBounds(330,480,200,30);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.white);
        c5.setBounds(100,530,200,30);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.white);
        c6.setBounds(330,530,200,30);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that the above-entered details are correct to the best of my knowledge.");
        c7.setBackground(Color.white);
        c7.setBounds(100,590,550,30);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 15));
        submit.setBounds(600, 640, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(260, 640, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.setBounds(170, 640, 80, 30);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.white);

        setSize(850, 740);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String accountTypeString = null;
            if (saving.isSelected()) {
                accountTypeString = "Saving Account";
            } else if (fixdepo.isSelected()) {
                accountTypeString = "Fixed Deposit Account";
            } else if (curracc.isSelected()) {
                accountTypeString = "Current Account";
            } else if (recurrdepo.isSelected()) {
                accountTypeString = "Recurring Deposit Account";
            }
            
            Random random = new Random();
            String cardno = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinpass = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String services = "";
            if (c1.isSelected()){
                services = services + " ATM Card";           
            }if (c2.isSelected()){
                services = services + " Internet Banking";
            }if (c3.isSelected()){
                services = services + " Mobile Banking";
            } if (c4.isSelected()){
                services = services + " Email Alert";
            }if (c5.isSelected()){
                services = services + " Cheque Book";
            }if (c6.isSelected()){
                services = services + " E-Statement";
            }
            
            try {
                if (accountTypeString.equals("")){
                    
                } else {
                    Conn c = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"','"+accountTypeString+"','"+cardno+"','"+pinpass+"','"+services+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardno+"','"+pinpass+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null , "Card Number: " + cardno + "\n Pin: " + pinpass);
                    
                    setVisible(false);
                    new Deposit(pinpass).setVisible(true);
                }
            } catch (Exception e){
              System.out.println(e);
            }
            
        }else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        } else if (ae.getSource() == back) {
            setVisible(false);
            new SignupTwo(formno).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new SignupThree("");
    }
}
