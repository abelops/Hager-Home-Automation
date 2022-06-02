package res.mains;

import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import java.awt.*;
import lib.DesignUtils;
import res.devices.*;
import java.sql.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ContCent {
    
    JFrame frame = new JFrame();
    JPanel contPanelWindow = new JPanel(null);
    JPanel headerpanel = new JPanel(null);
    public static JButton light = new JButton();
    JButton tempr = new JButton();
    JButton fan = new JButton();
    JButton door = new JButton();
    JLabel headerLabel = new JLabel();
    DesignUtils headerDesigner = new DesignUtils();
    JButton back = new JButton();
    Color mainColor = new Color(54, 75, 153);

        // *********TURN ON and OFF global variables
    public boolean lighton ;
    public double tempDisplay;
    public boolean FanOn;
    public boolean doorOpen;
    
    private static HttpURLConnection connection;
    
    

         // Button Icons 
         ImageIcon fanimg = new ImageIcon(getClass().getResource("power-on-off-8-240.png"));
         JLabel fanlabel = new JLabel("Fan",fanimg,JLabel.CENTER);
         
     
         ImageIcon Lightimg = new ImageIcon(getClass().getResource("light-bulb-15-240.png"));
         JLabel lightlabel = new JLabel("Light",Lightimg,JLabel.CENTER);

     
         ImageIcon tempimg = new ImageIcon(getClass().getResource("temp.png"));
         JLabel templabel = new JLabel("",tempimg,JLabel.CENTER);
         
     
         ImageIcon doorimg = new ImageIcon(getClass().getResource("door-3-240.png"));
         JLabel doorlabel = new JLabel("Door",doorimg,JLabel.CENTER);
    

    public ContCent() {
        try{
            //connect database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
            Statement creaStatement = conn.createStatement();
            creaStatement.executeUpdate("CREATE DATABASE IF NOT EXISTS hager");
            creaStatement.executeUpdate("USE hager");
            String allStat = "select * from functions";
            PreparedStatement orgst = conn.prepareStatement(allStat);
            ResultSet orgsl2=orgst.executeQuery(allStat);
            if(orgsl2.next()){
                
                String door =orgsl2.getString("frontdoor");
                String temperature =orgsl2.getString("temperature");
                String fan =orgsl2.getString("fan");
                String livingroomlight =orgsl2.getString("livingroomlight");
                System.out.println(door);
                if(Integer.parseInt(door)==1){
                    System.out.println(door);
                    doorOpen = true;     
                   }
                else{
                    doorOpen = false;
                    }

                if(Integer.parseInt(livingroomlight)==1){
                    lighton = true;
                   }
                else{
                    lighton = false;
                  }

                if(Integer.parseInt(fan)==1){
                    FanOn = true;
                  }
                else{
                    FanOn = false;
                  }
                if(Double.parseDouble(temperature) > 0){
                    tempDisplay = Double.parseDouble(temperature);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    
        Home.frame.add(contPanelWindow);
        Home.frame.add(headerpanel);

        // System.out.println(FanOn);
        // System.out.println(tempDisplay);
        // System.out.println(lighton);
        // System.out.println(doorOpen);

        contPanelWindow.setVisible(true);
        contPanelWindow.setBackground(Color.LIGHT_GRAY);
        contPanelWindow.setBounds(0, 200, 1100, 400);

        // Header creator
        headerDesigner.headerCreator("Hager Home Automation", headerLabel, headerpanel);
        
        // Button configs
             //Light 1
        light.setText("");
        light.setBounds(330, 10, 150, 130);
        if(lighton==false){
            light.setBackground(Color.WHITE);
        }
        else{
            light.setBackground(mainColor);
        }
        light.setBorder(null);
        lightlabel.setBounds(0,0,30,30);
        lightlabel.setVisible(true);
        light.add(lightlabel);

              //Temprature
        tempr.setText("      "+String.valueOf(tempDisplay));
        tempr.setFont(new Font("montserrat", Font.PLAIN, 28));
        tempr.setBounds(600, 10, 150, 130);
        
        if(tempDisplay >= 35){
            tempr.setBackground(Color.RED);
        }
        else if(tempDisplay >= 30){
            tempr.setBackground(Color.YELLOW);
        } 
        else{
            tempr.setBackground(Color.GREEN);
        }
        tempr.setBorder(null);
        templabel.setBounds(0,0,30,30);
        templabel.setVisible(true);
        tempr.add(templabel);

               //FAN
        fan.setText("");
        fan.setBounds(330, 150, 150, 130);
        if(FanOn==false){
            fan.setBackground(Color.WHITE);
        }
        else{
            fan.setBackground(mainColor);
        }
        fan.setBorder(null);
        fanlabel.setBounds(0,0,30,30);
        fanlabel.setVisible(true);
        fan.add(fanlabel);
                //DOOR
        door.setText("");
        door.setBounds(600, 150, 150, 130);
        if(doorOpen==false){
            door.setBackground(Color.WHITE);
        }
        else{
            door.setBackground(mainColor);
        }
        door.setBorder(null);
        doorlabel.setBounds(0,0,30,30);
        doorlabel.setVisible(true);
        door.add(doorlabel);


        back.setText("Go Back");
        back.setForeground(Color.white);
        back.setBounds(50, 300, 120, 50);
        Home.designer.defBtnColor(back);
        // Adding components
        contPanelWindow.add(light);
        contPanelWindow.add(tempr);
        contPanelWindow.add(fan);
        contPanelWindow.add(door);
        contPanelWindow.add(back);

        headerpanel.add(headerLabel);
        
        light.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // new Light();
              lighton = !lighton;
            if(lighton){
                try{
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", ""); 
                    Statement creaStatement = conn.createStatement();
                    creaStatement.executeUpdate("CREATE DATABASE IF NOT EXISTS hager");
                    creaStatement.executeUpdate("USE hager"); 
                    String Updated = "UPDATE functions SET fan=1";
                    creaStatement.execute(Updated);

                    light.setBackground(mainColor);
                  }catch(Exception f){
                    f.printStackTrace();
                  }
            } 
            else{
                try{
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", ""); 
                    Statement creaStatement = conn.createStatement();
                    creaStatement.executeUpdate("CREATE DATABASE IF NOT EXISTS hager");
                    creaStatement.executeUpdate("USE hager"); 
                    String Updated = "UPDATE functions SET fan=0";
                    creaStatement.execute(Updated);

                    light.setBackground(Color.WHITE);
                  }catch(Exception f){
                    f.printStackTrace();
                  }
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });

        // tempr.addMouseListener(new MouseListener() {
        //     @Override
        //     public void mouseClicked(MouseEvent e) {
               
        //     }

        //     @Override
        //     public void mousePressed(MouseEvent e) {

        //     }

        //     @Override
        //     public void mouseReleased(MouseEvent e) {

        //     }

        //     @Override
        //     public void mouseEntered(MouseEvent e) {

        //     }

        //     @Override
        //     public void mouseExited(MouseEvent e) {

        //     }

        // });

        fan.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                //new Fan();
                FanOn = !FanOn;
                if(FanOn){
                    try{
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", ""); 
                        Statement creaStatement = conn.createStatement();
                        creaStatement.executeUpdate("CREATE DATABASE IF NOT EXISTS hager");
                        creaStatement.executeUpdate("USE hager"); 
                        String Updated = "UPDATE functions SET livingroomlight=1";
                         creaStatement.execute(Updated);

                         fan.setBackground(mainColor);
                        }catch(Exception f){
                            f.printStackTrace();
                        }
                } else{
                    try{
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", ""); 
                        Statement creaStatement = conn.createStatement();
                        creaStatement.executeUpdate("CREATE DATABASE IF NOT EXISTS hager");
                        creaStatement.executeUpdate("USE hager"); 
                        String Updated = "UPDATE functions SET fan=0";
                         creaStatement.execute(Updated);

                         fan.setBackground(Color.WHITE);
                        }catch(Exception f){
                            f.printStackTrace();
                        }
                }
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {

            }

            @Override
            public void mouseExited(MouseEvent arg0) {

            }

            @Override
            public void mousePressed(MouseEvent arg0) {

            }

            @Override
            public void mouseReleased(MouseEvent arg0) {

            }

        });

        door.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                //new door();
                doorOpen = !doorOpen;
                if(doorOpen){
                    try{
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", ""); 
                        Statement creaStatement = conn.createStatement();
                        creaStatement.executeUpdate("CREATE DATABASE IF NOT EXISTS hager");
                        creaStatement.executeUpdate("USE hager"); 
                        String Updated = "UPDATE functions SET frontdoor=1";
                         creaStatement.execute(Updated);

                         door.setBackground(mainColor);
                        }catch(Exception f){
                            f.printStackTrace();
                        }
                } else{
                    try{
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", ""); 
                        Statement creaStatement = conn.createStatement();
                        creaStatement.executeUpdate("CREATE DATABASE IF NOT EXISTS hager");
                        creaStatement.executeUpdate("USE hager"); 
                        String Updated = "UPDATE functions SET frontdoor=0";
                         creaStatement.execute(Updated);

                         door.setBackground(Color.WHITE);
                        }catch(Exception f){
                            f.printStackTrace();
                        }
                    
                }
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {

            }

            @Override
            public void mouseExited(MouseEvent arg0) {

            }

            @Override
            public void mousePressed(MouseEvent arg0) {

            }

            @Override
            public void mouseReleased(MouseEvent arg0) {

            }
        });
        
        // contPanelWindow.addMouseListener(new MouseListener() {
        //     @Override
        //     public void mouseEntered(MouseEvent arg0) {
        //         try{
        //             //connect database
        //             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
        //             Statement creaStatement = conn.createStatement();
        //             creaStatement.executeUpdate("CREATE DATABASE IF NOT EXISTS hager");
        //             creaStatement.executeUpdate("USE hager");
        //             String allStat = "select * from functions";
        //             PreparedStatement orgst = conn.prepareStatement(allStat);
        //             ResultSet orgsl2=orgst.executeQuery(allStat);

        //             if(orgsl2.next()){
        //                 String temperature =orgsl2.getString("temperature");
        //                 if(Double.parseDouble(temperature) > 0){
        //                     tempDisplay = Double.parseDouble(temperature);
        //                 }
        //             }
        //         }
        //         catch(Exception e){
        //             e.printStackTrace();
        //         }
        //     }
        // });
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                Home.frame.getContentPane().removeAll();
                new Login();
                Home.frame.repaint();
            }

        });

    }
    

 }