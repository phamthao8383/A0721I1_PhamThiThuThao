package fresher.Team3.Enities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_shipers_transport")
public class ShipperEnity extends BaseEnity{
	
	@Column(name = "name", length = 200, nullable = false)
	private String name;
	
	
	@Column(name = "price", precision = 13, scale = 2, nullable = false)
	private BigDecimal price;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "shipperEnityOrders") // Ten Property trong
	private Set<OrdersEnity> ordersEnities = new HashSet<OrdersEnity>();


	public Set<OrdersEnity> getOrdersEnities() {
		return ordersEnities;
	}


	public void setOrdersEnities(Set<OrdersEnity> ordersEnities) {
		this.ordersEnities = ordersEnities;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BigDecimal getPrice() {
		return price;
	}


	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public ShipperEnity(Integer id, Date createdDate, Date updatedDate, String name, BigDecimal price,
			Set<OrdersEnity> ordersEnities) {
		super(id, createdDate, updatedDate);
		this.name = name;
		this.price = price;
		this.ordersEnities = ordersEnities;
	}


	public ShipperEnity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ShipperEnity(Integer id, Date createdDate, Date updatedDate) {
		super(id, createdDate, updatedDate);
		// TODO Auto-generated constructor stub
	}
	
	

}
