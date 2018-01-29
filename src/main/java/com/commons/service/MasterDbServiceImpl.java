package com.commons.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commons.master.entity.Cities;
import com.commons.master.entity.Countries;
import com.commons.master.entity.States;
import com.commons.repository.MasterDbDao;

@Service
@Transactional
public class MasterDbServiceImpl implements MasterDbService{

	@Autowired
	MasterDbDao masterDbDao;

	@Override
	public List<Countries> fetchCountries() throws Exception {
		return masterDbDao.fetchCountries();
	}

	@Override
	public List<States> fetchStates(int countryId) throws Exception {
		return masterDbDao.fetchStates(countryId);
	}

	@Override
	public List<Cities> fetchCitiesByCountryAndState(int countryId, int stateId) throws Exception {
		return masterDbDao.fetchCitiesByCountryAndState(countryId, stateId);
	}

	@Override
	public List<Cities> fetchCitiesByCountry(int countryId) throws Exception {
		return masterDbDao.fetchCitiesByCountry(countryId);
	}
}
