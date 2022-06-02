package com.chinafood.servidor.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.chinafood.servidor.entity.Proveedor;
import com.chinafood.servidor.repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl extends ICRUDImpl<Proveedor, Integer>{

	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Override
	public JpaRepository<Proveedor, Integer> getRepository() {
		
		return proveedorRepository;
	}

}
