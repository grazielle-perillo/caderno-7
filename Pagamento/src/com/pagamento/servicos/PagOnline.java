package com.pagamento.servicos;

public interface PagOnline {
	public double gerarTaxa(double valor, int x);
	public double gerarTaxaPagamento(double valor);
}
