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
		
	
	
		Cliente c1 = new Cliente(null, "Maria Brown", "333.222.111-21", "119499-9922", 500);
		Cliente c2 = new Cliente(null, "Fernando Ferreira", "332.222.111-21", "119799-9955", 700);
		Cliente c3 = new Cliente(null, "Felipe Hernadez", "332.242.111-21", "119899-9955", 200);
		Cliente c4 = new Cliente(null, "Chris Redfield", "332.522.111-21", "115599-9955", 1000);
		Cliente c5 = new Cliente(null, "Claire Redfield", "332.622.111-21", "114499-9955", 650);
		Cliente c6 = new Cliente(null, "Jill Wesker", "332.222.161-21", "119999-3355", 700);
		Cliente c7 = new Cliente(null, "Rebecca Chambers", "372.222.111-21", "112299-9955",320);
		
		PropostaCredito pc1 = new PropostaCredito(null, 2.5 , 10000.0, 12000.0 , 8 , 625.0);
		PropostaCredito pc2 = new PropostaCredito(null, 5.5 , 4000.0 , 6000.0 , 10 , 400.0);
		PropostaCredito pc3 = new PropostaCredito(null, 2.5 , 5000.0 , 7000.0 , 8 , 625.0);
		PropostaCredito pc4 = new PropostaCredito(null, 5.5 , 7000.0 , 8000.0 , 10 , 400.0);
		PropostaCredito pc5 = new PropostaCredito(null, 5.5 , 9000.0 , 10000.0 , 10 , 400.0);
		
		c1.setProposta(pc5);
		pc5.setCliente(c1);
		
		c2.setProposta(pc3);
		pc3.setCliente(c2);
  	
	
		
		clienteRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7));
		propostaCreditoRepository.saveAll(Arrays.asList(pc1,pc2,pc3,pc4,pc5));
	
	

	}

}
