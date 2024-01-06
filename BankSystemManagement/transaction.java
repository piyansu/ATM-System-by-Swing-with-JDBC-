package BankSystemManagement;

import java.awt.*;
import java.awt.event.*;
import java.beans.Statement;

import javax.swing.*;
import java.sql.*;

public class transaction extends JFrame implements ActionListener{

    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String name , cardno ,pin;
    transaction(String pin , String name , String cardno){
    	this.name = name;
    	this.pin = pin ;
    	this.cardno = cardno;
    	
    	ImageIcon i1 = new ImageIcon(signup_three.class.getResource("/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l2 = new JLabel(i3);
        l2.setBounds(0, 0, 900, 700);
        add(l2);
        
        l1 = new JLabel("Welcome "+name);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
       
        b1 = new JButton("DEPOSIT");
        b2 = new JButton("CASH WITHDRAWL");
        b3 = new JButton("FAST CASH");
        b4 = new JButton("MINI STATEMENT");
        b5 = new JButton("PIN CHANGE");
        b6 = new JButton("BALANCE ENQUIRY");
        b7 = new JButton("EXIT");
        
        setLayout(null);
        
        l1.setBounds(260,135,700,35);
        l2.add(l1);
        
        b1.setBounds(170,190,150,35);
        l2.add(b1);
        
        b2.setBounds(352,190,150,35);
        l2.add(b2);
        
        b3.setBounds(170,242,150,35);
        l2.add(b3);
        
        b4.setBounds(352,242,150,35);
        l2.add(b4);
        
        b5.setBounds(170,295,150,35);
        l2.add(b5);
        
        b6.setBounds(352,295,150,35);
        l2.add(b6);
        
        b7.setBounds(265,350,150,35);
        l2.add(b7);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        
        
        setSize(900,700);
        setLocation(230,10);
        setUndecorated(true);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){ 
            setVisible(false);
			new deposit(pin , name,cardno).setVisible(true);
        }else if(ae.getSource()==b2){ 
            setVisible(false);
            new withdrawal(pin , name,cardno).setVisible(true);
        }else if(ae.getSource()==b3){ 
            setVisible(false);
            new fastcash(pin ,name,cardno).setVisible(true);
        }else if(ae.getSource()==b4){ 
            new statement(pin , cardno).setVisible(true);
        }else if(ae.getSource()==b5){ 
            setVisible(false);
            new pin(pin , name,cardno).setVisible(true);
        }else if(ae.getSource()==b6){ 
            this.setVisible(false);
            new balance(pin , name,cardno).setVisible(true);
        }else if(ae.getSource()==b7){ 
            System.exit(0);
        }
    }
    
    public static void main(String[] args){
        new transaction("" , "" ,"").setVisible(true);
    }
}