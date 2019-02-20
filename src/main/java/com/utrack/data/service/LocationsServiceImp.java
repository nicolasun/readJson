package com.utrack.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utrack.data.dao.LocationsDAO;
import com.utrack.data.model.Locations;

@Service
@Transactional
public class LocationsServiceImp implements LocationsService{

	@Autowired
	private LocationsDAO LocationsDAO;
	
	@Override
	public void addLocations(Locations d) {
		this.LocationsDAO.addLocations(d);
		
	}

/*	@Override
	public void updateLocations(Locations d) {
		this.LocationsDAO.updateLocations(d);
		
	}*/

/*	@Override
	public List<Locations> listLocations() {
		return this.LocationsDAO.listLocations();
	}*/

	@Override
	public Locations getLocationsById(int id) {
		return this.LocationsDAO.getLocationsById(id);
	}

	@Override
	public List<Locations> getLocationsByLocationId(int lid) {
		return this.LocationsDAO.getLocationsByLocationId(lid);
	}

/*	@Override
	public void removeLocations(int id) {
		this.LocationsDAO.removeLocations(id);
		
	}*/

	
	
}
