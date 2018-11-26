package dao;

import java.util.List;

import entitidades.OrdemModel;

public interface IOrdem {
	
	public OrdemModel save(OrdemModel ordem);
	public List<OrdemModel> getAll();
	public OrdemModel getOrdemModelById(Long osId);
	public void deleteOrdemModel(Long osId);
	public OrdemModel updateColecaoModel(OrdemModel ordem);
	
}
