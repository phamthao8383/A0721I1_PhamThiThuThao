package fresher.Team3.Enities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

@Table(name = "tbl_reviews")
public class ReviewsEnity extends BaseEnity {
	
	@Column(name = "rate")
	private Integer rate;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id") // foreign key
	private UsersEnity usersEnityReviews;
	
	@Lob
	@Column(name = "content",columnDefinition = "LONGTEXT", nullable = true)
	private String content;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id") // foreign key
	private ProductsEnity productsEnityReviews;


	public Integer getRate() {
		return rate;
	}


	public void setRate(Integer rate) {
		this.rate = rate;
	}


	public UsersEnity getUsersEnityReviews() {
		return usersEnityReviews;
	}


	public void setUsersEnityReviews(UsersEnity usersEnityReviews) {
		this.usersEnityReviews = usersEnityReviews;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public ProductsEnity getProductsEnityReviews() {
		return productsEnityReviews;
	}


	public void setProductsEnityReviews(ProductsEnity productsEnityReviews) {
		this.productsEnityReviews = productsEnityReviews;
	}


	public ReviewsEnity(Integer id, Date createdDate, Date updatedDate, Integer rate, UsersEnity usersEnityReviews,
			String content, ProductsEnity productsEnityReviews) {
		super(id, createdDate, updatedDate);
		this.rate = rate;
		this.usersEnityReviews = usersEnityReviews;
		this.content = content;
		this.productsEnityReviews = productsEnityReviews;
	}


	public ReviewsEnity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ReviewsEnity(Integer id, Date createdDate, Date updatedDate) {
		super(id, createdDate, updatedDate);
		// TODO Auto-generated constructor stub
	}
	
	
	

}
