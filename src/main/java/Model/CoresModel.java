package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbCores")
public class CoresModel {
	
	private Integer coresId; 
	private String cor;
	private String tam;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCoresId() {
		return coresId;
	}
	public void setCoresId(Integer coresId) {
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
	
	
}
