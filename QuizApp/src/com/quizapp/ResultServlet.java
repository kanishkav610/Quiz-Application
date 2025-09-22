package com.quizapp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class ResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer score = (Integer) session.getAttribute("score");
        if (score == null) score = 0;

        response.setContentType("text/html");
        response.getWriter().println("<h1>Quiz Finished!</h1>");
        response.getWriter().println("<p>Your score: " + score + "</p>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

