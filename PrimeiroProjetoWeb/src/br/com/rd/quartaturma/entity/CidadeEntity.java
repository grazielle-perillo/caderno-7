package br.com.rd.quartaturma.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


@Entity //indica entidade
@Table(name="TB_CIDADE") //nome tabela igual do banco
@NamedQuery(name="Cidade.findAll", query="SELECT t FROM CidadeEntity t") //? consulta, retorna os dados da tabela
public class CidadeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id //pk
	@GeneratedValue //autoincrement
	@Column(name="ID_CIDADE")
	private BigInteger idCidade;
	
	@Column(name="ID_UF")
	private BigInteger idUf;
	
	@Column(name="CD_CIDADE_IBGE")
	private BigInteger cidadeIbge;
	
	@Column(name="DS_CIDADE")
	private String cidade;

	public BigInteger getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(BigInteger idCidade) {
		this.idCidade = idCidade;
	}

	public BigInteger getIdUf() {
		return idUf;
	}

	public void setIdUf(BigInteger idUf) {
		this.idUf = idUf;
	}

	public BigInteger getCidadeIbge() {
		return cidadeIbge;
	}

	public void setCidadeIbge(BigInteger cidadeIbge) {
		this.cidadeIbge = cidadeIbge;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}