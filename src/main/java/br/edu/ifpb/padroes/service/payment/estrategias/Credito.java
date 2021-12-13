package br.edu.ifpb.padroes.service.payment.estrategias;

public class Credito implements PagamentoEstrategia {
	public String pagar() {
		return "Do credit card payment!";
	}
}
