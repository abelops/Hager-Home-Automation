package res.mains;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

import lib.DesignUtils;
import java.sql.*;
public class Login {
    JPanel loginPanel = new JPanel();
    JButton submit = new JButton();
    JLabel label1, label2, label3;
    JTextField field1, field2;
    JButton back = new JButton();
 
    Login() {
        Home.frame.add(loginPanel); // Adding the panel to the frame
        Color bodyColor = new Color(215, 232, 250);
        loginPanel.setLayout(null);
        loginPanel.setSize(1100, 600);
        loginPanel.setVisible(true);
        loginPanel.setLocation(400, 30);
        Home.frame.setBackground(bodyColor);

        // Username:
        usernameConfig();

        // Password:
        label2 = new JLabel("Password");
        field2 = new JPasswordField(15);
        label2.setBounds(10, 210, 200, 40);
        field2.setBounds(10, 243, 270, 35);
        Color Bord = new Color(214, 214, 214);
        Border border = BorderFactory.createLineBorder(Bord, 1);
        field2.setBorder(border);

        // Submit button:
        submit.setText("Submit");
        submit.setBounds(10, 295, 120, 40);
        Home.designer.BtnFontDesigner(submit);
        Home.designer.defBtnColor(submit);

        // Back Button
        back.setText("Home");
        back.setBounds(140, 295, 120, 40);
        Home.designer.BtnFontDesigner(back);
        Home.designer.defBtnColor(back);

        //Header 
        headerConfig();

        // Adding components:
        loginPanel.add(label1);
        loginPanel.add(field1);
        loginPanel.add(label2);
        loginPanel.add(field2);
        loginPanel.add(submit);
        loginPanel.add(back);
        loginPanel.add(label3);

        submitHover();
        backHover();
        // submitAction();
        submitEnterPressAction();

    }

    protected void usernameConfig() {
        label1 = new JLabel("Username");
        field1 = new JTextField(15);
        label1.setBounds(10, 140, 200, 40);
        field1.setBounds(10, 173, 270, 35);
        Color Bord = new Color(214, 214, 214);
        Border border = BorderFactory.createLineBorder(Bord, 1);
        field1.setBorder(border);
        // field1.setBorder(null);
    }

    void headerConfig() {
        Color mainColor = new Color(54, 75, 153);
        label3 = new JLabel("HHA User Login");
        label3.setBounds(20, 5, 350, 50);
        label3.setFont(new Font("montserrat", Font.BOLD, 35));
        label3.setForeground(mainColor);
    }

    void welcomeMsg() {
        JOptionPane.showMessageDialog(Home.frame, "You have successfully logged in", "Login Confirmation",
                JOptionPane.INFORMATION_MESSAGE);
    }

    void notAllowedMsg() {
        JOptionPane.showMessageDialog(Home.frame, "Incorrect login or password. Try again", "Error",
                JOptionPane.ERROR_MESSAGE);
    }

    void submitHover() {
        submit.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                authenticator();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                submit.setForeground(Color.RED);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                submit.setForeground(Color.BLACK);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                submit.setBackground(Color.GRAY);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Home.designer.defBtnColor(submit);

            }

        });
    }

    void authenticator() {
        JLabel errorMsg = new JLabel();
        errorMsg.setFont(new Font("Times New Roman", Font.PLAIN, 10));
        errorMsg.setBounds(100, 190, 250, 20);
        loginPanel.add(errorMsg);

        final String username, password;
        username = field1.getText().toString();
        password = field2.getText().toString();

         // Stored Password & username
        final ArrayList<String> registeredUsernames = new ArrayList<String>();
        registeredUsernames.add("Akinahom");
        registeredUsernames.add("Adnan");
        registeredUsernames.add("Selo");
        final ArrayList<String> registeredPasswords = new ArrayList<String>();
        registeredPasswords.add("1234");
        registeredPasswords.add("1234");
        registeredPasswords.add("1234"); 

        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            Statement creaStatement = conn.createStatement();
            creaStatement.executeUpdate("CREATE DATABASE IF NOT EXISTS hager");
            creaStatement.executeUpdate("USE hager");
            String allStat = "select * from user";
            PreparedStatement orgst = conn.prepareStatement(allStat);
            ResultSet orgsl2=orgst.executeQuery(allStat);
            boolean Stat = false; 
            while (orgsl2.next()) {
                String usrnm = orgsl2.getString("username");
                String passwd = orgsl2.getString("password");
                if (username.equals(usrnm) && password.equals(passwd)) {
                    welcomeMsg();
                    Stat = true;
                    Home.frame.getContentPane().removeAll();
                    Home.frame.repaint();
                    //Console log:
                    System.out.println("Authentication Successful\n\n");
                    new ContCent(); // creating the control center
                    Home.frame.validate();
                    break;
                } 
                else{
                    Stat = false;
                }
            }
            if(!Stat){
                JOptionPane.showMessageDialog(Home.frame, "Account not found ! Please recheck your Username and password");
            }
      
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       // if (username.equals(registeredUsernames.get(0)) &&
        // password.equals(registeredPasswords.get(0))) {
        // welcomeMsg();
        // }
        // else
        // {
        // notAllowedMsg();
        // }
    }

    void backHover() {
        back.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {
                loginPanel.setVisible(false);
                new Home();
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                back.setBackground(Color.GRAY);

            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                Home.designer.defBtnColor(back);

            }

            @Override
            public void mousePressed(MouseEvent arg0) {
                back.setForeground(Color.RED);

            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
                back.setForeground(Color.BLACK);

            }

        });
    }

    void submitEnterPressAction() {
        loginPanel.getRootPane().setDefaultButton(submit);
        submit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                authenticator();
            }

        });
    }

}