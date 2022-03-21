package fresher.Team3.Enities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "tbl_categories")
public class CategoriesEnity extends BaseEnity {
	
	
	@Column(name = "name", length = 200, nullable = false)
	private String name;
	
	@Column(name = "description", length = 200, nullable = false)
	private String description;
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "categoriesEnity")
	private Set<ProductsEnity> productsEnities = new HashSet<ProductsEnity>();
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

	public Set<ProductsEnity> getProductsEnities() {
		return productsEnities;
	}

	public void setProductsEnities(Set<ProductsEnity> productsEnities) {
		this.productsEnities = productsEnities;
	}

	public CategoriesEnity(Integer id, Date createdDate, Date updatedDate, String name, String description,
			Set<ProductsEnity> productsEnities) {
		super(id, createdDate, updatedDate);
		this.name = name;
		this.description = description;
		this.productsEnities = productsEnities;
	}
	public CategoriesEnity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoriesEnity(Integer id, Date createdDate, Date updatedDate) {
		super(id, createdDate, updatedDate);
		// TODO Auto-generated constructor stub
	}
}
