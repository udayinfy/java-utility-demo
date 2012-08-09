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
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;

public class JMSProducer {

	public static void main(String[] args) throws JMSException {

		// activeMQ��Ĭ�Ϸ���˿���61616 ��������conf�ļ����µ������ļ����޸Ķ˿�
		ConnectionFactory factory = new ActiveMQConnectionFactory("failover:(tcp://10.2.30.132:61616,tcp://172.17.40.52:61616)");
		Connection conn = factory.createConnection();
		conn.start();

		Queue queue = new ActiveMQQueue("q");
		Topic topic = new ActiveMQTopic("t");
		final Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Message msg = session.createTextMessage("Hello");
		// ���������ߵĻظ�Ŀ��
		msg.setJMSReplyTo(topic);

		MessageProducer producer = session.createProducer(queue);
		for (int i = 0; i < 10; i++) {
			producer.send(session.createTextMessage("msg " + i));
		}
		System.out.println("send over");

		// �������߽��ܵ���Ϣ��ظ�ʱ ��ʱ������������ֳ䵱�������ߵĽ�ɫ
		MessageConsumer consumer2 = session.createConsumer(topic);
		consumer2.setMessageListener(new MessageListener() {
			@Override
			public void onMessage(Message msg1) {
				try {
					System.out.println("2 < <" + ((TextMessage) msg1).getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
