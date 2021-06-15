package com.frsumiya.proway_projeto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frsumiya.proway_projeto.entities.PropostaCredito;
import com.frsumiya.proway_projeto.services.PropostaCreditoService;

@RestController
@RequestMapping(value = "/proposta_credito")
public class PropostaCreditoResource {
	
	
@Autowired	
private PropostaCreditoService propostaService;
	
	
	@GetMapping
	public ResponseEntity<List<PropostaCredito>> findAll(){
		
		List<PropostaCredito> list = propostaService.findAll();

		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping (value = "/{id}")
	public ResponseEntity<PropostaCredito> findById(@PathVariable Long id ){
		
	
		PropostaCredito obj = propostaService.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	


}
