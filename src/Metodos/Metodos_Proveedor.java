
package Metodos;

import Conexion.ConexionBD;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Metodos_Proveedor {
    
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
        DT.addColumn("Codigo");
        DT.addColumn("Nombre");
        DT.addColumn("Dni");
        DT.addColumn("Ruc");
        DT.addColumn("Direccion");
        DT.addColumn("Email");
        DT.addColumn("Telefono");
        DT.addColumn("Banco");
        DT.addColumn("Nro Cuenta");
        DT.addColumn("Estado");
        return DT;
    }
    //----------------------------------------------------------------------------

    //ACTUALIZAR DATOS DE LAS TABLAS DE LA BASE DE DATOS
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public int ActualizarProveedor(String Codigo, String Nombre, String DNI, String Ruc, String Direccion, String Email, String Telefono, String Banco, String Cuenta, String Estado) {
        String SQL = "UPDATE proveedor SET Nombre = '" + Nombre + "', Dni = '" + DNI + "', Ruc = '" + Ruc + "', Direccion = '" + Direccion + "', Email = '" + Email + "', Telefono = '" + Telefono + "',  Banco = '" + Banco + "',  Cuenta = '" + Cuenta + "',  Estado = '" + Estado +"' WHERE IdProveedor = " + Codigo;
        int resultado = 0;
        Connection conexion = null;

        
        try {
            conexion = ConexionBD.conectar();
            GP = conexion.prepareStatement(SQL);
            resultado = GP.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro Modificado con Éxito");
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
    public int EliminarProveedor(String Bor){
        String SQL = "DELETE FROM proveedor WHERE IdProveedor =" + Bor;
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
    public int guardarProveedor(String Nombre, String DNI, String Ruc, String Direccion, String Email, String Telefono, String Banco, String Cuenta, String Estado) {
        int resultado = 0;
        Connection conexion = null;

        String sentencia_guardar = "INSERT INTO proveedor (Nombre, Dni, Ruc, Direccion, Email, Telefono, Banco, Cuenta, Estado) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            conexion = ConexionBD.conectar();
            GP = conexion.prepareStatement(sentencia_guardar);
            
            GP.setString(1, Nombre);
            GP.setString(2, DNI);
            GP.setString(3, Ruc);
            GP.setString(4, Direccion);
            GP.setString(5, Email);
            GP.setString(6, Telefono);
            GP.setString(7, Banco);
            GP.setString(8, Cuenta);
            GP.setString(9, Estado);
            resultado = GP.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro Guardado con Ëxito");
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

        String MYSQL_SELECT = "SELECT * FROM proveedor";

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
                fila[9] = RS.getString(10);
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
public int  ProveedorExistente(String Dni) {
        Connection conexion = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(IdProveedor) FROM proveedor WHERE Dni = ? ";

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
public int RucExistente(String Ruc) {
        Connection conexion = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(IdProveedor) FROM proveedor WHERE Ruc = ? ";

        try {
            conexion = ConexionBD.conectar();
            GP = conexion.prepareStatement(sql);
            
            GP.setString(1, Ruc);
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
