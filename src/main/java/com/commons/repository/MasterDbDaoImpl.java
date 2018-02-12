package com.commons.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.commons.master.entity.Cities;
import com.commons.master.entity.Countries;
import com.commons.master.entity.States;

@Repository
public class MasterDbDaoImpl implements MasterDbDao{

	@Autowired
	SessionFactory sessionFactoryMaster;

	@SuppressWarnings("unchecked")
	@Override
	public List<Countries> fetchCountries() throws Exception {
		Session session = sessionFactoryMaster.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Countries> data = null;
		try {
			data = (List<Countries>)session.createQuery("from Countries order by name asc").list();
		} catch (Exception e) {
			throw e;
		} finally {
			transaction.commit();
			session.close();
		}
		return data;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<States> fetchStates(int countryId) throws Exception {
		Session session = sessionFactoryMaster.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<States> data = null;
		try {
			data = (List<States>)session.createQuery("from States where countryId = :countryId order by name asc").setParameter("countryId", countryId).list();
		} catch (Exception e) {
			throw e;
		} finally {
			transaction.commit();
			session.close();
		}
		return data;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cities> fetchCitiesByCountryAndState(int countryId, int stateId)
			throws Exception {
		Session session = sessionFactoryMaster.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Cities> data = null;
		try {
			data = (List<Cities>)session.createQuery("from Cities where countryId = :countryId and stateId = :stateId order by name asc")
					.setParameter("countryId", countryId)
					.setParameter("stateId", stateId)
					.list();
		} catch (Exception e) {
			throw e;
		} finally {
			transaction.commit();
			session.close();
		}
		return data;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cities> fetchCitiesByCountry(int countryId) throws Exception {
		Session session = sessionFactoryMaster.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		List<Cities> data = null;
		try {
			data = (List<Cities>)session.createQuery("from Cities where countryId = :countryId order by name asc")
					.setParameter("countryId", countryId)
					.list();
		} catch (Exception e) {
			throw e;
		} finally {
			transaction.commit();
			session.close();
		}
		return data;
	}
}
