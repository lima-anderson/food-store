package br.edu.ifpb.padroes.service.payment.estrategias;

public class Debito implements PagamentoEstrategia {
	
	public String pagar() {
		return "Do debit  payment!";
	}
}
