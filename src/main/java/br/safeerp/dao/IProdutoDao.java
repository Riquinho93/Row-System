package br.safeerp.dao;

import java.util.List;

import br.safeerp.entitidades.ProdutoModel;

public interface IProdutoDao {
	
	public ProdutoModel save(ProdutoModel ordem);
	public List<ProdutoModel> getAll();
	public ProdutoModel getOrdemModelById(Long osId);
	public void deleteOrdemModel(Long osId);
	public ProdutoModel updateColecaoModel(ProdutoModel ordem);
	
}
