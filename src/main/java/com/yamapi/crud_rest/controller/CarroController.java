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

    @GetMapping(path = "/{modelo}")
    public Carro find(@PathVariable("modelo") String modelo) {
        return repository.findOne(modelo);
    }

    @PostMapping(consumes = "application/json")
    public Carro create(@RequestBody Carro carro) {
        return repository.save(carro);
    }

    @DeleteMapping(path = "/{modelo}")
    public void delete(@PathVariable("modelo") String modelo) {
        repository.delete(modelo);
    }

    @PutMapping(path = "/{modelo}")
    public Carro update(@PathVariable("modelo") String modelo, @RequestBody Carro carro) throws BadHttpRequest {
        if (repository.exists(modelo)) {
        	carro.setModelo(modelo);
            return repository.save(carro);
        } else {
            throw new BadHttpRequest();
        }
    }

}