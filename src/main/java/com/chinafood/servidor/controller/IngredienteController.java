package com.chinafood.servidor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinafood.servidor.entity.Ingrediente;
import com.chinafood.servidor.serviceImpl.IngredienteServiceImpl;

@CrossOrigin(origins = "http://localhost:8095/")
@RestController
@RequestMapping("/ingrediente")
public class IngredienteController {
	
	@Autowired
	IngredienteServiceImpl ingredienteService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Ingrediente>> listarIngredientes() throws Exception{
		List<Ingrediente> lista = ingredienteService.listarTodos();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@GetMapping("/buscar/{codigo}")
	public ResponseEntity<Ingrediente> buscar(@PathVariable("codigo") int cod) throws Exception{
		Ingrediente ingred=ingredienteService.buscarPorId(cod);
		//validar med
		if(ingred==null)
			throw new NotFoundException();
		
		return new ResponseEntity<>(ingred,HttpStatus.OK);
	}
	@PostMapping("/registrar")
	public ResponseEntity<Ingrediente> registrar(@RequestBody Ingrediente ingred) throws Exception{
		Ingrediente i=ingredienteService.registrar(ingred);               
		
		return new ResponseEntity<>(i,HttpStatus.CREATED);
	}
	@PutMapping("/actualizar")
	public ResponseEntity<Ingrediente> actualizar(@RequestBody Ingrediente ingred) throws Exception{
		Ingrediente i=ingredienteService.buscarPorId(ingred.getIdIngrediente());				
		//validar m
		if(i==null)
			throw new NotFoundException();
		else
			i=ingredienteService.actualizar(ingred);   
		
		return new ResponseEntity<>(ingred,HttpStatus.OK);
	}
	@DeleteMapping("/eliminar/{codigo}")
	public ResponseEntity<Void> eliminar(@PathVariable("codigo") int cod) throws Exception{
		Ingrediente i=ingredienteService.buscarPorId(cod);   
		//validar m
		if(i==null)
			throw new NotFoundException();
		else
			ingredienteService.eliminar(cod);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
