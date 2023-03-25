package model;

import java.time.LocalDateTime;

public class Task {

    private int id;
    private String title;
    private String note;
    private LocalDateTime dateTime;
    private Boolean status;

    public Task() {}

    public Task(int id, String title, String note, LocalDateTime dateTime, Boolean status) {
        this.id = id;
        this.title = title;
        this.note = note;
        this.dateTime = dateTime;
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
