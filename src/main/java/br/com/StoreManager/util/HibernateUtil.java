package br.com.StoreManager.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import br.com.StoreManager.model.Contato;
import br.com.StoreManager.model.Funcionario;
import br.com.StoreManager.model.LocalArmazenamento;
import br.com.StoreManager.model.Movimentacao;
import br.com.StoreManager.model.Produto;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			// loads configuration and mappings
			Configuration configuration = new Configuration().configure();

			configuration.addPackage("br.com.StoreManager.model");
			configuration.addAnnotatedClass(Contato.class);
			configuration.addAnnotatedClass(Movimentacao.class);
			configuration.addAnnotatedClass(Funcionario.class);
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
