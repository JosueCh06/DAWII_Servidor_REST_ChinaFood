package com.chinafood.servidor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinafood.servidor.entity.Platillo;
import com.chinafood.servidor.serviceImpl.PlatilloServiceImpl;

@CrossOrigin(origins = "http://localhost:8095/")
@RestController
@RequestMapping("/platillo")
public class PlatilloController {
	
	@Autowired
	private PlatilloServiceImpl platilloService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Platillo>> listarPlatillos() throws Exception{
		List<Platillo> lista = platilloService.listarTodos();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

}
