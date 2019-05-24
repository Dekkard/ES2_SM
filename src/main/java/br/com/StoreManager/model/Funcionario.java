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
@Table(name = "Funcionario")
@Proxy(lazy = false)
public class Funcionario implements Serializable{
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
	@Column (name="perfil")
	private String perfil;
	@OneToMany(mappedBy = "Funcionario", targetEntity = Movimentacao.class, 
			cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Movimentacao> movimentacao;
}
