package com.utrack.data.service;

import java.util.List;

import com.utrack.data.model.Drivers;

public interface DriversService {
	public void addDrivers(Drivers d);
	public void updateDrivers(Drivers d);
	public List<Drivers> listDrivers();
	public Drivers getDriversById(int id);
	public List<Drivers> getDriversByDriverId(int did);
	public void removeDrivers(int id);
}
