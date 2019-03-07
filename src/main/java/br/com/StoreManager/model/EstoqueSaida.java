package br.com.StoreManager.model;

import java.util.Date;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "estoqueSaida")
@Proxy(lazy = false)
public class EstoqueSaida implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column (name="id")
	private Integer id;
	@Column (name="produto_id")
	private String produto_id;
	@Column (name="funcionario_id")
	private String funcionario_id;
	@Column (name="data")
	private Date data;
	@Column (name="qtdSaida")
	private Integer qtdSaida;
	@Column (name="valorPago")
	private Double valorPago;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProduto_id() {
		return produto_id;
	}
	public void setProduto_id(String produto_id) {
		this.produto_id = produto_id;
	}
	public String getFuncionario_id() {
		return funcionario_id;
	}
	public void setFuncionario_id(String funcionario_id) {
		this.funcionario_id = funcionario_id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Integer getQtdSaida() {
		return qtdSaida;
	}
	public void setQtdSaida(Integer qtdSaida) {
		this.qtdSaida = qtdSaida;
	}
	public Double getValorPago() {
		return valorPago;
	}
	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}
}
