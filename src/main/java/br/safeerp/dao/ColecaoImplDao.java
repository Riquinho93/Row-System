package br.safeerp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.safeerp.entitidades.ColecaoModel;

@Repository("daoColecao")
public class ColecaoImplDao implements IColecaoDao {

	@Autowired
	private SessionFactory factory;
	

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public void save(ColecaoModel colecao) {
		 factory.getCurrentSession().saveOrUpdate(colecao);
	}

	@Override
	public List<ColecaoModel> listar() {
		return (List<ColecaoModel>) factory.getCurrentSession().createQuery("from tb_colecao").list();
	}
	

	@Override
	public ColecaoModel buscarById(Long idColecao) {
		return (ColecaoModel) factory.getCurrentSession().get(ColecaoModel.class, idColecao);
	}

	@Override
	public void delete(Long idColecao) {
		factory.getCurrentSession().delete(buscarById(idColecao));

	}

//	@Override
//	public ColecaoModel updateColecaoModel(ColecaoModel colecao) {
//		em.merge(colecao);
//		return colecao;
//	}

}
