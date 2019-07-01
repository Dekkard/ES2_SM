package br.com.StoreManager.controller;

import br.com.StoreManager.model.LocalArmazenamento;
import br.com.StoreManager.model.Produto;
import br.com.StoreManager.util.HibernateUtil;
@SuppressWarnings("all")
public class Test {
	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
		LocalArmController lac = new LocalArmController();
		LocalArmazenamento la = new LocalArmazenamento();
		la.setDescricao("Storage Suprime");
		la.setQtdMax(100000);
		lac.setLocalArmazenamento(la);
		lac.incluir();
//		List<LocalArmazenamento> lista = lac.listarTodos();
//		if(lista != null) {
//			for(LocalArmazenamento la : lista) {
//				System.out.println(la.getDescricao());
//			}
//		}
//		LocalArmazenamento la = lac.buscarLocalArmazenamento(1);
//		System.out.println(la.getId());
//		Produto produto = new Produto();
//		ProdutoController pc = new ProdutoController();
//		produto.setDescricao("Arroz");
//		produto.setLocalArmazenamento(la);
//		produto.setMarca("São João");
//		produto.setQTDestoque(50);
//		produto.setValorUnitario(10.00);
//		pc.setProduto(produto);
//		pc.incluir();
	}
}
