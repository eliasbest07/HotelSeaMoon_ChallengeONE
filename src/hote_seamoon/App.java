package hote_seamoon;

import java.awt.Color;
import java.io.IOException;

import hote_seamoon.views.LoginView;

public class App {
	
	   public static void main(String[] args) throws IOException {

		      LoginView ventanaMain = new LoginView();
		      ventanaMain.setBackground(new Color(0, 0, 0, 0));
		      ventanaMain.setVisible(true);

		      
		   }
}
