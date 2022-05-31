package com.chinafood.servidor.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.chinafood.servidor.entity.Platillo;
import com.chinafood.servidor.repository.PlatilloRepository;

@Service
public class PlatilloServiceImpl extends ICRUDImpl<Platillo, Integer> {

	@Autowired
	private PlatilloRepository repository;

	@Override
	public JpaRepository<Platillo, Integer> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	
}
