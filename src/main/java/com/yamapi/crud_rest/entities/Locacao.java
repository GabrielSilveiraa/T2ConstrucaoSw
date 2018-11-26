package com.yamapi.crud_rest.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Locacao {

	
	@Id
	String codigo;
	String dataInicio;
	String dataFim;
	String valorTotal;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataFim() {
		return dataFim;
	}
	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}
	public String getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	@Override
	public String toString() {
		return "Locacao [codigo=" + codigo + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", valorTotal="
				+ valorTotal + "]";
	}

	
	
}
