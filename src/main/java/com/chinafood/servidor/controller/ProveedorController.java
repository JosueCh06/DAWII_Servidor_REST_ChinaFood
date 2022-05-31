package com.chinafood.servidor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinafood.servidor.entity.Proveedor;
import com.chinafood.servidor.serviceImpl.ProveedorServiceImpl;

@CrossOrigin(origins = "http://localhost:8095/")
@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

	@Autowired
	ProveedorServiceImpl proveedorService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Proveedor>> listarProveedores() throws Exception{
		List<Proveedor> lista = proveedorService.listarTodos();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
}
