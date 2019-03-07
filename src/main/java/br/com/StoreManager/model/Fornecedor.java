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
	@Column (name="nome")
	private String nome;
	@Column (name="telefone")
	private Integer telefone;
	@Column (name="email")
	private String email;
	@Column (name="cpfCnpj")
	private Integer cpfCnpj;
	@Column (name="telefoneReserva")
	private Integer telefoneReserva;
	
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
	public Integer getTelefone() {
		return telefone;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(Integer cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public Integer getTelefoneReserva() {
		return telefoneReserva;
	}
	public void setTelefoneReserva(Integer telefoneReserva) {
		this.telefoneReserva = telefoneReserva;
	}
}
