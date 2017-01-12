package site.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.demo.dao.Productdaoint;
import site.demo.model.Products;


@Service
public class Productserviceclass implements Productserviceint {
	
@Autowired
public Productdaoint dao;
	public List<Products> showitems() {
		System.out.print("\nServ - showitems");
		List<Products> items=dao.getProducts();
		System.out.print("\nproducts retrieved\n");
		return items;
	}
	public void addproducts(Products product) {
		System.out.print("\nproducts adding service");
		dao.addproducts(product);
		
	}
	public void updateData(Products updateproduct) {
		dao.updateData(updateproduct);
		
	}
	public void removeproduct(String product) {
		dao.removeproduct(product);
		
	}

	public Products getproductbyid(String id){
		Products product=dao.getproductbyid(id);
		return product;
	}
	
}
