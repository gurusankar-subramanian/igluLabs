package com.jwt.controller;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.domain.StatusMaster;
import com.jwt.domain.Tasks;
import com.jwt.service.StatusMasterService;
import com.jwt.service.TasksService;
import com.jwt.util.CommonUtil;
import com.jwt.util.Constants;


/**
 * Controller for accessing tasks 
 * @author Guru Sankar
 *
 */

@RestController
@RequestMapping("tasks")
//@PreAuthorize("hasAuthority('"+Constants.ADMIN_USER+"') or hasAuthority('"+Constants.STANDARD_USER+"')")
public class TasksController {

	public static final Logger logger = LoggerFactory.getLogger(TasksController.class);

	@Autowired
	private TasksService tasksService;
 
	@Autowired
	private StatusMasterService statusMasterService;

	@Autowired
	private CommonUtil commonUtil;
	

	@SuppressWarnings("unchecked")
	@PostMapping(value = "/")
	public ResponseEntity<?> creatTask(@RequestBody Tasks task) {
		Boolean startAndEndDateTimeResult = commonUtil.validateStartAndEndDateTime(task);
		Boolean dateResult = commonUtil.validateDate(task);
		
		if(startAndEndDateTimeResult  && dateResult){
			StatusMaster status = statusMasterService.findByStatusCode(Constants.STATUS_NEW);
			task.setStatus(status);
			return new ResponseEntity<Tasks>(tasksService.save(task), HttpStatus.CREATED);
		}
		return new ResponseEntity<Tasks>(task, HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		Tasks tasks = tasksService.find(id);
		if(!Objects.isNull(tasks))
			return new ResponseEntity<Tasks>(tasks, HttpStatus.OK);
		else
			return new ResponseEntity<Tasks>(HttpStatus.NOT_FOUND);
	}

	@SuppressWarnings("unchecked")
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateTask(@PathVariable("id") Long id, @RequestBody Tasks task) {
		if(id != task.getId()){
			return new ResponseEntity<>("PathVariable and ID in task Object is not same ",HttpStatus.BAD_REQUEST);
		}
		Boolean startAndEndDateTimeResult = commonUtil.validateStartAndEndDateTime(task);
		Boolean dateResult = commonUtil.validateDate(task);
		if(startAndEndDateTimeResult  && dateResult){
			task = tasksService.update(task);
			if(!Objects.isNull(task))
				return new ResponseEntity<Tasks>(task, HttpStatus.OK);
			else
				return new ResponseEntity<>("Status is Completed - Cannot edit Task ", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("", HttpStatus.BAD_REQUEST);
	}

	@SuppressWarnings("unchecked")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable("id") Long id) {
		tasksService.delete(id);
		return new ResponseEntity<Tasks>(HttpStatus.OK);
	}
	

	@GetMapping("/all")
	public ResponseEntity<?> findAll(@RequestParam(value="currentDate", required=false, defaultValue="false") Boolean currentDate) {
		List<Tasks> tasks = tasksService.findAll(currentDate);
		if(tasks != null)
			return new ResponseEntity<List<Tasks>>(tasks, HttpStatus.OK);
		else
			return new ResponseEntity<Tasks>(HttpStatus.NO_CONTENT);
	}
}
