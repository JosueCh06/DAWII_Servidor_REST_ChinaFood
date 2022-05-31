package com.chinafood.servidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chinafood.servidor.entity.Ingrediente;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer>{

}
