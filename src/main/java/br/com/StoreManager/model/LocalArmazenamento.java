package br.com.StoreManager.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;	
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "localArmazenamento")
@Proxy(lazy = false)
@NamedQueries({
	@NamedQuery(name = "LocalArmazenamento.find",query = "SELECT l FROM LocalArmazenamento l"),
	@NamedQuery(name = "LocalArmazenamento.findById",query = "SELECT l FROM LocalArmazenamento l where l.id = :id"),
	@NamedQuery(name = "LocalArmazenamento.findByDescricao",query = "SELECT l FROM LocalArmazenamento l where l.descricao = :descricao")
})
public class LocalArmazenamento implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
	private Integer id;
	@Column (name="descricao")
	private String descricao;
	@Column (name="endereco")
	private String endereco;
	@Column (name="lote")
	private String lote;
	@Column (name="qtdMax")
	private Integer qtdMax;
	@OneToMany(mappedBy = "localArmazenamento", targetEntity = Produto.class, 
			cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Produto> produto;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getLote() {
		return lote;
	}
	public void setLote(String lote) {
		this.lote = lote;
	}
	public Integer getQtdMax() {
		return qtdMax;
	}
	public void setQtdMax(Integer qtdMax) {
		this.qtdMax = qtdMax;
	}
	public List<Produto> getProduto() {
		return produto;
	}
	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
}
