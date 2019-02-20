package com.utrack.data.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.utrack.data.model.Drivers;
import com.utrack.data.model.Locations;

@Repository
public class DriversDAOImp implements DriversDAO{

	private static final Logger logger = LoggerFactory.getLogger(DriversDAOImp.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addDrivers(Drivers d) {
		getCurrentSession().persist(d);
		logger.info("Driver saved successfully, Driver Details="+d);
	}

	@Override
	public void updateDrivers(Drivers d) {
		getCurrentSession().update(d);
		logger.info("Driver updated successfully, Driver Details="+d);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Drivers> listDrivers() {
		List<Drivers> driversList = getCurrentSession().createQuery("from Drivers").list();
		for(Drivers d : driversList){
			logger.info("Person List::"+d);
		}
		return driversList;
	}

	@Override
	public Drivers getDriversById(int id) {	
		Drivers d = (Drivers) getCurrentSession().load(Drivers.class, new Integer(id));
		logger.info("Person loaded successfully, Person details="+d);
		return d;
	}

	@Override
	public void removeDrivers(int id) {
		Drivers d = (Drivers) getCurrentSession().load(Drivers.class, new Integer(id));
		if(null != d){
			getCurrentSession().delete(d);
		}
		logger.info("Person deleted successfully, person details="+d);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Drivers> getDriversByDriversId(int did) {
		Query query = getCurrentSession().createQuery("from Drivers where driver_id = :driverId ");
		query.setParameter("driverId", did);
		List<Drivers> driversList = query.getResultList();
		return driversList;
	}

}
