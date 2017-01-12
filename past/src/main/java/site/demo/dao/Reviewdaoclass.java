package site.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import site.demo.model.Customer;
import site.demo.model.Review;
@Repository
public class Reviewdaoclass implements Reviewdaoint {
@Autowired
SessionFactory sf;
@Transactional
	public List<Review> getreviewsbycustomer(String customer) {
		Session s=sf.openSession();
		List<Review> data= s.createQuery("from Review where customerid='"+customer+"'").list();
		s.close();
		return data;
	}
@Transactional
	public List<Review> getreviewbyxid(String xid) {
	Session s=sf.openSession();
	List<Review> data= s.createQuery("from Review where xmapview='"+xid+"'").list();
	System.out.println("\nreview elements:"+data);
	List<Review> rv=  new ArrayList();
	/*rv.get(0).setCustomerid(new Customer());
	rv.get(0).setReview("");
	rv.get(0).setReview_id(0);
	rv.get(0).setXmapview("");*/

	if(data!=null||data.isEmpty()==false){
	rv.addAll(data);}
	s.close();
		 return rv;
	}

	public void addreview(Review data) {
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		System.out.println("\nreview save method");
		s.save(data);
		System.out.println("\nreview save method");
		t.commit();
		s.close();
	}

}
