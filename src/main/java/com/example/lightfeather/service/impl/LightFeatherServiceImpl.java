package com.example.lightfeather.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lightfeather.model.Supervisor;
import com.example.lightfeather.model.SupervisorPostData;
import com.example.lightfeather.repository.LightFeatherRepository;
import com.example.lightfeather.service.LightFeatherService;

@Service
public class LightFeatherServiceImpl implements LightFeatherService{
	
	@Autowired
	private LightFeatherRepository lightFeatherRepository;

	@Override
	public List<Supervisor> getSupervisor() {
		List<Supervisor> list = lightFeatherRepository.getSupervisor();
		List<Supervisor> supervisorSortedList  = list.stream()
				.filter(sup -> !StringUtils.isNumeric(sup.getJurisdiction()))
						.sorted(Comparator.comparing(Supervisor::getJurisdiction)
								.thenComparing(Supervisor::getLastName).thenComparing(Supervisor::getFirstName))
						.collect(Collectors.toList());
		return supervisorSortedList;
	}

	@Override
	public void submitSupervisor(SupervisorPostData data) {
		System.out.println(data);
		
	}
	

}
