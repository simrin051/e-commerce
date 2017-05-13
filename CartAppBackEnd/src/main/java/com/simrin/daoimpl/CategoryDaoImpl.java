package com.simrin.daoimpl;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.simrin.dao.CategoryDao;
import com.simrin.model.Category;

public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	SessionFactory sessionFactory;
	public CategoryDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	
	@Transactional
	public int deleteCategoryintById(int categoryid) {
		Category categoryToDelete = new Category();
		categoryToDelete.setCategoryid(categoryid);
		sessionFactory.getCurrentSession().delete(categoryToDelete);
		return 0;
	}
	@Transactional
	public int saveorupdate(Category category) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(category);
		return 0;
	

	}
	@Transactional
	public List<Category> getAllCategory() {
		@SuppressWarnings("unchecked")List<Category> listCategory = (List<Category>) sessionFactory.getCurrentSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCategory;
		
	}
	@Transactional
	public Category getCategoryBy(int categoryid) {
		System.out.println("asfaaaadada "+categoryid);
		String hql = "from Users where u= " + categoryid;
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) query.list();
		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
			}	
		return null;
	}	
}
