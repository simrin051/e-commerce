package com.simrin.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.simrin.dao.ShippingDao;
import com.simrin.model.Shipping;


public class ShippingDaoImpl implements ShippingDao{
	
	@Autowired
	SessionFactory sessionFactory;
	public ShippingDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public int saveorupdate(Shipping shipping) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(shipping);
		return 0;
	}
	@Transactional
	public List<Shipping> getAllShipping() {
		@SuppressWarnings("unchecked")List<Shipping> listShipping = (List<Shipping>) sessionFactory.getCurrentSession().createCriteria(Shipping.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listShipping;	

	}
	@Transactional
	public Shipping getShippingBy(int shippingid) {
		System.out.println("asfaaaadada "+shippingid);
		String hql = "from Users where u= " + shippingid;
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Shipping> listShipping = (List<Shipping>) query.list();
		if (listShipping != null && !listShipping.isEmpty()) {
			return listShipping.get(0);
		}
		return null;
	}
	@Transactional
	public int deleteShippingintById(int shippingid) {
		Shipping shippingToDelete = new Shipping();
		shippingToDelete.setShippingid(shippingid);
		sessionFactory.getCurrentSession().delete(shippingToDelete);
		return 0;
		
	}

}
