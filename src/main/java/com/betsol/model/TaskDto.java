package com.betsol.model;

import java.sql.Date;

public class TaskDto {
   
    private String task_name;
    
    private String details;    
    
    private Long taskID;
    
    private Integer priority;
    
    private String deadline;
    
    private Date dateCreated;
    
    private Long userID;

    private String status;

    public TaskDto(){

    }

    public TaskDto(String task_name,String details, Long taskID, Integer priority, String deadline, String status, Long userID) {
		this.task_name=task_name;
        this.deadline=deadline;
        this.details=details;
        this.priority=priority;
        this.taskID=taskID;
        this.userID=userID;
        this.status=status;
	}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Long getTaskID() {
        return taskID;
    }

    public void setTaskID(Long taskID) {
        this.taskID = taskID;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    
}
