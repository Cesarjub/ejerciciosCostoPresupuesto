package Presupuestos;

//Cesar Julio Beltran - Costos y Presupuestos

import java.awt.Desktop;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class VentanaPrincipalSistema extends javax.swing.JFrame 
{
    public VentanaPrincipalSistema() 
    {
        initComponents();
     
        //
        this.setLocationRelativeTo(null); 
        
        vf = new VentanaFormulario(1);
        
        e1 = new PanelEjercicioUno();
        e2 = new PanelEjercicioDos();
        e3 = new PanelEjercicioTres();
        e4 = new PanelEjercicioCuatro();
        e5 = new PanelEjercicioCinco();
        e6 = new PanelEjercicioSeis();
        e7 = new PanelEjercicioSiete();
        e8 = new PanelEjercicioOcho();
        e9 = new PanelEjercicioNueve();
        pm = new PanelPresupuestoMaestro();
        
        panelPrincipal.addTab("tab2", e1);
        panelPrincipal.addTab("tab3", e2);
        panelPrincipal.addTab("tab4", e3);
        panelPrincipal.addTab("tab5", e4);
        panelPrincipal.addTab("tab6", e5);
        panelPrincipal.addTab("tab7", e6);
        panelPrincipal.addTab("tab8", e7);
        panelPrincipal.addTab("tab9", e8);
        panelPrincipal.addTab("tab10", e9);
        panelPrincipal.addTab("tab11", pm);
        
        //Icono de la Ventana
        try{
            Image image = new ImageIcon(this.getClass().getResource("/Imagenes/iconoSistema.png")).getImage(); 
            this.setIconImage(image);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Icono de la ventana+", 2);
        }  
    }
    
    public void setDejarVer()
    {
        e1.setDejarVer(); 
        e2.setDejarVer(); 
        e3.setDejarVer(); 
        e4.setDejarVer(); 
        e5.setDejarVer(); 
        e6.setDejarVer(); 
        e7.setDejarVer(); 
        e8.setDejarVer(); 
        e9.setDejarVer();          
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JTabbedPane();
        PanelMenu = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbEj1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        lbEj2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        lbEj3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        lbEj4 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        lbEj5 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        lbEj6 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        lbEj7 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        lbEj8 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbEj9 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbPM = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        barraOpciones = new javax.swing.JMenuBar();
        archivoMenu = new javax.swing.JMenu();
        menuInicio = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenuItem();
        ejerciciosMenu = new javax.swing.JMenu();
        menuEj1 = new javax.swing.JMenuItem();
        menuEj2 = new javax.swing.JMenuItem();
        menuEj3 = new javax.swing.JMenuItem();
        menuEj4 = new javax.swing.JMenuItem();
        menuEj5 = new javax.swing.JMenuItem();
        menuEj6 = new javax.swing.JMenuItem();
        menuEj7 = new javax.swing.JMenuItem();
        menuEj8 = new javax.swing.JMenuItem();
        menuEj9 = new javax.swing.JMenuItem();
        menuPresupuesto = new javax.swing.JMenuItem();
        ayudaMenu = new javax.swing.JMenu();
        menuTutorial = new javax.swing.JMenuItem();
        menuAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Presupuestos");
        setName("frameSistema"); // NOI18N
        setResizable(false);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        getContentPane().setLayout(null);

        panelPrincipal.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        PanelMenu.setBackground(new java.awt.Color(255, 255, 255));
        PanelMenu.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hola!");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 0, 90, 40);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoo.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(670, 0, 40, 40);

        PanelMenu.add(jPanel1);
        jPanel1.setBounds(0, 0, 730, 40);

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));
        PanelMenu.add(jPanel2);
        jPanel2.setBounds(0, 430, 740, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Presupuesto y punto de equilibrio");
        PanelMenu.add(jLabel2);
        jLabel2.setBounds(0, 50, 730, 30);

        lbEj1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEj1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ejercicioUno.png"))); // NOI18N
        lbEj1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbEj1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbEj1MouseClicked(evt);
            }
        });
        PanelMenu.add(lbEj1);
        lbEj1.setBounds(50, 120, 80, 80);
        PanelMenu.add(jSeparator1);
        jSeparator1.setBounds(50, 200, 80, 10);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Ejercicio 1");
        PanelMenu.add(jLabel5);
        jLabel5.setBounds(50, 200, 80, 30);

        lbEj2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEj2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ejercicioDos.png"))); // NOI18N
        lbEj2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbEj2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbEj2MouseClicked(evt);
            }
        });
        PanelMenu.add(lbEj2);
        lbEj2.setBounds(190, 120, 80, 80);
        PanelMenu.add(jSeparator2);
        jSeparator2.setBounds(330, 350, 80, 10);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Ejercicio 2");
        PanelMenu.add(jLabel7);
        jLabel7.setBounds(190, 200, 80, 30);

        lbEj3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEj3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ejercicioTres.png"))); // NOI18N
        lbEj3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbEj3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbEj3MouseClicked(evt);
            }
        });
        PanelMenu.add(lbEj3);
        lbEj3.setBounds(330, 120, 80, 80);
        PanelMenu.add(jSeparator3);
        jSeparator3.setBounds(330, 200, 80, 10);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Ejercicio 3");
        PanelMenu.add(jLabel9);
        jLabel9.setBounds(330, 200, 80, 30);

        lbEj4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEj4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ejercicioCuatro.png"))); // NOI18N
        lbEj4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbEj4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbEj4MouseClicked(evt);
            }
        });
        PanelMenu.add(lbEj4);
        lbEj4.setBounds(460, 120, 80, 80);
        PanelMenu.add(jSeparator4);
        jSeparator4.setBounds(460, 200, 80, 10);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Ejercicio 4");
        PanelMenu.add(jLabel11);
        jLabel11.setBounds(460, 200, 80, 30);

        lbEj5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEj5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ejercicioCinco.png"))); // NOI18N
        lbEj5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbEj5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbEj5MouseClicked(evt);
            }
        });
        PanelMenu.add(lbEj5);
        lbEj5.setBounds(590, 120, 80, 80);
        PanelMenu.add(jSeparator5);
        jSeparator5.setBounds(590, 200, 80, 10);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Ejercicio 5");
        PanelMenu.add(jLabel13);
        jLabel13.setBounds(590, 200, 80, 30);

        lbEj6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEj6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ejercicioSeis.png"))); // NOI18N
        lbEj6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbEj6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbEj6MouseClicked(evt);
            }
        });
        PanelMenu.add(lbEj6);
        lbEj6.setBounds(50, 270, 80, 80);
        PanelMenu.add(jSeparator6);
        jSeparator6.setBounds(190, 200, 80, 20);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Ejercicio 6");
        PanelMenu.add(jLabel15);
        jLabel15.setBounds(50, 350, 80, 30);

        lbEj7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEj7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ejercicioSiete.png"))); // NOI18N
        lbEj7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbEj7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbEj7MouseClicked(evt);
            }
        });
        PanelMenu.add(lbEj7);
        lbEj7.setBounds(190, 270, 80, 80);
        PanelMenu.add(jSeparator7);
        jSeparator7.setBounds(50, 350, 80, 10);
        PanelMenu.add(jSeparator8);
        jSeparator8.setBounds(590, 350, 80, 10);
        PanelMenu.add(jSeparator9);
        jSeparator9.setBounds(460, 350, 80, 10);
        PanelMenu.add(jSeparator10);
        jSeparator10.setBounds(190, 350, 80, 10);

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Ejercicio 7");
        PanelMenu.add(jLabel17);
        jLabel17.setBounds(190, 350, 80, 30);

        lbEj8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEj8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ejercicioOcho.png"))); // NOI18N
        lbEj8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbEj8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbEj8MouseClicked(evt);
            }
        });
        PanelMenu.add(lbEj8);
        lbEj8.setBounds(330, 270, 80, 80);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Ejercicio 8");
        PanelMenu.add(jLabel19);
        jLabel19.setBounds(330, 350, 80, 30);

        lbEj9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEj9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/EjercicioNueve.png"))); // NOI18N
        lbEj9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbEj9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbEj9MouseClicked(evt);
            }
        });
        PanelMenu.add(lbEj9);
        lbEj9.setBounds(460, 270, 80, 80);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Ejercicio 9");
        PanelMenu.add(jLabel21);
        jLabel21.setBounds(460, 350, 80, 30);

        lbPM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/EjercicioDiez.png"))); // NOI18N
        lbPM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbPM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbPMMouseClicked(evt);
            }
        });
        PanelMenu.add(lbPM);
        lbPM.setBounds(590, 270, 80, 80);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Presupuesto");
        PanelMenu.add(jLabel23);
        jLabel23.setBounds(590, 350, 80, 30);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("maestro");
        PanelMenu.add(jLabel24);
        jLabel24.setBounds(590, 370, 80, 14);

        panelPrincipal.addTab("tab1", PanelMenu);

        getContentPane().add(panelPrincipal);
        panelPrincipal.setBounds(0, 0, 740, 490);

        archivoMenu.setText("Archivo");
        archivoMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuInicio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        menuInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/opMenu.png"))); // NOI18N
        menuInicio.setText("Menu");
        menuInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuInicioActionPerformed(evt);
            }
        });
        archivoMenu.add(menuInicio);

        menuSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/opSalir.png"))); // NOI18N
        menuSalir.setText("Salir");
        menuSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        archivoMenu.add(menuSalir);

        barraOpciones.add(archivoMenu);

        ejerciciosMenu.setText("Ejercicios");
        ejerciciosMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuEj1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        menuEj1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/opEjercicio.png"))); // NOI18N
        menuEj1.setText("Ejercicio 1");
        menuEj1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuEj1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEj1ActionPerformed(evt);
            }
        });
        ejerciciosMenu.add(menuEj1);

        menuEj2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        menuEj2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/opEjercicio.png"))); // NOI18N
        menuEj2.setText("Ejercicio 2");
        menuEj2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuEj2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEj2ActionPerformed(evt);
            }
        });
        ejerciciosMenu.add(menuEj2);

        menuEj3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        menuEj3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/opEjercicio.png"))); // NOI18N
        menuEj3.setText("Ejercicio 3");
        menuEj3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuEj3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEj3ActionPerformed(evt);
            }
        });
        ejerciciosMenu.add(menuEj3);

        menuEj4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
        menuEj4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/opEjercicio.png"))); // NOI18N
        menuEj4.setText("Ejercicio 4");
        menuEj4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuEj4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEj4ActionPerformed(evt);
            }
        });
        ejerciciosMenu.add(menuEj4);

        menuEj5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_MASK));
        menuEj5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/opEjercicio.png"))); // NOI18N
        menuEj5.setText("Ejercicio 5");
        menuEj5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuEj5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEj5ActionPerformed(evt);
            }
        });
        ejerciciosMenu.add(menuEj5);

        menuEj6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, java.awt.event.InputEvent.CTRL_MASK));
        menuEj6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/opEjercicio.png"))); // NOI18N
        menuEj6.setText("Ejercicio 6");
        menuEj6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuEj6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEj6ActionPerformed(evt);
            }
        });
        ejerciciosMenu.add(menuEj6);

        menuEj7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_7, java.awt.event.InputEvent.CTRL_MASK));
        menuEj7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/opEjercicio.png"))); // NOI18N
        menuEj7.setText("Ejercicio 7");
        menuEj7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuEj7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEj7ActionPerformed(evt);
            }
        });
        ejerciciosMenu.add(menuEj7);

        menuEj8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_8, java.awt.event.InputEvent.CTRL_MASK));
        menuEj8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/opEjercicio.png"))); // NOI18N
        menuEj8.setText("Ejercicio 8");
        menuEj8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuEj8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEj8ActionPerformed(evt);
            }
        });
        ejerciciosMenu.add(menuEj8);

        menuEj9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_9, java.awt.event.InputEvent.CTRL_MASK));
        menuEj9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/opEjercicio.png"))); // NOI18N
        menuEj9.setText("Ejercicio 9");
        menuEj9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuEj9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuEj9ActionPerformed(evt);
            }
        });
        ejerciciosMenu.add(menuEj9);

        menuPresupuesto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        menuPresupuesto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/opPresupuesto.png"))); // NOI18N
        menuPresupuesto.setText("Presupuesto maestro");
        menuPresupuesto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuPresupuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPresupuestoActionPerformed(evt);
            }
        });
        ejerciciosMenu.add(menuPresupuesto);

        barraOpciones.add(ejerciciosMenu);

        ayudaMenu.setText("Ayuda");
        ayudaMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        menuTutorial.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        menuTutorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ayuda.png"))); // NOI18N
        menuTutorial.setText("Manual de usuario");
        menuTutorial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuTutorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTutorialActionPerformed(evt);
            }
        });
        ayudaMenu.add(menuTutorial);

        menuAcercaDe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        menuAcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/opAcerca.png"))); // NOI18N
        menuAcercaDe.setText("Acerca del sistema");
        menuAcercaDe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAcercaDeActionPerformed(evt);
            }
        });
        ayudaMenu.add(menuAcercaDe);

        barraOpciones.add(ayudaMenu);

        setJMenuBar(barraOpciones);

        setBounds(0, 0, 735, 500);
    }// </editor-fold>//GEN-END:initComponents

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        setDejarVer();
        System.exit(0);
    }//GEN-LAST:event_menuSalirActionPerformed

    private void menuAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAcercaDeActionPerformed
        VentanaAcercaSistema vas = new VentanaAcercaSistema();
        setDejarVer();
        vas.setVisible(true);        
    }//GEN-LAST:event_menuAcercaDeActionPerformed

    private void menuInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuInicioActionPerformed
        setDejarVer();
        panelPrincipal.setSelectedIndex(0);
    }//GEN-LAST:event_menuInicioActionPerformed

    private void lbEj1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEj1MouseClicked
        setDejarVer();
        panelPrincipal.setSelectedIndex(1);
    }//GEN-LAST:event_lbEj1MouseClicked

    private void menuEj1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEj1ActionPerformed
        setDejarVer();
        panelPrincipal.setSelectedIndex(1);
    }//GEN-LAST:event_menuEj1ActionPerformed

    private void menuEj2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEj2ActionPerformed
        setDejarVer();
        panelPrincipal.setSelectedIndex(2);
    }//GEN-LAST:event_menuEj2ActionPerformed

    private void lbEj2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEj2MouseClicked
        setDejarVer();
        panelPrincipal.setSelectedIndex(2);
    }//GEN-LAST:event_lbEj2MouseClicked

    private void lbEj7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEj7MouseClicked
        setDejarVer();
        panelPrincipal.setSelectedIndex(7);
    }//GEN-LAST:event_lbEj7MouseClicked

    private void menuEj7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEj7ActionPerformed
        setDejarVer();
        panelPrincipal.setSelectedIndex(7);
    }//GEN-LAST:event_menuEj7ActionPerformed

    private void lbEj8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEj8MouseClicked
        setDejarVer();
        panelPrincipal.setSelectedIndex(8);
    }//GEN-LAST:event_lbEj8MouseClicked

    private void menuEj8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEj8ActionPerformed
        setDejarVer();
        panelPrincipal.setSelectedIndex(8);
    }//GEN-LAST:event_menuEj8ActionPerformed

    private void lbEj9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEj9MouseClicked
        setDejarVer();
        panelPrincipal.setSelectedIndex(9);
    }//GEN-LAST:event_lbEj9MouseClicked

    private void menuEj9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEj9ActionPerformed
        setDejarVer();
        panelPrincipal.setSelectedIndex(9);
    }//GEN-LAST:event_menuEj9ActionPerformed

    private void lbEj3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEj3MouseClicked
        setDejarVer();
        panelPrincipal.setSelectedIndex(3);
    }//GEN-LAST:event_lbEj3MouseClicked

    private void lbEj4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEj4MouseClicked
        setDejarVer();
        panelPrincipal.setSelectedIndex(4);
    }//GEN-LAST:event_lbEj4MouseClicked

    private void lbEj5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEj5MouseClicked
        setDejarVer();
        panelPrincipal.setSelectedIndex(5);
    }//GEN-LAST:event_lbEj5MouseClicked

    private void lbEj6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEj6MouseClicked
        setDejarVer();
        panelPrincipal.setSelectedIndex(6);
    }//GEN-LAST:event_lbEj6MouseClicked

    private void menuEj3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEj3ActionPerformed
        setDejarVer();
        panelPrincipal.setSelectedIndex(3);
    }//GEN-LAST:event_menuEj3ActionPerformed

    private void menuEj4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEj4ActionPerformed
        setDejarVer();
        panelPrincipal.setSelectedIndex(4);
    }//GEN-LAST:event_menuEj4ActionPerformed

    private void menuEj5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEj5ActionPerformed
        setDejarVer();        
        panelPrincipal.setSelectedIndex(5);
    }//GEN-LAST:event_menuEj5ActionPerformed

    private void menuEj6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuEj6ActionPerformed
        setDejarVer();
        panelPrincipal.setSelectedIndex(6);
    }//GEN-LAST:event_menuEj6ActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
      if ((evt.getNewState() & VentanaPrincipalSistema.ICONIFIED) == VentanaPrincipalSistema.ICONIFIED)
      {
          setDejarVer();
      }
    }//GEN-LAST:event_formWindowStateChanged

    private void lbPMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbPMMouseClicked
        setDejarVer();
        panelPrincipal.setSelectedIndex(10);
    }//GEN-LAST:event_lbPMMouseClicked

    private void menuPresupuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPresupuestoActionPerformed
        setDejarVer();
        panelPrincipal.setSelectedIndex(10);
    }//GEN-LAST:event_menuPresupuestoActionPerformed

    private void menuTutorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTutorialActionPerformed
        try
        {
            //Creamos un archivo en la carpeta temporal de tu sistema operativo
            File temp = new File(System.getProperty("java.io.tmpdir") + "Manual_usuario.pdf");
            
            //Creamos un flujo de entrada al cual asignamos el valor del PDF que esta dentro del JAR
            InputStream flujoEntrada = this.getClass().getResourceAsStream("/Archivos/Manual_de_usuario.pdf");
            
            //Creamos un flujo de salida para poder escribir sobre el archivo temporal
            FileOutputStream flujoSalida = new FileOutputStream(temp);
            //Preparamos el temp para que se llene de la informacion de PDF dentro del jar
            FileWriter fw = new FileWriter(temp);
            //Creamos un arreglo de bytes generico que soporte un gran tamano 1KB * 512 B --> se usa para todo tipo de archivo  
            byte[] buffer = new byte[1024*512];
 
            int control; //para contar posiciones de byte
 
            //Mientras haya bytes por leer se ejecuta este bucle
            while ((control = flujoEntrada.read(buffer)) != -1){
                flujoSalida.write(buffer, 0, control);
            }
 
            //Cerramos y guardamos el archivo creado
            fw.close();
            flujoSalida.close();
            flujoEntrada.close();
 
            //Ahora ya tenemos en temp todo tu PDF descomprimido y lo podemos abrir
            Desktop.getDesktop().open(temp);
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Ejercicios pdf", 2);
        }
    }//GEN-LAST:event_menuTutorialActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipalSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipalSistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelMenu;
    private javax.swing.JMenu archivoMenu;
    private javax.swing.JMenu ayudaMenu;
    private javax.swing.JMenuBar barraOpciones;
    private javax.swing.JMenu ejerciciosMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lbEj1;
    private javax.swing.JLabel lbEj2;
    private javax.swing.JLabel lbEj3;
    private javax.swing.JLabel lbEj4;
    private javax.swing.JLabel lbEj5;
    private javax.swing.JLabel lbEj6;
    private javax.swing.JLabel lbEj7;
    private javax.swing.JLabel lbEj8;
    private javax.swing.JLabel lbEj9;
    private javax.swing.JLabel lbPM;
    private javax.swing.JMenuItem menuAcercaDe;
    private javax.swing.JMenuItem menuEj1;
    private javax.swing.JMenuItem menuEj2;
    private javax.swing.JMenuItem menuEj3;
    private javax.swing.JMenuItem menuEj4;
    private javax.swing.JMenuItem menuEj5;
    private javax.swing.JMenuItem menuEj6;
    private javax.swing.JMenuItem menuEj7;
    private javax.swing.JMenuItem menuEj8;
    private javax.swing.JMenuItem menuEj9;
    private javax.swing.JMenuItem menuInicio;
    private javax.swing.JMenuItem menuPresupuesto;
    private javax.swing.JMenuItem menuSalir;
    private javax.swing.JMenuItem menuTutorial;
    private javax.swing.JTabbedPane panelPrincipal;
    // End of variables declaration//GEN-END:variables
    PanelEjercicioUno e1;
    PanelEjercicioDos e2;
    PanelEjercicioTres e3;
    PanelEjercicioCuatro e4;
    PanelEjercicioCinco e5;
    PanelEjercicioSeis e6;
    PanelEjercicioSiete e7;
    PanelEjercicioOcho e8;
    PanelEjercicioNueve e9;
    PanelPresupuestoMaestro pm;
    VentanaFormulario vf;
}
