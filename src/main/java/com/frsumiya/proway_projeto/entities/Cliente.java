package com.frsumiya.proway_projeto.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.frsumiya.proway_projeto.enuns.SaudeFinanceira;
import com.frsumiya.proway_projeto.services.ClienteService;


@Entity
@Table (name="tb_cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue (strategy  = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cpf;
	private String telefone;
	private Integer score;
	private String saudeFinanceira;
	
	@JsonIgnore
	@OneToOne (cascade = CascadeType.ALL)
	@JoinTable (name = "tb_cliente_proposta",
	joinColumns = @JoinColumn (name="cliente_id") ,
	inverseJoinColumns = @JoinColumn (name="proposta_id"))
	private PropostaCredito proposta;
	
	public Cliente() {
		
	}

	public Cliente(Long id , String nome, String cpf, String telefone, Integer score) {
		super();
		this.id =id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.score = score;
		
		this.saudeFinanceira = ClienteService.defineSaudeCliente(score);
		

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
	
	
	public PropostaCredito getProposta() {
		return proposta;
	}

	public void setProposta(PropostaCredito proposta) {
		this.proposta = proposta;
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
