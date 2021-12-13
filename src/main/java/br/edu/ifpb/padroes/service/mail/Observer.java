package br.edu.ifpb.padroes.service.mail;

import br.edu.ifpb.padroes.domain.Order.OrderStatus;

public interface Observer {
	void sinalizarEvento(OrderStatus status);
}
