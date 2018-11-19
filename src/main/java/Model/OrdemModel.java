package Model;

import java.io.Serializable;
import java.util.UUID;

public class OrdemModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id = UUID.randomUUID().toString();
	private String modelo;
	private boolean answer;
	private String dtOS;
	
	//Metodos especiais
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public boolean isAnswer() {
		return answer;
	}
	public void setAnswer(boolean answer) {
		this.answer = answer;
	}
	public String getDtOS() {
		return dtOS;
	}
	public void setDtOS(String dtOS) {
		this.dtOS = dtOS;
	}
	
	

}
