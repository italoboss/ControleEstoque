<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="head.jsp" %>
        <script src="js/validate_user.js"></script>
    </head>
    <body>
        <%@include file="validateSession.jsp" %>
        <%@include file="header.jsp" %>
        
        <div id="content">
            <form method="post" action="AdicionarUsuario">
                <h3>Adicionar Usuário</h3>
                <div class="form-group">
                    <label for="ulogin">Login: </label>
                    <input type="text" name="login" id="ulogin" class="form-control" placeholder="Usuário" required />
                </div>

                <div class="form-group">
                    <label for="usenha">Repetir Senha: </label>
                    <input type="password" name="senha" id="usenha" class="form-control" placeholder="Senha" required />
                </div>	

                <div class="form-group">
                    <label for="usenharep">Repetir Senha: </label>
                    <input type="password" name="senhaRep" id="usenharep" class="form-control" placeholder="Repetir senha" required />
                </div>	
                <p> <span id="error_label" class="label label-danger"></span> </p>
                <input type="submit" onclick="return validateUser()" id="botao" value="Cadastrar"  class="btn btn-primary" />	
            </form>
        </div>
        
        <%@include file="footer.jsp" %>
    </body>
</html>
