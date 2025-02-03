package com.todo.servlet;

import com.todo.dao.TaskDAO;
import com.todo.model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/addTask")
public class AddTaskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskName = request.getParameter("task_name");
        String status = request.getParameter("status");

        // Create Task object
        Task task = new Task(0, taskName, status, null);
        
        // Add task to the database
        TaskDAO taskDAO = new TaskDAO();
        taskDAO.addTask(task);

        // Redirect to the task list
        response.sendRedirect("listTasks");
    }
}
