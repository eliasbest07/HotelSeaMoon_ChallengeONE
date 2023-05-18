package hote_seamoon.views;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import  hote_seamoon.utils.Credentials;
import hote_seamoon.widgets.ButtonRoom;
import hote_seamoon.widgets.RoundButtonAccion;
import hote_seamoon.widgets.RoundedButton;
import hote_seamoon.widgets.RoundedComboBox;
import hote_seamoon.widgets.RoundedLabel;
import hote_seamoon.widgets.RoundedPanel;
import hote_seamoon.widgets.RoundedTextField;

import java.time.temporal.ChronoUnit;


public class ReservaView extends JFrame {

	private JPanel contentPane;
	private RoundedButton closeButton;
	private JLabel mapa;
	private JLabel labelFecha;
	private JLabel nombreHotel;
	private JLabel logoHotel;
	private HomeView main;
	private List<ButtonRoom> room;
	private ButtonRoom disponible;
	private ButtonRoom ocupada;
	private ButtonRoom selecionada;
	private RoundedComboBox fechaIngresoAnio;
	private RoundedComboBox fechaIngresoMes;
	private RoundedComboBox fechaIngresoDia;
	private RoundedComboBox fechaSalidaAnio;
	private RoundedComboBox fechaSalidaMes;
	private RoundedComboBox fechaSalidaDia;
	private RoundedComboBox nacimientoAnio;
	private RoundedComboBox nacimientoMes;
	private RoundedComboBox nacimientoDia;
	private RoundedComboBox formadePago;
	private RoundedTextField valorNoche;
	//private JDateChooser fechaNacimiento;
	private RoundButtonAccion registrar;
	private RoundedTextField nombreCliente;
	private RoundedTextField apellidoCliente;

	private RoundedTextField numeroIdCliente;
	private RoundedTextField numeroPersona;
	private RoundedTextField numeroNinios;
	
	private RoundedTextField telefonoCliente;
	private RoundedComboBox nacionalidadCliente;
	
	
	
	
	
	public ReservaView(HomeView entrada) {
		this.main=entrada;
		setTitle("Agregar Reservas");
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(220, 100, 850, 500);
		contentPane = new RoundedPanel(30, new Color(0xeef4d0),new Color(0xf88887), true);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		ImageIcon plano = new ImageIcon(getClass().getResource("../assets/planohotel.png"));
		ImageIcon hotellogo = new ImageIcon(getClass().getResource("../assets/hotelnombre.png"));
		ImageIcon logo = new ImageIcon(getClass().getResource("../assets/hotelseamoon.png"));
		
		nombreHotel= new JLabel(hotellogo);
		logoHotel= new JLabel();
		labelFecha = new RoundedLabel("Hora", 20, Color.WHITE, new Color(255, 255, 255, 100), 0.5f);

		Image imagenOriginal = logo.getImage();
		Image imagenEscalada = imagenOriginal.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
		ImageIcon iconEscalado = new ImageIcon(imagenEscalada);

		logoHotel.setIcon(iconEscalado);
		
		registrar = new RoundButtonAccion( "✔", 25,new Color(192, 192, 192,100),new Color(138, 146, 255,200),0.5f);
		registrar.setFont(new Font("", Font.PLAIN, 24));
		String[] datos = {"2023", "2024", "2025"};
		
		String[] meses = {"enero", "febrero", "marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"};
		String[] dias =   {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17"};
		String[] metodosPago = {"Tarjeta de Crédito","Tarjeta de Débito","Dinero en efectivo"};
		 String[] nacionalidad = {"afgano-afgana", "alemán-", "alemana", "árabe-árabe", "argentino-argentina", "australiano-australiana", "belga-belga", "boliviano-boliviana", "brasileño-brasileña", "camboyano-camboyana", "canadiense-canadiense", "chileno-chilena", "chino-china", "colombiano-colombiana", "coreano-coreana", "costarricense-costarricense", "cubano-cubana", "danés-danesa", "ecuatoriano-ecuatoriana", "egipcio-egipcia", "salvadoreño-salvadoreña", "escocés-escocesa", "español-española", "estadounidense-estadounidense", "estonio-estonia", "etiope-etiope", "filipino-filipina", "finlandés-finlandesa", "francés-francesa", "galés-galesa", "griego-griega", "guatemalteco-guatemalteca", "haitiano-haitiana", "holandés-holandesa", "hondureño-hondureña", "indonés-indonesa", "inglés-inglesa", "iraquí-iraquí", "iraní-iraní", "irlandés-irlandesa", "israelí-israelí", "italiano-italiana", "japonés-japonesa", "jordano-jordana", "laosiano-laosiana", "letón-letona", "letonés-letonesa", "malayo-malaya", "marroquí-marroquí", "mexicano-mexicana", "nicaragüense-nicaragüense", "noruego-noruega", "neozelandés-neozelandesa", "panameño-panameña", "paraguayo-paraguaya", "peruano-peruana", "polaco-polaca", "portugués-portuguesa", "puertorriqueño-puertorriqueño", "dominicano-dominicana", "rumano-rumana", "ruso-rusa", "sueco-sueca", "suizo-suiza", "tailandés-tailandesa", "taiwanes-taiwanesa", "turco-turca", "ucraniano-ucraniana", "uruguayo-uruguaya", "venezolano-venezolana", "vietnamita-vietnamita"};
		formadePago= new RoundedComboBox(20);
		fechaIngresoAnio = new RoundedComboBox(20);
		fechaIngresoMes=new RoundedComboBox(20);
		fechaIngresoDia=new RoundedComboBox(20);
		
		fechaSalidaAnio = new RoundedComboBox(20);
		fechaSalidaMes = new RoundedComboBox(20);
		fechaSalidaDia = new RoundedComboBox(20);
		
		nacimientoAnio = new RoundedComboBox(7);
		nacimientoMes = new RoundedComboBox(7);
		nacimientoDia = new RoundedComboBox(7);
		nacimientoMes.setDatos(meses);
		
		valorNoche = new RoundedTextField(10, Color.WHITE, new Color(255, 255, 255, 128), 0.5f);
		nombreCliente  = new RoundedTextField(10, Color.WHITE, new Color(255, 255, 255, 128), 0.5f);
		apellidoCliente  = new RoundedTextField(10, Color.WHITE, new Color(255, 255, 255, 128), 0.5f);
		numeroIdCliente  = new RoundedTextField(10, Color.WHITE, new Color(255, 255, 255, 128), 0.5f);
		numeroPersona  = new RoundedTextField(10, Color.WHITE, new Color(255, 255, 255, 128), 0.5f);
		numeroNinios  = new RoundedTextField(10, Color.WHITE, new Color(255, 255, 255, 128), 0.5f);
		telefonoCliente  = new RoundedTextField(10, Color.WHITE, new Color(255, 255, 255, 128), 0.5f);
		nacionalidadCliente = new RoundedComboBox(20);
		
		disponible = new ButtonRoom("",4,Color.blue,Color.black,0.1f);
		ocupada = new ButtonRoom("x",4,Color.blue,Color.black,0.1f); 
		selecionada = new ButtonRoom(".",4,Color.blue,Color.black,0.1f); 
		disponible.setBounds(675, 80,10,10);
		ocupada.setBounds(675, 100,10,10);
		selecionada.setBounds(675, 120,10,10);
		
		formadePago.setDatos(metodosPago);
		fechaIngresoMes.setDatos(meses);
		fechaIngresoAnio.setDatos(datos);
		
		fechaSalidaDia.setDatos(dias);
		fechaSalidaMes.setDatos(meses);
		fechaSalidaAnio.setDatos(datos);
		
		
		fechaIngresoAnio.setPreferredSize(new Dimension(200, 30));
		
		String[] anios = new String[0];
        List<String> listaAnios = new ArrayList<>(Arrays.asList(anios));
		for(int i=1;i<=100 ;i++) {
			int nanio= 1922+i;
			listaAnios.add(""+nanio);
		}
		anios = listaAnios.toArray(new String[0]);

        nacimientoAnio.setDatos(anios);
		
		nacionalidadCliente.setDatos(nacionalidad);
		nacionalidadCliente.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		
		room= new ArrayList<>();
		
		for(int i=0; i<32;i++) {
			ButtonRoom addroom = new ButtonRoom("",7,Color.blue,Color.black,0.1f);
			room.add(addroom);
		}
		
				
		mapa= new JLabel(plano);
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
		
		mapa.setBounds(400, 80,400, 300);
		room.get(0).setBounds(444, 145,30,30);
		room.get(0).setText("x");
		room.get(1).setBounds(475, 145,30,30);
		room.get(2).setBounds(506, 145,30,30);
		room.get(3).setBounds(538, 145,30,30);
		room.get(4).setBounds(570, 145,30,30);
		room.get(5).setBounds(602, 145,30,30);
		room.get(6).setBounds(634, 145,30,30);
		room.get(7).setBounds(664, 145,30,30);
		room.get(8).setBounds(695, 145,30,30);
		room.get(9).setBounds(726, 145,30,30);
		
		room.get(10).setBounds(444, 190,30,30);
		room.get(11).setBounds(475, 190,30,30);
		room.get(12).setBounds(506, 190,30,30);
		
		room.get(13).setBounds(664, 190,30,30);
		room.get(14).setBounds(695, 190,30,30);
		room.get(15).setBounds(726, 190,30,30);

		room.get(16).setBounds(444, 274,30,30);
		room.get(17).setBounds(475, 274,30,30);
		room.get(18).setBounds(506, 274,30,30);
		
		room.get(19).setBounds(664, 274,30,30);
		room.get(20).setBounds(695, 274,30,30);
		room.get(21).setBounds(726, 274,30,30);
		
		room.get(22).setBounds(444, 318,30,30);
		room.get(23).setBounds(475, 318,30,30);
		room.get(24).setBounds(506, 318,30,30);
		room.get(25).setBounds(538, 318,30,30);
		room.get(26).setBounds(570, 318,30,30);
		room.get(27).setBounds(602, 318,30,30);
		room.get(28).setBounds(634, 318,30,30);
		room.get(29).setBounds(664, 318,30,30);
		room.get(30).setBounds(695, 318,30,30);
		room.get(31).setBounds(726, 318,30,30);
		
		for(int i=0;i<32;i++) {
			 final int index = i;
			    room.get(i).addActionListener(new ActionListener() {
			        public void actionPerformed(ActionEvent e) {
			        	if(room.get(index).getText() != "x") {
				        	if(room.get(index).getText() == ".") {
				        		room.get(index).setText(""); 	
				        	}else {
				        		room.get(index).setText("."); 			        		
				        	}
			        	}
			        }
			    });
		}
		
		for(int i=0;i<32;i++) {
			contentPane.add(room.get(i));
		}
		
		formadePago.setBounds(195, 285,210,40);
		formadePago.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		fechaIngresoDia.setBounds(40, 145,70,40);
		fechaIngresoMes.setBounds(130, 145,160,40);
		fechaIngresoAnio.setBounds(306, 145,100,40);
		fechaIngresoAnio.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		fechaIngresoDia.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		fechaIngresoMes.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		
		fechaSalidaDia.setBounds(40, 215,70,40);
		fechaSalidaMes.setBounds(130, 215,160,40);
		fechaSalidaAnio.setBounds(306, 215,100,40);
		fechaSalidaAnio.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		fechaSalidaDia.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		fechaSalidaMes.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		
		valorNoche.setBounds(40, 285,100,40);
		
		Calendar calendario = Calendar.getInstance();

        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH) + 1;
        int anio = calendario.get(Calendar.YEAR);
        
        fechaIngresoMes.setSelectedIndex(mes-1);
        fechaSalidaMes.setSelectedIndex(mes-1);
        
        asignarDiadelMes(mes,anio);
        
        fechaIngresoDia.setSelectedIndex(dia-1);
        fechaSalidaDia.setSelectedIndex(dia-1);
        
        
        labelFecha.setText("Hoy es "+obtenerNombreDia(dia,mes,anio)+" " +dia+" - "+ mes +" - "+anio);
        labelFecha.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		labelFecha.setForeground(Color.BLACK);
		labelFecha.setBounds(420, 10, 400, 60);
		nombreHotel.setBounds(80, 5, 400, 100);
		logoHotel.setBounds(77, 15, 100, 100);
		
		nombreCliente.setBounds(40, 370, 180, 40);
		apellidoCliente.setBounds(40, 440, 180, 40);
		numeroIdCliente.setBounds(250, 370, 180, 40);
		
		
		telefonoCliente.setBounds(460, 370, 210, 40);
		nacionalidadCliente.setBounds(460, 440, 210, 40);
		registrar.setBounds(720, 380, 80, 80);
		
		nacimientoAnio.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		nacimientoMes.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		nacimientoDia.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		nacimientoDia.setBounds(240, 440, 60, 30);
		nacimientoMes.setBounds(300, 440, 130, 30);
		nacimientoAnio.setBounds(300, 465, 70, 30);
		
		JLabel lbl1 = new JLabel("FECHA DE CHECK IN");
		JLabel lbl2 = new JLabel("FECHA DE CHECK OUT");
		JLabel lbl3 = new JLabel("VALOR POR NOCHE");
		JLabel lbl4 = new JLabel("FORMA DE PAGO");
		JLabel lbl5 = new JLabel("SELECIONAR HABITACIONES");
		JLabel lbl6 = new JLabel("DISPONIBLE");
		JLabel lbl7 = new JLabel("OCUPADA");
		JLabel lbl8 = new JLabel("SELECCIONADA");
		JLabel lbl9 = new JLabel("DATOS DEL CLIENTE");
		JLabel lbl10 = new JLabel("NOMBRE");
		JLabel lbl11 = new JLabel("APELLIDO");
		JLabel lbl12 = new JLabel("NUMERO DE IDENTIFICACION");
		JLabel lbl13 = new JLabel("FECHA DE NACIMIENTO");
		JLabel lbl14 = new JLabel("TELEFONO");
		JLabel lbl15 = new JLabel("SISTEMA DE RESERVAS");
		JLabel lbl16 = new JLabel("NACIONALIDAD");
		
		lbl1.setBounds(30, 90, 200, 80);
		lbl2.setBounds(30, 160, 200, 80);
		lbl3.setBounds(30, 230, 200, 80);
		lbl4.setBounds(300, 230, 200, 80);
		lbl5.setBounds(440, 50, 200, 80);
		lbl6.setBounds(690, 45, 200, 80);
		lbl7.setBounds(690, 65, 200, 80);
		lbl8.setBounds(690, 85, 200, 80);
		lbl9.setBounds(30, 300, 200, 80);
		lbl10.setBounds(30, 320, 200, 80);
		lbl11.setBounds(240, 320, 200, 80);
		lbl12.setBounds(450, 320, 200, 80);
		lbl13.setBounds(240, 390, 200, 80);
		lbl14.setBounds(30, 390, 200, 80);
		lbl15.setBounds(260, 80, 200, 80);
		lbl16.setBounds(450, 390, 200, 80);
		
		JLabel alura = new JLabel("Alura ONE 2023");
		alura.setBounds(15, 478, 400, 20);
		contentPane.add(alura);
		
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
		contentPane.add(lbl11);
		contentPane.add(lbl12);
		contentPane.add(lbl13);
		contentPane.add(lbl14);
		contentPane.add(lbl15);
		contentPane.add(lbl16);
		contentPane.add(nacimientoDia);
		contentPane.add(nacimientoMes);
		contentPane.add(nacimientoAnio);
		contentPane.add(registrar);
		contentPane.add(disponible);
		contentPane.add(ocupada);
		contentPane.add(selecionada);
		contentPane.add(nombreCliente);
		contentPane.add(apellidoCliente);
		contentPane.add(numeroIdCliente);
		contentPane.add(telefonoCliente);
		contentPane.add(nacionalidadCliente);
		contentPane.add(formadePago);
		contentPane.add(logoHotel);
		contentPane.add(nombreHotel);
		contentPane.add(labelFecha);
		contentPane.add(valorNoche);
		contentPane.add(fechaSalidaDia);
		contentPane.add(fechaSalidaMes);
		contentPane.add(fechaSalidaAnio);
		contentPane.add(fechaIngresoMes);
		contentPane.add(fechaIngresoDia);
		contentPane.add(fechaIngresoAnio);
		contentPane.add(mapa);
		contentPane.add(closeButton);
		
		Credentials cre= new Credentials();

		
		  System.out.println(cre.getManagerPassword()); 
		  
		//String date1 = "2023-02-01";
      //  String date2 = "2023-01-10";
       // long daysBetween = calculateDays(date1, date2);
      //  System.out.println("Days between: " + daysBetween);

		setContentPane(contentPane);
	}

	private int ultimoDia(int mes, int anio) {
        LocalDate fecha = LocalDate.of(anio, mes, 1).plusMonths(1).minusDays(1);
        return fecha.getDayOfMonth();
    }
	private String obtenerNombreDia(int dia, int mes, int anio) {
        LocalDate fecha = LocalDate.of(anio, mes, dia);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("EEEE", Locale.getDefault());
        return fecha.format(formato);
    }
	private void asignarDiadelMes(int mes, int anio) {
		String[] dias = new String[0];
	        List<String> listaDias = new ArrayList<>(Arrays.asList(dias));
			for(int i=1;i<=ultimoDia(mes,anio) ;i++) {
				listaDias.add(""+i);
			}
	        dias = listaDias.toArray(new String[0]);

	        fechaIngresoDia.setDatos(dias);
	        fechaSalidaDia.setDatos(dias);
	}
	private long calculateDays(String date1, String date2) {
        LocalDate localDate1 = LocalDate.parse(date1);
        LocalDate localDate2 = LocalDate.parse(date2);

        long days = ChronoUnit.DAYS.between(localDate1, localDate2);
        return days;
    }
}
