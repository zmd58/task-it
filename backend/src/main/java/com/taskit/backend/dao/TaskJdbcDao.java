package com.taskit.backend.dao;

import com.taskit.backend.model.Task;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class TaskJdbcDao implements TaskDao {

    private final JdbcTemplate jdbcTemplate;

    public TaskJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Task> findAllTasks() {
        //need a try/catch
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT title, note, date, status FROM tasks;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            tasks.add(mapRowToTask(results));
        }
        return tasks;
    }

    @Override
    public Task createTask(Task task) {
        //need to add try/catch
        String sql = "INSERT INTO tasks (title, note, date, status) VALUES (?, ?, ?, ?):";
        int taskId = jdbcTemplate.queryForObject(sql, int.class, task.getTitle(), task.getNote(), task.getDate(), task.getStatus());
        task.setId(taskId);
        return task;
    }

    @Override
    public void deleteTask(int id) {
        //need to add try/catch
        String sql = "DELETE FROM tasks WHERE task_id = ?;";
        jdbcTemplate.update(sql,id);
    }

    private Task mapRowToTask(SqlRowSet res){
        Task task = new Task();
        task.setId(res.getInt("task_id"));
        task.setTitle(res.getString("title"));
        task.setNote(res.getString("note"));
        task.setDate(res.getDate("date").toLocalDate());
        task.setStatus(res.getBoolean("status"));

        return task;
    }
}
