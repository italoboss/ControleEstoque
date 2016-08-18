<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="head.jsp" %>
    </head>
    <body>
        <%@include file="validateSession.jsp" %>
        <%@include file="header.jsp" %>
        <div id="content">
            <div class="row">
                <h3>Estoque</h3>
            </div><br/>
            <table class="table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Produto</th>
                        <th>QTD</th>
                        <th>Ações</th>
                    </tr>
		</thead>
		<tbody>
                    <c:forEach items="${estoques}" var="estoque">
                        <tr>
                            <td><c:out value="${estoque.nomeProduto}" /></td>
                            <td><c:out value="${estoque.quantidade}" /></td>
                            <td class="td_action"><a href="AtualizarEstoque?idEstoque=<c:out value="${estoque.id}" />" title="Atualizar"><span class="glyphicon glyphicon-refresh"></span></a></td>
                        </tr>
                    </c:forEach>
		</tbody>
            </table>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
