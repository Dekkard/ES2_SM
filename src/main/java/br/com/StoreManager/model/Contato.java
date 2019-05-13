package br.com.StoreManager.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "cliente")
@Proxy(lazy = false)
public class Contato implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column (name="id")
	private Integer id;
	@Column (name="cpfCnpj")
	private Integer cpfCnpj;
	@Column (name="nome")
	private String nome;
	@Column (name="email")
	private String email;
	@Column (name="endereco")
	private String endereco;
	@Column (name="telefone")
	private Integer telefone;
	@Column (name="tipo")
	private String tipo;
	@OneToMany (mappedBy="cliente", targetEntity = Movimentacao.class, fetch=FetchType.EAGER)
	private List<Movimentacao> multas;
}
