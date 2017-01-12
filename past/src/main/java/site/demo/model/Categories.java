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
@Component
public class Categories {
	@Id
	private String cat_id;
	private String cat_name;
	private String cat_desc;
	private String status;
	

	@Transient
	private Set<Products> products;
	
	@OneToMany(mappedBy="categories",fetch=FetchType.EAGER)
	public Set<Products> getProducts() {
		return products;
	}
	
	public void setProducts(Set<Products> products) {
		this.products = products;
	}
	
	public String getCat_id() {
		return cat_id;
	}
	
	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}
	
	public String getCat_name() {
		return cat_name;
	}
	
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}
	
	public String getCat_desc() {
		return cat_desc;
	}
	
	public void setCat_desc(String cat_desc) {
		this.cat_desc = cat_desc;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
