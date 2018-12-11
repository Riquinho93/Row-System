package br.safeerp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.safeerp.entitidades.ProdutoModel;

@Repository
public class ProdutoImplDao implements IProdutoDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public ProdutoModel save(ProdutoModel ordem) {
		em.persist(ordem);
		return ordem;
	}

	@Override
	public List<ProdutoModel> getAll() {
		Query req = em.createQuery("select * from tbos");
		return req.getResultList();
	}

	@Override
	public ProdutoModel getOrdemModelById(Long osId) {
		ProdutoModel ordem = em.find(ProdutoModel.class, osId);
		return ordem;
	}

	@Override
	public void deleteOrdemModel(Long osId) {
		em.remove(getOrdemModelById(osId));

	}

	@Override
	public ProdutoModel updateColecaoModel(ProdutoModel ordem) {
		em.merge(ordem);
		return ordem;
	}

}
