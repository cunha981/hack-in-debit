package br.com.hack.inadimplencia.entity;

import org.springframework.stereotype.Component;

@Component
public class Proposta {
	private String cpf;
	private String status;
	private Boolean podePagar;
	private Double quantoMinimo;
	private Double quantoMaximo;
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Boolean getPodePagar() {
		return podePagar;
	}
	public void setPodePagar(Boolean podePagar) {
		this.podePagar = podePagar;
	}
	public Double getQuantoMinimo() {
		return quantoMinimo;
	}
	public void setQuantoMinimo(Double quantoMinimo) {
		this.quantoMinimo = quantoMinimo;
	}
	public Double getQuantoMaximo() {
		return quantoMaximo;
	}
	public void setQuantoMaximo(Double quantoMaximo) {
		this.quantoMaximo = quantoMaximo;
	}
}
