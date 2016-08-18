<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <%@include file="head.jsp" %>
        <link rel="stylesheet" href="css/login.css" />
    </head>
    <body>
        <%  if (session != null && session.isNew() && session.getAttribute("user") != null) { %>
                <jsp:forward page="index.jsp" />
        <%  }  %>
        <div id="form_login" >
            <h3>Sistema de Controle de Estoque</h3>
            <%  if (request.getAttribute("error") != null) {%>
                <p> <span id="error_label" class="label label-danger"><%=request.getAttribute("error")%></span> </p>
            <%  }%>
            <form method="POST" action="LoginServlet" >
                <div class="form-group">
                    <label for="login">Login: </label>
                    <input type="text" name="txtLogin" id="login" class="form-control" />
                </div>
                
                <div class="form-group">
                    <label for="senha">Senha: </label>
                    <input type="password" name="txtSenha" id="senha" class="form-control" />
                </div>
                
                <input type="submit" value="Entrar" id="botao" class="btn btn-primary" />
            </form> <br/>
            <p><a href="cadastrar_usuario.jsp">Cadastrar-me</a></p>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>