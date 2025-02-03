package com.todo.servlet;

import com.todo.dao.TaskDAO;
import com.todo.model.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/listTasks")
public class ListTasksServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TaskDAO taskDAO = new TaskDAO();
        List<Task> tasks = taskDAO.getAllTasks();

        // Set response type as JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Convert the task list into JSON format
        String jsonResponse = "{ \"tasks\": [";
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            jsonResponse += String.format("{\"id\":%d, \"task_name\":\"%s\", \"status\":\"%s\"}",
                    task.getId(), task.getTaskName(), task.getStatus());
            if (i < tasks.size() - 1) {
                jsonResponse += ",";
            }
        }
        jsonResponse += "]}";

        // Send the JSON response to the client
        response.getWriter().write(jsonResponse);
    }
}
