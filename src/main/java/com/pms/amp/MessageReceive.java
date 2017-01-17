package com.pms.amp;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageReceive {
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;// 默认连接用户名
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;// 默认连接密码
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;// 默认连接地址

	public static void main(String[] args) {
		ConnectionFactory connectionFactory;// 连接工厂
		Connection connection = null;// 连接

		Session session;// 会话 接受或者发送消息的线程
		Destination destination;// 消息的目的地

		MessageConsumer messageConsumer;// 消息的消费者

		// 实例化连接工厂
		connectionFactory = new ActiveMQConnectionFactory(MessageReceive.USERNAME, MessageReceive.PASSWORD,
				MessageReceive.BROKEURL);
		final BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();
		ExecutorService service = Executors.newFixedThreadPool(2);
		try {
			// 通过连接工厂获取连接
			connection = connectionFactory.createConnection();
			// 启动连接
			connection.start();
			// 创建session
			session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
			// 创建一个连接HelloWorld的消息队列
			destination = session.createQueue("HelloWorld");
			// 创建消息消费者
			messageConsumer = session.createConsumer(destination);
			service.execute(new DoSthWithMsg1(blockingQueue));
			service.execute(new DoSthWithMsg2(blockingQueue));

			messageConsumer.setMessageListener(new MessageListener() {

				@Override
				public void onMessage(Message message) {
					if (message instanceof TextMessage) {
						TextMessage textMessage = (TextMessage) message;

						try {
							//收到签收，另起一个线程，通知mq服务已经签收
							message.acknowledge();
							blockingQueue.put("收到的消息:" + textMessage.getText());
						} catch (InterruptedException e) {
							e.printStackTrace();
						} catch (JMSException e) {
							e.printStackTrace();
						}
					}
				}
			});

		} catch (JMSException e) {
			e.printStackTrace();
		}

	}
}
