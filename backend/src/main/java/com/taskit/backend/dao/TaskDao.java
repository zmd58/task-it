package com.taskit.backend.dao;

import com.taskit.backend.model.Task;

import java.util.List;

public interface TaskDao {

    Task findTaskById(int Id);
    List<Task> findAllTasks();
    Task createTask(Task task);
    boolean updateTask(int Id, Task task);
    void deleteTask(int id);


}
