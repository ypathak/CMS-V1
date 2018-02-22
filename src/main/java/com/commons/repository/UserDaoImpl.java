package com.commons.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.commons.entity.Client;
import com.commons.entity.Role;
import com.commons.entity.User;

@Repository
public class UserDaoImpl extends GenericDAOImpl<User, Long> implements UserDao {
	@Autowired
	SessionFactory sessionFactoryApp;

	@Override
	public User findByUserName(String userName) throws Exception {
		Session session = sessionFactoryApp.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		User user = null;
		try {
			String hql = "FROM User WHERE username = :username or email = :username";
			user = (User) session.createQuery(hql).setParameter("username", userName).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			transaction.commit();
			session.close();
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findallrole(String role) throws Exception {
		List<Role> list = null;
		Session session = sessionFactoryApp.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			String hql = "from Role WHERE role=:role";
			list = (List<Role>) session.createQuery(hql).setParameter("role", role).list();
		} catch (Exception e) {
			throw e;
		} finally {
			transaction.commit();
			session.close();
		}
		return list;
	}

	@Override
	public void save(User user) {
		Session session = sessionFactoryApp.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			user.setDeleted(false);
			session.save(user);
		} catch (Exception e) {
			throw e;
		} finally {
			transaction.commit();
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> clientlist(Long id) throws Exception {
		Session session = sessionFactoryApp.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Client> list = null;
		try{
			String hql="from Client where user_id=:user_id";	
			list = (List<Client>) session.createQuery(hql).setParameter("user_id", id).list();

		}catch(Exception e){
			throw e;

		}
		finally {
			transaction.commit();
			session.close();
		}
		return list;
	}

	@Override
	public void saveclient(Client client) throws Exception {
		Session session = sessionFactoryApp.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		try {
			client.setDeleted(false);
			session.save(client);
		} catch (Exception e) {
			throw e;
		} finally {
			transaction.commit();
			session.close();
		}
	}

	@Override
	public List<User> adminlist(Long id,int pagecount,int totalrecordparpage) {
		// TODO Auto-generated method stub
		Session session=sessionFactoryApp.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<User> list = null;
		try{
			String hql="from User where created_by=:created_by";	
			list = (List<User>) session.createQuery(hql).setParameter("created_by", id)
					.setFirstResult((pagecount-1)*totalrecordparpage).setMaxResults(pagecount*totalrecordparpage).list();

		}catch(Exception e){
			throw e;

		}
		finally {
			transaction.commit();
			session.close();
		}
		
		return list;
	}

	@Override
	public int totallist(Long id) {
		// TODO Auto-generated method stub
		Session session=sessionFactoryApp.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<User> list = null;
		try{
			String hql="from User where created_by=:created_by";	
			list = (List<User>) session.createQuery(hql).setParameter("created_by", id).list();

		}catch(Exception e){
			throw e;

		}
		finally {
			transaction.commit();
			session.close();
		}
		
		return list.size();
	}
}
