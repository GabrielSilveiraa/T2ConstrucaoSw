package com.yamapi.crud_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.yamapi.crud_rest.entities.Cliente;



	@RepositoryRestResource(path = "/cliente")
	public interface ClienteRepository extends JpaRepository<Cliente, String> {
	
}
