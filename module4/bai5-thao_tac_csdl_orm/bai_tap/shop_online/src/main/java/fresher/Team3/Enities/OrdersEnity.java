package fresher.Team3.Enities;

import java.math.BigDecimal;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_order")
public class OrdersEnity extends BaseEnity {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id") // foreign key
	private UsersEnity usersEnityOrders;

	@Column(name = "total_price", precision = 13, scale = 2, nullable = true)
	private BigDecimal totalPrice;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "shipping_id") // foreign key
	private ShipperEnity shipperEnityOrders;

	@Column(name = "status", nullable = true)
	private Integer status;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "contact_id") // foreign key
	private ContactsEnity contactsEnityOrder;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "ordersEnityOrderDetails") // Ten Property
																										// trong
	private Set<OrderDetailsEnity> orderDetailsEnities = new HashSet<OrderDetailsEnity>();

	public UsersEnity getUsersEnityOrders() {
		return usersEnityOrders;
	}

	public void setUsersEnityOrders(UsersEnity usersEnityOrders) {
		this.usersEnityOrders = usersEnityOrders;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public ShipperEnity getShipperEnityOrders() {
		return shipperEnityOrders;
	}

	public void setShipperEnityOrders(ShipperEnity shipperEnityOrders) {
		this.shipperEnityOrders = shipperEnityOrders;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public ContactsEnity getContactsEnityOrder() {
		return contactsEnityOrder;
	}

	public void setContactsEnityOrder(ContactsEnity contactsEnityOrder) {
		this.contactsEnityOrder = contactsEnityOrder;
	}

	public Set<OrderDetailsEnity> getOrderDetailsEnities() {
		return orderDetailsEnities;
	}

	public void setOrderDetailsEnities(Set<OrderDetailsEnity> orderDetailsEnities) {
		this.orderDetailsEnities = orderDetailsEnities;
	}

	public OrdersEnity(Integer id, Date createdDate, Date updatedDate, UsersEnity usersEnityOrders,
			BigDecimal totalPrice, ShipperEnity shipperEnityOrders, Integer status, ContactsEnity contactsEnityOrder,
			Set<OrderDetailsEnity> orderDetailsEnities) {
		super(id, createdDate, updatedDate);
		this.usersEnityOrders = usersEnityOrders;
		this.totalPrice = totalPrice;
		this.shipperEnityOrders = shipperEnityOrders;
		this.status = status;
		this.contactsEnityOrder = contactsEnityOrder;
		this.orderDetailsEnities = orderDetailsEnities;
	}

	public OrdersEnity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrdersEnity(Integer id, Date createdDate, Date updatedDate) {
		super(id, createdDate, updatedDate);
		// TODO Auto-generated constructor stub
	}

}
