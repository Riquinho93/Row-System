package entitidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.mail.imap.protocol.UID;
@Entity
@Table(name = "tbpessoa")
public class PessoaModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pessoaId;
	private UID iddPessoa;
	private String pessoa;
	private String tipo;
	
	public Long getPessoaId() {
		return pessoaId;
	}
	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
	}
	public UID getIddPessoa() {
		return iddPessoa;
	}
	public void setIddPessoa(UID iddPessoa) {
		this.iddPessoa = iddPessoa;
	}
	public String getPessoa() {
		return pessoa;
	}
	public void setPessoa(String pessoa) {
		this.pessoa= pessoa;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
