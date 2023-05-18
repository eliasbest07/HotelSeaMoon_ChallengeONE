package hote_seamoon.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import hote_seamoon.widgets.RoundButtonAccion;
import hote_seamoon.widgets.RoundedButton;
import hote_seamoon.widgets.RoundedLabel;
import hote_seamoon.widgets.RoundedPanel;


public class HomeView extends JFrame {

	private RoundedPanel contentPane;
	private JLabel edificio;
	private JLabel hotelLogo;
	private JLabel hotelNombre;
	private JLabel estrellas;
	private JLabel estrella;
	private JLabel labelHora;
	private JLabel labelFecha;
	private JLabel textReg;
	private JLabel textBus;
	private RoundedButton closeButton;
	private JPanel panelRegistro;
	private JPanel panelBusqueda;
	private ReservaView agregar;
	private SearchView buscador;
	
	
	public HomeView() {
		setTitle("Administrador de Habitaciones y Reservas");
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(220, 100, 850, 500);
		contentPane = new RoundedPanel(30, new Color(0x29173f),new Color(0x685283) ,new Color(0x06195b),0.01f);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		 
		RoundButtonAccion registrar = new RoundButtonAccion( "", 25,new Color(192, 192, 192,100),new Color(245, 138, 130,200),0.5f);
		RoundButtonAccion busqueda = new RoundButtonAccion( "", 25,new Color(192, 192, 192,100),new Color(138, 245, 255,190),0.5f);
		
		ImageIcon edif = new ImageIcon(getClass().getResource("../assets/edificio.png"));
		ImageIcon logo = new ImageIcon(getClass().getResource("../assets/hotelseamoonnoche.png"));
		ImageIcon nombre = new ImageIcon(getClass().getResource("../assets/hotelnombreblanco.png"));
		ImageIcon estrell = new ImageIcon(getClass().getResource("../assets/estrellas.gif"));
		ImageIcon iconoRegistrar = new ImageIcon(getClass().getResource("../assets/agregar.png"));
		ImageIcon iconoBusqueda = new ImageIcon(getClass().getResource("../assets/buscar.png"));
		
		panelRegistro= new JPanel();
		panelRegistro.setOpaque(false);
		panelBusqueda= new JPanel();
		panelBusqueda.setOpaque(false);
		
		agregar= new ReservaView(this);
		buscador= new SearchView(this);
		buscador.setBackground(new Color(0, 0, 0, 0));
		agregar.setBackground(new Color(0, 0, 0, 0));
		textReg= new JLabel("<html><body>Registro de <br>  reserva</body></html>");
		textBus= new JLabel("Búsqueda");
		estrellas=new JLabel(estrell); 
		estrella=new JLabel(estrell); 
		edificio= new JLabel(edif);
		edificio.setBounds(500, 340, edif.getIconWidth(), edif.getIconHeight());
		hotelLogo= new JLabel(logo);
		hotelLogo.setBounds(70, 50, logo.getIconWidth(), logo.getIconHeight());
		hotelNombre= new JLabel(nombre);
		hotelNombre.setBounds(170, 30, nombre.getIconWidth(), nombre.getIconHeight());
		closeButton = new RoundedButton(20);
		closeButton.setText("x");
		closeButton.setFont(new Font("Agency FB", Font.BOLD, 20));
		closeButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        System.exit(0);
		    }
		});
		estrella.setBounds(50, -160, 470, 200);
		estrellas.setBounds(450, -60, 470, 200);
		closeButton.setBounds(0, 0, 65, 40);
		
		registrar.setIcon(iconoRegistrar);
		busqueda.setIcon(iconoBusqueda);
		
		registrar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        agregar.setVisible(true);
		        dispose(); 
		    }
		});
		
		busqueda.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        buscador.setVisible(true);
		        dispose(); 
		    }
		});
		panelRegistro.add(registrar);
		panelBusqueda.add(busqueda);
		
		JLabel informacion;
		JLabel bienvenido;
		
		Calendar calendario = Calendar.getInstance();

	        int dia = calendario.get(Calendar.DAY_OF_MONTH);
	        int mes = calendario.get(Calendar.MONTH) + 1;
	        int anio = calendario.get(Calendar.YEAR);
	        
	        
	    labelFecha = new RoundedLabel("Hora", 20, Color.WHITE, new Color(255, 255, 255, 100), 0.5f);   
		labelHora = new RoundedLabel("Hora", 20, Color.WHITE, new Color(255, 255, 255, 100), 0.5f);
		bienvenido = new RoundedLabel("Bienvenido", 20, Color.WHITE, new Color(255, 255, 255, 100), 0.5f);
		labelFecha.setText(""+dia+" - "+ mes +" - "+anio);
		String texto = "<html><body>Sistema de reserva de hotel. Controle y administre de forma óptima y fácil el flujo de reservas y de huespedes del hotel <br> Esta herramienta le permitirá llevar un control completo y detallado de sus reservas y huéspedes, tendrá acceso a heramientas especiales para tareas especificas como lo son: <br><br> - Registro de Reservas y Huéspedes <br> - Edición de Reservas y Huéspedes existentes <br> - Eliminar todo tipo de registros</body></html>";
	  
				
		informacion = new RoundedLabel("algo"	, 20, Color.WHITE, new Color(255, 255, 255, 100), 0.5f);
		informacion.setText(texto);
		informacion.setVerticalAlignment(SwingConstants.TOP);
		informacion.setHorizontalAlignment(SwingConstants.LEFT);
		informacion.setBounds(50, 210, 400, 250);
		informacion.setPreferredSize(new Dimension(400, 200));
				
		bienvenido.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		bienvenido.setBounds(50, 160, 400, 40);
		bienvenido.setForeground(Color.WHITE);
		informacion.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		informacion.setForeground(Color.WHITE);
		
		textReg.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textReg.setBounds(495, 225, 400, 40);
		textReg.setForeground(Color.WHITE);
		
		textBus.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		textBus.setBounds(625, 215, 400, 40);
		textBus.setForeground(Color.WHITE);
		
		labelFecha.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		labelFecha.setForeground(Color.WHITE);
		labelFecha.setBounds(620, 10, 200, 60);
		
		labelHora.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		labelHora.setForeground(Color.WHITE);
		labelHora.setBounds(500, 10, 100, 60);
		
		panelRegistro.setBounds(450, 150, 180, 180);
		panelBusqueda.setBounds(580, 150, 180, 180);
		
		JLabel alura = new JLabel("Alura ONE 2023");
		alura.setBounds(15, 475, 400, 20);
		alura.setForeground(Color.WHITE);
		contentPane.add(alura);
		
		contentPane.add(textBus);
		contentPane.add(textReg);
		contentPane.add(panelBusqueda);
		contentPane.add(panelRegistro);
		contentPane.add(labelFecha);
		contentPane.add(labelHora);
		contentPane.add(estrellas);
		contentPane.add(bienvenido);
		contentPane.add(informacion);
		contentPane.add(hotelNombre);
		contentPane.add(hotelLogo);
		contentPane.add(closeButton);
		contentPane.add(edificio);
		contentPane.add(estrella);
		
		setResizable(false);
		
		  new Thread(() -> {
	            while (true) {
	                actualizarHora();
	                try {
	                    Thread.sleep(1000);
	                } catch (InterruptedException ex) {
	                    ex.printStackTrace();
	                }
	            }
	        }).start();
		
	
		setContentPane(contentPane);
	}

	 private void actualizarHora() {
	        Date horaActual = new Date();

	        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");

	        String horaFormateada = formatoHora.format(horaActual);

	        SwingUtilities.invokeLater(() -> {
	            labelHora.setText(horaFormateada);
	        });
	    }
}
