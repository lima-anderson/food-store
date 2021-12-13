package br.edu.ifpb.padroes.service.payment.estrategias;

public class Paypal implements PagamentoEstrategia {

	public String pagar() {
		return "Do paypal payment!";
	}
}
