package controllers;

import dao.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Usuario;

public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            Usuario user = new Usuario(request.getParameter("txtLogin"), request.getParameter("txtSenha"));
            UsuarioDAO dao = new UsuarioDAO();
            if (dao.validarUsuario(user)) {
                HttpSession session = request.getSession(true);
                session.setAttribute("user", user.getId());
                Cookie userName = new Cookie("username", user.getLogin().toUpperCase());
                response.addCookie(userName);
                response.sendRedirect("./");
            } else {
                request.setAttribute("error", "Login inválido. Tente novamente.");
                getServletContext().getRequestDispatcher("/views/login.jsp").include(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
            getServletContext().getRequestDispatcher("/views/error.jsp").include(request, response);
        }
    }

}
