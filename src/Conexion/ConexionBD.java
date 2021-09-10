package Conexion;

import java.sql.*;


public class ConexionBD {

    public static String url = "jdbc:mysql://localhost/farmacia?serverTimezone=UTC";
    public static String usuario = "root";
    public static String clave = "";
    public static String clase = "com.mysql.cj.jdbc.Driver";

    public static Connection conectar() {
        Connection conexion = null;

        try {
            Class.forName(clase);
            conexion = DriverManager.getConnection(url, usuario, clave);
            //System.out.println("Conexion Establecida");
            //JOptionPane.showMessageDialog(null, "CONEXION EXITOSA");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return conexion;
    }
}
