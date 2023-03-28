package com.taskit.backend.controller;

import com.taskit.backend.dao.TaskDao;
import com.taskit.backend.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taskit/tasks")
public class TaskController {

    private TaskDao taskDao;

    public TaskController(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @GetMapping()
    public List<Task> getAllTasks() {
        //need to add try/catch
            return taskDao.findAllTasks();
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Task makeTask(@RequestBody Task task) {
        //need to add try/catch
        return taskDao.createTask(task);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        //need to add try/catch
        taskDao.deleteTask(id);
    }
}
