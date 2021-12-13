package br.edu.ifpb.padroes.service.payment.estrategias;

public class Boleto implements PagamentoEstrategia {
	public String pagar() {
		return "Do billet payment!";
	}
}
