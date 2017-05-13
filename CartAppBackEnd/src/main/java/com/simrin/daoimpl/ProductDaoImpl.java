package com.simrin.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.simrin.dao.ProductDao;
import com.simrin.model.Product;


public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	SessionFactory sessionFactory;
	public ProductDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public int saveorupdate(Product product) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(product);
		return 0;
	}
	
	@Transactional	
	public List<Product> getAllProduct() {
		@SuppressWarnings("unchecked")List<Product> listProduct = (List<Product>) sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listProduct;	
	
	}
	@Transactional
	public Product getProductBy(int productid) {
		System.out.println("asfaaaadada "+productid);
		String hql = "from Users where u= " +productid;
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) query.list();
		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
			}
		return null;
	}
	@Transactional
	public int deleteProductintById(int productid) {
		Product productToDelete = new Product();
		productToDelete.setProductid(productid);
		sessionFactory.getCurrentSession().delete(productToDelete);
	
		
		return 0;
	}
	

}
