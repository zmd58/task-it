package com.taskit.backend.dao;

import com.taskit.backend.model.Task;

import java.util.List;

public interface TaskDao {

    List<Task> findAllTasks();
    Task createTask(Task task);
    void deleteTask(int id);

}
