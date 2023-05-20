package com.btmstudio.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.btmstudio.widgets.RoundedButton;
import com.btmstudio.widgets.RoundedButtonOpcion;
import com.btmstudio.widgets.RoundedPanel;
import com.btmstudio.widgets.RoundedTextField;

import javax.swing.JTabbedPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

import com.btmstudio.utils.DataBase;
import com.btmstudio.models.Huesped;
import com.btmstudio.models.Reserva;

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
	private DataBase db;
	
	

	public SearchView(HomeView entrada) throws Exception {
		this.main=entrada;
		db= new DataBase();
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
		

		ImageIcon	hotellogo = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("hotelnombre.png")));
		ImageIcon	logo = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("hotelseamoon.png")));
		ImageIcon	icono = new ImageIcon(ImageIO.read(getClass().getClassLoader().getResourceAsStream("icono.png")));
		
		
		setIconImage(icono.getImage());
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
		modelo.addColumn("Habitacion");
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
		modeloHuesped.addColumn("Identificación del Huesped");
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
		
		cargarTablaReservas();
		cargarTablaHuespedes();
		
		editar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	 int numeroPanel = panel.getSelectedIndex();
		         if(numeroPanel == 0) {
		         	modificarReserva();
		         	limpiarTablaR();
		         	cargarTablaReservas();
		         } else if(numeroPanel == 1){
		         	modificarHuesped();
		         	limpiarTablaH();
		         	cargarTablaHuespedes();
		         }
		    }
		});
		
		eliminar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	  int numeroPanel = panel.getSelectedIndex();
	                if(numeroPanel == 0) {
	                	eliminarReserva();
	                	limpiarTablaR();
	                	cargarTablaReservas();
	                } else if(numeroPanel == 1){
	                	eliminarHuesped();
	                	limpiarTablaH();
	                	cargarTablaHuespedes();
	                }
		    }
		});
		
		mostrar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       	if(panel.getSelectedIndex() == 0){
					limpiarTablaR();
				  	cargarTablaReservas();
            	
            } else if(panel.getSelectedIndex() == 1) {
					limpiarTablaH();
			      	cargarTablaHuespedes();
            }
		    }
		});
		
		iniciarBusqueda.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	if(panel.getSelectedIndex() == 0){
					limpiarTablaR();
            		buscarReservas(buscar.getText());
            } else if(panel.getSelectedIndex() == 1) {
					limpiarTablaH();
					buscarHuespedes(buscar.getText());
            }
		    }
		});
		
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
	public void cargarTablaReservas() {
        List<Reserva> reservas = db.listarReservas();
        reservas.forEach(reserva -> modelo.addRow(
        		new Object[]{ 
        				reserva.getId(), 
        				reserva.getFechaEntrada(), 
        				reserva.getFechaSalida(),
        				reserva.getValor(),
        				reserva.getHabitaciones(),
        				reserva.getFormaDePago()
	        		}
        		));
    }
	
	public void cargarTablaHuespedes() {
		 List<Huesped> huespedes = db.listar();
        huespedes.forEach(huesped -> modeloHuesped.addRow(
        		new Object[]{ 
        				huesped.getNumeroIdentidad(), 
        				huesped.getNombre(), 
        				huesped.getApellido(), 
        				huesped.getFechaNacimiento(),
        				huesped.getNacionalidad(),
        				huesped.getTelefono(),
        				huesped.getNumeroReservas()
	        		}
        		));
    }
	
	private void modificarHuesped() {
        if (filaElegidaHuesped()) {
            JOptionPane.showMessageDialog(this, "Por favor, elija un huésped");
            return;
        }

        Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
                .ifPresentOrElse(fila -> {
                    Integer id = Integer.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
                    String nombre = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 1);
                    String apellido = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 2);
                    LocalDate fechaNac = LocalDate.parse(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 3).toString());
                    String nacionalidad = (String) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 4);
                    int telefono = (int) modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 5);
					
					var filaModificadas = db.modificar(id, nombre, apellido, fechaNac, nacionalidad, telefono);
					
					JOptionPane.showMessageDialog(this, filaModificadas + " Item modificado con éxito!");
                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
    }

	private void modificarReserva() {
        if (filaElegidaReserva()) {
            JOptionPane.showMessageDialog(this, "Por favor, elije un item");
            return;
        }

        Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
                .ifPresentOrElse(fila -> {
                    Integer id = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
                    LocalDate fechaEntrada = LocalDate.parse(modelo.getValueAt(tbReservas.getSelectedRow(), 1).toString());
                    LocalDate fechaSalida = LocalDate.parse(modelo.getValueAt(tbReservas.getSelectedRow(), 2).toString());
                    Double valor = Double.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 3).toString());
                    String habitacion = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 4);
                    String formaPago = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 5);
					
					var filaModificadas = db.modificarReserva(id, fechaEntrada, fechaSalida, valor, habitacion, formaPago);
					
					JOptionPane.showMessageDialog(this, filaModificadas + " Item modificado con éxito!");
                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
    }
	
	private void eliminarReserva() {
        if (filaElegidaReserva()) {
            JOptionPane.showMessageDialog(this, "Por favor, elije un item");
            return;
        }

        Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
                .ifPresentOrElse(fila -> {
                    Integer id = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());

					var idEliminado = db.eliminarReserva(id);

                    modelo.removeRow(tbReservas.getSelectedRow());

                    JOptionPane.showMessageDialog(this, "La reserva " + idEliminado + ", fue eliminada con éxito!");
                }, () -> JOptionPane.showMessageDialog(this, "No ha seleccionado ningún campo"));
    }
	
	private boolean filaElegidaReserva() {
        return tbReservas.getSelectedRowCount() == 0 || tbReservas.getSelectedColumnCount() == 0;
    }
	
	
	
	private void eliminarHuesped() {
        if (filaElegidaHuesped()) {
            JOptionPane.showMessageDialog(this, "Por favor, elije un item");
            return;
        }

        Optional.ofNullable(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
                .ifPresentOrElse(fila -> {
                	Integer id = Integer.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
                  //  Integer id = Integer.valueOf(modeloHuesped.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());

					var huespedEliminado = db.eliminar(id+1);

                    modeloHuesped.removeRow(tbHuespedes.getSelectedRow());

                    JOptionPane.showMessageDialog(this, huespedEliminado + " huésped fue eliminado con éxito!");
                }, () -> JOptionPane.showMessageDialog(this, "Por favor. Seleccione uno en la lista"));
    }

	
	private boolean filaElegidaHuesped() {
        return tbHuespedes.getSelectedRowCount() == 0 || tbHuespedes.getSelectedColumnCount() == 0;
    }
	
	
	private void buscarHuespedes(String clave) {
		
		if(clave.equals("")) {
			JOptionPane.showMessageDialog(null, String.format("Por favor, Ingresa un valor"));
			limpiarTablaH();
			cargarTablaHuespedes();
			
		} else {
	        var huespedes = db.buscar(clave);
	        huespedes.forEach(huesped -> modeloHuesped.addRow(
	        		new Object[]{ 
	        				huesped.getNumeroIdentidad(), 
	        				huesped.getNombre(), 
	        				huesped.getApellido(), 
	        				huesped.getFechaNacimiento(),
	        				huesped.getNacionalidad(),
	        				huesped.getTelefono(),
	        				huesped.getNumeroReservas()
		        		}
	        		)
	        	);
		}
    }
	
	
	private void buscarReservas(String clave) {

		if(clave.equals("")) {
			JOptionPane.showMessageDialog(null, String.format("Por favor, Ingresa un Numero"));
			limpiarTablaR();
			cargarTablaReservas();
			
		} else {
	        var reservas = db.buscarReserva(clave);
	        reservas.forEach(reserva -> modelo.addRow(
	        		new Object[]{ 
	        				reserva.getId(), 
	        				reserva.getFechaEntrada(),
	        				reserva.getFechaSalida(), 
	        				reserva.getValor(),
	        				reserva.getFormaDePago()
		        		}
	        		)
	        	);
		}
    }
	
	private void limpiarTablaR() {
        modelo.getDataVector().clear();
    }
	
	private void limpiarTablaH() {
        modeloHuesped.getDataVector().clear();
    }
}
