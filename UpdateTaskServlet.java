package com.todo.servlet;

import com.todo.dao.TaskDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/updateTask")
public class UpdateTaskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("id"));
        String status = request.getParameter("status");

        // Update task status in the database
        TaskDAO taskDAO = new TaskDAO();
        taskDAO.updateTaskStatus(taskId, status);

        // Redirect to the task list
        response.sendRedirect("listTasks");
    }
}
