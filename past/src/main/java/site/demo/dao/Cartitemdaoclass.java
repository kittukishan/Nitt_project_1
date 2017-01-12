package site.demo.dao;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import site.demo.formula.Idgen;

import site.demo.model.Cartitem;
import site.demo.model.Customer;
import site.demo.model.Users;
import site.demo.model.Xmapview;
@Repository
public class Cartitemdaoclass implements Cartitemdao {
	@Autowired
	SessionFactory sf;
	
	/*@Autowired
	Cartdaoint cdao;*/

	Cartitem c;
	Idgen ig;
	@Transactional
	public void addcartitem(Customer customer, Xmapview data,int quantity) {
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		c=new Cartitem();
		
				String s3="";																					//c.setXmapview(data);
		List<String> s1=s.createQuery("select cartitemid from Cartitem").list();
		if(s1.isEmpty()||s1==null){
			c.setCartitemid("CI1001");}
		else{
			ig=new Idgen();
			 s3=(String) s.createQuery("select max(cartitemid) from Cartitem").uniqueResult();
			System.out.println("s3 value:"+s3);
		c.setCartitemid(ig.generate(s3, "CI"));}
		
		c.setCustomer(customer);
		c.setCategory_type(data.getCategory_type());
		c.setDesc(data.getDesc());
		c.setPrice(data.price);
		c.setProduct_name(data.product_name);
		c.setQuantity(quantity);
		c.setStatus(data.status);
		//c.setStock(data.stock);
		c.setSupplier_name(data.supplier_name);
		c.setTotalprice(data.price*quantity);
		c.setXid(data.xid);
		
	//custdao.addcustomerbyuser(username,cdao.addtocart(username));
		/*	c.setCart(cdao.addtocart(username));*/
	/*else
		c.setCart(cust.getCart());*/
		s.save(c);
	t.commit();
	s.flush();
	s.close();
	
	}
	public List<Cartitem> getitemsbycustomer(String customer) {
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Query q= s.createQuery("from Cartitem where customer_id='"+customer+"'");
			//q.setParameter(0, customer);
		List<Cartitem> data=q.list();
		System.out.println("\nitems"+data);
		t.commit();
		s.close();
		return data;
	}
	public int getcountitemsbycustomer(String customer) {
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		int data=0;
		System.out.println(customer);
		try {
			Query q= s.createQuery("select count(Cartitemid) from Cartitem where customer_id='"+customer+"'");
				
			long data1 =(Long) q.uniqueResult();
			String sw=Long.toString(data1);
			data=Integer.parseInt(sw);
		
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return data;
		}
		t.commit();
		s.close();
		return data;
	
	}
	public void removecartitem(String cartitem) {
	Session s=sf.openSession();
	Query q=s.createQuery("delete from Cartitem where cartitemid='"+cartitem+"'");
	q.executeUpdate();
	s.close();
		
	}
	public void clearcartitems(String customerid) {
		Session s=sf.openSession();
		Query q=s.createQuery("delete from Cartitem where customer_id='"+customerid+"'");
		q.executeUpdate();
		s.close();
			
		
	}
	
	   public Customer validate(String customerid) throws IOException{
		   System.out.println("\ncheckout flow "+customerid);
	        Cartitem cart = getitemsbycustomer(customerid).get(0);
		   
		   Session ses = sf.openSession();
		   Query qr = ses.createQuery("from Cartitem where customer_id='"+customerid+"'");
		  List<Cartitem> data = qr.list();
		   
	        if(data==null || data.size()==0){
	            throw new IOException(customerid);
	        }
	       Customer cus= ses.get(Customer.class,customerid);
	       ses.close();
	       //return cus;
	       return null;
	      
	    }


}
