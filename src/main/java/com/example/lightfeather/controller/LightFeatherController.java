package com.example.lightfeather.controller;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lightfeather.model.ErrorMessage;
import com.example.lightfeather.model.Supervisor;
import com.example.lightfeather.model.SupervisorPostData;
import com.example.lightfeather.service.LightFeatherService;

@RestController
@RequestMapping("/api/")
public class LightFeatherController {

	private static Logger logger = LoggerFactory.getLogger(LightFeatherController.class);

	@Autowired
	private LightFeatherService lightFeatherService;

	@CrossOrigin
	@GetMapping(value = "supervisors", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Supervisor>> getSuperViosrList() {
		List<Supervisor> supevisorList = lightFeatherService.getSupervisor();
		logger.info("list of supervisor from get api {}", supevisorList);
		return new ResponseEntity<>(supevisorList, HttpStatus.OK);

	}

	@CrossOrigin
	@PostMapping(value = "submit", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> submitSupervisor(@RequestBody SupervisorPostData supervisorPostData) {
		ErrorMessage error = new ErrorMessage();
		if (StringUtils.isBlank(supervisorPostData.getFirstName())
				|| StringUtils.isBlank(supervisorPostData.getLastName())
				|| Objects.isNull(supervisorPostData.getSupervisor())) {
			error.setErrorMessage("please provide the firstname, last name and supervisor");
			error.setDetailedMessage("400");
			logger.info("SupervisorPostData from ui  {}", supervisorPostData);
			return new ResponseEntity<>("please provide the firstname, last name and supervisor", HttpStatus.BAD_REQUEST);
		}
		if (!supervisorPostData.getFirstName().matches("[a-zA-Z]+")) {
			error.setErrorMessage("please provide proper name");
			error.setDetailedMessage("400");
			logger.info("SupervisorPostData from ui  {}", supervisorPostData);
			return new ResponseEntity<>("please provide proper name", HttpStatus.BAD_REQUEST);
		}
		if (StringUtils.isNotBlank(supervisorPostData.getPhoneNumber())
				&& !supervisorPostData.getPhoneNumber().matches("\\d{3}-\\d{3}-\\d{4}")) {
			error.setErrorMessage("please provide proper phone number");
			error.setDetailedMessage("400");
			logger.info("SupervisorPostData from ui  {}", supervisorPostData);
			return new ResponseEntity<>("please provide proper phone number", HttpStatus.BAD_REQUEST);
		}
		if (StringUtils.isNotBlank(supervisorPostData.getEmail()) && !Pattern
				.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$").matcher(supervisorPostData.getEmail()).matches()) {
			return new ResponseEntity<>("please provide proper email", HttpStatus.BAD_REQUEST);
		}
		lightFeatherService.submitSupervisor(supervisorPostData);
		logger.info("SupervisorPostData from ui  {}", supervisorPostData);
		return new ResponseEntity<>("data created", HttpStatus.CREATED);
	}

}
