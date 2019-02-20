package com.utrack.data.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.utrack.data.model.Locations;

@Repository
public class LocationsDAOImp implements LocationsDAO{
	private static final Logger logger = LoggerFactory.getLogger(LocationsDAOImp.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addLocations(Locations d) {
		getCurrentSession().persist(d);
		logger.info("Location saved successfully, Location Details="+d);
	}

/*	@Override
	public void updateLocations(Locations d) {
		getCurrentSession().update(d);
		logger.info("Location updated successfully, Location Details="+d);
		
	}*/

/*	@Override
	@SuppressWarnings("unchecked")
	public List<Locations> listLocations() {
		List<Locations> LocationsList = getCurrentSession().createQuery("from Locations").list();
		for(Locations d : LocationsList){
			logger.info("location List::"+d);
		}
		return LocationsList;
	}*/

	@Override
	public Locations getLocationsById(int id) {	
		Locations d = (Locations) getCurrentSession().load(Locations.class, new Integer(id));
		logger.info("location loaded successfully, location details="+d);
		return d;
	}

/*	@Override
	public void removeLocations(int id) {
		Locations d = (Locations) getCurrentSession().load(Locations.class, new Integer(id));
		if(null != d){
			getCurrentSession().delete(d);
		}
		logger.info("location deleted successfully, location details="+d);
	}*/

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<Locations> getLocationsByLocationId(int lid) {
		Query query = getCurrentSession().createQuery("from Locations where location_id = :locationId");
		query.setParameter("locationId", lid);
		List<Locations> locationList = query.getResultList();

		logger.debug("location search by cid successfully, Location details="+lid);
		
		return locationList;
	}

}
