package com.frsumiya.proway_projeto.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.frsumiya.proway_projeto.enuns.SaudeFinanceira;

@Entity
@Table (name="tb_proposta_credito")
public class PropostaCredito implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	@Id
	@GeneratedValue (strategy  = GenerationType.IDENTITY)
	private Long id;
	private Double taxaJuros;
	private Double valor;
	private Double cet;
	private Integer prazo;
	private Double parcelas;
	private String  saudeF;
	
	@OneToOne //(mappedBy = "proposta", cascade = CascadeType.ALL )
	//@ManyToMany(mappedBy =  "proposta")
	private Cliente  cliente;
	
	
	public PropostaCredito() {
		
	}
	
	
	public PropostaCredito(Long id, Double taxaJuros, Double valor, Double cet, Integer prazo, Double parcelas) {
		super();
		this.id = id;
		this.taxaJuros = taxaJuros;
		this.valor = valor;
		this.cet = cet;
		this.prazo = prazo;
		this.parcelas = parcelas;
		

		//Definir para qual saúde financeira será designado cada valor de empréstimo pessoal.
		if(this.valor > 9000.0) {
			
			this.saudeF = SaudeFinanceira.BOA.toString();
		}
			
		if(this.valor <= 9000.0 && this.valor >= 5000.0) {
			
			this.saudeF = SaudeFinanceira.MEDIA.toString();
			
		}
			
		if(this.valor <5000.0) {
			
			
			this.saudeF = SaudeFinanceira.RUIM.toString();
		}
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Double getTaxaJuros() {
		return taxaJuros;
	}


	public void setTaxaJuros(Double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public Double getCet() {
		return cet;
	}


	public void setCet(Double cet) {
		this.cet = cet;
	}


	public Integer getPrazo() {
		return prazo;
	}


	public void setPrazo(Integer prazo) {
		this.prazo = prazo;
	}


	public Double getParcelas() {
		return parcelas;
	}


	public void setParcelas(Double parcelas) {
		this.parcelas = parcelas;
	}
	
	


	public String getSaudeF() {
		return saudeF;
	}


	public void setSaudeF(String saudeF) {
		this.saudeF = saudeF;
	}
	
	

	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		PropostaCredito other = (PropostaCredito) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	


}
