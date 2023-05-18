package hote_seamoon.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.table.DefaultTableModel;

import hote_seamoon.widgets.RoundedButton;
import hote_seamoon.widgets.RoundedButtonOpcion;
import hote_seamoon.widgets.RoundedPanel;
import hote_seamoon.widgets.RoundedTextField;

import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

public class SearchView extends JFrame {

	private JPanel contentPane;
	private RoundedButton closeButton;
	private HomeView main;
	private JLabel nombreHotel;
	private JLabel logoHotel;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloHuesped;
	private JTable tbReservas;
	private JTable tbHuespedes;
	private RoundedTextField buscar;
	
	

	public SearchView(HomeView entrada) {
		this.main=entrada;
		setTitle("Buscar Reservas y Huespedes");
		setUndecorated(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(220, 100, 850, 500);
		contentPane = new RoundedPanel(30, new Color(0x044772),new Color(0xa0eacf), false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		closeButton = new RoundedButton(15);
		closeButton.setBounds(0, 0,75, 40);
		closeButton.setText("☚");
		closeButton.setFont(new Font("Agency FB", Font.BOLD, 26));
		closeButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        dispose();
		       main.setVisible(true);
		    }
		});
		
		ImageIcon hotellogo = new ImageIcon(getClass().getResource("../assets/hotelnombre.png"));
		ImageIcon logo = new ImageIcon(getClass().getResource("../assets/hotelseamoon.png"));
		
		nombreHotel= new JLabel(hotellogo);
		logoHotel= new JLabel();
		Image imagenOriginal = logo.getImage();
		Image imagenEscalada = imagenOriginal.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon iconEscalado = new ImageIcon(imagenEscalada);
		logoHotel.setIcon(iconEscalado);
		
		nombreHotel.setBounds(480, 5, 400, 100);
		logoHotel.setBounds(477, 15, 100, 100);
		
		buscar = new RoundedTextField(10, Color.WHITE, new Color(255, 255, 255, 128), 0.5f);
		RoundedButtonOpcion iniciarBusqueda = new RoundedButtonOpcion(25,new Color(0x54d3fc),new Color(0x547ffc));
		iniciarBusqueda.setText("Buscar");
		RoundedButtonOpcion mostrar = new RoundedButtonOpcion(25,new Color(0x54d3fc),new Color(0x547ffc));
		mostrar.setText("Mostrar todo");
		RoundedButtonOpcion editar = new RoundedButtonOpcion(25,new Color(0x54d3fc),new Color(0x547ffc));
		editar.setText("Editar");
		RoundedButtonOpcion eliminar = new RoundedButtonOpcion(25,new Color(0x54d3fc),new Color(0x547ffc));
		eliminar.setText("Eliminar");
		
		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(57,121,133));
		
		panel.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		panel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panel.setBounds(15, 130, 820, 300);
		
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel.setBackground(new Color(163,233,207));
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 panel.setBackground(new Color(57,121,133));
			}
		});
		
		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		tbReservas.setBackground(new Color(245,245,220));
		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Fecha Check In");
		modelo.addColumn("Fecha Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pago");
		// cargarTablaReservas();
		JScrollPane scroll_table = new JScrollPane(tbReservas);
		panel.addTab("Reservas", new ImageIcon("src/main/resources/imagenes/reservado.png"), scroll_table, null);
		scroll_table.setVisible(true);
		
		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		tbHuespedes.setBackground(new Color(245,245,220));
		modeloHuesped = (DefaultTableModel) tbHuespedes.getModel();
		modeloHuesped.addColumn("Número de Huesped");
		modeloHuesped.addColumn("Nombre");
		modeloHuesped.addColumn("Apellido");
		modeloHuesped.addColumn("Fecha de Nacimiento");
		modeloHuesped.addColumn("Nacionalidad");
		modeloHuesped.addColumn("Telefono");
		modeloHuesped.addColumn("Número de Reserva");
		//cargarTablaHuespedes();
		JScrollPane scroll_tableHuespedes = new JScrollPane(tbHuespedes);
		panel.addTab("Huéspedes", new ImageIcon("src/main/resources/imagenes/pessoas.png"), scroll_tableHuespedes, null);
		scroll_tableHuespedes.setVisible(true);
		
		buscar.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		buscar.setBounds(50, 70, 200, 40);
		iniciarBusqueda.setBounds(265, 70, 120, 40);
		iniciarBusqueda.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		mostrar.setBounds(265, 440, 200, 40);
		editar.setBounds(485, 440, 140, 40);
		eliminar.setBounds(645, 440, 140, 40);
		mostrar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		editar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		eliminar.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		
		JLabel lbl1 = new JLabel("SISTEMA DE BÚSQUEDA");
		JLabel lbl2 = new JLabel("NÚMERO DE RESERVA O NÚMERO DE IDENTIDAD DEL HUÉSPED");
		lbl1.setBounds(310, 10, 140, 40);
		lbl2.setBounds(55, 35, 400, 40);
		
		JLabel alura = new JLabel("Alura ONE 2023");
		alura.setBounds(15, 475, 400, 20);
		alura.setForeground(Color.WHITE);
		contentPane.add(alura);
		
		contentPane.add(panel);
		contentPane.add(lbl1);
		contentPane.add(lbl2);
		contentPane.add(iniciarBusqueda);
		contentPane.add(mostrar);
		contentPane.add(editar);
		contentPane.add(eliminar);
		contentPane.add(buscar);
		contentPane.add(logoHotel);
		contentPane.add(nombreHotel);
		contentPane.add(closeButton);
		
		setContentPane(contentPane);
	}

}
