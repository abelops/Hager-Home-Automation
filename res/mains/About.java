package res.mains;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class About {
    //Software Version
    private double version = 1.0;

    public double getVersion() {
        return version;
    }
    public void setVersion(double version) {
        this.version = version;
    }


    JFrame aboutFrame = new JFrame();
    JPanel sidebar = new JPanel();
    JLabel name, title;
    JTextArea authorDescrip = new JTextArea();
    JButton ok = new JButton();
    JTextArea softDescrip = new JTextArea();

    About() {
        aboutFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        aboutFrame.setVisible(true);
        aboutFrame.setAutoRequestFocus(true);
        aboutFrame.setBounds(420, 200, 600, 350);
        aboutFrame.setAlwaysOnTop(true);
        aboutFrame.setLayout(null);
        aboutFrame.setResizable(false);
        aboutFrame.setTitle("About");
        aboutFrame.setLocationRelativeTo(Home.frame);

        sidebar.setLayout(null);
        sidebar.setSize(200, 350);
        sidebar.setVisible(true);
        sidebar.setBackground(Color.LIGHT_GRAY);

        title = new JLabel();
        title.setText("HHA");
        title.setBounds(80, 5, 200, 30);
        title.setForeground(Color.RED);

        name = new JLabel();
        name.setText("Hager Home Automation");
        name.setBounds(30, 40, 200, 30);


        authorDescrip.setText("            A group project by \n       Section A Group 3 Students\n Home Automation Java Project");
        authorDescrip.setEditable(false);
        authorDescrip.setSize(200, 50);
        authorDescrip.setBounds(10, 140, 200, 50);
        authorDescrip.setBackground(Color.lightGray);

        softDescrip.setText("   This is a demo program writtten in pure java."
                +    "\nThis program is a demo for a Home automation control "
                +    "\nThe name of the Developers are: ."
                +    "\n 1. Abel Abebe            ETS0019/12."
                +    "\n 2. Abel Getahun         ETS0034/12."
                +    "\n 3. Abesolom Nekahiwot ETS0047/12."
                +    "\n 4. Adnan Kemal          ETS0066/12."
                +    "\n 5. Akinahom Getahun     ETS0073/12.");
                
        softDescrip.setBounds(205, 50, 410, 200);
        softDescrip.setEditable(false);
        softDescrip.setFont(new Font("Dotum",Font.TRUETYPE_FONT,14));

        sidebar.add(name);
        sidebar.add(title);
        sidebar.add(authorDescrip);
        

        ok.setText("OK");
        Home.designer.BtnFontDesigner(ok);
        ok.setBounds(270, 275, 280, 30);
        ok.setBorderPainted(true);
        ok.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.GRAY));
        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                aboutFrame.setVisible(false);
            }

        });
        ok.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ok.setBackground(Color.YELLOW);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ok.setBackground(UIManager.getColor("control"));
            }
        });

        aboutFrame.add(sidebar);
        aboutFrame.add(ok);
        aboutFrame.add(softDescrip);

        aboutFrame.setVisible(true);
        aboutFrame.repaint();

    }
}
