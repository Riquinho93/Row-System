package br.safeerp.entitidades;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class ProdutoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long osId;

	private String modelo;
	private boolean answer;
	private String dtSaida;
	private String dtEntrada;
	private String largura;
	private String tipoEnfesto;
	private String obs;
	private String status;
//
//	@ManyToOne
//	@JoinColumn(name = "id_colecao")
//	private ColecaoModel idColecao;

//	@OneToMany(mappedBy = "entradaEstoqueProduto", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@Column(name = "ID_ENTRADA_ESTOQUE_PRODUTO")
	// @Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
//	private Collection<ProdutoModel> listCoresTam;

	public Long getOsId() {
		return osId;
	}

	public void setOs_id(Long osId) {
		this.osId = osId;
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

	public String getDtSaida() {
		return dtSaida;
	}

	public void setDtSaida(String dtSaida) {
		this.dtSaida = dtSaida;
	}

	public String getDtEntrada() {
		return dtEntrada;
	}

	public void setDtEntrada(String dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public String getLargura() {
		return largura;
	}

	public void setLargura(String largura) {
		this.largura = largura;
	}

	public String getTipoEnfesto() {
		return tipoEnfesto;
	}

	public void setTipoEnfesto(String tipoEnfesto) {
		this.tipoEnfesto = tipoEnfesto;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public void setOsId(Long osId) {
		this.osId = osId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ProdutoModel(String modelo, String largura, String tipoEnfesto, String dtEntrada, String dtSaida,
			String status) {
		super();
		this.modelo = modelo;
		this.largura = largura;
		this.tipoEnfesto = tipoEnfesto;
		this.dtEntrada = dtEntrada;
		this.dtSaida = dtSaida;
		this.status = status;
	}

	public ProdutoModel() {
		super();
	}

}
