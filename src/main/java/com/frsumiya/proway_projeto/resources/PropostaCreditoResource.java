package com.frsumiya.proway_projeto.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.frsumiya.proway_projeto.dto.PropostaCreditoDto;
import com.frsumiya.proway_projeto.entities.PropostaCredito;
import com.frsumiya.proway_projeto.services.PropostaCreditoService;

@RestController
@RequestMapping(value = "/proposta_credito")
public class PropostaCreditoResource {
	
	
@Autowired	
private PropostaCreditoService propostaService;
	
	
	@GetMapping
	public ResponseEntity<List<PropostaCreditoDto>> findAll(){
		
		List<PropostaCredito> list = propostaService.findAll();
		
		List<PropostaCreditoDto> listDto =  list.stream().map( x -> new PropostaCreditoDto(x)).collect(Collectors.toList());
		

		return ResponseEntity.ok().body(listDto);		
	}
	
	@GetMapping (value = "/{id}")
	public ResponseEntity<PropostaCreditoDto> findById(@PathVariable Long id ){
		
	
		PropostaCredito proposta = propostaService.findById(id);	
		
		return ResponseEntity.ok().body(new PropostaCreditoDto(proposta));
	}
	

}
