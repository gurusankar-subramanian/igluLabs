package com.jwt.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.SimpleFormatter;

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

	public Tasks save(Tasks task) {
		return tasksRepository.saveAndFlush(task);
	}

	public Tasks update(Tasks task) {
		Tasks dbTask = find(task.getId());
		//if status is already completed - we should not edit the task 
		if(Constants.STATUS_COMPLETED.equals(dbTask.getStatus().getStatusCode()))
			return null;

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

	public List<Tasks> findAll(Boolean currentDate) {
		if(currentDate)
			return tasksRepository.findByDate(new SimpleDateFormat(Constants.COMMON_DATE_FORMAT).format(new Date()));
		else	
			return tasksRepository.findAll();
	}
	
}
