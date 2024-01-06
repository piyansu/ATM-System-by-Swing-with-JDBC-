package BankSystemManagement;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class statement extends JFrame implements ActionListener {

    JButton b1;
    JLabel l1;
    String cardno;

    statement(String pin, String cardno) {
        super("Mini Statement");
        getContentPane().setBackground(Color.WHITE);
        setSize(360, 700);
        setLocation(530, 10);

        l1 = new JLabel();
        JScrollPane scrollPane = new JScrollPane(l1);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getViewport().setBackground(Color.WHITE);
        
        // Set the border color to white
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        add(scrollPane);

        JLabel l2 = new JLabel("<html><u>SBI Bank</u></html>");
        l2.setBounds(130, 20, 300, 50);
        l2.setFont(new Font("System", Font.BOLD, 20));
        add(l2);

        JLabel l3 = new JLabel();
        l3.setBounds(20, 80, 300, 20);
        l3.setFont(new Font("System", Font.BOLD, 17));
        add(l3);

        JLabel l4 = new JLabel();
        l4.setBounds(20, 400, 300, 20);
        add(l4);

        try {
            connection c = new connection();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pin+"'");
            while (rs.next()) {
                l3.setText("Card Number: " + rs.getString("cardno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            int balance = 0;
            connection c1 = new connection();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where cardno = '"+cardno+"'");
            while (rs.next()) {
                l1.setText(l1.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + rs.getString("amount") + "<br><br><html>");
                if (rs.getString("type").equals("     Deposit     ")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            l4.setText("Your total Balance is Rs " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(null);
        b1 = new JButton("Exit");
        add(b1);

        b1.addActionListener(this);

        scrollPane.setBounds(12, 140, 320, 200);
        b1.setBounds(20, 500, 100, 25);
    }

    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new statement("", "").setVisible(true);
    }
}
