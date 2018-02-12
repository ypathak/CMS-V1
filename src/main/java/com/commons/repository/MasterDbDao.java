package com.commons.repository;

import java.util.List;

import com.commons.master.entity.Cities;
import com.commons.master.entity.Countries;
import com.commons.master.entity.States;

public interface MasterDbDao {
	List<Countries> fetchCountries() throws Exception;

	List<States> fetchStates(int countryId) throws Exception;

	List<Cities> fetchCitiesByCountryAndState(int countryId, int stateId) throws Exception;
	
	List<Cities> fetchCitiesByCountry(int countryId) throws Exception;
}
