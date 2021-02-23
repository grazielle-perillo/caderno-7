package br.com.rd.projeto.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name="TB_TIPO_EXAME")
@NamedQuery(name="TipoExame.findAll", query="SELECT t FROM TipoExameEntity t") //? consulta, retorna os dados da tabela

public class TipoExameEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id //pk
	@GeneratedValue //autoincrement
	@Column(name="ID_TIPO_EXAME")
	private BigInteger idTipoExame;
	
	@Column(name="DS_TIPO_EXAME")
	private String dsTipoExame;

	public BigInteger getIdTipoExame() {
		return idTipoExame;
	}

	public void setIdTipoExame(BigInteger idTipoExame) {
		this.idTipoExame = idTipoExame;
	}

	public String getDsTipoExame() {
		return dsTipoExame;
	}

	public void setDsTipoExame(String dsTipoExame) {
		this.dsTipoExame = dsTipoExame;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
