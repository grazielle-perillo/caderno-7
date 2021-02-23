package br.com.rd.quartaturma.vo;

public class Cidade {
	private Integer idCidade;
	private Integer idUf;
	private Integer cidadeIbge; 
	private String cidade;
	
	public Integer getIdCidade() {
		return idCidade;
	}
	public void setIdCidade(Integer idCidade) {
		this.idCidade = idCidade;
	}
	public Integer getIdUf() {
		return idUf;
	}
	public void setIdUf(Integer idUf) {
		this.idUf = idUf;
	}
	public Integer getCidadeIbge() {
		return cidadeIbge;
	}
	public void setCidadeIbge(Integer cidadeIbge) {
		this.cidadeIbge = cidadeIbge;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
}