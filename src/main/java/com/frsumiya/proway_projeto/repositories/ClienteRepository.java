package com.frsumiya.proway_projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frsumiya.proway_projeto.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	

}
