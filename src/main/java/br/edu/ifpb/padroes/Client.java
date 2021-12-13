package br.edu.ifpb.padroes;

import br.edu.ifpb.padroes.domain.Order;
import br.edu.ifpb.padroes.service.order.OrderManager;
import br.edu.ifpb.padroes.service.payment.GeradorPagamento;
import br.edu.ifpb.padroes.service.payment.estrategias.Boleto;
import br.edu.ifpb.padroes.service.payment.estrategias.PagamentoEstrategia;

public class Client {
	public static void main(String[] args) {

		Order order = new Order();
		OrderManager orderManager = new OrderManager(order);
		PagamentoEstrategia boleto = new Boleto();
		GeradorPagamento gerador = new GeradorPagamento(boleto);
		System.out.println(gerador);
		orderManager.cancelOrder();
//		orderManager.payOrder(boleto);

	}
}

 