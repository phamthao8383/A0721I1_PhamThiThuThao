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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name = "tbl_products")

public class ProductsEnity extends BaseEnity{
	
	
	@Column(name = "name", length = 200, nullable = false)
	private String name;
	/*
	 * kieu long text
	 */
	@Lob
	@Column(name = "description",columnDefinition = "LONGTEXT", nullable = false)
	private String description;
	
	
	/*
	 * BigDecimal
	 */
	@Column(name = "price", precision = 13, scale = 2, nullable = false)
	private BigDecimal price;
	
	@Column(name = "dateofmanufacture", nullable = true)
	private Date ngaySanXuat;
	
	@Column(name = "expiry", nullable = true)
	private Date hanSuDung;
	
	@Column(name = "status" , nullable = true)
	private Integer status;
	
	@Column(name = "avg_rating", precision = 13, scale = 2, nullable = true)
	private BigDecimal avgRating;
	
	@Column(name = "avatar", length = 200, nullable = true)
	private String avatar;
	
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id") // foreign key
	private CategoriesEnity categoriesEnity;
	
	

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productsEnity") // Ten Property trong
	private Set<ProductImagesEnity> productImagesEnities = new HashSet<ProductImagesEnity>();
	

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productsEnityReviews") // Ten Property trong
	private Set<ReviewsEnity> reviewsEnities = new HashSet<ReviewsEnity>();

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "productsEnityOrderDetails") // Ten Property trong
	private Set<OrderDetailsEnity> orderDetailsEnities = new HashSet<OrderDetailsEnity>();

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(Date ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}

	public Date getHanSuDung() {
		return hanSuDung;
	}

	public void setHanSuDung(Date hanSuDung) {
		this.hanSuDung = hanSuDung;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public BigDecimal getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(BigDecimal avgRating) {
		this.avgRating = avgRating;
	}

	public CategoriesEnity getCategoriesEnity() {
		return categoriesEnity;
	}

	public void setCategoriesEnity(CategoriesEnity categoriesEnity) {
		this.categoriesEnity = categoriesEnity;
	}

	public Set<ProductImagesEnity> getProductImagesEnities() {
		return productImagesEnities;
	}

	public void setProductImagesEnities(Set<ProductImagesEnity> productImagesEnities) {
		this.productImagesEnities = productImagesEnities;
	}

	public Set<ReviewsEnity> getReviewsEnities() {
		return reviewsEnities;
	}

	public void setReviewsEnities(Set<ReviewsEnity> reviewsEnities) {
		this.reviewsEnities = reviewsEnities;
	}

	public Set<OrderDetailsEnity> getOrderDetailsEnities() {
		return orderDetailsEnities;
	}

	public void setOrderDetailsEnities(Set<OrderDetailsEnity> orderDetailsEnities) {
		this.orderDetailsEnities = orderDetailsEnities;
	}

	
	public ProductsEnity(Integer id, Date createdDate, Date updatedDate, String name, String description,
			BigDecimal price, Date ngaySanXuat, Date hanSuDung, Integer status, BigDecimal avgRating, String avatar,
			CategoriesEnity categoriesEnity, Set<ProductImagesEnity> productImagesEnities,
			Set<ReviewsEnity> reviewsEnities, Set<OrderDetailsEnity> orderDetailsEnities) {
		super(id, createdDate, updatedDate);
		this.name = name;
		this.description = description;
		this.price = price;
		this.ngaySanXuat = ngaySanXuat;
		this.hanSuDung = hanSuDung;
		this.status = status;
		this.avgRating = avgRating;
		this.avatar = avatar;
		this.categoriesEnity = categoriesEnity;
		this.productImagesEnities = productImagesEnities;
		this.reviewsEnities = reviewsEnities;
		this.orderDetailsEnities = orderDetailsEnities;
	}

	public ProductsEnity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductsEnity(Integer id, Date createdDate, Date updatedDate) {
		super(id, createdDate, updatedDate);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
