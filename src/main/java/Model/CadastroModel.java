package Model;

import java.io.Serializable;

public class CadastroModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String sobrenome;
	private String email;
	private String endereco;
	private String telefone;
	private String dtnascimento;
	private boolean gender = false;
	private int idade;
	private String name = "Estrangeiro";
	private Boolean idioms = false;
	private String text;
	
	//Metodos especiais
    public CadastroModel(String wrapped)
    {
        this.name = wrapped;
    }
    public CadastroModel(){}
    public String getName()
    {
        return name;
    }
 
    public void setName(String wrapped)
    {
        this.name = wrapped;
    }
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public String getDtnascimento() {
		return dtnascimento;
	}
	public void setDtnascimento(String dtnascimento) {
		this.dtnascimento = dtnascimento;
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
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
    

	

	public String getIdioms() {
		if (this.idioms == true) {
			return "Sim";
		}else{
			return "Não";
		}
		
	}
	public void setIdioms(Boolean idioms) {
		this.idioms = idioms;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "CadastroModel [nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + ", endereco="
				+ endereco + ", telefone=" + telefone + ", dtnascimento=" + dtnascimento + ", gender=" + gender
				+ ", idade=" + idade + ", name=" + name + ", idioms=" + idioms + ", text=" + text + "]";
	}
	
	
	
	
	
	

}
