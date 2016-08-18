<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="head.jsp" %>
    </head>
    <body>
        <%@include file="validateSession.jsp" %>
        <%@include file="header.jsp" %>
        <div id="content">
            <div id="error_panel">
                <img src="images/redwarning.png" />
                <h4>Ocorreu um erro durante o processo. Verifique com o administrador.</h4>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
