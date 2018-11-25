package com.yamapi.crud_rest.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carro {

    @Id
    private String modelo;
    private String marca;
    private String motor;
    private String concessionariaId;
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
//	nome":"teste","endereco":"teste","descricao":"teste","dataCriacao":"teste","tipo":"teste","capacidadeVeiculos":"50
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	public String getConcessionariaId() {
		return concessionariaId;
	}
	public void setConcessionariId(String concessionariaId) {
		this.concessionariaId = concessionariaId;
	}
	@Override
	public String toString() {
		return "Carro [marca=" + marca + ", modelo=" + modelo + ", motor=" + motor + ", concessionariId="
				+ concessionariaId + "]";
	}

   
}