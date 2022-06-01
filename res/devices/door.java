package res.devices;

import lib.DesignUtils;
import res.mains.Home;
import res.utils.*;

import javax.swing.JLabel;
// import javax.swing.JOptionPane;
import javax.swing.JPanel;

// import java.awt.event.ActionListener;
// import java.io.BufferedWriter;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.awt.event.ActionEvent;

import javax.swing.JButton;

public class door extends Functioner {
    static int volumeLevel = 0;
    DesignUtils designer = new DesignUtils();
    Utils utils = new Utils();
    JLabel header = new JLabel();
    JPanel headerPanel = new JPanel();
    JButton back = new JButton();
    JPanel bodyPanel = new JPanel();
    JButton on = new JButton();
    JButton off = new JButton();

    public door() {
        Home.frame.getContentPane().removeAll();
        Home.frame.add(headerPanel);
        Home.frame.add(bodyPanel);

        designer.headerCreator("Smart Door", header, headerPanel); // designing the header and creating the header
        designer.bodyPanelCreatorWithBackButton(bodyPanel, back); // Creating and designing the body panel and setting
                                                                  // the back button
        
        designer.onOffButtonCreator(on, off);

        on.setText("Open");
        off.setText("Close");

        utils.backAction(back);
        utils.onOffAction(on, off);
        onOffWriter(on, off, "Smart Door");

        // volumeConfig();

        bodyPanel.add(back);
        bodyPanel.add(on);
        bodyPanel.add(off);
        headerPanel.add(header);
        Home.frame.repaint();
    }
}
