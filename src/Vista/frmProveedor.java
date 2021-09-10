
package Vista;

import Conexion.ConexionBD;
import Metodos.Metodos_Proveedor;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class frmProveedor extends javax.swing.JInternalFrame {

    private final Metodos_Proveedor CP = new Metodos_Proveedor();
    int nums = 0;
    DefaultTableModel modelo;

    String strCodigo;
    String accion;
    int registros;
    String id[] = new String[50];
    static int intContador;

    public String codigo;
    static Connection conn = null;
    static ResultSet rs = null;
    DefaultTableModel dtm = new DefaultTableModel();
    String criterio, busqueda;

    public frmProveedor() {
        initComponents();
        
        btnCancelar.setMnemonic(KeyEvent.VK_X);
//
//        buttonGroup1.add(rbtnCodigo);
//        buttonGroup1.add(rbtnNombre);
//        buttonGroup1.add(rbtnRuc);
//        buttonGroup1.add(rbtnDni);
        mirar();

        this.setSize(711, 429);
        CrearTabla();
        BuscarProveedor("");
    }

    Metodos_Proveedor metodos = new Metodos_Proveedor();

    private void listar() {
        tblProveedor.setModel(CP.getDatos());
    }

    void CrearTabla() {

        TableCellRenderer render = new DefaultTableCellRenderer() {

            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

                JLabel l = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (column == 0 || column == 2 || column == 3 || column == 5 || column == 6 || column == 8 || column == 9 || column == 10) {
                    l.setHorizontalAlignment(SwingConstants.CENTER);
                } else {
                    l.setHorizontalAlignment(SwingConstants.LEFT);
                }

                if (isSelected) {

                    l.setBackground(new Color(168, 198, 238));
                    l.setForeground(Color.WHITE);
                } else {
                    l.setForeground(Color.BLACK);
                    if (row % 2 == 0) {
                        l.setBackground(Color.WHITE);
                    } else {

                        l.setBackground(new Color(204, 255, 204));
                    }
                }
                return l;
            }
        };

        for (int i = 0; i < tblProveedor.getColumnCount(); i++) {
            tblProveedor.getColumnModel().getColumn(i).setCellRenderer(render);
        }

        tblProveedor.setAutoResizeMode(tblProveedor.AUTO_RESIZE_OFF);

        int[] anchos = {30, 200, 80, 80, 180, 70, 70, 150, 80, 80, 70, 200};
        for (int i = 0; i < tblProveedor.getColumnCount(); i++) {
            tblProveedor.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
    }

    void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtRuc.setText("");
        txtDni.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
        txtBanco.setText("");
        txtCuenta.setText("");
        chbEstado.setSelected(true);

//        rbtnCodigo.setSelected(false);
//        rbtnNombre.setSelected(false);
//        rbtnRuc.setSelected(false);
//        rbtnDni.setSelected(false);
        txtBusqueda.setText("");
    }

    void mirar() {
        tblProveedor.setEnabled(true);
        btnNuevo.setEnabled(true);
        btnModificar.setEnabled(true);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnSalir.setEnabled(true);

        txtNombre.setEnabled(false);
        txtRuc.setEnabled(false);
        txtDni.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtEmail.setEnabled(false);
        txtBanco.setEnabled(false);
        txtCuenta.setEnabled(false);
        chbEstado.setEnabled(false);

    }

    void modificar() {
        tblProveedor.setEnabled(false);
        btnNuevo.setEnabled(false);
        btnModificar.setEnabled(false);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        btnSalir.setEnabled(false);

        txtNombre.setEnabled(true);
        txtRuc.setEnabled(true);
        txtDni.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtEmail.setEnabled(true);
        txtBanco.setEnabled(true);
        txtCuenta.setEnabled(true);
        chbEstado.setEnabled(true);
        txtNombre.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        btnModificar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        tabProveedor = new javax.swing.JTabbedPane();
        pBuscar = new javax.swing.JPanel();
        btnReporte = new javax.swing.JButton();
        lblEstado = new javax.swing.JLabel();
        txtBusqueda = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProveedor = new javax.swing.JTable();
        pNuevo = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        chbEstado = new javax.swing.JRadioButton();
        txtTelefono = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtBanco = new javax.swing.JTextField();
        txtCuenta = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("Proveedores");
        getContentPane().setLayout(null);

        btnModificar.setBackground(new java.awt.Color(204, 255, 204));
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Ptodo.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificar.setIconTextGap(0);
        btnModificar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar);
        btnModificar.setBounds(600, 150, 81, 60);

        btnNuevo.setBackground(new java.awt.Color(204, 255, 204));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cmas.png"))); // NOI18N
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
        getContentPane().add(btnNuevo);
        btnNuevo.setBounds(600, 30, 81, 60);

        btnSalir.setBackground(new java.awt.Color(204, 255, 204));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Pvolv.png"))); // NOI18N
        btnSalir.setText("Volver");
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSalir.setIconTextGap(0);
        btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(600, 330, 81, 50);

        btnGuardar.setBackground(new java.awt.Color(204, 255, 204));
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
        getContentPane().add(btnGuardar);
        btnGuardar.setBounds(600, 90, 81, 60);

        tabProveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        pBuscar.setBackground(new java.awt.Color(255, 255, 255));
        pBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pBuscar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/print_1.png"))); // NOI18N
        btnReporte.setText("Reporte");
        btnReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        pBuscar.add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 28, 120, 50));
        pBuscar.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 200, 20));

        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });
        pBuscar.add(txtBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 380, -1));

        jLabel13.setBackground(new java.awt.Color(251, 248, 248));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Proveedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jLabel13.setOpaque(true);
        pBuscar.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 550, 80));

        tblProveedor.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblProveedor.setRowHeight(22);
        tblProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProveedorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProveedor);

        pBuscar.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 550, 230));

        tabProveedor.addTab("BUSCAR", pBuscar);

        pNuevo.setBackground(new java.awt.Color(255, 255, 255));
        pNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pNuevo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCodigo.setBackground(new java.awt.Color(251, 248, 248));
        txtCodigo.setEnabled(false);
        pNuevo.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 70, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("ID Proveedor:");
        pNuevo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 80, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nombre o Razón Social:");
        pNuevo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 140, 20));

        txtNombre.setBackground(new java.awt.Color(251, 248, 248));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        pNuevo.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 380, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("RUC:");
        pNuevo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 50, 20));

        txtRuc.setBackground(new java.awt.Color(251, 248, 248));
        txtRuc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRucKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRucKeyTyped(evt);
            }
        });
        pNuevo.add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 150, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Dirección:");
        pNuevo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 55, 20));

        txtDireccion.setBackground(new java.awt.Color(251, 248, 248));
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDireccionKeyReleased(evt);
            }
        });
        pNuevo.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 380, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Teléfono:");
        pNuevo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 60, 20));

        txtEmail.setBackground(new java.awt.Color(251, 248, 248));
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmailKeyReleased(evt);
            }
        });
        pNuevo.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, 150, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("DNI:");
        pNuevo.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 30, 20));

        txtDni.setBackground(new java.awt.Color(251, 248, 248));
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDniKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });
        pNuevo.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 150, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Email:");
        pNuevo.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 40, 20));

        chbEstado.setBackground(new java.awt.Color(204, 255, 204));
        chbEstado.setText("ACTIVO");
        chbEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chbEstado.setOpaque(false);
        pNuevo.add(chbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 70, -1));

        txtTelefono.setBackground(new java.awt.Color(251, 248, 248));
        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
        });
        pNuevo.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 150, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Banco de Referencia:");
        pNuevo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 130, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Nº Cuenta:");
        pNuevo.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 70, 20));

        txtBanco.setBackground(new java.awt.Color(251, 248, 248));
        txtBanco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBancoKeyReleased(evt);
            }
        });
        pNuevo.add(txtBanco, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 150, -1));

        txtCuenta.setBackground(new java.awt.Color(251, 248, 248));
        txtCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCuentaKeyReleased(evt);
            }
        });
        pNuevo.add(txtCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 150, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Estado:");
        pNuevo.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 50, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel1.setText("* Campos Obligatorios");
        pNuevo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 334, 130, 20));

        jLabel9.setText("*");
        pNuevo.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 20, -1));

        jLabel10.setText("*");
        pNuevo.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 20, -1));

        jLabel11.setText("*");
        pNuevo.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 220, 20, -1));

        jLabel16.setText("*");
        pNuevo.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 20, -1));

        jLabel17.setText("*");
        pNuevo.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 20, -1));

        jLabel18.setText("*");
        pNuevo.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 20, -1));

        jLabel19.setText("*");
        pNuevo.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 140, 20, -1));

        tabProveedor.addTab("Nuevo Proveedor", pNuevo);

        getContentPane().add(tabProveedor);
        tabProveedor.setBounds(10, 10, 575, 380);

        btnEliminar.setBackground(new java.awt.Color(204, 255, 204));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Delete1.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setIconTextGap(0);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(600, 270, 81, 60);

        btnCancelar.setBackground(new java.awt.Color(204, 255, 204));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/Cancel.png"))); // NOI18N
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
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(600, 210, 81, 60);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedorMouseClicked
        int row;
        row = tblProveedor.getSelectedRow();

        if (row == -1) {
            JOptionPane.showMessageDialog(null, "Se debe seleccionar un registro");
        } else {
            txtCodigo.setText(tblProveedor.getValueAt(row, 0).toString());
            txtNombre.setText(tblProveedor.getValueAt(row, 1).toString());
            txtDni.setText(tblProveedor.getValueAt(row, 2).toString());
            txtRuc.setText(tblProveedor.getValueAt(row, 3).toString());
            txtDireccion.setText(tblProveedor.getValueAt(row, 4).toString());
            txtEmail.setText(tblProveedor.getValueAt(row, 5).toString());
            txtTelefono.setText(tblProveedor.getValueAt(row, 6).toString());
            txtBanco.setText(tblProveedor.getValueAt(row, 7).toString());
            txtCuenta.setText(tblProveedor.getValueAt(row, 8).toString());
            String est = tblProveedor.getValueAt(row, 9).toString();
            if (est.equals("Activo")) {
                chbEstado.setSelected(true);
            } else {
                chbEstado.setSelected(false);
            }

        }

        mirar();
    }//GEN-LAST:event_tblProveedorMouseClicked

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        txtNombre.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (tblProveedor.getSelectedRows().length > 0) {
            accion = "Modificar";
            modificar();
            tabProveedor.setSelectedIndex(tabProveedor.indexOfComponent(pNuevo));
        } else {
            JOptionPane.showMessageDialog(null, "¡Se debe seleccionar un registro!");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        mirar();
        tabProveedor.setSelectedIndex(tabProveedor.indexOfComponent(pBuscar));

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        accion = "Nuevo";
        modificar();
        limpiarCampos();
        tblProveedor.setEnabled(false);
        tabProveedor.setSelectedIndex(tabProveedor.indexOfComponent(pNuevo));
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    public boolean validardatos() {
        if (txtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre o razón social del proveedor");
            txtNombre.requestFocus();
            txtNombre.setBackground(Color.YELLOW);
            return false;
        } else {
            return true;
        }

    }
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //VALIDAR CAMPOS PARA QUE TODOS ESTEN LLENOS
        if (validardatos() == true) {
            if (txtBanco.getText().isEmpty() || txtCuenta.getText().isEmpty()
                    || txtDireccion.getText().isEmpty()
                    || txtTelefono.getText().isEmpty() || txtRuc.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "POR FAVOR RELLENE TODOS LOS CAMPOS");
                /*----------------------------------------------------------------------------*/
            } else {

                String Codigo = txtCodigo.getText();
                String Nombre = txtNombre.getText();
                String Ruc = txtRuc.getText();
                String DNI = txtDni.getText();
                String Direccion = txtDireccion.getText();
                String Telefono = txtTelefono.getText();
                String Email = txtEmail.getText();
                String Banco = txtBanco.getText();
                String Cuenta = txtCuenta.getText();
                String Estado;
                if (chbEstado.isSelected()) {
                    Estado = "Activo";
                } else {
                    Estado = "Inactivo";
                }
                if (accion.equals("Nuevo")) {
                     if (metodos.Email(txtEmail.getText())) {
                    if (metodos.RucExistente(txtRuc.getText()) == 0) {
                    int respuesta = metodos.guardarProveedor(Nombre, DNI, Ruc, Direccion, Email, Telefono, Banco, Cuenta, Estado);
                    if (respuesta > 0) {
                        listar();

                        limpiarCampos();
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "El proveedor ya esta registrado");
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "El correo electrónico no es valido");
            } 
                } 
                if (accion.equals("Modificar")) {
                     if (metodos.Email(txtEmail.getText())) {
                    int respuesta = metodos.ActualizarProveedor(Codigo, Nombre, DNI, Ruc, Direccion, Email, Telefono, Banco, Cuenta, Estado);
                    if (respuesta > 0) {
                        listar();
                        nums = 0;
                    }
                    mirar();
                    tabProveedor.setSelectedIndex(tabProveedor.indexOfComponent(pBuscar));
                }else {
                JOptionPane.showMessageDialog(null, "El correo electrónico no es valido");
            } }
            
        }}
        BuscarProveedor("");
        btnNuevo.setEnabled(true);
        btnCancelar.setEnabled(true);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased

        BuscarProveedor(txtBusqueda.getText());
    }//GEN-LAST:event_txtBusquedaKeyReleased

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        String cadena = (txtNombre.getText()).toUpperCase();
        txtNombre.setText(cadena);
        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
            txtRuc.requestFocus();
        }
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtRucKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyReleased
        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
            txtDni.requestFocus();
        }
    }//GEN-LAST:event_txtRucKeyReleased

    private void txtDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyReleased
        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
            txtDireccion.requestFocus();
        }
    }//GEN-LAST:event_txtDniKeyReleased

    private void txtDireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyReleased
        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
            txtTelefono.requestFocus();
        }
    }//GEN-LAST:event_txtDireccionKeyReleased

    private void txtTelefonoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyReleased
        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
            txtEmail.requestFocus();
        }
    }//GEN-LAST:event_txtTelefonoKeyReleased

    private void txtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyReleased
        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
            txtBanco.requestFocus();
        }
    }//GEN-LAST:event_txtEmailKeyReleased

    private void txtBancoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBancoKeyReleased
        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
            txtCuenta.requestFocus();
        }
    }//GEN-LAST:event_txtBancoKeyReleased

    private void txtCuentaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuentaKeyReleased
        int keyCode = evt.getKeyCode();
        if (keyCode == KeyEvent.VK_ENTER) {
            btnGuardar.requestFocus();
        }
    }//GEN-LAST:event_txtCuentaKeyReleased

    private void txtRucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRucKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
        int i = txtRuc.getText().length();
        if (txtRuc.getText().trim().length() < 11) {

        } else {
            i = 10;
            String com = txtRuc.getText().substring(0, 10);
            txtRuc.setText("");
            txtRuc.setText(com);
        }
    }//GEN-LAST:event_txtRucKeyTyped

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
        int i = txtDni.getText().length();
        if (txtDni.getText().trim().length() < 8) {

        } else {
            i = 10;
            String com = txtDni.getText().substring(0, 7);
            txtDni.setText("");
            txtDni.setText(com);
        }
    }//GEN-LAST:event_txtDniKeyTyped

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        JRReporte cr = new JRReporte();
        Connection con = null;

        try {
            con = ConexionBD.conectar();
            Map parametros = new HashMap();
            parametros.put("Dni", txtDni.getText());
            String ruta = System.getProperty("user.dir") + "\\src\\Reportes\\Proveedores.jrxml";
            cr.abrirReporte(ruta, con, parametros);
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar el reporte de Empleados", "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tblProveedor.getSelectedRowCount();
        if (fila < 1) {
            JOptionPane.showMessageDialog(null, "Seleccione un registro de la tabla");
        } else if(fila==1){
        int result = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el registro?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            
            if (CP.EliminarProveedor(tblProveedor.getValueAt(tblProveedor.getSelectedRow(), 0).toString()) > 0) {
                limpiarCampos();
                listar();
            }
        }
        if (result == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Registro no Eliminado!");
        }
        }
    
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
        int i = txtTelefono.getText().length();
        if (txtTelefono.getText().trim().length() < 15) {

        } else {
            i = 10;
            String com = txtTelefono.getText().substring(0, 14);
            txtTelefono.setText("");
            txtTelefono.setText(com);
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped
    void BuscarProveedor(String buscar) {
        String[] titulos = {"Codigo", "Nombre", "DNI", "Ruc", "Direccion", "Email", "Telefono", "Banco", "Cuenta", "Estado"};
        String Sql = "SELECT * FROM proveedor WHERE CONCAT(IdProveedor, Nombre, Dni, Ruc, Direccion, Email, Telefono, Banco, Cuenta,Estado) LIKE '%" + buscar + "%'";
        modelo = new DefaultTableModel(null, titulos);
        String[] Registros = new String[10];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(Sql);
            while (rs.next()) {
                Registros[0] = rs.getString("IdProveedor");
                Registros[1] = rs.getString("Nombre");
                Registros[2] = rs.getString("Dni");
                Registros[3] = rs.getString("Ruc");
                Registros[4] = rs.getString("Direccion");
                Registros[5] = rs.getString("Email");
                Registros[6] = rs.getString("Telefono");
                Registros[7] = rs.getString("Banco");
                Registros[8] = rs.getString("Cuenta");
                Registros[9] = rs.getString("Estado");
                modelo.addRow(Registros);
            }
            tblProveedor.setModel(modelo);
            lblEstado.setText("Total de Registros: " + tblProveedor.getRowCount());
        } catch (SQLException ex) {
            Logger.getLogger(BuscarClientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnSalir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton chbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JPanel pBuscar;
    private javax.swing.JPanel pNuevo;
    private javax.swing.JTabbedPane tabProveedor;
    private javax.swing.JTable tblProveedor;
    private javax.swing.JTextField txtBanco;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCuenta;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
ConexionBD cc = new ConexionBD();
    Connection cn = cc.conectar();
}
