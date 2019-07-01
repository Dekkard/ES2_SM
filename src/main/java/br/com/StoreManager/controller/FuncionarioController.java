package br.com.StoreManager.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.StoreManager.model.Funcionario;
import br.com.StoreManager.persistence.FuncionarioDAOImp;

@ManagedBean
public class FuncionarioController {
	public void incluir(Funcionario funcionario) {
		FuncionarioDAOImp fc = new FuncionarioDAOImp();
		fc.incluir(funcionario);
	}

	public void alterar(Funcionario funcionario) {
		FuncionarioDAOImp fc = new FuncionarioDAOImp();
		fc.alterar(funcionario);
	}

	public void excluir(Funcionario funcionario) {
		FuncionarioDAOImp fc = new FuncionarioDAOImp();
		fc.excluir(funcionario);
	}

	public List<Funcionario> listarTodos() {
		FuncionarioDAOImp fc = new FuncionarioDAOImp();
		return fc.listarTodos();
	}

	public Funcionario buscarFuncionario(Integer id) {
		FuncionarioDAOImp fc = new FuncionarioDAOImp();
		return fc.buscarFuncionario(id);
	}
}
