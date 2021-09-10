
package Metodos;

import Conexion.ConexionBD;
import static Metodos.Metodos_Empleados.GP;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Metodos_Empleados {
    
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
        DT.addColumn("Id");
        DT.addColumn("Nombres");
        DT.addColumn("Apellidos");
        DT.addColumn("Especialidad");
        DT.addColumn("Sexo");
        DT.addColumn("DNI");
        DT.addColumn("Email");
        DT.addColumn("Telefono");
        DT.addColumn("Direccion");
        DT.addColumn("Ingreso");
        DT.addColumn("Salida");
        DT.addColumn("Sueldo");
        DT.addColumn("Estado");
        return DT;
    }
    //----------------------------------------------------------------------------

    //ACTUALIZAR DATOS DE LAS TABLAS DE LA BASE DE DATOS
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public int ActualizarEmpleado(String Id, String Nombres, String Apellidos, String Especialidad, String Sexo, int DNI, String Email,int Telefono, String Direccion, String Ingreso, String Salida, float Sueldo, String Estado, int Usuario) {
        String SQL = "UPDATE empleado SET Nombres = '" + Nombres + "', Apellidos = '" + Apellidos +  "', Especialidad = '" + Especialidad + "', Sexo = '" + Sexo + "', Dni = '" + DNI + "',  Email = '" + Email + "', Telefono = '" + Telefono + "',  Direccion = '" + Direccion +  "',  HoraIngreso = '" + Ingreso +  "',  HoraSalida = '" + Salida + "',  Sueldo = '" + Sueldo +"', Estado = '" + Estado +"', idUsuario = '" + Usuario +"' WHERE idEmpleado = " + Id;
        int resultado = 0;
        Connection conexion = null;

        
        try {
            conexion = ConexionBD.conectar();
            GP = conexion.prepareStatement(SQL);
            resultado = GP.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro modificado con éxito");
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
    public int EliminarEmpleado(String Bor){
        String SQL = "DELETE FROM empleado WHERE idEmpleado =" + Bor;
        int res = 0;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            GP = conexion.prepareStatement(SQL);
            res = GP.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado");
            }
            
        } catch (Exception e) {
            System.out.println(e);

        }
        return res;
    }
    //????????????????????????????????????????????????????????????????????????????????

    //INSERTAR DATOS EN LA TABLA DE LA BASE DE DATOS
    //********************************************************************************************
    public int guardarEmpleado(String Nombres, String Apellidos, String Especialidad, String Sexo, int DNI, String Email, int Telefono, String Direccion, String Ingreso, String Salida, float Sueldo, String Estado, int Usuario) {
        int resultado = 0;
        Connection conexion = null;

        String sentencia_guardar = "INSERT INTO empleado (Nombres, Apellidos, Especialidad, Sexo, Dni, Email, Telefono, Direccion, HoraIngreso, HoraSalida, Sueldo, Estado, idUsuario) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            conexion = ConexionBD.conectar();
            GP = conexion.prepareStatement(sentencia_guardar);
            
            GP.setString(1, Nombres);
            GP.setString(2, Apellidos);
            GP.setString(3, Especialidad);
            GP.setString(4, Sexo);
            GP.setInt(5, DNI);
            GP.setString(6, Email);
            GP.setInt(7, Telefono);
            GP.setString(8, Direccion);
            GP.setString(9, Ingreso);
            GP.setString(10, Salida);
            GP.setFloat(11, Sueldo);
            GP.setString(12, Estado);
            GP.setInt(13, Usuario);
            resultado = GP.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro guardado con éxito");
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

        String MYSQL_SELECT = "SELECT * FROM empleado";

        try {
            setTitulos();
            CN = ConexionBD.conectar();
            PS = CN.prepareStatement(MYSQL_SELECT);
            RS = PS.executeQuery();
            Object[] fila = new Object[13];
            while (RS.next()) {
                fila[0] = RS.getString(1);
                fila[1] = RS.getString(2);
                fila[2] = RS.getString(3);
                fila[3] = RS.getString(4);
                fila[4] = RS.getString(5);
                fila[5] = RS.getInt(6);
                fila[6] = RS.getString(7);
                fila[7] = RS.getInt(8);
                fila[8] = RS.getString(9);
                fila[9] = RS.getString(10);
                fila[10] = RS.getString(11);
                fila[11] = RS.getFloat(12);
                fila[12] = RS.getString(13);
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
public int EmpleadoExistente(String Dni) {
        Connection conexion = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(idEmpleado) FROM empleado WHERE Dni = ?";

        try {
            conexion = ConexionBD.conectar();
            GP = conexion.prepareStatement(sql);
            
            GP.setString(1, Dni);
            rs = GP.executeQuery();
            
            if (rs.next()) {
               return rs.getInt(1);
            }
            return 1;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 1;
    }
public boolean Email(String correo){
    Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    
    Matcher mather = pattern.matcher(correo);
    return mather.find();
}
}