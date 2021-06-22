package com.frsumiya.proway_projeto.dto;

import com.frsumiya.proway_projeto.entities.Cliente;

public class ClienteDto {
	
	
	private Long id;
	private String nome;
	private String cpf;
	private String telefone;
	private Integer score;
	private String saudeFinanceira;
	
	public ClienteDto() {
		
	}

	public ClienteDto(Cliente cliente) {

		id = cliente.getId();
		nome = cliente.getNome();
		cpf = cliente.getCpf();
		telefone = cliente.getTelefone();
		score = cliente.getScore();
		saudeFinanceira = cliente.getSaudeFinanceira();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getSaudeFinanceira() {
		return saudeFinanceira;
	}

	public void setSaudeFinanceira(String saudeFinanceira) {
		this.saudeFinanceira = saudeFinanceira;
	}
	
	
	
	

}
