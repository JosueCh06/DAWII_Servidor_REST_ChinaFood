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
		public Proveedor buscar(@PathVariable("codigo") Integer cod) throws Exception{
			return proveedorService.buscarPorId(cod);     
		}
		//insert into tabla values(?,?,?,?)
		@PostMapping("/registrar")
		public void registrar(@RequestBody Proveedor prov)throws Exception{
			proveedorService.registrar(prov);         
		}
		//update tabla set campo1=?,campo2=? where campon=?
		@PutMapping("/actualizar")
		public void actualizar(@RequestBody Proveedor prov) throws Exception{
			proveedorService.actualizar(prov);
		}
		//delete from tabla where campon=?
		@DeleteMapping("/eliminar/{codigo}")
		public void eliminar(@PathVariable("codigo") Integer cod) throws Exception{
			proveedorService.eliminar(cod);
		}
}
