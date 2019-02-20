package com.utrack.data.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utrack.data.model.Carriers;
import com.utrack.data.model.DCLDetails;
import com.utrack.data.model.DCLResponse;
import com.utrack.data.model.Drivers;
import com.utrack.data.model.Locations;
import com.utrack.data.utility.StringFormat;

@Service
public class DBTransation {
	
	@Autowired
	private CarriersService carriersService;
	@Autowired
	private LocationsService locationsService;
	@Autowired
	private DriversService driversService;
	@Autowired
	private JsonService jsonData;
	
	private static final Logger logger = LoggerFactory.getLogger(DBTransation.class);
	
	public void storeJsonToDB() {
		DCLResponse dclresponse = jsonData.jsonToObject();
		if(null!=dclresponse) {
			logger.debug("get json data to loop");
			for(DCLDetails dcl :dclresponse.getResults()) {
				//check carrier in db if there is exist one, do not insert
				Carriers carrier = null;
				if(!dcl.getCarrier_cd().isEmpty()) {
					List<Carriers> carriersList =  carriersService.getCarriersByCarrierName(dcl.getCarrier_cd());
					if(carriersList.size()>0) {
						carrier = carriersList.get(0);
					}
				}
				
				if(null==carrier) {
					carrier = new Carriers();
					carrier.setCarrier_name(StringFormat.capital(dcl.getCarrier_cd()));
					carriersService.addCarriers(carrier);
					carrier.setId(carriersService.getCarriersByCarrierName(dcl.getCarrier_cd()).get(0).getId());
				}
				
				
				//check location in db if there is exist one, do not insert
				Locations location = null;
				if(dcl.getHome_loc_6()>0) {
					List<Locations> locationsList = locationsService.getLocationsByLocationId(dcl.getHome_loc_6());
					if(locationsList.size()>0) {
						location = locationsList.get(0);
					}
				}
				
				if(null==location) {
					location = new Locations();
					location.setLocation_id(dcl.getHome_loc_6());
					location.setLocation_name(StringFormat.capital(dcl.getHome_loc_3()));
					locationsService.addLocations(location);
					//get location auto id back
					location.setId(locationsService.getLocationsByLocationId(dcl.getHome_loc_6()).get(0).getId());
				}
				
				
				//if carrier and location ready insert 
				//check driver exist
				//update the exist driver
				Drivers driver = new Drivers();
				if(dcl.getOper_nbr() > 0) {
					List<Drivers> driverList = driversService.getDriversByDriverId(dcl.getOper_nbr());
					if(driverList.size()>0) {
						driver = driverList.get(0);
					}
				}
				driver.setCarriers(carrier);
				driver.setLocations(location);
				driver.setDriver_id(dcl.getOper_nbr());
				driver.setFirst_name(StringFormat.capital(dcl.getFirst_name()));
				driver.setLast_name(StringFormat.capital(dcl.getLast_name()));
				driver.setMiddle_init(StringFormat.capital(dcl.getMiddle_init()));
				driver.setOper_class(StringFormat.capital(dcl.getOper_class()));
				
				if(driver.getId() > 0) {
					driversService.updateDrivers(driver);
				}
				else {
					driversService.addDrivers(driver);
				}		
			}
		}
		else {
			logger.debug("reponse is null");
		}
	}
	
}
