/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GestorBDDoctor;
import Model.GestorBDPaciente;
import Objetos.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author james
 */
@WebServlet(name = "ReporteDoctor", urlPatterns = {"/ReporteDoctor"})
public class ReporteDoctor extends HttpServlet {

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
            CitaMedico citaMedico;
            Paciente paciente1;

            
            String btn = request.getParameter("boton");
            if (btn.equals("Paciente con mas informes")) {
                String cuentaI = (String) request.getParameter("user");
                paciente1=new Paciente(cuentaI);
                request.setAttribute("cuenta", paciente1.getCodigo());
              request.getRequestDispatcher("/Reporte_Doctor/buscarPacienteConInforme.jsp").forward(request, response);  
            }
            
            else if (btn.equals("Buscar")) {
                 
                String cuentaI = (String) request.getParameter("user");
                paciente1=new Paciente(cuentaI);
                request.setAttribute("cuenta", paciente1.getCodigo());
                
                ArrayList<Informe> informes = new ArrayList<Informe>();
                String user = (String) request.getParameter("user");
                String fecha1 = (String) request.getParameter("fecha1");
                String fecha2 = (String) request.getParameter("fecha2");
                
                Doctor doctor;
                GestorBDDoctor gestorBDPacient = new GestorBDDoctor();
                
                informes = gestorBDPacient.leeInforme(fecha1, fecha2);

                if ((informes != null)) {
                    request.setAttribute("Informe", informes);
                    request.getRequestDispatcher("/Reporte_Doctor/buscarPacienteConInforme.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/Reporte_Doctor/buscarPacienteConInforme.jsp").forward(request, response);
                }     
                 
                 
             } 
            
            else if (btn.equals("Inicio")) {
                String cuentaC=(String) request.getParameter("user");
                paciente1=new Paciente(cuentaC);
                request.setAttribute("cuenta", paciente1.getCodigo());

                 request.getRequestDispatcher("/pagesDoctor/inicioSistema.jsp").forward(request, response);
            }
            
            if (btn.equals("Citas programadas para hoy")) {
                java.time.LocalDate today = java.time.LocalDate.now();

                citaMedico=new CitaMedico();
                
                ArrayList<CitaMedico> citas = new ArrayList<CitaMedico>();
                String user = (String) request.getParameter("user");
                request.setAttribute("cuenta", user);
                request.setAttribute("estado", "falso");

                String paciente = " ";
                
                Doctor doctor;
                GestorBDDoctor gestorBDDoctor = new GestorBDDoctor();
                
                citas = gestorBDDoctor.leeCitaDoctor(user, today.toString());

                if ((citas != null)) {
                    request.setAttribute("Cita", citas);
                    request.setAttribute("paciente", paciente);
                    request.getRequestDispatcher("/Reporte_Doctor/CitasProgramadas.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/Reporte_Doctor/CitasProgramadas.jsp").forward(request, response);
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
