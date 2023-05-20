package com.btmstudio.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.sql.DataSource;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;

import com.btmstudio.widgets.CircleGradientPanel;
import com.btmstudio.widgets.RoundedButton;
import com.btmstudio.widgets.RoundedButtonOpcion;
import com.btmstudio.widgets.RoundedLabel;
import com.btmstudio.widgets.RoundedPanel;
import com.btmstudio.widgets.RoundedPasswordField;
import com.btmstudio.widgets.RoundedTextField;

import com.btmstudio.controllers.LoginController;
import com.btmstudio.utils.DataBase;
import com.btmstudio.utils.Credentials;

public class LoginView extends JFrame {

	private RoundedPanel contentPane;
	private JLabel ola;
	private JLabel olaMedia;
	private JLabel olaMediaDos;
	private JLabel olaMediaTres;
	private JLabel olaBaja;
	private JLabel olaBajaDos;
	private JLabel subOla;
	private JLabel logoHotel;
	private JLabel nombreHotel;
	private JLabel palmera;
	private JLabel turista;
	private JLabel avion;
	private JPanel nombre;
	private JPanel panel;
	private JPanel panelSeguir;
	private JPanel panelVolver;
	private JPanel panelRSeguir;
	private JPanel panelRVolver;
	private JPanel panelOpcion;
	
	private RoundedButton closeButton;
	private CircleGradientPanel sol;
	private CircleGradientPanel playa;
	private boolean actInicio=false;
	private boolean actRegistrar=false;
	private boolean seguir=false;
	private boolean seguirRegistro=false;
	
	
	private JLabel tituloIniciar;
	private RoundedTextField inputUsuario;
	private RoundedPasswordField inputClave;
	private RoundedPasswordField inputClaveMaestra;
	private RoundedTextField inputUsuarioRegistrar;
	private RoundedPasswordField inputClaveRegistrar;
	private JLabel alura = new JLabel("Alura ONE 2023");
	private JLabel marca = new JLabel("by BTM Studio Elias Montilla");
	private HomeView main;
	private JLabel lbl1 = new JLabel("USUARIO");
	private JLabel lbl2 = new JLabel("CLAVE");
	private JLabel lbl3 = new JLabel("VOLVER");
	private JLabel lbl4 = new JLabel("INGRESAR");
	
	private JLabel lbl5 = new JLabel("REGISTRAR USUARIO");
	private JLabel lbl6 = new JLabel("CLAVE GERENTE");
	private JLabel lbl7 = new JLabel("NUEVO USUARIO");
	private JLabel lbl8 = new JLabel("CLAVE USUARIO");
	private JLabel lbl9 = new JLabel("ATRAS");
	private JLabel lbl10 = new JLabel("CREAR");
	
	// private LoginController controller;
	private DataBase db;
	private final Credentials dataSource;
	
	public LoginView() throws IOException {
		setTitle("Bienvenido al Sistema Interno");
		 // controller= new LoginController();
		db= new DataBase();
		dataSource= new Credentials();
		 Credentials load = new Credentials();
		 System.out.println(LoginView.class.getProtectionDomain().getCodeSource().getLocation().getPath());

		 //ImageIcon alta = new ImageIcon("wave.png");
		 // ImageIcon alta = new ImageIcon(getClass().getResource("wave.png"));
		 InputStream inputStream = getClass().getClassLoader().getResourceAsStream("wavemedia.png");
		 ImageIcon alta = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("wave.png")));
		 ImageIcon media = new ImageIcon(ImageIO.read(inputStream));
		 
		//ImageIcon media = new ImageIcon("wavemedia.png");
		ImageIcon bajo = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("wavebaja.png"))); // 
		ImageIcon logo = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("hotelseamoon.png"))); // 
		ImageIcon hotellogo = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("hotelnombre.png"))); // 
		ImageIcon imgPalmera = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("palmera.png"))); // 
		ImageIcon imgTurista = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("turista.png"))); // 
		ImageIcon imgAvion = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("avion.png"))); // 
		ImageIcon icono = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("icono.png"))); // 
		setIconImage(icono.getImage());

		// Asignamos las imagenes a un JLabel
		avion= new JLabel(imgAvion);
		turista = new JLabel(imgTurista);
		palmera = new JLabel(imgPalmera);
		nombreHotel= new JLabel(hotellogo);
		logoHotel= new JLabel();
		olaBajaDos= new JLabel(bajo);
		olaBaja= new JLabel(bajo);
		olaMediaTres= new JLabel(media);
		olaMedia = new JLabel(media);
		ola = new JLabel(alta);
		subOla = new JLabel(alta);
		olaMediaDos  = new JLabel(media);
		panel = new JPanel();
		panelOpcion= new JPanel();
		nombre= new JPanel();
		panelSeguir= new JPanel();
		panelVolver = new JPanel();
		panelRSeguir= new JPanel();
		panelRVolver= new JPanel();
		try {
			main= new HomeView();
			main.setBackground(new Color(0, 0, 0, 0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		panelOpcion.setLayout(new BoxLayout(panelOpcion, BoxLayout.X_AXIS));

 // Agrega un espacio en blanco de 10 píxeles de ancho
		
		
		
		RoundedButtonOpcion registrar = new RoundedButtonOpcion(25,new Color(0x54d3fc),new Color(0x547ffc));
		RoundedButtonOpcion iniciar = new RoundedButtonOpcion(25,new Color(0x54d3fc),new Color(0x547ffc));
		
		RoundedButtonOpcion iniciarSeguir = new RoundedButtonOpcion(25,new Color(251, 255, 255, 80),new Color(0x547ffc));
		RoundedButtonOpcion iniciarVolver = new RoundedButtonOpcion(25,new Color(251, 255, 255, 80),new Color(0x547ffc));
		
		RoundedButtonOpcion registroSeguir = new RoundedButtonOpcion(25,new Color(0x54d3fc),new Color(0x547ffc));
		RoundedButtonOpcion registroVolver = new RoundedButtonOpcion(25,new Color(0x54d3fc),new Color(0x547ffc));
		
		setUndecorated(true); // Establecer la ventana sin decoración boton de minimizar y cerrar
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(220, 100, 850, 500);
		contentPane = new RoundedPanel(30, Color.WHITE,new Color(0x3bedeb),Color.BLUE,0.2f);
		
		registrar.setText("Registrar");
		registrar.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		
		iniciar.setText("Iniciar Sesión");
		iniciar.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		
		iniciarSeguir.setText("▶");
		iniciarSeguir.setFont(new Font("Agency FB", Font.BOLD, 22));
		
		iniciarVolver.setText("◀");
		iniciarVolver.setFont(new Font("Agency FB", Font.BOLD, 22));
		
		registroSeguir.setText("▶");
		registroSeguir.setFont(new Font("Agency FB", Font.BOLD, 22));
		
		registroVolver.setText("◀");
		registroVolver.setFont(new Font("Agency FB", Font.BOLD, 22));
		
		iniciarVolver.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        seguir=true;
		    }
		});
		
		registroVolver.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	seguirRegistro=true;
		    }
		});
		
	
		registroSeguir.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	if(inputClaveMaestra.getPassword().length==0) {
		    		JOptionPane.showMessageDialog(null, panel, "Se requiere La clave del Gerente", JOptionPane.PLAIN_MESSAGE);
		    		// JOptionPane.showMessageDialog(null, "NO", "NO REGISTRO", JOptionPane.INFORMATION_MESSAGE);
		    		return;
		    	}else {
		    		if(!inputClaveMaestra.getText().equals(dataSource.getManagerPassword())) {
		    			JOptionPane.showMessageDialog(null, panel, "La clave del Gerente es incorrecta "+dataSource.getManagerPassword(), JOptionPane.PLAIN_MESSAGE);
		    			return;
		    		}
		    	}
		    	if(inputUsuarioRegistrar.getText().length()<3) {
		    		JOptionPane.showMessageDialog(null, panel, "Nombre del nuevo Usuario NO es valido", JOptionPane.PLAIN_MESSAGE);
		    		return;
		    	}else {
		    		if(db.existeUsuario(inputUsuarioRegistrar.getText())) {
		    			JOptionPane.showMessageDialog(null, panel, "Ya EXISTE un Usuario con ese nombre", JOptionPane.PLAIN_MESSAGE);
		    			return;
		    		}
		    	}
		    	if(inputClaveRegistrar.getText().length()<6) {
		    		JOptionPane.showMessageDialog(null, panel, "La nueva clave debe ser mayor de 6 digitos", JOptionPane.PLAIN_MESSAGE);
		    		return;
		    	}
		    	boolean registro= db.registarFull(inputClaveMaestra.getText(),inputUsuarioRegistrar.getText() , inputClaveRegistrar.getText());
		    	//controller.registrar(inputClaveMaestra.getText(),inputUsuarioRegistrar.getText() , inputClaveRegistrar.getText());
		    	// seguirRegistro=true;
		    	if(registro) {
		    		 JOptionPane.showMessageDialog(null, "Registro Exitoso", "Ya puedes Inicia Sesión", JOptionPane.INFORMATION_MESSAGE);
		    		 seguirRegistro=true;
		    	}else {
		    		 JOptionPane.showMessageDialog(null, "NO", "NO SE REGISTRO", JOptionPane.INFORMATION_MESSAGE);
		    	}
		    }
		});
		iniciarSeguir.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	if(inputUsuario.getText().length()<3) {
		    		JOptionPane.showMessageDialog(null, "Error Usuario", "No es valido el Usuario", JOptionPane.INFORMATION_MESSAGE);
		    		return;
		    	}
		    	if(inputClave.getText().length()<6) {
		    		JOptionPane.showMessageDialog(null, panel, "La nueva clave debe ser mayor de 6 digitos", JOptionPane.PLAIN_MESSAGE);
		    		return;
		    	}
		    	
		    	if(db.iniciarSesion(inputUsuario.getText(),inputClave.getText())) {
		    		  main.setVisible(true);
				        dispose(); 
		    	}else {
		    		JOptionPane.showMessageDialog(null, panel, "INCORRECTO", JOptionPane.PLAIN_MESSAGE);
		    	}
		    }
		});
		    
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelSeguir.setOpaque(false);
		panelVolver.setOpaque(false);
		panelRSeguir.setOpaque(false);
		panelRVolver.setOpaque(false);
		panelVolver.add(iniciarVolver);
		panelSeguir.add(iniciarSeguir);
		panelOpcion.setOpaque(false);
		panel.setOpaque(false);
		
		panelRSeguir.add(registroSeguir);
		panelRVolver.add(registroVolver);
		
		closeButton = new RoundedButton(20);
		closeButton.setText("x");
		closeButton.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		closeButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        System.exit(0);
		    }
		});
		

		
		panelOpcion.add(registrar);
		panelOpcion.add(Box.createRigidArea(new Dimension(50, 0)));
		panelOpcion.add(iniciar);
		panel.add(closeButton);
		
		 sol = new CircleGradientPanel(0, 0, 100, Color.YELLOW, Color.ORANGE);
		 sol.setPreferredSize(new Dimension(200, 200));
		 sol.setOpaque(false);
		 
		 playa = new CircleGradientPanel(0, 0, 1000,new Color(0xffd06a),new Color(0xe5a928));
		 playa.setPreferredSize(new Dimension(2000, 2000));
		 playa.setOpaque(false);
		 
		 inputUsuario = new RoundedTextField(10, Color.WHITE, new Color(255, 255, 255, 128), 0.5f);
		 inputUsuario.setPreferredSize(new Dimension(200, 30));
		 
		 inputClave = new RoundedPasswordField(10, Color.WHITE, new Color(255, 255, 255, 128), 0.5f);
		 inputClave.setPreferredSize(new Dimension(200, 30));
		 
		 inputClaveMaestra = new RoundedPasswordField(10, Color.WHITE, new Color(255, 255, 255, 128), 0.5f);
		 inputClaveMaestra.setPreferredSize(new Dimension(200, 30));
		 
		 inputUsuarioRegistrar = new RoundedTextField(10, Color.WHITE, new Color(255, 255, 255, 128), 0.5f);
		 inputUsuarioRegistrar.setPreferredSize(new Dimension(200, 30));
		 
		 inputClaveRegistrar = new RoundedPasswordField(10, Color.WHITE, new Color(255, 255, 255, 128), 0.5f);
		 inputClaveRegistrar.setPreferredSize(new Dimension(200, 30));
		 
		 iniciar.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	if(!actInicio && !actRegistrar) {
			    	actInicio=true;
			    	timerInicio.start();
			    	}
			    }
			});
		 
		 registrar.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	if(!actRegistrar && !actInicio) {
			    		actRegistrar=true;
			    		timerRegistrar.start();
			    	}
			    }
			});
		  tituloIniciar = new RoundedLabel("Iniciar Sesión", 20, Color.WHITE, new Color(255, 255, 255, 100), 0.5f);
		  tituloIniciar.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		 // tituloIniciar.setVisible(false);
		 logoHotel.setPreferredSize(new Dimension(80, 80));
	 
		Image imagenOriginal = logo.getImage();
		Image imagenEscalada = imagenOriginal.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon iconEscalado = new ImageIcon(imagenEscalada);

		logoHotel.setIcon(iconEscalado);
		 
			nombre.add(logoHotel);
			nombre.add(nombreHotel);
			nombre.setOpaque(false);
			
		
		alura.setBounds(15, 405, 400, 20);
		alura.setForeground(Color.WHITE);
		lbl5.setForeground(Color.WHITE);
		lbl9.setForeground(Color.WHITE);
		lbl10.setForeground(Color.WHITE);
		marca.setForeground(Color.WHITE);

		contentPane.add(lbl1);
		contentPane.add(lbl2);
		contentPane.add(lbl3);
		contentPane.add(lbl4);
		contentPane.add(lbl5);
		contentPane.add(lbl6);
		contentPane.add(lbl7);
		contentPane.add(lbl8);
		contentPane.add(lbl9);
		contentPane.add(lbl10);
		contentPane.add(inputClaveMaestra);
		contentPane.add(inputUsuarioRegistrar);	
		contentPane.add(inputClaveRegistrar);
		contentPane.add(panelRSeguir);
		contentPane.add(panelRVolver);	
		contentPane.add(avion);
		contentPane.add(panelVolver);	
		contentPane.add(panelSeguir);
		contentPane.add(inputClave);
		contentPane.add(inputUsuario);
		contentPane.add(turista);
		contentPane.add(palmera);
		contentPane.add(tituloIniciar);
		contentPane.add(playa);
		contentPane.add(nombre);
		contentPane.add(panelOpcion);
		contentPane.add(closeButton);
		contentPane.add(sol);
		contentPane.add(ola);
		contentPane.add(olaMedia);
		contentPane.add(olaMediaDos);
		contentPane.add(olaMediaTres);
		contentPane.add(olaBaja);
		contentPane.add(olaBajaDos);
		contentPane.add(subOla);
		contentPane.add(alura);
		contentPane.add(marca);
		
		timer.start();

		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		
	}

	Timer timer = new Timer(50, new ActionListener() {
	    int x = 0; // Posición inicial X de la imagen
	    public void actionPerformed(ActionEvent e) {
	        x -= 10; // Mueve la imagen 10 píxeles a la izquierda
	        if (x < -1280) { // Si la posición de la imagen x es menor que -150, establece la posición x en 500
	            x = 0;
	        }
	        if(!actInicio) {
	        	panelVolver.setLocation(500, 850);
	        	panelSeguir.setLocation(500, 850);
	        	inputClave.setLocation(500, 850);
	        	inputUsuario.setLocation(500, 750);
	        	turista.setLocation(500, 750);
	        	palmera.setLocation(500, 750);
	        	tituloIniciar.setLocation(500, 750);	
	        	playa.setLocation(500, 550);	
	        	panelOpcion.setLocation(220, 300);
	        	lbl1.setLocation(500, 750);
		         lbl2.setLocation(500, 750);
		         lbl3.setLocation(500, 750);
		         lbl4.setLocation(500, 750);
	        }
	        if(!actRegistrar) {
	        	avion.setLocation(-500, 850);
	        	panelRSeguir.setLocation(-500, 850);
	        	panelRVolver.setLocation(-500, 850);
	        	panelOpcion.setLocation(220, 300);
	        	inputClaveMaestra.setLocation(-500, 850);
	        	inputUsuarioRegistrar.setLocation(-500, 850);
	        	inputClaveRegistrar.setLocation(-500, 850);
	        	lbl5.setLocation(380, 780);
	        	lbl6.setLocation(40, 750);
	        	lbl7.setLocation(400, 750);
	        	lbl8.setLocation(580, 750);
	        	lbl9.setLocation(200, 700);
	        	lbl10.setLocation(580, 700);
	        }else {
	        	panelOpcion.setLocation(50,880);
	        }
	        alura.setLocation(15, 475);
	        marca.setLocation(680, 475);
	        sol.setLocation(700, 25);
	        nombre.setLocation(250, 20);
	        closeButton.setLocation(0, 0);
	        
	        if(x %2 ==0) {
	        	olaMedia.setLocation(355+x, 95);
	        	olaMediaDos.setLocation(x-925, 95);
	        	olaMediaTres.setLocation(x+1635, 95);
	        }
	        ola.setLocation(x, 95); // Establece la nueva posición de la imagen
	        subOla.setLocation(x+1280, 95);
	        olaBaja.setLocation(-x-250, 95);
	        olaBajaDos.setLocation(-x-1530, 95);
	    }
	
	});
	
	Timer timerInicio = new Timer(10, new ActionListener() {
	    int centerX = 60;
	    int centerY = 300;
	    int radius = 150;
	    double angle = 2.55;
	    public void actionPerformed(ActionEvent e) {
	    	 int x = (int) (centerX + radius * Math.cos(angle));
	         int y = (int) (centerY + radius * Math.sin(angle));
	         panelVolver.setLocation(-x+265,y+220);
	         panelSeguir.setLocation(-x+650,y+220);
	         inputClave.setLocation(-x+400,y+180);
	         inputUsuario.setLocation(-x+400,y+100);
	         turista.setLocation(-x+200,y+30);
	         palmera.setLocation(-x+650,y+10);
	         tituloIniciar.setLocation(-x+450,y+20);
	         lbl1.setLocation(-x+400,y+80);
	         lbl2.setLocation(-x+400,y+160);
	         lbl3.setLocation(-x+280,y+200);
	         lbl4.setLocation(-x+670,y+200);
	         playa.setLocation(-x,y);
	         if(!seguir) {
		         if (x == 80) {
		        //	 tituloIniciar.setVisible(true);
	
		         }else {
		        	 if(actInicio) {
		        	 angle += 0.05;	
		        	 }
		         }
	
		         if (angle >= 2 * Math.PI) {
		             angle = 0;
		         }
	         }else {
	        	 if(angle > 7.0) {
	        		 panelVolver.setLocation(500, 850);
	 	        	panelSeguir.setLocation(500, 850);
	 	        	inputClave.setLocation(500, 850);
	 	        	inputUsuario.setLocation(500, 750);
	 	        	turista.setLocation(500, 750);
	 	        	palmera.setLocation(500, 750);
	 	        	lbl1.setLocation(500, 750);
	 		         lbl2.setLocation(500, 750);
	 		         lbl3.setLocation(500, 750);
	 		         lbl4.setLocation(500, 750);
	 	        	tituloIniciar.setLocation(500, 750);	
	 	        	//playa.setLocation(500, 450);
	 	        	actInicio=false;
	 	        	angle=2.55;
	 	        	seguir=false;
	 	        	 ((Timer)e.getSource()).stop();	 	 
	 	        	 
	        	 }else {
	        		 angle += 0.05;		        		 
	        	 }
	         }
	    }
	
	});
	
	Timer timerRegistrar = new Timer(10, new ActionListener() {
	    int centerX = 60;
	    int centerY = 300;
	    int radius = 250;
	    double angle = 2.50;
	    boolean estatico =false; 
	    int avanzar=300;
	    public void actionPerformed(ActionEvent e) {
	    
	    	 int x = (int) (centerX + radius * Math.cos(angle));
	         int y = (int) (centerY + radius * Math.sin(angle));
	         avion.setLocation(x,y);	

	        // System.out.println("El valor de angle es: " + angle);
	         
	      
	         if(!seguirRegistro) {
	        	   if(estatico) {
	  	        	 radius=5;
	  	        	 avion.setLocation(300,y-160);
	  	        	// panelRSeguir.setLocation(-500, 850);
	  	        	 panelRSeguir.setLocation(550,380);
	  	        	 panelRVolver.setLocation(200, 380);
	  	        	inputClaveMaestra.setLocation(50, 300);
		        	inputUsuarioRegistrar.setLocation(325, 300);
		        	inputClaveRegistrar.setLocation(600, 300);
		        	lbl5.setLocation(380, 380);
		        	lbl6.setLocation(60, 280);
		        	lbl7.setLocation(390, 280);
		        	lbl8.setLocation(600, 280);
		        	lbl9.setLocation(230, 360);
		        	lbl10.setLocation(580, 360);
	  	        	 angle += 0.05;	
	  	         }else {
	  	        	 avion.setLocation(x,y);	
	  	        	 panelRSeguir.setLocation(x+300, y+250);
	  	        	 panelRVolver.setLocation(x-50, y+250);
	  	        	inputClaveMaestra.setLocation(x-50, y+200);
		        	inputUsuarioRegistrar.setLocation(x-325, y+200);
		        	inputClaveRegistrar.setLocation(x-600, y+200);
	  	         }
		         if (angle > 5.5) {
		        //	 tituloIniciar.setVisible(true);
		        	estatico=true;
	
		         }else {
		        
		        	 angle += 0.05;	
		         }
	
		         if (angle >= 2 * Math.PI) {
		             angle = 0;
		         }
	         }else {
	        	 if(avanzar > 800) {
	 	        	((Timer)e.getSource()).stop();	
	 	         	lbl5.setLocation(380, 780);
		        	lbl6.setLocation(40, 750);
		        	lbl7.setLocation(400, 750);
		        	lbl8.setLocation(580, 750);
		        	lbl9.setLocation(200, 700);
		        	lbl10.setLocation(580, 700);
	 	        	actRegistrar=false;
	        		 seguirRegistro=false;
	        		 estatico=false;
	        		 angle = 2.50;
	        		 radius = 250;
	        		 avanzar=300;
	        		 panelOpcion.setVisible(true);
	        	 }else {
	        		 avanzar=avanzar+10;
	        		 avion.setLocation(avanzar,y-160);	
	        		 angle += 0.05;
	        	 }
	         }
	    }
	
	});

}