package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import beans.Order;

@Stateless
@Local(OrdersBusinessInterface.class)
@Alternative
public class OrdersBusinessService implements OrdersBusinessInterface {
	
	
	public OrdersBusinessService service;

	List<Order> orders = new ArrayList<Order>();
	
	@Resource(mappedName="java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	@Resource(mappedName="java:/jms/queue/Order")
	private Queue queue;

	
	@Override
	public void test() {
		System.out.println("Hello from the OrdersBusinessService");

	}
	
	public OrdersBusinessService() {
		orders.add(new Order("Mark", "Chapter 1", "Verse 1", "The beginning of the good news about Jesus the Messiah, the Son of God,"));
		orders.add(new Order("Mark", "Chapter 1", "Verse 2", "as it is written in Isaiah the prophet: I will send my messenger ahead of you,"));
		orders.add(new Order("Mark", "Chapter 1", "Verse 3", "a voice of one calling in the wilderness, Prepare the way for the Lord, make straight paths for him"));
		orders.add(new Order("Mark", "Chapter 1", "Verse 4", " And so John the Baptist appeared in the wilderness, preaching a baptism of repentance for the forgiveness of sins."));
		orders.add(new Order("Mark", "Chapter 1", "Verse 5", "The whole Judean countryside and all the people of Jerusalem went out to him. Confessing their sins, they were baptized by him in the Jordan River."));
		orders.add(new Order("Mark", "Chapter 1", "Verse 6", "John wore clothing made of camel’s hair, with a leather belt around his waist, and he ate locusts and wild honey."));
		orders.add(new Order("Mark", "Chapter 1", "Verse 7", "And this was his message: “After me comes the one more powerful than I, the straps of whose sandals I am not worthy to stoop down and untie."));
		orders.add(new Order("Mark", "Chapter 1", "Verse 8", "I baptize you with water, but he will baptize you with the Holy Spirit."));
	
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return orders;
	}

	@Override
	public void setOrders(List<Order> orders) {
		this.orders = orders;
		
	}

	@Override
	public void sendOrder(Order order) {
		
		// Send a Message for an Order
		try {
			Connection connection = connectionFactory.createConnection();
			Session  session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer messageProducer = session.createProducer(queue);
			TextMessage message1 = session.createTextMessage();
			TextMessage message2 = session.createTextMessage();
			
			message1.setText("This is test message");
			messageProducer.send(message1);
			
			messageProducer.send(message2);
			
			connection.close();
			System.out.println("This is the test message.");
		
			} 
			catch (JMSException e) 
			{
			e.printStackTrace();
			}
		
	}

}
