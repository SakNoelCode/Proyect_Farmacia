package Metodos;

import Conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Metodos_Comprobantes {

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
        DT.addColumn("ID Comprobante");
        DT.addColumn("Descripcion");
        DT.addColumn("Estado");
        return DT;
    }
    //----------------------------------------------------------------------------

    //ACTUALIZAR DATOS DE LAS TABLAS DE LA BASE DE DATOS
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public int ActualizarDatos(String ID, String Descripcion, String Estado) {
        String SQL = "UPDATE tipoComprobante SET Descripcion = '" + Descripcion +  "', Estado = '" + Estado + "' WHERE IdTipoComprobante = " + ID;
        int resultado = 0;
        Connection conexion = null;

        
        try {
            conexion = ConexionBD.conectar();
            GP = conexion.prepareStatement(SQL);
            resultado = GP.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro modificado");
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
    public int EliminarDatos(String ID){
        String SQL = "DELETE FROM tipoComprobante WHERE IdTipoComprobante =" + ID;
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
    public int guardarComprobante(String Descripcion, String Estado) {
        int resultado = 0;
        Connection conexion = null;

        String sentencia_guardar = "INSERT INTO tipoComprobante (Descripcion, Estado) VALUES (?,?)";

        try {
            conexion = ConexionBD.conectar();
            GP = conexion.prepareStatement(sentencia_guardar);
            GP.setString(1, Descripcion);
            GP.setString(2, Estado);
            resultado = GP.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Registro guardado");
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

        String MYSQL_SELECT = "SELECT * FROM tipoComprobante ORDER BY Descripcion ASC";

        try {
            setTitulos();
            CN = ConexionBD.conectar();
            PS = CN.prepareStatement(MYSQL_SELECT);
            RS = PS.executeQuery();
            Object[] productos = new Object[3];
            while (RS.next()) {
                productos[0] = RS.getInt(1);
                productos[1] = RS.getString(2);
                productos[2] = RS.getString(3);
                DT.addRow(productos);

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
}
//--------------------------------------------------------------------------------
