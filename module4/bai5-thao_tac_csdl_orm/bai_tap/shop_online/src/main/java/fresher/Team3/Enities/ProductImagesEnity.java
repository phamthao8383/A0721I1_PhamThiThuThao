package fresher.Team3.Enities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="tbl_images_product")
public class ProductImagesEnity extends BaseEnity {
	@Column(name = "name", length = 200, nullable = true)
	private String name;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id") // foreign key
	private ProductsEnity productsEnity;
	
	@Column(name = "path", length = 200, nullable = true)
	private String path;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductsEnity getProductsEnity() {
		return productsEnity;
	}

	public void setProductsEnity(ProductsEnity productsEnity) {
		this.productsEnity = productsEnity;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ProductImagesEnity(Integer id, Date createdDate, Date updatedDate, String name, ProductsEnity productsEnity,
			String path) {
		super(id, createdDate, updatedDate);
		this.name = name;
		this.productsEnity = productsEnity;
		this.path = path;
	}

	public ProductImagesEnity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductImagesEnity(Integer id, Date createdDate, Date updatedDate) {
		super(id, createdDate, updatedDate);
		// TODO Auto-generated constructor stub
	}
	
	
	

}

