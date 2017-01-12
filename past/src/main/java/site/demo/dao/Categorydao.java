package site.demo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import site.demo.formula.Idgen;
import site.demo.model.Categories;
import site.demo.model.Products;

@Repository
public class Categorydao implements Categorydaoint {
	@Autowired
	SessionFactory sf2;
	Idgen ig;
	
	public void addcategory(Categories cats) {
		Session se1=sf2.openSession();
		Transaction ts1=se1.beginTransaction();
		Query q1=se1.createQuery("select max(cat_id) from Categories");
		List<String> s=q1.list();
		String s2=s.get(0);
		ig=new Idgen();
		String id=ig.generate(s2,"ca");
		cats.setCat_id(id);
		se1.save(cats);
		ts1.commit();
		se1.close();
		
	}

	public void modifycategory(Categories data) {
		Session se2=sf2.openSession();
		Transaction t=se2.beginTransaction();
		/*List<Categories> li= getcategorybyid(id);*/
		se2.saveOrUpdate(data);
		t.commit();
		se2.close();
	}
	@Transactional
	public List<Categories> getcategories() {
		Session s3=sf2.openSession();
		Query q=s3.createQuery("from Categories");
		List<Categories> list=q.list();
		System.out.println("\ncategories"+list.get(0).getCat_name());
		s3.close();
		return list;
	}
	@Transactional
	public Categories getcategories(String id){
		Session s3=sf2.openSession();
		Query q=s3.createQuery("from Categories where cat_id='"+id+"'");
		Categories lis=(Categories)q.list().get(0);
		s3.close();
		return lis;
	
}
	@Transactional
	public void removecategory(Categories cat) {
		Session s3=sf2.openSession();
		s3.delete(cat);
		s3.close();
		
		
	}

		
	
	


}
