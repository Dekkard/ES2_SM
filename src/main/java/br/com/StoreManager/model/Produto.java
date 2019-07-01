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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "produto")
@Proxy(lazy = false)
@NamedQueries({
	@NamedQuery(name = "Produto.find",query = "SELECT p FROM Produto p"),
	@NamedQuery(name = "Produto.findById",query = "SELECT p FROM Produto p where p.id = :id"),
	@NamedQuery(name = "Produto.findByDescricao",query = "SELECT p FROM Produto p where p.descricao = :descricao")
})
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
	private Integer id;
	@Column (name="descricao")
	private String descricao;
	@Column (name="QTDestoque")
	private Integer QTDestoque;
	@Column (name="marca")
	private String marca;
	@Column (name="valorUnitario")
	private Double valorUnitario;
	@ManyToOne @JoinColumn(name="localArm_id")
	private LocalArmazenamento localArmazenamento;
	@OneToMany(mappedBy = "produto", targetEntity = Movimentacao.class, 
			cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Movimentacao> movimentacao;
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
	public Integer getQTDestoque() {
		return QTDestoque;
	}
	public void setQTDestoque(Integer qTDestoque) {
		QTDestoque = qTDestoque;
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
	public LocalArmazenamento getLocalArmazenamento() {
		return localArmazenamento;
	}
	public void setLocalArmazenamento(LocalArmazenamento localArmazenamento) {
		this.localArmazenamento = localArmazenamento;
	}
	public List<Movimentacao> getMovimentacao() {
		return movimentacao;
	}
	public void setMovimentacao(List<Movimentacao> movimentacao) {
		this.movimentacao = movimentacao;
	}
}
