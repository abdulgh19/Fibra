package fibra.mz.dao.impl;

import org.springframework.stereotype.Repository;

import fibra.mz.dao.CategoriaDao;
import fibra.mz.dao.TipoClienteDao;
import fibra.mz.entity.Categoria;
import fibra.mz.entity.TipoCliente;

@Repository
public class TipoClienteDaoImpl extends GenericDaoImp<TipoCliente> implements TipoClienteDao {

	public TipoClienteDaoImpl() {
		super(TipoCliente.class);
		// TODO Auto-generated constructor stub
	}

}
