package com.btmstudio.utils;

import javax.swing.JOptionPane;

import com.btmstudio.models.Huesped;
import com.btmstudio.models.Reserva;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private Connection conexion;

    public DataBase() {
        try {
   
            Class.forName("org.sqlite.JDBC");
      
            this.conexion = DriverManager.getConnection("jdbc:sqlite:hotdata.db");
    
            PreparedStatement statement1 = conexion.prepareStatement(
                "CREATE TABLE IF NOT EXISTS login (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "usuario TEXT," +
                "clave TEXT" +
                ");"
            );
            statement1.executeUpdate();
            statement1.close();
            
            PreparedStatement statement2 = conexion.prepareStatement(
                "CREATE TABLE IF NOT EXISTS huespedes (" +
                "id_huespedes INTEGER PRIMARY KEY AUTOINCREMENT," +
                "numero_identidad INTEGER,"+ 
                "nombre TEXT," +
                "apellido TEXT," +
                "fecha_nacimiento DATE," +
                "nacionalidad TEXT," +
                "telefono INTEGER,"+
                "id_reservas INTEGER"+
                ");"
            );
            statement2.executeUpdate();
            statement2.close();
            
            PreparedStatement statement3 = conexion.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS reservas (" +
                    "id_reservas INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "fecha_entrada DATE," +
                    "fecha_salida DATE," +
                    "forma_de_pago TEXT," +
                    "valor DOUBLE," +
                    "numero_habitacion TEXT" +
                    ");"
                );
                statement3.executeUpdate();
                statement3.close();
            //this.archivoCreado = true;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Problema con la base de datos. Error "+e, "Base de Datos SQLite", JOptionPane.WARNING_MESSAGE);

           // this.archivoCreado = false;
            e.printStackTrace();
        }
        // this.archivoCreado = false;
    }
    
    public boolean iniciarSesion(String usuario, String clave) {
		try {
			final PreparedStatement statement = conexion.prepareStatement("SELECT * FROM login WHERE "
					+ "usuario LIKE ? AND  clave LIKE ? ");  
			try (statement) {				
				statement.setString(1,  usuario);
				statement.setString(2, clave);
				final ResultSet rs = statement.executeQuery();
				try (rs) {
					while (rs.next()) {
						return true;
					} 
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return false;
	}
    public boolean registarFull(String gerente,String usuario, String clave){
    	try {
			final PreparedStatement statement =
					conexion.prepareStatement("INSERT INTO login"
					+ "(usuario, clave ) "
					+ "VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS);
			try (statement) {
				
				statement.setString(1, usuario);
				statement.setString(2, clave);
				

				statement.execute();
				
				final ResultSet rs = statement.getGeneratedKeys();

				try (rs) {
					while(rs.next()) {
						//System.out.println("Fue registrado el usuario");
						return true;
					}
				} catch(SQLException e) {
					return false;
					//throw new RuntimeException(e);
				}
			} catch(SQLException e) {
				return false;
				//throw new RuntimeException(e);
			}

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return false;
    	
    }
    public boolean registar(String usuario, String clave) {
    	try {
			final PreparedStatement statement =
					conexion.prepareStatement("INSERT INTO login"
					+ "(usuario, clave ) "
					+ "VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS);
			try (statement) {
				
				statement.setString(1, usuario);
				statement.setString(2, clave);
				

				statement.execute();
				
				final ResultSet rs = statement.getGeneratedKeys();

				try (rs) {
					while(rs.next()) {
						//System.out.println("Fue registrado el usuario");
						return true;
					}
				} catch(SQLException e) {
					return false;
					//throw new RuntimeException(e);
				}
			} catch(SQLException e) {
				return false;
				//throw new RuntimeException(e);
			}

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return false;
	}
	
	public boolean existeUsuario(String usuario) {
		
		try {

			final PreparedStatement statement = conexion.prepareStatement("SELECT * FROM login WHERE "
					+ "usuario LIKE ? ");  

			try (statement) {
				
				statement.setString(1,usuario);

				final ResultSet rs = statement.executeQuery();

				try (rs) {
					
					while (rs.next()) {
						return true;
					} 
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return false;
	}

	

	public List<Huesped> listar() {

		List<Huesped> lista = new ArrayList<>();
		Huesped usuario = null;

		try {

			final PreparedStatement statement = conexion.prepareStatement("SELECT * FROM huespedes");

			try (statement) {
				
				statement.execute();

				final ResultSet rs = statement.getResultSet();

				try (rs) {
					
					while (rs.next()) {
						
						Integer id = rs.getInt("id_huespedes");
						String nombre = rs.getString("nombre");
						String apellido = rs.getString("apellido");
						String nacimientoFecha = rs.getString("fecha_nacimiento");
						LocalDate fechaNacimiento = LocalDate.parse(nacimientoFecha);
						String nacionalidad = rs.getString("nacionalidad");
						Integer telefono = rs.getInt("telefono");
						Integer numeroReserva = rs.getInt("id_reservas");
						Integer numeroIdentidad = rs.getInt("numero_identidad");
						
						// Huesped(String nombre, String apellido,Integer numeroIdentidad , LocalDate fechaNacimiento, String nacionalidad, int telefono, Integer numeroReserva) {
						usuario = new Huesped(nombre, apellido,numeroIdentidad, fechaNacimiento, nacionalidad, telefono, numeroReserva);
						lista.add(usuario);
						//System.out.println(usuario);
					} 
				} catch(SQLException e) {
					throw new RuntimeException(e);
				} 
			} catch(SQLException e) {
				throw new RuntimeException(e);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}

	public int modificar(Integer id, String nombre, String apellido, LocalDate fecha_nac, String nacionalidad, int telefono) {

		try {

			final PreparedStatement statement = conexion.prepareStatement("UPDATE huespedes SET "
					+ "nombre = ? "
					+ ", apellido = ? "
					+ ", fecha_nacimiento = ? "
					+ ", nacionalidad = ? "
					+ ", telefono = ? "
					+ " WHERE id_huespedes = ? ");

			try (statement) {
				
				statement.setString(1, nombre);
				statement.setString(2, apellido);
				statement.setObject(3, fecha_nac);
				statement.setString(4, nacionalidad);
				statement.setLong(5, telefono);
				statement.setInt(6, id);

				statement.execute();

				//System.out.println("Se modificó con éxito el huesped: " + nombre);
				return statement.getUpdateCount();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	public void guardar(Huesped usuario) {

    	try {
    		// Huesped(String nombre, String apellido,Integer numeroIdentidad , LocalDate fechaNacimiento, String nacionalidad, int telefono, Integer numeroReserva) {
			final PreparedStatement statement = conexion.prepareStatement("INSERT INTO huespedes"
																+ "(nombre, apellido,numero_identidad, fecha_nacimiento, nacionalidad, telefono, id_reservas) "
																+ "VALUES (?, ?, ?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
			try (statement) {
				
				statement.setString(1, usuario.getNombre());
				statement.setString(2, usuario.getApellido());
				statement.setObject(3, usuario.getNumeroIdentidad());
				statement.setObject(4, usuario.getFechaNacimiento());
				statement.setString(5, usuario.getNacionalidad());
				statement.setLong(6, usuario.getTelefono());
				statement.setInt(7, usuario.getNumeroReservas());

				statement.execute();
				
				final ResultSet rs = statement.getGeneratedKeys();

				try (rs) {
					while(rs.next()) {
						usuario.setId(rs.getInt(1));
					//	System.out.println("Fue insertado un nuevo huesped: " + usuario);
					}
				} catch(SQLException e) {
					throw new RuntimeException(e);
				}
			} catch(SQLException e) {
				throw new RuntimeException(e);
			}

		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public int modificar(Integer id, int numeroIdentidad, String nombre, String apellido, LocalDate fecha_nac, String nacionalidad, int telefono) {

		try {

			final PreparedStatement statement = conexion.prepareStatement("UPDATE huespedes SET "
					+ "nombre = ? "
					+ ", apellido = ? "
					+ ", fecha_nacimiento = ? "
					+ ", nacionalidad = ? "
					+ ", telefono = ? "
					+ ",numero_identidad = ?"
					+ " WHERE id_huespedes = ? ");

			try (statement) {
				
				statement.setString(1, nombre);
				statement.setString(2, apellido);
				statement.setObject(3, fecha_nac);
				statement.setString(4, nacionalidad);
				statement.setInt(5, telefono);
				statement.setInt(6, numeroIdentidad);
				statement.setInt(7, id);

				statement.execute();

				//System.out.println("Se modificó con éxito el huesped: " + nombre);
				return statement.getUpdateCount();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int eliminar(Integer id) {

		try {

			final PreparedStatement statement = conexion.prepareStatement("DELETE FROM huespedes WHERE id_huespedes = ?");

			try (statement) {

				statement.setInt(1, id);
				statement.execute();

				return statement.getUpdateCount();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	// BUSCAR
	public List<Huesped> buscar(String clave) {
		
		List<Huesped> lista = new ArrayList<>();
		Huesped usuario;
		
		try {

			final PreparedStatement statement = conexion.prepareStatement("SELECT * FROM huespedes WHERE "
					+ "numero_identidad LIKE ? ");
					

			try (statement) {
				
				statement.setString(1, "%" + Integer.parseInt(clave) + "%");
			
				
				final ResultSet rs = statement.executeQuery();

				try (rs) {
					
					while (rs.next()) {
						
						Integer id = rs.getInt("id_huespedes");
						String nombre = rs.getString("nombre");
						String apellido = rs.getString("apellido");
						String nacimientoFecha = rs.getString("fecha_nacimiento");
						LocalDate fechaNacimiento = LocalDate.parse(nacimientoFecha);
						String nacionalidad = rs.getString("nacionalidad");
						int telefono = rs.getInt("telefono");
						int numeroIdentidad = rs.getInt("numero_identidad");
						Integer numeroReserva = rs.getInt("id_reservas");
						
						usuario = new Huesped(nombre, apellido,numeroIdentidad, fechaNacimiento, nacionalidad, telefono, numeroReserva);
						lista.add(usuario);
						//System.out.println(usuario);
					} 
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}
	

	public List<Reserva> listarReservas() {

		List<Reserva> lista = new ArrayList<>();
		Reserva reserva = null;

		try {

			final PreparedStatement statement = conexion.prepareStatement("SELECT * FROM reservas");

			try (statement) {
				
				statement.execute();

				final ResultSet rs = statement.getResultSet();

				try (rs) {
					
					while (rs.next()) {
						
						int id = rs.getInt("id_reservas");
						String entradaFecha = rs.getString("fecha_entrada");
						String salidaFecha = rs.getString("fecha_salida");
						LocalDate fechaEntrada = LocalDate.parse(entradaFecha);
						LocalDate fechaSalida = LocalDate.parse(salidaFecha);
						
						Double valor = rs.getDouble("valor");
						String formaDePago = rs.getString("forma_de_pago");
						String numeroHabitacion = rs.getString("numero_habitacion");
						
						reserva = new Reserva(id, fechaEntrada, fechaSalida, valor, formaDePago,numeroHabitacion);
						lista.add(reserva);
						//System.out.println(reserva);
					} 
				} catch(SQLException e) {
					throw new RuntimeException(e);
				} 
			} catch(SQLException e) {
				throw new RuntimeException(e);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return lista;
	}

	
	
	public int agregarReserva(Reserva reserva) {

    	try {

			final PreparedStatement statement = conexion.prepareStatement("INSERT INTO reservas"
																+ "(fecha_entrada, fecha_salida, valor, numero_habitacion , forma_de_pago) "
																+ "VALUES (?, ?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
			try (statement) {
				
				statement.setObject(1, reserva.getFechaEntrada());
				statement.setObject(2, reserva.getFechaSalida());
				statement.setDouble(3, reserva.getValor());
				statement.setString(4, reserva.getHabitaciones());
				statement.setString(5, reserva.getFormaDePago());

				statement.execute();
				
				final ResultSet rs = statement.getGeneratedKeys();

				try (rs) {
					while(rs.next()) {
						reserva.setId(rs.getInt(1));
					//	System.out.println("Se asgregó una nueva reserva: " + reserva);
						return rs.getInt(1);
					}
				} catch(SQLException e) {
					throw new RuntimeException(e);
				}
			} catch(SQLException e) {
				throw new RuntimeException(e);
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
    	return -1;
	}
	
	public String obtenerHabitaciones() {
		String habitaciones="";
		 List<Reserva> lista= listarReservas();
		 
		 for( Reserva hab : lista) {
			 habitaciones+=hab.getHabitaciones();
		 }
		
		return habitaciones;
	}
	
	public int modificarReserva(Integer id, LocalDate fechaEntrada, LocalDate fechaSalida, Double valor,String habitacion, String formaDePago) {

		try {

			final PreparedStatement statement = conexion.prepareStatement("UPDATE reservas SET "
					+ "fecha_entrada = ? "
					+ ", fecha_salida = ? "
					+ ", valor = ? "
					+ ", forma_de_pago = ? "
					+ ", numero_habitacion = ? "
					+ " WHERE id_reservas = ? ");

			try (statement) {
				
				statement.setObject(1, fechaEntrada);
				statement.setObject(2, fechaSalida);
				statement.setDouble(3, valor);
				statement.setString(4, formaDePago);
				statement.setString(5,habitacion);
				statement.setInt(6, id);

				statement.execute();

				//System.out.println("Se modificó la reserva!");
				return statement.getUpdateCount();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int eliminarReserva(Integer id) {

		try {

			final PreparedStatement statement = conexion.prepareStatement("DELETE FROM reservas WHERE id_reservas = ?");

			try (statement) {

				statement.setInt(1, id);
				statement.execute();

				//System.out.println("Se eliminó la reserva!");
				return statement.getUpdateCount();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	// BUSCAR
		public List<Reserva> buscarReserva(String clave) {
			
			List<Reserva> lista = new ArrayList<>();
			Reserva reserva;
			
			try {

				final PreparedStatement statement = conexion.prepareStatement("SELECT * FROM reservas WHERE "
						+ "id_reservas LIKE ?"); 

				try (statement) {
					
					statement.setString(1, "%" + Integer.parseInt(clave) + "%");
					
					
					final ResultSet rs = statement.executeQuery();

					try (rs) {
						
						while (rs.next()) {
							
							Integer id = rs.getInt("id_reservas");
							String entradaFecha = rs.getString("fecha_entrada");
							String salidaFecha = rs.getString("fecha_salida");
							LocalDate fechaEntrada = LocalDate.parse(entradaFecha);
							LocalDate fechaSalida = LocalDate.parse(salidaFecha);
							Double valor = rs.getDouble("valor");
							String formaDePago = rs.getString("forma_de_pago");
							String habitaciones = rs.getString("numero_habitacion");
							
							reserva = new Reserva(id, fechaEntrada, fechaSalida, valor, formaDePago, habitaciones);
							lista.add(reserva);
							
						} 
					}
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return lista;
		}
   
}