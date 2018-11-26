package com.yamapi.crud_rest.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carro {

    @Id
    private String renavam;
    private String modelo;
    private String marca;
    private String valorDiaria;
    
    
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

	public String getRenavam() {
		return renavam;
	}
	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}
	public String getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(String valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	@Override
	public String toString() {
		return "Carro [marca=" + marca + ", modelo=" + modelo + ", renavam=" + renavam + ", valorDiaria="
				+ valorDiaria + "]";
	}

   
}