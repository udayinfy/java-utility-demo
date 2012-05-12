package demo.avtivemq;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;

public class JMSConsumer {

	public static void main(String[] args) throws JMSException {

		ConnectionFactory factory = new ActiveMQConnectionFactory(
				"tcp://192.168.243.138:61616");
		Connection conn = factory.createConnection();
		conn.start();

		Queue queue = new ActiveMQQueue("q");
		final Topic top = new ActiveMQTopic("t");
		final Session session = conn.createSession(false,
				Session.AUTO_ACKNOWLEDGE);

		MessageConsumer consumer = session.createConsumer(queue);
		final MessageProducer p = session.createProducer(top);
		
		consumer.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message msg1) {
				try {
					System.out.println("1 < <" + msg1);
					MessageProducer p = session.createProducer(top);

					Message msg = session.createTextMessage("haha");
					// 给回复消息设置目标 这里的目标就是Producer里设置的
					msg.setJMSDestination(msg1.getJMSReplyTo());
					p.send(msg);
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
	}

}



