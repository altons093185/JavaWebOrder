package dao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import model.entity.Order;

public class OrderDAO {

	private static List<Order> orders = new CopyOnWriteArrayList<>();

	public void save(Order order) {
		orders.add(order);
	}

	public List<Order> findAll() {
		return orders;
	}

	// 刪除一筆資訊
		public void remove(int index) {
			orders.remove(index);
		}
		
		// 修改一筆資訊
		public void update(int index, Order newOrder) {
			orders.set(index, newOrder);
		}
		
		// 取得單筆資料
		public Order getOrder(int index) {
			return orders.get(index);
		}
}
