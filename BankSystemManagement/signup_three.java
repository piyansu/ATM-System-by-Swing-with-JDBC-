package BankSystemManagement;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter.FilterBypass;

import java.sql.*;
import java.util.*;

public class signup_three extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,accountdetails;
    JRadioButton r1,r2,r3,r4;
    JButton b1;
    JTextField pinfield ;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    String formno;
    String name;
    String cardno;
    
    signup_three(String formno , String name){
        this.formno = formno;
        this.name = name;
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
    
        ImageIcon i1 = new ImageIcon(signup_three.class.getResource("/icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(180, 10, 100, 100);
        add(l14);

        
        accountdetails = new JLabel("<html><u>Page 3 : Account Details</u></html>");
        accountdetails.setFont(new Font("Railway", Font.BOLD, 25));
        accountdetails.setBounds(300, 40, 600, 30);
        add(accountdetails);
        
        l2 = new JLabel("Account Type:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l3 = new JLabel("Card Number:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        
        Random ran = new Random();
        long first7 = 10000 + ran.nextInt(90000);
        this.cardno = String.valueOf(first7);
        
        l4 = new JLabel(cardno);
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l5 = new JLabel("(Your 16-digit Card number)");
        l5.setFont(new Font("Raleway", Font.BOLD, 12));
        
        l6 = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        l6.setFont(new Font("Raleway", Font.BOLD, 12));
        
        l7 = new JLabel("PIN:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l8 = new JLabel("XXXX");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        
        pinfield = new JTextField();
        pinfield.setFont(new Font("Railway", Font.PLAIN, 15));
        pinfield.setBounds(330,343,200,30);
        
     // Apply the DocumentFilter to restrict input to 4 digits
        ((AbstractDocument) pinfield.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
                if (isDigit(string) && (fb.getDocument().getLength() + string.length()) <= 4) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                if (isDigit(text) && (fb.getDocument().getLength() + text.length() - length) <= 4) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            private boolean isDigit(String text) {
                return text.matches("\\d*");
            }
        });

        add(pinfield);
    
        l9 = new JLabel("(4-digit password)");
        l9.setFont(new Font("Raleway", Font.BOLD, 12));
    
        l10 = new JLabel("Services Required:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l11 = new JLabel("Form No:");
        l11.setFont(new Font("Raleway", Font.BOLD, 14));
        l11.setBounds(650,10,70,30);
        
        l12 = new JLabel(formno);
        l12.setFont(new Font("Raleway", Font.BOLD, 14));
        l12.setBounds(715,10,80,30);
        
        b1 = new JButton("Submit");
        b1.setFont(new Font("Raleway", Font.BOLD, 14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);        
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c4 = new JCheckBox("EMAIL Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        
        c7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.",true);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
         
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        
        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(r1);
        groupgender.add(r2);
        groupgender.add(r3);
        groupgender.add(r4);
        
        setLayout(null);
        
        
        add(l11);
        
        
        add(l12);
        
        l2.setBounds(100,140,200,30);
        add(l2);
        
        r1.setBounds(100,180,150,30);
        r1.setBackground(Color.CYAN);
        add(r1);
        
        r2.setBounds(350,180,300,30);
        r2.setBackground(Color.CYAN);
        add(r2);
        
        r3.setBounds(100,220,250,30);
        r3.setBackground(Color.CYAN);
        add(r3);
        
        r4.setBounds(350,220,250,30);
        r4.setBackground(Color.CYAN);
        add(r4);
        
        l3.setBounds(100,270,200,30);
        add(l3);
        
        l4.setBounds(330,270,250,30);
        add(l4);
        
        l5.setBounds(100,300,200,20);
        add(l5);
        
        l6.setBounds(330,300,500,20);
        add(l6);
        
        l7.setBounds(100,340,200,30);
        add(l7);
        
        l9.setBounds(100,370,200,20);
        add(l9);
        
        l10.setBounds(100,415,200,30);
        add(l10);
        
        c1.setBounds(100,460,200,30);
        c1.setBackground(Color.CYAN);
        add(c1);
        
        c2.setBounds(350,458,200,30);
        c2.setBackground(Color.CYAN);
        add(c2);
        
        c3.setBounds(100,510,200,30);
        c3.setBackground(Color.CYAN);
        add(c3);
        
        c4.setBounds(350,508,200,30);
        c4.setBackground(Color.CYAN);
        add(c4);
        
        c5.setBounds(100,560,200,30);
        c5.setBackground(Color.CYAN);
        add(c5);
        
        c6.setBounds(350,558,200,30);
        c6.setBackground(Color.CYAN);
        add(c6);
        
        c7.setBounds(140,610,600,20);
        c7.setBackground(Color.CYAN);
        add(c7);
        
        b1.setBounds(330,645,100,40);
        add(b1);
        
        
        getContentPane().setBackground(Color.CYAN);

        setSize(810, 700);
        setLocation(300, 12);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20)); // Adjust the values for the desired roundness
        setVisible(true);

        b1.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        String atype = null;
        if (r1.isSelected()) {
            atype = "Saving Account";
        } else if (r2.isSelected()) {
            atype = "Fixed Deposit Account";
        } else if (r3.isSelected()) {
            atype = "Current Account";
        } else if (r4.isSelected()) {
            atype = "Recurring Deposit Account";
        }
        
        String pin = pinfield.getText();

        String facility = "";
        if (c1.isSelected()) {
            facility = facility + " ATM Card";
        }
        if (c2.isSelected()) {
            facility = facility + " , Internet Banking";
        }
        if (c3.isSelected()) {
            facility = facility + " ,  Mobile Banking";
        }
        if (c4.isSelected()) {
            facility = facility + " , EMAIL Alerts";
        }
        if (c5.isSelected()) {
            facility = facility + " , Cheque Book";
        }
        if (c6.isSelected()) {
            facility = facility + " , E-Statement";
        }

        try {
            if (atype == null || facility.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            } else {
                connection c1 = new connection();
                String q1 = "INSERT INTO signupthree VALUES('" + formno + "','" + name + "' , '" + atype + "','" + cardno + "','" + pin + "','"
                        + facility + "')";
                String q2 = "INSERT INTO login VALUES('" + formno + "' , '" + name + "' , '" + cardno + "','" + pin + "')";
                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);
                JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:" + pin);

                // new Deposit(pin).setVisible(true);
                login signUp = new login();
                signUp.setVisible(true);
                dispose() ; 
                setVisible(false);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new signup_three("" , "").setVisible(true);
    }
    
}