package Metodos;

import Conexion.ConexionBD;
import java.sql.*;


public class Metodos_sql {

    public static ConexionBD conexion = new ConexionBD();

    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static String sql;
    public static int resultado_numero = 0;

    public int guardar(String Dni, String nombres, String apellidos, String email, String nusuario, String clave, String TipoUsuario, String estado) {
        int resultado = 0;
        Connection conexion = null;

        String sentencia_guardar = ("INSERT INTO Usuario (Nombres, Apellidos, Dni, Email, Usuario, Contraseña, TipoUsuario, Estado) VALUES (?,?,?,?,?,?,?,?)");

        try {
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
            sentencia_preparada.setString(1, nombres);
            sentencia_preparada.setString(2, apellidos);
            sentencia_preparada.setString(3, Dni);
            sentencia_preparada.setString(4, email);
            sentencia_preparada.setString(5, nusuario);
            sentencia_preparada.setString(6, clave);
            sentencia_preparada.setString(7, TipoUsuario);
            sentencia_preparada.setString(8, estado);
            resultado = sentencia_preparada.executeUpdate();
            sentencia_preparada.close();

            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    }

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
                String apellidos = resultado.getString("apellidos");
                busqueda_nombre = (nombres + " " + apellidos);
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_nombre;
    }
    
    public static String buscarUsuario(String nusuario) {

        String busquedaUsuario = null;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar = ("SELECT Nombres, Apellidos, Usuario FROM usuario WHERE Usuario = '" + nusuario + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                String Usuario = resultado.getString("Usuario");
                busquedaUsuario = (Usuario );
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return busquedaUsuario;
    }
    
    public static String buscarTipoUsuario(String nusuario) {

        String busqueda_Rol = null;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar = ("SELECT Nombres, Apellidos, TipoUsuario FROM usuario WHERE Usuario = '" + nusuario + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                String Tipo_Usuario = resultado.getString("TipoUsuario");
                busqueda_Rol = (Tipo_Usuario);
            }
            conexion.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_Rol;
    }
    
    public static String buscarId(String nusuario) {

        String busqueda_Id = null;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar = ("SELECT Nombres, Apellidos, TipoUsuario, idUsuario FROM usuario WHERE Usuario = '" + nusuario + "'");
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
    public static String buscarUsuarioRegistrado(String nusuario, String clave) {
        String busqueda_usuario = null;
        Connection conexion = null;
        String tipo ="Administrador";
        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar_usuario = ("SELECT Nombres, Usuario, Contraseña FROM usuario WHERE Usuario = '" + nusuario + "' && Contraseña = '" + clave + "' && TipoUsuario = '" + tipo + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar_usuario);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                busqueda_usuario = "USUARIO ENCONTRADO";
            } else {
                busqueda_usuario = "USUARIO NO ENCONTRADO";

            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_usuario;
    }

    public static String UsuarioInvitado(String user, String pass) {
        String buscarUsuario = null;
        Connection conexion = null;
        
        
       String tipo ="Vendedor";
        
        try {
            conexion = ConexionBD.conectar();
            String buscarInvitado = ("SELECT Nombres, Usuario, Contraseña, TipoUsuario  FROM usuario WHERE Usuario = '" + user + "' && Contraseña = '" + pass + "' && TipoUsuario = '" + tipo + "'");
            sentencia_preparada = conexion.prepareStatement(buscarInvitado);
            resultado = sentencia_preparada.executeQuery();
            if(resultado.next()){
                buscarUsuario = "USUARIO ENCONTRADO";
            }else {
                buscarUsuario = "USUARIO NO ENCONTRADO";
            }
            conexion.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    
    return buscarUsuario;
    }
}

