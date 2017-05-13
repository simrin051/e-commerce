package com.simrin.dao;



import java.util.List;

import com.simrin.model.Users;




public interface UserDao {
	
	int saveorUpdate(Users user);
	List<Users>getAllusers();
	boolean validatelogin(String name,String password);
	Users getUserBy(int userid);
	int deleteUserById(int userid);



}
