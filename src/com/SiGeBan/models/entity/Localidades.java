package com.SiGeBan.models.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Localidades implements Serializable {
	// propiedades
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLocalidad;
	private String localidad;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "provincia")
	private Provincias provincia;

	// constructor
	public Localidades() {
	}

	public Localidades(String localidad,Provincias provincia) {
		super();
		this.localidad = localidad;
		this.provincia = provincia;
	}

	// metodos
	public int getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public Provincias getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincias provincia) {
		this.provincia = provincia;
	}

	public String getCiudad() {
		return localidad;
	}

	public void setCiudad(String ciudad) {
		this.localidad = ciudad;
	}

	@Override
	public String toString() {
		return "Localidades [idLocalidad=" + idLocalidad + ", ciudad=" + localidad + "]";
	}

}