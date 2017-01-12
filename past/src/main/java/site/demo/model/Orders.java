package site.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Orders implements Serializable{
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE)
private String Order_id;
private Date Order_date;
private Date Delivery_date;
private String grandtotal;
@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="customer_id")
private Customer customer;

@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn(name="shid")
private Shippingaddress shid;

@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
@JoinColumn
private Billingaddress bid;

private boolean status;

public String getOrder_id() {
	return Order_id;
}

public void setOrder_id(String order_id) {
	Order_id = order_id;
}

public Date getOrder_date() {
	return Order_date;
}

public void setOrder_date(Date order_date) {
	Order_date = order_date;
}

public Date getDelivery_date() {
	return Delivery_date;
}

public void setDelivery_date(Date delivery_date) {
	Delivery_date = delivery_date;
}

public String getGrandtotal() {
	return grandtotal;
}

public void setGrandtotal(String grandtotal) {
	this.grandtotal = grandtotal;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

public Shippingaddress getShid() {
	return shid;
}

public void setShid(Shippingaddress shid) {
	this.shid = shid;
}

public Billingaddress getBid() {
	return bid;
}

public void setBid(Billingaddress bid) {
	this.bid = bid;
}

public boolean isStatus() {
	return status;
}

public void setStatus(boolean status) {
	this.status = status;
}





}
