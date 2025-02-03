package com.todo.model;

import java.sql.Timestamp;

public class Task {
    private int id;
    private String taskName;
    private String status;
    private Timestamp createdAt;

    // Constructor
    public Task(int id, String taskName, String status, Timestamp createdAt) {
        this.id = id;
        this.taskName = taskName;
        this.status = status;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}

