package fresher.Team3.Enities;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_users")
public class UsersEnity implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "username", length = 200, nullable = false)
	private String username;

	@Column(name = "password", length = 200, nullable = false)
	private String password;

	@Column(name = "email", length = 200, nullable = false)
	private String email;

	@Column(name = "created_at", nullable = true)
	private Date createdDate;

	@Column(name = "updated_at", nullable = true)
	private Date updatedDate;

	@Column(name = "adress", length = 200, nullable = false)
	private String adress;

	@Column(name = "cmt", length = 200, nullable = false)
	private String cmt;

	@Column(name = "phone", length = 200, nullable = false)
	private String phone;

	@Column(name = "name", length = 200, nullable = false)
	private String name;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usersEnityReviews") // Ten Property trong
	private Set<ReviewsEnity> reviewsEnities = new HashSet<ReviewsEnity>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usersEnityOrders") // Ten Property trong
	private Set<OrdersEnity> ordersEnities = new HashSet<OrdersEnity>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCmt() {
		return cmt;
	}

	public void setCmt(String cmt) {
		this.cmt = cmt;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<RolesEnity> getRolesEnities() {
		return rolesEnities;
	}

	public void setRolesEnities(Set<RolesEnity> rolesEnities) {
		this.rolesEnities = rolesEnities;
	}

	@ManyToMany
	@JoinTable(name = "tbl_user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<RolesEnity> rolesEnities = new HashSet<RolesEnity>();
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.rolesEnities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub 
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		if(!this.adress.equals("1")) return false;
		return true;
	}

	public Set<ReviewsEnity> getReviewsEnities() {
		return reviewsEnities;
	}

	public void setReviewsEnities(Set<ReviewsEnity> reviewsEnities) {
		this.reviewsEnities = reviewsEnities;
	}

	public Set<OrdersEnity> getOrdersEnities() {
		return ordersEnities;
	}

	public void setOrdersEnities(Set<OrdersEnity> ordersEnities) {
		this.ordersEnities = ordersEnities;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UsersEnity(Integer id, String username, String password, String email, Date createdDate, Date updatedDate,
			String adress, String cmt, String phone, String name, Set<ReviewsEnity> reviewsEnities,
			Set<OrdersEnity> ordersEnities, Set<RolesEnity> rolesEnities) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.adress = adress;
		this.cmt = cmt;
		this.phone = phone;
		this.name = name;
		this.reviewsEnities = reviewsEnities;
		this.ordersEnities = ordersEnities;
		this.rolesEnities = rolesEnities;
	}

	public UsersEnity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
