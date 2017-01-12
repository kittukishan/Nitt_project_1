	package site.demo.dao;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import site.demo.model.Products;
import site.demo.model.Supplier;
import site.demo.model.Xmap_pro_supp;
import site.demo.formula.*;

@Repository

public class Xpsdaoclass implements Xpsdaoint {
	
	
	@Autowired
	SessionFactory sf;
	
	Idgen idgen;
	
	
	@Transactional
	public List<Xmap_pro_supp> getallproducts(){
		Session s=sf.openSession();
		Query hql=s.createQuery("from Xmap_pro_supp");
		List<Xmap_pro_supp> list=hql.list();
		for(Xmap_pro_supp x:list){
			System.out.println("list"+x);
		}
		
		s.close();
		return list;
	}
	
	
	public void addproduct(Xmap_pro_supp product) {
		Session s2=sf.openSession();
		Transaction t=s2.beginTransaction();
		try {
			Query q1=s2.createQuery("select max(xid) from Xmap_pro_supp");
			List<String> s=q1.list();
			String s1=s.get(0);
			if(s1==null||s1.isEmpty()){
				product.setXid("xp1001");
			}
			else{
			idgen=new Idgen();
			String id=idgen.generate(s1, "xp");
			product.setXid(id);}
			s2.save(product);
			saveImage(product);
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("exception at data base: "+e);
		}
		t.commit();
		s2.close();
		
	}
	@Transactional
	private void saveImage(Xmap_pro_supp prd){
		//past/src/main/webapp/files/images/desserts
		Path path=Paths.get("C://Users//Kishan//git//niit_project1_past//past//src//main///webapp//files//images//desserts//"+prd.getXid()+".jpg");
		System.out.println("\nImg : " + prd.getImage1());
		System.out.println("\nPath : " + path.toString());
				if(prd.getImage1()!=null && !prd.getImage1().isEmpty())
				{
					try {
						
						prd.getImage1().transferTo(new File(path.toString()));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("\nexp : " + e.toString());
						e.printStackTrace();
					} 
					
				}
		
	}
	public void removeproduct(String xid) {
		Session s4=sf.openSession();
		Transaction t=s4.beginTransaction();
		//String s="delete from Xmap_pro_supp where xid='"+xid+"'";
		Xmap_pro_supp temp = s4.get(Xmap_pro_supp.class, xid);
		s4.delete(temp);
		//Query q=s4.delcreatequery(s);
		//s4.delete(xid);
		t.commit();
		s4.close();
		
	}

	public void updateproduct(Xmap_pro_supp product) {
		Session s4=sf.openSession();
		Transaction t=s4.beginTransaction();
		s4.saveOrUpdate(product);
		t.commit();
		s4.close();
		
	}

	public List<Xmap_pro_supp> getproductsbyid(String xid) {
		Session ses1=sf.openSession();
		Transaction t=ses1.beginTransaction();
		Query hql=ses1.createQuery("from Xmap_pro_supp where xid='"+xid+"'");
		List<Xmap_pro_supp> lst=hql.list();
		t.commit();
		ses1.close();
		return lst;
	}
	
public List<String> getprdid(){
	Session se1=sf.openSession();
	Transaction t=se1.beginTransaction();
	System.out.println("query entered");
	Query hql=se1.createQuery("select item_id from Products");
	List<String> list=hql.list();
	t.commit();
	
	System.out.println("data retrieved");
	se1.close();
	return list;
	
}
public List<String> getcatid(){
	Session se1=sf.openSession();
	Transaction t=se1.beginTransaction();
	System.out.println("query entered");
	Query hql=se1.createQuery("select cat_id from Categories");
	List<String> list=hql.list();
	t.commit();
	
	System.out.println("data retrieved");
	se1.close();
	return list;
	
}public List<String> getsuppid(){
	Session se1=sf.openSession();
	Transaction t=se1.beginTransaction();
	System.out.println("query entered");
	Query hql=se1.createQuery("select supp_id from Supplier");
	List<String> list=hql.list();
	t.commit();
	
	System.out.println("data retrieved");
	se1.close();
	return list;
	
}
/*---------------------------------------Xmap methods--------------------------------------------------*/

public static <Xmap_pro_supp> Xmap_pro_supp conv(Object o, Class<Xmap_pro_supp> clazz) {
    try {
        return clazz.cast(o);
    } catch(ClassCastException e) {
    	System.out.println("\nexcep: "+e);
        return null;
    }
}
public List<Xmap_pro_supp> getxmapproducts() {
	Session s3=sf.openSession();
	System.out.println("dao entered");
	
		String s="select p.item_name as product_name,p.desc,x.price,x.stock,x.status,c.cat_name as cat_type,s.supp_name as supplier_name from Products p join Xmap_pro_supp x on p.item_id= x.product_id join Supplier s on s.supp_id=x.supp_id join Categories c on c.cat_id=x.cat_id order by product_id,stock";
		Query q=s3.createQuery(s);
		
		List<Xmap_pro_supp> list = (List<Xmap_pro_supp>) q.list();
		//site.demo.model.Xmap_pro_supp x=conv(list,Xmap_pro_supp.class);
		//System.out.println("\n "+x.cat_type);
		ArrayList<Xmap_pro_supp> data = new ArrayList();
		System.out.println(data.size());
		System.out.println(list.size());
		System.out.println(list.get(0));
		String client = String.valueOf(list.get(0).getPrice());
		System.out.println(client);
		for(int i=0;i<=list.size();i++){
			data.add((Xmap_pro_supp)list.get(i));
			System.out.println("jblkj "+data.get(0).getCat_id());
			
		}
		for(Xmap_pro_supp dt : list){
			data.add((Xmap_pro_supp)dt);
			System.out.println("jblkj "+data.size());
		}
		//System.out.println("data: "+data.get(0).getProduct_name());
		/*
		Iterator itr = ((List<site.demo.model.Xmap_pro_supp>) list).iterator();
		while(itr.hasNext()){
		   //Object obj = (Object) itr.next();
		   Xmap_pro_supp obj = (Xmap_pro_supp)itr.next();
		   //now you have one array of Object for each row
		   String client = String.valueOf(obj.stock); // don't know the type of column CLIENT assuming String 
		   String service =String.valueOf(obj.price); 
		   System.out.println("string: "+client);
			System.out.println("string: "+service);
		}
		String s1=String.valueOf(list);
		String s2=String.valueOf(((List<site.demo.model.Xmap_pro_supp>) list).get(0).getClass());
*/
		
		/*List<Xmap_pro_supp> itr = (List<Xmap_pro_supp>) list.iterator();
		
			System.out.println("\nitr value: "+itr.get(0).product_name+"\nvalu2"+itr.get(0).getProduct_name());
			//now you have one array of Object for each row
			while(((Iterator<Xmap_pro_supp>) itr).hasNext())
			{
				List<Xmap_pro_supp> lis=(List<Xmap_pro_supp>) itr.get(0);
				
			System.out.println("\nvalue3 "+lis.get(0).product_name);
					
		System.out.println("\nquery completeed.");
			}
			
*/s3.close();	return null;
		
}
@Transactional

public List<Xmap_pro_supp> getproductsbysupp(String supplier) {
	Session s3=sf.openSession();
	String s=getidbysupp(supplier);
	Query q=s3.createQuery("from Xmap_pro_supp where supp_id='"+s+"'");
	List<Xmap_pro_supp> list=q.list();
	s3.close();

	return list;
}

				public String getidbysupp(String name ){
						Session ses1=sf.getCurrentSession();
						Query hql=ses1.createQuery("select supp_id from Supplier where supp_name='"+name+"'");
						List<Supplier> lst=hql.list();
						String id=lst.get(0).getSupp_id();
						return id;
					}
				@Transactional

public List<Xmap_pro_supp> getproductsbycat(String category){
	Session s=sf.openSession();
	Transaction t=s.beginTransaction();
	
	String id=getidbycat(category);
	Query q=s.createQuery("select * from Xmap_pro_supp where cat_id='"+s+"'");
	List<Xmap_pro_supp> list=q.list();
	t.commit();
	s.close();
	return list;
}	
					private String getidbycat(String cat_name){
							Session ses1=sf.getCurrentSession();
							Query hql=ses1.createQuery("select cat_id from Categories where cat_name='"+cat_name+"'");
							List<String> lst=hql.list();
							String id=lst.get(0);
							return id;
						}


}
