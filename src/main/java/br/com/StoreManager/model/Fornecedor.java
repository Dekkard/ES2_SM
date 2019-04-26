package br.com.StoreManager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "fornecedor")
@Proxy(lazy = false)
public class Fornecedor implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column (name="id")
	private Integer id;
	@Column (name="cpfcCnpj")
	private Integer cpfcCnpj;
	@Column (name="nome")
	private String nome;
	@Column (name="email")
	private String email;
	@Column (name="endereco")
	private String endereco;
	@Column (name="telefone")
	private Integer telefone;	
}
