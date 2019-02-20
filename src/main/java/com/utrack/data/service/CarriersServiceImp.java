package com.utrack.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utrack.data.dao.CarriersDAO;
import com.utrack.data.model.Carriers;

@Service
@Transactional
public class CarriersServiceImp implements CarriersService {

	@Autowired
	private CarriersDAO CarriersDAO;
	
	@Override
	public void addCarriers(Carriers d) {
		this.CarriersDAO.addCarriers(d);
		
	}

/*	@Override
	public void updateCarriers(Carriers d) {
		this.CarriersDAO.updateCarriers(d);
		
	}*/

/*	@Override
	public List<Carriers> listCarriers() {
		return this.CarriersDAO.listCarriers();
	}*/

	@Override
	public Carriers getCarriersById(int id) {
		return this.CarriersDAO.getCarriersById(id);
	}

/*	@Override
	public void removeCarriers(int id) {
		this.CarriersDAO.removeCarriers(id);
		
	}*/

	@Override
	public List<Carriers> getCarriersByCarrierName(String cname) {
		return this.CarriersDAO.getCarriersByCarrierName(cname);
	}

}
