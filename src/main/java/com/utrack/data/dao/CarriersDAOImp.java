package com.utrack.data.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.utrack.data.model.Carriers;

@Repository
public class CarriersDAOImp implements CarriersDAO{
	private static final Logger logger = LoggerFactory.getLogger(CarriersDAOImp.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void addCarriers(Carriers d) {
		getCurrentSession().persist(d);
		logger.info("Carrier saved successfully, Carrier Details="+d);
	}

/*	@Override
	public void updateCarriers(Carriers d) {
		getCurrentSession().update(d);
		logger.info("Carrier updated successfully, Carrier Details="+d);
		
	}*/

/*	@Override
	@SuppressWarnings("unchecked")
	public List<Carriers> listCarriers() {
		List<Carriers> CarriersList = getCurrentSession().createQuery("from Carriers").list();
		for(Carriers d : CarriersList){
			logger.info("Carrier List::"+d);
		}
		return CarriersList;
	}*/

	@Override
	public Carriers getCarriersById(int id) {	
		Carriers d = (Carriers) getCurrentSession().load(Carriers.class, new Integer(id));
		logger.info("Carrier loaded successfully, Carrier details="+d);
		return d;
	}

/*	@Override
	public void removeCarriers(int id) {
		Carriers d = (Carriers) getCurrentSession().load(Carriers.class, new Integer(id));
		if(null != d){
			getCurrentSession().delete(d);
		}
		logger.info("Carrier deleted successfully, Carrier details="+d);
	}*/

	@Override
	public List<Carriers> getCarriersByCarrierName(String cname) {
		Query query = getCurrentSession().createQuery("from Carriers where carrier_name = :carrierName");
		query.setParameter("carrierName", cname);
		List<Carriers> CarriersList = query.getResultList();

		logger.debug("Carrier search by cid successfully, Carrier details="+cname);
		
		return CarriersList;
	}

}
