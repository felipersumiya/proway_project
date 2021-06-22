package com.frsumiya.proway_projeto.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frsumiya.proway_projeto.dto.ClienteDto;
import com.frsumiya.proway_projeto.dto.PropostaCreditoDto;
import com.frsumiya.proway_projeto.entities.Cliente;
import com.frsumiya.proway_projeto.entities.PropostaCredito;
import com.frsumiya.proway_projeto.enuns.SaudeFinanceira;
import com.frsumiya.proway_projeto.repositories.ClienteRepository;
import com.frsumiya.proway_projeto.repositories.PropostaCreditoRepository;


@Service
public class PropostaCreditoService {
	
	@Autowired
	private PropostaCreditoRepository propostaRepository;
	
	//@Autowired
	//private ClienteService clienteService;
	
	public List<PropostaCredito> findAll() {

		return propostaRepository.findAll();

	}

	public PropostaCredito findById(Long id) {

		Optional<PropostaCredito> obj = propostaRepository.findById(id);
		return obj.get();

	}
	
	
	public PropostaCredito fromDTO(PropostaCreditoDto propostaDto) {

		return new PropostaCredito(propostaDto.getId(), propostaDto.getTaxaJuros(), propostaDto.getValor(),
				propostaDto.getCet(), propostaDto.getPrazo(), propostaDto.getParcelas());

	}
	
	
	
	public PropostaCredito insert(PropostaCredito proposta) {
		
		return propostaRepository.save(proposta);
		
	}
	
	public void delete(Long id) {
		
		propostaRepository.deleteById(id);
		
	}
	
	public void update(Long id, PropostaCredito newProposta) {
		
		try {
			
			PropostaCredito proposta = propostaRepository.getById(id);
			updateData(proposta, newProposta);
			propostaRepository.save(proposta);
		
		}catch (Exception e) {
			
			e.printStackTrace();
		
		
		}	
	}
	
	public void updateData(PropostaCredito  proposta, PropostaCredito newProposta) {
			
		proposta.setTaxaJuros(newProposta.getTaxaJuros());
		proposta.setValor(newProposta.getValor());
		proposta.setCet(newProposta.getCet());
		proposta.setPrazo(newProposta.getPrazo());
		proposta.setParcelas(newProposta.getParcelas());
		proposta.setSaudeF(newProposta.getSaudeF());
					
	}

	
	
	public static String definirSaudeProposta(Double valor) {
		
		
		if(valor > 9000.0) {
			
			return  SaudeFinanceira.BOA.toString();
		}
			
		if(valor <= 9000.0 && valor >= 5000.0) {
			
			return  SaudeFinanceira.MEDIA.toString();
			
		}
			
		if(valor < 5000.0) {
			
			
			return SaudeFinanceira.RUIM.toString();
		}
		
		return "Indefinido";
		
	}
	
	//retorna a lista de propostas de crédito pessoal com base na saúde financeira do cliente.
	//* Criei meus próprios parâmetros para definir a saúde financeira do cliente, divididos em : boa, média e ruim, representados pelos valores de enum (SaudeFinanceira) BOA, MEDIA e RUIM respectivamente.
/**	public List<PropostaCredito> findPropostas(Long idCliente){
		
		//talvez sejam duas listas                                                                                                                                                                                                                                                                                                                                     
		List<PropostaCredito> listPropostas = new ArrayList<>();
		listPropostas = propostaRepository.findAll();
		
		//recupera o cliente logado.
		Cliente cliente = new Cliente();
		cliente = clienteService.findById(idCliente);
		
	
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
			
		
	}**/

}