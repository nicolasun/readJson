package com.utrack.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.utrack.data.model.Drivers;
import com.utrack.data.dao.*;

@Service
@Transactional
public class DriversServiceImp implements DriversService{

	@Autowired
	private DriversDAO driversDAO;
	
	@Override
	public void addDrivers(Drivers d) {
		this.driversDAO.addDrivers(d);
		
	}

	@Override
	public void updateDrivers(Drivers d) {
		this.driversDAO.updateDrivers(d);
		
	}

	@Override
	public List<Drivers> listDrivers() {
		return this.driversDAO.listDrivers();
	}

	@Override
	public Drivers getDriversById(int id) {
		return this.driversDAO.getDriversById(id);
	}

	@Override
	public void removeDrivers(int id) {
		this.driversDAO.removeDrivers(id);
		
	}

	@Override
	public List<Drivers> getDriversByDriverId(int did) {
		return this.driversDAO.getDriversByDriversId(did);
	}

}
