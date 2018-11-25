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
import javassist.tools.web.BadHttpRequest;
import com.yamapi.crud_rest.repository.*;
import com.yamapi.crud_rest.entities.*;
@RestController
@RequestMapping(path = "/concessionaria")
public class ConcessionariaController {

    @Autowired
    private ConcessionariaRepository repository;

    @GetMapping
    public Iterable<Concessionaria> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{nome}")
    public Concessionaria find(@PathVariable("nome") String nome) {
        return repository.findOne(nome);
    }

    @PostMapping(consumes = "application/json")
    public Concessionaria create(@RequestBody Concessionaria concessionaria) {
        return repository.save(concessionaria);
    }

    @DeleteMapping(path = "/{nome}")
    public void delete(@PathVariable("nome") String id) {
        repository.delete(id);
    }

    @PutMapping(path = "/{nome}")
    public Concessionaria update(@PathVariable("id") String nome, @RequestBody Concessionaria concessionaria) throws BadHttpRequest {
        if (repository.exists(nome)) {
        		concessionaria.setNome(nome);
            return repository.save(concessionaria);
        } else {
            throw new BadHttpRequest();
        }
    }

}