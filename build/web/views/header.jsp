<header>
    <%
        String username = "";
        Cookie[] cookies = request.getCookies();
        if (cookies!=null) {
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("username")) username = cookie.getValue();
            }
        }
    %>
    <div id="logo">
        SCE
    </div>
    <div id="top_menu">
        <ul>
            <li><a href="./">Início</a></li>
            <li><a href="ListarProdutos">Produtos</a></li>
            <li><a href="ListarEstoque">Estoque</a></li>
            <% if (username.equals("ADMIN")) { %>
                <li><a href="ListarUsuarios">Usuários</a></li>
            <% } %>
        </ul>
    </div>
    <div id="user_bar">
        <span class="glyphicon glyphicon-user"></span>
        Bem-vindo, <%= username.toUpperCase() %>! <br/>
        <a href="LogoutServlet">Sair</a>
    </div>
</header>
