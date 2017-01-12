package site.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.SystemPropertyUtils;

import site.demo.formula.Idgen;
import site.demo.model.Supplier;

@Repository
public class Supplierdao implements Supplierdaoint {
	@Autowired
	SessionFactory sf;
	
	Idgen ig;
	@Transactional

	public void addsupplier(Supplier supplier) {
		Session s1=sf.openSession();
		Transaction t=s1.beginTransaction();
		Query q1=s1.createQuery("select max(supp_id) from Supplier");
		List<String> s=q1.list();
		String s2=s.get(0);
		ig=new Idgen();
		String id=ig.generate(s2,"su");
		supplier.setSupp_id(id);
		s1.save(supplier);
		t.commit();
		s1.close();
		
	}
	@Transactional

	public List<Supplier> showall() {
		Session s1=sf.openSession();
		System.out.println("\nquery entered");
		Query q1=s1.createQuery("from Supplier");
		List<Supplier> list=q1.list();
		System.out.println("\nquery returned");
		return list;
	}
	@Transactional

	public Supplier showbyid(String suppid) {
		Session s1=sf.openSession();
		Query q1=s1.createQuery("from Supplier where supp_id='"+suppid+"'");
		Supplier list=(Supplier)q1.list().get(0);
		
		return list;
	}
	
	
	@Transactional

	public void updatesupplier(Supplier supplier) {
		
		Session s1=sf.openSession();
		Transaction t=s1.beginTransaction();
		System.out.println("\nquery returned");
		s1.saveOrUpdate(supplier);
		t.commit();
		s1.close();
	}
	@Transactional

	public void removesupplier(String suppid) {
		// TODO Auto-generated method stub
		
	}

}
