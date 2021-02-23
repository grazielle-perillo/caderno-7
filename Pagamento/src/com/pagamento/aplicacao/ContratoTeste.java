package com.pagamento.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import com.pagamento.entidade.Contrato;
import com.pagamento.entidade.Pagamento;
import com.pagamento.servicos.Calculo;

public class ContratoTeste {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		System.out.print("Informe o numero do contrato:");
		int numeroContrato = sc.nextInt();
		System.out.print("Informe a data do contrato neste formato: 00/00/0000");
		Date dataContrato = data.parse(sc.next());
		System.out.print("Informe o valor do contrato: ");
		Double valorContrato = sc.nextDouble();
		
		Contrato contrato = new Contrato(numeroContrato,dataContrato,valorContrato);
		
		System.out.print("Deseja gerar quantas parcelas para pagamento deste contrato? ");
		int numeroParcelas = sc.nextInt();
		
		Calculo calculo = new Calculo(contrato, numeroParcelas);
		
		
		System.out.print("Vencimento das Parcelas:\n");
		for( Pagamento pagamento : contrato.getArrayPagamento()) {
			System.out.print(pagamento);
		}
		
		} catch (ParseException e) {
			System.out.print("\nData informada em formato incorreto \n");
			System.out.print(e.getMessage());
			e.printStackTrace();
		} finally {
		
		sc.close();
		}
	}
}
