package Controller;

import Model.Administrador;
import Model.GestorBDAdmin;
import java.awt.Button;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Objetos.*;
import java.sql.Blob;
import java.util.Base64;
import javax.sql.rowset.serial.SerialBlob;


@WebServlet(name = "crearAdmin", urlPatterns = {"/crearAdmin"})

public class adminServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String btn = request.getParameter("boton");

            if (btn.equals("Agregar Admin")) {

                request.getRequestDispatcher("/pagesAdmin/llenaRegistroAdmin.jsp").forward(request, response);
            } else if (btn.equals("Agregar Doctor")) {

                request.getRequestDispatcher("/pagesAdmin/llenaRegistroDoctor.jsp").forward(request, response);
            } else if (btn.equals("Agregar Examen")) {
                request.getRequestDispatcher("/pagesAdmin/llenaRegistroExamen.jsp").forward(request, response);
            } else if (btn.equals("Agregar Nuevo Laboratorista")) {

                request.getRequestDispatcher("/pagesLabo/llenaRegistroLabo.jsp").forward(request, response);
            } 
            /**
             *Modifica los datos del administrador
             */
            else if (btn.equals("Modificar mis datos")) {

                String USER = (String) request.getParameter("user").trim();
                request.setAttribute("cuenta", USER);

                GestorBDAdmin gestorBD = new GestorBDAdmin();
                Administrador admin;
                admin = gestorBD.AdminU(USER);
                request.setAttribute("Nombre", admin.getNombre().trim());
                request.setAttribute("Dpi", admin.getDPI().trim());
                request.setAttribute("Password", admin.getClave().trim());
                request.getRequestDispatcher("/pagesAdmin/modificaAdmin.jsp").forward(request, response);
            } 
            /**
             *Registra un nuevo Administrador a la base de datos
             */
            else if (btn.equals("Registrar Admin")) {

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
            
            /**
             * Crea una Consulta en la base de datos
             */
            else if (btn.equals("Crear Consulta")) {

                String tipo = request.getParameter("tipo");
                String costo = request.getParameter("costo");
                double costoC = Double.parseDouble(costo);
                
                if (tipo.length() >= 2) {
                    GestorBDAdmin gestorBD = new GestorBDAdmin();
                    if (gestorBD.registrarConsulta("", tipo, costoC)) {
                        request.getRequestDispatcher("/RegistroGuardado.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("/errorEnRegistro.jsp").forward(request, response);
                    }
                }

            }
            /**
             *Actualiza un aministrador en la BD y recibe los parametros correspondientes
             */
            if (btn.equals("Actualizar Admin")) {
                String nombreI = (String) request.getParameter("nombre");
                String codigo = (String) request.getParameter("codigo");
                String dpiI = (String) request.getParameter("dpi");
                String nameI = (String) request.getParameter("password");

                GestorBDAdmin gestorBD = new GestorBDAdmin();

                if (gestorBD.modificar(codigo, dpiI, nombreI, nameI)) {
                    request.getRequestDispatcher("/pagesAdmin/registroGuardado.jsp").forward(request, response);
                } else {

                    request.getRequestDispatcher("/pagesAdmin/errorEnRegistro.jsp").forward(request, response);
                }
            } 
            /**
             * Modifica un examen y recibe los 
             */
            else if (btn.equals("Modificar precio examen")) {

                String codigo = (String) request.getParameter("codigo");
                String costo = (String) request.getParameter("costo");
                double newcosto = Double.parseDouble(costo);

                GestorBDAdmin gestorBD = new GestorBDAdmin();
                if (gestorBD.ActualizarExamen(codigo, newcosto)) {
                    request.getRequestDispatcher("/RegistroGuardado.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/errorGuardar.jsp").forward(request, response);
                }
            }
            else if (btn.equals("Modifica precios")) {
                ArrayList<Examenes> examenes = new ArrayList<Examenes>();
                Examenes examen;
                GestorBDAdmin gestorBD = new GestorBDAdmin();
                examenes = gestorBD.leeTodosExamen();
                if (examenes != null) {
                    request.setAttribute("Examenes", examenes);
                    request.getRequestDispatcher("/Examen/listaExamen.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/noHayRegistros.jsp").forward(request, response);
                }
            }

            else if (btn.equals("Agregar Nueva Consulta.")) {
                ArrayList<Especialidad> especialidades = new ArrayList<Especialidad>();
                Especialidad especialidad;
                GestorBDAdmin gestorBD = new GestorBDAdmin();
                especialidades = gestorBD.leeEspecialidad();
                
                ArrayList<Consulta> consultas = new ArrayList<Consulta>();
                Consulta consulta;
                GestorBDAdmin gestorBD2 = new GestorBDAdmin();
                consultas = gestorBD2.leeConsulta();
                
                ArrayList<Consulta> consultas2 = new ArrayList<Consulta>();
                Consulta consulta2;
                GestorBDAdmin gestorBD3 = new GestorBDAdmin();
                consultas2 = gestorBD3.leeConsultaSA();
                
                if (especialidades != null) {
                    request.setAttribute("Especialidad", especialidades);
                    request.setAttribute("Consulta", consultas);
                    request.setAttribute("Consulta2", consultas2);
                    request.getRequestDispatcher("/Consulta/llenaRegistroConsulta.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/noHayRegistros.jsp").forward(request, response);
                }
            } 
 
            
            //redirige a la pagina para ver que doctor va a agregar la especialidad
            else if (btn.equals("Agrega Especialidad a Medico")) {
                ArrayList<Doctor> doctores = new ArrayList<Doctor>();
                ArrayList<Doctor> doctores2 = new ArrayList<Doctor>();
                Doctor doctor;
                GestorBDAdmin gestorBD = new GestorBDAdmin();
                GestorBDAdmin gestorBD2 = new GestorBDAdmin();
                doctores = gestorBD.leeTodosDoctor();
                doctores2 = gestorBD2.leeDoctor();
                if ((doctores != null)) {
                    request.setAttribute("Doctor", doctores);
                    request.setAttribute("Doctor2", doctores2);
                    request.getRequestDispatcher("/pagesDoctor/listaDoctor.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/noHayRegistros.jsp").forward(request, response);
                }
            } 
            //Agrega Nueva Especialidad y la guarda en la tabla
            else if (btn.equals("Agrega Nueva Especialidad")) {
                
                String codigo = (String) request.getParameter("codigo");
                String especialidad = (String) request.getParameter("especialidad");
                
               
                GestorBDAdmin gestorBD = new GestorBDAdmin();
                if (gestorBD.registrarEspecialidad(codigo, especialidad)) {
                    
                    request.getRequestDispatcher("/RegistroGuardado.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/errorGuardar.jsp").forward(request, response);
                }
            } 
            
            else if (btn.equals("Registrar Examen")) {

                String codigo = request.getParameter("codigo");
                String nombre = request.getParameter("nombre");
                String orden = request.getParameter("orden");
                String descripcion = request.getParameter("descripcion");
                String costo = request.getParameter("costo");
                double costoo = Double.parseDouble(costo);
                String tipoInforme = request.getParameter("tipoInforme");

                GestorBDAdmin gestorBD = new GestorBDAdmin();
                if (gestorBD.registrarExamen(codigo, nombre, orden, descripcion, costoo, tipoInforme)) {
                    request.getRequestDispatcher("/pagesAdmin/registroGuardadoExamen.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/pagesAdmin/errorEnRegistro.jsp").forward(request, response);
                }
            } 
            
            else if (btn.equals("Registrar Doctor")) {

                String codigo = request.getParameter("codigo");
                String nombre = request.getParameter("nombre");
                String colegiado = request.getParameter("colegiado");
                String dpi = request.getParameter("dpi");
                String telefono = request.getParameter("telefono");
                String correo = request.getParameter("correo");
                String horaInicio = request.getParameter("horaInicio");
                String horaFin = request.getParameter("horaFin");
                String trabajo = request.getParameter("trabajo");
                String password = request.getParameter("password");
                String esp1 = request.getParameter("especialidad");
                String esp2 = request.getParameter("especialidad2");
                String esp3 = request.getParameter("especialidad3");

                GestorBDAdmin gestorBD = new GestorBDAdmin();

                if (gestorBD.registrarDoctor(codigo, nombre, colegiado, dpi, telefono, correo, horaInicio, horaFin, trabajo, password)) {
                    
                    GestorBDAdmin gestorBD1 = new GestorBDAdmin();
                    gestorBD1.registrarEspecialidad(codigo, esp1);

                    if (esp2.length() >=2) {
                        GestorBDAdmin gestorBD2 = new GestorBDAdmin();
                        gestorBD2.registrarEspecialidad(codigo, esp2);
                    }
                    if (esp3.length() >=2) {
                        GestorBDAdmin gestorBD3 = new GestorBDAdmin();
                        gestorBD3.registrarEspecialidad(codigo, esp3);
                    }
                    request.getRequestDispatcher("/pagesAdmin/registroGuardadoDoctor.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/pagesAdmin/errorEnRegistro.jsp").forward(request, response);
                }
            } else if (btn.equals("Registrar Laboratorista")) {

                String codigo = request.getParameter("codigo");
                String nombre = request.getParameter("nombre");
                String registro = request.getParameter("registro");
                String dpi = request.getParameter("dpi");
                String telefono = request.getParameter("telefono");
                String examen = request.getParameter("examen");
                String correo = request.getParameter("correo");
                String diasT = request.getParameter("diasTrabajo");
                String trabajo = request.getParameter("trabajo");
                String password = request.getParameter("password");

                GestorBDAdmin gestorBD = new GestorBDAdmin();
                if (gestorBD.registrarLabo(codigo, nombre, registro, dpi, telefono, examen, correo, diasT, trabajo, password)) {
                    request.getRequestDispatcher("/RegistroGuardado.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("/errorGuardar.jsp").forward(request, response);
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
//Registrar Laboratorista