package com.taskit.service;

import com.taskit.model.Task;
import com.taskit.utility.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class TaskService {
    private final String baseUrl;
    private final RestTemplate restTemplate = new RestTemplate();

    public TaskService(String baseUrl) {
        this.baseUrl = baseUrl;
    }


    public Task[] getAllTasks() {
        // need to check for null on main when using this endpoint
        Task[] tasks = null;
        try {
            tasks = restTemplate.getForObject(baseUrl + "tasks", Task[].class);
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }

        return tasks;
    }

    public Task getTaskById(int taskId) {
        Task task = null;
        try {
            task = restTemplate.getForObject(baseUrl + taskId, Task.class);
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }

        return task;
    }

    public boolean createTask(Task task) {
        if (task != null) {
            HttpEntity<Task> entity = makeAuthEntity(task);
            try {
                restTemplate.exchange(baseUrl + "create", HttpMethod.POST, entity, Task.class);
                return true;
            } catch (RestClientResponseException | ResourceAccessException e) {
                BasicLogger.log(e.getMessage());
            }
        }

        return false;
    }

    public boolean editTask(int taskId, Task task) {
        if (taskId != task.getId()) {
            HttpEntity<Task> entity = makeAuthEntity(task);
            try {
                restTemplate.exchange(baseUrl + "create", HttpMethod.PUT, entity, Task.class);
                return true;
            } catch (RestClientResponseException | ResourceAccessException e) {
                BasicLogger.log(e.getMessage());
            }
        }

        return false;
    }

    public boolean deleteTask(int taskId) {
        try {
            restTemplate.delete(baseUrl + "delete/" + taskId);
            return true;
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }

        return false;
    }


    private HttpEntity<Task> makeAuthEntity(Task task) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(task, headers);
    }

    private HttpEntity<Void> makeAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(headers);
    }
}
