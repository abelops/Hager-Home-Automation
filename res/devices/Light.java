package res.devices;

import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JButton;

import lib.DesignUtils;
import res.mains.Home;
import res.utils.*;

public class Light extends Functioner {
    DesignUtils designer = new DesignUtils();
    Utils utils = new Utils();
    JLabel header = new JLabel();
    JPanel headerPanel = new JPanel();
    JButton back = new JButton();
    JPanel bodyPanel = new JPanel();
    JButton on = new JButton();
    JButton off = new JButton();

    public Light() {
        Home.frame.getContentPane().removeAll();
        Home.frame.add(headerPanel);
        Home.frame.add(bodyPanel);

        designer.headerCreator("Light-1", header, headerPanel); // designing the header and creating the header
        designer.bodyPanelCreatorWithBackButton(bodyPanel, back); // Creating and designing the body panel and setting
                                                                  // the back button
        designer.onOffButtonCreator(on, off);

        utils.backAction(back);
        utils.onOffAction(on, off);

        onOffWriter(on, off, "Light-1");

        bodyPanel.add(back);
        bodyPanel.add(on);
        bodyPanel.add(off);
        headerPanel.add(header);
        Home.frame.repaint();
    }
    
}
