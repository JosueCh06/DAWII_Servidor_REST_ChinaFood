package com.chinafood.servidor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

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
	
	//select *from tabla where campo1=?
		//convierte a JSON
		@GetMapping("/buscar/{codigo}")
		public ResponseEntity<Proveedor> buscar(@PathVariable("codigo") int cod) throws Exception{
			Proveedor prov=proveedorService.buscarPorId(cod);
			if(prov==null)
				throw new NotFoundException();
			return new ResponseEntity<>(prov,HttpStatus.OK);
		}
		//insert into tabla values(?,?,?,?)
		@PostMapping("/registrar")
		public ResponseEntity<Proveedor> registrar(@RequestBody Proveedor prov)throws Exception{
			Proveedor p=proveedorService.registrar(prov);  
			return new ResponseEntity<>(p,HttpStatus.CREATED);
			
		}
		//update tabla set campo1=?,campo2=? where campon=?
		@PutMapping("/actualizar")
		public ResponseEntity<Proveedor> actualizar(@RequestBody Proveedor prov) throws Exception{
			Proveedor p=proveedorService.buscarPorId(prov.getIdProveedor());
			if(p==null)
				throw new NotFoundException();
			else
				p=proveedorService.actualizar(prov);
			return new ResponseEntity<>(prov,HttpStatus.OK);
		}
		//delete from tabla where campon=?
		@DeleteMapping("/eliminar/{codigo}")
		public ResponseEntity<Proveedor> eliminar(@PathVariable("codigo") int cod) throws Exception{
			Proveedor p=proveedorService.buscarPorId(cod);
			if(p==null)
				throw new NotFoundException();
			else
				proveedorService.eliminar(cod);
			return new ResponseEntity<>(HttpStatus.OK);
		}
}
