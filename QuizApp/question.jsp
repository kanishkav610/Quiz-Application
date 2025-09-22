<%@ page import="java.util.List" %>
<%@ page import="com.quizapp.Question" %>
<%
    List<Question> questions = (List<Question>) session.getAttribute("questions");
    Integer index = (Integer) session.getAttribute("currentIndex");

    if (questions == null || index == null || index >= questions.size()) {
        response.sendRedirect("ResultServlet");
        return;
    }

    Question q = questions.get(index);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Quiz Question</title>
</head>
<body>
    <h1>Question <%= index + 1 %>:</h1>
    <p><%= q.getQuestionText() %></p>
    <form action="QuizProgressServlet" method="post">
        <input type="radio" name="answer" value="<%= q.getOption1() %>"> <%= q.getOption1() %><br>
        <input type="radio" name="answer" value="<%= q.getOption2() %>"> <%= q.getOption2() %><br>
        <input type="radio" name="answer" value="<%= q.getOption3() %>"> <%= q.getOption3() %><br>
        <input type="radio" name="answer" value="<%= q.getOption4() %>"> <%= q.getOption4() %><br>
        <button type="submit">Next</button>
    </form>
</body>
</html>
