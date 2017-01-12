package site.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;


import site.demo.model.Users;


public interface Userserviceint {
	
	public void addUserDetails(Users user);
	public List<Users> getUserById(String uname);
	public List<Users> getUsers();
	public void updateData(Users updateuser);
	public int chkuser(String un,String pd);
	public int chkuser1(String name);

}
