package fresher.Team3.Enities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tlb_order_details")
public class OrderDetailsEnity extends BaseEnity{
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id") // foreign key
	private ProductsEnity productsEnityOrderDetails;
	
	@Column(name = "quality" , nullable = true)
	private Integer quality;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id") // foreign key
	private OrdersEnity ordersEnityOrderDetails;

	public ProductsEnity getProductsEnityOrderDetails() {
		return productsEnityOrderDetails;
	}

	public void setProductsEnityOrderDetails(ProductsEnity productsEnityOrderDetails) {
		this.productsEnityOrderDetails = productsEnityOrderDetails;
	}

	public Integer getQuality() {
		return quality;
	}

	public void setQuality(Integer quality) {
		this.quality = quality;
	}

	public OrdersEnity getOrdersEnityOrderDetails() {
		return ordersEnityOrderDetails;
	}

	public void setOrdersEnityOrderDetails(OrdersEnity ordersEnityOrderDetails) {
		this.ordersEnityOrderDetails = ordersEnityOrderDetails;
	}

	public OrderDetailsEnity(Integer id, Date createdDate, Date updatedDate, ProductsEnity productsEnityOrderDetails,
			Integer quality, OrdersEnity ordersEnityOrderDetails) {
		super(id, createdDate, updatedDate);
		this.productsEnityOrderDetails = productsEnityOrderDetails;
		this.quality = quality;
		this.ordersEnityOrderDetails = ordersEnityOrderDetails;
	}

	public OrderDetailsEnity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetailsEnity(Integer id, Date createdDate, Date updatedDate) {
		super(id, createdDate, updatedDate);
		// TODO Auto-generated constructor stub
	}
	
	

}
