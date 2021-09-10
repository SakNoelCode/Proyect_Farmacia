package Vista;

import Conexion.ConexionBD;
import Metodos.Metodos_Empleados;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class frmEmpleados extends javax.swing.JInternalFrame {

    private final Metodos_Empleados CP = new Metodos_Empleados();
    int nums = 0;

    DefaultTableModel model;

    public frmEmpleados() {
        initComponents();

        txtIdUsuario.setVisible(false);
        mirar();
        listar();
        cargar("");

    }

    Metodos_Empleados metodos = new Metodos_Empleados();

    private void listar() {
        jtb_Empleados.setModel(CP.getDatos());
    }

    private void limpiar() {
        txtId.setText("");
        txtNombre.setText("");
        txtApellidos.setText("");
        jcb_Sexo.setSelectedIndex(0);
        txtDni.setText("");
        txtEmail.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtEspecialidad.setText("");
        txtIngreso.setText("");
        txtSalida.setText("");
        txtSueldo.setText("");
        chbEstado.setSelected(false);

    }

    void mirar() {
        txtNombre.setEnabled(false);
        txtApellidos.setEnabled(false);
        jcb_Sexo.setEnabled(false);
        txtDni.setEnabled(false);
        txtEmail.setEnabled(false);
        txtDireccion.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtEspecialidad.setEnabled(false);
        txtIngreso.setEnabled(false);
        txtSalida.setEnabled(false);
        txtSueldo.setEnabled(false);
        chbEstado.setEnabled(false);

        btnguardar.setEnabled(false);
        btnEliminar.setEnabled(false);
        btncancelar.setEnabled(false);
        btnRegresar.setEnabled(true);
    }

    void nuevo() {
        txtNombre.setEnabled(true);
        txtApellidos.setEnabled(true);
        jcb_Sexo.setEnabled(true);
        txtDni.setEnabled(true);
        txtEmail.setEnabled(true);
        txtDireccion.setEnabled(true);
        txtTelefono.setEnabled(true);
        txtEspecialidad.setEnabled(true);
        txtIngreso.setEnabled(true);
        txtSalida.setEnabled(true);
        txtSueldo.setEnabled(true);
        chbEstado.setEnabled(true);

        btnguardar.setEnabled(true);
        btnEliminar.setEnabled(true);
        btncancelar.setEnabled(true);

        btnRegresar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnmodificar = new javax.swing.JMenuItem();
        mneliminar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcb_Sexo = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        chbEstado = new javax.swing.JCheckBox();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtId = new jtextfieldround.JTextFieldRound();
        txtNombre = new jtextfieldround.JTextFieldRound();
        txtApellidos = new jtextfieldround.JTextFieldRound();
        txtDni = new jtextfieldround.JTextFieldRound();
        txtEmail = new jtextfieldround.JTextFieldRound();
        txtDireccion = new jtextfieldround.JTextFieldRound();
        txtTelefono = new jtextfieldround.JTextFieldRound();
        txtEspecialidad = new jtextfieldround.JTextFieldRound();
        txtSueldo = new jtextfieldround.JTextFieldRound();
        txtIngreso = new jtextfieldround.JTextFieldRound();
        txtSalida = new jtextfieldround.JTextFieldRound();
        jPanel2 = new javax.swing.JPanel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        txtIdUsuario = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtb_Empleados = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        btnbuscar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        txtBuscar = new jtextfieldround.JTextFieldRound();

        mnmodificar.setText("Modificar");
        mnmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnmodificarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnmodificar);

        mneliminar.setText("Eliminar");
        mneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mneliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mneliminar);

        setBackground(new java.awt.Color(210, 240, 240));
        setClosable(true);
        setIconifiable(true);
        setMinimumSize(new java.awt.Dimension(999, 730));
        setPreferredSize(new java.awt.Dimension(999, 730));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(251, 248, 248));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Empleado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 11), new java.awt.Color(0, 102, 102))); // NOI18N
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Id:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(56, 32, 17, 15);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Nombres:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(16, 72, 57, 15);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Apellidos:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(16, 114, 59, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("DNI:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(47, 207, 26, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Sexo:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(39, 156, 34, 15);

        jcb_Sexo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "⠀", "M", "F" }));
        jcb_Sexo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jcb_Sexo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jcb_SexoKeyPressed(evt);
            }
        });
        jPanel1.add(jcb_Sexo);
        jcb_Sexo.setBounds(83, 152, 76, 25);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Telefono:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(320, 160, 57, 15);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Email:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(340, 80, 35, 15);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("Direccion:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(320, 120, 59, 15);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("Especialidad:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(300, 210, 77, 15);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("Hora de Salida:");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(690, 120, 92, 15);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("Hora de Ingreso:");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(680, 80, 103, 15);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setText("Sueldo S/:");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(718, 163, 65, 15);

        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("*");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(290, 110, 20, 19);

        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setText("*");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(590, 110, 20, 14);

        jLabel17.setForeground(new java.awt.Color(0, 102, 102));
        jLabel17.setText("*");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(210, 205, 20, 10);

        jLabel18.setForeground(new java.awt.Color(0, 102, 102));
        jLabel18.setText("*");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(590, 70, 10, 14);

        jLabel19.setForeground(new java.awt.Color(0, 102, 102));
        jLabel19.setText("*");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(287, 64, 18, 17);

        jLabel20.setForeground(new java.awt.Color(0, 102, 102));
        jLabel20.setText("*");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(560, 150, 30, 10);

        jLabel21.setForeground(new java.awt.Color(0, 102, 102));
        jLabel21.setText("*");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(910, 70, 16, 14);

        jLabel22.setForeground(new java.awt.Color(0, 102, 102));
        jLabel22.setText("*");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(560, 202, 23, 14);

        jLabel23.setForeground(new java.awt.Color(0, 102, 102));
        jLabel23.setText("*");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(911, 111, 28, 14);

        jLabel24.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 102, 102));
        jLabel24.setText("* Campos Obligatorios");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(828, 239, 126, 14);

        jLabel27.setForeground(new java.awt.Color(0, 102, 102));
        jLabel27.setText("*");
        jPanel1.add(jLabel27);
        jLabel27.setBounds(163, 152, 6, 25);

        chbEstado.setForeground(new java.awt.Color(0, 102, 102));
        chbEstado.setText("Activo");
        chbEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(chbEstado);
        chbEstado.setBounds(793, 204, 55, 23);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 102, 102));
        jLabel25.setText("Estado:");
        jPanel1.add(jLabel25);
        jLabel25.setBounds(737, 207, 46, 15);

        jLabel26.setForeground(new java.awt.Color(0, 102, 102));
        jLabel26.setText("*");
        jPanel1.add(jLabel26);
        jLabel26.setBounds(910, 150, 28, 14);

        txtId.setEditable(false);
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdKeyPressed(evt);
            }
        });
        jPanel1.add(txtId);
        txtId.setBounds(80, 30, 100, 28);

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });
        jPanel1.add(txtNombre);
        txtNombre.setBounds(80, 70, 210, 28);

        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidosKeyPressed(evt);
            }
        });
        jPanel1.add(txtApellidos);
        txtApellidos.setBounds(80, 110, 210, 28);

        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDniKeyPressed(evt);
            }
        });
        jPanel1.add(txtDni);
        txtDni.setBounds(80, 200, 130, 28);

        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
        });
        jPanel1.add(txtEmail);
        txtEmail.setBounds(390, 70, 200, 28);

        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionKeyPressed(evt);
            }
        });
        jPanel1.add(txtDireccion);
        txtDireccion.setBounds(390, 110, 200, 28);

        txtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefonoKeyPressed(evt);
            }
        });
        jPanel1.add(txtTelefono);
        txtTelefono.setBounds(390, 150, 170, 28);

        txtEspecialidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEspecialidadKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEspecialidadKeyPressed(evt);
            }
        });
        jPanel1.add(txtEspecialidad);
        txtEspecialidad.setBounds(390, 200, 170, 28);

        txtSueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSueldoKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSueldoKeyPressed(evt);
            }
        });
        jPanel1.add(txtSueldo);
        txtSueldo.setBounds(790, 150, 120, 28);

        txtIngreso.setText("00:00 am");
        txtIngreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIngresoKeyPressed(evt);
            }
        });
        jPanel1.add(txtIngreso);
        txtIngreso.setBounds(790, 70, 120, 28);

        txtSalida.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSalidaKeyPressed(evt);
            }
        });
        jPanel1.add(txtSalida);
        txtSalida.setBounds(790, 110, 120, 28);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 52, 960, 260);

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnnuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnnuevo.setForeground(new java.awt.Color(0, 102, 102));
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (38).png"))); // NOI18N
        btnnuevo.setContentAreaFilled(false);
        btnnuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnnuevo.setFocusPainted(false);
        btnnuevo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (47).png"))); // NOI18N
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });
        jPanel2.add(btnnuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 150, -1));

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(0, 102, 102));
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (37).png"))); // NOI18N
        btnguardar.setContentAreaFilled(false);
        btnguardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnguardar.setFocusPainted(false);
        btnguardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (46).png"))); // NOI18N
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });
        btnguardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnguardarKeyPressed(evt);
            }
        });
        jPanel2.add(btnguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 170, -1));

        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(0, 102, 102));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (39).png"))); // NOI18N
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setFocusPainted(false);
        btnEliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (45).png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 190, -1));

        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(0, 102, 102));
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (41).png"))); // NOI18N
        btncancelar.setContentAreaFilled(false);
        btncancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncancelar.setFocusPainted(false);
        btncancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (44).png"))); // NOI18N
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 210, -1));

        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(0, 102, 102));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (42).png"))); // NOI18N
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.setFocusPainted(false);
        btnRegresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (43).png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 8, -1, 50));

        txtIdUsuario.setEditable(false);
        txtIdUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdUsuarioActionPerformed(evt);
            }
        });
        jPanel2.add(txtIdUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 25, -1));

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 620, 990, 80);

        jtb_Empleados = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        jtb_Empleados.setBackground(new java.awt.Color(251, 248, 248));
        jtb_Empleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtb_Empleados.setComponentPopupMenu(jPopupMenu1);
        jtb_Empleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtb_Empleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_EmpleadosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtb_Empleados);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 393, 960, 220);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("BUSCAR:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(30, 350, 60, 10);

        jPanel3.setBackground(new java.awt.Color(0, 102, 153));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Registro de Empleados");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(360, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addGap(350, 350, 350))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addContainerGap())
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 983, 51);

        btnbuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnbuscar.setForeground(new java.awt.Color(0, 102, 102));
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (36).png"))); // NOI18N
        btnbuscar.setContentAreaFilled(false);
        btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnbuscar.setFocusPainted(false);
        btnbuscar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (50).png"))); // NOI18N
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnbuscar);
        btnbuscar.setBounds(360, 320, 210, 70);

        btnImprimir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(0, 102, 102));
        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (40).png"))); // NOI18N
        btnImprimir.setContentAreaFilled(false);
        btnImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImprimir.setFocusPainted(false);
        btnImprimir.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/button (51).png"))); // NOI18N
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(btnImprimir);
        btnImprimir.setBounds(800, 320, 180, 70);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });
        getContentPane().add(txtBuscar);
        txtBuscar.setBounds(90, 340, 270, 28);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
    nuevo();
    jcb_Sexo.setSelectedIndex(0);
    txtIngreso.setText("0:00 am");
    txtSalida.setText("0:00 pm");
    txtId.setText("");
    txtNombre.setText("");
    txtApellidos.setText("");
    txtDni.setText("");
    txtEmail.setText("");
    txtDireccion.setText("");
    txtTelefono.setText("");
    txtEspecialidad.setText("");
    txtSueldo.setText("");
    txtNombre.requestFocus();
    chbEstado.setSelected(false);
}//GEN-LAST:event_btnnuevoActionPerformed

private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
    mirar();
}//GEN-LAST:event_btncancelarActionPerformed

private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
    //VALIDAR CAMPOS PARA QUE TODOS ESTEN LLENOS
    if (txtNombre.getText().isEmpty()
            || txtApellidos.getText().isEmpty() || txtDni.getText().isEmpty()
            || txtEmail.getText().isEmpty() || txtDireccion.getText().isEmpty()
            || txtTelefono.getText().isEmpty() || txtEspecialidad.getText().isEmpty() || txtSueldo.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos");
        /*----------------------------------------------------------------------------*/
    } else {
        String Id = txtId.getText();
        String Nombres = txtNombre.getText();
        String Apellidos = txtApellidos.getText();
        String Especialidad = txtEspecialidad.getText();
        String Sexo = jcb_Sexo.getSelectedItem().toString();
        int DNI = Integer.parseInt(txtDni.getText());
        int Telefono = Integer.parseInt(txtTelefono.getText());
        String Email = txtEmail.getText();
        String Direccion = txtDireccion.getText();
        String Ingreso = txtIngreso.getText();
        String Salida = txtSalida.getText();
        float Sueldo = Float.parseFloat(txtSueldo.getText());
        int Usuario = Integer.parseInt(txtIdUsuario.getText());
        String Estado;
        if (chbEstado.isSelected()) {
            Estado = "Activo";
        } else {
            Estado = "Inactivo";
        }
        if (nums == 0) {
            if (metodos.Email(txtEmail.getText())) {
                if (metodos.EmpleadoExistente(txtDni.getText()) == 0) {

                    int respuesta = metodos.guardarEmpleado(Nombres, Apellidos, Especialidad, Sexo, DNI, Email, Telefono, Direccion, Ingreso, Salida, Sueldo, Estado, Usuario);
                    if (respuesta > 0) {
                        listar();
                        limpiar();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "El empleado ya esta registrado");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El correo electrónico no es valido");
            }
        }

        if (nums != 0) {
            if (metodos.Email(txtEmail.getText())) {
                int respuesta = metodos.ActualizarEmpleado(Id, Nombres, Apellidos, Especialidad, Sexo, DNI, Email, Telefono, Direccion, Ingreso, Salida, Sueldo, Estado, Usuario);
                if (respuesta > 0) {
                    listar();
                    limpiar();
                    nums = 0;
                }

            } else {
                JOptionPane.showMessageDialog(null, "El correo electrónico no es valido");
            }
        }
    }
}//GEN-LAST:event_btnguardarActionPerformed

private void mneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mneliminarActionPerformed

}//GEN-LAST:event_mneliminarActionPerformed

private void mnmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnmodificarActionPerformed

}//GEN-LAST:event_mnmodificarActionPerformed

    private void jtb_EmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_EmpleadosMouseClicked
        int row = jtb_Empleados.getSelectedRow();
        txtId.setText(jtb_Empleados.getValueAt(row, 0).toString());
        txtNombre.setText(jtb_Empleados.getValueAt(row, 1).toString());
        txtApellidos.setText(jtb_Empleados.getValueAt(row, 2).toString());
        txtEspecialidad.setText(jtb_Empleados.getValueAt(row, 3).toString());
        jcb_Sexo.setSelectedItem(jtb_Empleados.getValueAt(row, 4).toString());
        txtDni.setText(jtb_Empleados.getValueAt(row, 5).toString());
        txtEmail.setText(jtb_Empleados.getValueAt(row, 6).toString());
        txtTelefono.setText(jtb_Empleados.getValueAt(row, 7).toString());
        txtDireccion.setText(jtb_Empleados.getValueAt(row, 8).toString());
        txtIngreso.setText(jtb_Empleados.getValueAt(row, 9).toString());
        txtSalida.setText(jtb_Empleados.getValueAt(row, 10).toString());
        txtSueldo.setText(jtb_Empleados.getValueAt(row, 11).toString());
        String est = jtb_Empleados.getValueAt(row, 12).toString();
        if (est.equals("Activo")) {
            chbEstado.setSelected(true);
        } else {
            chbEstado.setSelected(false);
        }

        nums = 1;
    }//GEN-LAST:event_jtb_EmpleadosMouseClicked

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        listar();
        txtBuscar.setText("");
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int fila = jtb_Empleados.getSelectedRowCount();
        if (fila < 1) {
            JOptionPane.showMessageDialog(null, "SELECCIONE UN REGISTRO DE LA TABLA");
        } else if(fila==1){
        int result = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el registro?", "Mensaje del Sistema", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            if (CP.EliminarEmpleado(jtb_Empleados.getValueAt(jtb_Empleados.getSelectedRow(), 0).toString()) > 0) {
                limpiar();
                listar();
            }
        }
        if (result == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Registro no Eliminado!");
        }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jcb_SexoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcb_SexoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtDni.requestFocus();

        }
    }//GEN-LAST:event_jcb_SexoKeyPressed

    private void btnguardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnguardarKeyPressed
         //VALIDAR CAMPOS PARA QUE TODOS ESTEN LLENOS
    if (txtNombre.getText().isEmpty()
            || txtApellidos.getText().isEmpty() || txtDni.getText().isEmpty()
            || txtEmail.getText().isEmpty() || txtDireccion.getText().isEmpty()
            || txtTelefono.getText().isEmpty() || txtEspecialidad.getText().isEmpty() || txtSueldo.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor rellene todos los campos");
        /*----------------------------------------------------------------------------*/
    } else {
        String Id = txtId.getText();
        String Nombres = txtNombre.getText();
        String Apellidos = txtApellidos.getText();
        String Especialidad = txtEspecialidad.getText();
        String Sexo = jcb_Sexo.getSelectedItem().toString();
        int DNI = Integer.parseInt(txtDni.getText());
        int Telefono = Integer.parseInt(txtTelefono.getText());
        String Email = txtEmail.getText();
        String Direccion = txtDireccion.getText();
        String Ingreso = txtIngreso.getText();
        String Salida = txtSalida.getText();
        float Sueldo = Float.parseFloat(txtSueldo.getText());
        int Usuario = Integer.parseInt(txtIdUsuario.getText());
        String Estado;
        if (chbEstado.isSelected()) {
            Estado = "Activo";
        } else {
            Estado = "Inactivo";
        }
        if (nums == 0) {
            if (metodos.Email(txtEmail.getText())) {
                if (metodos.EmpleadoExistente(txtDni.getText()) == 0) {

                    int respuesta = metodos.guardarEmpleado(Nombres, Apellidos, Especialidad, Sexo, DNI, Email, Telefono, Direccion, Ingreso, Salida, Sueldo, Estado, Usuario);
                    if (respuesta > 0) {
                        listar();
                        limpiar();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "El empleado ya esta registrado");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El correo electrónico no es valido");
            }
        }

        if (nums != 0) {
            if (metodos.Email(txtEmail.getText())) {
                int respuesta = metodos.ActualizarEmpleado(Id, Nombres, Apellidos, Especialidad, Sexo, DNI, Email, Telefono, Direccion, Ingreso, Salida, Sueldo, Estado, Usuario);
                if (respuesta > 0) {
                    listar();
                    limpiar();
                    nums = 0;
                }

            } else {
                JOptionPane.showMessageDialog(null, "El correo electrónico no es valido");
            }
        }
    }
    }//GEN-LAST:event_btnguardarKeyPressed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        JRReporte cr = new JRReporte();
        Connection con = null;
        try {
            con = ConexionBD.conectar();
            String ruta = System.getProperty("user.dir") + "\\src\\Reportes\\Empleado.jrxml";
            cr.abrirReporte(ruta, con);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnImprimirActionPerformed

    private void txtIdUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdUsuarioActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtNombre.requestFocus();

        }
    }//GEN-LAST:event_txtIdKeyPressed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtApellidos.requestFocus();

        }
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "Ingrese solo Letras");
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            jcb_Sexo.requestFocus();

        }
    }//GEN-LAST:event_txtApellidosKeyPressed

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "Ingrese solo Letras");
        }
    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtDniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtEmail.requestFocus();

        }
    }//GEN-LAST:event_txtDniKeyPressed

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

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtDireccion.requestFocus();

        }
    }//GEN-LAST:event_txtEmailKeyPressed

    private void txtDireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtTelefono.requestFocus();

        }
    }//GEN-LAST:event_txtDireccionKeyPressed

    private void txtTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtEspecialidad.requestFocus();

        }
    }//GEN-LAST:event_txtTelefonoKeyPressed

    private void txtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(null, "Ingrese solo Números");
        }
    }//GEN-LAST:event_txtTelefonoKeyTyped

    private void txtEspecialidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEspecialidadKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtIngreso.requestFocus();

        }
    }//GEN-LAST:event_txtEspecialidadKeyPressed

    private void txtEspecialidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEspecialidadKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();

            JOptionPane.showMessageDialog(null, "Ingrese solo Letras");
        }
    }//GEN-LAST:event_txtEspecialidadKeyTyped

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        cargar(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtSueldoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            btnguardar.requestFocus();

        }
    }//GEN-LAST:event_txtSueldoKeyPressed

    private void txtSueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoKeyTyped
        char c = evt.getKeyChar();
        if (Character.isLetter(c)) {
            getToolkit().beep();
            evt.consume();

            JOptionPane.showMessageDialog(null, "Ingrese solo Números");
        }
    }//GEN-LAST:event_txtSueldoKeyTyped

    private void txtIngresoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIngresoKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtSalida.requestFocus();

        }
    }//GEN-LAST:event_txtIngresoKeyPressed

    private void txtSalidaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalidaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtSueldo.requestFocus();

        }
    }//GEN-LAST:event_txtSalidaKeyPressed

    //METODO PARA BUSCAR REGISTROS
    //-------------------------------------------------------------------------------------------------------------------------------------------
    void cargar(String valor) {
        String mostrar = "SELECT * FROM empleado WHERE CONCAT(idEmpleado,Nombres,Apellidos, Especialidad, Sexo, Dni, Email, Telefono, Direccion, HoraIngreso, HoraSalida, Sueldo, Estado) LIKE '%" + valor + "%'";
        String[] titulos = {"idEmpleado", "Nombres", "Apellidos", "Especialidad", "Sexo", "Dni", "Email", "Telefono", "Direccion", "Ingreso", "Salida", "Sueldo", "Estado"};
        String[] Registros = new String[13];
        model = new DefaultTableModel(null, titulos);

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(mostrar);
            while (rs.next()) {
                Registros[0] = rs.getString("idEmpleado");
                Registros[1] = rs.getString("Nombres");
                Registros[2] = rs.getString("Apellidos");
                Registros[3] = rs.getString("Especialidad");
                Registros[4] = rs.getString("Sexo");
                Registros[5] = rs.getString("dni");
                Registros[6] = rs.getString("Email");
                Registros[7] = rs.getString("Telefono");
                Registros[8] = rs.getString("Direccion");
                Registros[9] = rs.getString("HoraIngreso");
                Registros[10] = rs.getString("HoraSalida");
                Registros[11] = rs.getString("Sueldo");
                Registros[12] = rs.getString("Estado");
                model.addRow(Registros);
            }
            jtb_Empleados.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(frmEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //-------------------------------------------------------------------------------------------------------------------------------------------


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JCheckBox chbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
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
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox jcb_Sexo;
    private javax.swing.JTable jtb_Empleados;
    private javax.swing.JMenuItem mneliminar;
    private javax.swing.JMenuItem mnmodificar;
    private jtextfieldround.JTextFieldRound txtApellidos;
    private jtextfieldround.JTextFieldRound txtBuscar;
    private jtextfieldround.JTextFieldRound txtDireccion;
    private jtextfieldround.JTextFieldRound txtDni;
    private jtextfieldround.JTextFieldRound txtEmail;
    private jtextfieldround.JTextFieldRound txtEspecialidad;
    private jtextfieldround.JTextFieldRound txtId;
    public static javax.swing.JTextField txtIdUsuario;
    private jtextfieldround.JTextFieldRound txtIngreso;
    private jtextfieldround.JTextFieldRound txtNombre;
    private jtextfieldround.JTextFieldRound txtSalida;
    private jtextfieldround.JTextFieldRound txtSueldo;
    private jtextfieldround.JTextFieldRound txtTelefono;
    // End of variables declaration//GEN-END:variables
ConexionBD cc = new ConexionBD();
    Connection cn = cc.conectar();
}
