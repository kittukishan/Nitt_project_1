package site.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Products {

	@Id
	//@JoinColumn(name="product_id")

	
	/*@OneToOne(mappedBy = "product_id",
     orphanRemoval = true)*/
	
	/*@OneToOne(mappedBy = "product_id")*/
	private String  item_id;
	
	private String item_name;
	private String desc;
	private String status;
	@Transient
	private MultipartFile image;
	
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	//private int price;
	//private int offer;
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_no) {
		this.item_id = item_no;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item) {
		this.item_name = item;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/*public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getOffer() {
		return offer;
	}
	public void setOffer(int offer) {
		this.offer = offer;
	}*/
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
