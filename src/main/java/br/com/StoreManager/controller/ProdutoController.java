package br.com.StoreManager.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.StoreManager.model.Produto;
import br.com.StoreManager.persistence.ProdutoDAOImp;

@ManagedBean(name = "ProdutoMB")
@RequestScoped
public class ProdutoController {
	private Produto produto;
	private List<Produto> lista;
	private ProdutoDAOImp pc;
	
	public ProdutoController() {
		this.produto = new Produto();
		this.lista = new ArrayList<Produto>();
		this.pc = new ProdutoDAOImp();
	}
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public List<Produto> getLista() {
		return lista;
	}
	public void setLista(List<Produto> lista) {
		this.lista = lista;
	}
	
	public void incluir() {
		pc = new ProdutoDAOImp();
		pc.incluir(produto);
	}
	public void alterar() {
		pc = new ProdutoDAOImp();
		pc.alterar(produto);
	}
	public void excluir() {
		pc = new ProdutoDAOImp();
		pc.excluir(produto);
	}
	public List<Produto> listarTodos() {
		pc = new ProdutoDAOImp();
		return pc.listarTodos();
	}
	public Produto buscarProduto(Integer id) {
		pc = new ProdutoDAOImp();
		return pc.buscarProduto(id);
	}
}
