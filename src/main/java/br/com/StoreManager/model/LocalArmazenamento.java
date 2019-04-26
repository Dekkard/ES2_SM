package br.com.StoreManager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
}
