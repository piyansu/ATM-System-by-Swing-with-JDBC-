package BankSystemManagement;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;

class balance extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton b1, b2, b3;
    JLabel l1, l2, l3;
    String pin;
    String cardno ; String name ;

    balance(String pin , String name , String cardno) {
        this.pin = pin;
        this.cardno = cardno;
        this.name = name;

        ImageIcon i1 = new ImageIcon(signup_three.class.getResource("/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 900, 700);
        add(l3);

        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 19));
        
        l2 = new JLabel();
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 19));

        b1 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(190, 210, 400, 35);
        l3.add(l1);

        b1.setBounds(260, 300, 150, 35);
        l3.add(b1);
        
        connection c1 = new connection();
        int balance = 0;
        
        try{
        	
        	ResultSet rs = c1.s.executeQuery("select * from bank where cardno = '"+cardno+"'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch(Exception e){}
		l1.setText("Your Current Account Balance");
		
		l2.setText("Rs "+balance);
		l2.setBounds(300, 240, 400, 35);
        l3.add(l2);
        
        b1.addActionListener(this);

        setSize(900, 700);
        setLocation(230, 10);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new transaction( pin , name , cardno ).setVisible(true);
    }

    public static void main(String[] args) {
    	new balance( "" , "" , "").setVisible(true);
    }
}
