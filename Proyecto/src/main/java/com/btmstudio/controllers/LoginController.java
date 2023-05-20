package com.btmstudio.controllers;

import com.btmstudio.connection.PoolConnection;
import com.btmstudio.services.DbLogin;

public class LoginController {
	
	DbLogin login;
	
	public LoginController() {
		login= new DbLogin(new PoolConnection().recuperateConnection());
	}
	
	public boolean inicioSesion(String usuario, String clave) {
		
		return false;
	}
	public boolean registrar(String claveGerente, String usuario, String clave) {
		
		
		return false;
	}
	
	public boolean usuarioExiste(String usuario ) {
		
		return false;
	}
	
}
