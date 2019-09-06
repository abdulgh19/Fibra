package fibra.mz.entity;


import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
@Access(AccessType.FIELD)
public class Cliente extends IdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Column(name = "nome") //Este campo serve tanto para Empresa como para Cliente Singular
	private String nome;
	
	@Column (name = "apelido")
	private String apelido;
	
	@Column (name = "telfone")
	private int telefone;
	
	@Column (name = "nuit")
	private int nuit;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name="tipoCliente_id")
	private TipoCliente tipoCliente;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public int getNuit() {
		return nuit;
	}

	public void setNuit(int nuit) {
		this.nuit = nuit;
	}
	
	




}
