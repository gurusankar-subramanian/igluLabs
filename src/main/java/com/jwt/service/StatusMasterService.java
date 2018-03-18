package com.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.domain.StatusMaster;
import com.jwt.repository.*;
import com.jwt.*;

/**
 * Service for Status master entity
 * @author Guru Sankar
 *
 */
@Service
public class StatusMasterService {

	@Autowired
	StatusMasterRepository statusMasterRepository;

	public StatusMaster findByStatusCode(String statusCode) {
		return statusMasterRepository.findByStatusCode(statusCode);
	}

	public List<StatusMaster> findAll() {
		return statusMasterRepository.findAll();
	}
	
	public StatusMaster findById(Long id) {
		return statusMasterRepository.findOne(id);
	}
}
