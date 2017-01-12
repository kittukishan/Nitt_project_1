package site.demo.dao;

import java.util.List;
import site.demo.model.Products;

public interface Productdaoint {


	public void addproducts(Products product);
	public List<Products> getProducts();
	public void updateData(Products updateproduct);
	public void removeproduct(String product);
	public Products getproductbyid(String id);
	
}
