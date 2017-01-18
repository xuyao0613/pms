package com.pms.amp.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service("myQueueProducer")
public class MyQueueProducer {

	private JmsTemplate jmsQueueTemplate;

	public JmsTemplate getJmsQueueTemplate() {
		return jmsQueueTemplate;
	}

	@Autowired
	public void setJmsQueueTemplate(JmsTemplate jmsQueueTemplate) {
		this.jmsQueueTemplate = jmsQueueTemplate;
	}


	public void send(){
		jmsQueueTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session arg0) throws JMSException {
				return arg0.createTextMessage("s");
			}
		});
	}
}
