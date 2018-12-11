package br.safeerp.service;

import java.util.List;

import br.safeerp.entitidades.ColecaoModel;

public interface IColecaoService {

	public void save(ColecaoModel colecao);

	public List<ColecaoModel> listar();

	public ColecaoModel buscarById(Long idColecao);

	public void delete(Long idColecao);

//	public ColecaoModel updateColecaoModel(ColecaoModel colecao);

}
