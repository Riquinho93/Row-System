package Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbColecao")
public class ColecaoModel implements Serializable{

	private Long colecaoId;
	private String nome;
	private String dtEntrada;
	//private String dtSaida;
	private boolean answer;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getColecaoId() {
		return colecaoId;
	}

	public void setColecaoId(Long colecaoId) {
		this.colecaoId = colecaoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}

	public String getDtEntrada() {
		return dtEntrada;
	}

	public void setDtEntrada(String dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

//	public String getDtSaida() {
//		return dtSaida;
//	}
//
//	public void setDtSaida(String dtSaida) {
//		this.dtSaida = dtSaida;
//	}

}
