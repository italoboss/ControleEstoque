package controllers;

import dao.ProdutoDAO;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Produto;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class AdicionarProduto extends HttpServlet {

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
                System.out.println("Chegando no Servlet...");
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        if (ServletFileUpload.isMultipartContent(request) && session != null) 
        {
            try {
                Produto novo = new Produto();
                int qtd = 0;
                DiskFileItemFactory factory = new DiskFileItemFactory();
                String root = getServletContext().getRealPath("/");
                File repository = new File(root + "/images/products/temp");
                factory.setRepository(repository);
                ServletFileUpload upload = new ServletFileUpload(factory);
                List<FileItem> fileItems = upload.parseRequest(request);
                Iterator i = fileItems.iterator();
                String fileName = null;
                while (i.hasNext()) {
                    FileItem fi = (FileItem) i.next();
                    if (fi.isFormField()) 
                    {
                        String name = fi.getFieldName();
                        String value = fi.getString();
                        switch (name) {
                            case "nomeProduto":
                                novo.setNome(value);
                                break;
                            case "descricaoProduto":
                                novo.setDescricao(value);
                                break;
                            case "precoProduto":
                                novo.setPreco(Double.parseDouble(value));
                                break;
                            case "qtdProduto":
                                qtd = Integer.parseInt(value);
                                break;
                            default:
                                break;
                        }
                    }
                    else {
                        fileName = fi.getName();
                        if (fileName != null && !"".equals(fileName)) {
                            File aux = new File(root + "images/products/" + fileName);
                            fi.write(aux);
                            novo.setImagem(fileName);
                            System.out.println("File uploaded. => " + aux.getPath());
                        }
                    }
                }
                ProdutoDAO dao = new ProdutoDAO();
                int user = (int)session.getAttribute("user");
                dao.adicionarProduto(novo, user, qtd);
                response.sendRedirect("ListarProdutos");
            } catch (SQLException ex) {
                Logger.getLogger(AdicionarProduto.class.getName()).log(Level.SEVERE, null, ex);
                getServletContext().getRequestDispatcher("/views/error.jsp").include(request, response);
            } catch (Exception ex) {
                Logger.getLogger(AdicionarProduto.class.getName()).log(Level.SEVERE, null, ex);
                getServletContext().getRequestDispatcher("/views/error.jsp").include(request, response);
            }
        }
        else {
            getServletContext().getRequestDispatcher("/views/adicionar_produto.jsp").include(request, response);
        }
    }

}
