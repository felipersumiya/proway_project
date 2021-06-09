package com.frsumiya.proway_projeto.services;

import java.util.ArrayList;
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
	
	private ClienteRepository clienteRepository;
	
	public List<PropostaCredito> findAll() {

		return propostaRepository.findAll();

	}

	public PropostaCredito findById(Long id) {

		Optional<PropostaCredito> obj = propostaRepository.findById(id);
		return obj.get();

	}
	
	public List<PropostaCredito> findPropostas(Long idCliente){
		
		//talvez sejam duas listas                                                                                                                                                                                                                                                                                                                                     
		List<PropostaCredito> list = new ArrayList<>();
		list = propostaRepository.findAll();
		
		//recupera o cliente logado.
		Cliente cliente = new Cliente();
		cliente = clienteRepository.getById(idCliente);
		//verificar logica
		for(PropostaCredito x : list) {
			
					if(cliente.getScore() > 500) {
						
						if (x.getValor() > 5000 ) {
							
								list.add(x);
						}
						
	
					}
		
		}
		
		return list;

	}

}