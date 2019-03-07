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
	@Column (name="nome")
	private String nome;
	@Column (name="descricao")
	private String descricao;
	@Column (name="categoria_id")
	private Integer categoria_id;
	@Column (name="fornecedor_id")
	private Integer fornecedor_id;
	@Column (name="localArm_id")
	private Integer localArm_id;
	@Column (name="tipoUnidade_id")
	private Integer tipoUnidade_id;
	@Column (name="marca")
	private String marca;
	@Column (name="valorUnitario")
	private Double valorUnitario;
	@Column (name="dataValidade")
	private Date dataValidade;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getCategoria_id() {
		return categoria_id;
	}
	public void setCategoria_id(Integer categoria_id) {
		this.categoria_id = categoria_id;
	}
	public Integer getFornecedor_id() {
		return fornecedor_id;
	}
	public void setFornecedor_id(Integer fornecedor_id) {
		this.fornecedor_id = fornecedor_id;
	}
	public Integer getLocalArm_id() {
		return localArm_id;
	}
	public void setLocalArm_id(Integer localArm_id) {
		this.localArm_id = localArm_id;
	}
	public Integer getTipoUnidade_id() {
		return tipoUnidade_id;
	}
	public void setTipoUnidade_id(Integer tipoUnidade_id) {
		this.tipoUnidade_id = tipoUnidade_id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public Date getDataValidade() {
		return dataValidade;
	}
	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
}
