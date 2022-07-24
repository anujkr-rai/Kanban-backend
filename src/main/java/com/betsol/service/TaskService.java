package com.betsol.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.betsol.repository.TaskRepository;
import com.betsol.repository.UserRepository;
import com.betsol.model.Task;
import com.betsol.model.TaskDto;

import com.betsol.model.changeTask;

@Service
public class TaskService {

    @Autowired
    public TaskRepository taskRepo;

    @Autowired
    public UserRepository userRepo;

    public Task getTask(Long taskID) {
        Optional<Task> findById = taskRepo.findById(taskID);
        return findById.get();
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<Task>();
        taskRepo.findAll().forEach(task -> tasks.add(task));
        return tasks;
    }

    public ResponseEntity<String> createTask(TaskDto taskDto){
        try{

            
        if(!userRepo.existsById(taskDto.getUserID()))
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User id not valid");

        Task task= new Task();
        task.setTaskID(taskDto.getTaskID());
        task.setTask_name(taskDto.getTask_name());
        task.setDeadline(taskDto.getDeadline());
        task.setDetails(taskDto.getDetails());
        task.setPriority(taskDto.getPriority());
        task.setDateCreated(taskDto.getDateCreated());
        task.setUserID(taskDto.getUserID());
        task.setStatus(taskDto.getStatus());
        // UserDao user = new UserDao();
        // user.setId(taskDto.getUserID());
        // task.setUserID(user);

        taskRepo.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body("Sucessfully Created");
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.toString());
        }
    }

    public ResponseEntity<?> getUserTask(Long user_id){
        List<Task> list = taskRepo.getUserTask(user_id);
        return ResponseEntity.ok().body(list);
    }


    public String deleteTask(Long taskID) {
        if (taskRepo.existsById(taskID)) {
            taskRepo.deleteById(taskID);
            return "Deleted successfully";
        }
        return "User not found";
    }

    public Task changeTask(changeTask changeTask) {

        taskRepo.changeTask(changeTask.getTask_id(), changeTask.getTask_name(), changeTask.getDetails(),
                changeTask.getPriority(), changeTask.getDeadline(), changeTask.getStatus());
        return taskRepo.findById(changeTask.getTask_id()).get();
    }
}
