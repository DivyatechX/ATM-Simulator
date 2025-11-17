
package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    String pin;
    Withdrawl(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 960, 1080);
        add(l3);
        
        l1 = new JLabel("MAXIMUM WITHDRAWAL IS RS.10,000");
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));
        
        l2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        
        b1 = new JButton("WITHDRAW");
        b2 = new JButton("BACK");
        
        setLayout(null);
        
        l1.setBounds(190,350,400,20);
        l3.add(l1);
        
        l2.setBounds(190,400,400,20);
        l3.add(l2);
        
        t1.setBounds(190,450,330,30);
        l3.add(t1);
        
        b1.setBounds(390,588,150,35);
        l3.add(b1);
        
        b2.setBounds(390,633,150,35);
        l3.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setSize(960,1080);
        setLocation(500,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    
   
public void actionPerformed(ActionEvent ae) {
    System.out.println("Withdrawl.actionPerformed fired, source=" + ae.getSource() + ", pin=" + pin);

    try {
        if (ae.getSource() == b1) { // WITHDRAW
            
            String amountStr = (t1 != null) ? t1.getText() : null;
            System.out.println("Entered amount: " + amountStr);

            if (amountStr == null || amountStr.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the Amount you want to Withdraw");
                return;
            }

            int withdrawAmt;
            try {
                withdrawAmt = Integer.parseInt(amountStr.trim());
                if (withdrawAmt <= 0) {
                    JOptionPane.showMessageDialog(null, "Enter a positive amount");
                    return;
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Invalid amount. Use numbers only.");
                return;
            }

            // create connection
            Conn c1 = new Conn();
            if (c1 == null || c1.c == null) {
                JOptionPane.showMessageDialog(null, "Database connection failed.");
                System.out.println("Conn or conn.c is null");
                return;
            }

            Connection conn = c1.c;
            PreparedStatement pstSel = null;
            PreparedStatement pstIns = null;
            ResultSet rs = null;
            try {
                // safer: explicitly select columns and avoid wildcard
                String sqlSelect = "SELECT `mode`, amount FROM bank WHERE pin = ?";
                pstSel = conn.prepareStatement(sqlSelect);
                pstSel.setString(1, pin);
                rs = pstSel.executeQuery();

                int balance = 0;
                while (rs.next()) {
                    // getString may return null — use safe comparison
                    String mode = rs.getString("mode");
                    String amtStr = rs.getString("amount");
                    int rowAmt = 0;
                    if (amtStr != null && !amtStr.trim().isEmpty()) {
                        try {
                            rowAmt = Integer.parseInt(amtStr.trim());
                        } catch (NumberFormatException nfe) {
                            // if amount column is not numeric, skip or handle
                            System.out.println("Non-numeric amount value in DB: " + amtStr + " — skipping row");
                            continue;
                        }
                    }
                    // use safe equals to avoid NPE
                    if ("Deposit".equals(mode)) {
                        balance += rowAmt;
                    } else {
                        // treat any non-Deposit (including null) as withdrawal type
                        balance -= rowAmt;
                    }
                }

                System.out.println("Calculated balance = " + balance + ", requested withdraw = " + withdrawAmt);
                if (balance < withdrawAmt) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                // Insert withdrawal record. Use explicit columns so DB order doesn't matter.
                String sqlInsert = "INSERT INTO bank (pin, date_time, mode, amount) VALUES (?, ?, ?, ?)";
                pstIns = conn.prepareStatement(sqlInsert);
                pstIns.setString(1, pin);
                // store timestamp as string or timestamp — here we use java.sql.Timestamp
                java.sql.Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
                pstIns.setTimestamp(2, ts);   
                pstIns.setString(3,"Withdrawal");
                pstIns.setInt(4, withdrawAmt);   
                int rows = pstIns.executeUpdate();
                System.out.println("Inserted withdrawal rows = " + rows);
                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "Rs. " + withdrawAmt + " Debited Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Withdrawal failed (no rows inserted)");
                }

                // after successful withdraw, go back to transactions
                this.setVisible(false);
                new Transactions(pin).setVisible(true);

            } finally {
                try { if (rs != null) rs.close(); } catch (SQLException e) { /*ignore*/ }
                try { if (pstSel != null) pstSel.close(); } catch (SQLException e) { /*ignore*/ }
                try { if (pstIns != null) pstIns.close(); } catch (SQLException e) { /*ignore*/ }
                try { if (conn != null) conn.close(); } catch (SQLException e) { /*ignore*/ }
            }

        } else if (ae.getSource() == b2) { // BACK
            this.setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    } catch (SQLException sqle) {
        sqle.printStackTrace();
        JOptionPane.showMessageDialog(null, "Database error: " + sqle.getMessage());
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }

            
    }

    
    
    public static void main(String[] args){
        new Withdrawl("").setVisible(true);
    }
}
