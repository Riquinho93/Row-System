package Controller;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;


@SuppressWarnings("unchecked")
public abstract class GenericDao<T, PK> {

	private final EntityManager entityManager;
	private final EntityManagerFactory factory;

	private Class<?> clazz;

	// Constructor
	public GenericDao() {
		this(DaoFactory.entityManagerFactorInstance());
	}

	public GenericDao(EntityManagerFactory factory) {
		this.factory = factory;
		this.entityManager = factory.createEntityManager();
		this.clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	// Fazendo Crud
	public Object excuteQuery(String query, Object... params) {
		Query createQuery = this.entityManager.createQuery(query);

		for (int i = 0; i < params.length; i++) {
			createQuery.setParameter(i, params[i]);
		}

		return createQuery.getResultList();
	}

	public List<T> findAll() {
		return this.entityManager.createQuery("FROM " + this.clazz.getName()).getResultList();
	}

	public T findById(PK pk) {
		return (T) this.entityManager.find(this.clazz, pk);
	}

	public void save(T entity) throws Exception {
		try {
			this.begin();
			this.entityManager.persist(entity);
			this.commit();
		} catch (Exception e) {
			this.rollBack();
			throw e;
		}
	}

	public void update(T entity) throws Exception {
		try {
			this.begin();
			this.entityManager.merge(entity);
			this.commit();

		} catch (Exception e) {
			this.rollBack();
			throw e;
		}
	}

	public void delete(T entity) throws Exception {
		try {
			this.begin();
			this.entityManager.remove(entity);
			this.commit();

		} catch (Exception e) {
			this.rollBack();
			throw e;
		}
	}

	// Transaction methodos

	public void begin() {
		this.entityManager.getTransaction().begin();
	}

	public void commit() {
		this.entityManager.getTransaction().commit();
	}

	public void close() {
		this.entityManager.close();
		this.factory.close();
	}

	public void rollBack() {
		this.entityManager.getTransaction().rollback();
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}
}
