package fibra.mz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fibra.mz.dao.ClienteDao;
import fibra.mz.entity.Cliente;
import fibra.mz.service.ClienteService;

@Service("clienteService")
public class ClienteServiceImpl extends GenericServiceImp<Cliente> implements ClienteService {

	
	@Autowired
	private ClienteDao clienteDao;
}
