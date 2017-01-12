package site.demo.model;

import java.util.List;

import javax.mail.Multipart;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity

public class Xmap_pro_supp extends Object {

	@Id
public String xid;
	
/*@JoinColumn( referencedColumnName="item_id")*/
/*@OneToMany(cascade=CascadeType.ALL)*/

	/*@JoinColumn( referencedColumnName="item_id")
	@OneToMany(cascade=CascadeType.ALL)*/
public String product_id;
	
	
public String supp_id;
public String cat_id;
public int price;
public int stock;
public String status;

@Transient
public String product_name;
@Transient
public String cat_type;
@Transient
public String supplier_name;
@Transient
public String desc;
@Transient
private MultipartFile image1;


public MultipartFile getImage1() {
	return image1;
}
public void setImage1(MultipartFile image1) {
	this.image1 = image1;
}
public String getProduct_name() {
	return product_name;
}
public void setProduct_name(String product_name) {
	this.product_name = product_name;
}
public String getCat_type() {
	return cat_type;
}
public void setCat_type(String cat_type) {
	this.cat_type = cat_type;
}
public String getSupplier_name() {
	return supplier_name;
}
public void setSupplier_name(String supplier_name) {
	this.supplier_name = supplier_name;
}
public String getXid() {
	return xid;
}
public void setXid(String xid) {
	this.xid = xid;
}
public String getProduct_id() {
	return product_id;
}
public void setProduct_id(String product_id) {
	this. product_id = product_id;
}
public String getSupp_id() {
	return supp_id;
}
public void setSupp_id(String supp_id) {
	this.supp_id = supp_id;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getCat_id() {
	return cat_id;
}
public void setCat_id(String cat_id) {
	this.cat_id = cat_id;
}



}
