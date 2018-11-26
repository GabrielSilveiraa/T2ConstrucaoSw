package com.yamapi.crud_rest.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {

	 @Id
		String cpf;
		String nome;
		
	
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		
	
	    
		@Override
		public String toString() {
			return "Cliente [cpf=" + cpf + ", nome=" + nome + "]";
		}
	
}
