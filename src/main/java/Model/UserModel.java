package Model;

import java.io.Serializable;
import java.util.UUID;

public class UserModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id = UUID.randomUUID().toString();
	private String nome;
	private boolean gender;
	private String idiom;
	private int idade;
	private boolean answer;
	private String colecao;
	
	
	//Metodos especiais
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String isGender() {
		if (gender == true) {
			return "Masculino";
		}else{
			return "Feminino";
		}
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getIdiom() {
		return idiom;
	}
	public void setIdiom(String idiom) {
		this.idiom = idiom;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public boolean isAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}
	

	public String getColecao() {
		return colecao;
	}
	public void setColecao(String colecao) {
		this.colecao = colecao;
	}
	@Override
	public String toString() {
		return "UserModel [nome=" + nome + ", gender=" + gender + ", idiom=" + idiom + ", idade=" + idade + "]";
	}
	
	
	
}
