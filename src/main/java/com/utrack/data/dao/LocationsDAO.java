package com.utrack.data.dao;

import java.util.List;

import com.utrack.data.model.Locations;


public interface LocationsDAO {
	public void addLocations(Locations d);
/*	public void updateLocations(Locations d);*/
/*	public List<Locations> listLocations();*/
	public Locations getLocationsById(int id);
	public List<Locations> getLocationsByLocationId(int lid);
/*	public void removeLocations(int id);*/
}
