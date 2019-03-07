package br.com.StoreManager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "categoria")
@Proxy(lazy = false)
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "formaPagam_id")
	private Integer formaPagam_id;
	@Column(name = "totalPago")
	private Double totalPago;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFormaPagam_id() {
		return formaPagam_id;
	}

	public void setFormaPagam_id(Integer formaPagam_id) {
		this.formaPagam_id = formaPagam_id;
	}

	public Double getTotalPago() {
		return totalPago;
	}

	public void setTotalPago(Double totalPago) {
		this.totalPago = totalPago;
	}
}
