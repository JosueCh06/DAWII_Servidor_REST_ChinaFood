package com.chinafood.servidor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinafood.servidor.entity.CategoriaPlatillo;
import com.chinafood.servidor.serviceImpl.CategoriaPlatilloServiceImpl;

@CrossOrigin(origins = "http://localhost:8095/")
@RestController
@RequestMapping("/categoriaPlatillo")
public class CategoriaPlatilloController {

	@Autowired
	private CategoriaPlatilloServiceImpl catPlatilloService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<CategoriaPlatillo>> listarCategoriasPlatillos() throws Exception{
		List<CategoriaPlatillo> lista = catPlatilloService.listarTodos();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
}
