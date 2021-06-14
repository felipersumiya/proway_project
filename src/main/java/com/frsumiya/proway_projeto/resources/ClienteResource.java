package com.frsumiya.proway_projeto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frsumiya.proway_projeto.entities.Cliente;
import com.frsumiya.proway_projeto.entities.PropostaCredito;
import com.frsumiya.proway_projeto.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService;
	
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		
		List<Cliente> list = clienteService.findAll();

		return ResponseEntity.ok().body(list);		
	}
	
	//Este método retornará uma lista de propostas baseadas na saúde financeira do cliente, identificado pelo ID.
	@GetMapping (value = "/{id}")
	public ResponseEntity<List<PropostaCredito>> findById(@PathVariable Long id ){
		
		List<PropostaCredito> list2 = clienteService.findPropostas(id);
		//Cliente obj = clienteService.findById(id);
		
		return ResponseEntity.ok().body(list2);
	}
	

}
