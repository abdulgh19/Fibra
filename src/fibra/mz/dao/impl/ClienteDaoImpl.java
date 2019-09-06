package fibra.mz.dao.impl;

import org.springframework.stereotype.Repository;

import fibra.mz.dao.ClienteDao;
import fibra.mz.entity.Cliente;

@Repository
public class ClienteDaoImpl extends GenericDaoImp<Cliente> implements ClienteDao{

	public ClienteDaoImpl() {
		super(Cliente.class);
	}

}
