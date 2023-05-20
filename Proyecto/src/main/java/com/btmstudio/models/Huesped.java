package com.btmstudio.models;


import java.time.LocalDate;

public class Huesped {
	private Integer id;
	private Integer numeroIdentidad;
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private String nacionalidad;
	private int telefono;
	private Integer numeroReservas;
	
	
	public Huesped() {
	}

	public Huesped(String nombre, String apellido,Integer numeroIdentidad , LocalDate fechaNacimiento, String nacionalidad, int telefono, Integer numeroReserva) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.numeroReservas = numeroReserva;
		this.numeroIdentidad = numeroIdentidad;
	}


	public Integer getId() {
		return id;
	}

	public Integer getNumeroIdentidad() {
		return numeroIdentidad;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNumeroIdentidad(Integer id) {
		this.numeroIdentidad = id;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Integer getNumeroReservas() {
		return numeroReservas;
	}

	public void setNumeroReservas(Integer numeroReservas) {
		this.numeroReservas = numeroReservas;
	}


	@Override
	public String toString() {
		return "ID: " + numeroIdentidad + ", NOMBRE: " + nombre + ", APELLIDO: " + apellido + ", FECHA-NAC: "
				+ fechaNacimiento + ", NACIONALIDAD: " + nacionalidad + ", TELEFONO: " + telefono + ", N° RESERVA: "
				+ numeroReservas + "]";
	}
	
	
}