package com.taskit.backend.model;

import org.springframework.lang.NonNull;

import java.time.LocalDate;

public class Task {
    private int id;
    @NonNull
    private String title;
    @NonNull
    private String note;

    private LocalDate date = LocalDate.now();
    private Boolean status;


    public Task() {}

    public Task(int id, String title, String note, LocalDate date) {
        this.id = id;
        this.title = title;
        this.note = note;
        this.date = date;
        this.status = false;
    }

    public Task(int id, @NonNull String title, @NonNull String note, LocalDate date, Boolean status) {
        this.id = id;
        this.title = title;
        this.note = note;
        this.date = date;
        this.status = status;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
