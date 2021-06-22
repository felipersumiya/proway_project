package com.frsumiya.proway_projeto.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.dom4j.dtd.AttributeDecl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.frsumiya.proway_projeto.dto.ClienteDto;
import com.frsumiya.proway_projeto.dto.PropostaCreditoDto;
import com.frsumiya.proway_projeto.entities.Cliente;
import com.frsumiya.proway_projeto.entities.PropostaCredito;
import com.frsumiya.proway_projeto.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	
	//Retorna uma lista de clientes.
	@GetMapping
	public ResponseEntity<List<ClienteDto>> findAll(){
		
		List<Cliente> list = clienteService.findAll();
		
		List<ClienteDto> listDto = list.stream().map( x -> new ClienteDto(x)).collect(Collectors.toList());
		
		

		return ResponseEntity.ok().body(listDto);		
	}
	
	//Retorna o cliente com o id recebido na entrada.
	@GetMapping (value = "/{id}")
	public ResponseEntity<ClienteDto> findClienteById(@PathVariable Long id ){
		
		
		Cliente cliente = clienteService.findById(id);	
		
		return ResponseEntity.ok().body(new ClienteDto(cliente));

	}
	
	//Este método retornará uma lista de propostas baseadas na saúde financeira do cliente, identificado pelo ID.
	@GetMapping (value = "/propostas/{id}")
	public ResponseEntity<List<PropostaCreditoDto>> findById(@PathVariable Long id ){
		
		
		List<PropostaCredito> list2 = clienteService.findPropostas(id);
		List<PropostaCreditoDto> listDto = list2.stream().map(x -> new PropostaCreditoDto(x)).collect(Collectors.toList());
		//Cliente obj = clienteService.findById(id);
		
		return ResponseEntity.ok().body(listDto);
	}
	

}
