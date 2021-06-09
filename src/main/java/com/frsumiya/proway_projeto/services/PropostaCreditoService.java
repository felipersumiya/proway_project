package com.frsumiya.proway_projeto.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.frsumiya.proway_projeto.entities.Cliente;
import com.frsumiya.proway_projeto.entities.PropostaCredito;
import com.frsumiya.proway_projeto.enuns.SaudeFinanceira;
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
	
	//retorna a lista de propostas de crédito pessoal com base na saúde financeira do cliente.
	//* Criei meus próprios parâmetros para definir a saúde financeira do cliente, divididos em : boa, média e ruim, representados pelos valores de enum (SaudeFinanceira) BOA, MEDIA e RUIM respectivamente.
	public List<PropostaCredito> findPropostas(Long idCliente){
		
		//talvez sejam duas listas                                                                                                                                                                                                                                                                                                                                     
		List<PropostaCredito> listPropostas = new ArrayList<>();
		listPropostas = propostaRepository.findAll();
		
		//recupera o cliente logado.
		Cliente cliente = new Cliente();
		cliente = clienteRepository.getById(idCliente);
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