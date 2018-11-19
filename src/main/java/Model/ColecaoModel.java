package Model;

import java.io.Serializable;
import java.util.UUID;

public class ColecaoModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id = UUID.randomUUID().toString();
	private int ID;
	private String nome;
	private String dtColecao;
	private boolean answer;
	

	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDtColecao() {
		return dtColecao;
	}
	public void setDtColecao(String dtColecao) {
		this.dtColecao = dtColecao;
	}
	public boolean isAnswer() {
		return answer;
	}
	public void setAnswer(boolean answer) {
		this.answer = answer;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
