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
    private String oficina;
    private String importado;
    private String capacidadeVeiculos;
    
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
	public String isOficina() {
		return oficina;
	}
	public void setOficina(String oficina) {
		this.oficina = oficina;
	}
	public String isImportado() {
		return importado;
	}
	public void setImportado(String importado) {
		this.importado = importado;
	}
	public String getCapacidadeVeiculos() {
		return capacidadeVeiculos;
	}
	public void setCapacidadeVeiculos(String capacidadeVeiculos) {
		this.capacidadeVeiculos = capacidadeVeiculos;
	}
	
    @Override
	public String toString() {
		return "Concessionaria [nome=" + nome + ", endereco=" + endereco + ", descricao=" + descricao + ", dataCriacao="
				+ dataCriacao + ", tipo=" + tipo + ", oficina=" + oficina + ", importado=" + importado
				+ ", capacidadeVeiculos=" + capacidadeVeiculos + "]";
	}
    

}