package com.betsol.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.betsol.model.Task;
import com.betsol.model.TaskDto;
import com.betsol.model.changeTask;
import com.betsol.service.TaskService;


import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TaskController {
	
	@Autowired
	private TaskService taskService;


	@GetMapping("/getTask/{taskID}")
	public ResponseEntity<?> getTask(@PathVariable("taskID") Long taskID){
		try {
			String CLASS_NAME= "getTask";
			log.info(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()) +"Getting a single Task from "+CLASS_NAME);
			taskService.getTask(taskID);
			return ResponseEntity.status(HttpStatus.FOUND).body("Found!");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.toString());
		}
		
	}

	@GetMapping("/getAllTasks")
	public List<Task> getAllTasks(){
		return taskService.getAllTasks();
	}

	@PostMapping("/createTask")
	public ResponseEntity<String> createTask(@RequestBody TaskDto task){
		try {
			String CLASS_NAME= "createTask";
			log.info(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()) +"Created a new task from"+CLASS_NAME);
			return taskService.createTask(task);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.toString());
		}
		
	}

	@DeleteMapping("/deleteTask/{taskID}")
	public ResponseEntity<?> deleteTask(@PathVariable("taskID") Long taskID){
		try {
			String CLASS_NAME= "deleteTask";
			log.info(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()) +"Deleted Task "+CLASS_NAME);
		 	taskService.deleteTask(taskID);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deleted!");
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.toString());
		}
	}

	@PutMapping("/changeTask")
	public Task changeTask(@RequestBody changeTask changeTask){
		String CLASS_NAME= "editTask";
		log.info(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()) +"Editing Task from "+CLASS_NAME);
		return taskService.changeTask(changeTask);
	}

	@GetMapping("/getUserTask/{user_id}")
	public ResponseEntity<?> getUserTask(@PathVariable("user_id") Long user_id){
		String CLASS_NAME= "getUserTask";
		log.info(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()) +"Editing Task from "+CLASS_NAME);
		return taskService.getUserTask(user_id);
	}

}