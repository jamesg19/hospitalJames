/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Email.Email;
import Model.*;
import static Model.ConectaBD.cerrar;
import Objetos.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author james
 */
@WebServlet(name = "doctor", urlPatterns = {"/doctor"})
public class doctorServlet extends HttpServlet {

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
            String Check = request.getParameter("inlineRadioOptions");
            GestorBDPaciente pacienteDB = new GestorBDPaciente();
            String fechaC,horaC,especialidadC;                                                                                                                                      String estadoo="TRUE";
            Paciente paciente1;
            Consulta consulta;
            CitaMedico citaMedico;
            
            /**
             * ver citas programadas
             */
             if (btn.equals("Citas programadas")) {
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
                    request.getRequestDispatcher("/pagesDoctor/CitasProgramadas.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/errorCita.jsp").forward(request, response);
                }  
            }

            else if (btn.equals("Inicio")) {
                String cuentaC=(String) request.getParameter("user");
                paciente1=new Paciente(cuentaC);
                request.setAttribute("cuenta", paciente1.getCodigo());

                 request.getRequestDispatcher("/pagesDoctor/inicioSistema.jsp").forward(request, response);
            }
             
             
            else if (btn.equals("Atender paciente")) {
                java.time.LocalDate today = java.time.LocalDate.now();
                String paciente = (String) request.getParameter("paciente");
                request.setAttribute("paciente", paciente);
                
                citaMedico=new CitaMedico();
                int d;
                ArrayList<CitaMedico> citas = new ArrayList<CitaMedico>();
                String user = (String) request.getParameter("user");
                request.setAttribute("cuenta", user);
                Doctor doctor;
                Paciente pacient;
                GestorBDDoctor gestorBDDoctor = new GestorBDDoctor();
                GestorBDDoctor g=new GestorBDDoctor();
                
                pacient=g.consultarPacienteC(paciente);
                request.setAttribute("correoP", pacient.getCorreo());
                request.setAttribute("nombreP", pacient.getNombre());
                request.setAttribute("codigoP", pacient.getCodigo());
                request.setAttribute("estado", "falso");
                
                citas = gestorBDDoctor.leeCitaDoctor(user, today.toString());

                if ((citas != null)) {
                    request.setAttribute("Cita", citas);
                    request.getRequestDispatcher("/pagesDoctor/CitasProgramadas.jsp").forward(request, response);
                } 
            }
             
             
            else if (btn.equals("Realizar y Enviar Informe")) {
                
                java.time.LocalDate today = java.time.LocalDate.now();

                citaMedico=new CitaMedico();
                
                ArrayList<CitaMedico> citas = new ArrayList<CitaMedico>();
                String user = (String) request.getParameter("user");
                
                
                String pacientee = (String) request.getParameter("idpaciente");
                String doctor = (String) request.getParameter("doctor");
                String destino = (String) request.getParameter("correo");
                String informe = (String) request.getParameter("informe");
                String fecha = (String) request.getParameter("fecha");
                String hora = (String) request.getParameter("hora");
                request.setAttribute("cuenta", doctor);
                
                String paciente = " ";
                GestorBDDoctor ge = new GestorBDDoctor();
                GestorBDDoctor gestorBDDoctor = new GestorBDDoctor();
                
                //registra el informe
                ge.registrarInforme(paciente, pacientee, doctor, informe, fecha, hora);
                Email SendEmail = new Email();
                SendEmail.Email(destino, informe,"Informe del doctor ");
                
                
                
                citas = gestorBDDoctor.leeCitaDoctor(doctor, today.toString());

                if ((citas != null)) {
                    request.setAttribute("estado", estadoo);
                    request.setAttribute("Cita", citas);
                    request.setAttribute("paciente", paciente);
                    request.getRequestDispatcher("/pagesDoctor/CitasProgramadas.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/pagesDoctor/CitasProgramadas.jsp").forward(request, response);
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
