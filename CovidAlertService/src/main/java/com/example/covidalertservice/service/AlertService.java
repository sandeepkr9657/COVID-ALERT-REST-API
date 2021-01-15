package com.example.covidalertservice.service;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.covidalertservice.dto.AlertStatus;
import com.example.covidalertservice.dto.StateData;
import com.example.covidalertservice.dto.SummaryData;


@Service
public class AlertService 

{
	@Autowired
	private Covid19DataProvider covid19DataProvider;
	
	public AlertStatus getAlertAboutState(String state)
	{
		AlertStatus alertStatus = new AlertStatus();
		
		StateData stateData = covid19DataProvider.getStateData(state);
		
		
		alertStatus.setSummaryData(stateData);
		if(stateData.getTotalConfirmed()<1000)
		{
			alertStatus.setAlertLevel("GREEN");
			alertStatus.setMeasuresToBeTaken(Arrays.asList("Everything is Normal !!"));
		}
		else if(stateData.getTotalConfirmed()>1000 && stateData.getTotalConfirmed()<10000)
		{
			alertStatus.setAlertLevel("ORANGE");
			alertStatus.setMeasuresToBeTaken(Arrays.asList("Only Essential Services are allowed !!"));
		}
		else
		{
			alertStatus.setAlertLevel("RED");
			alertStatus.setMeasuresToBeTaken(Arrays.asList("TOTAL LOCKDOWN !!"));
		}
		
		return alertStatus;
	}
	
	public SummaryData getOverAllSummary()
	{
		 return covid19DataProvider.getSummaryData("summary");
	}
}
