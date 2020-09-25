package ecommerce.customerservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	private String fullname;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false, unique = true)
	private String mobile;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	@Transient
	private String confirmPassword;

	public Customer() {
		super();
	}

	public Customer(Integer id, String fullname, String email, String mobile, String password, String confirmPassword) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public Customer(String fullname, String email, String mobile, String password, String confirmPassword) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
