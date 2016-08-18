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
            <form method="post" enctype="multipart/form-data" action="EditarProduto">
                <h3>Editar Produto</h3>
                <input type="hidden" name="idProduto" value="<c:out value="${produto.id}" />" />
                <input type="hidden" name="imagemProduto" value="<c:out value="${produto.imagem}" />" />
                
                <div class="form-group">
                    <img src="images/products/<c:out value="${produto.imagem}" />" alt="Imagem do Produto" class="img-thumbnail">
                    <input type="file"  name="datafile" id="imagemProduto" class="form-control" accept="image/*"  />
                </div>
                    
                <input type="hidden" name="idProduto" value="<c:out value="${produto.id}" />" />
                <div class="form-group">
                    <label for="nome">Nome: </label>
                    <input type="text" name="nomeProduto" id="nome" class="form-control" placeholder="Nome do Produto" value="<c:out value="${produto.nome}" />" required />
                </div>

                <div class="form-group">
                    <label for="preco">Preço: </label>
                    <div class="input-group"> 
                        <span class="input-group-addon">R$</span>
                        <input type="number" name="precoProduto" id="preco" class="form-control currency" placeholder="Preço do Produto" step="0.01" value="<c:out value="${produto.preco}" />" required />
                    </div>
                </div>	

                <div class="form-group">
                    <label for="descricao">Descrição: </label>
                    <textarea id="descricao" class="form-control" rows="6" cols="50" name="descricaoProduto" placeholder="Descreva aqui seu produto"><c:out value="${produto.descricao}" /></textarea>
                </div>
                <input type="submit" id="botao" value="Editar"  class="btn btn-primary" />	
            </form>
        </div>
        
        <%@include file="footer.jsp" %>
    </body>
</html>
