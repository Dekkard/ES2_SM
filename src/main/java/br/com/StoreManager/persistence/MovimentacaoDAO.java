package br.com.StoreManager.persistence;

import java.util.List;

import br.com.StoreManager.model.Movimentacao;

public interface MovimentacaoDAO {
	public void incluir(Movimentacao movimentacao);
	public void alterar(Movimentacao movimentacao);
	public void excluir(Movimentacao movimentacao);
	public List<Movimentacao> listarTodos();
	public Movimentacao buscarMovimentacao(Integer id);
}
