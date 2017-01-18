package Amq;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pms.amp.producer.MyQueueProducer;
import com.pms.amp.producer.MyTopicProducer;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath:spring-mvc.xml","classpath:spring-mybatis.xml","classpath:spring-activemq.xml"})  
public class AmqTest {
	@Autowired
	MyQueueProducer myQueueProducer;
	
	@Autowired
	MyTopicProducer myTopicProducer;
	@Test
	public void testQueue(){
		Assert.assertNotNull(myQueueProducer);
		myQueueProducer.send();
	}
	
	@Test
	public void testTopic(){
		Assert.assertNotNull(myTopicProducer);
		myTopicProducer.send();
	}
}
