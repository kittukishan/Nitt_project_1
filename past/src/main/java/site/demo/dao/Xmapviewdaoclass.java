package site.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import site.demo.model.Categories;
import site.demo.model.Products;

import site.demo.model.Xmap_pro_supp;
import site.demo.model.Xmapview;

@Repository
public class Xmapviewdaoclass implements Xmapviewint {
@Autowired
	SessionFactory sf;
@Transactional

	public List<Xmapview> getproductsbysupp(String supplier) {
		Session s3=sf.openSession();
		System.out.println("dao entered");
		
			String s="from Xmapview where supplier_name='"+supplier+"'and status='true'";
			Query q=s3.createQuery(s);
		List<Xmapview> list=q.list();
		System.out.println("nisiov"+list.get(0).product_name);
		return list;
	}
@Transactional

	public List<Xmapview> getproductsbycat(String category) {
		
		Session s3=sf.openSession();
		System.out.println("dao entered");
		
			String s="from Xmapview where category_type='"+category+"'";
			Query q=s3.createQuery(s);
		List<Xmapview> list=q.list();
		System.out.println("nisiov"+list.get(0).product_name);
		s3.close();
		return list;
	}

@Transactional

	public List<Xmapview> getxmapproducts() {
		Session s3=sf.openSession();
		System.out.println("dao entered");
		
			String s="from Xmapview  v1  where price =(select  min(price) from Xmapview  v2 where v1.product_id = v2.product_id)";
			Query q=s3.createQuery(s);
		List<Xmapview> list=q.list();
		for(Xmapview x:list){
			System.out.println("\nkjscnj"+x.status);
		}
		s3.close();
		return list;
	}
@Transactional

	public List<Xmapview> getviewbyid(String xid) {
		Session s3=sf.openSession();
		System.out.println("dao entered");
		
			String s="from Xmapview where product_id='"+xid+"'and status='true'";
			Query q=s3.createQuery(s);
		List<Xmapview> list=q.list();
		System.out.println("nisiov"+list.get(0).product_name);
		s3.close();
		return list;
	}
@Transactional

	public List<Xmapview> getviewbyxid(String xid) {
		Session s3=sf.openSession();
		System.out.println("dao entered");
		
			String s="from Xmapview where xid='"+xid+"'";
			Query q=s3.createQuery(s);
		List<Xmapview> list=q.list();
		
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getStatus()=="false")
				return null;
		}
		System.out.println("nisiov: "+list.get(0).product_name);
		s3.close();
		return list;
	}
	
	
}
