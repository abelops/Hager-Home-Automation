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

    public ContCent() {
        Home.frame.add(contPanelWindow);
        Home.frame.add(headerpanel);

        contPanelWindow.setVisible(true);
        contPanelWindow.setBackground(Color.LIGHT_GRAY);
        contPanelWindow.setBounds(0, 200, 1100, 400);

        // Header creator
        headerDesigner.headerCreator("Hager Home Automation", headerLabel, headerpanel);
        
        // Button configs
        light.setText("Light-1");
        light.setBounds(50, 30, 300, 30);

        light2.setText("Light-2");
        light2.setBounds(400, 30, 300, 30);

        fan.setText("Fan");
        fan.setBounds(750, 30, 300, 30);

        door.setText("Door");
        door.setBounds(50, 100, 300, 30);


        back.setText("Go Back");
        back.setBounds(50, 300, 120, 50);

        // Adding components
        contPanelWindow.add(light);
        contPanelWindow.add(light2);
        contPanelWindow.add(fan);
        contPanelWindow.add(door);
        contPanelWindow.add(back);

        headerpanel.add(headerLabel);

        light.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                new Light();
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
                new Light2();
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
                new Fan();
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
                new door();
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