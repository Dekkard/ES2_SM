package br.com.StoreManager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "cliente")
@Proxy(lazy = false)
public class Cliente implements Serializable{
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
}
