package com.taskit.backend.controller;

import com.taskit.backend.dao.TaskDao;
import com.taskit.backend.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taskit")
public class TaskController {

    private TaskDao taskDao;

    public TaskController(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @GetMapping(path = "/tasks")
    public List<Task> getAllTasks() {
        //need to add try/catch
        return taskDao.findAllTasks();
    }

    @GetMapping(path = "/{Id}")
    public Task getTaskById(@PathVariable int Id) {
        //need to add try/catch
        return taskDao.findTaskById(Id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/create")
    public Task makeTask(@RequestBody Task task) {
        //need to add try/catch
        return taskDao.createTask(task);
    }

    @PutMapping(path = "/update/{Id}")
    public boolean updateTask(@PathVariable int Id, @RequestBody Task task) {
        //need to add try/catch
        return taskDao.updateTask(Id, task);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        //need to add try/catch
        taskDao.deleteTask(id);
    }
}
