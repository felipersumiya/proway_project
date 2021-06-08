package com.frsumiya.proway_projeto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.frsumiya.proway_projeto.entities.Cliente;
import com.frsumiya.proway_projeto.entities.PropostaCredito;
import com.frsumiya.proway_projeto.repositories.ClienteRepository;
import com.frsumiya.proway_projeto.repositories.PropostaCreditoRepository;

public class PropostaCreditoService {
	
	@Autowired
	private PropostaCreditoRepository propostaRepository;
	
	public List<PropostaCredito> findAll() {

		return propostaRepository.findAll();

	}

	public PropostaCredito findById(Long id) {

		Optional<PropostaCredito> obj = propostaRepository.findById(id);
		return obj.get();

	}

}
