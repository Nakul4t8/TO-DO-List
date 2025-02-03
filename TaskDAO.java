package com.todo.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.todo.model.Task;

public class TaskDAO {
    // Create task
    public void addTask(Task task) {
        String query = "INSERT INTO tasks (task_name, status) VALUES (?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, task.getTaskName());
            pst.setString(2, task.getStatus());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all tasks
    public List<Task> getAllTasks() {
        List<Task> taskList = new ArrayList<>();
        String query = "SELECT * FROM tasks";
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Task task = new Task(
                    rs.getInt("id"),
                    rs.getString("task_name"),
                    rs.getString("status"),
                    rs.getTimestamp("created_at")
                );
                taskList.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return taskList;
    }

    // Update task status
    public void updateTaskStatus(int id, String status) {
        String query = "UPDATE tasks SET status = ? WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, status);
            pst.setInt(2, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete task
    public void deleteTask(int id) {
        String query = "DELETE FROM tasks WHERE id = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

