package entitidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.mail.imap.protocol.UID;

@Entity
@Table(name = "tbCores")
public class CoresModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long coresId;
	private UID iddCores;
	private String cor;
	private String tam;
	private boolean answer;

	@ManyToOne
	@JoinColumn(name = "osId")
	private OrdemModel osId;
	
	public Long getCoresId() {
		return coresId;
	}

	public void setCoresId(Long coresId) {
		this.coresId = coresId;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getTam() {
		return tam;
	}

	public void setTam(String tam) {
		this.tam = tam;
	}

	public OrdemModel getOsId() {
		return osId;
	}

	public void setOsId(OrdemModel osId) {
		this.osId = osId;
	}
	public boolean isAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}

	public UID getIddCores() {
		return iddCores;
	}

	public void setIddCores(UID iddCores) {
		this.iddCores = iddCores;
	}
	

}
