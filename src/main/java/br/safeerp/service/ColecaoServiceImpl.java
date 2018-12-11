package br.safeerp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.safeerp.dao.ColecaoImpl;
import br.safeerp.dao.IColecao;
import br.safeerp.entitidades.ColecaoModel;

@Service
public class ColecaoServiceImpl implements IColecaoService {
	
	private IColecao daoColecao;
	@Autowired
	public void setDaoColecao(ColecaoImpl daoColecao) {
		this.daoColecao = daoColecao;
	}

	
//	 public ColecaoServiceImpl() {}

	@Override
	public ColecaoModel save(ColecaoModel colecao) {
		return daoColecao.save(colecao);
	}

	@Override
	public List<ColecaoModel> getAll() {
		return daoColecao.getAll();
	}

	@Override
	public ColecaoModel getColecaoModelById(Long idColecao) {
		return daoColecao.getColecaoModelById(idColecao);
	}

	@Override
	public void deleteColecaoModel(Long idColecao) {
		daoColecao.deleteColecaoModel(idColecao);
	}

	@Override
	public ColecaoModel updateColecaoModel(ColecaoModel colecao) {
		return daoColecao.updateColecaoModel(colecao);
	}


}
