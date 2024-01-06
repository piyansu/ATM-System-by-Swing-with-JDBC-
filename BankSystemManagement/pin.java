package BankSystemManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class pin extends JFrame implements ActionListener {
    
    JPasswordField t1, t2;
    JButton b1, b2;                               
    JLabel l1, l2, l3;
    String pin, name, cardno;

    pin(String pin, String name, String cardno) {
        this.pin = pin;
        this.name = name;
        this.cardno = cardno;

        ImageIcon i1 = new ImageIcon(signup_three.class.getResource("/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        l4.setBounds(0, 0, 900, 700);
        add(l4);

        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 20));
        l1.setForeground(Color.WHITE);

        l2 = new JLabel("New PIN:");
        l2.setFont(new Font("System", Font.BOLD, 16));
        l2.setForeground(Color.WHITE);

        l3 = new JLabel("Re-Enter New PIN:");
        l3.setFont(new Font("System", Font.BOLD, 16));
        l3.setForeground(Color.WHITE);

        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));

        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));

        b1 = new JButton("CHANGE");
        b2 = new JButton("BACK");

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(null);

        l1.setBounds(245, 150, 800, 35);
        l4.add(l1);

        l2.setBounds(180, 200, 150, 35);
        l4.add(l2);

        l3.setBounds(180, 270, 200, 35);
        l4.add(l3);

        t1.setBounds(340, 205, 160, 25);
        l4.add(t1);

        t2.setBounds(340, 275, 160, 25);
        l4.add(t2);

        b1.setBounds(180, 340, 150, 35);
        l4.add(b1);

        b2.setBounds(350, 340, 150, 35);
        l4.add(b2);

        setSize(900, 700);
        setLocation(230, 10);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

 // Inside the actionPerformed method

    public void actionPerformed(ActionEvent ae) {
    	if(ae.getSource()==b1){
    		try {
                String npin = t1.getText();
                String rpin = t2.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                
                if (t1.getText().isEmpty() || t2.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Both PIN fields are required");
                    return;
                }
                
                connection c1 = new connection();
                String q2 = "update login set pin = '" + rpin + "' where pin = '" + pin + "'";
                String q3 = "update signupthree set pin = '" + rpin + "' where pin = '" + pin + "'";

                // Execute the update queries
                c1.s.executeUpdate(q2);
                c1.s.executeUpdate(q3);
                
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new transaction(pin ,name , cardno).setVisible(true);
                
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                    e.printStackTrace();
                }
    	}
		    else if (ae.getSource() == b2) {
		    	setVisible(false);
		    	new transaction(pin ,name , cardno).setVisible(true);
		    }

   }
    public static void main(String[] args) {
        new pin("", "", "").setVisible(true);
    }
}
