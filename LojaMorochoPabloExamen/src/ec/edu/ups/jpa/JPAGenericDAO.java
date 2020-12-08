package ec.edu.ups.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

import ec.edu.ups.dao.GenericDAO;

public class JPAGenericDAO<T, ID> implements GenericDAO<T, ID> {
	
	private Class<T> persistentClass;
	protected EntityManager em;
	
	public JPAGenericDAO(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
		this.em = Persistence.createEntityManagerFactory("LojaMorochoPabloExamen").createEntityManager();
	}
	
	
	public void create(T entity) {
		em.getTransaction().begin();
		try {
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ERROR: JPAGenericDAO:create " + e);
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
	}

	public T read(ID id) {
		return em.find(persistentClass, id);
	}

	public void update(T entity) {
		em.getTransaction().begin();
		try {
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ERROR: JPAGenericDAO:update " + e);
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
	}

	public void delete(T entity) {
		em.getTransaction().begin();
		try {
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ERROR: JPAGenericDAO:delete " + e);
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
	}

	public void deleteById(ID id) {
		T entity = this.read(id);
		if(entity !=null)
			this.delete(entity);
	}

	public List<T> find() {
		em.getTransaction().begin();
		List<T> lista = null;
		try {
		    CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		    cq.select(cq.from(persistentClass));
		    lista = em.createQuery(cq).getResultList();
		    em.getTransaction().commit();
		} catch (Exception e) {
		    e.printStackTrace();
		}
		return lista;
	}

}
