package fibra.mz.service;

import java.util.List;

import fibra.mz.entity.Categoria;
import fibra.mz.entity.Material;

public interface MaterialService extends GenericService<Material> {

	public List<Material> listarMaterialDaCategoria(Categoria categoria);
	public List<Material> listarMaterial(String nome);

}
