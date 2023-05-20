package com.btmstudio.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DbLogin {

		Connection con;
	
	public DbLogin(Connection con) {
		this.con = con;
	}
	public boolean iniciarSesion(String usuario, String clave) {
		
		try {

			final PreparedStatement statement = con.prepareStatement("SELECT * FROM login WHERE "
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
	public boolean registar(String usuario, String clave) {
    	try {
			final PreparedStatement statement =
					con.prepareStatement("INSERT INTO login"
					+ "(usuario, clave ) "
					+ "VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS);
			try (statement) {
				
				statement.setString(1, usuario);
				statement.setString(2, clave);
				

				statement.execute();
				
				final ResultSet rs = statement.getGeneratedKeys();

				try (rs) {
					while(rs.next()) {
						System.out.println("Fue registrado el usuario");
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

			final PreparedStatement statement = con.prepareStatement("SELECT * FROM login WHERE "
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
	
}
