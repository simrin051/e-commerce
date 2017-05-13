package com.simrin.CartAppBackEnd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.simrin.dao.ShippingDao;
import com.simrin.model.Shipping;


public class ShippingTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.simrin.*");
		context.refresh();
		ShippingDao shippingDAO=(ShippingDao)context.getBean("shippingDao");
		Shipping shipping=(Shipping)context.getBean("shipping");
		List<Shipping> lst=shippingDAO.getAllShipping();
		for(Shipping ship:lst){
		System.out.println(ship.getUserid()+" "+ship.getFirstname()+" "+ship.getLastname()+" "+shipping.getLoginid()+""+shipping.getContact()+""+shipping.getCity()+""+shipping.getPincode());;
		}
	
	shipping.setUserid(5);
	shipping.setFirstname("ji");
	shipping.setLastname("AAA");
	shipping.setLoginid(57);
	shipping.setContact("487");
	shipping.setArea("kok");
	shipping.setCity("bang");
	shipping.setPincode(90);
	shippingDAO.saveorupdate(shipping);
	//shippingDAO.deleteShippingintById(5);
	}

}
