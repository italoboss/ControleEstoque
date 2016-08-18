<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="head.jsp" %>
        <script src="js/confirm_delete_user.js"></script>
    </head>
    <body>
        <%@include file="validateSession.jsp" %>
        <%@include file="header.jsp" %>
        <div id="content">
            <div class="row">
                <div class="col-md-9"><h3>Lista dos Usuários</h3></div>
                <div class="col-md-3"><br/><a href="AdicionarUsuario"><button class="btn btn-primary">Adicionar Usuário</button></a></div>
            </div><br/>
            <table class="table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Usuario</th>
                        <th>Ações</th>
                    </tr>
		</thead>
		<tbody>
                    <c:forEach items="${usuarios}" var="usuario">
                        <tr>
                            <td><c:out value="${usuario.login}" /></td>
                            <td class="td_action"><a onclick="confirmDelete(<c:out value='${usuario.id}' />)" href="#" title="Remover"><span class="glyphicon glyphicon-trash"></span></a></td>
                        </tr>
                    </c:forEach>
		</tbody>
            </table>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
