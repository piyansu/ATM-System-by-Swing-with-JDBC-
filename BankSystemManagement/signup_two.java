package BankSystemManagement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

public class signup_two extends JFrame implements ActionListener {

    JLabel additionaldetails, religion, category, income, education, qualification, occupation, panno, aadharno,
            existingaccount;
    JTextField panfield, aadharfield;
    JRadioButton exists, notexists;
    JButton next;
    JComboBox religiondrop, categorydrop, incomedrop, eaducationdrop, occupationdrop;
    String formno;
    String name;

    signup_two(String formno, String name) {
        this.formno = formno;
        this.name = name;

        setTitle("Create Account - Page 2");
        setLayout(null);

        additionaldetails = new JLabel("<html><u>Page 2 : Additional Details</u></html>");
        additionaldetails.setFont(new Font("Railway", Font.BOLD, 25));
        additionaldetails.setBounds(198, 40, 600, 50);
        add(additionaldetails);

        religion = new JLabel("Religion : ");
        religion.setFont(new Font("Railway", Font.BOLD, 20));
        religion.setBounds(90, 120, 600, 50);
        add(religion);

        String valReligion[] = { "", "Hindu", "Muslim", "Sikh", "Christian", "Other" };
        religiondrop = new JComboBox(valReligion);
        religiondrop.setBounds(260, 131, 300, 30);
        religiondrop.setBackground(Color.WHITE);
        add(religiondrop);

        category = new JLabel("Category : ");
        category.setFont(new Font("Railway", Font.BOLD, 20));
        category.setBounds(90, 160, 600, 50);
        add(category);

        String valcategory[] = { "", "Genaral", "OBC", "SC", "SC", "Other" };
        categorydrop = new JComboBox(valcategory);
        categorydrop.setBounds(260, 170, 300, 30);
        categorydrop.setBackground(Color.WHITE);
        add(categorydrop);

        income = new JLabel("Income : ");
        income.setFont(new Font("Railway", Font.BOLD, 20));
        income.setBounds(90, 200, 600, 50);
        add(income);

        String valincome[] = { "", "Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000" };
        incomedrop = new JComboBox(valincome);
        incomedrop.setBounds(260, 210, 300, 30);
        incomedrop.setBackground(Color.WHITE);
        add(incomedrop);

        education = new JLabel("Education");
        education.setFont(new Font("Railway", Font.BOLD, 20));
        education.setBounds(90, 250, 600, 50);
        add(education);

        qualification = new JLabel("Qualification : ");
        qualification.setFont(new Font("Railway", Font.BOLD, 20));
        qualification.setBounds(90, 280, 600, 50);
        add(qualification);

        String valeaducation[] = { "", "Non-Graduate", "Graduate", "Post-Graduate", "Doctorate", "Others" };
        eaducationdrop = new JComboBox(valeaducation);
        eaducationdrop.setBounds(260, 270, 300, 30);
        eaducationdrop.setBackground(Color.WHITE);
        add(eaducationdrop);

        occupation = new JLabel("Occupation : ");
        occupation.setFont(new Font("Railway", Font.BOLD, 20));
        occupation.setBounds(90, 320, 600, 50);
        add(occupation);

        String valoccupation[] = { "", "Salaried", "Self-Employed", "Bussiness", "Student", "Retired", "Others" };
        occupationdrop = new JComboBox(valoccupation);
        occupationdrop.setBounds(260, 330, 300, 30);
        occupationdrop.setBackground(Color.WHITE);
        add(occupationdrop);

        panno = new JLabel("Pan Number : ");
        panno.setFont(new Font("Railway", Font.BOLD, 20));
        panno.setBounds(90, 360, 600, 50);
        add(panno);

        panfield = new JTextField();
        panfield.setFont(new Font("Railway", Font.PLAIN, 15));
        panfield.setBounds(260, 375, 300, 30);
        
        ((AbstractDocument) panfield.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
                if (string.matches("\\d*")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                if (text.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        add(panfield);

        aadharno = new JLabel("Aadhar Number : ");
        aadharno.setFont(new Font("Railway", Font.BOLD, 20));
        aadharno.setBounds(90, 400, 600, 50);
        add(aadharno);

        aadharfield = new JTextField();
        aadharfield.setFont(new Font("Railway", Font.PLAIN, 15));
        aadharfield.setBounds(260, 412, 300, 30);
        
        ((AbstractDocument) aadharfield.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
                if (string.matches("\\d*")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                if (text.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
        add(aadharfield);

        existingaccount = new JLabel("Existing Account : ");
        existingaccount.setFont(new Font("Railway", Font.BOLD, 19));
        existingaccount.setBounds(89, 440, 600, 50);
        add(existingaccount);

        exists = new JRadioButton("Exists");
        exists.setFont(new Font("Railway", Font.BOLD, 18));
        exists.setBounds(280, 455, 100, 20);
        exists.setBackground(Color.CYAN);
        add(exists);

        notexists = new JRadioButton("Not-Exists");
        notexists.setFont(new Font("Railway", Font.BOLD, 18));
        notexists.setBounds(390, 455, 150, 20);
        notexists.setBackground(Color.CYAN);
        add(notexists);

        ButtonGroup maritalstatus = new ButtonGroup();
        maritalstatus.add(exists);
        maritalstatus.add(notexists);

        next = new JButton("Next");
        next.setBounds(255, 520, 150, 40);
        next.setBackground(Color.BLACK);
        next.setFont(new Font("Raleway", Font.BOLD, 20));
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.CYAN);

        setSize(700, 630);
        setLocation(350, 40);
        setUndecorated(true);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20)); // Adjust the values for the desired roundness
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Next")) {
            String sreligion = (String) religiondrop.getSelectedItem();
            String scategory = (String) categorydrop.getSelectedItem();
            String sincome = (String) incomedrop.getSelectedItem();
            String seaducation = (String) eaducationdrop.getSelectedItem();
            String soccupation = (String) occupationdrop.getSelectedItem();

            String spanno = panfield.getText();
            String saadharno = aadharfield.getText();

            String existingaccount = null;
            if (exists.isSelected())
                existingaccount = "Yes";
            else if (notexists.isSelected())
                existingaccount = "No";

            try {
                if (sreligion.equals("") || scategory.equals("") || sincome.equals("") || seaducation.equals("")
                        || soccupation.equals("") || spanno.equals("") || saadharno.equals("")
                        || existingaccount == null) {
                    JOptionPane.showMessageDialog(null, "All fields are required");
                } else {
                    connection c = new connection();
                    String query = "INSERT INTO signuptwo VALUES ('" + formno + "' , '" + sreligion + "' , '"
                            + scategory + "' , '" + sincome + "' , '" + seaducation + "', '" + soccupation + "', '"
                            + spanno + "' , '" + saadharno + "', '" + existingaccount + "')";
                    c.s.executeUpdate(query);

                    signup_three signUpFramethree = new signup_three(formno, name);
                    signUpFramethree.setVisible(true);
                    dispose();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new signup_two("", "");
    }
}
