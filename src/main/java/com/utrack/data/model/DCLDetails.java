package com.utrack.data.model;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class DCLDetails {
	
	@NotEmpty
	private int oper_nbr;
	@NotEmpty
	private String carrier_cd;
	@NotEmpty
	private String last_name;
	@NotEmpty
	private String first_name;
	
	private String middle_init;
	@NotEmpty
	private int home_loc_6;
	@NotEmpty
	private String home_loc_3;
	@NotEmpty
	private String oper_class;
}
