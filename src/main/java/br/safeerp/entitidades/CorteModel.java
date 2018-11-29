package br.safeerp.entitidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.mail.imap.protocol.UID;

@Entity
@Table(name = "tbCortes")
public class CorteModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cortesId;
	private UID iddCortes;
	private String cor;
	private String tam;
	public Long getCortesId() {
		return cortesId;
	}
	public void setCortesId(Long cortesId) {
		this.cortesId = cortesId;
	}
	public UID getIddCortes() {
		return iddCortes;
	}
	public void setIddCortes(UID iddCortes) {
		this.iddCortes = iddCortes;
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
