package de.telekom.jpaassociationonetomany.model;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

	@Entity
	@Table(name = "order_tbl")
	//Umbenennung der Tabelle in der DB, weil Order in SQL ein Schlüsselword ist
	public class Order {
		
		@Id
		@GeneratedValue
		private Long orderId;
		
		
		private String orderDescription;
		
		@OneToMany
		@JoinColumn(name="fk_order")
		private List<OrderItem> listOrderItem;
		
		public Order() {}
		
		
		
		public Order(String orderDescription, List<OrderItem> listOrderItem) {
			super();
			this.orderDescription = orderDescription;
			this.listOrderItem = listOrderItem;
		}






		public Long getOrderId() {
			return orderId;
		}

		
		public String getOrderDescription() {
			return orderDescription;
		}

		public void setOrderDescription(String orderDescription) {
			this.orderDescription = orderDescription;
		}

		public List<OrderItem> getListOrderItem() {
			return listOrderItem;
		}

		public void setListOrderItem(List<OrderItem> listOrderItem) {
			this.listOrderItem = listOrderItem;
		}

		@Override
		public String toString() {
			return "Order [orderId=" + orderId + ", orderDescription=" + orderDescription + ", listOrderItem="
					+ listOrderItem + "]";
		}
	
		
}
