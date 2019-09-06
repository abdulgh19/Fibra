package fibra.mz.entity;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "param_categoria")
@Access(AccessType.FIELD)
public class Categoria extends IdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "designacao")
	private String designacao;
	
	@OneToMany (mappedBy = "categoria", fetch = FetchType.LAZY)
	private List<Material> material;

	public List<Material> getMaterial() {
		return material;
	}

	public void setMaterial(List<Material> material) {
		this.material = material;
	}

	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}




}
