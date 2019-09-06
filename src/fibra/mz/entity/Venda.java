package fibra.mz.entity;


import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Venda")
@Access(AccessType.FIELD)
public class Venda extends IdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Column(name = "totalVenda") //Este campo serve tanto para Empresa como para Cliente Singular
	private Double totalVenda;

	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	
    @ManyToMany(mappedBy = "vendas")
    private List<Material> materiais;

	public Double getTotalVenda() {
		return totalVenda;
	}


	public void setTotalVenda(Double totalVenda) {
		this.totalVenda = totalVenda;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
