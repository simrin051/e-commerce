package com.simrin.daoimpl;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.simrin.dao.UserDao;
import com.simrin.model.Users;



public class UserDaoImpl implements UserDao{

	
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	
	
	@Transactional
	public List<Users> getAllusers() 
	{@SuppressWarnings("unchecked")List<Users> listUser = (List<Users>) sessionFactory.getCurrentSession().createCriteria(Users.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	return listUser;	
	
	}
	@Transactional
	public boolean validatelogin(String name, String password) {
		// TODO Auto-generated method stub
		return false;
	}
	@Transactional
	public Users getUserBy(int userid) {
		
		System.out.println("asfaaaadada "+userid);
		String hql = "from Users where u= " + userid;
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Users> listUsrs = (List<Users>) query.list();
		if (listUsrs != null && !listUsrs.isEmpty()) {
			return listUsrs.get(0);
			}
			
		return null;

	}
	
	@Transactional
	public int deleteUserById(int userid) {

	 
		Users usrToDelete = new Users();
		usrToDelete.setUserid(userid);
		sessionFactory.getCurrentSession().delete(usrToDelete);
		return 0;
		
	}
	
	@Transactional
	public int saveorUpdate(Users user) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(user);
		return 0;
	}


		
	}

	
	
	
	
	
	
	

	
