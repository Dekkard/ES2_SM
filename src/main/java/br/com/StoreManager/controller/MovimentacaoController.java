package br.com.StoreManager.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.StoreManager.model.Movimentacao;
import br.com.StoreManager.persistence.MovimentacaoDAOImp;

@ManagedBean
public class MovimentacaoController {
	public void incluir(Movimentacao movimentacao) {
		MovimentacaoDAOImp mc = new MovimentacaoDAOImp();
		mc.incluir(movimentacao);
	}

	public void alterar(Movimentacao movimentacao) {
		MovimentacaoDAOImp mc = new MovimentacaoDAOImp();
		mc.alterar(movimentacao);
	}

	public void excluir(Movimentacao movimentacao) {
		MovimentacaoDAOImp mc = new MovimentacaoDAOImp();
		mc.excluir(movimentacao);
	}

	public List<Movimentacao> listarTodos() {
		MovimentacaoDAOImp mc = new MovimentacaoDAOImp();
		return mc.listarTodos();
	}

	public Movimentacao buscarProduto(Integer id) {
		MovimentacaoDAOImp mc = new MovimentacaoDAOImp();
		return mc.buscarMovimentacao(id);
	}
}
