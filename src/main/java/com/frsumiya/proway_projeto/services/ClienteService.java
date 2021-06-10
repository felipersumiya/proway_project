package com.frsumiya.proway_projeto.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frsumiya.proway_projeto.entities.Cliente;
import com.frsumiya.proway_projeto.entities.PropostaCredito;
import com.frsumiya.proway_projeto.enuns.SaudeFinanceira;
import com.frsumiya.proway_projeto.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PropostaCreditoService propostaService;
	
	public List<Cliente> findAll() {

		return clienteRepository.findAll();

	}

	public Cliente findById(Long id) {

		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.get();

	}
	
	//retorna uma lista de propostas de credito de acordo com o ciente.
	public List<PropostaCredito> findPropostas(Long id){
		
		//talvez sejam duas listas                                                                                                                                                                                                                                                                                                                                     
		List<PropostaCredito> listPropostas = new ArrayList<>();
		listPropostas = propostaService.findAll();
		
		//recupera o cliente logado.
		Cliente cliente = new Cliente();
		Optional<Cliente> obj= clienteRepository.findById(id);
		cliente= obj.get();
		clienteRepository.findById(id);
	
		//verificar logica
		List<PropostaCredito> listRetorno = new ArrayList<>();
		
		
		//A lista será populada de acordo com a saúde financeira do cliente
		
		
		if(cliente.getSaudeFinanceira() == SaudeFinanceira.BOA.toString()) {
			
			//popular a lista
			for(PropostaCredito x : listPropostas) {
				
				if(x.getSaudeF() == SaudeFinanceira.BOA.toString()) {
					listRetorno.add(x);
				}
				
				
			}
			
		
		}
			
			
		if(cliente.getSaudeFinanceira() == SaudeFinanceira.MEDIA.toString()) {
			

			//popular a lista
			for(PropostaCredito x : listPropostas) {
				
				if(x.getSaudeF() == SaudeFinanceira.MEDIA.toString()) {
					listRetorno.add(x);
				}
				
				
			}
			
		}
			
			
			
			
		if(cliente.getSaudeFinanceira() == SaudeFinanceira.RUIM.toString()) {
			

			//popular a lista
			for(PropostaCredito x : listPropostas) {
				
				if(x.getSaudeF() == SaudeFinanceira.RUIM.toString()) {
					listRetorno.add(x);
				}
				
				
			}
			
		}
			
			

		return listRetorno;	
			
		
	}

	
	

}
