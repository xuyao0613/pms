package com.pms.amp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSend2 {
	// 默认连接用户名
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	// 默认连接密码
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	// 默认连接地址
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;

	// 发送的消息数量
	private static final int SENDNUM = 100;
	public static AtomicInteger aInt = new AtomicInteger(0);

	public static void main(String[] args) {
		// 连接工厂
		ConnectionFactory connectionFactory;
		// 连接
		Connection connection = null;
		// 会话 接受或者发送消息的线程
		final Session session;
		// 消息的目的地
		final Destination destination;
		// 消息生产者
		final MessageProducer messageProducer;
		// 实例化连接工厂
		connectionFactory = new ActiveMQConnectionFactory(MessageSend2.USERNAME, MessageSend2.PASSWORD,
				MessageSend2.BROKEURL);

		ExecutorService service = Executors.newCachedThreadPool(); // 创建一个线程池

		try {
			// 通过连接工厂获取连接
			connection = connectionFactory.createConnection();
			// 启动连接
			connection.start();
			// 创建session
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			// 创建一个名称为HelloWorld的消息队列
			destination = session.createQueue("HelloWorld");
			// 创建消息生产者
			messageProducer = session.createProducer(null);
			// 发送消息
			//

			for (int i = 0; i < MessageSend2.SENDNUM; i++) {
				Runnable runnable = new Runnable() {
					@Override
					public void run() {
						while (true) {
							// try {
							// Thread.sleep(500);
							// } catch (InterruptedException e1) {
							// e1.printStackTrace();
							// }
							try {
								sendMessage(destination,session, messageProducer);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}

					}
				};
				service.execute(runnable);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// if (connection != null) {
			// try {
			//// connection.close();
			//// service.shutdown();
			// } catch (JMSException e) {
			// e.printStackTrace();
			// }
			// }
		}
	}

	public synchronized static void sendMessage(Destination destination,Session session, MessageProducer messageProducer) throws Exception {
		// for (int i = 0; i < Producer2.SENDNUM; i++) {
		// 创建一条文本消息
		TextMessage message = session.createTextMessage("ActiveMQ 发送消息" + aInt.incrementAndGet());
		System.out.println("发送消息：Activemq 发送消息");
		// 通过消息生产者发出消息
		messageProducer.send(destination, message, DeliveryMode.NON_PERSISTENT, 4, 4000);
		// session.commit();
		// try {
		// Thread.sleep(1000);
		// } catch (InterruptedException e1) {
		// e1.printStackTrace();
		// }
		// }

	}
}
