package br.com.StoreManager.persistence;

import java.util.List;

import br.com.StoreManager.model.Produto;

public interface ProdutoDAO {
	public void incluir(Produto produto);
	public void alterar(Produto produto);
	public void excluir(Produto produto);
	public List<Produto> listarTodos();
	public Produto buscarProduto(Integer id);
}
