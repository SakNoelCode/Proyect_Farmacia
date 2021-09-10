
package Vista;

import Conexion.ConexionBD;
import Metodos.Metodos_Compra;
import Metodos.Metodos_Productos;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;


public class frmCompras extends javax.swing.JInternalFrame {

    public String estado = "NORMAL";
    String Total;
    String strCodigo;
    String accion;
    String numCompra;
    int registros;
    String id[]=new String[50];
  
    int num = 0;

    static int intContador;
    public int IdEmpleado =0,NombreEmpleado;
    int idventa,nidventa;
    
    public String codigo;
    static Connection conn=null;
    
    static ResultSet rs=null;
    DefaultTableModel dtm=new DefaultTableModel();
    DefaultTableModel dtmDetalle = new DefaultTableModel();

    String criterio,busqueda;
    public frmCompras() {
        initComponents();
        txtFecha.setDisabledTextColor(Color.blue);
        txtFecha.setText(fecha());
        txtFecha.setVisible(false);
        
        txtFechas.setDisabledTextColor(Color.blue);
        txtFechas.setText(fechaactual());
        
        txtNumeroCompra.setText("0000001");
        
        numCompra = generarIdCompra();
        txtUltimoId.setText(numCompra);
        
        this.setSize(920, 630);
        txtIdComprobante.setVisible(false);
        
        lblIdProducto.setVisible(false);
        lblIdProveedor.setVisible(false);
        txtDescripcionProducto.setVisible(false);
        txtIdEmpleado.setVisible(false);
        
        txtUltimoId.setVisible(false);
        btnReporte.setEnabled(false);
        mirar();
        
        txtTipoPago.setVisible(false);
        
        String titulos[] = {"ID","PRODUCTO", "PRESENTACIÓN","DESCRIPCIÓN", "CANT.", "PRECIO", "TOTAL"};
        dtmDetalle.setColumnIdentifiers(titulos);
        tblDetalleProducto.setModel(dtmDetalle);
        CrearTablaDetalleProducto();
    }

    void limpiarTabla(){
        try{      
	int filas=tblDetalleProducto.getRowCount();
            for (int i = 0;filas>i; i++) {
                dtmDetalle.removeRow(0);
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }
    
     void limpiarCampos(){

       txtSubTotal.setText("0.0");
       txtIGV.setText("0.0");
       txtTotalCompra.setText("0.0");
       
       lblIdProducto.setText("");
       txtCodigoProducto.setText("");
       txtNombreProducto.setText("");
       txtCantidad.setText("");
       txtPrecioProducto.setText("");
       txtCantidadProducto.setText("");
       txtTotalProducto.setText("");
       txtCodigoProducto.requestFocus();
   }
     void modificar(){

       btnNuevo.setEnabled(false);

       btnGuardar.setEnabled(true);
       btnCancelar.setEnabled(true);
       btnSalir.setEnabled(false);
        
       txtComprobante.setEnabled(true);
       txtCodigoProducto.setEnabled(true);
       txtCantidadProducto.setEnabled(true);
       txtFechas.setEnabled(true);
       txtPrecioProducto.setEditable(true);
       txtPrecioProducto.setEnabled(true);
       
       btnBuscarComprobante.setEnabled(true);
       btnBuscarProveedor.setEnabled(true);
       btnBuscarProducto.setEnabled(true);
       btnAgregarProducto.setEnabled(true);
       btnEliminarProducto.setEnabled(true);
       btnLimpiarTabla.setEnabled(true);
      // chkCambiarNumero.setEnabled(true);
       
       txtCodigoProducto.requestFocus();
   }
     void mirar(){
       btnNuevo.setEnabled(true);
       btnGuardar.setEnabled(false);
       btnCancelar.setEnabled(false);
       btnSalir.setEnabled(true);
        

       txtComprobante.setEnabled(false);
       txtCodigoProducto.setEnabled(false);
       txtCantidadProducto.setEnabled(false);
       txtFechas.setEnabled(false);
       //txtNumero.setEnabled(false);
       
       btnBuscarProveedor.setEnabled(false);
       btnBuscarProducto.setEnabled(false);
       btnAgregarProducto.setEnabled(false);
       btnEliminarProducto.setEnabled(false);
       btnLimpiarTabla.setEnabled(false);
       
       btnBuscarComprobante.setEnabled(false);
      // chkCambiarNumero.setEnabled(false);
      // chkCambiarNumero.setSelected(false);
       
       txtSubTotal.setText("0.0");
       txtIGV.setText("0.0");
       txtTotalCompra.setText("0.0");
       lblIdProducto.setText("");
       txtCodigoProducto.setText("");
       txtNombreProducto.setText("");
       txtCantidad.setText("");
       txtPrecioProducto.setText("");
       txtCantidadProducto.setText("");
       txtTotalProducto.setText("");
       txtCodigoProducto.requestFocus();
       
       txtNombreProveedor.setText("");
       txtRuc.setText("");
       txtComprobante.setText("");
       txtPresentacionProducto.setText("");
       txtConcentracionProducto.setText("");
       

   }
     
     void CalcularTotal(){
            
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        DecimalFormat formateador = new DecimalFormat("####.##",simbolos);
        double precio_prod=0,cant_prod=0,total_prod=0;
        precio_prod=Double.parseDouble(txtPrecioProducto.getText());
        cant_prod=Double.parseDouble(txtCantidadProducto.getText());
        total_prod=precio_prod*cant_prod;
        txtTotalProducto.setText(String.valueOf(formateador.format(total_prod)));
}

      void CalcularSubTotal(){
        double subtotal=0;
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        DecimalFormat formateador = new DecimalFormat("####.##",simbolos);        
        subtotal=Double.parseDouble(txtTotalCompra.getText())/1.18;
        txtSubTotal.setText(String.valueOf(formateador.format(subtotal)));
    }
    void CalcularIGV(){
        double igv=0;
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        DecimalFormat formateador = new DecimalFormat("####.##",simbolos);       
        igv=Double.parseDouble(txtSubTotal.getText())*0.18;
        txtIGV.setText(String.valueOf(formateador.format(igv)));
    }
    void CalcularTotal_Compra(){
        int fila = 0;
        double valorCompra = 0;
        fila = dtmDetalle.getRowCount();
        for (int f=0; f<fila; f++){
            valorCompra += Double.parseDouble(String.valueOf(tblDetalleProducto.getModel().getValueAt(f, 6)));            
        }
        txtTotalCompra.setText(String.valueOf(valorCompra));
    }
     public int recorrer(int id){
        int fila = 0,valor=-1;
        
        fila = tblDetalleProducto.getRowCount();
        
        for (int f = 0; f < fila;f++) {
            if(Integer.parseInt(String.valueOf(dtmDetalle.getValueAt(f, 0)))==id){

                valor=f;
        
                break;
                
                
            }else{
       
                valor= -1;
            }          
              
        }
        return valor;
    } 
    void agregardatos(int item, String nom, String pres, String descrip,double cant,double pre,double tot){
        
        int p=recorrer(item);
        double n_cant,n_total;
        if (p>-1){
                               
            n_cant=Double.parseDouble(String.valueOf(tblDetalleProducto.getModel().getValueAt(p,4)))+cant;
            tblDetalleProducto.setValueAt(n_cant,p,4);
                       
            n_total=Double.parseDouble(String.valueOf(tblDetalleProducto.getModel().getValueAt(p,4)))*Double.parseDouble(String.valueOf(tblDetalleProducto.getModel().getValueAt(p,5)));
            tblDetalleProducto.setValueAt(n_total,p,6);
            
                            
        }else{
            String Datos[] = {String.valueOf(item),nom, pres, descrip,String.valueOf(cant),String.valueOf(pre),String.valueOf(tot)};
            dtmDetalle.addRow(Datos);
        }
        tblDetalleProducto.setModel(dtmDetalle);
    }
    void obtenerUltimoIdCompra(){
        try{
        Metodos_Compra oCompra=new Metodos_Compra(); 
        rs= oCompra.obtenerUltimoIdCompra();
            while (rs.next()) {
                idventa = rs.getInt(1);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnBuscarProveedor = new javax.swing.JButton();
        txtNombreProveedor = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblIdProveedor = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        btnBuscarComprobante = new javax.swing.JButton();
        txtComprobante = new javax.swing.JTextField();
        txtFechas = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        btnBuscarProducto = new javax.swing.JButton();
        txtNombreProducto = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtDescripcionProducto = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        txtPrecioProducto = new javax.swing.JTextField();
        lblIdProducto = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtPresentacionProducto = new javax.swing.JTextField();
        txtConcentracionProducto = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtIdEmpleado = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        txtCantidadProducto = new javax.swing.JTextField();
        btnAgregarProducto = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        txtTotalProducto = new javax.swing.JTextField();
        btnEliminarProducto = new javax.swing.JButton();
        btnLimpiarTabla = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDetalleProducto = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();
        txtIGV = new javax.swing.JTextField();
        txtTotalCompra = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtNumeroCompra = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIdComprobante = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        txtTipoPago = new javax.swing.JTextField();
        txtIdProveedor = new javax.swing.JTextField();
        btnReporte = new javax.swing.JButton();
        txtUltimoId = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMinimumSize(new java.awt.Dimension(111, 34));
        setNormalBounds(new java.awt.Rectangle(0, 0, 111, 0));
        setPreferredSize(new java.awt.Dimension(935, 635));

        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(251, 248, 248));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de la Compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(0, 102, 102));

        jLabel1.setBackground(new java.awt.Color(0, 51, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Proveedor:");

        btnBuscarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscarrr_2.png"))); // NOI18N
        btnBuscarProveedor.setAlignmentY(1.0F);
        btnBuscarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProveedorActionPerformed(evt);
            }
        });

        txtNombreProveedor.setEnabled(false);

        jLabel13.setBackground(new java.awt.Color(0, 51, 51));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("RUC:");

        jLabel2.setBackground(new java.awt.Color(0, 51, 51));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Fecha:");

        txtRuc.setEditable(false);

        jLabel14.setBackground(new java.awt.Color(0, 51, 51));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setText("Comprobante:");

        btnBuscarComprobante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscarrr_2.png"))); // NOI18N
        btnBuscarComprobante.setAlignmentY(1.0F);
        btnBuscarComprobante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarComprobante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarComprobanteActionPerformed(evt);
            }
        });

        txtComprobante.setEditable(false);

        txtFechas.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(btnBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btnBuscarComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(txtNombreProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnBuscarProveedor))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel14)
                .addGap(6, 6, 6)
                .addComponent(txtComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnBuscarComprobante))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 60, 695, 73);

        jPanel2.setBackground(new java.awt.Color(251, 248, 248));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setBackground(new java.awt.Color(0, 51, 51));
        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 102));
        jLabel22.setText("Código:");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 70, 40));

        txtCodigoProducto.setEditable(false);
        txtCodigoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoProductoActionPerformed(evt);
            }
        });
        txtCodigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodigoProductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoProductoKeyTyped(evt);
            }
        });
        jPanel2.add(txtCodigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 40, 100, 25));

        btnBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/buscarrr_2.png"))); // NOI18N
        btnBuscarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProductoActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 30, -1));

        txtNombreProducto.setEnabled(false);
        jPanel2.add(txtNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 240, -1));

        jLabel19.setBackground(new java.awt.Color(0, 51, 51));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 102));
        jLabel19.setText("Stock:");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));
        jPanel2.add(txtDescripcionProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 30, 20));

        txtCantidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidad.setEnabled(false);
        jPanel2.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 90, -1));

        txtPrecioProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtPrecioProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPrecioProducto.setEnabled(false);
        jPanel2.add(txtPrecioProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 90, -1));
        jPanel2.add(lblIdProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 20, 20));

        jLabel23.setBackground(new java.awt.Color(0, 51, 51));
        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 102));
        jLabel23.setText("Costo c/u:");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 70, -1));

        txtPresentacionProducto.setEditable(false);
        jPanel2.add(txtPresentacionProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 160, -1));

        txtConcentracionProducto.setEditable(false);
        jPanel2.add(txtConcentracionProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 160, -1));

        jLabel18.setBackground(new java.awt.Color(0, 51, 51));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 102));
        jLabel18.setText("Producto:");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 70, 20));

        jLabel20.setBackground(new java.awt.Color(0, 51, 51));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 102));
        jLabel20.setText("Presentación:");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 90, 20));

        jLabel25.setBackground(new java.awt.Color(0, 51, 51));
        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 102, 102));
        jLabel25.setText("Concentración:");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 100, 20));

        txtIdEmpleado.setEditable(false);
        jPanel2.add(txtIdEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 90, -1));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 140, 625, 120);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel21.setText("CANTIDAD:");

        txtCantidadProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCantidadProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidadProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadProductoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadProductoKeyTyped(evt);
            }
        });

        btnAgregarProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAgregarProducto.setForeground(new java.awt.Color(0, 102, 102));
        btnAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/mas.png"))); // NOI18N
        btnAgregarProducto.setText("Agregar");
        btnAgregarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        jLabel24.setText("TOTAL:");

        txtTotalProducto.setBackground(new java.awt.Color(255, 255, 204));
        txtTotalProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTotalProducto.setForeground(new java.awt.Color(0, 102, 204));
        txtTotalProducto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotalProducto.setDisabledTextColor(new java.awt.Color(0, 102, 204));
        txtTotalProducto.setEnabled(false);

        btnEliminarProducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminarProducto.setForeground(new java.awt.Color(0, 102, 102));
        btnEliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/canc8.png"))); // NOI18N
        btnEliminarProducto.setText("Eliminar");
        btnEliminarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        btnLimpiarTabla.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLimpiarTabla.setForeground(new java.awt.Color(0, 102, 102));
        btnLimpiarTabla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuev.png"))); // NOI18N
        btnLimpiarTabla.setText("Limpiar");
        btnLimpiarTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarTablaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtTotalProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnAgregarProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminarProducto)
                .addGap(8, 8, 8)
                .addComponent(btnLimpiarTabla)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtTotalProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnLimpiarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(10, 260, 650, 50);

        tblDetalleProducto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblDetalleProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDetalleProducto.setRowHeight(22);
        jScrollPane3.setViewportView(tblDetalleProducto);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(10, 321, 780, 180);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("SUB TOTAL");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 100, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("I.G.V.");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 100, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("TOTAL A PAGAR");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel6.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 150, 20));

        txtSubTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSubTotal.setEnabled(false);
        jPanel6.add(txtSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 100, 30));

        txtIGV.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtIGV.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtIGV.setEnabled(false);
        jPanel6.add(txtIGV, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 100, 30));

        txtTotalCompra.setBackground(new java.awt.Color(255, 255, 204));
        txtTotalCompra.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTotalCompra.setForeground(new java.awt.Color(0, 255, 102));
        txtTotalCompra.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotalCompra.setDisabledTextColor(new java.awt.Color(0, 255, 102));
        txtTotalCompra.setEnabled(false);
        jPanel6.add(txtTotalCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 150, 30));

        jPanel1.add(jPanel6);
        jPanel6.setBounds(10, 519, 790, 72);

        btnNuevo.setBackground(new java.awt.Color(204, 255, 204));
        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(0, 102, 102));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/nuevo9.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setIconTextGap(0);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevo);
        btnNuevo.setBounds(810, 180, 90, 80);

        btnGuardar.setBackground(new java.awt.Color(204, 255, 204));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(0, 102, 102));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setIconTextGap(0);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar);
        btnGuardar.setBounds(810, 260, 90, 80);

        btnCancelar.setBackground(new java.awt.Color(204, 255, 204));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 102, 102));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Canc.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setIconTextGap(0);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar);
        btnCancelar.setBounds(810, 340, 90, 80);

        btnSalir.setBackground(new java.awt.Color(204, 255, 204));
        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 102, 102));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/door_in.png"))); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setIconTextGap(0);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir);
        btnSalir.setBounds(810, 510, 90, 80);

        txtNumeroCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroCompraActionPerformed(evt);
            }
        });
        jPanel1.add(txtNumeroCompra);
        txtNumeroCompra.setBounds(770, 100, 110, 20);

        jLabel3.setBackground(new java.awt.Color(0, 51, 51));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("N° Compra:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(790, 80, 70, 14);
        jPanel1.add(txtIdComprobante);
        txtIdComprobante.setBounds(580, 440, 40, 20);

        txtFecha.setEditable(false);
        jPanel1.add(txtFecha);
        txtFecha.setBounds(20, 480, 59, 20);

        txtTipoPago.setEditable(false);
        jPanel1.add(txtTipoPago);
        txtTipoPago.setBounds(660, 160, 110, 20);

        txtIdProveedor.setEditable(false);
        jPanel1.add(txtIdProveedor);
        txtIdProveedor.setBounds(650, 190, 130, 20);

        btnReporte.setBackground(new java.awt.Color(204, 255, 204));
        btnReporte.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReporte.setForeground(new java.awt.Color(0, 102, 102));
        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/printer.png"))); // NOI18N
        btnReporte.setText("Imprimir");
        btnReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporte.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReporte.setIconTextGap(0);
        btnReporte.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        jPanel1.add(btnReporte);
        btnReporte.setBounds(810, 420, 90, 80);

        txtUltimoId.setEditable(false);
        jPanel1.add(txtUltimoId);
        txtUltimoId.setBounds(660, 220, 40, 20);

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.setForeground(new java.awt.Color(0, 51, 51));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Realizar Compra");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 920, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(0, 0, 920, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 919, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static String fechaactual() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyy");
        return formatofecha.format(fecha);

    }
    public static String fecha() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("yyy-MM-dd");
        return formatofecha.format(fecha);

    }
    private void btnBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProveedorActionPerformed
        BuscarProveedor proveedor = new BuscarProveedor();
        frmPrincipal.tbn_escritorio.add(proveedor);
        proveedor.toFront();
        proveedor.setVisible(true);
    }//GEN-LAST:event_btnBuscarProveedorActionPerformed

    private void txtCodigoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoProductoActionPerformed

    private void txtCodigoProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProductoKeyReleased
      /*BuscarProductoPorCodigo();
        int keyCode = evt.getKeyCode();
        if (keyCode==KeyEvent.VK_ENTER) txtCantidadProducto.requestFocus();*/
    }//GEN-LAST:event_txtCodigoProductoKeyReleased

    private void txtCodigoProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProductoKeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_txtCodigoProductoKeyTyped

    private void btnBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProductoActionPerformed
        accion = "ProductoCompra";
        BuscarProductosCompras producto= new BuscarProductosCompras();
        frmPrincipal.tbn_escritorio.add(producto);
        producto.toFront();
        producto.setVisible(true);
    }//GEN-LAST:event_btnBuscarProductoActionPerformed

    private void txtCantidadProductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProductoKeyReleased
     CalcularTotal();
        int keyCode = evt.getKeyCode();
        if (keyCode==KeyEvent.VK_ENTER) btnAgregarProducto.requestFocus();
    }//GEN-LAST:event_txtCantidadProductoKeyReleased

    private void txtCantidadProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadProductoKeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume();
    }//GEN-LAST:event_txtCantidadProductoKeyTyped

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
      double stock,cant;

        if (!txtCantidadProducto.getText().equals("")){
            if(txtCantidadProducto.getText().equals("")){
                txtCantidadProducto.setText("0");
                cant=Double.parseDouble(txtCantidadProducto.getText());
            }else{
                cant=Double.parseDouble(txtCantidadProducto.getText());
            }

            if(cant>0){

                int d1=Integer.parseInt(txtCodigoProducto.getText());
                String d2=txtNombreProducto.getText();
                String d3=txtPresentacionProducto.getText();
                String d4=txtConcentracionProducto.getText();
                double d5=Double.parseDouble(txtCantidadProducto.getText());
                double d6=Double.parseDouble(txtPrecioProducto.getText());
                double d7=Double.parseDouble(txtTotalProducto.getText());
                agregardatos(d1,d2,d3,d4,d5,d6,d7);

                CalcularTotal_Compra();
                CalcularSubTotal();
                CalcularIGV();

                txtCantidadProducto.setText("");
                txtTotalProducto.setText("");
                txtCodigoProducto.requestFocus();

            }else{
                JOptionPane.showMessageDialog(null, "Ingrese Cantidad mayor a 0");
                txtCantidadProducto.requestFocus();
            }

        }else{
            JOptionPane.showMessageDialog(null, "Ingrese cantidad");
            txtCantidadProducto.requestFocus();
        }
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
       int fila = tblDetalleProducto.getSelectedRow();
       if (fila == -1) {
        JOptionPane.showMessageDialog(null, "Por favor seleccione una fila", "ERROR", JOptionPane.ERROR_MESSAGE);
    } else//de lo contrario si se selecciono la fila 
    { 
       
       if (fila > 0) {
            dtmDetalle.removeRow(fila);
            CalcularTotal_Compra();
            CalcularSubTotal();
            CalcularIGV();
        } else if (fila == 0) {
            dtmDetalle.removeRow(fila);
            txtSubTotal.setText("0.0");
            txtIGV.setText("0.0");
            txtTotalCompra.setText("0.0");

            CalcularTotal_Compra();
            CalcularSubTotal();
            CalcularIGV();
        }
       }
        CalcularTotal_Compra();
        CalcularSubTotal();
        CalcularIGV();
        
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnLimpiarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarTablaActionPerformed
        limpiarTabla();
        txtSubTotal.setText("0.0");
        txtIGV.setText("0.0");
        txtTotalCompra.setText("0.0");
        
//        txtNombreProveedor.setText("");
//        txtRuc.setText("");
//        txtComprobante.setText("");
//        
//        txtCodigoProducto.setText("");
//        txtNombreProducto.setText("");
//        txtPresentacionProducto.setText("");
//        txtConcentracionProducto.setText("");
    }//GEN-LAST:event_btnLimpiarTablaActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        accion="Nuevo";
        modificar();
        limpiarCampos();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (txtComprobante.getText().isEmpty() || txtNombreProveedor.getText().isEmpty() || txtNumeroCompra.getText().isEmpty() || txtCantidad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos");
            //--------------------------------------------------
        } else {
        int result = JOptionPane.showConfirmDialog(this, "¿Desea Generar la Compra?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
                Metodos_Compra compras=new Metodos_Compra();
        String Numero = txtNumeroCompra.getText();
        String Fecha = txtFecha.getText();
        String TipoPago = txtTipoPago.getText();
        String SubTotal = txtSubTotal.getText();
        String Total = txtTotalCompra.getText();
        String Igv = txtIGV.getText();
        String Estado = estado;
        String IdProveedor = txtIdProveedor.getText();
        String IdEmpleados = txtIdEmpleado.getText();
        String IdTipoComprobante = txtIdComprobante.getText();
        //+++++++++++++++++++++++
        if (num == 0) {
            compras.GuardarCompras(Numero, Fecha, TipoPago, SubTotal, Total, Igv, Estado, IdProveedor, IdEmpleados, IdTipoComprobante);
            guardarDetalle();
        }
            mirar();
            limpiarTabla();
            numCompra=generaNumCompra();
            txtNumeroCompra.setText(numCompra);
        
        }
        if (result == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Compra Anulada!");
        }
        btnReporte.setEnabled(true);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        mirar();
        limpiarTabla();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnBuscarComprobanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarComprobanteActionPerformed
        
       
        BuscarComprobanteCompra Comprobante = new BuscarComprobanteCompra();
        CentrarVentana(Comprobante);
    }//GEN-LAST:event_btnBuscarComprobanteActionPerformed
        public void CentrarVentana(JInternalFrame internalFrame) {
        int x = (frmPrincipal.tbn_escritorio.getWidth() / 2) - internalFrame.getWidth() / 2;
        int y = (frmPrincipal.tbn_escritorio.getHeight() / 2) - internalFrame.getHeight() / 2;
        if (internalFrame.isShowing()) {
            internalFrame.setLocation(x, y);
        } else {
            frmPrincipal.tbn_escritorio.add(internalFrame);
            internalFrame.setLocation(x, y);
            internalFrame.show();
        }
    }
    private void txtNumeroCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroCompraActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        JRReporte cr = new JRReporte();
    Connection con = null;
    
        try {
            con = ConexionBD.conectar();
            Map parametros = new HashMap();
            parametros.put("IdCompra", txtUltimoId.getText());
            String ruta = System.getProperty("user.dir") + "\\src\\Reportes\\Compras.jrxml";
            cr.abrirReporte(ruta, con, parametros);
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el reporte de Ventas", "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    
        btnReporte.setEnabled(false);
    }//GEN-LAST:event_btnReporteActionPerformed
 void CrearTablaDetalleProducto(){

      
        TableCellRenderer render = new DefaultTableCellRenderer() { 

            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) { 
            
                JLabel l = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
               
                    if(column==0 || column==4 || column==5 || column==6){
                        l.setHorizontalAlignment(SwingConstants.CENTER); 
                    }else{
                        l.setHorizontalAlignment(SwingConstants.LEFT);
                    }
    
               if (isSelected) {
                    l.setBackground(new Color(0, 102, 102));
                    l.setForeground(Color.WHITE);
                } else {
                    l.setForeground(Color.BLACK);
                    if (row % 2 == 0) {
                        l.setBackground(Color.WHITE);
                    } else {
                        l.setBackground(new Color(240, 240, 240));
                    }
                }
                return l; 
            } 
        }; 
        
     
        for (int i=0;i<tblDetalleProducto.getColumnCount();i++){
            tblDetalleProducto.getColumnModel().getColumn(i).setCellRenderer(render);
        }
      
    
        tblDetalleProducto.setAutoResizeMode(tblDetalleProducto.AUTO_RESIZE_OFF);

       
        int[] anchos = {50,100,180,230,70,70,70};
        for(int i = 0; i < tblDetalleProducto.getColumnCount(); i++) {
            tblDetalleProducto.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
   }
 
 public String generaNumCompra(){

        Metodos_Compra oCompra=new Metodos_Compra(); 
        try {

            rs= oCompra.obtenerUltimoIdCompra();
            while (rs.next()) {
            if (rs.getString(1) != null) {
                Scanner s = new Scanner(rs.getString(1));
                int c = s.useDelimiter("C").nextInt() + 1;

                if (c < 10) {
                    return "C0000" + c;
                }
                if (c < 100) {
                    return "C000" + c;
                }
                if (c < 1000) {
                    return "C00" + c;
                }
                if (c < 10000) {
                    return "C0" + c;
                } else {
                    return "C" + c;
                }
            }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return "C00001";
              
  }
 void guardarDetalle(){
        obtenerUltimoIdCompra();
        Metodos_Compra Detallecompras=new Metodos_Compra();
//        
//        EntidadDetalleCompra detallecompra=new EntidadDetalleCompra();
//        ClaseProducto productos=new ClaseProducto();
//        String codigo,strId;
//        EntidadProducto producto=new EntidadProducto();
        int fila=0;
        String strId;
        double cant = 0,ncant,stock;   
        fila =tblDetalleProducto.getRowCount();
        for (int f=0; f<fila; f++){
            String IdVentas = String.valueOf(idventa);
            String IdProducto = String.valueOf(tblDetalleProducto.getModel().getValueAt(f, 0));
            String Cantidad = String.valueOf(tblDetalleProducto.getModel().getValueAt(f, 4));
            String Costo = String.valueOf(tblDetalleProducto.getModel().getValueAt(f, 5));
            String Total = String.valueOf(tblDetalleProducto.getModel().getValueAt(f, 6));
            
           if (num == 0) {
            Detallecompras.GuardarDetalleCompras(IdVentas, IdProducto, Cantidad, Costo, Total);
            
        }
           try{
                Metodos_Productos oProducto=new Metodos_Productos();
                
                rs= oProducto.listarProductoActivoPorParametro("id",((String) tblDetalleProducto.getValueAt(f, 0)));
                while (rs.next()) {

                            cant=Double.parseDouble(rs.getString(4));
                }
                

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,ex.getMessage());
                System.out.println(ex.getMessage());
            }                   
            
        Metodos_Productos oProducto=new Metodos_Productos();
        
        strId =  ((String) tblDetalleProducto.getValueAt(f, 0));
        ncant=Double.parseDouble(String.valueOf(tblDetalleProducto.getModel().getValueAt(f, 4)));
        stock=cant+ncant;
        
        String Producto = String.valueOf(stock);
        if (num == 0) {
        oProducto.actualizarProductoStock(strId, Producto);
        }
    }
    }    
 public String generarIdCompra() {

        Metodos_Compra oCompra = new Metodos_Compra();
        try {

            rs = oCompra.obtenerUltimoIdCompra();
            while (rs.next()) {
                if (rs.getString(1) != null) {
                    Scanner s = new Scanner(rs.getString(1));
                    int c = s.useDelimiter("C").nextInt() + 1;

                    if (c < 10) {
                        return "" + c;
                    }
                    if (c < 100) {
                        return "" + c;
                    }
                    if (c < 1000) {
                        return "" + c;
                    }
                    if (c < 10000) {
                        return "" + c;
                    } else {
                        return "C" + c;
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return "1";

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnBuscarComprobante;
    private javax.swing.JButton btnBuscarProducto;
    private javax.swing.JButton btnBuscarProveedor;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiarTabla;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JLabel lblIdProducto;
    public static javax.swing.JLabel lblIdProveedor;
    private javax.swing.JTable tblDetalleProducto;
    public static javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCantidadProducto;
    public static javax.swing.JTextField txtCodigoProducto;
    public static javax.swing.JTextField txtComprobante;
    public static javax.swing.JTextField txtConcentracionProducto;
    public static javax.swing.JLabel txtDescripcionProducto;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFechas;
    private javax.swing.JTextField txtIGV;
    public static javax.swing.JTextField txtIdComprobante;
    public static javax.swing.JTextField txtIdEmpleado;
    public static javax.swing.JTextField txtIdProveedor;
    public static javax.swing.JTextField txtNombreProducto;
    public static javax.swing.JTextField txtNombreProveedor;
    public static javax.swing.JTextField txtNumeroCompra;
    public static javax.swing.JTextField txtPrecioProducto;
    public static javax.swing.JTextField txtPresentacionProducto;
    public static javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTipoPago;
    private javax.swing.JTextField txtTotalCompra;
    private javax.swing.JTextField txtTotalProducto;
    public static javax.swing.JTextField txtUltimoId;
    // End of variables declaration//GEN-END:variables
}
