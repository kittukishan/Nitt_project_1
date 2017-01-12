package site.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.SystemPropertyUtils;

import site.demo.formula.Idgen;

import site.demo.model.Customer;
import site.demo.model.Users;
@Repository
public class Customerdaoclass implements Customerdaoint {
	@Autowired
SessionFactory sf;
Customer c;
Idgen ig;

	@Transactional
	public Customer getdatabyuser(String user) {
		Session s=sf.openSession();
		Query q=s.createQuery("from Customer where name='"+user+"'");
		System.out.println("\n hi: ");
		Customer data= (Customer) q.uniqueResult();
		System.out.println("\n hi: ");
s.close();
		//System.out.println("customerdata: "+data.get(0).getCustomer_id()+data.get(0).getUsers().getName());
		return data;
		
	}
	@Transactional
	public Customer addcustomerbyuser(String user) {		/*,Cart data*/
		Session s=sf.openSession();
		c=new Customer();String s1="";
		List<String> str=(List<String>) s.createQuery("select customer_id from Customer").list(); ;
		if(str.isEmpty()){
		c.setCustomer_id("cu1001");}
		else {
		 s1=(String) s.createQuery("select max(customer_id)from Customer").uniqueResult();
		System.out.println("string of max customer"+s1);
		ig=new Idgen();
		String idgen=ig.generate(s1,"cu");
		c.setCustomer_id(idgen);
		}
		c.setUsers(s.get(Users.class,user));
		c.setUser_contact(s.get(Users.class,user).getMobile());
		s.save(c);
		s.flush();
		s.close();
		return c;
	}

	
	
}
