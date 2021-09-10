
package Metodos;

import Conexion.ConexionBD;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Metodos_Clientes {
    
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
        DT.addColumn("Sexo");
        DT.addColumn("DNI");
        DT.addColumn("Telefono");
        DT.addColumn("RUC");
        DT.addColumn("Email");
        DT.addColumn("Direccion");
        return DT;
    }
    //----------------------------------------------------------------------------

    //ACTUALIZAR DATOS DE LAS TABLAS DE LA BASE DE DATOS
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public int ActualizarClientes(String Id, String Nombres, String Apellidos, String Sexo, String DNI, String Telefono, String Ruc, String Email, String Direccion) {
        String SQL = "UPDATE cliente SET Nombres = '" + Nombres + "', Apellidos = '" + Apellidos + "', Sexo = '" + Sexo + "', Dni = '" + DNI + "', Telefono = '" + Telefono + "', Ruc = '" + Ruc + "',  Email = '" + Email + "',  Direccion = '" + Direccion + "' WHERE idCliente = " + Id;
        int resultado = 0;
        Connection conexion = null;

        
        try {
            conexion = ConexionBD.conectar();
            GP = conexion.prepareStatement(SQL);
            resultado = GP.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "REGISTRO MODIFICADO");
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
    public int EliminarClientes(String Bor){
        String SQL = "DELETE FROM cliente WHERE idCliente =" + Bor;
        int res = 0;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            GP = conexion.prepareStatement(SQL);
            res = GP.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO");
            }
            
        } catch (Exception e) {
            System.out.println(e);

        }
        return res;
    }
    //????????????????????????????????????????????????????????????????????????????????

    //INSERTAR DATOS EN LA TABLA DE LA BASE DE DATOS
    //********************************************************************************************
    public int guardarClientes(String Nombres, String Apellidos, String Sexo, String DNI, String Telefono, String Ruc, String Email, String Direccion) {
        int resultado = 0;
        Connection conexion = null;

        String sentencia_guardar = "INSERT INTO cliente (Nombres, Apellidos, Sexo, Dni, Telefono, Ruc, Email, Direccion) VALUES (?,?,?,?,?,?,?,?)";

        try {
            conexion = ConexionBD.conectar();
            GP = conexion.prepareStatement(sentencia_guardar);
            
            GP.setString(1, Nombres);
            GP.setString(2, Apellidos);
            GP.setString(3, Sexo);
            GP.setString(4, DNI);
            GP.setString(5, Telefono);
            GP.setString(6, Ruc);
            GP.setString(7, Email);
            GP.setString(8, Direccion);
            resultado = GP.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "REGISTRO GUARDADO");
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

        String MYSQL_SELECT = "SELECT * FROM cliente";

        try {
            setTitulos();
            CN = ConexionBD.conectar();
            PS = CN.prepareStatement(MYSQL_SELECT);
            RS = PS.executeQuery();
            Object[] fila = new Object[9];
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
public int ClienteExistente(String Dni) {
        Connection conexion = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(idCliente) FROM cliente WHERE Dni = ? ";

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
        String sql = "SELECT COUNT(idCliente) FROM cliente WHERE Ruc = ? ";

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