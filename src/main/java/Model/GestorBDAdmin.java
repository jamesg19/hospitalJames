package Model;

import static Model.ConectaBD.passw;
import Objetos.Doctor;
import Objetos.Examenes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Gestor de base de datos del administrador que maneja todas las acciones o
 * consultas del mismo
 *
 * @author james
 */
public class GestorBDAdmin {

    String claveUsuario;
    Connection conn = null;
    Statement stm = null;
    ResultSet usuarioResultSet;
    Administrador usuarioHallado;
    Examenes examenHallado;
    Doctor doctorHallado;
    String codigoo, dpi, nombre, passwordd;
    String codigoE, nombreE, ordenE, descripcionE, formatoPDFE;
    String codigoD, nombreD, colegiadoD, correoD, horaInicioD, horaFinD, trabajoD, especialidadD, telefonoD, passD;

    double costoE;

    /**
     * registra un nuevo administrador al sistema
     *
     * @param codigo
     * @param dpi
     * @param nombre
     * @param password
     * @return
     */
    public boolean registrar(String codigo, String dpi, String nombre, String password) {
        int resultUpdate = 0;

        conn = ConectaBD.abrir();

        String query = "INSERT INTO administrador VALUES (?,?,?,?)";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, codigo);
            preSt.setString(2, dpi);
            preSt.setString(3, nombre);
            preSt.setString(4, password);

            resultUpdate = preSt.executeUpdate();

            if (resultUpdate != 0) {
                ConectaBD.cerrar();
                return true;
            } else {
                ConectaBD.cerrar();
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * registra un nuevo doctor
     *
     * @param codigo
     * @param nombre
     * @param colegiado
     * @param dpi
     * @param telefono
     * @param correo
     * @param horaInicio
     * @param horaFin
     * @param trabajo
     * @param password
     * @return
     */
    public boolean registrarDoctor(String codigo, String nombre, String colegiado, String dpi,
            String telefono, String correo, String horaInicio, String horaFin, String trabajo, String password) {
        int resultUpdate = 0;

        conn = ConectaBD.abrir();

        String query = "INSERT INTO doctor VALUES (?,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, codigo);
            preSt.setString(2, nombre);
            preSt.setString(3, colegiado);
            preSt.setString(4, dpi);
            preSt.setString(5, telefono);
            preSt.setString(6, correo);
            preSt.setString(7, horaInicio);
            preSt.setString(8, horaFin);
            preSt.setString(9, trabajo);
            preSt.setString(10, password);

            resultUpdate = preSt.executeUpdate();

            if (resultUpdate != 0) {
                ConectaBD.cerrar();
                return true;
            } else {
                ConectaBD.cerrar();
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * registra examenes nuevos al sistema
     *
     * @param codigo
     * @param nombre
     * @param orden
     * @param descripcion
     * @param costo
     * @param tipoInforme
     * @return
     */
    public boolean registrarExamen(String codigo, String nombre, String orden, String descripcion, Double costo, String tipoInforme) {
        int resultUpdate = 0;

        conn = ConectaBD.abrir();

        String query = "INSERT INTO examen VALUES (?,?,?,?,?,?)";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, codigo);
            preSt.setString(2, nombre);
            preSt.setString(3, orden);
            preSt.setString(4, descripcion);
            preSt.setDouble(5, costo);
            preSt.setString(6, tipoInforme);

            resultUpdate = preSt.executeUpdate();

            if (resultUpdate != 0) {
                ConectaBD.cerrar();
                return true;
            } else {
                ConectaBD.cerrar();
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * registra una nueva especialidad de un doctor
     *
     * @param codigo
     * @param especialidad
     * @return
     */
    public boolean registrarEspecialidad(String codigo, String especialidad) {
        int resultUpdate = 0;

        conn = ConectaBD.abrir();

        String query = "INSERT INTO especialidad VALUES (?,?,?)";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            int c = 0;
            preSt.setInt(1, c);
            preSt.setString(2, codigo);
            preSt.setString(3, especialidad);

            resultUpdate = preSt.executeUpdate();

            if (resultUpdate != 0) {
                ConectaBD.cerrar();
                return true;
            } else {
                ConectaBD.cerrar();
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Actualiza el precio del examen
     *
     * @param codigo
     * @param costo
     * @return
     */
    public boolean ActualizarExamen(String codigo, double costo) {
        int resultUpdate = 0;

        conn = ConectaBD.abrir();

        String query = "UPDATE examen  SET costo = ? WHERE codigo = ?";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setDouble(1, costo);
            preSt.setString(2, codigo);

            resultUpdate = preSt.executeUpdate();

            if (resultUpdate != 0) {
                ConectaBD.cerrar();
                return true;
            } else {
                ConectaBD.cerrar();
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * modifica el administrador
     *
     * @param codigo
     * @param dpi
     * @param nombre
     * @param password
     * @return
     */
    public boolean modificar(String codigo, String dpi, String nombre, String password) {
        int resultUpdate = 0;

        conn = ConectaBD.abrir();

        String query = "UPDATE administrador  SET dpi = ?, nombre = ?, password = ? WHERE codigo = ?";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, dpi);
            preSt.setString(2, nombre);
            preSt.setString(3, password);
            preSt.setString(4, codigo);

            resultUpdate = preSt.executeUpdate();

            if (resultUpdate != 0) {
                ConectaBD.cerrar();
                return true;
            } else {
                ConectaBD.cerrar();
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * consulta para inicial sesion de un administrador
     *
     * @param codigo
     * @param password
     * @return
     */
    public Administrador consultar(String codigo, String password) {
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT * FROM administrador WHERE codigo='" + codigo + "' AND password='" + password + "';");

            if (!usuarioResultSet.next()) {
                System.out.println(" No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                System.out.println("Se encontró el registro");
                codigoo = usuarioResultSet.getString("codigo");
                dpi = usuarioResultSet.getString("dpi");
                nombre = usuarioResultSet.getString("nombre");
                passwordd = usuarioResultSet.getString("password");
                usuarioHallado = new Administrador(codigoo, dpi, nombre, passwordd);
                ConectaBD.cerrar();
                return usuarioHallado;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * visualizar datos de un aministrador en especifico
     *
     * @param codigo
     * @return
     */
    public Administrador AdminU(String codigo) {
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT * FROM administrador WHERE codigo='" + codigo + "';");

            if (!usuarioResultSet.next()) {
                System.out.println(" No se encontro el registro");
                ConectaBD.cerrar();
                return null;
            } else {
                System.out.println("Se encontró el registro");
                codigoo = usuarioResultSet.getString("codigo");
                dpi = usuarioResultSet.getString("dpi");
                nombre = usuarioResultSet.getString("nombre");
                passwordd = usuarioResultSet.getString("password");
                usuarioHallado = new Administrador(codigoo, dpi, nombre, passwordd);
                ConectaBD.cerrar();
                return usuarioHallado;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * borrar un usuario
     *
     * @param cuenta
     * @param clave
     * @return
     */
    public boolean borrar(String cuenta, String clave) {
        int resultUpdate = 0;
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();

            resultUpdate = stm.executeUpdate("DELETE FROM usuarios WHERE(cuenta='" + cuenta + "'and clave='" + clave + "');");

            if (resultUpdate != 0) {
                ConectaBD.cerrar();
                return true;
            } else {
                ConectaBD.cerrar();
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Array List para leer todos los examenes
     *
     * @return
     */
    public ArrayList<Examenes> leeTodosExamen() {
        ArrayList<Examenes> examenes = new ArrayList<Examenes>();
        try {
            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT * FROM examen");
            if (!usuarioResultSet.next()) {
                System.out.println(" No se encontraron registros");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    codigoE = usuarioResultSet.getString("codigo");
                    nombreE = usuarioResultSet.getString("nombre");
                    ordenE = usuarioResultSet.getString("orden");
                    descripcionE = usuarioResultSet.getString("Descripcion");
                    costoE = usuarioResultSet.getDouble("costo");
                    formatoPDFE = usuarioResultSet.getString("tipo_informe");

                    examenHallado = new Examenes(codigoE, nombreE, ordenE, descripcionE, costoE, formatoPDFE);
                    examenes.add(examenHallado);
                } while (usuarioResultSet.next());
                ConectaBD.cerrar();
                return examenes;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Array List para leer todos los doctores con especialidad
     *
     * @return
     */
    public ArrayList<Doctor> leeTodosDoctor() {
        ArrayList<Doctor> doctores = new ArrayList<Doctor>();
        try {

            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT distinctrow d.codigo, d.nombre,d.colegiado,d.correo,d.hora_inicio,hora_fin, d.trabajo,e.tipo_Especialidad FROM doctor d INNER JOIN especialidad e ON d.codigo = e.id_doctor");
            if (!usuarioResultSet.next()) {

                System.out.println(" No se encontraron registros");
                ConectaBD.cerrar();
                return doctores;
            } else {
                do {
                    codigoD = usuarioResultSet.getString("codigo");
                    nombreD = usuarioResultSet.getString("nombre");
                    colegiadoD = usuarioResultSet.getString("colegiado");
                    correoD = usuarioResultSet.getString("correo");
                    horaInicioD = usuarioResultSet.getString("hora_inicio");
                    horaFinD = usuarioResultSet.getString("hora_fin");
                    trabajoD = usuarioResultSet.getString("trabajo");
                    especialidadD = usuarioResultSet.getString("tipo_Especialidad");

                    doctorHallado = new Doctor(codigoD, nombreD, colegiadoD, correoD, horaInicioD, horaFinD, trabajoD, especialidadD);
                    doctores.add(doctorHallado);
                } while (usuarioResultSet.next());
                ConectaBD.cerrar();
                return doctores;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     */
    public ArrayList<Doctor> leeDoctor() {
        ArrayList<Doctor> doctores = new ArrayList<Doctor>();
        try {

            conn = ConectaBD.abrir();
            stm = conn.createStatement();
            usuarioResultSet = stm.executeQuery("SELECT * FROM doctor");
            if (!usuarioResultSet.next()) {

                System.out.println(" No se encontraron registros");
                ConectaBD.cerrar();
                return null;
            } else {
                do {
                    codigoD = usuarioResultSet.getString("codigo");
                    nombreD = usuarioResultSet.getString("nombre");
                    colegiadoD = usuarioResultSet.getString("colegiado");
                    correoD = usuarioResultSet.getString("correo");
                    horaInicioD = usuarioResultSet.getString("hora_inicio");
                    horaFinD = usuarioResultSet.getString("hora_fin");
                    trabajoD = usuarioResultSet.getString("trabajo");

                    doctorHallado = new Doctor(codigoD, nombreD, colegiadoD, correoD, horaInicioD, horaFinD, trabajoD, "");
                    doctores.add(doctorHallado);
                } while (usuarioResultSet.next());
                ConectaBD.cerrar();
                return doctores;
            }
        } catch (Exception e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return null;
        }
    }

    public boolean registrarLabo(String codigo, String nombre, String registro, String dpi, String telefono, String examen, String correo, String diasT, String trabajo, String password) {
        int resultUpdate = 0;

        conn = ConectaBD.abrir();

        String query = "INSERT INTO laboratorista VALUES (?,?,?,?,?,?,?,?,?,?)";

        try (PreparedStatement preSt = conn.prepareStatement(query)) {

            preSt.setString(1, codigo);
            preSt.setString(2, nombre);
            preSt.setString(3, registro);
            preSt.setString(4, dpi);
            preSt.setString(5, telefono);
            preSt.setString(6, examen);
            preSt.setString(7, correo);
            preSt.setString(8, diasT);
            preSt.setString(9, trabajo);
            preSt.setString(10, password);

            resultUpdate = preSt.executeUpdate();

            if (resultUpdate != 0) {
                ConectaBD.cerrar();
                return true;
            } else {
                ConectaBD.cerrar();
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error en la base de datos.");
            e.printStackTrace();
            return false;
        }
    }

}
