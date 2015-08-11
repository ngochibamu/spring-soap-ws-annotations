package org.chibamu.takeaways;

import orgg.chibamu.takeaways.order.domain.Order;

public interface OrderService {
	
	public String placeOrder(Order order);
	public boolean cancelOrder(String orderRef);
}
