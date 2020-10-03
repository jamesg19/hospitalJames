/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author james
 */
@WebServlet(name = "paciente", urlPatterns = {"/paciente"})
public class pacienteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String btn = request.getParameter("boton");
            /**
             * Registra un nuevo paciente
             */
             if (btn.equals("Registrarme como paciente")) {

                String codigo = request.getParameter("codigo");
                String nombre = request.getParameter("nombre");
                String sexo = request.getParameter("sexo");
                String cumple = request.getParameter("cumple");
                String dpi = request.getParameter("dpi");
                String telefono = request.getParameter("telefono");
                String peso = request.getParameter("peso");
                double pesoo= Double.parseDouble(peso);
                String sangre = request.getParameter("sangre");
                String correo = request.getParameter("correo");
                String password = request.getParameter("password");

                GestorBDPaciente gestorBD = new GestorBDPaciente();
                if (gestorBD.registrarPaciente(codigo, nombre, sexo, cumple,dpi,
                        telefono,pesoo,sangre,correo,password)) {
                    request.getRequestDispatcher("RegistroGuardado.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/errorGuardar.jsp").forward(request, response);
                }
            }
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
