package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import entitidades.OrdemModel;

@Repository
public class OrdemImpl implements IOrdem {

	@PersistenceContext
	private EntityManager em;

	@Override
	public OrdemModel save(OrdemModel ordem) {
		em.persist(ordem);
		return ordem;
	}

	@Override
	public List<OrdemModel> getAll() {
		Query req = em.createQuery("select * from tbos");
		return req.getResultList();
	}

	@Override
	public OrdemModel getOrdemModelById(Long osId) {
		OrdemModel ordem = em.find(OrdemModel.class, osId);
		return ordem;
	}

	@Override
	public void deleteOrdemModel(Long osId) {
		em.remove(getOrdemModelById(osId));

	}

	@Override
	public OrdemModel updateColecaoModel(OrdemModel ordem) {
		em.merge(ordem);
		return ordem;
	}

}
