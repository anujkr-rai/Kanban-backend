package com.betsol.model;


import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table
public class Task {

    @Column(name="task_name")
    private String task_name;

    @Column(name="details")
    private String details;
    
    @Id
    @Column(name="task_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskID;

    @Column(name="priority")
    private Integer priority;

    @Column(name="deadline")
    private String deadline;

    @CreationTimestamp
    @Column(name="date_created", updatable = false)
    private Date dateCreated;

    @Column(name="user_id")
    private long user_id;

    @Column(name="status")
    private String status;

    // @OneToOne
    // @JoinColumn(name="user_id")
    // private User userID;

    // @OneToOne
    // @JoinColumn(name="user_id", referencedColumnName = "user_id")
    // private UserDao userID;

    public Task(){

    }

    public Task(String task_name,String details, Long taskID, Integer priority, String deadline, String status, Long userID) {
		super();
		this.task_name=task_name;
        this.deadline=deadline;
        this.details=details;
        this.priority=priority;
        this.taskID=taskID;
        this.status=status;
        this.user_id=userID;
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
        return user_id;
    }

    public void setUserID(Long userID) {
        this.user_id = userID;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    

    


    
}
