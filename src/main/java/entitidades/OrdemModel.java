package entitidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbos")
public class OrdemModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long osId;
	private String modelo;
	private boolean answer;
	private String dtSaida;
	private String dtEntrada;
	private String largMedida;
	private String tamanho;
	private String tecido;
	private String codigo;
	private Double valor;
	private String composicao;
	private String obs;
	@ManyToOne
	@JoinColumn(name = "idColecao")
	private ColecaoModel idColecao;

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

	public String getLargMedida() {
		return largMedida;
	}

	public void setLargMedida(String largMedida) {
		this.largMedida = largMedida;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getTecido() {
		return tecido;
	}

	public void setTecido(String tecido) {
		this.tecido = tecido;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getComposicao() {
		return composicao;
	}

	public void setComposicao(String composicao) {
		this.composicao = composicao;
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

	public OrdemModel(String modelo, boolean answer, String dtSaida, String dtEntrada, String largMedida,
			String tamanho, String tecido, String codigo, Double valor, String composicao, String obs) {
		super();
		this.modelo = modelo;
		this.answer = answer;
		this.dtSaida = dtSaida;
		this.dtEntrada = dtEntrada;
		this.largMedida = largMedida;
		this.tamanho = tamanho;
		this.tecido = tecido;
		this.codigo = codigo;
		this.valor = valor;
		this.composicao = composicao;
		this.obs = obs;
	}

	public OrdemModel() {
		super();
	}

}
