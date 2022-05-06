package com.mediscreen.report.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class AgeCalculatorServiceImpl implements AgeCalculatorService {

	private Logger logger = LogManager.getLogger();

	@Override
	public int calculteAge(Date birthDay) {
		logger.debug("AgeCalculatorService : calculteAge");

		Period period = Period.between(birthDay.toInstant().atZone(ZoneId.of("-06")).toLocalDate(), LocalDate.now());
		
		return period.getYears();
	}

}
