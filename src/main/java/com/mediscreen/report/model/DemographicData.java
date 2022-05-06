package com.mediscreen.report.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DemographicData {
	
	private String firstName;
	private String lastName;
	private int age;
	private boolean isMan;
	private String City;
	

}
