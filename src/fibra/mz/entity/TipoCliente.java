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
@Table(name = "param_tipoCliente")
@Access(AccessType.FIELD)
public class TipoCliente extends IdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "designacao")
	private String designacao;
	
	@OneToMany (mappedBy = "tipoCliente", fetch = FetchType.LAZY)
	private List<Cliente> cliente;

	public List<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}

	public String getDesignacao() {
		return designacao;
	}

	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}



}
