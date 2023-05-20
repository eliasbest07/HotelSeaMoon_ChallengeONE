package com.btmstudio.widgets;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;

import java.awt.*;
import java.io.IOException;


public class RoundedComboBox extends JComboBox<String> {
	int radius;
    public RoundedComboBox(int radio) {
    	this.radius =radio;
        setUI(new RoundedComboBoxUI());
        setOpaque(false);
        setBackground(new Color(255, 255, 255,100));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
       // setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }
    public void setDatos(String[] datos) {
        DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(datos);
        setModel(model);
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
      //  g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
        g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        g2.fillRoundRect(1, 1, getWidth() - 3, getHeight()  - 3, radius - 1, radius - 1);
        super.paintComponent(g2);
        g2.dispose();
    }

        
    private class RoundedComboBoxUI extends BasicComboBoxUI {

        @Override
        protected JButton createArrowButton() {
        	   JButton arrowButton = new RoundedButtonOpcion(10,new Color(255, 255, 255,100),new Color(255, 255, 255,255));
               ImageIcon icon=new ImageIcon();
			try {
				icon = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("flecha.png")));
			} catch (IOException e) {
				e.printStackTrace();
			}  // 
               arrowButton.setIcon(icon);
               return arrowButton;
     
            }
        
    }
    
    class RoundedComboPopup extends BasicComboPopup {

        public RoundedComboPopup(JComboBox combo) {
            super(combo);
            setOpaque(false);
            setBackground(new Color(255, 255, 255,100));
           // setBackground(Color.WHITE);
            setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            //setBorder(BorderFactory.createLineBorder(Color.WHITE));
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
          //  g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
            g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
            g2.fillRoundRect(1, 1, getWidth() - 3, getHeight()  - 3, 15 - 1, 15 - 1);
            super.paintComponent(g2);
            g2.dispose();
        }

        @Override
        protected JScrollPane createScroller() {
            JScrollPane scroller = new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scroller.getViewport().setBackground(Color.WHITE);
            
            scroller.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
           // scroller.setBorder(BorderFactory.createLineBorder(Color.WHITE));
            return scroller;
        }
    }
    
}