package br.safeerp.entitidades;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.mail.imap.protocol.UID;

@Entity
@Table(name = "tb_colecao")
public class ColecaoModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long colecaoId;
	
	private UID iddColecao;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "dt_saida")
	private String dtEntrada;
	
	private boolean answer;
	@OneToMany(mappedBy = "colecaoId")
	private Collection<ProdutoModel> listOs;
	
	public ColecaoModel() {}

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

	public Collection<ProdutoModel> getListOs() {
		return listOs;
	}

	public void setListOs(Collection<ProdutoModel> listOs) {
		this.listOs = listOs;
	}

	public ColecaoModel(String nome, String dtEntrada) {
		super();
		this.nome = nome;
		this.dtEntrada = dtEntrada;
	}

	public UID getIddColecao() {
		return iddColecao;
	}

	public void setIddColecao(UID iddColecao) {
		this.iddColecao = iddColecao;
	}

	

}
