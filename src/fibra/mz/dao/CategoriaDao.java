package fibra.mz.dao;

import java.util.List;

import fibra.mz.entity.Categoria;

public interface CategoriaDao extends GenericDao<Categoria> {
	
	public List<Categoria> findByNome(String nome);

}
