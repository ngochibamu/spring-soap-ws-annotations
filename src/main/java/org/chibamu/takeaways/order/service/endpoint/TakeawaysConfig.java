package org.chibamu.takeaways.order.service.endpoint;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class TakeawaysConfig extends WsConfigurerAdapter{

	private static final String TARGET_NAMESPACE="http://org.chibamu.takeaways/OrderService/schema";
	
	/*
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext){
		MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
		messageDispatcherServlet.setApplicationContext(applicationContext);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(messageDispatcherServlet, "/tkws/*");
	}*/
	
	@Bean (name = "orderService")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema takeAwaySchema){
		DefaultWsdl11Definition defaultWsdlDef = new DefaultWsdl11Definition();
		defaultWsdlDef.setPortTypeName("OrderService");
		defaultWsdlDef.setLocationUri("/tkws");
		defaultWsdlDef.setSchema(takeAwaySchema);
		defaultWsdlDef.setTargetNamespace(TARGET_NAMESPACE);
		return defaultWsdlDef;		
	}
	
	@Bean
	public XsdSchema takeAwaySchema(){
		return new SimpleXsdSchema(new ClassPathResource("schema/OrderService.xsd"));
	}
	
}
