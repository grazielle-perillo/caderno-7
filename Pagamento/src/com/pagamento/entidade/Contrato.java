package com.pagamento.entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contrato {
	
	private int numeroContrato;
	private Date dataContrato;
	private double valorContrato;
	
	List<Pagamento> ArrayPagamento = new ArrayList<>();
	
	public Contrato (int numero, Date data, double valor) {
		this.numeroContrato = numero;
		this.dataContrato = data;
		this.valorContrato = valor;
	}
	 int getNumeroContrato() {
		return numeroContrato;
	}
	public Date getDataContrato() {
		return dataContrato;
	}
	public double getValorContrato() {
		return valorContrato;
	}
	public List<Pagamento> getArrayPagamento() {
			return ArrayPagamento;
		}
}

