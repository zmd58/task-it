package com.taskit.backend.model;

import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

public class Task {
    private int id;
    @NonNull
    private String title;
    @NonNull
    private String note;
    private LocalDateTime dateTime = LocalDateTime.now();
    private Boolean status;


    public Task() {}

    public Task(int id, String title, String note, LocalDateTime dateTime) {
        this.id = id;
        this.title = title;
        this.note = note;
        this.dateTime = dateTime;
        this.status = false;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
