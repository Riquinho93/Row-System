package br.safeerp.dao;

import java.util.List;

import br.safeerp.entitidades.ColecaoModel;


public interface IColecao  {
	
	public ColecaoModel save(ColecaoModel colecao);
	public List<ColecaoModel> getAll();
	public ColecaoModel getColecaoModelById(Long idColecao);
	public void deleteColecaoModel(Long idColecao);
	public ColecaoModel updateColecaoModel(ColecaoModel colecao);
}
