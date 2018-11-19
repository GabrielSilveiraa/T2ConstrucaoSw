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
@RequestMapping(path = "/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository repository;

    @GetMapping
    public Iterable<Project> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{projectname}")
    public Project find(@PathVariable("projectname") String projectname) {
        return repository.findOne(projectname);
    }

    @PostMapping(consumes = "application/json")
    public Project create(@RequestBody Project project) {
        return repository.save(project);
    }

    @DeleteMapping(path = "/{projectname}")
    public void delete(@PathVariable("projectname") String projectname) {
        repository.delete(projectname);
    }

    @PutMapping(path = "/{projectname}")
    public Project update(@PathVariable("projectname") String projectname, @RequestBody Project project) throws BadHttpRequest {
        if (repository.exists(projectname)) {
            project.setProjectName(projectname);
            return repository.save(project);
        } else {
            throw new BadHttpRequest();
        }
    }

}