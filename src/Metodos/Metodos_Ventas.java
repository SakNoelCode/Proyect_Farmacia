package Metodos;

import Conexion.ConexionBD;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Metodos_Ventas {
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
        DT.addColumn("Serie");
        DT.addColumn("Número");
        DT.addColumn("Descripcion");
        DT.addColumn("Categoria");
        DT.addColumn("Cantidad");
        DT.addColumn("Igv");
        DT.addColumn("Costo");
        DT.addColumn("Precio");
        DT.addColumn("Estado");
        return DT;
    }
    //----------------------------------------------------------------------------

    //ACTUALIZAR DATOS DE LAS TABLAS DE LA BASE DE DATOS
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public int ActualizarDatos(String ID, String Serie, String Numero, String Descripcion, String Categoria, int Cantidad, float Igv, float Costo, float Precio, String Estado) {
        String SQL = "UPDATE producto SET Serie = '" +  Serie + "', Numero = '" +  Numero + "', pro_Descripcion = '" + Descripcion + "', pro_Categoria = '" + Categoria + "', pro_Cantidad = '" + Cantidad + "', Igv = '" + Igv + "', pro_Costo = '" + Costo + "', pro_Precio = '" + Precio + "', pro_Estado = '" + Estado + "' WHERE pro_ID = " + ID;
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
        String SQL = "DELETE FROM producto WHERE pro_id =" + ID;
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
    public int GuardarVentas( String Serie, String Numero, String Fecha, String VentaTotal, String Descuento, String SubTotal, String Igv, String Total, String Estado, String IdCliente, String IdEmpleado, String IdTipoComprobante) {
        int resultado = 0;
        Connection conexion = null;

        String sentencia_guardar = "INSERT INTO ventas (Serie, Numero, Fecha, VentaTotal, Descuento, SubTotal, Igv, Total, Estado, IdCliente, IdEmpleado, IdTipoComprobante) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            conexion = ConexionBD.conectar();
            GP = conexion.prepareStatement(sentencia_guardar);
            GP.setString(1, Serie);
            GP.setString(2, Numero);
            GP.setString(3, Fecha);
            GP.setString(4, VentaTotal);
            GP.setString(5, Descuento);
            GP.setString(6, SubTotal);
            GP.setString(7, Igv);
            GP.setString(8, Total);
            GP.setString(9, Estado);
            GP.setString(10, IdCliente);
            GP.setString(11, IdEmpleado);
            GP.setString(12, IdTipoComprobante);
            resultado = GP.executeUpdate();
            if (resultado > 0) {
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    }
    
    public int GuardarDetalleVentas(String IdVenta, String IdProducto, String Cantidad, String Costo, String Precio, String Total) {
        int resultado = 0;
        Connection conexion = null;

        String sentencia_guardar = "INSERT INTO detalleventa (IdVenta, idProducto, Cantidad, Costo, Precio, Importe) VALUES (?,?,?,?,?,?)";

        try {
            conexion = ConexionBD.conectar();
            GP = conexion.prepareStatement(sentencia_guardar);
            GP.setString(1, IdVenta);
            GP.setString(2, IdProducto);
            GP.setString(3, Cantidad);
            GP.setString(4, Costo);
            GP.setString(5, Precio);
            GP.setString(6, Total);
            resultado = GP.executeUpdate();
            if (resultado > 0) {
                JOptionPane.showMessageDialog(null, "Venta realizada con Éxito");
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

        String MYSQL_SELECT = "SELECT * FROM ventas";

        try {
            setTitulos();
            CN = ConexionBD.conectar();
            PS = CN.prepareStatement(MYSQL_SELECT);
            RS = PS.executeQuery();
            Object[] productos = new Object[9];
            while (RS.next()) {
                productos[0] = RS.getInt(1);
                productos[1] = RS.getString(2);
                productos[2] = RS.getString(3);
                productos[3] = RS.getString(4);
                productos[4] = RS.getString(5);
                productos[4] = RS.getString(6);
                productos[5] = RS.getInt(7);
                productos[6] = RS.getFloat(8);
                productos[7] = RS.getFloat(9);
                productos[8] = RS.getFloat(10);
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

//--------------------------------------------------------------------------------
    public ResultSet obtenerUltimoIdVenta() throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement statement = connection.prepareCall("{call UltimoIdVenta()}");
            rs = statement.executeQuery();
            return rs;
        }catch(SQLException SQLex){
            throw SQLex;            
        }        
    }


public ResultSet listarVentaPorFecha(String criterio,java.util.Date fechaini, java.util.Date fechafin) throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement statement = connection.prepareCall("{call VentasPorFecha(?,?,?)}");
            statement.setString ("criterio", criterio);
            statement.setDate ("fechaIni", new java.sql.Date(fechaini.getTime()));
            statement.setDate ("fechaFin", new java.sql.Date(fechafin.getTime()));
            rs = statement.executeQuery();
            return rs;
        }catch(SQLException SQLex){
            throw SQLex;            
        }        
    } 


 public ResultSet listarDetalleVentaPorParametro(String criterio, String busqueda) throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement statement = connection.prepareCall("{call DetalleVentaParametro(?,?)}");
            statement.setString("criterio", criterio);
            statement.setString("buscar", busqueda);
            rs = statement.executeQuery();
            return rs;
        }catch(SQLException SQLex){
            throw SQLex;            
        }        
    }  
 
 public ResultSet listarVentaPorDetalle(String criterio,java.util.Date fechaini, java.util.Date fechafin) throws Exception{
        ResultSet rs = null;
        try{
            CallableStatement statement = connection.prepareCall("{call VentasPorDetalle(?,?,?)}");
            statement.setString ("criterio", criterio);
            statement.setDate ("fechaIni", new java.sql.Date(fechaini.getTime()));
            statement.setDate ("fechaFin", new java.sql.Date(fechafin.getTime()));
            rs = statement.executeQuery();
            return rs;
        }catch(SQLException SQLex){
            throw SQLex;            
        }        
    }
 
 public void actualizarVentaEstado(String codigo,String Venta){
        try{
            CallableStatement statement=connection.prepareCall("{call ActualizarVentaEstado(?,?)}");
            statement.setString("pidventa",codigo);
            statement.setString("pestado",Venta);        
            statement.executeUpdate();
            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        JOptionPane.showMessageDialog(null,"¡Venta Anulada!","Mensaje del Sistema",1);
    }
}