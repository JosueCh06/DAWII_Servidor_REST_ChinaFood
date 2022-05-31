package com.chinafood.servidor.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.chinafood.servidor.entity.CategoriaProveedor;
import com.chinafood.servidor.repository.CategoriaProveedorRepository;

@Service
public class CategoriaProveedorServiceImpl extends ICRUDImpl<CategoriaProveedor, Integer>{

	@Autowired
	private CategoriaProveedorRepository repository;
	
	@Override
	public JpaRepository<CategoriaProveedor, Integer> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

}
