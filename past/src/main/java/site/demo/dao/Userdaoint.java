package site.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import site.demo.model.Users;

public interface Userdaoint {
	
	public void addUserDetails(Users user);
	public List<Users> getUserById(String uname);
	public List<Users> getUsers();
	public void updateData(Users updateuser);
	public int chkuser(String un,String pd);
	public int chkuser1(String name);
}
