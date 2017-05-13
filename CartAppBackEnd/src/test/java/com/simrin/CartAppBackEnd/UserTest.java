package com.simrin.CartAppBackEnd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.simrin.dao.UserDao;
import com.simrin.model.Users;

public class UserTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.simrin.*");
		context.refresh();
//	UserDao userDAO=(UserDao)context.getBean("userDao");
//	Users users=(Users)context.getBean("user");
//	
//
//		List<Users> lst=userDAO.getAllusers();
//		for(Users usr:lst){
//		System.out.println(usr.getUserid()+" "+usr.getName()+" "+usr.getPassword()+" "+usr.getRole());
//		}
//	
//	users.setUserid(5);
//	users.setName("ji");
//	users.setPassword("AAA");
//	users.setRole("ROLE_USER");
//	userDAO.saveorUpdate(users);
//	
//	userDAO.deleteUserById(5);
	}

}
