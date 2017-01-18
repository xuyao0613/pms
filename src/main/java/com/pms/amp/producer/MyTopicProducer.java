package com.pms.amp.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service("myTopicProducer")
public class MyTopicProducer {
	private JmsTemplate jmsTopicTemplate;

	public JmsTemplate getjmsTopicTemplate() {
		return jmsTopicTemplate;
	}

	@Autowired
	public void setjmsTopicTemplate(JmsTemplate jmsTopicTemplate) {
		this.jmsTopicTemplate = jmsTopicTemplate;
	}


	public void send(){
		jmsTopicTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session arg0) throws JMSException {
				return arg0.createTextMessage("s");
			}
		});
	}
}
