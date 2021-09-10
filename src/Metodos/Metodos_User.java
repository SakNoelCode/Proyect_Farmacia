package Metodos;

import Conexion.ConexionBD;
import static Metodos.Metodos_sql.resultado;
import static Metodos.Metodos_sql.sentencia_preparada;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Metodos_User {

    public static ConexionBD conexion = new ConexionBD();
    public static PreparedStatement GP;

    //MOSTRAR DATOS DE LA TABLA PRODUCTO DE LA BASE DE DATOS
    //--------------------------------------------------------------------------
    private DefaultTableModel DT;
    private ResultSet RS;
    private static PreparedStatement PS;
    Connection CN = null;

    private DefaultTableModel setTitulos() {
        DT = new DefaultTableModel();
        DT.addColumn("ID");
        DT.addColumn("Nombres");
        DT.addColumn("Apellidos");
        DT.addColumn("Dni");
        DT.addColumn("Email");
        DT.addColumn("Usuario");
        DT.addColumn("Contraseña");
        DT.addColumn("Tipo Usuario");
        DT.addColumn("Estado");
        return DT;
    }
    //----------------------------------------------------------------------------

    //ACTUALIZAR DATOS DE LAS TABLAS DE LA BASE DE DATOS
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public int ActualizarUsuarios( String idUsuario,  String Nombres, String Apellidos,String Dni, String Email, String Usuario, String Contraseña, String TipoUsuario, String Estado) {
        String SQL = "UPDATE usuario SET Nombres = '" + Nombres + "', Apellidos = '" + Apellidos + "', Dni = '" + Dni + "', Email = '" + Email + "', Usuario = '" + Usuario + "', Contraseña = '" + Contraseña + "', TipoUsuario = '" + TipoUsuario + "', Estado = '" + Estado +"' WHERE idUsuario = " + idUsuario;
        int resultado = 0;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            GP = conexion.prepareStatement(SQL);
            resultado = GP.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro Modificado con éxito");
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);

        }
        return resultado;
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    //ELIMINAR REGISTROS
    //????????????????????????????????????????????????????????????????????????????????
    public int EliminarUsuario(String Delete) {
        String SQL = "DELETE FROM usuario WHERE idUsuario =" + Delete;
        int res = 0;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            GP = conexion.prepareStatement(SQL);
            res = GP.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
            }

        } catch (Exception e) {
            System.out.println(e);

        }
        return res;
    }
    //????????????????????????????????????????????????????????????????????????????????

    //INSERTAR DATOS EN LA TABLA DE LA BASE DE DATOS
    //********************************************************************************************
    public int guardarUsuarios(String Nombres, String Apellidos, String Dni, String Email, String Usuario, String Contraseña, String TipoUsuario, String Estado) {
        int resultado = 0;
        Connection conexion = null;

        String sentencia_guardar = "INSERT INTO usuario (Nombres, Apellidos, Dni, Email, Usuario, Contraseña, TipoUsuario, Estado) VALUES (?,?,?,?,?,?,?,?)";

        try {
            conexion = ConexionBD.conectar();
            GP = conexion.prepareStatement(sentencia_guardar);

            GP.setString(1, Nombres);
            GP.setString(2, Apellidos);
            GP.setString(3, Dni);
            GP.setString(4, Email);
            GP.setString(5, Usuario);
            GP.setString(6, Contraseña);
            GP.setString(7, TipoUsuario);
            GP.setString(8, Estado);
            resultado = GP.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    }
    //************************************************************************************

    //-------------------------------------------------------------------------------------
    public DefaultTableModel getDatos() {

        String MYSQL_SELECT = "SELECT * FROM usuario";

        try {
            setTitulos();
            CN = ConexionBD.conectar();
            PS = CN.prepareStatement(MYSQL_SELECT);
            RS = PS.executeQuery();
            Object[] fila = new Object[10];
            while (RS.next()) {
                fila[0] = RS.getString(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getString(5);
                fila[5] = RS.getString(6);
                fila[6] = RS.getString(7);
                fila[7] = RS.getString(8);
                fila[8] = RS.getString(9);
                DT.addRow(fila);

            }
        } catch (SQLException e) {
            System.out.println(e);

        } finally {
            PS = null;
            RS = null;
            //CN.close();

        }
        return DT;
    }

//--------------------------------------------------------------------------------

    //Mostrar Los datos de los usuarios
    public static String buscarNombre(String nusuario) {

        String busqueda_nombre = null;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar = ("SELECT Nombres, Apellidos FROM usuario WHERE Usuario = '" + nusuario + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                String nombres = resultado.getString("nombres");
                busqueda_nombre = (nombres);
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_nombre;
    }

public static String buscarApellidos(String nusuario) {

        String busqueda_apellidos = null;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar = ("SELECT Nombres, Apellidos FROM usuario WHERE Usuario = '" + nusuario + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                String apellidos = resultado.getString("apellidos");
                busqueda_apellidos = (apellidos);
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_apellidos;
    }
    
public static String buscarId(String nusuario) {

        String busqueda_Id = null;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar = ("SELECT idUsuario, Nombres, Apellidos FROM usuario WHERE Usuario = '" + nusuario + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                String Id = resultado.getString("idUsuario");
                busqueda_Id = (Id);
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_Id;
    }

    public static String buscarDni(String nusuario) {

        String busqueda_Dni = null;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar = ("SELECT idUsuario, Dni, Nombres, Apellidos FROM usuario WHERE Usuario = '" + nusuario + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                String Dni = resultado.getString("Dni");
                busqueda_Dni = (Dni);
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_Dni;
    }
    
    public static String buscarEmail(String nusuario) {

        String busqueda_Email = null;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar = ("SELECT idUsuario, Dni, Email, Nombres, Apellidos FROM usuario WHERE Usuario = '" + nusuario + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                String Email = resultado.getString("Email");
                busqueda_Email = (Email);
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_Email;
    }
    
     public static String buscarUsuario(String nusuario) {

        String busqueda_Usuario = null;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar = ("SELECT idUsuario, Dni, Email, Usuario, Nombres, Apellidos FROM usuario WHERE Usuario = '" + nusuario + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                String Usuario = resultado.getString("Usuario");
                busqueda_Usuario = (Usuario);
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_Usuario;
    }
     
     public static String buscarContraseña(String nusuario) {

        String busqueda_Contraseña = null;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar = ("SELECT idUsuario, Dni, Email, Usuario, Contraseña, Nombres, Apellidos FROM usuario WHERE Usuario = '" + nusuario + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                String Contraseña = resultado.getString("Contraseña");
                busqueda_Contraseña = (Contraseña);
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_Contraseña;
    }
     
     public static String buscarTipoUsuario(String nusuario) {

        String busqueda_TipoUsuario= null;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar = ("SELECT idUsuario, Dni, Email, Usuario, Contraseña, TipoUsuario, Nombres, Apellidos FROM usuario WHERE Usuario = '" + nusuario + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                String TipoUsuario = resultado.getString("TipoUsuario");
                busqueda_TipoUsuario = (TipoUsuario);
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_TipoUsuario;
    }
     
     public static String buscarEstado(String nusuario) {

        String busqueda_Estado= null;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar = ("SELECT idUsuario, Dni, Email, Usuario, Contraseña, TipoUsuario, Estado, Nombres, Apellidos FROM usuario WHERE Usuario = '" + nusuario + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                String Foto = resultado.getString("Estado");
                busqueda_Estado = (Foto);
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_Estado;
    }
     //*************************************************************************************************************************************
     
     
     //Imagen
     public void guardar_imagen(String ruta, String nombre){
         Connection con = ConexionBD.conectar();
         String insert = "INSERT INTO usuario (Foto) VALUES (?)";
         FileInputStream fi = null;
         PreparedStatement ps = null;
         
         try {
             File file = new File(ruta);
             fi = new FileInputStream(file);
             
             ps = con.prepareStatement(insert);
             ps.setBinaryStream(8, fi);
             
             ps.executeUpdate();
         } catch (Exception ex) {
             System.out.println("Error al guardar");
         }
     }
}