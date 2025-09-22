<%@ page session="true" %>
<%
    Integer score = (Integer) session.getAttribute("score");
    List<com.quizapp.Question> questions = (List<com.quizapp.Question>) session.getAttribute("questions");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Quiz Result</title>
</head>
<body>
    <h1>Your Score: <%= score %> / <%= questions.size() %></h1>
    <a href="index.jsp">Try Again</a>
</body>
</html>
