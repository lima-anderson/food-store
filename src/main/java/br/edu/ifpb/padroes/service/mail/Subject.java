package br.edu.ifpb.padroes.service.mail;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.padroes.domain.Order.OrderStatus;

public class Subject {
	private List<Observer> observers = new ArrayList();
	private OrderStatus status;

	public void adicionar(Observer observer) {
		observers.add(observer);
	}

	public void notificarObservers(OrderStatus status) {
		for (Observer o : observers) {
			o.sinalizarEvento(status);
		}
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus novoStatus) {
		if (novoStatus != this.status) {
			this.status = novoStatus;
			this.notificarObservers(novoStatus);
		}
	}
}
