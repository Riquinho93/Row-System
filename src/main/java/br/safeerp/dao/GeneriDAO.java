package br.safeerp.dao;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.safeerp.hibernateUtil.HibernateUtil;

public class GeneriDAO {
	private Class classe;
	private Session session;

//	public AbstractDAO(){
//		this.classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//		setSession(new HibernateUtil().getSessionFactory());
//	}

	public void setSession(SessionFactory sf) {
		this.session = sf.openSession();
	}

	public void save(T t) {
		this.session.beginTransaction();
		this.session.save(t);
		this.session.close();
	}

	public void delete(T t) {
		this.session.beginTransaction();
		this.session.delete(t);
		this.session.close();
	}

	public void alter(T t) {
		this.session.beginTransaction();
		this.session.update(t);
		this.session.close();
	}

	public List<T> findAll(T t) {
		this.session.beginTransaction();
		return this.session.createCriteria(this.classe).list();
	}

}
