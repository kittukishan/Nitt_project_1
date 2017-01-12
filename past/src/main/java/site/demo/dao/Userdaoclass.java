package site.demo.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import site.demo.model.Users;

@Repository
public class Userdaoclass implements Userdaoint {
	
	
@Autowired
	SessionFactory sf1;

@Transactional
	public void addUserDetails(Users user) {
		
		Session s1=sf1.openSession();
		Transaction t1=s1.beginTransaction();
		try{
		user.setAuthorities("role_user");
		user.setStatus(true);
		s1.save(user);
		}
		catch(Exception ec){
			System.out.println("u got strucked"+"ec");
		}
		t1.commit();
		s1.close();
	}
@Transactional

	public List<Users> getUserById(String uname) {
		Session s2=sf1.openSession();
		Query q1=s2.createQuery("from Users where name='"+uname+"'");
		List<Users> user=q1.list();
		s2.close();
		return user;
		
	}
@Transactional

	public List<Users> getUsers() {
		
		Session s3=sf1.openSession();
		Query q2=s3.createQuery("from Users");
		List<Users> users=q2.list();
		s3.close();
		return users;
	}

	public void updateData(Users updateuser) {
		
		Session s1=sf1.openSession();
		Transaction t1=s1.beginTransaction();
		s1.saveOrUpdate(updateuser);
		t1.commit();
		s1.close();
	}
	@Transactional

	public int chkuser(String un,String pd)
	{
		String authorities="";
		String uname="",pass="";
		
		Session se1=sf1.openSession();
			Query qr1=se1.createQuery("from Users where username= '" + un + "' and password ='" + pd + "'");
			List<Users>lst = qr1.list();
				se1.close();
			for(Users u : lst){			
				System.out.println(u.getAuthorities());
				authorities = u.getAuthorities();
				uname=u.getName();
				pass=u.getPassword();
				}
			
			int count=0;
			if (uname.equals(un)&& pass.equals(pd) && authorities.equals("Admin")&& lst != null && !lst.isEmpty()) 
			{
				count= 1;
			}
			else if(uname.equals(un)&& pass.equals(pd)&& lst != null && !lst.isEmpty()) {
				count= 2;
			}
			else 
				System.out.println("user match failed");
			
			return count;
	 
		
	}

	public int chkuser1(String name) {
		Session se1=sf1.openSession();
		Transaction t=se1.beginTransaction();
		Query q=se1.createQuery("select authorities from Users where name='"+name+"'");
		String s=(String) q.list().get(0);
		int count=0;
		
		try {
			if(s.equalsIgnoreCase("role_admin")){count=1;}
			else if(s.equalsIgnoreCase("role_user")){count=2;}
			else	count=3;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		t.commit();
		se1.close();
		return count;
	}
	
	

}
