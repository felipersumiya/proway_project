package com.frsumiya.proway_projeto.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.frsumiya.proway_projeto.entities.Cliente;
import com.frsumiya.proway_projeto.entities.PropostaCredito;
import com.frsumiya.proway_projeto.repositories.ClientePropostaRepository;
import com.frsumiya.proway_projeto.repositories.ClienteRepository;
import com.frsumiya.proway_projeto.repositories.PropostaCreditoRepository;


@Configuration
@Profile ("test")
public class TesteMain implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PropostaCreditoRepository propostaCreditoRepository;
	
	@Autowired
	private ClientePropostaRepository clientePropostaRepository;
	


	public void run(String... args) throws Exception {
		
	
	
		Cliente c1 = new Cliente(null, "Maria Brown", "333.222.111-21", "119999-9922", 500);
		Cliente c2 = new Cliente(null, "Fernando Ferreira", "332.222.111-21", "119999-9955", 900);
		
		PropostaCredito pc1 = new PropostaCredito(null, 2.5 , 5000.0 , 6000.0 , 8 , 625.0);
		PropostaCredito pc2 = new PropostaCredito(null, 5.5 , 4000.0 , 5000.0 , 10 , 400.0);
	
	
		
		clienteRepository.saveAll(Arrays.asList(c1,c2));
		propostaCreditoRepository.saveAll(Arrays.asList(pc1,pc2));
	
	

	}

}
