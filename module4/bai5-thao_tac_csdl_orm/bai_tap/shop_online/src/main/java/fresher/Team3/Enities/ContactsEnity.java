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

@Entity
@Table(name = "tbl_contact")
public class ContactsEnity extends BaseEnity {
	
	@Column(name = "name", length = 200, nullable = false)
	private String name;
	
	@Column(name = "adress", length = 200, nullable = false)
	private String adress;
	
	@Column(name = "phone", length = 200, nullable = false)
	private String phone;
	
	
	@Column(name = "note", length = 200, nullable = true)
	private String note;
	
	public ContactsEnity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ContactsEnity(Integer id, Date createdDate, Date updatedDate) {
		super(id, createdDate, updatedDate);
		// TODO Auto-generated constructor stub
	}
	public ContactsEnity(Integer id, Date createdDate, Date updatedDate, String name, String adress, String phone,
			String note, Set<OrdersEnity> ordersEnities) {
		super(id, createdDate, updatedDate);
		this.name = name;
		this.adress = adress;
		this.phone = phone;
		this.note = note;
		this.ordersEnities = ordersEnities;
	}


	public Set<OrdersEnity> getOrdersEnities() {
		return ordersEnities;
	}


	public void setOrdersEnities(Set<OrdersEnity> ordersEnities) {
		this.ordersEnities = ordersEnities;
	}


	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "contactsEnityOrder") // Ten Property trong
	private Set<OrdersEnity> ordersEnities = new HashSet<OrdersEnity>();


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}
	
	
	
	
	

}
