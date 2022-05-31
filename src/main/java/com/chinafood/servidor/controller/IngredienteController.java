package com.chinafood.servidor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

}
