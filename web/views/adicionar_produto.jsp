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
            <form action="AdicionarProduto" enctype="multipart/form-data" method="post" >
                <h3>Adicionar Produto</h3>
                
                <div class="form-group">
                    <label for="imagemProduto">Imagem: </label>
                    <input type="file" name="datafile" id="imagemProduto" class="form-control" accept="image/*" />
                </div>
                
                <div class="form-group">
                    <label for="nome">Nome: </label>
                    <input type="text" name="nomeProduto" id="nome" class="form-control" placeholder="Nome do Produto" required />
                </div>

                <div class="form-group">
                    <label for="preco">Preço: </label>
                    <div class="input-group"> 
                        <span class="input-group-addon">R$</span>
                        <input type="number" name="precoProduto" id="preco" class="form-control currency" placeholder="Preço do Produto" step="0.01" required />
                    </div>
                </div>	

                <div class="form-group">
                    <label for="qtd">Quantidade: </label>
                    <input type="number" name="qtdProduto" id="qtd" class="form-control" placeholder="Quantidade inicial" required />
                </div>	

                <div class="form-group">
                    <label for="descricao">Descrição: </label>
                    <textarea id="descricao" class="form-control" rows="4" cols="50" name="descricaoProduto" placeholder="Descreva aqui seu produto"></textarea>
                </div>
                
                <input type="submit" id="botao" value="Cadastrar"  class="btn btn-primary" />	
            </form>
        </div>
        
        <%@include file="footer.jsp" %>
    </body>
</html>
