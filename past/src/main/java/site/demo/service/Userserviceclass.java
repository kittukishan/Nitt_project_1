package site.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import site.demo.dao.Userdaoclass;
import site.demo.dao.Userdaoint;
import site.demo.model.Users;

@Service
public class Userserviceclass implements Userserviceint {
	@Autowired
	Userdaoint userdao;

	
	public void addUserDetails(Users user) {
		
		userdao.addUserDetails(user);
	}
	

	public List<Users> getUserById(String uname) {
		
		List<Users> user=userdao.getUserById(uname);
		return user;
		
	}

	public List<Users> getUsers() {
		List<Users> users=userdao.getUsers();
		return users;
	}

	public void updateData(Users updateuser) {
		
		userdao.updateData(updateuser);
	}

	public int chkuser(String un, String pd) {
		return userdao.chkuser(un,pd);
		
	}


	public int chkuser1(String name) {
		int val=userdao.chkuser1(name);
		return val;
	}




	

}
