package com.utrack.data.dao;

import java.util.List;

import com.utrack.data.model.Carriers;

public interface CarriersDAO {
	public void addCarriers(Carriers d);
/*	public void updateCarriers(Carriers d);*/
/*	public List<Carriers> listCarriers();*/
	public Carriers getCarriersById(int id);
	public List<Carriers> getCarriersByCarrierName(String cname);
/*	public void removeCarriers(int id);*/
}
