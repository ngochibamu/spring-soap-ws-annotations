package org.chibamu.takeaways.order.service.endpoint;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.chibamu.takeaways.OrderService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import orgg.chibamu.takeaways.order.domain.CancelOrderRequest;
import orgg.chibamu.takeaways.order.domain.CancelOrderResponse;
import orgg.chibamu.takeaways.order.domain.ObjectFactory;
import orgg.chibamu.takeaways.order.domain.PlaceOrderRequest;
import orgg.chibamu.takeaways.order.domain.PlaceOrderResponse;

/**
* <pre>
* This is the endpoint for the {@link OrderService}.
* Requests are simply delegated to the {@link OrderService} for processing.
* Two operations are mapped, using annotation, as specified in the link,
* <a href="http://static.springsource.org/spring-ws/sites/1.5/reference/html/server.html#server-at-endpoint"
* >http://static.springsource.org/spring-ws/sites/1.5/reference/html/server.html#server-at-endpoint</a
* ><ul>
*     <li>placeOrderRequest</li>
*     <li>cancelOrderRequest</li>
* </ul>
* </pre>
*
*/
@Endpoint
public class OrderServicePayloadRootAnnotationEndPoint {

	private static final String TARGET_NAMESPACE="http://org.chibamu.takeaways/OrderService/schema";
    private final OrderService orderService;
    private final ObjectFactory JAXB_OBJECT_FACTORY = new ObjectFactory();
   
    public OrderServicePayloadRootAnnotationEndPoint(OrderService orderService) {
        this.orderService = orderService;
    }

    @PayloadRoot(localPart = "placeOrderRequest", namespace = TARGET_NAMESPACE)
    public JAXBElement<PlaceOrderResponse> getOrder(PlaceOrderRequest placeOrderRequest) {
    	
        PlaceOrderResponse response = JAXB_OBJECT_FACTORY.createPlaceOrderResponse();
        response.setRefNumber(orderService.placeOrder(placeOrderRequest.getOrder()));
        QName qName = new QName(TARGET_NAMESPACE, "placeOrderResponse");
        return new JAXBElement<PlaceOrderResponse>(qName, PlaceOrderResponse.class, response);
    }

    @PayloadRoot(localPart = "cancelOrderRequest", namespace = TARGET_NAMESPACE)
    public JAXBElement<CancelOrderResponse> cancelOrder(
            CancelOrderRequest cancelOrderRequest) {
        CancelOrderResponse response = JAXB_OBJECT_FACTORY.createCancelOrderResponse();
        response.setCancelled(orderService.cancelOrder(cancelOrderRequest.getRefNumber()));
        QName qName = new QName(TARGET_NAMESPACE, "cancelOrderResponse");
        return new JAXBElement<CancelOrderResponse>(qName, CancelOrderResponse.class, response);
    }

}