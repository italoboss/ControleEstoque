<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="head.jsp" %>
        <script src="js/confirm_delete_product.js"></script>
    </head>
    <body>
        <%@include file="validateSession.jsp" %>
        <%@include file="header.jsp" %>
        <div id="content">
            <div class="row">
                <div class="col-md-9"><h3>Lista dos Produtos</h3></div>
                <div class="col-md-3"><br/><a href="AdicionarProduto"><button class="btn btn-primary">Adicionar Produto</button></a></div>
            </div><br/>
            <table class="table table-striped table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Produto</th>
                        <th>Descrição</th>
                        <th>Preço</th>
                        <th colspan="2">Ações</th>
                    </tr>
		</thead>
		<tbody>
                    <c:forEach items="${produtos}" var="produto">
                        <tr>
                            <td><c:out value="${produto.nome}" /></td>
                            <td><c:out value="${produto.descricao}" /></td>
                            <td><c:out value="${produto.preco}" /></td>
                            <td class="td_action"><a href="EditarProduto?idProduto=<c:out value="${produto.id}" />" title="Editar"><span class="glyphicon glyphicon-edit"></span></a></td>
                            <td class="td_action"><a onclick="confirmDelete(<c:out value="${produto.id}" />)" href="#" title="Remover"><span class="glyphicon glyphicon-trash"></span></a></td>
                           <%-- <td><a href="ProdutoStudentController.do?action=edit&idProduto=<c:out value="${produto.id}"/>">Upd</a></td>
                            <td><a href="ProdutoController.do?action=delete&idProduto=<c:out value="${produto.id}"/>">Del</a></td> --%>
                        </tr>
                    </c:forEach>
		</tbody>
            </table>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
