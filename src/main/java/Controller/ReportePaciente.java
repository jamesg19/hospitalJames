/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GestorBDPaciente;
import Model.GestorPacienteReporte;
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
@WebServlet(name = "ReportePaciente", urlPatterns = {"/ReportePaciente"})
public class ReportePaciente extends HttpServlet {

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
        Paciente paciente1;
        
        try (PrintWriter out = response.getWriter()) {

            String btn = request.getParameter("boton");
            
            if (btn.equals("Ultimas 5 citas")) {
                
 
                String cuentaI = (String) request.getParameter("user");
                paciente1=new Paciente(cuentaI);
                request.setAttribute("cuenta", paciente1.getCodigo());
                
                ArrayList<Cita> citas = new ArrayList<Cita>();
                String user = (String) request.getParameter("user");
                Doctor doctor;
                GestorPacienteReporte gestorBDPacient = new GestorPacienteReporte();
                
                citas = gestorBDPacient.leeCita(user);

                if ((citas != null)) {
                    request.setAttribute("Cita", citas);
                    request.getRequestDispatcher("/Reporte_Paciente/Ultimas5Consultas.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/pagesPaciente/VerMisCitas.jsp").forward(request, response);
                }     
                 
                 
             }
            
            else if (btn.equals("Consultas realizadas.")) {
                String cuentaC=(String) request.getParameter("user");
                paciente1=new Paciente(cuentaC);
                request.setAttribute("cuenta", paciente1.getCodigo());

                 request.getRequestDispatcher("/Reporte_Paciente/buscarConsultaTiempo.jsp").forward(request, response);
            }
            
            else if (btn.equals("Buscar.")) {
                String cuentaI = (String) request.getParameter("user");
                paciente1=new Paciente(cuentaI);
                request.setAttribute("cuenta", paciente1.getCodigo());
                
                String doc = (String) request.getParameter("busqueda");
                String fecha1 = (String) request.getParameter("fecha1");
                String fecha2 = (String) request.getParameter("fecha2");
                
                ArrayList<Cita> citas = new ArrayList<Cita>();
                String user = (String) request.getParameter("user");
                
                Doctor doctor;
                GestorPacienteReporte gestorBDPacient = new GestorPacienteReporte();
                
                citas = gestorBDPacient.leeCitaDocIntTiempo(doc, fecha1, fecha2);

                if ((citas != null)) {
                    request.setAttribute("Cita", citas);
                    request.setAttribute("cuenta", paciente1.getCodigo());
                    request.getRequestDispatcher("/Reporte_Paciente/buscarConsultaTiempo.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/Reporte_Paciente/buscarConsultaTiempo.jsp").forward(request, response);
                }
            }
            
            else if (btn.equals("Citas con intervalo de tiempo")) {
                String cuentaC=(String) request.getParameter("user");
                paciente1=new Paciente(cuentaC);
                request.setAttribute("cuenta", paciente1.getCodigo());

                 request.getRequestDispatcher("/Reporte_Paciente/buscarConsultaTiempo.jsp").forward(request, response);
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
