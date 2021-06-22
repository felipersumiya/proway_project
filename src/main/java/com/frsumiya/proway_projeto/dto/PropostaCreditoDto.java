package com.frsumiya.proway_projeto.dto;

import com.frsumiya.proway_projeto.entities.PropostaCredito;

public class PropostaCreditoDto {
	
	private Long id;
	private Double taxaJuros;
	private Double valor;
	private Double cet;
	private Integer prazo;
	private Double parcelas;
	private String  saudeF;
	
	public PropostaCreditoDto() {
		
	}
	
	public PropostaCreditoDto(PropostaCredito proposta) {
		
		
		id = proposta.getId();
		taxaJuros = proposta.getTaxaJuros();
		valor = proposta.getValor();
		cet = proposta.getCet();
		prazo = proposta.getPrazo();
		parcelas= proposta.getParcelas();
		saudeF = proposta.getSaudeF();
		
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
	
	
	
	

}
