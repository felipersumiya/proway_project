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
	

	// Perfil para execução de testes. 
	// Insere dados para popular o banco de dados em memória (banco de dados H2)
	public void run(String... args) throws Exception {
		

		
		Cliente c1 = new Cliente(null, "Maria Brown", "333.222.111-21", "119499-9922", 500);
		Cliente c2 = new Cliente(null, "Fernando Ferreira", "332.222.111-21", "119799-9955", 700);
		Cliente c3 = new Cliente(null, "Felipe Hernadez", "332.242.111-21", "119899-9955", 200);
		Cliente c4 = new Cliente(null, "Chris Redfield", "332.522.111-20", "115599-9955", 1000);
		Cliente c5 = new Cliente(null, "Claire Redfield", "332.622.111-21", "114499-9955", 650);
		Cliente c6 = new Cliente(null, "Jill Wesker", "332.222.161-21", "119999-3355", 700);
		Cliente c7 = new Cliente(null, "Rebecca Chambers", "372.222.111-21", "112299-9955",320);
		Cliente c8 = new Cliente(null, "João Pereira", "372.232.111-21", "116699-9955",200);
		Cliente c9 = new Cliente(null, "Mariana Oliveira", "372.233.111-41", "112299-9955",1000);
		Cliente c10 = new Cliente(null, "Leandro Silva", "352.222.111-21", "112299-3455",750);
		Cliente c11 = new Cliente(null, "Eliana Alves", "372.282.111-21", "112299-0055",440);
		Cliente c12 = new Cliente(null, "Alex Vieira", "362.222.441-21", "112299-9933",564);
		Cliente c13= new Cliente(null, "Arnaldo Silva", "332.222.661-21", "112299-9999",920);
		Cliente c14 = new Cliente(null, "Carlos de Albuquerque", "372.222.111-21", "112239-9955",200);

		
		
		
		
		
		PropostaCredito pc1 = new PropostaCredito(null, 2.5 , 10000.0, 12000.0 , 8 , 625.0);
		PropostaCredito pc2 = new PropostaCredito(null, 5.5 , 4000.0 , 6000.0 , 10 , 400.0);
		PropostaCredito pc3 = new PropostaCredito(null, 2.5 , 5000.0 , 7000.0 , 8 , 625.0);
		PropostaCredito pc4 = new PropostaCredito(null, 5.5 , 7000.0 , 8000.0 , 10 , 400.0);
		PropostaCredito pc5 = new PropostaCredito(null, 5.5 , 9000.0 , 10000.0 , 10 , 400.0);
		PropostaCredito pc6 = new PropostaCredito(null, 1.9 , 10000.0 , 13000.0 , 15 , 870.0);
		PropostaCredito pc7 = new PropostaCredito(null, 1.8 , 15000.0 , 18000.0 , 17 , 1060.0);
		PropostaCredito pc8 = new PropostaCredito(null, 7.7 , 2000.0 , 3000.0 , 10 , 300.0);
		PropostaCredito pc9 = new PropostaCredito(null, 4.0 , 1500.0 , 2500.0 , 12 , 208.0);
		PropostaCredito pc10 = new PropostaCredito(null, 3.0 , 8500.0 , 9500.0 , 13 , 730.0);
		PropostaCredito pc11= new PropostaCredito(null, 1.0, 20000.0, 22000.0, 16 , 1400.0);
		PropostaCredito pc12= new PropostaCredito(null, 3.4 , 5000.0 , 6000.0 , 8 , 750.0);
		
		
		//Atrelar propostas aos clientes.
		c1.setProposta(pc5);
		pc5.setCliente(c1);
		
		c2.setProposta(pc3);
		pc3.setCliente(c2);
  	
		c9.setProposta(pc7);
		pc7.setCliente(c9);
		
		c14.setProposta(pc9);
		pc9.setCliente(c14);
		
		
		clienteRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14));
		propostaCreditoRepository.saveAll(Arrays.asList(pc1,pc2,pc3,pc4,pc5,pc6,pc7,pc8,pc9,pc10,pc11,pc12));
	
	
	}

}
