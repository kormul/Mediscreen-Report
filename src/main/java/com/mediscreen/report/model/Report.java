package com.mediscreen.report.model;

import com.mediscreen.report.enumeration.RiskLevel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Report {
	
	private RiskLevel riskLevel;

}
