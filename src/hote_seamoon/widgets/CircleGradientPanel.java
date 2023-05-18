package hote_seamoon.widgets;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class CircleGradientPanel extends JPanel {

    private int x;
    private int y;
    private int diameter;
    private GradientPaint gradient;

    public CircleGradientPanel(int x, int y, int diameter, Color color1, Color color2) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
        this.gradient = new GradientPaint(x, y, color1, x + diameter, y + diameter, color2);
    }


	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibuja el gradiente de fondo
        
        g2d.setPaint(gradient);
        g2d.fillOval(x, y, diameter, diameter);

        g2d.dispose();
    }
}
