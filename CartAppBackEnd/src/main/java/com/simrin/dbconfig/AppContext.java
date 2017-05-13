package com.simrin.dbconfig;


import java.util.Properties;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.simrin.dao.CartDao;
import com.simrin.dao.CategoryDao;
import com.simrin.dao.ProductDao;
import com.simrin.dao.ShippingDao;
import com.simrin.dao.UserDao;
import com.simrin.daoimpl.CartDaoImpl;
import com.simrin.daoimpl.CategoryDaoImpl;
import com.simrin.daoimpl.ProductDaoImpl;
import com.simrin.daoimpl.ShippingDaoImpl;
import com.simrin.daoimpl.UserDaoImpl;
import com.simrin.model.Cart;
import com.simrin.model.Category;
import com.simrin.model.Product;
import com.simrin.model.Shipping;
import com.simrin.model.Users;

@EnableTransactionManagement
@Configuration
@ComponentScan("com.simrin.*")
public class AppContext {
	

	 @Bean
	 (name = "dataSource")
	    public DataSource getDataSource() {
	    	BasicDataSource dataSource = new BasicDataSource();
	    	dataSource.setDriverClassName("org.h2.Driver");
	    	dataSource.setUrl("jdbc:h2:tcp://localhost/~/shoppingDB");
	    	dataSource.setUsername("sa");
	    	dataSource.setPassword("");
	    	
	    	return dataSource;
	    }
	 
	 
	 
	  private Properties getHibernateProperties() {
	    	Properties properties = new Properties();
	    	properties.put("hibernate.show_sql", "true");
	    	properties.put("hibernate.format_sql", "true");
	    	properties.put("hibernate.hbm2ddl.auto", "update");
	    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	    	return properties;
	    }
	 
	  @Autowired
	    @Bean(name = "sessionFactory")
	    public SessionFactory getSessionFactory(DataSource dataSource) {
	    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	    	sessionBuilder.addProperties(getHibernateProperties());
	    	sessionBuilder.addAnnotatedClass(Users.class);
	    	sessionBuilder.addAnnotatedClass(Cart.class);
	    	sessionBuilder.addAnnotatedClass(Category.class);
	    	sessionBuilder.addAnnotatedClass(Product.class);
	    	sessionBuilder.addAnnotatedClass(Shipping.class);
	    	return sessionBuilder.buildSessionFactory();
	    }
	  
	  
	  @Autowired
		@Bean(name = "transactionManager")
		public HibernateTransactionManager getTransactionManager(
				SessionFactory sessionFactory) {
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(
					sessionFactory);

			return transactionManager;
		}
	  
		@Autowired
		@Bean(name="userDao")
		public UserDao getUserDao(SessionFactory sessionFactory){
			return new UserDaoImpl(sessionFactory);
		}
		@Autowired
		@Bean(name="user")
		public Users getUser(){
			return new Users();
			
		}
		@Autowired
		@Bean(name="cartDao")
		public CartDao getCartDao(SessionFactory sessionFactory){
			return new CartDaoImpl(sessionFactory);
		}
		@Autowired
		@Bean(name="cart")
		public Cart getCart(){
			return new Cart();
		}
		@Autowired
		@Bean(name="categoryDao")
		public CategoryDao getCategoryDao(SessionFactory sessionFactory){
		
			return new CategoryDaoImpl(sessionFactory);
		}
		@Autowired
		@Bean(name="category")
		public Category getCategory()
		{
			return new Category();
		}
		@Autowired
		@Bean(name="productDao")
		public ProductDao getProductDao(SessionFactory sessionFactory){
			return new ProductDaoImpl(sessionFactory);
		}
		@Autowired
		@Bean(name="product")
		public Product getProduct(){
			return new Product();
		}
		@Autowired
		@Bean(name="shippingDao")
		public ShippingDao getShippingDao(SessionFactory sessionFactory)
		{
			return new ShippingDaoImpl(sessionFactory);
		}
		@Autowired
		@Bean(name="shipping")
		public Shipping getShipping()
		{
			return new Shipping();
		}
}
