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
import javax.persistence.Table;

@Entity

public class Cartitem {
	
@Id
public String cartitemid;
public String xid;
public int quantity,price,totalprice;
public String status,product_name,category_type,supplier_name,desc;

@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="customer_id")
private Customer customer;

public String getCartitemid() {
	return cartitemid;
}

public void setCartitemid(String cartitemid) {
	this.cartitemid = cartitemid;
}

public String getXid() {
	return xid;
}

public void setXid(String xid) {
	this.xid = xid;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}



public int getTotalprice() {
	return totalprice;
}

public void setTotalprice(int totalprice) {
	this.totalprice = totalprice;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getProduct_name() {
	return product_name;
}

public void setProduct_name(String product_name) {
	this.product_name = product_name;
}

public String getCategory_type() {
	return category_type;
}

public void setCategory_type(String category_type) {
	this.category_type = category_type;
}

public String getSupplier_name() {
	return supplier_name;
}

public void setSupplier_name(String supplier_name) {
	this.supplier_name = supplier_name;
}

public String getDesc() {
	return desc;
}

public void setDesc(String desc) {
	this.desc = desc;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}










}
