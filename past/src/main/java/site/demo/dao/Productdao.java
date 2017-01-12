package site.demo.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import site.demo.model.Supplier;
import site.demo.formula.Idgen;
import site.demo.model.Products;
@Repository
public class Productdao implements Productdaoint {
	
	@Autowired
	private SessionFactory sf;
	
	
	Idgen ig;
	@Transactional
	public List<Products> getProducts() {
		System.out.print("\ndao-showitems");
		Session s1=sf.openSession();
		Query q1=s1.createQuery("from Products");
		List<Products> items=q1.list();
		System.out.print("\nproducts retrieved\n");
		s1.close();
		return items;
	}
	@Transactional
	public void addproducts(Products product) {
		
		Session s2=sf.openSession();
		Transaction t=s2.beginTransaction();
		System.out.print("\nproducts adding dao");
		try {
			Query q1=s2.createQuery("select max(item_id) from Products");
			List<String> s=q1.list();
			String s3=s.get(0).toString();
			ig=new Idgen();
			String id=ig.generate(s3,"pr");
			product.setItem_id(id);
			s2.save(product);
			saveImage(product);
			System.out.print("\nproducts saved dao");
			t.commit();
			s2.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("deenamma exception"+e);
			e.printStackTrace();
		}
		
		
	}	
	@Transactional
	private void saveImage(Products prd){
		//past/src/main/webapp/files/images/desserts
		Path path=Paths.get("E://practice//past//src//main//webapp//files//images//desserts//"+prd.getItem_id()+".jpg");
		System.out.println("\nImg : " + prd.getImage());
		System.out.println("\nPath : " + path.toString());
				if(prd.getImage()!=null && !prd.getImage().isEmpty())
				{
					try {
						
						prd.getImage().transferTo(new File(path.toString()));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("\nexp : " + e.toString());
						e.printStackTrace();
					} 
					
				}
		
	}
	@Transactional
			
	public void updateData(Products updateproduct) {
		Session s4=sf.openSession();
		Transaction t=s4.beginTransaction();
		s4.saveOrUpdate(updateproduct);
		t.commit();
		s4.close();
		
	}	@Transactional

	public Products getproductbyid(String id){
		Session s4=sf.openSession();
		Transaction t=s4.beginTransaction();
		Query q=s4.createQuery("from Products where item_id='"+id+"'");
		Products product=(Products)q.list().get(0);
		t.commit();
		s4.close();
		
		return product;
	}
	@Transactional

	public void removeproduct(String product) {
		Session s4=sf.openSession();
		Transaction t=s4.beginTransaction();
		/*Query q=s4.createQuery("delete from Products where item_id='"+product+"'");*/
		Products p=s4.get(Products.class,product);
	System.out.println("hbj"+p.getDesc());
	s4.delete(p);
		t.commit();
		
		s4.close();
	}

}
