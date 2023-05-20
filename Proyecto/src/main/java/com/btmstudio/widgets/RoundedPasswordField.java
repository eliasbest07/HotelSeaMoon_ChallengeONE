package com.btmstudio.widgets;

import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class RoundedPasswordField extends JPasswordField  {

    private int radius;
    private Color borderColor;
    private Color backgroundColor;
    private float transparency;
    private boolean showPassword = false;

    public RoundedPasswordField(int radius, Color borderColor, Color backgroundColor, float transparency) {
        super();
        this.radius = radius;
        this.borderColor = borderColor;
        this.backgroundColor = backgroundColor;
        this.transparency = transparency;
        setOpaque(false);
        setFont(new Font("Agency FB", Font.BOLD, 22));
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 5)); //Agregamos un espacio para el botón
        try {
        addShowPasswordButton(); //Agregamos el botón
        }catch (Exception e) {
			// TODO: handle exception
		}
    }

    private void addShowPasswordButton() throws IOException {
        JButton showPasswordButton = new JButton(new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("eye.png"))));   //  
        showPasswordButton.setPreferredSize(new Dimension(30, 20)); //Le damos un tamaño
        showPasswordButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //Cambiamos el cursor
        showPasswordButton.setContentAreaFilled(false); //Quitamos el fondo
        showPasswordButton.setBorderPainted(false); //Quitamos el borde
        showPasswordButton.addActionListener(e -> {
            showPassword = !showPassword; //Cambiamos el estado del showPassword
            updateTextEchoChar(); //Actualizamos el modo de visualización
        });
        add(showPasswordButton, BorderLayout.EAST); //
    }

    private void updateTextEchoChar() {
        if (showPassword) {
            setEchoChar((char) 0); //Mostramos los caracteres
        } else {
            setEchoChar('•'); //Ocultamos los caracteres
            
        }
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
        size.width += 20; //Le sumamos el ancho del botón
        size.height += 10;
        return size;
    }

}
