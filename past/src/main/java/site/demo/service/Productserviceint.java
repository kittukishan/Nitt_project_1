package site.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import site.demo.model.Products;



public interface Productserviceint {

	public List<Products> showitems();
	public void addproducts(Products product);
	public void updateData(Products updateproduct);
	public void removeproduct(String product);
	public Products getproductbyid(String id);
	
}
