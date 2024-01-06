package BankSystemManagement;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.net.URL;
import java.sql.ResultSet;
import java.util.Arrays;

public class login extends JFrame implements ActionListener {

    JTextField cardfield;
    JPasswordField pinfield;
    JButton login, clear, signup;

    login() {
        setTitle("ATM Project by Piyansu");
        setLayout(null);

        URL iconURL = getClass().getResource("/icons/logo.png");
        ImageIcon i1 = new ImageIcon(iconURL);
        Image i2 = i1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 35, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to My ATM Project 💰");
        text.setFont(new Font("Osward", Font.BOLD, 33));
        text.setBounds(185, 62, 600, 40);
        add(text);

        JLabel cardno = new JLabel("Enter Card No.");
        cardno.setFont(new Font("Osward", Font.BOLD, 25));
        cardno.setBounds(130, 170, 600, 40);
        add(cardno);

        cardfield = new JTextField();
        cardfield.setFont(new Font("Osward", Font.PLAIN, 25));
        cardfield.setBounds(320, 175, 290, 35);
        add(cardfield);

        JLabel pin = new JLabel("Enter Pin No.");
        pin.setFont(new Font("Osward", Font.BOLD, 25));
        pin.setBounds(130, 240, 600, 40);
        add(pin);

        pinfield = new JPasswordField();
        pinfield.setFont(new Font("Osward", Font.BOLD, 25));
        pinfield.setBounds(320, 240, 290, 35);
        
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

        JButton login = new JButton("Login");
        login.setBounds(240, 325, 100, 45);
        login.setBackground(Color.BLACK);
        login.setFont(new Font("Osward", Font.BOLD, 20));
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        JButton clear = new JButton("Clear");
        clear.setBounds(420, 325, 100, 45);
        clear.setBackground(Color.BLACK);
        clear.setFont(new Font("Osward", Font.BOLD, 20));
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        JButton signup = new JButton("SignUp");
        signup.setBounds(240, 390, 280, 45);
        signup.setBackground(Color.BLACK);
        signup.setFont(new Font("Osward", Font.BOLD, 20));
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        JButton exit = new JButton("Exit");
        exit.setBounds(310, 450, 140, 45);
        exit.setBackground(Color.BLACK);
        exit.setFont(new Font("Osward", Font.BOLD, 20));
        exit.setForeground(Color.white);
        exit.addActionListener(this);
        add(exit);

        getContentPane().setBackground(Color.CYAN);

        setSize(775, 530);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
        setVisible(true);
        setLocation(350, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Login")) {
            String cardNo = cardfield.getText();
            char[] pinChars = pinfield.getPassword();
            String pinNo = new String(pinChars);
            
            connection c  = new connection();
            String query = "SELECT * FROM login WHERE cardno = '" + cardNo + "' AND pin = '" + pinNo + "'";
            try {
            	ResultSet rs = c.s.executeQuery(query) ; 
            	
            	if (rs.next()) {
                    String name = rs.getString("name");
                    String cardno = rs.getString("cardno");
                    String pinno = rs.getString("pin");
                    setVisible(false);
                    new transaction( pinno , name , cardno ).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            		
            	
            }catch(Exception e1) {
            	System.out.println(e1);
            }
            
            
            // Clear the pinChars array for security
            Arrays.fill(pinChars, '0');
        } else if (e.getActionCommand().equals("Clear")) {
            cardfield.setText("");
            pinfield.setText("");
        } else if (e.getActionCommand().equals("SignUp")) {
            signup_one signUpFrame = new signup_one();
            signUpFrame.setVisible(true);
            dispose();
        } else if (e.getActionCommand().equals("Exit")) {
            dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new login();
        });
    }
}
