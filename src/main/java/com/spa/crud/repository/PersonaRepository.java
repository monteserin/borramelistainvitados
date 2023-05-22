package com.spa.crud.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spa.crud.persistence.model.Persona;


public interface PersonaRepository extends CrudRepository<Persona, Integer> {
    List<Persona> findAll();

}
