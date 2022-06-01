package res.mains;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
// import java.io.*;
// import java.awt.image.BufferedImage;
// import javax.imageio.ImageIO;

import lib.DesignUtils; // User Defined Package

public class Home extends JFrame {
    public static JFrame frame = new JFrame();
    JButton login = new JButton();
    JButton exit = new JButton();
    JButton about = new JButton();
    

    // JPanel imagePanel = new JPanel();
    ImageIcon image = new ImageIcon(getClass().getResource("backgroundNew.jpg"));
    JLabel labelpic = new JLabel("",image,JLabel.CENTER);
    
    public static DesignUtils designer = new DesignUtils(); // Static object which will be used in other classes too

    // FlowLayout fl = new FlowLayout(300, 10, 500);
    public Home() {
        
        frame.setTitle("Hager Home Automation Control");
        
        frame.setSize(1100, 600);
        frame.setAlwaysOnTop(false);
        frame.setEnabled(true);
        frame.setLocation(150, 50);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);
        designer.defBtnColor(about);
                designer.defBtnColor(login);
                designer.defBtnColor(exit);   
        

        // imagePanel.setBounds(900,100,250,250);
        // imagePanel.setEnabled(true);
        // imagePanel.setLayout(null);
        // imagePanel.setVisible(true);
        
        // landing();
        // Adding the components
        adder();
        imgAdder();
        // Hover Effect Adder
        loginConfig();
        
        // Applying the effects/configs
        exitConfig();

        // About Button
        aboutConfig();
        aboutHover();

        // Button Functionality
        exitAction(); // Exit button functionality
        loginAction(); // Login button functionality
    }
    // void landing(){
    //  try{
    //    BufferedImage img = ImageIO.read(new File("../../images/icons/v1/"));
    //    JLabel pic = new JLabel(new ImageIcon(img));
       
    //    imagePanel.add(pic);
    //  } 
    //  catch(IOException e){}
    // }

    void imgAdder(){

        labelpic.setBounds(0,0,600,800);
    }

    void loginConfig() {
        login.setBounds(740, 220, 200, 40); // Sets the position of the button on the frame
        login.setText("Login");
        login.setContentAreaFilled(true);
        login.setEnabled(true);
        login.setFocusPainted(true);
        login.setFocusable(true);

        // Button design
        designer.BtnFontDesigner(login);

    }

    void exitConfig() {
        exit.setBounds(740, 270, 200, 40); // Sets the position of the button on the frame
        exit.setText("Exit");
        exit.setContentAreaFilled(true);
        exit.setEnabled(true);
        exit.setFocusPainted(true);
        exit.setFocusable(true);
        // login.setSize(100 , 50);

        // Button design
        designer.BtnFontDesigner(exit);

    }

    void aboutConfig() {
        about.setBounds(740, 320, 200, 40);
        about.setText("About");
        // about.setText("About");
        about.setContentAreaFilled(true);
        about.setEnabled(true);
        about.setFocusPainted(true);
        about.setFocusable(true);
        // about.setToolTipText("Press to know about the software");

        designer.BtnFontDesigner(about);

    }


    void aboutHover() {
        about.addMouseListener(new MouseInputListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {
                new About();
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                // about.setBackground(Color.LIGHT_GRAY);
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                designer.defBtnColor(about);
                designer.defBtnColor(login);
                designer.defBtnColor(exit);    
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
                // about.setForeground(Color.BLUE);
            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
                about.setForeground(Color.BLACK);
            }

            @Override
            public void mouseDragged(MouseEvent arg0) {

            }

            @Override
            public void mouseMoved(MouseEvent arg0) {

            }

        });
    }


    void exitAction() { // The exit button actions defined here
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // System.exit(0); //Both of these code works
                // frame.dispose();
                int userAnswer;
                userAnswer = JOptionPane.showConfirmDialog(frame, "Are you sure ?");
                if (userAnswer == JOptionPane.YES_OPTION) {
                    System.out.println("Exiting the program......\nThanks for using the program");
                    System.exit(0); // Exits the program
                } else if (userAnswer == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(frame, "You opted for using this program more",
                            "Returning To Program....", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    // Do nothing :-)
                }
            }

        });
    }

    void loginAction() {
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getContentPane().removeAll(); // Removes everything from the current window/frame
                // frame.revalidate();
                frame.repaint(); // Updates the Frame windows live
                
                // Second Panel
                new Login();

                // Re adding the new contents to the main frame
                frame.validate();
            }
        });
    }

    void adder() {
        // frame.add(imagePanel);
        frame.add(labelpic);
        frame.add(login);
        frame.add(exit);
        frame.add(about);
    }
}