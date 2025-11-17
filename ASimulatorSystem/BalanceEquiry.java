package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

 class BalanceEnquiry extends JFrame implements ActionListener {

    JButton b1;
    JLabel l1;
    String pin;

    public BalanceEnquiry(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel bg = new JLabel(i3);
        bg.setBounds(0, 0, 960, 1080);
        add(bg);

        l1 = new JLabel();
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("System", Font.BOLD, 16));

        b1 = new JButton("BACK");

        setLayout(null);

        l1.setBounds(190, 350, 600, 35);
        bg.add(l1);

        b1.setBounds(390, 633, 150, 35);
        bg.add(b1);

        // add listener
        b1.addActionListener(this);

        // compute balance using SQL
        double balance = 0.0;
        System.out.println("DEBUG: BalanceEnquiry opened for pin = '" + pin + "'");

        Conn c = null;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            c = new Conn();
            conn = c.c;
            if (conn == null) {
                System.out.println("DEBUG: DB connection is null");
                JOptionPane.showMessageDialog(this, "Database connection failed.");
            } else {
                // Debug: show the DB/catalog so we confirm the DB the app uses
                try { System.out.println("DEBUG: JDBC URL = " + conn.getMetaData().getURL()); } catch(SQLException e){}

                String sql =
                    "SELECT COALESCE(SUM( " +
                    "  CASE " +
                    "    WHEN TRIM(mode) = 'Deposit' THEN CAST(TRIM(amount) AS DECIMAL(20,2)) " +
                    "    WHEN TRIM(mode) IN ('Withdrawl','Withdrawal') THEN -CAST(TRIM(amount) AS DECIMAL(20,2)) " +
                    "    ELSE 0 END " +
                    "), 0) AS bal " +
                    "FROM bank WHERE pin = ?";

                pst = conn.prepareStatement(sql);
                pst.setString(1, pin);
                rs = pst.executeQuery();
                if (rs.next()) {
                    balance = rs.getDouble("bal");
                }
                // debug: also print rows fetched for inspection (optional)
                rs.close();
                pst.close();

                // Optional: list raw rows to debug issues (uncomment if you need)
                /*
                PreparedStatement pst2 = conn.prepareStatement("SELECT pin, date, mode, amount FROM bank WHERE pin = ? ORDER BY date DESC");
                pst2.setString(1, pin);
                ResultSet rs2 = pst2.executeQuery();
                while (rs2.next()) {
                    System.out.println("ROW: pin=" + rs2.getString("pin") +
                                       " mode='" + rs2.getString("mode") + "'" +
                                       " amount='" + rs2.getString("amount") + "'");
                }
                rs2.close();
                pst2.close();
                */
            }
        } catch (SQLException sq) {
            sq.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + sq.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pst != null) pst.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }

        l1.setText("Your Current Account Balance is Rs " + String.format("%.2f", balance));

        setSize(960, 1080);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("7831").setVisible(true); // quick test pin
    }
}
