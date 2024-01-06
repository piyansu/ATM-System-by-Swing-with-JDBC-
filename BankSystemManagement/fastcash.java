package BankSystemManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class fastcash extends JFrame implements ActionListener {

    JLabel l1, l2;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;
    JTextField t1;
    String name , pin; String cardno ;
    
    fastcash(String pin , String name , String cardno) {
    	this.name = name;
    	this.pin = pin;
        this.cardno = cardno ;
        
        ImageIcon i1 = new ImageIcon(signup_three.class.getResource("/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 900, 700);
        add(l3);

        l1 = new JLabel("SELECT WITHDRAWL AMOUNT");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("Rs 100");
        b2 = new JButton("Rs 500");
        b3 = new JButton("Rs 1000");
        b4 = new JButton("Rs 2000");
        b5 = new JButton("Rs 5000");
        b6 = new JButton("Rs 10000");
        b7 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(210, 140, 700, 35);
        l3.add(l1);

        b1.setBounds(170, 190, 150, 35);
        l3.add(b1);

        b2.setBounds(350, 190, 150, 35);
        l3.add(b2);

        b3.setBounds(170, 240, 150, 35);
        l3.add(b3);

        b4.setBounds(350, 240, 150, 35);
        l3.add(b4);

        b5.setBounds(170, 290, 150, 35);
        l3.add(b5);

        b6.setBounds(350, 290, 150, 35);
        l3.add(b6);

        b7.setBounds(260, 340, 150, 35);
        l3.add(b7);

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = ((JButton)ae.getSource()).getText().substring(3); //k
            connection c = new connection();
            ResultSet rs = c.s.executeQuery("select * from bank where cardno = '"+cardno+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            } 
            
            if (balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == b7) {
                this.setVisible(false);
                new transaction(pin ,name ,cardno).setVisible(true);
            }else{
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('" + cardno +"','"+name+"' , '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                setVisible(false);
                new transaction(pin ,name ,cardno).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new fastcash("" , "" , "").setVisible(true);
    }
}
