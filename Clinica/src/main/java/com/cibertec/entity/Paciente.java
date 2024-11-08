package com.cibertec.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String direccion;

	private String telefono;
    private String email;
    private String historialOdontologico;
    private String alergias;
    private String tratamientosPrevios;

    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHistorialOdontologico() {
		return historialOdontologico;
	}
	public void setHistorialOdontologico(String historialOdontologico) {
		this.historialOdontologico = historialOdontologico;
	}
	public String getAlergias() {
		return alergias;
	}
	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}
	public String getTratamientosPrevios() {
		return tratamientosPrevios;
	}
	public void setTratamientosPrevios(String tratamientosPrevios) {
		this.tratamientosPrevios = tratamientosPrevios;
	}
}
