package com.pagamento.servicos;

import java.util.Calendar;
import java.util.Date;
import com.pagamento.entidade.Contrato;
import com.pagamento.entidade.Pagamento;

public class Calculo implements PagOnline{

	@Override
	public double gerarTaxa(double valor, int i) {
		return valor = valor +((valor/100)*i);
	}	
	@Override
	public double gerarTaxaPagamento(double valor) {
		return valor = valor +((valor/100)*2);
	}
	
	public Calculo(Contrato contrato, int numero) {
		double parcela = (contrato.getValorContrato()/ numero);
		for (int i = 1; i <= numero; i++) {
			Date novaData = setMes(contrato.getDataContrato() , i);
			double parcelaJuros = gerarTaxa(parcela, i);
			double jurosPag = gerarTaxaPagamento(parcelaJuros);
			contrato.getArrayPagamento().add(new Pagamento(novaData, jurosPag));
		}
	}
	private Date setMes(Date data, int numero) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.MONTH, numero);	
		return calendar.getTime();
	}
}
