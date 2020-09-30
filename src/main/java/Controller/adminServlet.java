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
            } 
            
            
            else if (btn.equals("Agregar Doctor")) {
                
            request.getRequestDispatcher("/pagesAdmin/llenaRegistroDoctor.jsp").forward(request, response);  
            }
            
            
            else if (btn.equals("Agregar Examen")) {    
            request.getRequestDispatcher("/pagesAdmin/llenaRegistroExamen.jsp").forward(request, response);
            }
            
            
            else if (btn.equals("Modificar mis datos")) {  
                
            String USER = (String) request.getParameter("user").trim();
            request.setAttribute("cuenta",USER);
            
            GestorBDAdmin gestorBD = new GestorBDAdmin();
            Administrador admin;      
            admin=gestorBD.AdminU(USER);      
            request.setAttribute("Nombre",admin.getNombre().trim());
            request.setAttribute("Dpi",admin.getDPI().trim());
            request.setAttribute("Password",admin.getClave().trim());        
            request.getRequestDispatcher("/pagesAdmin/modificaAdmin.jsp").forward(request, response);
            }

            


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
            else if (btn.equals("Modificar precio examen")) {  
                
            String codigo = (String) request.getParameter("codigo");
            String costo = (String) request.getParameter("costo");
            double newcosto= Double.parseDouble(costo);
            
            GestorBDAdmin gestorBD = new GestorBDAdmin();
            if (gestorBD.ActualizarExamen(codigo, newcosto)) {
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
            String costo =  request.getParameter("costo");
            double costoo= Double.parseDouble(costo);
            String tipoInforme =  request.getParameter("tipoInforme");
            
            GestorBDAdmin gestorBD = new GestorBDAdmin();
            if (gestorBD.registrarExamen(codigo, nombre, orden, descripcion,costoo,tipoInforme)) {
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
            String telefono =  request.getParameter("telefono");
            String correo = request.getParameter("correo");
            String horaInicio =  request.getParameter("horaInicio");
            String horaFin =  request.getParameter("horaFin");
            String trabajo =  request.getParameter("trabajo");
            String password =  request.getParameter("password");
            
            GestorBDAdmin gestorBD = new GestorBDAdmin();
            if (gestorBD.registrarDoctor(codigo, nombre, colegiado, dpi,telefono,correo,horaInicio,horaFin,trabajo,password)) {
                request.getRequestDispatcher("/pagesAdmin/registroGuardadoDoctor.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/pagesAdmin/errorEnRegistro.jsp").forward(request, response);
            }
            }
            
            if(btn.equals("Modifica precios")){
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
