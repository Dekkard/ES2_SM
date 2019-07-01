package br.com.StoreManager.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.StoreManager.model.Contato;
import br.com.StoreManager.persistence.ContatoDAOImp;

@ManagedBean
public class ContatoController {
	public void incluir(Contato contato) {
		ContatoDAOImp cc = new ContatoDAOImp();
		cc.incluir(contato);
	}

	public void alterar(Contato contato) {
		ContatoDAOImp cc = new ContatoDAOImp();
		cc.alterar(contato);
	}

	public void excluir(Contato contato) {
		ContatoDAOImp cc = new ContatoDAOImp();
		cc.excluir(contato);
	}

	public List<Contato> listarTodos() {
		ContatoDAOImp cc = new ContatoDAOImp();
		return cc.listarTodos();
	}

	public Contato buscarContato(Integer id) {
		ContatoDAOImp cc = new ContatoDAOImp();
		return cc.buscarContato(id);
	}
}
