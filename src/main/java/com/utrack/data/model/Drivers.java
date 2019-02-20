package com.utrack.data.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import lombok.Data;

@Data
@Entity
@Table(name="drivers")
public class Drivers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Version
	private int version;
	private int driver_id;
	private String first_name;
	private String middle_init;
	private String last_name;
	private String oper_class;
	
	
	@ManyToOne(targetEntity=Carriers.class)
	@JoinColumn(name="carrier_id")
	private Carriers carriers;
	
	@ManyToOne(targetEntity=Locations.class)
	@JoinColumn(name="location_id")
	private Locations locations;
	
}
