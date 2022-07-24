package com.betsol.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.betsol.model.Task;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
 
    @Transactional
    @Modifying
    @Query(value = "update task set task.task_name = :taskName, task.details = :details, task.priority = :priority, task.deadline = :deadline, task.status= :status where task.task_id = :taskID ", nativeQuery = true)
    void changeTask(@Param("taskID") Long taskID, @Param("taskName") String taskName, @Param("details") String details, @Param("priority") Integer priority, @Param("deadline")String deadline, @Param("status") String status);


    @Transactional
    @Modifying
    @Query(value="select * from task where task.user_id = :user_id", nativeQuery = true)
    List<Task> getUserTask(@Param("user_id") Long user_id);
}
