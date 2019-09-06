package fibra.mz.dao.impl;

import org.springframework.stereotype.Repository;

import fibra.mz.dao.VendaDao;
import fibra.mz.entity.Venda;

@Repository
public class VendaDaoImpl extends GenericDaoImp<Venda> implements VendaDao{

	public VendaDaoImpl() {
		super(Venda.class);
	}

}
