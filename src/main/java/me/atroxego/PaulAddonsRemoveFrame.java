package me.atroxego;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.File;

public class PaulAddonsRemoveFrame extends JFrame {
    public static void main(String[] args) {
        try {
            Thread.sleep(3000);
            PaulAddonsRemoveFrame frame = new PaulAddonsRemoveFrame(args[0]);
            frame.centerFrame(frame);
            frame.setVisible(true);
            Thread.sleep(4000);
            frame.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static final int w = 350;
    private static final int h = 130;

    public PaulAddonsRemoveFrame(String arg) {
        try {
            setName("PaulAddonsUpdaterFrame");
            setTitle("PaulAddons Updater");
            setUndecorated(true);
            setResizable(false);
            setSize(w,h);
            setShape(new RoundRectangle2D.Double(0, 0, w, h, 16, 16));
            String text = "Paul Addons Updater";
            JPanel mainPanel = new JPanel();
            Label label = new Label(text);
            label.setFont(new Font("Posterama", Font.BOLD, 16));
            TextArea desc = new TextArea(null,4,45, 3);
            desc.append("Starting old jar deletion...\n");

            File oldJar = new File(arg);
            if (!oldJar.exists()) desc.append("Old jar doesn't exist!\n");
            else {
                desc.append("Old jar found!\n");

                if (oldJar.delete()) desc.append("Old jar removed successfully!\n");
                else desc.append("Could remove the old jar!\n");
            }
            desc.append("Closing this window in 3 seconds.\n");
            desc.setEditable(false);
            desc.setFocusable(false);
            desc.setForeground(Color.WHITE);
            desc.setBackground(Color.BLACK);
            desc.setSize(200,200);
            mainPanel.add(label);
            mainPanel.add(desc);
            setContentPane(mainPanel);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void centerFrame(JFrame frame) {
        Rectangle rectangle = frame.getBounds();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle screenRectangle = new Rectangle(0, 0, screenSize.width, screenSize.height);

        int newX = screenRectangle.x + (screenRectangle.width - rectangle.width) / 2;
        int newY = screenRectangle.y + (screenRectangle.height - rectangle.height) / 2;

        if (newX < 0) newX = 0;
        if (newY < 0) newY = 0;

        frame.setBounds(newX, newY, rectangle.width, rectangle.height);
    }

}