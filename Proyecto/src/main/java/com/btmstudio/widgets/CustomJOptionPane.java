package com.btmstudio.widgets;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class CustomJOptionPane extends JOptionPane {

    public CustomJOptionPane(Object message, int messageType, int optionType) {
        super(message, messageType, optionType);
        //setOpaque(false);
    }

    @Override
    public void paintComponent(Graphics g) {
    	  Graphics2D g2d = (Graphics2D) g.create();
          g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
          g2d.setColor(new Color(255,255,255,100));
          g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
          g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
          g2d.setColor(new Color(255,255,255));
          g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
          g2d.dispose();
          super.paintComponent(g);
    }

    public static void main(String[] args) {
        // Establecer el estilo del JOptionPane como el de sistema
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
}

