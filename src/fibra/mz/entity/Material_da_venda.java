package fibra.mz.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;


@Embeddable
@Table(name = "Material_da_venda")
public class Material_da_venda {
	
	//private static final long serialVersionUID = 1L;
	
	@Column(name = "quantidade")
	private int quantidade;

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	

}
