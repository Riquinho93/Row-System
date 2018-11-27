package dao;

import java.util.List;

import entitidades.ColecaoModel;
import entitidades.CoresModel;

public interface ICores {
	public CoresModel save(CoresModel cores);
	public List<CoresModel> getAll();
	public CoresModel getCoresModelById(Long idCores);
	public void deleteCoresModel(Long idCores);
	public CoresModel updateCoresModel(CoresModel cores);
}
