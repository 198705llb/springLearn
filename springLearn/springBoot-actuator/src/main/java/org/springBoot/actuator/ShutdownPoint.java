package org.springBoot.actuator;

import org.springframework.beans.BeansException;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@ConfigurationProperties(prefix="endpoints.shutdown")
public class ShutdownPoint extends AbstractEndpoint<String> implements ApplicationContextAware{

	public ShutdownPoint(String id) {
		super(id);
	}

	@Override
	public String invoke() {
		System.err.println("成功关闭了");
		return null;
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		System.err.println("context成功了");
		
	}

}
