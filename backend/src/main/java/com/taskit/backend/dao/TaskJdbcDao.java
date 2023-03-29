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
    public Task findTaskById(int Id) {
        Task task = null;
        String sql = "SELECT task_id, title, note, date_due, task_status FROM tasks WHERE task_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, Id);

        if (results.next()) {
            task = mapRowToTask(results);
        }

        return task;
    }

    @Override
    public List<Task> findAllTasks() {
        //need to add try/catch
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT task_id, title, note, date_due, task_status FROM tasks;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            tasks.add(mapRowToTask(results));
        }
        return tasks;
    }

    @Override
    public Task createTask(Task task) {
        //would we need to create status or have it default to not_completed?
        //need to add try/catch
        String sql = "INSERT INTO tasks (title, note, date_due, task_status) VALUES (?, ?, ?, ?);";
        int taskId = jdbcTemplate.queryForObject(sql, int.class, task.getTitle(), task.getNote(), task.getDate(), task.getStatus());
        task.setId(taskId);
        return task;
    }

    @Override
    public boolean updateTask(int Id, Task task) {
        String sql = "UPDATE tasks " +
                    "SET title = ?, note = ?, date_due = ?, task_status = ?" +
                    "WHERE task_id = ?;";
        int numberOfRow = jdbcTemplate.update(sql, task.getTitle(), task.getNote()
                , task.getDate(), task.getStatus(), Id);

        return numberOfRow == 1;
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
        task.setDate(res.getDate("date_due").toLocalDate());
        task.setStatus(res.getBoolean("task_status"));

        return task;
    }
}
