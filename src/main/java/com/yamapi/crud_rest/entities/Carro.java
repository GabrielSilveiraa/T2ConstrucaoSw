package com.yamapi.crud_rest.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carro {

    @Id
    private String modelo;
    private String marca;
    private double motor;
    private int concessionariaId;
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getMotor() {
		return motor;
	}
	public void setMotor(double motor) {
		this.motor = motor;
	}
	public int getConcessionariaId() {
		return concessionariaId;
	}
	public void setConcessionariId(int concessionariaId) {
		this.concessionariaId = concessionariaId;
	}
	@Override
	public String toString() {
		return "Carro [marca=" + marca + ", modelo=" + modelo + ", motor=" + motor + ", concessionariId="
				+ concessionariaId + "]";
	}

   
}