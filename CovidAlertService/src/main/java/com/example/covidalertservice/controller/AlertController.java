package com.example.covidalertservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.covidalertservice.dto.*;
import com.example.covidalertservice.service.AlertService;

@RestController
@RequestMapping("/india/")
public class AlertController 
{

	@Autowired
	private AlertService alertService;
	
	
	@GetMapping("/{state}")
	AlertStatus getAlertAboutState(@PathVariable String state)
	{
		return alertService.getAlertAboutState(state);
	}
	
	@GetMapping("/summary")
	public SummaryData getOverAllSummary()
	{
		return alertService.getOverAllSummary();
	}
	
	
}
