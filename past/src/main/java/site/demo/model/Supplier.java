package site.demo.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import site.demo.model.Products;
@Entity

public class Supplier {
	@Id
	private String supp_id;
	//private String supp_prod_id;
	private String supp_prod;
	private String supp_name;
	private String supp_contact;
	private String supp_address;
	private String supp_mail;
	private String supp_status;
	
	@Transient
	private Set<Products> products;
	
	@OneToMany(mappedBy="supplier",fetch=FetchType.EAGER)
	public Set<Products> getProducts() {
		return products;
	}
	
	public void setProducts(Set<Products> products) {
		this.products = products;
	}
	
	public String getSupp_id() {
		return supp_id;
	}
	public void setSupp_id(String supp_id) {
		this.supp_id = supp_id;
	}
	/*public String getSupp_prod_id() {
		return supp_prod_id;
	}
	public void setSupp_prod_id(String supp_prod_id) {
		this.supp_prod_id = supp_prod_id;
	}*/
	public String getSupp_prod() {
		return supp_prod;
	}
	public void setSupp_prod(String supp_prod) {
		this.supp_prod = supp_prod;
	}
	public String getSupp_name() {
		return supp_name;
	}
	public void setSupp_name(String supp_name) {
		this.supp_name = supp_name;
	}
	public String getSupp_contact() {
		return supp_contact;
	}
	public void setSupp_contact(String supp_contact) {
		this.supp_contact = supp_contact;
	}
	public String getSupp_address() {
		return supp_address;
	}
	public void setSupp_address(String supp_address) {
		this.supp_address = supp_address;
	}
	public String getSupp_mail() {
		return supp_mail;
	}
	public void setSupp_mail(String supp_mail) {
		this.supp_mail = supp_mail;
	}

	public String getSupp_status() {
		return supp_status;
	}

	public void setSupp_status(String supp_status) {
		this.supp_status = supp_status;
	}
	
}
