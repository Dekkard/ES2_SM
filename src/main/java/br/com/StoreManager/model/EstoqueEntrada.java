package br.com.StoreManager.model;

import java.util.Date;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "estoqueEntrada")
@Proxy(lazy = false)
public class EstoqueEntrada implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column (name="id")
	private Integer id;
	@Column (name="produto_id")
	private Integer produto_id;
	@Column (name="data")
	private Date data;
	@Column (name="qtdEntrada")
	private Integer qtdEntrada;
	@Column (name="valorPago")
	private Double valorPago;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProduto_id() {
		return produto_id;
	}
	public void setProduto_id(Integer produto_id) {
		this.produto_id = produto_id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Integer getQtdEntrada() {
		return qtdEntrada;
	}
	public void setQtdEntrada(Integer qtdEntrada) {
		this.qtdEntrada = qtdEntrada;
	}
	public Double getValorPago() {
		return valorPago;
	}
	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}
}
