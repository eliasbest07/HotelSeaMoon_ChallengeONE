package com.btmstudio.widgets;


import java.awt.*;
import javax.swing.*;
 
public class RoundButtonAccion extends JButton {
 
    private int radius;
    private Color borderColor;
    private Color backgroundColor;

 
    public RoundButtonAccion(String text, int radius, Color borderColor, Color backgroundColor, float transparency) {
        super(text);
        this.radius = radius;
        this.borderColor = borderColor;
        this.backgroundColor = backgroundColor;

        setForeground(Color.WHITE); 
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(20, 45, 20, 45));
        setContentAreaFilled(false);
        setFocusPainted(false);
        
        setOpaque(false);
     
        
        setBorder(new RoundBorder(radius, Color.WHITE));
    }
 
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();
        Color colorone = borderColor;
        Color colortwo = backgroundColor;

        GradientPaint gradient = new GradientPaint( //  new Color(0x54d3fc)
                0, 0, colorone,
                width, height, colortwo // new Color(0x547ffc)
        );
        GradientPaint gradientHover = new GradientPaint(
                0, 0,  colortwo,
                width, height, colorone
        );
        g2d.setPaint(gradient);
        
      
        
        Color color1 = new Color(0x54d3fc);
        Color color2 = new Color(0x547ffc);
        if (getModel().isRollover()) {
            color1 = color1.brighter();
            color2 = color2.brighter();
            g2d.setPaint(gradientHover);
            setForeground(Color.BLACK);
        } else {
            g2d.setPaint(gradient);
            setForeground(Color.WHITE);
        }

      
        g2d.fillRoundRect(0, 0, width - 1, height - 1, radius, radius);

        if (getModel().isRollover()) {
            g2d.setColor(Color.WHITE);
        } else {
            g2d.setColor(Color.BLACK);
        }

        g2d.dispose();
        super.paintComponent(g);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        size.width-= 20;
        size.height += 10;
        return size;
    }
 
}