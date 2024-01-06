package BankSystemManagement;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class withdrawal extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    String name ,pin, cardno;
    withdrawal(String pin ,String name , String cardno){
        this.name = name;
        this.pin = pin;
        this.cardno = cardno ;
        ImageIcon i1 = new ImageIcon(signup_three.class.getResource("/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 900, 700);
        add(l3);
        
        l1 = new JLabel("MINIIMUM WITHDRAWAL IS RS.100");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 17));
        
        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        
        b1 = new JButton("WITHDRAW");
        b2 = new JButton("BACK");
        
        setLayout(null);
        
        l1.setBounds(190,150,400,20);
        l3.add(l1);
        
        l2.setBounds(200,185,400,20);
        l3.add(l2);
        
        t1.setBounds(175,230,330,35);
        l3.add(t1);
        
        b1.setBounds(350,290,150,35);
        l3.add(b1);
        
        b2.setBounds(350,340,150,35);
        l3.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setSize(900,700);
        setLocation(230,10);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        try{        
            String amount = t1.getText();
            Date date = new Date();
            if(ae.getSource()==b1){
                if(t1.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    connection c1 = new connection();
                    
                    ResultSet rs = c1.s.executeQuery("select * from bank where cardno = '"+cardno+"'");
                    int balance = 0;
                    while(rs.next()){
                       if(rs.getString("type").equals("Deposit")){
                           balance += Integer.parseInt(rs.getString("amount"));
                       }else{
                           balance -= Integer.parseInt(rs.getString("amount"));
                       }
                    }
                    if(balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }
                    
                    c1.s.executeUpdate("insert into bank values('" + cardno + "','"+name+"' ,'"+date+"', 'Withdrawl', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                    setVisible(false);
                    new transaction(pin , name ,cardno).setVisible(true);
                }
            }else if(ae.getSource()==b2){
                setVisible(false);
                new transaction(pin , name ,cardno).setVisible(true);
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }

    
    
    public static void main(String[] args){
        new withdrawal("", "" , "").setVisible(true);
    }
}
