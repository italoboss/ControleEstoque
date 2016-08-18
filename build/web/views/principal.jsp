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
            <div id="dashboard">
                <a href="AdicionarProduto"><div id="op1" class="dash_item" >
                    <span class="glyphicon glyphicon-plus-sign"></span>
                    <p>Adicionar Produto</p>
                </div></a>
                <a href="ListarEstoque"><div id="op2" class="dash_item">
                    <span class="glyphicon glyphicon-refresh"></span>
                    <p>Atualizar Estoque</p>
                </div></a>
                <a href="EditarUsuario"><div id="op2" class="dash_item">
                    <span class="glyphicon glyphicon-wrench"></span>
                    <p>Minha Conta</p>
                </div></a>
                <a href="LogoutServlet"><div id="op3" class="dash_item">
                    <span class="glyphicon glyphicon-log-out"></span>
                    <p>Sair</p>
                </div></a>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>