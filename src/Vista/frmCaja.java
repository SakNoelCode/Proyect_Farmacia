
package Vista;

import Metodos.Metodos_Ventas;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


public class frmCaja extends javax.swing.JInternalFrame {
    static ResultSet rs=null;
    DefaultTableModel dtm=new DefaultTableModel();
    Date fecha_ini,fecha_fin;
    
    public frmCaja() {
        initComponents();
        //---------------------ANCHO Y ALTO DEL FORM----------------------
        this.setSize(566, 548);

        //---------------------FECHA ACTUAL-------------------------------
        Date date=new Date();
        String format=new String("dd/MM/yyyy");
        SimpleDateFormat formato=new SimpleDateFormat(format);
        dcFecha.setDate(date);

        txtIngreso.setEditable(false);
        txtCantidad.setEditable(false);
        txtGanancia.setEditable(false);
        txtTotal.setEditable(false);
        
        BuscarIngresos();
        CrearTabla(); 
        VentasTotal();
        CantidadVenta();
        GananciaVenta();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        dcFecha = new com.toedter.calendar.JDateChooser();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblVenta = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIngreso = new jtextfieldround.JTextFieldRound();
        txtGanancia = new jtextfieldround.JTextFieldRound();
        txtCantidad = new jtextfieldround.JTextFieldRound();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCalcular = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        txtTotal = new jtextfieldround.JTextFieldRound();

        setBackground(new java.awt.Color(251, 248, 248));
        setClosable(true);
        setIconifiable(true);
        setTitle("Resumen de caja");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("FECHA:");

        dcFecha.setDateFormatString("yyy-MM-dd");
        dcFecha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));

        tblVenta = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
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
        jScrollPane5.setViewportView(tblVenta);

        jPanel1.setBackground(new java.awt.Color(251, 248, 248));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Resumen diario", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(51, 0, 0))); // NOI18N
        jPanel1.setToolTipText("");
        jPanel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Ingreso por ventas:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(16, 27, 120, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Cant. de Productos:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 80, 120, 14);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Ganancia:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 120, 70, 30);

        txtIngreso.setText("0.0");
        txtIngreso.setBackground(new java.awt.Color(240, 240, 240));
        txtIngreso.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jPanel1.add(txtIngreso);
        txtIngreso.setBounds(140, 20, 80, 28);

        txtGanancia.setText("0.0");
        txtGanancia.setBackground(new java.awt.Color(240, 240, 240));
        txtGanancia.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        txtGanancia.setForeground(new java.awt.Color(102, 0, 0));
        jPanel1.add(txtGanancia);
        txtGanancia.setBounds(140, 120, 80, 28);

        txtCantidad.setText("0");
        txtCantidad.setBackground(new java.awt.Color(240, 240, 240));
        txtCantidad.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jPanel1.add(txtCantidad);
        txtCantidad.setBounds(140, 70, 80, 28);

        jLabel5.setFont(new java.awt.Font("AR JULIAN", 1, 12)); // NOI18N
        jLabel5.setText("TOTAL EN CAJA:");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/caja2.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(251, 248, 248));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        btnCalcular.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCalcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/vuelto.png"))); // NOI18N
        btnCalcular.setText("Calcular Ingresos");
        btnCalcular.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });
        jPanel2.add(btnCalcular);

        btnVentas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/CyV.png"))); // NOI18N
        btnVentas.setText("Ventas Realizadas");
        btnVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        txtTotal.setText("0.0");
        txtTotal.setBackground(new java.awt.Color(255, 204, 204));
        txtTotal.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        BuscarIngresos();
        CrearTabla();
        VentasTotal();
        CantidadVenta();
        GananciaVenta();
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed
       TotalVentasRealizadas ventas=new Vista.TotalVentasRealizadas();
        frmPrincipal.tbn_escritorio.add(ventas);
        ventas.show();
    }//GEN-LAST:event_btnVentasActionPerformed

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
                    if(column==0 || column==2 || column==3 || column==4 || column==5){
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
        
       
        for (int i=0;i<tblVenta.getColumnCount();i++){
            tblVenta.getColumnModel().getColumn(i).setCellRenderer(render);
        }
      
       
        tblVenta.setAutoResizeMode(tblVenta.AUTO_RESIZE_OFF);

        //Anchos de cada columna
        int[] anchos = {60,185,70,70,70,70};
        for(int i = 0; i < tblVenta.getColumnCount(); i++) {
            tblVenta.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }

    }
  void BuscarIngresos(){
        String titulos[]={"Cantidad","Producto","Precio","Importe","Ganancia","Fecha"};
        dtm.setColumnIdentifiers(titulos);
        
        Metodos_Ventas venta=new Metodos_Ventas();

        fecha_ini=dcFecha.getDate();
      

        try{
            rs=venta.listarVentaPorFecha("caja",fecha_ini,fecha_ini);
            boolean encuentra=false;
            String Datos[]=new String[6];
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
    void VentasTotal(){
        Double Total_venta=0.0;    
        int fila = 0;
        fila = dtm.getRowCount();
        for (int f=0; f<fila; f++){
            Total_venta += Double.parseDouble(String.valueOf(tblVenta.getModel().getValueAt(f, 3)));            
        }
        txtIngreso.setText(String.valueOf(Total_venta));
        txtTotal.setText(String.valueOf(Total_venta));
    }
    void CantidadVenta(){
        int cantidad=0;    
        int fila = 0;
        fila = dtm.getRowCount();
        for (int f=0; f<fila; f++){
            cantidad += Integer.parseInt(String.valueOf(tblVenta.getModel().getValueAt(f, 0)));            
        }
        txtCantidad.setText(String.valueOf(cantidad));
    }
    void GananciaVenta(){
        Double ganancia=0.0;    
        int fila = 0;
        fila = dtm.getRowCount();
        for (int f=0; f<fila; f++){
            ganancia += Double.parseDouble(String.valueOf(tblVenta.getModel().getValueAt(f, 4)));            
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
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnVentas;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tblVenta;
    private jtextfieldround.JTextFieldRound txtCantidad;
    private jtextfieldround.JTextFieldRound txtGanancia;
    private jtextfieldround.JTextFieldRound txtIngreso;
    private jtextfieldround.JTextFieldRound txtTotal;
    // End of variables declaration//GEN-END:variables
}
