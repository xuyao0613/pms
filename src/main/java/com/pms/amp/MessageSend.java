package com.pms.amp;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSend {
	// 默认连接用户名
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
	// 默认连接密码
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	// 默认连接地址
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;

	// 发送的消息数量
	private static final int SENDNUM = 20;
	public static AtomicInteger aInt = new AtomicInteger(0);

	public static void main(String[] args) {
		// 连接工厂
		ConnectionFactory connectionFactory;
		// 连接
		Connection connection = null;
		// 会话 接受或者发送消息的线程
		final Session session;
		// 消息的目的地
		Destination destination;
		// 消息生产者
		final MessageProducer messageProducer;
		// 实例化连接工厂
		connectionFactory = new ActiveMQConnectionFactory(MessageSend.USERNAME, MessageSend.PASSWORD, MessageSend.BROKEURL);

		ExecutorService service = Executors.newCachedThreadPool(); // 创建一个线程池
		final CountDownLatch cdAnswer = new CountDownLatch(SENDNUM);
		final CountDownLatch cdOrder = new CountDownLatch(1);// 构造方法参数指定计数的次数

		try {
			// 通过连接工厂获取连接
			connection = connectionFactory.createConnection();
			// 启动连接
			connection.start();
			// 创建session
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			// 创建一个名称为HelloWorld的消息队列
			destination = session.createQueue("HelloWorld");
			// 创建消息生产者
			messageProducer = session.createProducer(destination);
			// 发送消息
			// sendMessage(session,messageProducer);

			for (int i = 0; i < MessageSend.SENDNUM; i++) {
				Runnable runnable = new Runnable() {
					@Override
					public void run() {
						System.out.println("线程" + Thread.currentThread().getName() + "正准备接受命令");
						try {
							cdOrder.await();
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
						try {
							Thread.sleep(100);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
						// 创建一条文本消息
						TextMessage message;
						try {
							System.out.println("线程" + Thread.currentThread().getName() + "已接受命令");
							String msg = "ActiveMQ 消息" + aInt.incrementAndGet();
							message = session.createTextMessage(msg);
							messageProducer.send(message);
							System.out.println("线程" + Thread.currentThread().getName() + "发送" + msg);
						} catch (JMSException e) {
							e.printStackTrace();
						} finally {
							cdAnswer.countDown();
						}

					}
				};
				service.execute(runnable);
			}
			Thread.sleep(100);  
			
			cdOrder.countDown();
			System.out.println("线程" + Thread.currentThread().getName() + "已发送命令，正在等待结果");
			cdAnswer.await();
			System.out.println("线程" + Thread.currentThread().getName() + "已收到所有响应结果");
			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
					service.shutdown();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void sendMessage(Session session, MessageProducer messageProducer) throws Exception {
		for (int i = 0; i < MessageSend.SENDNUM; i++) {
			// 创建一条文本消息
			TextMessage message = session.createTextMessage("ActiveMQ 发送消息" + i);
			System.out.println("发送消息：Activemq 发送消息" + i);
			// 通过消息生产者发出消息
			messageProducer.send(message);
		}

	}
}
