package com.btmstudio.widgets;


import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;
import java.awt.LinearGradientPaint;


public class RoundedPanel extends JPanel {
    private int radius;
    private Color colorone;
    private Color colortwo;
    private Color colorthree;
    private float rangoTop;
    private Boolean opcion;

    public RoundedPanel(int radius, Color color, Color colordos, Color colortres, float rango) {
        this.radius = radius;
        this.colorone = color;
        this.colortwo = colordos;
        this.colorthree = colortres; 
        this.rangoTop = rango;
       // setLayout(new BorderLayout());
    }
    public RoundedPanel(int radius, Color color, Color colordos, boolean opcion) {
    	 this.radius = radius;
         this.colorone = color;
         this.colortwo = colordos;
         this.colorthree = new Color(0x54d3fc); 
         this.rangoTop = 0.1f;
         this.opcion = opcion;
    	
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        LinearGradientPaint gradient = new LinearGradientPaint(
                0, 0, 0, getHeight(),
                new float[] { rangoTop, 0.4f, 1.0f },
                new Color[] { colorone, colortwo,colorthree }
        );
        GradientPaint gradientDos = new GradientPaint( //  new Color(0x54d3fc)
                0, 0, colorone,
                getWidth(), getHeight(), colortwo // new Color(0x547ffc)
        );
        GradientPaint gradienttres = new GradientPaint( //  new Color(0x54d3fc)
        		getWidth(), 0, colortwo,
                0, getHeight(), colorone // new Color(0x547ffc)
        );
        
        if(opcion == null) {
        g2d.setPaint(gradient);
        }else {
        	if(opcion) {
        		 g2d.setPaint(gradientDos);
        	}else {
        		 g2d.setPaint(gradienttres);
        	}
        }
       // g2d.setColor(color);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2d.dispose();
    }
}