<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head></head>
    <body>
        <%
            if (session != null && session.getAttribute("user") != null) {
        %>
                <jsp:forward page="principal.jsp" />
        <%
            } else {
        %>
                <jsp:forward page="login.jsp" />
        <%
            }
        %>
    </body>
</html>
