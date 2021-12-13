package br.edu.ifpb.padroes.domain;

import br.edu.ifpb.padroes.domain.Order.OrderStatus;
import br.edu.ifpb.padroes.service.mail.Observer;

public class Customer implements Observer {

	private Long id;

	private String name;

	private String email;

	private String address;

	public void notificacao(OrderStatus status) {
		System.out.println("Status da compra: " + status);
	}

	public Customer() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public void sinalizarEvento(OrderStatus status) {
		notificacao(status);
//		System.out.println("Status da compra: " + status);
	}
}
