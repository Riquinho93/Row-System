package br.safeerp.service;

import java.util.List;

import br.safeerp.entitidades.ColecaoModel;

public interface IColecaoService {

	public ColecaoModel save(ColecaoModel colecao);

	public List<ColecaoModel> getAll();

	public ColecaoModel getColecaoModelById(Long idColecao);

	public void deleteColecaoModel(Long idColecao);

	public ColecaoModel updateColecaoModel(ColecaoModel colecao);

}
