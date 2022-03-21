
package fresher.Team3.DTO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import fresher.Team3.Enities.OrdersEnity;
import fresher.Team3.Enities.ReviewsEnity;
import fresher.Team3.Enities.RolesEnity;

public class ResgisterDTO {
	@NotEmpty(message = "Thiếu username")
	@Size(min = 6 , max = 32,message = "user min 6 max 32")
	private String username;
	@NotEmpty(message = "Thiếu ten ")
	@Size(min = 6 , max = 32,message = "name min 6 max 32")
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@NotEmpty(message = "Thiếu mat khau")
	@Size(min = 6 , max = 32,message = "password min 6 max 32")
	private String password;
	private String rePassword;
	private String email;
	private String eCode;
	public String geteCode() {
		return eCode;
	}
	public void seteCode(String eCode) {
		this.eCode = eCode;
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
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ResgisterDTO(@NotEmpty(message = "Thiếu username") String username, String name, String password,
			String rePassword, String email) {
		super();
		this.username = username;
		this.name = name;
		this.password = password;
		this.rePassword = rePassword;
		this.email = email;
	}
	public ResgisterDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ResgisterDTO [username=" + username + ", name=" + name + ", password=" + password + ", rePassword="
				+ rePassword + ", email=" + email + "]";
	}

	
}
