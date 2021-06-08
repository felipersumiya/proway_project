package com.frsumiya.proway_projeto.entities;

public class Cliente {
	
	
//atributos do cliente.
	private Long id;
	private String nome;
	private String cpf;
	private String telefone;
	private Integer score;
	
	
	
	public Cliente() {
		
	}

	
	public Cliente(String nome, String cpf, String telefone, Integer score) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.score = score;
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


	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
