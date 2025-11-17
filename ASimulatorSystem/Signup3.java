
package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JRadioButton r1,r2,r3,r4;
    JButton b1,b2;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    String formno;
    Signup3(String formno){
        this.formno = formno;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
    
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(150, 0, 100, 100);
        add(l14);
        
        l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        l2 = new JLabel("Account Type:");
        l2.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l3 = new JLabel("Card Number:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l4 = new JLabel("XXXX-XXXX-XXXX-4184");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l5 = new JLabel("(Your 16-digit Card number)");
        l5.setFont(new Font("Raleway", Font.BOLD, 12));
        
        l6 = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        l6.setFont(new Font("Raleway", Font.BOLD, 12));
        
        l7 = new JLabel("PIN:");
        l7.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l8 = new JLabel("XXXX");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
    
        l9 = new JLabel("(4-digit password)");
        l9.setFont(new Font("Raleway", Font.BOLD, 12));
    
        l10 = new JLabel("Services Required:");
        l10.setFont(new Font("Raleway", Font.BOLD, 18));
        
        l11 = new JLabel("Form No:");
        l11.setFont(new Font("Raleway", Font.BOLD, 14));
        
        l12 = new JLabel(formno);
        l12.setFont(new Font("Raleway", Font.BOLD, 14));
        
        b1 = new JButton("Submit");
        b1.setFont(new Font("Raleway", Font.BOLD, 14));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Cancel");
        b2.setFont(new Font("Raleway", Font.BOLD, 14));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        
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
        
      // create a container panel to hold everything (we'll keep absolute positioning)
JPanel contentPanel = new JPanel(null);
contentPanel.setBackground(Color.WHITE);

// move all add(...) calls to contentPanel instead of the frame
l11.setBounds(700,10,70,30);
contentPanel.add(l11);

l12.setBounds(770,10,40,30);
contentPanel.add(l12);

l1.setBounds(280,40,400,40);
contentPanel.add(l1); 

l2.setBounds(100,140,200,30);
contentPanel.add(l2);

r1.setBounds(100,180,150,30);
contentPanel.add(r1);

r2.setBounds(350,180,300,30);
contentPanel.add(r2);

r3.setBounds(100,220,250,30);
contentPanel.add(r3);

r4.setBounds(350,220,250,30);
contentPanel.add(r4);

l3.setBounds(100,300,200,30);
contentPanel.add(l3);

l4.setBounds(330,300,250,30);
contentPanel.add(l4);

l5.setBounds(100,330,200,20);
contentPanel.add(l5);

l6.setBounds(330,330,500,20);
contentPanel.add(l6);

l7.setBounds(100,370,200,30);
contentPanel.add(l7);

l8.setBounds(330,370,200,30);
contentPanel.add(l8);

l9.setBounds(100,400,200,20);
contentPanel.add(l9);

l10.setBounds(100,450,200,30);
contentPanel.add(l10);

c1.setBounds(100,500,200,30);
contentPanel.add(c1);

c2.setBounds(350,500,200,30);
contentPanel.add(c2);

c3.setBounds(100,550,200,30);
contentPanel.add(c3);

c4.setBounds(350,550,200,30);
contentPanel.add(c4);

c5.setBounds(100,600,200,30);
contentPanel.add(c5);

c6.setBounds(350,600,200,30);
contentPanel.add(c6);

c7.setBounds(100,680,600,20);
contentPanel.add(c7);

b1.setBounds(250,720,100,30);
contentPanel.add(b1);

b2.setBounds(420,720,100,30);
contentPanel.add(b2);

// set the content panel preferred size slightly bigger than the area needed
// (width same as window, height larger so scrollbars appear)
contentPanel.setPreferredSize(new Dimension(800, 900));

// put the content panel in a scroll pane
JScrollPane scrollPane = new JScrollPane(contentPanel,
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
        JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

// Option 1: add scrollPane directly to the frame's content pane and use no null layout on frame
getContentPane().setLayout(new BorderLayout());
getContentPane().add(scrollPane, BorderLayout.CENTER);

b1.addActionListener(this);
b2.addActionListener(this);

// window settings
setSize(850, 600);   // visible viewport size (taller content will scroll)
setLocation(500, 120);
setVisible(true);


        
    }
    
    @Override
public void actionPerformed(ActionEvent ae) {
    System.out.println("DEBUG: Signup3 submitting with formno='" + this.formno + "'");
System.out.println("DEBUG: account type selection -> r1=" + r1.isSelected() + ", r2=" + r2.isSelected()
    + ", r3=" + r3.isSelected() + ", r4=" + r4.isSelected());
System.out.println("DEBUG: facilities -> c1=" + c1.isSelected() + ", c2=" + c2.isSelected() + ", c3=" + c3.isSelected());

    System.out.println("Signup3.actionPerformed fired, source=" + ae.getSource() + ", formno=" + this.formno);

    if (ae.getSource() == b1) { // Submit
        String atype = null;
        if (r1.isSelected()) atype = "Saving Account";
        else if (r2.isSelected()) atype = "Fixed Deposit Account";
        else if (r3.isSelected()) atype = "Current Account";
        else if (r4.isSelected()) atype = "Recurring Deposit Account";

        StringBuilder facility = new StringBuilder();
        if (c1.isSelected()) facility.append("ATM Card ");
        if (c2.isSelected()) facility.append("Internet Banking ");
        if (c3.isSelected()) facility.append("Mobile Banking ");
        if (c4.isSelected()) facility.append("EMAIL Alerts ");
        if (c5.isSelected()) facility.append("Cheque Book ");
        if (c6.isSelected()) facility.append("E-Statement ");

        if (atype == null) {
            JOptionPane.showMessageDialog(this, "Please select an account type.");
            return;
        }

        // generate card and pin (you can keep your generator if desired)
        Random ran = new Random();
        long first7 = Math.abs(ran.nextLong()) % 9000000000000000L + 4000000000000000L;
        String cardno = String.valueOf(first7);
        long first3 = Math.abs(ran.nextLong()) % 9000L + 1000L;
        String pin = String.valueOf(first3);

        System.out.println("Attempting DB insert: formno=" + this.formno + " account=" + atype + " card=" + cardno + " pin=" + pin + " facilities=" + facility.toString().trim());

        Conn c = null;
        Connection conn = null;
        PreparedStatement pst1 = null;
        PreparedStatement pst2 = null;
        try {
            c = new Conn();
            conn = c.c;
            if (conn == null) {
                JOptionPane.showMessageDialog(this, "DB connection failed (conn is null). Check Conn.java and DB URL.");
                return;
            }

            String sql1 = "INSERT INTO signup3 (formno, account_type, card_no, pin, facilities) VALUES (?, ?, ?, ?, ?)";
            pst1 = conn.prepareStatement(sql1);
            pst1.setString(1, this.formno);
            pst1.setString(2, atype);
            pst1.setString(3, cardno);
            pst1.setString(4, pin);
            pst1.setString(5, facility.toString().trim());

            int inserted1 = pst1.executeUpdate();
            System.out.println("signup3 insert returned: " + inserted1);

            String sql2 = "INSERT INTO login (formno, cardno, pin) VALUES (?, ?, ?)";
            pst2 = conn.prepareStatement(sql2);
            pst2.setString(1, formno);
            pst2.setString(2, cardno);
            pst2.setString(3, pin);

            int inserted2 = pst2.executeUpdate();
            System.out.println("login insert returned: " + inserted2);

            if (inserted1 > 0 && inserted2 > 0) {
                JOptionPane.showMessageDialog(this, "Card Number: " + cardno + "\nPin: " + pin);
                // open deposit in EDT and catch its exceptions
                SwingUtilities.invokeLater(() -> {
                    try {
                        new Deposit(pin).setVisible(true);
                    } catch (Throwable t) {
                        t.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Failed to open Deposit screen: " + t.getMessage());
                    }
                });
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Insert failed. inserted1=" + inserted1 + " inserted2=" + inserted2);
            }
        } catch (SQLException sq) {
            sq.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + sq.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        } finally {
            try { if (pst1 != null) pst1.close(); } catch (SQLException e) {}
            try { if (pst2 != null) pst2.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }

    } else if (ae.getSource() == b2) { // Cancel
        // just close
        this.dispose();
    }
}

        
    
    
    public static void main(String[] args){
        new Signup3("").setVisible(true);
    }
    
}


