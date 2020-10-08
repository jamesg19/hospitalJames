/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

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
            String Check = request.getParameter("inlineRadioOptions");
            GestorBDPaciente pacienteDB = new GestorBDPaciente();
            String fechaC,horaC,especialidadC;
            Paciente paciente1;
            Consulta consulta;
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
             else if (btn.equals("Buscar doctor")) {
                    String cuentaI = (String) request.getParameter("user");
                    paciente1=new Paciente(cuentaI);
                    request.setAttribute("cuenta", paciente1.getCodigo());

                 request.getRequestDispatcher("/pagesPaciente/buscarMedico.jsp").forward(request, response);
             }
            
            else if (btn.equals("Inicio")) {
                String cuentaC=(String) request.getParameter("user");
                paciente1=new Paciente(cuentaC);
                request.setAttribute("cuenta", paciente1.getCodigo());

                 request.getRequestDispatcher("/pagesPaciente/inicioSistema.jsp").forward(request, response);
            }
                    
            else if (btn.equals("Cerrar sesion")) {
                cerrar();

                 request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
             
            else if (btn.equals("Busca doctor")) {
                String cuentaI = (String) request.getParameter("user");
                paciente1=new Paciente(cuentaI);
                request.setAttribute("cuenta", paciente1.getCodigo());
                
                if (Check.equals("nombre")) {
        
                    ArrayList<Doctor> doctores = new ArrayList<Doctor>();
                    Doctor doctor;
                    
                    GestorBDPaciente gestorBD = new GestorBDPaciente();
                    
                    String busqueda = request.getParameter("busqueda");
                    doctores = gestorBD.leeTodosDoctorNombre(busqueda);
                
                if ((doctores != null)) {
                    request.setAttribute("Doctor", doctores);
                    request.setAttribute("cuenta", cuentaI);

                    request.getRequestDispatcher("/pagesPaciente/buscarMedico.jsp").forward(request, response);
                    
                } else {
                    request.getRequestDispatcher("/noHayRegistros.jsp").forward(request, response);
                }    
                }
                
                
                if (Check.equals("especialidad")) {
                    
                    ArrayList<Doctor> doctores = new ArrayList<Doctor>();              
                    Doctor doctor;
                    GestorBDPaciente gestorBD = new GestorBDPaciente();

                    String busqueda = request.getParameter("busqueda");
                    doctores = gestorBD.leeTodosDoctorEspecialidad(busqueda);

                    if ((doctores != null)) {
                        request.setAttribute("Doctor", doctores);
                        request.getRequestDispatcher("/pagesPaciente/buscarMedico.jsp").forward(request, response);

                    } else {
                        request.getRequestDispatcher("/noHayRegistros.jsp").forward(request, response);
                    } 
                
                }
                
                
                
                
            }

            else if (btn.equals("Agendar una cita")) {
                
                 
                ArrayList<Especialidad> especialidades = new ArrayList<Especialidad>();
                Especialidad especialidad;
                GestorBDAdmin gestorBD = new GestorBDAdmin();
                especialidades = gestorBD.leeEspecialidad();
                
                if (especialidades != null) {
                    String paciente = (String) request.getParameter("user");
                    String nombres=(String) request.getAttribute("nombre");
                    
                    
                    request.setAttribute("cuenta", paciente);
                    request.setAttribute("nombre", nombres);
                    request.setAttribute("Especialidad", especialidades);
                    request.getRequestDispatcher("/pagesPaciente/llenaRegistroCita.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/noHayRegistros.jsp").forward(request, response);
                }
                
                
            }
             
            else if (btn.equals("Buscar cita")) {
                
                //especialidades en el combo 
                ArrayList<Especialidad> especialidades = new ArrayList<Especialidad>();
                //buscar doctor entre fecha laboral y especialidad
                ArrayList<Doctor> doctores = new ArrayList<Doctor>();
                Especialidad especialidad;
                
                String cuentaC=(String) request.getParameter("user");
                String nombre=(String) request.getAttribute("nombreI");
                fechaC=(String) request.getParameter("fecha");
                horaC=request.getParameter("hora");
                especialidadC=(String) request.getParameter("especialidad");
                paciente1=new Paciente(cuentaC,nombre);
                
                GestorBDAdmin gestorBD = new GestorBDAdmin();
                especialidades = gestorBD.leeEspecialidad();
                
                doctores=pacienteDB.leeDoctorEspFecha(especialidadC,horaC);
                
                
                GestorBDPaciente gestorBDs = new GestorBDPaciente();

                consulta = gestorBDs.consultarPrecioCita(especialidadC);
                
                
                
                if (especialidades != null) {
                    String paciente = (String) request.getParameter("user");
                    try{
                    request.setAttribute("cuenta", paciente1.getCodigo());
                    request.setAttribute("nombre", paciente1.getNombre());
                    request.setAttribute("fecha", fechaC);
                    request.setAttribute("hora", horaC);
                    request.setAttribute("costo", consulta.getCosto());
                    request.setAttribute("especialidad", especialidadC);
                    request.setAttribute("Especialidad", especialidades);
                    request.setAttribute("Doctor", doctores);
                    }catch(Exception e){}
                    
                    request.getRequestDispatcher("/pagesPaciente/llenaRegistroCita.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/noHayRegistros.jsp").forward(request, response);
                }

            }
             
             //agrega cita
             else if (btn.equals("Agregar mi cita")) {

                String medico = (String) request.getParameter("medico");
                String especialidad = (String) request.getParameter("especialidad");
                String paciente = (String) request.getParameter("paciente");
                String fecha = (String) request.getParameter("fecha");
                String hora = (String) request.getParameter("hora");
                
                GestorBDPaciente gestorBD = new GestorBDPaciente();
                Cita appoiment=new Cita(0,paciente,medico,especialidad,fecha,hora);
                
                if (gestorBD.registrarCita(appoiment.getPaciente(),appoiment.getMedico(),
                        appoiment.getEspecialidad(),appoiment.getFecha(),appoiment.getHora())) {
                    
                    out.print("Cita Programada con exito.");
                    out.print("Para mas detalles ve a la seccion de ''Ver mi citas'' ");
                } else {
                    out.print("No hay citas disponibles en la hora ingresada "+hora);
                }
                
                
            }
             
             else if (btn.equals("Ver mis citas")) {
                 
                String cuentaI = (String) request.getParameter("user");
                paciente1=new Paciente(cuentaI);
                request.setAttribute("cuenta", paciente1.getCodigo());
                
                ArrayList<Cita> citas = new ArrayList<Cita>();
                String user = (String) request.getParameter("user");
                
                Doctor doctor;
                GestorBDPaciente gestorBDPacient = new GestorBDPaciente();
                
                citas = gestorBDPacient.leeCita(user);

                if ((citas != null)) {
                    request.setAttribute("Cita", citas);
                    request.getRequestDispatcher("/pagesPaciente/VerMisCitas.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/pagesPaciente/VerMisCitas.jsp").forward(request, response);
                }     
                 
                 
             }
             
            /**
             * 
             */ 
            else if (btn.equals("Actualizar paciente")) {
                
                String codigo =(String) request.getParameter("codigo");
                String nombre = (String) request.getParameter("nombre");
                String sexo = (String) request.getParameter("sexo");
                String cumple= (String) request.getParameter("nacimiento");
                String dpi = (String) request.getParameter("dpi");
                String tel = (String) request.getParameter("telefono");
                String peso = (String) request.getParameter("peso");
                String sangre = (String) request.getParameter("sangre");
                String correo = (String) request.getParameter("correo");
                String password = (String) request.getParameter("password");
                double pesoo=Double.parseDouble(peso);

                GestorBDPaciente gestorBDPa = new GestorBDPaciente();
                
                
                if (gestorBDPa.modificarPACIENTE(codigo, nombre, sexo, cumple, dpi, tel, pesoo, sangre, correo, password)) {
                    request.getRequestDispatcher("/RegistroGuardado.jsp").forward(request, response);
                } else {

                    request.getRequestDispatcher("/errorGuardar.jsp").forward(request, response);
                }
            } 
            /**
             * JSP que modifica los datos del paciente
             */
             else if (btn.equals("Modificar mis datos")) {

                String USER = (String) request.getParameter("user");     
                request.setAttribute("codigo", USER);

                GestorBDPaciente gestorBD = new GestorBDPaciente();
                Paciente paciente;
                paciente = gestorBD.leePaciente(USER);
               

                request.setAttribute("Nombre", paciente.getNombre());
                request.setAttribute("Sexo", paciente.getSexo());
                request.setAttribute("Nacimiento", paciente.getCumple());
                request.setAttribute("Dpi", paciente.getDpi());
                request.setAttribute("Telefono", paciente.getTel());
                request.setAttribute("Peso", paciente.getPeso());
                request.setAttribute("Sangre", paciente.getSangre());
                request.setAttribute("Correo", paciente.getCorreo());
                request.setAttribute("Password", paciente.getPassword());
                

                request.getRequestDispatcher("/pagesPaciente/modificaPaciente.jsp").forward(request, response);
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
