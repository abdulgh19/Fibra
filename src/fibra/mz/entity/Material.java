package fibra.mz.entity;


import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "param_material")
@Access(AccessType.FIELD)
public class Material extends IdEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "designacao")
	private String designacao;
	
	@Column(name="valorDeCompra")
	private Double valorDeCompra;
	
	
	@Column(name="valorDeVenda")
	private Double valorDeVenda;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	
    @ManyToMany
    @JoinTable(
        name = "Material_da_venda",
        joinColumns = @JoinColumn(name = "material_id"),
        inverseJoinColumns = @JoinColumn(name = "venda_id")
    )
    private List<Venda> vendas;


	public Double getValorDeCompra() {
		return valorDeCompra;
	}


	public void setValorDeCompra(Double valorDeCompra) {
		this.valorDeCompra = valorDeCompra;
	}


	public Double getValorDevenda() {
		return valorDeVenda;
	}


	public void setValorDevenda(Double valorDevenda) {
		this.valorDeVenda = valorDevenda;
	}


	public String getDesignacao() {
		return designacao;
	}


	public void setDesignacao(String designacao) {
		this.designacao = designacao;
	}



	public Categoria getCategoria() {
		return categoria;
	}



	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Venda> getVendas() {
		return vendas;
	}


	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}


	@Override
	public String toString() {
		return "Material [designacao=" + designacao + ", categoria="
				+ categoria + "]";
	}
	
	
	
	
	

}
