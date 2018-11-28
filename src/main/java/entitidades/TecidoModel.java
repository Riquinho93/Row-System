package entitidades;

import java.io.Serializable;

import com.sun.mail.imap.protocol.UID;

public class TecidoModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long tecidoId;
	private UID iddTecido;
	private String tecido;
	private String cor;
	private String codigo;
	private Double valor = 0.0;
	private String composicao;
	
	
	public Long getTecidoId() {
		return tecidoId;
	}
	public void setTecidoId(Long tecidoId) {
		this.tecidoId = tecidoId;
	}
	public UID getIddTecido() {
		return iddTecido;
	}
	public void setIddTecido(UID iddTecido) {
		this.iddTecido = iddTecido;
	}
	public String getTecido() {
		return tecido;
	}
	public void setTecido(String tecido) {
		this.tecido = tecido;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
