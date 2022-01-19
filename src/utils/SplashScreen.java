/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ui.login.LoginPanel;

public class SplashScreen extends JWindow {
    
    public static void main(String[] args) {
        new SplashScreen();
    }
    
    public SplashScreen() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                showSplash();

            }
        });
    }

    public void showSplash() {

        JPanel content = (JPanel) getContentPane();
        content.setBackground(Color.WHITE);

        // Set the window's bounds, centering the window
        int width = 700;
        int height = 450;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);

        // Build the splash screen
        JLabel label = new JLabel(new ImageIcon(getClass().getResource("splash.gif")));
        JLabel copyrt = new JLabel("Splash Screen!!!", JLabel.CENTER);

        content.add(label, BorderLayout.CENTER);

        label.setLayout(new GridBagLayout());
        Font font = copyrt.getFont();
        copyrt.setFont(font.deriveFont(Font.BOLD, 24f));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        label.add(copyrt, gbc);

        ImageIcon wait = new ImageIcon(getClass().getResource("splash.gif"));
        label.add(new JLabel(wait), gbc);

        content.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10));

        // Display it
        setVisible(true);
        toFront();

        new ResourceLoader().execute();
    }

    public class ResourceLoader extends SwingWorker<Object, Object> {

        @Override
        protected Object doInBackground() throws Exception {

            // Wait a little while, maybe while loading resources
            try {
                Thread.sleep(6000);
                try {
                LoginPanel ap = new LoginPanel();
                ap.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;

        }

        @Override
        protected void done() {
            setVisible(false);
        }


    }

}
