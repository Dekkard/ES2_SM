package br.com.StoreManager.persistence;

import java.util.List;

import br.com.StoreManager.model.LocalArmazenamento;

public interface LocalArmDAO {
	public void incluir(LocalArmazenamento localArm);
	public void alterar(LocalArmazenamento localArm);
	public void excluir(LocalArmazenamento localArm);
	public List<LocalArmazenamento> listarTodos();
	public LocalArmazenamento buscarLocalArm(Integer id);
	public LocalArmazenamento buscarLocalArmDescricao(String descricao);
}
