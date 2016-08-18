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
            <form method="post" action="AtualizarEstoque">
                <h3>Atualizar Estoque</h3>
                <input type="hidden" name="idEstoque" value="<c:out value="${estoque.id}" />" />
                <input type="hidden" name="codUsuario" value="<c:out value="${estoque.codUsuario}" />" />
                <input type="hidden" name="codProduto" value="<c:out value="${estoque.codProduto}" />" />
                <div class="form-group">
                    <label for="nome">Produto: </label>
                    <input type="text" name="nomeProduto" id="nome" class="form-control" placeholder="Nome do Produto" value="<c:out value="${estoque.nomeProduto}" />" disabled/>
                </div>

                <div class="form-group">
                    <label for="quantidade">Quantidade: </label>
                    <div class="input-group">
                        <input type="number" name="quantidade" id="quantidade" class="form-control currency" placeholder="Preço do Produto" step="1" value="<c:out value="${estoque.quantidade}" />" />
                    </div>
                </div>
                <input type="submit" id="botao" value="Atualizar"  class="btn btn-primary" />	
            </form>
        </div>
        
        <%@include file="footer.jsp" %>
    </body>
</html>
