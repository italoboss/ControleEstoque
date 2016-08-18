package controllers;

import dao.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListarProdutos extends HttpServlet {

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
        if (session != null && session.getAttribute("user") != null) {
            try {
                int user = (int)session.getAttribute("user");
                ProdutoDAO dao = new ProdutoDAO();
                request.setAttribute("produtos", dao.listarProdutos(user));
                getServletContext().getRequestDispatcher("/views/listar_produtos.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(ListarProdutos.class.getName()).log(Level.SEVERE, null, ex);
                getServletContext().getRequestDispatcher("/views/error.jsp").include(request, response);
            }
        }
    }

}
