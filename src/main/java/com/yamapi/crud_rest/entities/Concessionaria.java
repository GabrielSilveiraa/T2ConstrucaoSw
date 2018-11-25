package com.yamapi.crud_rest.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Concessionaria {

    @Id
    private String nome;
    private String endereco;
    private String descricao;
    private String dataCriacao;
    private String tipo;
    private boolean oficina;
    private boolean importado;
    private int capacidadeVeiculos;
    
    public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isOficina() {
		return oficina;
	}
	public void setOficina(boolean oficina) {
		this.oficina = oficina;
	}
	public boolean isImportado() {
		return importado;
	}
	public void setImportado(boolean importado) {
		this.importado = importado;
	}
	public int getCapacidadeVeiculos() {
		return capacidadeVeiculos;
	}
	public void setCapacidadeVeiculos(int capacidadeVeiculos) {
		this.capacidadeVeiculos = capacidadeVeiculos;
	}
	
    @Override
	public String toString() {
		return "Concessionaria [nome=" + nome + ", endereco=" + endereco + ", descricao=" + descricao + ", dataCriacao="
				+ dataCriacao + ", tipo=" + tipo + ", oficina=" + oficina + ", importado=" + importado
				+ ", capacidadeVeiculos=" + capacidadeVeiculos + "]";
	}
    

}