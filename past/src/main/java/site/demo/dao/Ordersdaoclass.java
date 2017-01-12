package site.demo.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import site.demo.model.Billingaddress;
import site.demo.model.Orders;
import site.demo.model.Shippingaddress;
@Repository
public class Ordersdaoclass implements Ordersdaoint {
	@Autowired
	SessionFactory sf;
	public void confirmorder(Orders order) {
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		saveshippingaddress(order.getShid());
		savebillingaddress(order.getBid());
		//order.setCustomer(order.getCustomer());
		order.setGrandtotal(String.valueOf(getgrandtotal(order.getCustomer().customer_id)));
		Date d=new Date();
		Calendar c = Calendar.getInstance();    
		c.add(Calendar.DATE, 5);
		order.setOrder_date(d);
		order.setDelivery_date(d);
		order.setOrder_id(generateid());
		s.save(order);
		clearcart(order.getCustomer().customer_id);
		t.commit();
		s.close();
		
	}

	private int getgrandtotal(String customerid) {
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		int Grandtotal=0;
		List<Integer> count=s.createQuery("select tottalprice from Cartitem where customer='"+customerid+"'").list();
		for(int i=0;i<count.size();i++){
			Grandtotal=(Grandtotal+count.get(i));
		}
		return Grandtotal;
	}

	private void saveshippingaddress(Shippingaddress shid){
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		s.save(shid);
		t.commit();
		
		
	}
	private void savebillingaddress(Billingaddress bid){
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		s.save(bid);
		t.commit();
		
		
	}
	
	private void clearcart(String customerid){
		Session s=sf.getCurrentSession();
		Transaction t=s.beginTransaction();
		Query q=s.createQuery("delete from Cartitem where customer='"+customerid+"'");
		q.executeUpdate();
		t.commit();s.close();
	}
	@Transactional
	private String generateid(){		
	String newJid="";
		Session ss =sf.openSession();
		Transaction t=ss.beginTransaction();
		
		Query qq = ss.createQuery("from Orders");
		if(qq.list().isEmpty())
		{
			newJid="ORD00001";
		}
		else{	
			Query q = ss.createQuery("select max(Order_id) from Orders");			
			String prevId = q.list().get(0).toString();
			//String prevId = data.get(0).toString();
			System.out.print("\nExisting : "+prevId);
			int id = Integer.parseInt(prevId.substring(3));
			System.out.print("\nExisting id : "+id);
			id=id+1;
			if(id<=9)
				newJid="ORD0000"+id;
			else if(id<=99)
				newJid="ORD000"+id;
			else if(id<=999)
				newJid="ORD00"+id;
			else if(id<=9999)
				newJid="ORD0"+id;
			else
				newJid="ORD"+id;		
			System.out.print("\nGenerated : "+newJid);
			t.commit();				
		}
		ss.close();	
		return newJid;
	}
}
