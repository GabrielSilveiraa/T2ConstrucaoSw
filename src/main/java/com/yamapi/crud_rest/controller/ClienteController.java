package com.yamapi.crud_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yamapi.crud_rest.entities.Cliente;
import com.yamapi.crud_rest.entities.Concessionaria;
import com.yamapi.crud_rest.repository.ClienteRepository;
import com.yamapi.crud_rest.repository.ConcessionariaRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {

	
	  @Autowired
	    private ClienteRepository repository;

	    @GetMapping
	    public Iterable<Cliente> findAll() {
	        return repository.findAll();
	    }

	    @GetMapping(path = "/{cpf}")
	    public Cliente find(@PathVariable("cpf") String cpf) {
	        return repository.findOne(cpf);
	    }

	    @PostMapping(consumes = "application/json")
	    public Cliente create(@RequestBody Cliente cliente) {
	        return repository.save(cliente);
	    }

	    @DeleteMapping(path = "/{cpf}")
	    public void delete(@PathVariable("cpf") String cpf) {
	        repository.delete(cpf);
	    }

	    @PutMapping(path = "/{cpf}")
	    public Cliente update(@PathVariable("cpf") String cpf, @RequestBody Cliente cliente) throws BadHttpRequest {
	        if (repository.exists(cpf)) {
	        		cliente.setNome(cpf);
	            return repository.save(cliente);
	        } else {
	            throw new BadHttpRequest();
	        }
	    }
	
	
	
}
