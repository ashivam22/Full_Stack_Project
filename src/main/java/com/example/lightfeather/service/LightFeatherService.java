package com.example.lightfeather.service;

import java.util.List;

import com.example.lightfeather.model.Supervisor;
import com.example.lightfeather.model.SupervisorPostData;

public interface LightFeatherService {
	
	public List<Supervisor> getSupervisor();
	public void submitSupervisor(SupervisorPostData data);
	

}
