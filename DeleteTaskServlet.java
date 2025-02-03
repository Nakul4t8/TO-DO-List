package com.todo.servlet;

import com.todo.dao.TaskDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/deleteTask")
public class DeleteTaskServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("id"));

        // Delete task from the database
        TaskDAO taskDAO = new TaskDAO();
        taskDAO.deleteTask(taskId);

        // Redirect to the task list
        response.sendRedirect("listTasks");
    }
}
