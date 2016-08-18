/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.EstoqueDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Estoque;

/**
 *
 * @author italo_000
 */
public class AtualizarEstoque extends HttpServlet {

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
        EstoqueDAO dao = new EstoqueDAO();
        int idEstoque = Integer.parseInt(request.getParameter("idEstoque"));
        if (request.getParameter("codProduto") != null && session != null) 
        {
            try {
                int user = Integer.parseInt(request.getParameter("codUsuario"));
                int idProduto = Integer.parseInt(request.getParameter("codProduto"));
                int quantidade = Integer.parseInt(request.getParameter("quantidade"));
                Estoque novo = new Estoque(idEstoque, user, idProduto, quantidade);
                novo.setId(idEstoque);
                dao.atualizarEstoque(novo);
                response.sendRedirect("ListarEstoque");
            } catch (SQLException ex) {
                Logger.getLogger(EditarProduto.class.getName()).log(Level.SEVERE, null, ex);
                getServletContext().getRequestDispatcher("/views/error.jsp").include(request, response);
            }
        }
        else {
            try {
                request.setAttribute("estoque", dao.estoquePorId(idEstoque));
                getServletContext().getRequestDispatcher("/views/atualizar_estoque.jsp").include(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(EditarProduto.class.getName()).log(Level.SEVERE, null, ex);
                getServletContext().getRequestDispatcher("/views/error.jsp").include(request, response);
            }
        }
    }
    
}
