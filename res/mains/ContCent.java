package res.mains;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import lib.DesignUtils;
import res.devices.*;

public class ContCent {
    JFrame frame = new JFrame();
    JPanel contPanelWindow = new JPanel(null);
    JPanel headerpanel = new JPanel(null);
    public static JButton light = new JButton();
    JButton light2 = new JButton();
    JButton fan = new JButton();
    JButton door = new JButton();
    JLabel headerLabel = new JLabel();
    DesignUtils headerDesigner = new DesignUtils();
    JButton back = new JButton();
     
       // *********TURN ON and OFF global variables
    public boolean lighton = false;
    public boolean light2on = false;
    public boolean FanOn = false;
    public boolean doorOpen = false;

         // Button Icons 
         ImageIcon fanimg = new ImageIcon(getClass().getResource("power-on-off-8-240.png"));
         JLabel fanlabel = new JLabel("Fan",fanimg,JLabel.CENTER);
         
     
         ImageIcon Lightimg = new ImageIcon(getClass().getResource("light-bulb-15-240.png"));
         JLabel lightlabel = new JLabel("Light 1",Lightimg,JLabel.CENTER);

     
         ImageIcon Lightimg2 = new ImageIcon(getClass().getResource("light-bulb-15-240.png"));
         JLabel lightlabel2 = new JLabel("Light 2",Lightimg2,JLabel.CENTER);
         
     
         ImageIcon doorimg = new ImageIcon(getClass().getResource("door-3-240.png"));
         JLabel doorlabel = new JLabel("Door",doorimg,JLabel.CENTER);
    

    public ContCent() {
        Home.frame.add(contPanelWindow);
        Home.frame.add(headerpanel);

        

        contPanelWindow.setVisible(true);
        contPanelWindow.setBackground(Color.LIGHT_GRAY);
        contPanelWindow.setBounds(0, 200, 1100, 400);

        // Header creator
        headerDesigner.headerCreator("Hager Home Automation", headerLabel, headerpanel);
        
        // Button configs
        light.setText("");
        light.setBounds(330, 10, 150, 130);
        light.setBackground(Color.WHITE);
        lightlabel.setBounds(0,0,30,30);
        lightlabel.setVisible(true);
        light.add(lightlabel);

        light2.setText("");
        light2.setBounds(600, 10, 150, 130);
        light2.setBackground(Color.WHITE);
        lightlabel2.setBounds(0,0,30,30);
        lightlabel2.setVisible(true);
        light2.add(lightlabel2);

        fan.setText("");
        fan.setBounds(330, 150, 150, 130);
        fan.setBackground(Color.WHITE);
        fanlabel.setBounds(0,0,30,30);
        fanlabel.setVisible(true);
        fan.add(fanlabel);

        door.setText("");
        door.setBounds(600, 150, 150, 130);
        door.setBackground(Color.WHITE);
        doorlabel.setBounds(0,0,30,30);
        doorlabel.setVisible(true);
        door.add(doorlabel);


        back.setText("Go Back");
        back.setBounds(50, 300, 120, 50);

        // Adding components
        contPanelWindow.add(light);
        contPanelWindow.add(light2);
        contPanelWindow.add(fan);
        contPanelWindow.add(door);
        contPanelWindow.add(back);

        headerpanel.add(headerLabel);
        Color mainColor = new Color(54, 75, 153);
        light.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // new Light();
                   lighton = !lighton;
                if(lighton){
                light.setBackground(mainColor);

                } else{
                    light.setBackground(Color.WHITE);
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

        light2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //new Light2();
                light2on = !light2on;
                if(light2on){
                light2.setBackground(mainColor);
                } else{
                    light2.setBackground(Color.WHITE);
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

        fan.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                //new Fan();
                FanOn = !FanOn;
                if(FanOn){
                fan.setBackground(mainColor);
                } else{
                    fan.setBackground(Color.WHITE);
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
                    door.setBackground(mainColor);
                } else{
                    door.setBackground(Color.WHITE);
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