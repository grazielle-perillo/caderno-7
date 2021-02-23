package com.pagamento.entidade;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pagamento{
	
	private SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
	private Date dataParcela;
	private Double valorParcela;
	
	public Pagamento(Date dataParcela, Double valorParcela) {
		this.dataParcela = dataParcela;
		this.valorParcela = valorParcela;
	}
	protected Date getDataParcela() {
		return dataParcela;
	}
	protected Double getValorParcela() {
		return valorParcela;
	}
	@Override
	public String toString() {
		return data.format(dataParcela) + " - " + String.format("R$%.2f", valorParcela)+ "\n";
	}
}