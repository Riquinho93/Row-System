package entitidades;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.mail.imap.protocol.UID;

@Entity
@Table(name = "tbos")
public class OrdemModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long osId;
	private UID iddOS;
	private String modelo;
	private boolean answer;
	private String dtSaida;
	private String dtEntrada;
	private String largura;
	private String tipoEnfesto;
	private String obs;
	private String status;

	
	@ManyToOne
	@JoinColumn(name = "idColecao")
	private ColecaoModel idColecao;
	
	@OneToMany(mappedBy = "entradaEstoqueProduto", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@Column(name = "ID_ENTRADA_ESTOQUE_PRODUTO")
//	@Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private Collection<OrdemModel> listCoresTam;

	public Long getOsId() {
		return osId;
	}

	public ColecaoModel getIdColecao() {
		return idColecao;
	}

	public void setIdColecao(ColecaoModel idColecao) {
		this.idColecao = idColecao;
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

	public OrdemModel(String modelo, boolean answer, String dtSaida, String dtEntrada, String largMedida,
			String tamanho, String tecido, String codigo, Double valor, String composicao, String obs) {
		super();
		this.modelo = modelo;
		this.answer = answer;
		this.dtSaida = dtSaida;
		this.dtEntrada = dtEntrada;
		this.largura = largMedida;
		this.obs = obs;
	}
	

	public UID getIddOS() {
		return iddOS;
	}

	public void setIddOS(UID iddOS) {
		this.iddOS = iddOS;
	}

	public Collection<OrdemModel> getListCoresTam() {
		return listCoresTam;
	}

	public void setListCoresTam(Collection<OrdemModel> listCoresTam) {
		this.listCoresTam = listCoresTam;
	}

	public OrdemModel() {
		super();
	}

}
