package fibra.mz.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import fibra.mz.dao.CategoriaDao;
import fibra.mz.entity.Categoria;

@Repository
public class CategoriaDaoImpl extends GenericDaoImp<Categoria> implements CategoriaDao {

	public CategoriaDaoImpl() {
		super(Categoria.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Categoria> findByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
