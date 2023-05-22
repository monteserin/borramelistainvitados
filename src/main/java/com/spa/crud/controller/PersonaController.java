package com.spa.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spa.crud.persistence.model.Persona;
import com.spa.crud.repository.PersonaRepository;

@CrossOrigin // Para hacer peticiones desde otro servidor
@RestController // Para hacer peticiones REST
@RequestMapping("/persons/") //referencia a la BD del Front End
public class PersonaController {

	@Autowired
	private PersonaRepository invitadoRepository;
	
	@PostMapping
	public void createGuest(@RequestBody Persona person) { //debe ser el mismo metodo que dice api.js del frontend 
		invitadoRepository.save(person);
	}

	@DeleteMapping("/{id}")
	public void deleteGuest(@PathVariable("id") Integer id) {
		Persona i = new Persona();
		i.setId(id);
		invitadoRepository.delete(i);
	}
	
	@GetMapping
	public List<Persona> getGuests() {
		List<Persona> people = invitadoRepository.findAll();
		return people;
	}
	
}