package br.com.StoreManager.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.StoreManager.model.LocalArmazenamento;
import br.com.StoreManager.util.HibernateUtil;

@SuppressWarnings("all")
public class LocalArmDAOImp implements LocalArmDAO{
	private Session session;

	@Override
	public void incluir(LocalArmazenamento localArm) {
		session = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(localArm);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void alterar(LocalArmazenamento localArm) {
		session = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(localArm);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void excluir(LocalArmazenamento localArm) {
		session = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.delete(localArm);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<LocalArmazenamento> listarTodos() {
		session = null;
		List<LocalArmazenamento> lista = null;
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			lista = session.getNamedQuery("LocalArmazenamento.find").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			return lista;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return lista;
	}

	@Override
	public LocalArmazenamento buscarLocalArm(Integer id) {
		session = null;
		LocalArmazenamento localArm = new LocalArmazenamento();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			localArm = (LocalArmazenamento) session.getNamedQuery("LocalArmazenamento.findById").
					setParameter("id", id).setMaxResults(1).uniqueResult();
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return localArm;
	}
	public LocalArmazenamento buscarLocalArmDescricao(String descricao) {
		session = null;
		LocalArmazenamento localArm = new LocalArmazenamento();
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			localArm = (LocalArmazenamento) session.getNamedQuery("LocalArmazenamento.findByDescricao").
					setParameter("descricao", descricao).setMaxResults(1).uniqueResult();
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return localArm;
	}
}
