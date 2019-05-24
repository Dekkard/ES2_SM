package br.com.StoreManager.model;

import java.util.Date;
import java.util.List;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Produto")
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
	@ManyToOne @JoinColumn(name="id_localArm")
	private LocalArmazenamento localArmazenamento;
	@OneToMany(mappedBy = "Produto", targetEntity = Movimentacao.class, 
			cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Movimentacao> movimentacao;
}
