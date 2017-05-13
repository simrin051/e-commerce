package com.simrin.dao;



import java.util.List;

import com.simrin.model.Category;


public interface CategoryDao {
	int saveorupdate(Category category);
	List<Category>getAllCategory();
	Category getCategoryBy(int categoryid);
	int deleteCategoryintById(int categoryid);


}
