package br.com.StoreManager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "administrador")
@Proxy(lazy = false)
public class Administrador implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "perfil")
	private String perfil;
}
