package com.simrin.CartAppBackEnd;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.simrin.dao.CategoryDao;
import com.simrin.model.Category;

public class CategoryTest {
public static void main(String[] args) {
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.simrin.*");
	context.refresh();
	CategoryDao categoryDAO=(CategoryDao)context.getBean("categoryDao");
	Category category=(Category)context.getBean("category");
	List<Category> lst=categoryDAO.getAllCategory();
	for(Category cat:lst){
	System.out.println(cat.getCategoryid()+" "+cat.getCategory());
	}

category.setCategoryid(5);
category.setCategory("ji");
categoryDAO.saveorupdate(category);

//categoryDAO.deleteCategoryintById(5);
}
}
