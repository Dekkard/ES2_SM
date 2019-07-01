package br.com.StoreManager.controller;

import java.util.ArrayList;
import java.util.List;

//import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.StoreManager.model.LocalArmazenamento;
import br.com.StoreManager.persistence.LocalArmDAOImp;

@ManagedBean(name = "localArmMB")
@RequestScoped
public class LocalArmController {
	private LocalArmazenamento localArm;
	private List<LocalArmazenamento> lista;
	private LocalArmDAOImp lac;
	
	public LocalArmController() {
		this.localArm = new LocalArmazenamento();
		this.lista = new ArrayList<LocalArmazenamento>();
		this.lac = new LocalArmDAOImp();
	}
	
	public LocalArmazenamento getLocalArmazenamento() {
		return localArm;
	}
	public void setLocalArmazenamento(LocalArmazenamento localArm) {
		this.localArm = localArm;
	}
	public List<LocalArmazenamento> getLista() {
		return lista;
	}
	public void setLista(List<LocalArmazenamento> lista) {
		this.lista = lista;
	}
	
	public void incluir() {
		lac = new LocalArmDAOImp();
		lac.incluir(localArm);
	}

	public void alterar() {
		lac = new LocalArmDAOImp();
		lac.alterar(localArm);
	}
	public void excluir() {
		lac = new LocalArmDAOImp();
		lac.excluir(localArm);
	}
	public List<LocalArmazenamento> listarTodos() {
		lac = new LocalArmDAOImp();
		return lac.listarTodos();
	}
	public LocalArmazenamento buscarLocalArmazenamento(Integer id) {
		lac = new LocalArmDAOImp();
		return lac.buscarLocalArm(id);
	}
	public LocalArmazenamento buscarLocalArmazenamentoDescricao(String descricao) {
		lac = new LocalArmDAOImp();
		return lac.buscarLocalArmDescricao(descricao);
	}
//	@PostConstruct
//	public void init() {
//		lista = listarTodos();
//	}
}
