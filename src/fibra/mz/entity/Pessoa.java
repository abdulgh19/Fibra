package fibra.mz.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="param_pessoa")
@Access(AccessType.FIELD)
public class Pessoa extends IdEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "pessoa_apelido")
	private String apelido;

	@Column(name = "pessoa_nome")
	private String nome;

	@Column(name = "pessoa_genero")
	private String genero;

	@Column(name = "pessoa_email")
	private String email;

	@Column(name = "pessoa_telefone")
	private long telefone;

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

}
