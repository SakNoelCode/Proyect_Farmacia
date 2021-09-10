package Metodos;

import Conexion.ConexionBD;
import Vista.frmProductos;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class Metodos_Productos {
    private Connection connection=new ConexionBD().conectar();
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
        DT.addColumn("Presentación");
        DT.addColumn("Descripción");
        DT.addColumn("Concentración");
        DT.addColumn("Stock");
        DT.addColumn("Costo");
        DT.addColumn("Venta");
        DT.addColumn("Vencimiento");
        DT.addColumn("Registro Sanitario");
        DT.addColumn("Laboratorio");
        DT.addColumn("Estado");
        return DT;
    }
    //----------------------------------------------------------------------------

    //ACTUALIZAR DATOS DE LAS TABLAS DE LA BASE DE DATOS
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public int ActualizarDatos(String ID, String Descripcion, String Concentracion, int Stock, float Costo, float Precio, String RegistroSanitario, Date Fecha, String Estado,  String Presentacion, String Laboratorio) {
        String SQL = "UPDATE producto SET Descripcion = '" + Descripcion + "',Concentracion = '" + Concentracion + "', Stock = '" + Stock + "', Costo = '" + Costo + "', Precio_Venta = '" + Precio + "', RegistroSanitario = '" + RegistroSanitario + "', FechaVencimiento = '" + Fecha + "', Estado = '" + Estado + "', idPresentacion = '" + Presentacion +  "', idLaboratorio = '" + Laboratorio + "' WHERE idProducto = " + ID;
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
    public int EliminarDatos(String ID){
        String SQL = "DELETE FROM producto WHERE idProducto =" + ID;
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
    public int guardarProductos(String Descripcion, String Concentracion, int Stock, float Costo, float Precio, String RegistroSanitario, Date Fecha, String Estado,  String Presentacion, String Laboratorio) {
        int resultado = 0;
        Connection conexion = null;

        String sentencia_guardar = "INSERT INTO producto (Descripcion, Concentracion, Stock, Costo, Precio_Venta, RegistroSanitario, FechaVencimiento, Estado, idPresentacion, idLaboratorio) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try {
            conexion = ConexionBD.conectar();
            GP = conexion.prepareStatement(sentencia_guardar);
            GP.setString(1, Descripcion);
            GP.setString(2, Concentracion);
            GP.setInt(3, Stock);
            GP.setFloat(4, Costo);
            GP.setFloat(5, Precio);
            GP.setString(6, RegistroSanitario);
            GP.setString(7, ((JTextField)frmProductos.jdtFecha.getDateEditor().getUiComponent()).getText());
            GP.setString(8, Estado);
            GP.setString(9, Presentacion);
            GP.setString(10, Laboratorio);
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
        
        String MYSQL_SELECT = "SELECT p.idProducto,pr.Descripcion AS presentacion,p.Descripcion,p.Concentracion,p.Stock,p.Costo,p.Precio_Venta,p.FechaVencimiento,p.RegistroSanitario,l.Nombre as laboratorio,p.Estado "
                + " FROM producto AS p INNER JOIN presentacion AS pr ON p.idPresentacion=pr.idPresentacion INNER JOIN laboratorio AS l ON p.idLaboratorio=l.idLaboratorio ORDER BY p.idProducto;";

        try {
            setTitulos();
            CN = ConexionBD.conectar();
            PS = CN.prepareStatement(MYSQL_SELECT);
            RS = PS.executeQuery();
            Object[] productos = new Object[11];
            while (RS.next()) {
                productos[0] = RS.getInt(1);
                productos[1] = RS.getString(2);
                productos[2] = RS.getString(3);
                productos[3] = RS.getString(4);
                productos[4] = RS.getInt(5);
                productos[5] = RS.getFloat(6);
                productos[6] = RS.getFloat(7);
                productos[7] = RS.getString(8);
                productos[8] = RS.getString(9);
                productos[9] = RS.getString(10);
                productos[10] = RS.getString(11);
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
    public ResultSet listarProductoActivoPorParametro(String criterio, String busqueda) throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement statement = connection.prepareCall("{call ProductosPorParametro(?,?)}");
            statement.setString("pcriterio", criterio);
            statement.setString("pbusqueda", busqueda);
            rs = statement.executeQuery();
            return rs;
        }catch(SQLException SQLex){
            throw SQLex;            
        }        
    }

//--------------------------------------------------------------------------------

public void actualizarProductoStock(String Id,String Producto){
        try{
            CallableStatement statement=connection.prepareCall("{call ActualizarProductoStock(?,?)}");
            statement.setString("pidProducto",Id);
            statement.setString("pstock",Producto);        
            statement.executeUpdate();
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        //JOptionPane.showMessageDialog(null,"¡Producto Actualizado!","Mensaje del Sistema",1);
    }

public ResultSet listarProductos(String criterio, String busqueda) throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement statement = connection.prepareCall("{call BuscarProductos(?,?)}");
            statement.setString("criterio", criterio);
            statement.setString("Prod", busqueda);
            rs = statement.executeQuery();
            return rs;
        }catch(SQLException SQLex){
            throw SQLex;            
        }        
    }

private DefaultTableModel Titulos() {
        DT = new DefaultTableModel();
        DT.addColumn("ID");
        DT.addColumn("Presentación");
        DT.addColumn("Descripción");
        DT.addColumn("Concentración");
        DT.addColumn("Stock");
        DT.addColumn("Costo");
        DT.addColumn("Venta");
        return DT;
    }

public DefaultTableModel CargarDatosBusqueda() {
        
        String MYSQL_SELECT = "SELECT p.idProducto,pr.Descripcion AS presentacion,p.Descripcion,p.Concentracion,p.Stock,p.Costo,p.Precio_Venta "
                + "FROM producto AS p INNER JOIN presentacion AS pr ON p.idPresentacion=pr.idPresentacion WHERE P.Estado='Activo' ";
        try {
            Titulos();
            CN = ConexionBD.conectar();
            PS = CN.prepareStatement(MYSQL_SELECT);
            RS = PS.executeQuery();
            Object[] productos = new Object[7];
            while (RS.next()) {
                productos[0] = RS.getInt(1);
                productos[1] = RS.getString(2);
                productos[2] = RS.getString(3);
                productos[3] = RS.getString(4);
                productos[4] = RS.getInt(5);
                productos[5] = RS.getFloat(6);
                productos[6] = RS.getFloat(7);
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

private DefaultTableModel TitulosCompra() {
        DT = new DefaultTableModel();
        DT.addColumn("ID");
        DT.addColumn("Presentación");
        DT.addColumn("Descripción");
        DT.addColumn("Concentración");
        DT.addColumn("Stock");
        DT.addColumn("Costo");
        return DT;
    }
public DefaultTableModel CargarDatosBusquedaCompra() {
        
        String MYSQL_SELECT = "SELECT p.idProducto,pr.Descripcion AS presentacion,p.Descripcion,p.Concentracion,p.Stock,p.Costo "
                + "FROM producto AS p INNER JOIN presentacion AS pr ON p.idPresentacion=pr.idPresentacion WHERE P.Estado='Activo' ";
        try {
            TitulosCompra();
            CN = ConexionBD.conectar();
            PS = CN.prepareStatement(MYSQL_SELECT);
            RS = PS.executeQuery();
            Object[] productos = new Object[6];
            while (RS.next()) {
                productos[0] = RS.getInt(1);
                productos[1] = RS.getString(2);
                productos[2] = RS.getString(3);
                productos[3] = RS.getString(4);
                productos[4] = RS.getInt(5);
                productos[5] = RS.getFloat(6);
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