package br.com.StoreManager.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "localArmazenamento")
@Proxy(lazy = false)
public class LocalArmazenamento implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column (name="id")
	private Integer id;
	@Column (name="descricao")
	private String descricao;
	@Column (name="endereco")
	private String endereco;
	@Column (name="lote")
	private String lote;
	@Column (name="qtdMax")
	private Integer qtdMax;
	@OneToMany(mappedBy = "LocalArmazenamento", targetEntity = Movimentacao.class, 
			cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Produto> produto;
}
