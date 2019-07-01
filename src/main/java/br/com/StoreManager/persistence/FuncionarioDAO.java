package br.com.StoreManager.persistence;

import java.util.List;

import br.com.StoreManager.model.Funcionario;

public interface FuncionarioDAO {
	public void incluir(Funcionario func);
	public void alterar(Funcionario func);
	public void excluir(Funcionario func);
	public List<Funcionario> listarTodos();
	public Funcionario buscarFuncionario(Integer id);
}
