package Vista;

import Conexion.ConexionBD;
import Metodos.Metodos_User;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.*;


public class frmUsuarios extends javax.swing.JInternalFrame {
    String path="";
    String Id = "";
    private final Metodos_User CP = new Metodos_User();
    int nums = 0;

    DefaultTableModel model;

    public frmUsuarios() {
        initComponents();

        listar();

    }
    Metodos_User metodos = new Metodos_User();

    private void listar() {
        tbUsuario.setModel(CP.getDatos());
    }

    private void limpiar() {
        cboTipo.setSelectedIndex(0);
        txtID.setText("");
        txtDni.setText("");
        txtApellidos.setText("");
        txtNombres.setText("");
        txtEmail.setText("");
        txtUsuario.setText("");
        txtContraseña.setText("");
        txtDni.requestFocus();
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboTipo = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        chbEstado = new javax.swing.JCheckBox();
        txtID = new jtextfieldround.JTextFieldRound();
        txtDni = new jtextfieldround.JTextFieldRound();
        txtApellidos = new jtextfieldround.JTextFieldRound();
        txtNombres = new jtextfieldround.JTextFieldRound();
        txtEmail = new jtextfieldround.JTextFieldRound();
        txtUsuario = new jtextfieldround.JTextFieldRound();
        txtContraseña = new jtextfieldround.JTextFieldRound();
        btnPresentacion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuario = new javax.swing.JTable();
        btnaceptar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        txtImagen = new javax.swing.JTextField();
        btnImagen = new javax.swing.JButton();
        lblfoto = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnregistrar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtBuscar = new jtextfieldround.JTextFieldRound();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(995, 543));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(251, 248, 248));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos del Usuario:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 3, 11), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("Id:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(61, 31, 18, 16);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Email:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 180, 37, 16);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 51));
        jLabel3.setText("Contraseña:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 260, 80, 16);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setText("Tipo Usuario:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 300, 83, 16);

        cboTipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "⠀⠀⠀⠀⠀⠀⠀⠀", "Administrador", "Vendedor", " " }));
        cboTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoActionPerformed(evt);
            }
        });
        cboTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboTipoKeyPressed(evt);
            }
        });
        jPanel1.add(cboTipo);
        cboTipo.setBounds(120, 300, 132, 28);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setText("DNI:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(52, 67, 27, 16);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setText("Usuario:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(40, 220, 53, 16);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 51));
        jLabel8.setText("Apellidos:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(40, 100, 63, 16);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 51));
        jLabel9.setText("Nombres:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(40, 140, 61, 16);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 51));
        jLabel10.setText("Estado:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(40, 340, 49, 16);

        chbEstado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        chbEstado.setForeground(new java.awt.Color(0, 102, 102));
        chbEstado.setText("Activo");
        chbEstado.setContentAreaFilled(false);
        chbEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chbEstado.setFocusPainted(false);
        jPanel1.add(chbEstado);
        chbEstado.setBounds(120, 340, 61, 22);

        txtID.setEditable(false);
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIDKeyPressed(evt);
            }
        });
        jPanel1.add(txtID);
        txtID.setBounds(107, 27, 80, 25);

        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDniKeyPressed(evt);
            }
        });
        jPanel1.add(txtDni);
        txtDni.setBounds(107, 63, 130, 25);

        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidosKeyPressed(evt);
            }
        });
        jPanel1.add(txtApellidos);
        txtApellidos.setBounds(110, 100, 200, 25);

        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombresKeyPressed(evt);
            }
        });
        jPanel1.add(txtNombres);
        txtNombres.setBounds(110, 140, 200, 25);

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
        });
        jPanel1.add(txtEmail);
        txtEmail.setBounds(110, 180, 200, 25);

        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
        });
        jPanel1.add(txtUsuario);
        txtUsuario.setBounds(110, 220, 160, 25);

        txtContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraseñaKeyPressed(evt);
            }
        });
        jPanel1.add(txtContraseña);
        txtContraseña.setBounds(110, 260, 160, 25);

        btnPresentacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btn46.png"))); // NOI18N
        btnPresentacion.setBorderPainted(false);
        btnPresentacion.setContentAreaFilled(false);
        btnPresentacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPresentacion.setFocusPainted(false);
        btnPresentacion.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btn47.png"))); // NOI18N
        btnPresentacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPresentacionActionPerformed(evt);
            }
        });
        jPanel1.add(btnPresentacion);
        btnPresentacion.setBounds(180, 10, 64, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 60, 330, 380);

        tbUsuario = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tbUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUsuario);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(330, 60, 640, 208);

        btnaceptar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnaceptar.setForeground(new java.awt.Color(0, 153, 102));
        btnaceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btn17.png"))); // NOI18N
        btnaceptar.setContentAreaFilled(false);
        btnaceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnaceptar.setFocusPainted(false);
        btnaceptar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btn19.png"))); // NOI18N
        btnaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnaceptar);
        btnaceptar.setBounds(630, 270, 202, 50);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 51));
        jLabel7.setText("Buscar:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(357, 287, 49, 16);

        lblImagen.setText("Imagen:");
        getContentPane().add(lblImagen);
        lblImagen.setBounds(380, 360, 40, 14);
        getContentPane().add(txtImagen);
        txtImagen.setBounds(430, 350, 220, 20);

        btnImagen.setText("Agregar");
        btnImagen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenActionPerformed(evt);
            }
        });
        getContentPane().add(btnImagen);
        btnImagen.setBounds(660, 350, 71, 23);
        getContentPane().add(lblfoto);
        lblfoto.setBounds(804, 280, 170, 141);

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Registro de Usuarios");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(414, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addGap(350, 350, 350))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addContainerGap())
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1010, 51);

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));
        jPanel3.setLayout(null);

        btnregistrar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnregistrar.setForeground(new java.awt.Color(0, 153, 102));
        btnregistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btn12_1.png"))); // NOI18N
        btnregistrar.setContentAreaFilled(false);
        btnregistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnregistrar.setFocusPainted(false);
        btnregistrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btn22.png"))); // NOI18N
        btnregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarActionPerformed(evt);
            }
        });
        btnregistrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnregistrarKeyPressed(evt);
            }
        });
        jPanel3.add(btnregistrar);
        btnregistrar.setBounds(130, 0, 140, 60);

        btnNuevo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(0, 153, 102));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btn11_1.png"))); // NOI18N
        btnNuevo.setContentAreaFilled(false);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.setFocusPainted(false);
        btnNuevo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btn23.png"))); // NOI18N
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel3.add(btnNuevo);
        btnNuevo.setBounds(-10, 0, 147, 60);

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 153, 102));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btn13.png"))); // NOI18N
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setFocusPainted(false);
        btnEliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btn21.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEliminar);
        btnEliminar.setBounds(260, 0, 163, 60);

        btnImprimir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(0, 153, 102));
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btn16.png"))); // NOI18N
        btnImprimir.setContentAreaFilled(false);
        btnImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImprimir.setFocusPainted(false);
        btnImprimir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btn18.png"))); // NOI18N
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        jPanel3.add(btnImprimir);
        btnImprimir.setBounds(810, 0, 171, 60);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 153, 102));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btn15.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusPainted(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/btn20.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(400, 0, 174, 60);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 450, 1000, 70);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtBuscar);
        txtBuscar.setBounds(410, 280, 230, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarActionPerformed
    //VALIDAR CAMPOS PARA QUE TODOS ESTEN LLENOS
        if (txtDni.getText().isEmpty()
                || txtApellidos.getText().isEmpty() || txtNombres.getText().isEmpty()
                || txtEmail.getText().isEmpty() || txtUsuario.getText().isEmpty()
                || txtContraseña.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "POR FAVOR RELLENE TODOS LOS CAMPOS");

        } else {

            String ID = txtID.getText();
            String Nombres = txtNombres.getText();
            String Apellidos = txtApellidos.getText();
            String Dni = txtDni.getText();
            String Email = txtEmail.getText();
            String Usuario = txtUsuario.getText();
            String Contraseña = txtContraseña.getText();
            String TipoUsuario = cboTipo.getSelectedItem().toString();
//            String Foto = txtImagen.getText();
            String Estado;
            if (chbEstado.isSelected()) {
                Estado = "Activo";
            } else {
                Estado = "Inactivo";
            }

            if (nums == 0) {
                int respuesta = metodos.guardarUsuarios(Nombres, Apellidos, Dni, Email, Usuario, Contraseña, TipoUsuario, Estado);
                if (respuesta > 0) {
                    listar();

                    limpiar();
                }
            } else {
                int respuesta = metodos.ActualizarUsuarios(ID, Nombres, Apellidos, Dni, Email, Usuario, Contraseña, TipoUsuario, Estado);
                if (respuesta > 0) {
                    listar();
                    nums = 0;
                }
            }
        }
}//GEN-LAST:event_btnregistrarActionPerformed

private void btnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarActionPerformed
    listar();
    txtBuscar.setText("");
}//GEN-LAST:event_btnaceptarActionPerformed

    private void cboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTipoActionPerformed

    private void tbUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsuarioMouseClicked
        int row = tbUsuario.getSelectedRow();
//        Id=(tbUsuario.getValueAt(row, 0).toString());
        txtID.setText(tbUsuario.getValueAt(row, 0).toString());
        txtDni.setText(tbUsuario.getValueAt(row, 3).toString());
        txtApellidos.setText(tbUsuario.getValueAt(row, 2).toString());
        txtNombres.setText(tbUsuario.getValueAt(row, 1).toString());
        txtEmail.setText(tbUsuario.getValueAt(row, 4).toString());
        txtUsuario.setText(tbUsuario.getValueAt(row, 5).toString());
        txtContraseña.setText(tbUsuario.getValueAt(row, 6).toString());
        cboTipo.setSelectedItem(tbUsuario.getValueAt(row, 7).toString());
        String est = tbUsuario.getValueAt(row, 8).toString();
        if (est.equals("Activo")) {
            chbEstado.setSelected(true);
        } else {
            chbEstado.setSelected(false);
        }
//        String file = new String("/imgproductos/" + Id + ".jpg"); 
//     String master = System.getProperty("user.dir") + file;
//                  lblfoto.setIcon(new ImageIcon(master));
//            ImageIcon icon=new ImageIcon(master);
//            Image img=icon.getImage();
//            Image newimg = img.getScaledInstance(lblfoto.getWidth(),lblfoto.getHeight(),java.awt.Image.SCALE_SMOOTH);
//            ImageIcon newIcon= new ImageIcon(newimg);
//            lblfoto.setIcon(newIcon);
//            lblfoto.setSize(lblfoto.getWidth(), lblfoto.getHeight());
            
        nums = 1;
    }//GEN-LAST:event_tbUsuarioMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = tbUsuario.getSelectedRowCount();
        if (fila < 1) {
            JOptionPane.showMessageDialog(null, "SELECCIONE UN REGISTRO DE LA TABLA");
        } else if(fila==1){
        int result = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el registro?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            
            if (CP.EliminarUsuario(tbUsuario.getValueAt(tbUsuario.getSelectedRow(), 0).toString()) > 0) {
                limpiar();
                listar();
            }
        }
        if (result == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Registro no Eliminado!");
        }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         JRReporte cr = new JRReporte();
        Connection con = null;
        try {
            con = ConexionBD.conectar();
            String ruta = System.getProperty("user.dir") + "\\src\\Reportes\\Usuarios.jrxml"; 
            cr.abrirReporte(ruta, con);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cboTipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboTipoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            btnregistrar.requestFocus();

        }
    }//GEN-LAST:event_cboTipoKeyPressed

    private void btnregistrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnregistrarKeyPressed
        //VALIDAR CAMPOS PARA QUE TODOS ESTEN LLENOS
        if (txtDni.getText().isEmpty()
                || txtApellidos.getText().isEmpty() || txtNombres.getText().isEmpty()
                || txtEmail.getText().isEmpty() || txtUsuario.getText().isEmpty()
                || txtContraseña.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "POR FAVOR RELLENE TODOS LOS CAMPOS");

        } else {

            String ID = txtID.getText();
            String Nombres = txtNombres.getText();
            String Apellidos = txtApellidos.getText();
            String Dni = txtDni.getText();
            String Email = txtEmail.getText();
            String Usuario = txtUsuario.getText();
            String Contraseña = txtContraseña.getText();
            String TipoUsuario = cboTipo.getSelectedItem().toString();
//            String Foto = txtImagen.getText();
            String Estado;
            if (chbEstado.isSelected()) {
                Estado = "Activo";
            } else {
                Estado = "Inactivo";
            }

            if (nums == 0) {
                int respuesta = metodos.guardarUsuarios(Nombres, Apellidos, Dni, Email, Usuario, Contraseña, TipoUsuario, Estado);
                if (respuesta > 0) {
                    listar();

                    limpiar();
                }
            } else {
                int respuesta = metodos.ActualizarUsuarios(ID, Nombres, Apellidos, Dni, Email, Usuario, Contraseña, TipoUsuario, Estado);
                if (respuesta > 0) {
                    listar();
                    nums = 0;
                }
            }
        }
    }//GEN-LAST:event_btnregistrarKeyPressed

    private void btnImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenActionPerformed
        // TODO add your handling code here:
        try {
            open();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btnImagenActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
    this.dispose();
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
       cargar(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIDKeyPressed
     if (evt.getKeyCode() == evt.VK_ENTER) {
            txtDni.requestFocus();

        }
    }//GEN-LAST:event_txtIDKeyPressed

    private void txtDniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyPressed
       if (evt.getKeyCode() == evt.VK_ENTER) {
            txtApellidos.requestFocus();

        }
    }//GEN-LAST:event_txtDniKeyPressed

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
       char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(null, "Ingrese solo Números");
        }
    }//GEN-LAST:event_txtDniKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
       char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "Ingrese solo Letras");
        }
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtApellidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyPressed
       if (evt.getKeyCode() == evt.VK_ENTER) {
            txtNombres.requestFocus();

        }
    }//GEN-LAST:event_txtApellidosKeyPressed

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "Ingrese solo Letras");
        }
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtNombresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtEmail.requestFocus();

        }
    }//GEN-LAST:event_txtNombresKeyPressed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
       if (evt.getKeyCode() == evt.VK_ENTER) {
            txtUsuario.requestFocus();

        }
    }//GEN-LAST:event_txtEmailKeyPressed

    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
      if (evt.getKeyCode() == evt.VK_ENTER) {
            txtContraseña.requestFocus();

        }
    }//GEN-LAST:event_txtUsuarioKeyPressed

    private void txtContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraseñaKeyPressed
      if (evt.getKeyCode() == evt.VK_ENTER) {
            cboTipo.requestFocus();

        }
    }//GEN-LAST:event_txtContraseñaKeyPressed

    private void btnPresentacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPresentacionActionPerformed

        BuscarEmpleados Presentacion = new BuscarEmpleados();
        frmPrincipal.tbn_escritorio.add(Presentacion);
        Presentacion.toFront();
        Presentacion.setVisible(true);
    }//GEN-LAST:event_btnPresentacionActionPerformed
    void open() throws IOException {
        
        JFileChooser JFC = new JFileChooser();
        
        JFC.setFileFilter(new FileNameExtensionFilter("todos los archivos *.jpg", "png","JPG"));
        
        int abrir = JFC.showDialog(null, "Abrir");
        if (abrir == JFileChooser.APPROVE_OPTION) {
            FileReader FR = null;
            BufferedReader BR = null;

            try {
                File archivo = JFC.getSelectedFile();
                
                String PATH = JFC.getSelectedFile().getAbsolutePath();
                if(PATH.endsWith(".jpg")||PATH.endsWith(".png")){
                    
                    FR = new FileReader(archivo);
                    BR = new BufferedReader(FR);
                    
                    
                    String linea;
                    if(path.compareTo(archivo.getAbsolutePath())==0){
                        System.out.println( "Archivo Abierto"+"Oops! Error"+ JOptionPane.ERROR_MESSAGE);
                    }else{
                        path = archivo.getAbsolutePath();
                        while((linea=BR.readLine())!=null){ 
                          
                        }
                    }
                    lblfoto.setIcon(new ImageIcon(path));
            ImageIcon icon=new ImageIcon(path);
            Image img=icon.getImage();
            Image newimg = img.getScaledInstance(lblfoto.getWidth(),lblfoto.getHeight(),java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon= new ImageIcon(newimg);
            lblfoto.setIcon(newIcon);
            lblfoto.setSize(lblfoto.getWidth(), lblfoto.getHeight());
                    
                }else{
                    System.out.println( "Archivo no soportado"+"Oops! Error"+ JOptionPane.ERROR_MESSAGE);
                    open();
                }

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                
            } finally {
                try {
                    if(null!= FR){
                        FR.close();
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private void save(){

        try {
                             String file = new String("/imgproductos/" + Id + ".jpg"); 
     String master = System.getProperty("user.dir") + file;
    
                 File source = new File(path);

        File dest = new File(master);

            System.out.println("origen :"+path+ "destino: "+master);
 

       

        long start = System.nanoTime();

        long end;
      
                copyFileUsingFileStreams(source, dest);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    private static void copyFileUsingFileStreams(File source, File dest)

        throws IOException {

    InputStream input = null;

    OutputStream output = null;

    try {

        input = new FileInputStream(source);

        output = new FileOutputStream(dest);

        byte[] buf = new byte[1024];

        int bytesRead;

        while ((bytesRead = input.read(buf)) > 0) {

            output.write(buf, 0, bytesRead);

        }

    } finally {

        input.close();

        output.close();

    }
}
    
    //METODO PARA BUSCAR REGISTROS
    //-------------------------------------------------------------------------------------------------------------------------------------------
    void cargar(String valor) {
        String mostrar = "SELECT * FROM usuario WHERE CONCAT(Nombres, Apellidos, Dni,Usuario, Contraseña, TipoUsuario, Estado) LIKE '%" + valor + "%'";
        String[] titulos = {"ID", "Nombres", "Apellidos", "Dni", "Email", "Usuario", "Contraseña", "Tipo Usuario", "Estado"};
        String[] Registros = new String[9];
        model = new DefaultTableModel(null, titulos);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("idUsuario");
                Registros[1] = rs.getString("Nombres");
                Registros[2] = rs.getString("Apellidos");
                Registros[3] = rs.getString("Dni");
                Registros[4] = rs.getString("Email");
                Registros[5] = rs.getString("Usuario");
                Registros[6] = rs.getString("Contraseña");
                Registros[7] = rs.getString("TipoUsuario");
                Registros[8] = rs.getString("Estado");
                model.addRow(Registros);
            }
            tbUsuario.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(frmClientes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //-------------------------------------------------------------------------------------------------------------------------------------------

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    public static javax.swing.JButton btnImagen;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPresentacion;
    private javax.swing.JButton btnaceptar;
    private javax.swing.JButton btnregistrar;
    private javax.swing.JComboBox cboTipo;
    private javax.swing.JCheckBox chbEstado;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblfoto;
    private javax.swing.JTable tbUsuario;
    public static jtextfieldround.JTextFieldRound txtApellidos;
    private jtextfieldround.JTextFieldRound txtBuscar;
    private jtextfieldround.JTextFieldRound txtContraseña;
    public static jtextfieldround.JTextFieldRound txtDni;
    public static jtextfieldround.JTextFieldRound txtEmail;
    public static jtextfieldround.JTextFieldRound txtID;
    public static javax.swing.JTextField txtImagen;
    public static jtextfieldround.JTextFieldRound txtNombres;
    private jtextfieldround.JTextFieldRound txtUsuario;
    // End of variables declaration//GEN-END:variables
    ConexionBD cc = new ConexionBD();
    Connection cn = cc.conectar();
    //String idfila = "";
}
