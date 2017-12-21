package com.commons.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.commons.entity.Role;
import com.commons.entity.User;

@Repository
public class UserDaoImpl extends GenericDAOImpl<User, Long> implements UserDao  {
	@Autowired
	SessionFactory sessionfactory;

	Session session;
	Transaction transaction;
	@Override
	public User findByUserName(String userName) throws Exception{
		session  = sessionfactory.getCurrentSession();
		transaction =session.beginTransaction();
		
		User user = null;
		try {
			String hql = "FROM User WHERE username = :username or email = :username";
			user = (User) session.createQuery(hql)
					.setParameter("username", userName).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			transaction.commit();
			session.close();
		}
		return user;
	}

	@Override
	public List<Role> findallrole(String role) throws Exception{
		// TODO Auto-generated method stub
		List<Role> list;
		session=sessionfactory.getCurrentSession();
		transaction=session.beginTransaction();
		try{
			String hql = "from Role WHERE role=:role";
			 list=session.createQuery(hql).setParameter("role",role).list();
		}catch(Exception e){
			throw e;
		}finally {
			transaction.commit();
			session.close();
		}
		return list;
	}
      @Override
      public void save(User user){
    	  System.out.println("user dao+++++++++++++++++");
    	  session=sessionfactory.getCurrentSession();
  		transaction=session.beginTransaction();
  		try{
  			user.setDeleted(false);
  			 session.save(user);
  		}catch(Exception e){
  			throw e;
  		}finally {
  			transaction.commit();
  			session.close();
  		}
      }
	
}
