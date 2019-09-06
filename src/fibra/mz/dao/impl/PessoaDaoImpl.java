package fibra.mz.dao.impl;

import org.springframework.stereotype.Repository;

import fibra.mz.dao.PessoaDao;
import fibra.mz.entity.Pessoa;

@Repository
public class PessoaDaoImpl extends GenericDaoImp<Pessoa> implements PessoaDao{

	public PessoaDaoImpl( ) {
		super(Pessoa.class);
		// TODO Auto-generated constructor stub
	}

}
