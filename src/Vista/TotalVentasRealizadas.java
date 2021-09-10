
package Vista;


import Conexion.ConexionBD;
import Metodos.Metodos_Ventas;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


public class TotalVentasRealizadas extends javax.swing.JInternalFrame {

    private Connection connection=new ConexionBD().conectar();
    static ResultSet rs=null;
    DefaultTableModel dtm=new DefaultTableModel();
    String id[]=new String[50];
    static int intContador;
    Date fechaIni,fechaFin;
    String documento,criterio,busqueda,Total;
    boolean valor=true;
    int n=0;
    
    public TotalVentasRealizadas() {
        initComponents();

        //---------------------ANCHO Y ALTO DEL FORM----------------------
        this.setSize(660, 448);

        //---------------------FECHA ACTUAL-------------------------------
        Date date=new Date();
        String format=new String("dd/MM/yyyy");
        SimpleDateFormat formato=new SimpleDateFormat(format);
        dcFechaini.setDate(date);
        dcFechafin.setDate(date);
        
        txtCantidad.setEditable(false);
        txtTotalVenta.setEditable(false);
        txtGanancia.setEditable(false);
        
        BuscarVenta();
        CrearTabla(); 
        CantidadTotal();
        VentasTotal();
        CantidadVenta();
        GananciaVenta();
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
        jButton1 = new javax.swing.JButton();
        lblEstado = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCantidad = new jtextfieldround.JTextFieldRound();
        jLabel4 = new javax.swing.JLabel();
        txtTotalVenta = new jtextfieldround.JTextFieldRound();
        jLabel5 = new javax.swing.JLabel();
        txtGanancia = new jtextfieldround.JTextFieldRound();

        setBackground(new java.awt.Color(251, 248, 248));
        setClosable(true);
        setIconifiable(true);
        setTitle("Ventas Realizadas");
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
        tblVenta.setRowHeight(22);
        tblVenta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVentaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblVenta);

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(10, 110, 622, 190);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        dcFechaini.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(dcFechaini);
        dcFechaini.setBounds(20, 40, 130, 25);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("DESDE:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(60, 20, 70, 20);

        dcFechafin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel1.add(dcFechafin);
        dcFechafin.setBounds(190, 40, 130, 25);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("HASTA:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(230, 20, 70, 20);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Pbuscar1.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(350, 20, 110, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 10, 600, 90);
        getContentPane().add(lblEstado);
        lblEstado.setBounds(10, 300, 230, 20);

        jPanel2.setBackground(new java.awt.Color(251, 248, 248));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("CANTIDAD:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 20));

        txtCantidad.setBackground(new java.awt.Color(240, 240, 240));
        txtCantidad.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jPanel2.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 120, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("TOTAL DE VENTAS:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 110, 20));

        txtTotalVenta.setBackground(new java.awt.Color(255, 255, 204));
        txtTotalVenta.setCaretColor(new java.awt.Color(102, 0, 0));
        txtTotalVenta.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        txtTotalVenta.setForeground(new java.awt.Color(153, 0, 0));
        jPanel2.add(txtTotalVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 120, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("GANANCIAS:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 90, 20));

        txtGanancia.setBackground(new java.awt.Color(240, 240, 240));
        txtGanancia.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        txtGanancia.setForeground(new java.awt.Color(0, 102, 102));
        jPanel2.add(txtGanancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 120, -1));

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 320, 620, 90);
        jPanel2.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblVentaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVentaMouseClicked

    }//GEN-LAST:event_tblVentaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        BuscarVenta();
        CrearTabla();
        CantidadTotal();
        VentasTotal();
        CantidadVenta();
        GananciaVenta();
    }//GEN-LAST:event_jButton1ActionPerformed
//-----------------------------------------------------------------------------------------------
//--------------------------------------METODOS--------------------------------------------------
//-----------------------------------------------------------------------------------------------

    void CrearTabla(){
   //--------------------PRESENTACION DE JTABLE----------------------
      
        TableCellRenderer render = new DefaultTableCellRenderer() { 

            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) { 
                //aqui obtengo el render de la calse superior 
                JLabel l = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
                //Determinar Alineaciones   
                    if(column==0 || column==4 || column==5 || column==6 || column==7 || column==8){
                        l.setHorizontalAlignment(SwingConstants.CENTER); 
                    }else{
                        l.setHorizontalAlignment(SwingConstants.LEFT);
                    }

                //Colores en Jtable        
                 if (isSelected) {
                   // l.setBackground(new Color(203, 159, 41));
                    l.setBackground(new Color(0, 102, 102));
                    l.setForeground(Color.WHITE); 
                }else{
                    l.setForeground(Color.BLACK);
                    if (row % 2 == 0) {
                        l.setBackground(Color.WHITE);
                    } else {
                        //l.setBackground(new Color(232, 232, 232));
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
        int[] anchos = {50,130,120,80,80,80,80,80};
        for(int i = 0; i < tblVenta.getColumnCount(); i++) {
            tblVenta.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        //Ocultar columnas
        ocultarColumnas(tblVenta,new int[]{3});

    }
  void BuscarVenta(){
        String titulos[]={"Código","Producto","Presentación","Costo","Precio","Cantidad","Total","Ganancia"};
        dtm.setColumnIdentifiers(titulos);
        
        Metodos_Ventas venta=new Metodos_Ventas();

        fechaIni=dcFechaini.getDate();
        fechaFin=dcFechafin.getDate();

        try{
            rs=venta.listarVentaPorDetalle("consultar",fechaIni,fechaFin);
            boolean encuentra=false;
            String Datos[]=new String[8];
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
    void VentasTotal(){
        Double Total_venta=0.0;    
        int fila = 0;
        fila = dtm.getRowCount();
        for (int f=0; f<fila; f++){
            Total_venta += Double.parseDouble(String.valueOf(tblVenta.getModel().getValueAt(f, 6)));            
        }
        txtTotalVenta.setText(String.valueOf(Total_venta));
    }
    void CantidadVenta(){
        int cantidad=0;    
        int fila = 0;
        fila = dtm.getRowCount();
        for (int f=0; f<fila; f++){
            cantidad += Integer.parseInt(String.valueOf(tblVenta.getModel().getValueAt(f, 5)));            
        }
        txtCantidad.setText(String.valueOf(cantidad));
    }
    void GananciaVenta(){
        Double ganancia=0.0;    
        int fila = 0;
        fila = dtm.getRowCount();
        for (int f=0; f<fila; f++){
            ganancia += Double.parseDouble(String.valueOf(tblVenta.getModel().getValueAt(f, 7)));            
        }
        txtGanancia.setText(String.valueOf(Truncar(ganancia,2)));
    }
    public double Truncar(double nD, int nDec)
    {
      if(nD > 0)
        nD = Math.floor(nD * Math.pow(10,nDec))/Math.pow(10,nDec);
      else
        nD = Math.ceil(nD * Math.pow(10,nDec))/Math.pow(10,nDec);

      return nD;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dcFechafin;
    private com.toedter.calendar.JDateChooser dcFechaini;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JTable tblVenta;
    private jtextfieldround.JTextFieldRound txtCantidad;
    private jtextfieldround.JTextFieldRound txtGanancia;
    private jtextfieldround.JTextFieldRound txtTotalVenta;
    // End of variables declaration//GEN-END:variables
}
