package site.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Customer {
	@Id
	@Column(name="customer_id")
	public String customer_id;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="name")
	private Users users;
	public String user_contact;
	
	/*@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="shid")
	public Shippingaddress shippingaddress;*/
	
/*	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="bid")
	public Billingaddress billingaddress;
	*/
	
	@Transient
	@OneToMany(mappedBy="customer",fetch = FetchType.LAZY)
	private List<Cartitem> cartitem;
	@Transient
	@OneToMany(mappedBy="customer",fetch = FetchType.LAZY)
	private List<Review> review;
	@Transient
	@OneToMany(mappedBy="customer",fetch = FetchType.LAZY)
	private Orders orders;
	
	
	
	
	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getUser_contact() {
		return user_contact;
	}

	public void setUser_contact(String user_contact) {
		this.user_contact = user_contact;
	}

	/*public Shippingaddress getShippingaddress() {
		return shippingaddress;
	}

	public void setShippingaddress(Shippingaddress shippingaddress) {
		this.shippingaddress = shippingaddress;
	}

	public Billingaddress getBillingaddress() {
		return billingaddress;
	}

	public void setBillingaddress(Billingaddress billingaddress) {
		this.billingaddress = billingaddress;
	}*/


	
	
}