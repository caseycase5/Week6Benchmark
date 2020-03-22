package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

import beans.Order;

@Stateless
@Local(OrdersBusinessInterface.class)
@Alternative
public class AnotherOrdersBusinessService implements OrdersBusinessInterface {

	List<Order> orders =  new ArrayList<Order>();
	
	@Override
	public void test() {
		System.out.println("Hello from the AnotherOrdersBusinessService");

	}
	
	public AnotherOrdersBusinessService() {
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
		// TODO Auto-generated method stub
		
	}

}
