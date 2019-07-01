package br.com.StoreManager.persistence;

import java.util.List;

import br.com.StoreManager.model.Contato;

public interface ContatoDAO {
	public void incluir(Contato contato);
	public void alterar(Contato contato);
	public void excluir(Contato contato);
	public List<Contato> listarTodos();
	public Contato buscarContato(Integer id);
}
