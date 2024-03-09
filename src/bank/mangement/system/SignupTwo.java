package bank.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JButton next, clear, back;
    JRadioButton yes, no, yess, noo;
    JComboBox<String> relComboBox, cateComboBox, incomComboBox, eduComboBox, occupationsComboBox;
    JTextField pannumber, aadharnumber;
    ButtonGroup citizen, account;
    String formno;
    JLabel formNumberLabel;

    SignupTwo(String formno) {
        
        this.formno = formno;
        setTitle("Signup Form 2");
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
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetail = new JLabel("Page 2: Additional Details");
        additionalDetail.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetail.setBounds(290, 60, 400, 30);
        add(additionalDetail);

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 120, 120, 30);
        add(religion);

        String[] religions = { "Select", "Hindu", "Islam", "Sikh", "Christian", "Other" };

        relComboBox = new JComboBox<>(religions);
        relComboBox.setBounds(310, 120, 380, 30);
        relComboBox.setFont(new Font("Raleway", Font.BOLD, 13));
        relComboBox.setBackground(Color.WHITE);
        add(relComboBox);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 170, 200, 30);
        add(category);

        String[] cate = { "Select", "General", "OBC", "SC", "ST", "General-EWS", "Other" };

        cateComboBox = new JComboBox<>(cate);
        cateComboBox.setBounds(310, 170, 380, 30);
        cateComboBox.setFont(new Font("Raleway", Font.BOLD, 13));
        cateComboBox.setBackground(Color.WHITE);
        add(cateComboBox);

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 220, 200, 30);
        add(income);

        String[] incom = { "Select", "Null", "<1,50,000", "<2,50,000", "<5,00,000", "Above 5,00,000" };

        incomComboBox = new JComboBox<>(incom);
        incomComboBox.setBounds(310, 220, 380, 30);
        incomComboBox.setFont(new Font("Raleway", Font.BOLD, 13));
        incomComboBox.setBackground(Color.WHITE);
        add(incomComboBox);

        JLabel edu = new JLabel("Educational");
        edu.setFont(new Font("Raleway", Font.BOLD, 20));
        edu.setBounds(100, 270, 250, 30);
        add(edu);
        
        JLabel quali = new JLabel("Qualification: ");
        quali.setFont(new Font("Raleway", Font.BOLD, 20));
        quali.setBounds(100, 290, 250, 30);
        add(quali);

        String[] qualifications = { "Select", "High School", "Intermediate", "Under Graduate", "Graduate", "Post Graduate", "Others" };

        eduComboBox = new JComboBox<>(qualifications);
        eduComboBox.setBounds(310, 280, 380, 30);
        eduComboBox.setFont(new Font("Raleway", Font.BOLD, 13));
        eduComboBox.setBackground(Color.WHITE);
        add(eduComboBox);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 330, 200, 30);
        add(occupation);

        String[] occupations = { "Select", "Engineer", "Teacher", "Doctor", "Student", "Farmer", "Other" };

        occupationsComboBox = new JComboBox<>(occupations);
        occupationsComboBox.setBounds(310, 330, 380, 30);
        occupationsComboBox.setFont(new Font("Raleway", Font.BOLD, 13));
        occupationsComboBox.setBackground(Color.WHITE);
        add(occupationsComboBox);

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 380, 200, 30);
        add(pan);

        pannumber = new JTextField();
        pannumber.setBounds(310, 380, 380, 30);
        pannumber.setFont(new Font("Raleway", Font.BOLD, 13));
        add(pannumber);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        aadhar.setBounds(100, 430, 200, 30);
        add(aadhar);

        aadharnumber = new JTextField();
        aadharnumber.setBounds(310, 430, 380, 30);
        aadharnumber.setFont(new Font("Raleway", Font.BOLD, 13));
        add(aadharnumber);

        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100, 470, 200, 30);
        add(senior);

        yes = new JRadioButton("Yes");
        yes.setBounds(320, 480, 50, 30);
        yes.setBackground(Color.white);
        yes.setFont(new Font("Raleway", Font.BOLD, 13));
        add(yes);

        no = new JRadioButton("No");
        no.setBounds(430, 480, 50, 30);
        no.setBackground(Color.white);
        no.setFont(new Font("Raleway", Font.BOLD, 13));
        add(no);

        citizen = new ButtonGroup();
        citizen.add(yes);
        citizen.add(no);

        JLabel existing = new JLabel("Existing Account:");
        existing.setFont(new Font("Raleway", Font.BOLD, 20));
        existing.setBounds(100, 530, 200, 30);
        add(existing);

        yess = new JRadioButton("Yes");
        yess.setBounds(320, 530, 50, 30);
        yess.setBackground(Color.white);
        yess.setFont(new Font("Raleway", Font.BOLD, 13));
        add(yess);

        noo = new JRadioButton("No");
        noo.setBounds(430, 530, 50, 30);
        noo.setBackground(Color.white);
        noo.setFont(new Font("Raleway", Font.BOLD, 13));
        add(noo);

        account = new ButtonGroup();
        account.add(yess);
        account.add(noo);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(610, 600, 80, 30);
        next.addActionListener(this);
        add(next);

        clear = new JButton("Clear");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setFont(new Font("Raleway", Font.BOLD, 14));
        clear.setBounds(410, 600, 80, 30);
        clear.addActionListener(this);
        add(clear);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Raleway", Font.BOLD, 14));
        back.setBounds(310, 600, 80, 30);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(Color.white);

        setSize(850, 720);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            relComboBox.setSelectedIndex(0);
            cateComboBox.setSelectedIndex(0);
            incomComboBox.setSelectedIndex(0);
            eduComboBox.setSelectedIndex(0);
            occupationsComboBox.setSelectedIndex(0);
            pannumber.setText("");
            aadharnumber.setText("");
            citizen.clearSelection();
            account.clearSelection();
        } else if (ae.getSource() == next) {
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        } else if (ae.getSource() == back) {
            setVisible(false);
            new SignupOne().setVisible(true);
        }

        String sreligion = (String) relComboBox.getSelectedItem();
        String scategory = (String) cateComboBox.getSelectedItem();
        String sincome = (String) incomComboBox.getSelectedItem();
        String squalifications = (String) eduComboBox.getSelectedItem();
        String soccupation = (String) occupationsComboBox.getSelectedItem();
        String seniorcitizen = null;
        if (yes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (no.isSelected()) {
            seniorcitizen = "No";
        }

        String existingaccount = null;
        if (yess.isSelected()) {
            existingaccount = "Yes";
        } else if (noo.isSelected()) {
            existingaccount = "No";
        }

        String spannumber = pannumber.getText();
        String saadharnumber = aadharnumber.getText();

        try {
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+squalifications+"','"+soccupation+"','"+spannumber+"','"+saadharnumber+"','"+ seniorcitizen+"','" +existingaccount+"')";
            c.s.executeUpdate(query);
            
            //SingupThree object
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new SignupTwo("");
    }
}
