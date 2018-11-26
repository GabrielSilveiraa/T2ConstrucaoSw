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
@RequestMapping(path = "/carro")
public class CarroController {

    @Autowired
    private CarroRepository repository;

    @GetMapping
    public Iterable<Carro> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{renavam}")
    public Carro find(@PathVariable("renavam") String renavam) {
        return repository.findOne(renavam);
    }

    @PostMapping(consumes = "application/json")
    public Carro create(@RequestBody Carro carro) {
        return repository.save(carro);
    }

    @DeleteMapping(path = "/{renavam}")
    public void delete(@PathVariable("renavam") String renavam) {
        repository.delete(renavam);
    }

    @PutMapping(path = "/{renavam}")
    public Carro update(@PathVariable("renavam") String renavam, @RequestBody Carro carro) throws BadHttpRequest {
        if (repository.exists(renavam)) {
        	carro.setRenavam(renavam);
            return repository.save(carro);
        } else {
            throw new BadHttpRequest();
        }
    }

}