package com.btmstudio.controllers;

import java.time.LocalDate;
import java.util.List;

import com.btmstudio.services.DbReservas;
import com.btmstudio.models.Reserva;
import com.btmstudio.connection.PoolConnection;

public class ReservaController {
	
	private final DbReservas reservas;

	public ReservaController() {
		this.reservas = new DbReservas(new PoolConnection().recuperateConnection());
	}

	public List<Reserva> listar() {
		return reservas.listarReservas();
	}
	
	public void guardar(Reserva reserva) {
    	reservas.agregarReserva(reserva);
	}

	public int modificar(Integer id, LocalDate fechaEntrada, LocalDate fechaSalida, Double valor, String formaDePago)  {
		return reservas.modificarReserva(id, fechaEntrada, fechaSalida, valor,  formaDePago);
	}

	public int eliminar(Integer id) {
		return reservas.eliminarReserva(id);
	}

	public List<Reserva> buscarReserva(String clave) {
		return reservas.buscarReserva(clave);
	}
}