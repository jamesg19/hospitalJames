package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;

@WebServlet(name = "AdminSistem", urlPatterns = {"/AdminSistem"})
public class registroAdmin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {
            String btn = request.getParameter("boton");
            if (btn.equals("Agregar Admin")) {
            String codigo = request.getParameter("codigo");
            String dpi = request.getParameter("dpi");
            String nombre = request.getParameter("nombre");
            String password = request.getParameter("password");
            
            GestorBDAdmin gestorBD = new GestorBDAdmin();

            if (gestorBD.registrar(codigo, dpi, nombre, password)) {
                request.getRequestDispatcher("/pagesAdmin/registroGuardado.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/pagesAdmin/errorEnRegistro.jsp").forward(request, response);
            }
            }
        } finally {
            out.close();
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
