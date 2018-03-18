package com.jwt.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.domain.StatusMaster;
import com.jwt.service.StatusMasterService;

/**
 * Controller for accessing status master 
 * @author Guru Sankar
 *
 */
@RestController
@RequestMapping("status")
public class StatusMasterController {

	public static final Logger logger = LoggerFactory.getLogger(StatusMasterController.class);
 
	@Autowired
	private StatusMasterService statusMasterService;

	@GetMapping("/all")
	public List<StatusMaster> getAll() {
		return statusMasterService.findAll();
	}

}
