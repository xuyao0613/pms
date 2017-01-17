package com.pms.amp.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service("myProducer")
public class MyProducer {
	
	private JmsTemplate jmsQueueTemplate;

	public JmsTemplate getJmsQueueTemplate() {
		return jmsQueueTemplate;
	}
	
	@Autowired
	public void setJmsQueueTemplate(JmsTemplate jmsQueueTemplate) {
		this.jmsQueueTemplate = jmsQueueTemplate;
	}
	
	
	public MyProducer(){
	}
	
	
	
}
