package com.utrack.data.dao;

import java.util.List;

import com.utrack.data.model.Drivers;

public interface DriversDAO {
	public void addDrivers(Drivers d);
	public void updateDrivers(Drivers d);
	public List<Drivers> listDrivers();
	public Drivers getDriversById(int id);
	public List<Drivers> getDriversByDriversId(int did);
	public void removeDrivers(int id);
}
