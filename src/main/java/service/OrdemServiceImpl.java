package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.IOrdem;
import entitidades.OrdemModel;

@Service
public class OrdemServiceImpl implements IOrdemService {
	
	@Autowired
	private IOrdem daoOrdem;

	
	public void setDaoOrdem(IOrdem daoOrdem) {
		this.daoOrdem = daoOrdem;
	}

	@Override
	public OrdemModel save(OrdemModel ordem) {
		return daoOrdem.save(ordem);
	}

	@Override
	public List<OrdemModel> getAll() {
		return daoOrdem.getAll();
	}

	@Override
	public OrdemModel getOrdemModelById(Long osId) {
		return daoOrdem.getOrdemModelById(osId);
	}

	@Override
	public void deleteOrdemModel(Long osId) {
		daoOrdem.deleteOrdemModel(osId);
	}

	@Override
	public OrdemModel updateColecaoModel(OrdemModel ordem) {
		return daoOrdem.updateColecaoModel(ordem);
	}

}
