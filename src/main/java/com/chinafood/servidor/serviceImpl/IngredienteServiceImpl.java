package com.chinafood.servidor.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.chinafood.servidor.entity.Ingrediente;
import com.chinafood.servidor.repository.IngredienteRepository;

@Service
public class IngredienteServiceImpl extends ICRUDImpl<Ingrediente, Integer>{

	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	@Override
	public JpaRepository<Ingrediente, Integer> getRepository() {
		
		return ingredienteRepository;
	}

}
