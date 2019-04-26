package br.com.StoreManager.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.com.StoreManager.model.Administrador;
import br.com.StoreManager.model.Cliente;
import br.com.StoreManager.model.EstoqueCompra;
import br.com.StoreManager.model.EstoqueVenda;
import br.com.StoreManager.model.Fornecedor;
import br.com.StoreManager.model.FuncionarioCliente;
import br.com.StoreManager.model.FuncionarioFornecedor;
import br.com.StoreManager.model.LocalArmazenamento;
import br.com.StoreManager.model.Produto;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			// loads configuration and mappings
			Configuration configuration = new Configuration().configure();

			configuration.addPackage("br.com.StoreManager.model");
			configuration.addAnnotatedClass(Administrador.class);
			configuration.addAnnotatedClass(Cliente.class);
			configuration.addAnnotatedClass(EstoqueCompra.class);
			configuration.addAnnotatedClass(EstoqueVenda.class);
			configuration.addAnnotatedClass(Fornecedor.class);
			configuration.addAnnotatedClass(FuncionarioFornecedor.class);
			configuration.addAnnotatedClass(FuncionarioCliente.class);
			configuration.addAnnotatedClass(LocalArmazenamento.class);
			configuration.addAnnotatedClass(Produto.class);
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			// builds a session factory from the service registry
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
}
