package site.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity

public class Shippingaddress {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int shid;
private String sname;
private String state;
private String city;
private String addresslane;
private String doorno;
@Min(10)
@Max(10)
private int contact;
private int pincode;
private String orderid;

@Transient
@OneToMany(mappedBy="shippingaddress",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
private List<Orders> orders;


private int getShid() {
	return shid;
}


private void setShid(int shid) {
	this.shid = shid;
}


public String getSname() {
	return sname;
}


public void setSname(String name) {
	this.sname = name;
}


public String getOrderid() {
	return orderid;
}


public void setOrderid(String orderid) {
	this.orderid = orderid;
}


public List<Orders> getOrders() {
	return orders;
}


public void setOrders(List<Orders> orders) {
	this.orders = orders;
}


private String getState() {
	return state;
}


private void setState(String state) {
	this.state = state;
}


private String getCity() {
	return city;
}


private void setCity(String city) {
	this.city = city;
}


private String getAddresslane() {
	return addresslane;
}


private void setAddresslane(String addresslane) {
	this.addresslane = addresslane;
}


public String getDoorno() {
	return doorno;
}


public void setDoorno(String doorno) {
	this.doorno = doorno;
}


private int getContact() {
	return contact;
}


private void setContact(int contact) {
	this.contact = contact;
}


private int getPincode() {
	return pincode;
}


private void setPincode(int pincode) {
	this.pincode = pincode;
}


/*private Customer getCustomer() {
	return customer;
}


private void setCustomer(Customer customer) {
	this.customer = customer;
}*/




}
