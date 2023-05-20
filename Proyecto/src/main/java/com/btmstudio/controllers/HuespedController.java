package com.btmstudio.controllers;


import java.time.LocalDate;
import java.util.List;

import com.btmstudio.connection.PoolConnection;
import com.btmstudio.models.Huesped;
import com.btmstudio.services.DbHuesped;

public class HuespedController {
	
	private final DbHuesped huesped;

	public HuespedController() {
		this.huesped = new DbHuesped(new PoolConnection().recuperateConnection());
	}
	
	
	public List<Huesped> listar() {
		return huesped.listar();
	}
	
	public void guardar(Huesped usuario) {
    	huesped.guardar(usuario);
	}

	public int modificar(Integer id, int numeroIdentidad, String nombre,  String apellido, LocalDate fecha_nac, String nacionalidad, int telefono)  {
		return huesped.modificar(id, numeroIdentidad, nombre, apellido, fecha_nac,  nacionalidad, telefono);
	}

	public int eliminar(Integer id) {
		return huesped.eliminar(id);
	}
	
	public List<Huesped> buscarHuesped(String clave) {
		return huesped.buscar(clave);
	}
}
