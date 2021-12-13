package br.edu.ifpb.padroes.service.order;

import br.edu.ifpb.padroes.domain.Customer;
import br.edu.ifpb.padroes.domain.Order;
import br.edu.ifpb.padroes.service.log.LogHandler;
import br.edu.ifpb.padroes.service.log.LogService;
import br.edu.ifpb.padroes.service.mail.EmailNotification;
import br.edu.ifpb.padroes.service.mail.Observer;
import br.edu.ifpb.padroes.service.mail.Subject;
import br.edu.ifpb.padroes.service.payment.estrategias.PagamentoEstrategia;

public class OrderManager {

	public OrderManager(Order order) {
		this.order = order;
	}

	private Order order;

	private EmailNotification emailNotification = new EmailNotification();

	private PagamentoEstrategia paymentService;

	private LogService logService = new LogService(new LogHandler(LogHandler.LogHandlerType.FILE));

	private Subject s = new Subject();
	private Observer c = new Customer();

	public void payOrder(PagamentoEstrategia paymentService) {
		order.setStatus(Order.OrderStatus.IN_PROGRESS);

		s.adicionar(c);
		s.setStatus(order.getStatus());
		try {
			paymentService.pagar();
			order.setStatus(Order.OrderStatus.PAYMENT_SUCCESS);
			s.setStatus(order.getStatus());
			c.sinalizarEvento(order.getStatus());
//			emailNotification.sendMailNotification(String.format("Order %d completed successfully", order.getId()));
			logService.info("payment finished");
		} catch (Exception e) {
			logService.error("payment refused");
			order.setStatus(Order.OrderStatus.PAYMENT_REFUSED);
			s.setStatus(order.getStatus());
//			emailNotification.sendMailNotification(String.format("Order %d refused", order.getId()));
		}
	}

	public void cancelOrder() {
		order.setStatus(Order.OrderStatus.CANCELED);
		s.setStatus(order.getStatus());
		c.sinalizarEvento(order.getStatus());
//		emailNotification.sendMailNotification(String.format("Order %d canceled", order.getId()));
		logService.debug(String.format("order %d canceled", order.getId()));
	}

}