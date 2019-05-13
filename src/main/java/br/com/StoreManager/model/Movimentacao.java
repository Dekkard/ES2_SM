package br.com.StoreManager.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "estoqueEntrada")
@Proxy(lazy = false)
public class Movimentacao implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column (name="id")
	private Integer id;
	@Column (name="data")
	private Date data;
	@Column (name="qtd")
	private Integer qtd;
	@Column (name="valor")
	private Double valor;
	@Column (name="tipo")
	private String tipo;
	@Column (name="id_produto")
	private Integer id_produto;
	@Column (name="id_funcionario")
	private Integer id_funcionario;
	@ManyToOne @JoinColumn(name="id_contato")
	private Contato contato;
	@ManyToOne @JoinColumn(name="id_funcionario")
	private Funcionario funcionario;
	@ManyToOne @JoinColumn(name="id_produto")
	private Produto produto;
}
