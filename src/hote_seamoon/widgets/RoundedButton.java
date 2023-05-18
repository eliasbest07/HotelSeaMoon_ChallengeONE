package hote_seamoon.widgets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GradientPaint;

public class RoundedButton extends JButton {

    private int radius;
    
    public RoundedButton(int radio) {
    	this.radius =radio;
        setOpaque(false);
        setForeground(Color.WHITE); 
        setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        setContentAreaFilled(false);
        setFocusPainted(false);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int width = getWidth();
        int height = getHeight();
        
        GradientPaint gradientHover = new GradientPaint(
                0, 0, new Color(0xcd2222), 
                getWidth(), getHeight(), Color.RED
            ); 
        
        GradientPaint gradient = new GradientPaint(
                0, 0, Color.RED, 
                getWidth(), getHeight(), new Color(0xcd2222)
            );
            g2d.setPaint(gradient);
        
        // Dibuja los bordes redondeados
        //g2d.setColor(Color.RED);
        g2d.setPaint(gradient);
        g2d.fillRoundRect(0, 0, width - 1, height - 1, radius, radius);
        g2d.fillRoundRect(1, 1, width - 3, height - 3, radius - 1, radius - 1);
        

        if (getModel().isRollover()) {
            g2d.setPaint(gradientHover);
            setForeground(Color.BLACK);
        } else {
            g2d.setPaint(gradient);
            setForeground(Color.WHITE);
        }

        
        // Dibuja los bordes rectos
      //  g2d.setColor(Color.RED);
        g2d.fillRect(width -1 - radius, 0, radius, radius);
        g2d.fillRect(0, height -1 - radius, radius, radius);
        


        g2d.dispose();
        super.paintComponent(g);
    }
}
