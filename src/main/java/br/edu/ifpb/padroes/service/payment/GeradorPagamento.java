package br.edu.ifpb.padroes.service.payment;

import br.edu.ifpb.padroes.service.payment.estrategias.PagamentoEstrategia;

public class GeradorPagamento {

	private PagamentoEstrategia estrategia;

	public GeradorPagamento(PagamentoEstrategia estrategia) {
		this.estrategia = estrategia;
	}

	public PagamentoEstrategia getEstrategia() {
		return estrategia;
	}

	@Override
	public String toString() {
		return estrategia.pagar();
	}

}
