package com.btmstudio.models;


import java.time.LocalDate;

public class Reserva {
	private int id;
	private LocalDate fechaEntrada;
	private LocalDate fechaSalida;
	private Double valor;
	private String formaDePago;
	private String habitaciones;
	
	
	public Reserva() {
	}

	public Reserva(LocalDate fechaEntrada, LocalDate fechaSalida, Double valor, String formaDePago, String numeroHabitacion) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaDePago = formaDePago;
	}

	public Reserva(int id, LocalDate fechaEntrada, LocalDate fechaSalida, Double valor, String formaDePago, String numeroHabitacion) {
		this.id = id;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaDePago = formaDePago;
		this.habitaciones = numeroHabitacion;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}
	public String getHabitaciones() {
		return habitaciones;
	}

	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}


	public LocalDate getFechaSalida() {
		return fechaSalida;
	}


	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public String getFormaDePago() {
		return formaDePago;
	}


	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}
	public void setHabitacion(String habitacion) {
		this.habitaciones = habitacion;
	}

	@Override
	public String toString() {
		return "Reservas [ ID: " + id + ", FECHA ENTRADA: " + fechaEntrada + ", FECHA SALIDA: " + fechaSalida + ", VALOR: "
				+ valor + ", FORMA DE PAGO: " + formaDePago + " ]";
	}
	

}
