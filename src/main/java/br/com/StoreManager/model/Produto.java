package br.com.StoreManager.model;

import java.util.Date;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "produto")
@Proxy(lazy = false)
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column (name="id")
	private Integer id;
	@Column (name="descricao")
	private String descricao;
	@Column (name="QTDestoque")
	private String QTDestoque;
	@Column (name="marca")
	private String marca;
	@Column (name="valorUnitario")
	private Double valorUnitario;
	@Column (name="dataCompra")
	private Date dataCompra;
	@Column (name="validade")
	private Integer validade;
	@Column (name="codBarras")
	private String codBarras;
}
