package fibra.mz.dao;

import java.util.List;

import fibra.mz.entity.Categoria;
import fibra.mz.entity.Material;

public interface MaterialDao extends GenericDao<Material> {

	
	public List<Material> listarMaterialDaCategoria(Categoria categoria);
	public List<Material> listarMaterial(String nome);
}
