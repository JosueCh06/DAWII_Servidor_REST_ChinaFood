package com.chinafood.servidor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinafood.servidor.entity.CategoriaProveedor;
import com.chinafood.servidor.serviceImpl.CategoriaProveedorServiceImpl;

@CrossOrigin(origins = "http://localhost:8095/")
@RestController
@RequestMapping("/categoriaProveedor")
public class CategoriaProveedorController {

	@Autowired
	private CategoriaProveedorServiceImpl catProveedorService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<CategoriaProveedor>> listarCategoriasProveedores() throws Exception{
		List<CategoriaProveedor> lista = catProveedorService.listarTodos();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
}
