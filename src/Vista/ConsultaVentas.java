
package Vista;
import Conexion.ConexionBD;
import Metodos.Metodos_Ventas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


public class ConsultaVentas extends javax.swing.JInternalFrame {

    public String estado = "ANULADO";
    static ResultSet rs=null;
    DefaultTableModel dtm=new DefaultTableModel();
    DefaultTableModel dtm1=new DefaultTableModel();
    String id[]=new String[50];
    static int intContador;
    Date fechaIni,fechaFin;
    String comprobante,criterio,busqueda,Total;
    boolean valor=true;
    int n=0;
    public ConsultaVentas() {
        initComponents();
        //lblIdVenta.setVisible(false);
        //---------------------ANCHO Y ALTO DEL FORM----------------------
        
        this.setSize(769, 368);
        //---------------------FECHA ACTUAL-------------------------------
        Date date=new Date();
        String format=new String("dd/MM/yyyy");
        SimpleDateFormat formato=new SimpleDateFormat(format);
        dcFechaini.setDate(date);
        dcFechafin.setDate(date);
        lblIdVenta.setVisible(false);
        lblComprobante.setVisible(false);
        BuscarVenta();
        CrearTabla(); 
        CantidadTotal();
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        tblVenta = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        dcFechaini = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        dcFechafin = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        lblIdVenta = new javax.swing.JLabel();
        lblComprobante = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblDetalleVenta = new javax.swing.JTable();
        lblEstado = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAnular = new javax.swing.JButton();
        btnReporte1 = new javax.swing.JButton();
        btnVerDetalle = new javax.swing.JButton();
        btnOcultar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("Consultar Ventas");
        setMinimumSize(new java.awt.Dimension(769, 338));
        setPreferredSize(new java.awt.Dimension(769, 368));
        getContentPane().setLayout(null);

        tblVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblVenta.setRowHeight(22);
        tblVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVentaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblVenta);

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(10, 110, 740, 170);

        jPanel1.setBackground(new java.awt.Color(251, 248, 248));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Buscar venta:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 51, 51))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jPanel1.setLayout(null);

        dcFechaini.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(dcFechaini);
        dcFechaini.setBounds(70, 40, 120, 25);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Desde:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 40, 70, 20);

        dcFechafin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(dcFechafin);
        dcFechafin.setBounds(260, 40, 120, 25);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 51));
        jLabel3.setText("Hasta:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(210, 40, 70, 20);
        jPanel1.add(lblIdVenta);
        lblIdVenta.setBounds(320, 20, 40, 20);
        jPanel1.add(lblComprobante);
        lblComprobante.setBounds(410, 30, 0, 40);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btn3.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btn4.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(390, 20, 130, 60);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 550, 90);
        jPanel1.getAccessibleContext().setAccessibleName("");

        tblDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDetalleVenta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblDetalleVenta.setRowHeight(22);
        tblDetalleVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetalleVentaMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblDetalleVenta);

        getContentPane().add(jScrollPane6);
        jScrollPane6.setBounds(10, 340, 720, 140);
        getContentPane().add(lblEstado);
        lblEstado.setBounds(290, 280, 230, 20);

        jPanel2.setBackground(new java.awt.Color(251, 248, 248));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Anular Venta:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 51, 51))); // NOI18N
        jPanel2.setLayout(null);

        btnAnular.setForeground(new java.awt.Color(153, 0, 0));
        btnAnular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (98).png"))); // NOI18N
        btnAnular.setContentAreaFilled(false);
        btnAnular.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAnular.setFocusPainted(false);
        btnAnular.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (100).png"))); // NOI18N
        btnAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnularActionPerformed(evt);
            }
        });
        jPanel2.add(btnAnular);
        btnAnular.setBounds(10, 20, 160, 60);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(570, 10, 180, 90);

        btnReporte1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReporte1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btn6.png"))); // NOI18N
        btnReporte1.setContentAreaFilled(false);
        btnReporte1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporte1.setFocusPainted(false);
        btnReporte1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btn5.png"))); // NOI18N
        btnReporte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporte1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnReporte1);
        btnReporte1.setBounds(0, 290, 160, 40);

        btnVerDetalle.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnVerDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btn9.png"))); // NOI18N
        btnVerDetalle.setContentAreaFilled(false);
        btnVerDetalle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerDetalle.setFocusPainted(false);
        btnVerDetalle.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btn8.png"))); // NOI18N
        btnVerDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetalleActionPerformed(evt);
            }
        });
        getContentPane().add(btnVerDetalle);
        btnVerDetalle.setBounds(610, 290, 150, 40);

        btnOcultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btn10.png"))); // NOI18N
        btnOcultar.setContentAreaFilled(false);
        btnOcultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnOcultar.setFocusPainted(false);
        btnOcultar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btn14.png"))); // NOI18N
        btnOcultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOcultarActionPerformed(evt);
            }
        });
        getContentPane().add(btnOcultar);
        btnOcultar.setBounds(610, 280, 150, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVentaMouseClicked
       int fila;
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        fila = tblVenta.getSelectedRow();

        if (fila == -1){
            JOptionPane.showMessageDialog(null, "Se debe seleccionar un registro");
        }else{
            defaultTableModel = (DefaultTableModel)tblVenta.getModel();
            //strCodigo =  ((String) defaultTableModel.getValueAt(fila, 0));
            lblIdVenta.setText((String) defaultTableModel.getValueAt(fila, 0));
            lblComprobante.setText((String) defaultTableModel.getValueAt(fila, 4));

        }
        BuscarVentaDetalle();
        CrearTablaDetalle();
    }//GEN-LAST:event_tblVentaMouseClicked

    private void tblDetalleVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetalleVentaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDetalleVentaMouseClicked

    private void btnAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnularActionPerformed

        if(lblIdVenta.getText().isEmpty()){

            JOptionPane.showMessageDialog(this, "¡Se debe seleccionar un registro de venta!");
        }else{
            int fila_s = tblVenta.getSelectedRow();
            String est_venta=String.valueOf(tblVenta.getModel().getValueAt(fila_s, 7));

            if(tblVenta.getSelectedRows().length > 0 ){
                if(!est_venta.equals("ANULADO")){
                    int result = JOptionPane.showConfirmDialog(this, "¿Desea anular la venta?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        Metodos_Ventas ventas=new Metodos_Ventas();
                        String Estado = estado;
                        ventas.actualizarVentaEstado(lblIdVenta.getText(), Estado);

                        BuscarVenta();
                        CrearTabla();
                    }
                    if (result == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(null, "Anulación Cancelada!");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "¡Esta venta ya ha sido ANULADA!");
                }
            }
        }
    }//GEN-LAST:event_btnAnularActionPerformed

    private void btnReporte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporte1ActionPerformed
       if(lblComprobante.getText().isEmpty()){

            JOptionPane.showMessageDialog(this, "¡Se debe seleccionar un registro de venta!");
        }else{
        JRReporte cr = new JRReporte();
        Connection con = null;
        try {
            con = ConexionBD.conectar();
            Map parametros = new HashMap();
            parametros.put("IdVenta", lblIdVenta.getText());
            parametros.put("Comprobante", lblComprobante.getText());
            String ruta = System.getProperty("user.dir") + "\\src\\Reportes\\Ventas.jrxml";
            cr.abrirReporte(ruta, con, parametros);
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el reporte de Ventas", "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }
    }//GEN-LAST:event_btnReporte1ActionPerformed

    private void btnVerDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetalleActionPerformed
        if(tblVenta.getSelectedRows().length > 0 ) {

            if(n==0){
                this.setSize(769, 519);
                n=1;
            }
            BuscarVentaDetalle();
            CrearTablaDetalle();
            btnOcultar.setVisible(true);
            btnVerDetalle.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null, "¡Se debe seleccionar un registro de venta!");
        }

    }//GEN-LAST:event_btnVerDetalleActionPerformed

    private void btnOcultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOcultarActionPerformed
        if(tblVenta.getSelectedRows().length > 0 ) {

            if(n==1){
                this.setSize(769, 368);
                n=0;
            }
            BuscarVentaDetalle();
            CrearTablaDetalle();
            btnOcultar.setVisible(false);
            btnVerDetalle.setVisible(true);
        }

    }//GEN-LAST:event_btnOcultarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       BuscarVenta();
        CrearTabla();
        CantidadTotal();
    }//GEN-LAST:event_jButton2ActionPerformed
    void CrearTabla(){

      
        TableCellRenderer render = new DefaultTableCellRenderer() { 

            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) { 
              
                JComponent jcomponent= null;
                if(value instanceof String){
                    jcomponent = new JLabel((String) value);
                    ((JLabel) jcomponent).setHorizontalAlignment(SwingConstants.CENTER);
                    ((JLabel) jcomponent).setSize(30, jcomponent.getWidth());
                    ((JLabel) jcomponent).setPreferredSize(new Dimension(6, jcomponent.getWidth()));
                }
                jcomponent.setBackground(Color.red);
            
//aqui obtengo el render de la calse superior 
                JLabel l = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
                //Determinar Alineaciones   
                if(column==0 || column==2 || column==4 || column==5 || column==6 || column==7 || column==8){
                        l.setHorizontalAlignment(SwingConstants.CENTER); 
                    }else{
                        l.setHorizontalAlignment(SwingConstants.LEFT);
                    }

                //Colores en Jtable        
                if (isSelected) {

                    l.setBackground(new Color(0, 102, 102));
                    l.setForeground(Color.WHITE); 
                }else{
                    l.setForeground(Color.BLACK);
                    if (row % 2 == 0) {
                        l.setBackground(Color.WHITE);
                    } else {

                        l.setBackground(new Color(240,240,240));
                    }
                }        
                return l; 
            } 
        }; 
        
        //Agregar Render
        for (int i=0;i<tblVenta.getColumnCount();i++){
            tblVenta.getColumnModel().getColumn(i).setCellRenderer(render);
        }
      
        //Activar ScrollBar
        tblVenta.setAutoResizeMode(tblVenta.AUTO_RESIZE_OFF);

        //Anchos de cada columna
        int[] anchos = {50,160,70,120,80,40,60,60,80};
        for(int i = 0; i < tblVenta.getColumnCount(); i++) {
            tblVenta.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }

    }
  void BuscarVenta(){
        String titulos[]={"ID","Cliente","Fecha","Empleado","Documento","Serie","Número","Estado","Total"};
        dtm.setColumnIdentifiers(titulos);
        
        Metodos_Ventas venta=new Metodos_Ventas();

        fechaIni=dcFechaini.getDate();
        fechaFin=dcFechafin.getDate();
        try{
            rs=venta.listarVentaPorFecha("Buscar",fechaIni,fechaFin);
            boolean encuentra=false;
            String Datos[]=new String[9];
            int f,i;
            f=dtm.getRowCount();
            if(f>0){
                for(i=0;i<f;i++){
                    dtm.removeRow(0);
                }
            }
            while(rs.next()){
                Datos[0]=(String) rs.getString(1);
                Datos[1]=(String) rs.getString(2);
                Datos[2]=(String) rs.getString(3);
                Datos[3]=(String) rs.getString(4);
                Datos[4]=(String) rs.getString(5);
                Datos[5]=(String) rs.getString(6);
                Datos[6]=(String) rs.getString(7);
                Datos[7]=(String) rs.getString(8);
                Datos[8]=(String) rs.getString(9);

                dtm.addRow(Datos);
                encuentra=true;

            }
            if(encuentra=false){
                JOptionPane.showMessageDialog(null, "¡No se encuentra!");
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        tblVenta.setModel(dtm);
    }
   
    void CrearTablaDetalle(){
   //--------------------PRESENTACION DE JTABLE DETALLE VENTA----------------------
      
        TableCellRenderer render = new DefaultTableCellRenderer() { 

            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) { 
                //aqui obtengo el render de la calse superior 
                JLabel l = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
                //Determinar Alineaciones   
                    if(column==0 || column==1 || column==2 || column==5 || column==6){
                        l.setHorizontalAlignment(SwingConstants.CENTER); 
                    }else{
                        l.setHorizontalAlignment(SwingConstants.LEFT);
                    }

                //Colores en Jtable        
                if (isSelected) {
                    l.setBackground(new Color(0, 102, 102));
                    //l.setBackground(new Color(168, 198, 238));
                    l.setForeground(Color.WHITE); 
                }else{
                    l.setForeground(Color.BLACK);
                    if (row % 2 == 0) {
                        l.setBackground(Color.WHITE);
                    } else {
                        //l.setBackground(new Color(232, 232, 232));
                        l.setBackground(new Color(240, 240, 240));
                    }
                }
                return l; 
            } 
        }; 
        
        //Agregar Render
        for (int i=0;i<tblDetalleVenta.getColumnCount();i++){
            tblDetalleVenta.getColumnModel().getColumn(i).setCellRenderer(render);
        }
      
        //Activar ScrollBar
        tblDetalleVenta.setAutoResizeMode(tblVenta.AUTO_RESIZE_OFF);

        //Anchos de cada columna
        int[] anchos = {50,60,80,200,200,60,60,60};
        for(int i = 0; i < tblDetalleVenta.getColumnCount(); i++) {
            tblDetalleVenta.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        //Ocultar Columnas
        ocultarColumnas(tblDetalleVenta,new int[]{1});
    }
  void BuscarVentaDetalle(){
        String titulos[]={"ID","ID Prod.","Presentacion","Descripción","Concentracion","Cantidad","Precio","Importe"};
        dtm1.setColumnIdentifiers(titulos);
        Metodos_Ventas detalleventa=new Metodos_Ventas ();
        busqueda=lblIdVenta.getText();

        try{
            rs=detalleventa.listarDetalleVentaPorParametro("id",busqueda);
            boolean encuentra=false;
            String Datos[]=new String[8];
            int f,i;
            f=dtm1.getRowCount();
            if(f>0){
                for(i=0;i<f;i++){
                    dtm1.removeRow(0);
                }
            }
            while(rs.next()){
                Datos[0]=(String) rs.getString(1);
                Datos[1]=(String) rs.getString(2);
                Datos[2]=(String) rs.getString(3);
                Datos[3]=(String) rs.getString(4);
                Datos[4]=(String) rs.getString(5);
                Datos[5]=(String) rs.getString(6);
                Datos[6]=(String) rs.getString(7);
                Datos[7]=(String) rs.getString(8);
                dtm1.addRow(Datos);
                encuentra=true;

            }
            if(encuentra=false){
                JOptionPane.showMessageDialog(null, "¡No se encuentra!");
            }

        }catch(Exception ex){
            ex.printStackTrace();
        }
        tblDetalleVenta.setModel(dtm1);
    }
    void CantidadTotal(){
        Total= String.valueOf(tblVenta.getRowCount());   
        lblEstado.setText("Se cargaron " + Total + " registros");      
    }
    private void ocultarColumnas(JTable tbl, int columna[]){
        for(int i=0;i<columna.length;i++)
        {
             tbl.getColumnModel().getColumn(columna[i]).setMaxWidth(0);
             tbl.getColumnModel().getColumn(columna[i]).setMinWidth(0);
             tbl.getTableHeader().getColumnModel().getColumn(columna[i]).setMaxWidth(0);
             tbl.getTableHeader().getColumnModel().getColumn(columna[i]).setMinWidth(0);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnular;
    private javax.swing.JButton btnOcultar;
    private javax.swing.JButton btnReporte1;
    private javax.swing.JButton btnVerDetalle;
    private com.toedter.calendar.JDateChooser dcFechafin;
    private com.toedter.calendar.JDateChooser dcFechaini;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblComprobante;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblIdVenta;
    private javax.swing.JTable tblDetalleVenta;
    private javax.swing.JTable tblVenta;
    // End of variables declaration//GEN-END:variables

}
