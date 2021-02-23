package br.com.rd.projeto.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name="TB_ESP_MED")
@NamedQuery(name="Especialidade.findAll", query="SELECT t FROM EspecialidadeEntity t") //? consulta, retorna os dados da tabela

public class EspecialidadeEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id //pk
	@GeneratedValue //autoincrement
	@Column(name="ID_ESP_MED")
	private BigInteger idEspecialidade;
	
	@Column(name="DS_ESP_MED")
	private String dsEspecialidade;

	public BigInteger getIdEspecialidade() {
		return idEspecialidade;
	}

	public void setIdEspecialidade(BigInteger idEspecialidade) {
		this.idEspecialidade = idEspecialidade;
	}

	public String getDsEspecialidade() {
		return dsEspecialidade;
	}

	public void setDsEspecialidade(String dsEspecialidade) {
		this.dsEspecialidade = dsEspecialidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}