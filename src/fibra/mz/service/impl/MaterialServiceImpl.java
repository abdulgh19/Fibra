package fibra.mz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fibra.mz.dao.MaterialDao;
import fibra.mz.entity.Categoria;
import fibra.mz.entity.Material;
import fibra.mz.service.MaterialService;

@Service("materialService")
public class MaterialServiceImpl extends GenericServiceImp<Material> implements MaterialService{
	
	@Autowired
	private MaterialDao materialDao;

	@Override
	public List<Material> listarMaterialDaCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return materialDao.listarMaterialDaCategoria(categoria);
	}

	@Override
	public List<Material> listarMaterial(String nome) {
		// TODO Auto-generated method stub
		return materialDao.listarMaterial(nome);
	}

}
