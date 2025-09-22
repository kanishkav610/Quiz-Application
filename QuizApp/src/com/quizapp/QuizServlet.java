package com.quizapp;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuizServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        List<Question> questionList = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM questions");
            while (rs.next()) {
                Question q = new Question(
                        rs.getInt("id"),
                        rs.getString("question_text"),
                        rs.getString("option1"),
                        rs.getString("option2"),
                        rs.getString("option3"),
                        rs.getString("option4"),
                        rs.getString("correct_option") // make sure column name is correct
                );
                questionList.add(q);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // DEBUG: Check if questions are loaded
        System.out.println("Number of questions loaded: " + questionList.size());

        request.getSession().setAttribute("questions", questionList);
        request.getSession().setAttribute("currentIndex", 0);
        request.getSession().setAttribute("score", 0);

        response.sendRedirect("question.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.sendRedirect("index.jsp"); // optional safety
    }
   
}
