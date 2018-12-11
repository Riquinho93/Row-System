package br.safeerp.dao;

import java.util.List;

import br.safeerp.entitidades.ColecaoModel;
import br.safeerp.entitidades.PecaModel;

public interface IPecaDao {
	public PecaModel save(PecaModel cores);
	public List<PecaModel> getAll();
	public PecaModel getCoresModelById(Long idCores);
	public void deleteCoresModel(Long idCores);
	public PecaModel updateCoresModel(PecaModel cores);
}
