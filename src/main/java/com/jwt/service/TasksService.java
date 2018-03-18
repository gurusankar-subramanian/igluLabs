package com.jwt.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.repository.*; 
import com.jwt.util.Constants;
import com.jwt.util.EmailUtil;
import com.jwt.domain.*;

/**
 * Service for Tasks entity
 * @author Guru Sankar
 *
 */
@Service
public class TasksService {

	@Autowired
	TasksRepository tasksRepository;

	@Autowired
	StatusMasterService statusMasterService;

	@Autowired	
	EmailUtil emailUtil;

	public Tasks save(Tasks user) {
		return tasksRepository.saveAndFlush(user);
	}

	public Tasks update(Tasks task) {
		task = tasksRepository.save(task);
		StatusMaster statusMaster = statusMasterService.findById(task.getStatus().getId());
		if(Constants.STATUS_COMPLETED.equals(statusMaster.getStatusCode())){
			emailUtil.sendSimpleMessage(Constants.EMAIL_TO, Constants.EMAIL_SUBJECT, Constants.EMAIL_TEXT);
		}
		return tasksRepository.save(task);
	} 

	public Tasks find(Long id) {
		return tasksRepository.findOne(id);
	}
	
	public void delete(Long id) {
		Tasks tasks = find(id);
		if(!Objects.isNull(tasks)){
			tasksRepository.delete(tasks);
		}
	} 

	public List<Tasks> findAll() {
		return tasksRepository.findAll();
	}
	
}
