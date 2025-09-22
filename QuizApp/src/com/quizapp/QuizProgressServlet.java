package com.quizapp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class QuizProgressServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Question> questions = (List<Question>) session.getAttribute("questions");
        Integer currentIndex = (Integer) session.getAttribute("currentIndex");
        Integer score = (Integer) session.getAttribute("score");

        String selectedAnswer = request.getParameter("answer");

        // Increment score if correct
        Question current = questions.get(currentIndex);
        if (current.getCorrectOption().equals(selectedAnswer)) {
            score++;
            session.setAttribute("score", score);
        }

        // Move to next question
        currentIndex++;
        session.setAttribute("currentIndex", currentIndex);

        if (currentIndex >= questions.size()) {
            response.sendRedirect("ResultServlet");
        } else {
            response.sendRedirect("question.jsp");
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
