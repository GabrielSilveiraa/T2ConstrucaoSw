package com.yamapi.crud_rest.repository;

import com.yamapi.crud_rest.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "/projects")
public interface ProjectRepository extends JpaRepository<Project, String> {

}