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

import com.yamapi.crud_rest.entities.Locacao;
import com.yamapi.crud_rest.repository.LocacaoRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/locacao")
public class LocacaoController {

	 @Autowired
	    private LocacaoRepository repository;

	    @GetMapping
	    public Iterable<Locacao> findAll() {
	        return repository.findAll();
	    }

	    @GetMapping(path = "/{codigo}")
	    public Locacao find(@PathVariable("codigo") String codigo) {
	        return repository.findOne(codigo);
	    }

	    @PostMapping(consumes = "application/json")
	    public Locacao create(@RequestBody Locacao locacao) {
	        return repository.save(locacao);
	    }

	    @DeleteMapping(path = "/{codigo}")
	    public void delete(@PathVariable("codigo") String id) {
	        repository.delete(id);
	    }

	    @PutMapping(path = "/{codigo}")
	    public Locacao update(@PathVariable("id") String codigo, @RequestBody Locacao locacao) throws BadHttpRequest {
	        if (repository.exists(codigo)) {
        		locacao.setCodigo(codigo);
	            return repository.save(locacao);
	        } else {
	            throw new BadHttpRequest();
	        }
	    }
	
	
	
}
