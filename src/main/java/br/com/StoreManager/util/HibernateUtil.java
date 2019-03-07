package br.com.StoreManager.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.com.StoreManager.model.Administrador;
import br.com.StoreManager.model.Categoria;
import br.com.StoreManager.model.Cliente;
import br.com.StoreManager.model.Compra;
import br.com.StoreManager.model.EstoqueEntrada;
import br.com.StoreManager.model.EstoqueSaida;
import br.com.StoreManager.model.FormaPagamento;
import br.com.StoreManager.model.Fornecedor;
import br.com.StoreManager.model.Funcionario;
import br.com.StoreManager.model.LocalArmazenamento;
import br.com.StoreManager.model.Produto;
import br.com.StoreManager.model.TipoDoc;
import br.com.StoreManager.model.TipoUnidade;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			// loads configuration and mappings
			Configuration configuration = new Configuration().configure();

			configuration.addPackage("br.com.StoreManager.model");
			configuration.addAnnotatedClass(Administrador.class);
			configuration.addAnnotatedClass(Categoria.class);
			configuration.addAnnotatedClass(Cliente.class);
			configuration.addAnnotatedClass(Compra.class);
			configuration.addAnnotatedClass(EstoqueEntrada.class);
			configuration.addAnnotatedClass(EstoqueSaida.class);
			configuration.addAnnotatedClass(FormaPagamento.class);
			configuration.addAnnotatedClass(Fornecedor.class);
			configuration.addAnnotatedClass(Funcionario.class);
			configuration.addAnnotatedClass(LocalArmazenamento.class);
			configuration.addAnnotatedClass(Produto.class);
			configuration.addAnnotatedClass(TipoDoc.class);
			configuration.addAnnotatedClass(TipoUnidade.class);
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			// builds a session factory from the service registry
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}
}
