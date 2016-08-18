/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.UsuarioDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Usuario;

/**
 *
 * @author italo_000
 */
public class AdicionarUsuario extends HttpServlet {

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
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        if (request.getParameter("login") != null && session != null) 
        {
            try {
                String senhaRepetida = request.getParameter("senhaRep");
                Usuario novo = new Usuario(request.getParameter("login"), request.getParameter("senha"));
                if (novo.getSenha().equals(senhaRepetida)) {
                    UsuarioDAO dao = new UsuarioDAO();
                    dao.adicionarUsuario(novo);
                    response.sendRedirect("ListarUsuarios");
                }
                else {
                    getServletContext().getRequestDispatcher("/views/error.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdicionarProduto.class.getName()).log(Level.SEVERE, null, ex);
                getServletContext().getRequestDispatcher("/views/error.jsp").include(request, response);
            }
        }
        else {
            getServletContext().getRequestDispatcher("/views/adicionar_usuario.jsp").include(request, response);
        }
    }

}
