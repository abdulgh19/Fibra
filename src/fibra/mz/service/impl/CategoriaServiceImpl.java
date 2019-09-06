package fibra.mz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fibra.mz.dao.CategoriaDao;
import fibra.mz.entity.Categoria;
import fibra.mz.service.CategoriaService;

@Service("categoriaService")
public class CategoriaServiceImpl extends GenericServiceImp<Categoria> implements CategoriaService{
	
	@Autowired
	private CategoriaDao categDao;

}
