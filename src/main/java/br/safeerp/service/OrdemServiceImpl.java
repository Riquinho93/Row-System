package br.safeerp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.safeerp.dao.IProdutoDao;
import br.safeerp.entitidades.ProdutoModel;

@Service
public class OrdemServiceImpl implements IOrdemService {
	
	@Autowired
	private IProdutoDao daoOrdem;

	
	public void setDaoOrdem(IProdutoDao daoOrdem) {
		this.daoOrdem = daoOrdem;
	}

	@Override
	public ProdutoModel save(ProdutoModel ordem) {
		return daoOrdem.save(ordem);
	}

	@Override
	public List<ProdutoModel> getAll() {
		return daoOrdem.getAll();
	}

	@Override
	public ProdutoModel getOrdemModelById(Long osId) {
		return daoOrdem.getOrdemModelById(osId);
	}

	@Override
	public void deleteOrdemModel(Long osId) {
		daoOrdem.deleteOrdemModel(osId);
	}

	@Override
	public ProdutoModel updateColecaoModel(ProdutoModel ordem) {
		return daoOrdem.updateColecaoModel(ordem);
	}

}
