package br.com.hack.inadimplencia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pessoa")
public class Pessoa {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "CPF")
	private String cpf;
	@Column(name = "vl_GastosFixo")
	private Double valorGastoFixo;
	@Column(name = "vl_Gastos")
	private Double valorGastos;
	@Column(name = "vl_DividaTotal")
	private Double valorDividaTotal;
	@Column(name = "Parcelas")
	private Integer numeroParcelas;
	@Column(name = "vl_Parcelas")
	private Double valorParcelas;
	@Column(name = "situacao")
	private String situacao;
	@Column(name = "renda")
	private Double renda;
	@Column(name = "saldo")
	private Double saldo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Double getValorGastoFixo() {
		return valorGastoFixo;
	}
	public void setValorGastoFixo(Double valorGastoFixo) {
		this.valorGastoFixo = valorGastoFixo;
	}
	public Double getValorGastos() {
		return valorGastos;
	}
	public void setValorGastos(Double valorGastos) {
		this.valorGastos = valorGastos;
	}
	public Double getValorDividaTotal() {
		return valorDividaTotal;
	}
	public void setValorDividaTotal(Double valorDividaTotal) {
		this.valorDividaTotal = valorDividaTotal;
	}
	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}
	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}
	public Double getValorParcelas() {
		return valorParcelas;
	}
	public void setValorParcelas(Double valorParcelas) {
		this.valorParcelas = valorParcelas;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public Double getRenda() {
		return renda;
	}
	public void setRenda(Double renda) {
		this.renda = renda;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
}
