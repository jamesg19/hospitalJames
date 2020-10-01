/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;
import Objetos.*;
import javax.swing.JOptionPane;

@WebServlet(name = "login", urlPatterns = {"/login"})

public class login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String codigo = request.getParameter("codigo");
        String password = request.getParameter("password");

        try {
            Administrador admin;
            String Check = request.getParameter("inlineRadioOptions");
            //verifica si es administrador
            if (Check.equals("admin")) {

                GestorBDAdmin gestorBD = new GestorBDAdmin();

                admin = gestorBD.consultar(codigo, password);
                if (admin != null) {

                    request.setAttribute("nombre", admin.getNombre());
                    request.setAttribute("cuenta", admin.getCuenta());
                    request.setAttribute("dpi", admin.getDPI());
                    request.setAttribute("password", admin.getClave());
                    request.getRequestDispatcher("/pagesAdmin/inicioSistema.jsp").forward(request, response);

                } else {

                    request.getRequestDispatcher("/index.jsp").forward(request, response);
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
