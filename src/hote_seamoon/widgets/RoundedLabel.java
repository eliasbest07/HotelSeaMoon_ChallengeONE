package hote_seamoon.widgets;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
 
public class RoundedLabel extends JLabel {
 
    private int radius;
    private Color borderColor;
    private Color backgroundColor;
    private float transparency;
 
    public RoundedLabel(String text, int radius, Color borderColor, Color backgroundColor, float transparency) {
        super(text);
        this.radius = radius;
        this.borderColor = borderColor;
        this.backgroundColor = backgroundColor;
        this.transparency = transparency;
        setOpaque(false);
        setHorizontalAlignment(JLabel.CENTER);
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
    }
 
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(backgroundColor);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency));
        g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        g2d.setColor(borderColor);
        g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        g2d.dispose();
        super.paintComponent(g);
    }
 
    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        size.width += 20;
        size.height += 10;
        return size;
    }
 
}