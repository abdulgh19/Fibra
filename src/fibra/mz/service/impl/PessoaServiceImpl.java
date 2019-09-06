package fibra.mz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fibra.mz.dao.PessoaDao;
import fibra.mz.entity.Pessoa;
import fibra.mz.service.PessoaService;

@Service("pessoaService")
public class PessoaServiceImpl extends GenericServiceImp<Pessoa> implements PessoaService{
	
	@Autowired
	private PessoaDao pesDao;

}
