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
	
	@GetMapping("buscar/{codigo}")
	public ResponseEntity<Platillo> buscar(@PathVariable("codigo") int cod) throws Exception {
		Platillo p = platilloService.buscarPorId(cod);
		// validar
		if(p==null)
			throw new NotFoundException();
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<Platillo> registrar(@RequestBody Platillo pla) throws Exception {
		Platillo p = platilloService.registrar(pla);
		return new ResponseEntity<>(p, HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<Platillo> actualizar(@RequestBody Platillo pla) throws Exception {
		Platillo p = platilloService.buscarPorId(pla.getIdPlatillo());
		// validar
		if(p==null)
			throw new NotFoundException();
		else
			p = platilloService.actualizar(pla);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}
	
	@DeleteMapping("eliminar/{codigo}")
	public ResponseEntity<Void> eliminar(@PathVariable("codigo") int cod) throws Exception {
		Platillo p = platilloService.buscarPorId(cod);
		// validar
		if(p==null)
			throw new NotFoundException();
		else
			platilloService.eliminar(cod);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
