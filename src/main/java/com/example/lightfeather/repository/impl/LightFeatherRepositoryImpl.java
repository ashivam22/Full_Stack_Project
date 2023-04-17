package com.example.lightfeather.repository.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.lightfeather.model.Supervisor;
import com.example.lightfeather.repository.LightFeatherRepository;


@Repository
public class LightFeatherRepositoryImpl implements LightFeatherRepository{
	
	@Value("${aplicartion.url}")
	private String apiUrl;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public  List<Supervisor> getSupervisor() {
		ResponseEntity<Supervisor[]> apiResponse = restTemplate.getForEntity(apiUrl, Supervisor[].class);
		return Arrays.asList(apiResponse.getBody());
	}

}
