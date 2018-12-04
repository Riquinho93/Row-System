package br.safeerp.entitidades;

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
public class PecaModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long coresId;
	private String cor;
	private String tam;
	private int qtd = 1;
	private double qtdTotal = 0;
	private boolean answer;

	@ManyToOne
	@JoinColumn(name = "osId")
	private ProdutoModel osId;

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

	public ProdutoModel getOsId() {
		return osId;
	}

	public void setOsId(ProdutoModel osId) {
		this.osId = osId;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public boolean isAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}

	public double getQtd_total() {
		return qtdTotal;
	}

	public void setQtd_total(double qtd_total) {
		this.qtdTotal = qtd_total;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
