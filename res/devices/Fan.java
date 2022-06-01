package res.devices;

import lib.DesignUtils;
import res.mains.Home;
import res.utils.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;

public class Fan extends Functioner {
    static int volumeLevel = 0;

    DesignUtils designer = new DesignUtils();
    Utils utils = new Utils();
    JLabel header = new JLabel();
    JPanel headerPanel = new JPanel();
    JButton back = new JButton();
    JPanel bodyPanel = new JPanel();
    JButton on = new JButton();
    JButton off = new JButton();

    public Fan() {
        Home.frame.getContentPane().removeAll();
        Home.frame.add(headerPanel);
        Home.frame.add(bodyPanel);

        designer.headerCreator("Smart Fan", header, headerPanel); // designing the header and creating the header
        designer.bodyPanelCreatorWithBackButton(bodyPanel, back); // Creating and designing the body panel and setting
                                                                  // the back button

        designer.onOffButtonCreator(on, off);

        utils.backAction(back);
        utils.onOffAction(on, off);
        onOffWriter(on, off, "Smart Fan");

        volumeConfig();

        bodyPanel.add(back);
        bodyPanel.add(on);
        bodyPanel.add(off);
        headerPanel.add(header);
        Home.frame.repaint();
    }

    private void volumeConfig() {
        JButton volumeUp = new JButton("Speed Up");
        JButton volumeDown = new JButton("Speed Down");

        volumeUp.setBounds(380, 100, 100, 110);
        volumeUp.setToolTipText("Speed UP Button. Press to increase the Speed");

        volumeDown.setBounds(620, 100, 100, 110);
        volumeDown.setToolTipText("Speed Down Button. Press to decrease the Speed");

        bodyPanel.add(volumeUp);
        bodyPanel.add(volumeDown);

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                BufferedWriter logger;
                try {
                    if (volumeLevel > 100) {
                        JOptionPane info = new JOptionPane("Speed cannot be more than 100");
                        info.setBounds(0, 0, 300, 200);
                        bodyPanel.add(info);
                    } else {
                        volumeLevel++;
                        logger = new BufferedWriter(new FileWriter(file, true));
                        logger.append("Speed increated to " + volumeLevel + " By User at " + date);
                        logger.newLine();
                        logger.close();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        };
        volumeUp.addActionListener(al);

        volumeDown.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                BufferedWriter logger;
                try {
                    if (volumeLevel < 0) {
                        JOptionPane info = new JOptionPane("Speed cannot be less than 0");
                        info.setBounds(0, 0, 300, 200);
                        bodyPanel.add(info);
                    } else {
                        volumeLevel--;
                        logger = new BufferedWriter(new FileWriter(file, true));
                        logger.append("Speed decreased to " + volumeLevel + " By User at " + date);
                        logger.newLine();
                        logger.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
    }
}
