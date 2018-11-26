package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import entitidades.ColecaoModel;

@Repository
public class ColecaoImpl implements IColecao {

	@PersistenceContext
	private EntityManager em;
	

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public ColecaoModel save(ColecaoModel colecao) {
		em.persist(colecao);
		return colecao;
	}

	@Override
	public List<ColecaoModel> getAll() {
		Query req = em.createQuery("select * from tbcolecao;");
		return req.getResultList();
	}
	

	@Override
	public ColecaoModel getColecaoModelById(Long idColecao) {
		ColecaoModel col = em.find(ColecaoModel.class, idColecao);
		return col;
	}

	@Override
	public void deleteColecaoModel(Long idColecao) {
		em.remove(getColecaoModelById(idColecao));

	}

	@Override
	public ColecaoModel updateColecaoModel(ColecaoModel colecao) {
		em.merge(colecao);
		return colecao;
	}

}
