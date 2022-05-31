package com.chinafood.servidor.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.chinafood.servidor.entity.CategoriaPlatillo;
import com.chinafood.servidor.repository.CategoriaPlatilloRepository;

@Service
public class CategoriaPlatilloServiceImpl extends ICRUDImpl<CategoriaPlatillo, Integer>{

	@Autowired
	private CategoriaPlatilloRepository repository;
	
	@Override
	public JpaRepository<CategoriaPlatillo, Integer> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}

}
