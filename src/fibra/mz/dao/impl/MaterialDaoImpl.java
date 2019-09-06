package fibra.mz.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import fibra.mz.dao.MaterialDao;
import fibra.mz.entity.Categoria;
import fibra.mz.entity.Material;

@Repository
public class MaterialDaoImpl extends GenericDaoImp<Material> implements MaterialDao{

	public MaterialDaoImpl( ) {
		super(Material.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Material> listarMaterialDaCategoria(Categoria categoria) {
		Query query = getCurrentSession().createQuery(" from Material m join fetch m.categorias cat where cat =:cater ");
		query.setParameter("cater", categoria);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Material> listarMaterial(String nome) {
		Query query = getCurrentSession().createQuery("select m from Material m where m.designacao like :designacao");
		query.setParameter("designacao", "%"+nome+"%");
		return query.list();

	}
}
