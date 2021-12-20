package Presupuestos;

//Cesar Julio Beltran - Costos y Presupuestos

import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.text.NumberFormat;
import javax.swing.JOptionPane;

public class PanelEjercicioDos extends javax.swing.JPanel 
{

    public PanelEjercicioDos() 
    {
        initComponents();
        
        formatoImporte = NumberFormat.getCurrencyInstance();
        formatoNumero = NumberFormat.getNumberInstance();
        
        gop = new GetOperaciones();
        vf = new VentanaFormulario(2);
        
        totalFijo.setEditable(false);
        totalVaria.setEditable(false);
        totalMercancia.setEditable(false);
        totalAdmin.setEditable(false);
        totalGasto.setEditable(false);
        totalCostos.setEditable(false);
        totalPunto.setEditable(false);
        totalUtilidad.setEditable(false);
        
        setBloquear();   
        setInicializar();
    }
    
    public void setInicializar()
    {
        mercanciaFijo.setText("550000");
        mercanciaVaria.setText("610000");
        adminFijo.setText("110000");
        adminVaria.setText("30000");
        ventaFijo.setText("185000");
        ventaVaria.setText("42000");
        textVentas.setText("2200000");
        textUtilidad.setText("673");
        unidadesVendidas.setText("11000");
        unidadesAntes.setText("200000");        
    }
    
    public void setBorrar()
    {
        totalFijo.setText(null);
        totalVaria.setText(null);
        totalMercancia.setText(null);
        totalAdmin.setText(null);
        totalGasto.setText(null);
        totalCostos.setText(null);
        totalPunto.setText(null);
        totalUtilidad.setText(null);
        mercanciaFijo.setText(null);
        mercanciaVaria.setText(null);
        adminFijo.setText(null);
        adminVaria.setText(null);
        ventaFijo.setText(null);
        ventaVaria.setText(null);
        textVentas.setText(null);
        textUtilidad.setText(null);
        unidadesVendidas.setText(null);
        unidadesAntes.setText(null);
    }
    
    public void setEditar()
    {
        mercanciaFijo.setEditable(true);
        mercanciaVaria.setEditable(true);
        adminFijo.setEditable(true);
        adminVaria.setEditable(true);
        ventaFijo.setEditable(true);
        ventaVaria.setEditable(true);
        textVentas.setEditable(true);
        textUtilidad.setEditable(true);
        unidadesVendidas.setEditable(true);
        unidadesAntes.setEditable(true);         
    }
    
    public void setBloquear()
    {
        mercanciaFijo.setEditable(false);
        mercanciaVaria.setEditable(false);
        adminFijo.setEditable(false);
        adminVaria.setEditable(false);
        ventaFijo.setEditable(false);
        ventaVaria.setEditable(false);
        textVentas.setEditable(false);
        textUtilidad.setEditable(false);
        unidadesVendidas.setEditable(false);
        unidadesAntes.setEditable(false);       
    }
    
    public void setOperaciones()
    {
        float tMC = 0.0f;
        
        tMC = Float.parseFloat(mercanciaFijo.getText()) + Float.parseFloat(mercanciaVaria.getText());
        
        totalMercancia.setText(formatoImporte.format(tMC));
        
        float tAD = 0.0f;
        
        tAD = Float.parseFloat(adminFijo.getText()) + Float.parseFloat(adminVaria.getText());
        
        totalAdmin.setText(formatoImporte.format(tAD)); 
        
        float tGT = 0.0f;
        
        tGT = Float.parseFloat(ventaFijo.getText()) + Float.parseFloat(ventaVaria.getText());
        
        totalGasto.setText(formatoImporte.format(tGT));         
        
        float tCT = 0.0f;
        
        tCT = tMC + tAD + tGT;
        
        totalCostos.setText(formatoImporte.format(tCT));  
        
        float tCF = 0.0f;
        
        tCF = (Float.parseFloat(adminFijo.getText())) + (Float.parseFloat(mercanciaFijo.getText())) + Float.parseFloat(ventaFijo.getText());
        
        totalFijo.setText(formatoImporte.format(tCF));   
        
        float tCV = 0.0f;
        
        tCV = Float.parseFloat(adminVaria.getText()) + Float.parseFloat(mercanciaVaria.getText()) + Float.parseFloat(ventaVaria.getText());
        
        totalVaria.setText(formatoImporte.format(tCV));          
    }
    
    public void setA()
    {
        float tCF = 0.0f;
        
        tCF = (Float.parseFloat(adminFijo.getText())) + (Float.parseFloat(mercanciaFijo.getText())) + Float.parseFloat(ventaFijo.getText());
        
        float pV = 0.0f; //200
        
        pV = Float.parseFloat(textVentas.getText()) / Float.parseFloat(unidadesVendidas.getText());
        
        float stCV = 0.0f;
        
        stCV = Float.parseFloat(adminVaria.getText()) + Float.parseFloat(mercanciaVaria.getText()) + Float.parseFloat(ventaVaria.getText());
        
        float tCV = 0.0f;
        
        tCV = stCV / Float.parseFloat(unidadesVendidas.getText());
        
        float pe = 0.0f;
        
        pe = gop.getEquilibrioUnidad(tCF, tCV, pV);
        
        totalPunto.setText(formatoNumero.format(pe));  
    }

    public void setB()
    {
        float pV = 0.0f; //200 +
        
        pV = Float.parseFloat(textVentas.getText()) / Float.parseFloat(unidadesVendidas.getText());

        float stCV = 0.0f; //
        
        stCV = Float.parseFloat(adminVaria.getText()) + Float.parseFloat(mercanciaVaria.getText()) + Float.parseFloat(ventaVaria.getText());
        
        float tCV = 0.0f; //62 +
        
        tCV = stCV / Float.parseFloat(unidadesVendidas.getText());
        
        float vNetas = 0.0f; //40,000,000 +
        
        vNetas = Integer.parseInt(unidadesAntes.getText()) * pV;
        
        float nCV = 0.0f; //12,400,000 +
        
        nCV = Integer.parseInt(unidadesAntes.getText()) * tCV;
        
        float margenC = 0.0f; //27,600,000
        
        margenC = vNetas - nCV;
        
        float tCF = 0.0f; //845,000 +
        
        tCF = (Float.parseFloat(adminFijo.getText())) + (Float.parseFloat(mercanciaFijo.getText())) + Float.parseFloat(ventaFijo.getText());
        
        float utilidadOp = 0.0f; //26,755,000
        
        utilidadOp = margenC - tCF;
        
        totalUtilidad.setText(formatoImporte.format(utilidadOp));  
    }
    
    public void setDejarVer()
    {
        verFormulario.setSelected(false);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        botonAbrirArchivo = new javax.swing.JButton();
        verFormulario = new javax.swing.JToggleButton();
        botonEditar = new javax.swing.JButton();
        botonBorrar = new javax.swing.JButton();
        botonInicializar = new javax.swing.JButton();
        botonCalcularS = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        textVentas = new javax.swing.JTextField();
        adminFijo = new javax.swing.JTextField();
        mercanciaFijo = new javax.swing.JTextField();
        ventaFijo = new javax.swing.JTextField();
        totalFijo = new javax.swing.JTextField();
        mercanciaVaria = new javax.swing.JTextField();
        adminVaria = new javax.swing.JTextField();
        ventaVaria = new javax.swing.JTextField();
        totalVaria = new javax.swing.JTextField();
        totalMercancia = new javax.swing.JTextField();
        totalAdmin = new javax.swing.JTextField();
        totalGasto = new javax.swing.JTextField();
        totalCostos = new javax.swing.JTextField();
        textUtilidad = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        botonCalcularP = new javax.swing.JButton();
        unidadesVendidas = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        totalPunto = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        unidadesAntes = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        totalUtilidad = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ejercicio 2");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 0, 160, 40);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoo.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(670, 0, 40, 40);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 730, 40);

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        add(jPanel2);
        jPanel2.setBounds(0, 430, 730, 20);

        jToolBar1.setRollover(true);

        botonAbrirArchivo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/abrirPDF.png"))); // NOI18N
        botonAbrirArchivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonAbrirArchivo.setFocusable(false);
        botonAbrirArchivo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonAbrirArchivo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonAbrirArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAbrirArchivoMouseClicked(evt);
            }
        });
        jToolBar1.add(botonAbrirArchivo);

        verFormulario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ver.png"))); // NOI18N
        verFormulario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        verFormulario.setFocusable(false);
        verFormulario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        verFormulario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        verFormulario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                verFormularioItemStateChanged(evt);
            }
        });
        jToolBar1.add(verFormulario);

        botonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/editar.png"))); // NOI18N
        botonEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEditar.setFocusable(false);
        botonEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonEditarMouseClicked(evt);
            }
        });
        jToolBar1.add(botonEditar);

        botonBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar.png"))); // NOI18N
        botonBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonBorrar.setFocusable(false);
        botonBorrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonBorrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonBorrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonBorrarMouseClicked(evt);
            }
        });
        jToolBar1.add(botonBorrar);

        botonInicializar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iniciar.png"))); // NOI18N
        botonInicializar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonInicializar.setFocusable(false);
        botonInicializar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonInicializar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonInicializar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonInicializarMouseClicked(evt);
            }
        });
        jToolBar1.add(botonInicializar);

        botonCalcularS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/calcular.png"))); // NOI18N
        botonCalcularS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCalcularS.setFocusable(false);
        botonCalcularS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonCalcularS.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonCalcularS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCalcularSMouseClicked(evt);
            }
        });
        jToolBar1.add(botonCalcularS);

        add(jToolBar1);
        jToolBar1.setBounds(0, 40, 730, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Symsa");
        add(jLabel3);
        jLabel3.setBounds(0, 74, 730, 30);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Costos fijos:");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel9);
        jLabel9.setBounds(190, 0, 130, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Costos variables:");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel8);
        jLabel8.setBounds(320, 0, 130, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Total:");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel4);
        jLabel4.setBounds(450, 0, 130, 30);

        jPanel3.add(jPanel4);
        jPanel4.setBounds(0, 0, 580, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Costos fijos:");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel5);
        jLabel5.setBounds(140, 0, 120, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Costos fijos:");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel7);
        jLabel7.setBounds(250, 0, 120, 30);

        textVentas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textVentas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textVentas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textVentasKeyTyped(evt);
            }
        });
        jPanel3.add(textVentas);
        textVentas.setBounds(450, 150, 130, 30);

        adminFijo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        adminFijo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        adminFijo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                adminFijoKeyTyped(evt);
            }
        });
        jPanel3.add(adminFijo);
        adminFijo.setBounds(190, 60, 130, 30);

        mercanciaFijo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        mercanciaFijo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mercanciaFijo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mercanciaFijoKeyTyped(evt);
            }
        });
        jPanel3.add(mercanciaFijo);
        mercanciaFijo.setBounds(190, 30, 130, 30);

        ventaFijo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ventaFijo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ventaFijo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ventaFijoKeyTyped(evt);
            }
        });
        jPanel3.add(ventaFijo);
        ventaFijo.setBounds(190, 90, 130, 30);

        totalFijo.setBackground(new java.awt.Color(255, 204, 255));
        totalFijo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalFijo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(totalFijo);
        totalFijo.setBounds(190, 120, 130, 30);

        mercanciaVaria.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        mercanciaVaria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mercanciaVaria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                mercanciaVariaKeyTyped(evt);
            }
        });
        jPanel3.add(mercanciaVaria);
        mercanciaVaria.setBounds(320, 30, 130, 30);

        adminVaria.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        adminVaria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        adminVaria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                adminVariaKeyTyped(evt);
            }
        });
        jPanel3.add(adminVaria);
        adminVaria.setBounds(320, 60, 130, 30);

        ventaVaria.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ventaVaria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ventaVaria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ventaVariaKeyTyped(evt);
            }
        });
        jPanel3.add(ventaVaria);
        ventaVaria.setBounds(320, 90, 130, 30);

        totalVaria.setBackground(new java.awt.Color(255, 204, 255));
        totalVaria.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalVaria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(totalVaria);
        totalVaria.setBounds(320, 120, 130, 30);

        totalMercancia.setBackground(new java.awt.Color(204, 255, 204));
        totalMercancia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalMercancia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(totalMercancia);
        totalMercancia.setBounds(450, 30, 130, 30);

        totalAdmin.setBackground(new java.awt.Color(204, 255, 204));
        totalAdmin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalAdmin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(totalAdmin);
        totalAdmin.setBounds(450, 60, 130, 30);

        totalGasto.setBackground(new java.awt.Color(204, 255, 204));
        totalGasto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalGasto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(totalGasto);
        totalGasto.setBounds(450, 90, 130, 30);

        totalCostos.setBackground(new java.awt.Color(255, 204, 255));
        totalCostos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalCostos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(totalCostos);
        totalCostos.setBounds(450, 120, 130, 30);

        textUtilidad.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textUtilidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        textUtilidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textUtilidadKeyTyped(evt);
            }
        });
        jPanel3.add(textUtilidad);
        textUtilidad.setBounds(450, 180, 130, 30);

        jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel20);
        jLabel20.setBounds(190, 180, 260, 30);

        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel21);
        jLabel21.setBounds(190, 150, 260, 30);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5);
        jPanel5.setBounds(530, 10, 100, 100);

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setLayout(null);

        jLabel12.setBackground(new java.awt.Color(255, 204, 0));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Costo de mercancia vendida:");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(jLabel12);
        jLabel12.setBounds(0, 0, 190, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Gastos administrativos:");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(jLabel13);
        jLabel13.setBounds(0, 30, 190, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Gastos de ventas:");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(jLabel14);
        jLabel14.setBounds(0, 60, 190, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Costos totales:");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(jLabel15);
        jLabel15.setBounds(0, 90, 190, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Ventas:");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(jLabel10);
        jLabel10.setBounds(0, 120, 190, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Utilidad antes de impuesto:");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.add(jLabel6);
        jLabel6.setBounds(0, 150, 190, 30);

        jPanel3.add(jPanel6);
        jPanel6.setBounds(0, 30, 190, 180);

        add(jPanel3);
        jPanel3.setBounds(80, 110, 580, 210);

        botonCalcularP.setBackground(new java.awt.Color(0, 153, 153));
        botonCalcularP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonCalcularP.setForeground(new java.awt.Color(255, 255, 255));
        botonCalcularP.setText("Calcular");
        botonCalcularP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCalcularP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonCalcularPMouseClicked(evt);
            }
        });
        add(botonCalcularP);
        botonCalcularP.setBounds(330, 390, 110, 30);

        unidadesVendidas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                unidadesVendidasKeyTyped(evt);
            }
        });
        add(unidadesVendidas);
        unidadesVendidas.setBounds(80, 350, 120, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Unidades vendidas:");
        add(jLabel11);
        jLabel11.setBounds(80, 330, 130, 20);

        totalPunto.setBackground(new java.awt.Color(255, 255, 0));
        totalPunto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(totalPunto);
        totalPunto.setBounds(230, 350, 110, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Punto de equilibrio:");
        add(jLabel16);
        jLabel16.setBounds(230, 330, 130, 20);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Unidades:");
        add(jLabel17);
        jLabel17.setBounds(500, 350, 60, 30);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Utilidad antes de impuestos, si se vendieron");
        add(jLabel18);
        jLabel18.setBounds(410, 330, 260, 20);

        unidadesAntes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                unidadesAntesKeyTyped(evt);
            }
        });
        add(unidadesAntes);
        unidadesAntes.setBounds(410, 350, 90, 30);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Unidades");
        add(jLabel19);
        jLabel19.setBounds(340, 350, 60, 30);

        totalUtilidad.setBackground(new java.awt.Color(255, 255, 0));
        totalUtilidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(totalUtilidad);
        totalUtilidad.setBounds(570, 350, 100, 30);
    }// </editor-fold>//GEN-END:initComponents

    private void botonAbrirArchivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAbrirArchivoMouseClicked
        try
        {
            //Creamos un archivo en la carpeta temporal de tu sistema operativo
            File temp = new File(System.getProperty("java.io.tmpdir") + "Ejercicios.pdf");
            
            //Creamos un flujo de entrada al cual asignamos el valor del PDF que esta dentro del JAR
            InputStream flujoEntrada = this.getClass().getResourceAsStream("/Archivos/Ejercicios_del_sistema.pdf");
            
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
    }//GEN-LAST:event_botonAbrirArchivoMouseClicked

    private void mercanciaFijoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mercanciaFijoKeyTyped
    char c = evt.getKeyChar();
    
    if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
        evt.consume();

    if (c == '.' && mercanciaFijo.getText().contains("."))
        evt.consume();
    }//GEN-LAST:event_mercanciaFijoKeyTyped

    private void mercanciaVariaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mercanciaVariaKeyTyped
    char c = evt.getKeyChar();
    
    if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
        evt.consume();

    if (c == '.' && mercanciaVaria.getText().contains("."))
        evt.consume();
    }//GEN-LAST:event_mercanciaVariaKeyTyped

    private void adminFijoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adminFijoKeyTyped
    char c = evt.getKeyChar();
    
    if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
        evt.consume();

    if (c == '.' && adminFijo.getText().contains("."))
        evt.consume();
    }//GEN-LAST:event_adminFijoKeyTyped

    private void adminVariaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adminVariaKeyTyped
    char c = evt.getKeyChar();
    
    if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
        evt.consume();

    if (c == '.' && adminVaria.getText().contains("."))
        evt.consume();
    }//GEN-LAST:event_adminVariaKeyTyped

    private void ventaFijoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ventaFijoKeyTyped
    char c = evt.getKeyChar();
    
    if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
        evt.consume();

    if (c == '.' && ventaFijo.getText().contains("."))
        evt.consume();
    }//GEN-LAST:event_ventaFijoKeyTyped

    private void ventaVariaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ventaVariaKeyTyped
    char c = evt.getKeyChar();
    
    if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
        evt.consume();

    if (c == '.' && ventaVaria.getText().contains("."))
        evt.consume();
    }//GEN-LAST:event_ventaVariaKeyTyped

    private void textVentasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textVentasKeyTyped
    char c = evt.getKeyChar();
    
    if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
        evt.consume();

    if (c == '.' && textVentas.getText().contains("."))
        evt.consume();
    }//GEN-LAST:event_textVentasKeyTyped

    private void textUtilidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textUtilidadKeyTyped
    char c = evt.getKeyChar();
    
    if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
        evt.consume();

    if (c == '.' && textUtilidad.getText().contains("."))
        evt.consume();
    }//GEN-LAST:event_textUtilidadKeyTyped

    private void unidadesVendidasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unidadesVendidasKeyTyped
    char c = evt.getKeyChar();
    
    if (((c < '0') || (c > '9')))
        evt.consume();
    }//GEN-LAST:event_unidadesVendidasKeyTyped

    private void unidadesAntesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_unidadesAntesKeyTyped
    char c = evt.getKeyChar();
    
    if (((c < '0') || (c > '9')))
        evt.consume();
    }//GEN-LAST:event_unidadesAntesKeyTyped

    private void botonBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBorrarMouseClicked
        setBorrar();
        setBloquear();
    }//GEN-LAST:event_botonBorrarMouseClicked

    private void botonInicializarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonInicializarMouseClicked
        setBorrar();
        setInicializar();
        setBloquear();
    }//GEN-LAST:event_botonInicializarMouseClicked

    private void botonEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEditarMouseClicked
        setEditar();
        totalFijo.setText(null);
        totalVaria.setText(null);
        totalMercancia.setText(null);
        totalAdmin.setText(null);
        totalGasto.setText(null);
        totalCostos.setText(null);
        totalPunto.setText(null);
        totalUtilidad.setText(null);        
    }//GEN-LAST:event_botonEditarMouseClicked

    private void botonCalcularSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCalcularSMouseClicked
        if(mercanciaFijo.getText().equals("") || mercanciaVaria.getText().equals("") || adminFijo.getText().equals("") ||
                adminVaria.getText().equals("") || ventaVaria.getText().equals("") || textVentas.getText().equals("")
                || textUtilidad.getText().equals("") || unidadesVendidas.getText().equals("") || unidadesAntes.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Se han detectado valores nulos \n","Verifique los datos ingresados", 0);
        else
        {
            try
            {
                setOperaciones();
                setA();
                setB();
                setBloquear();  
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Ha ocurrido un error, se han detectado valores nulos: \n" + e ,"Verifique los datos ingresados", 0);
            }
        }    
    }//GEN-LAST:event_botonCalcularSMouseClicked

    private void botonCalcularPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCalcularPMouseClicked
        if(mercanciaFijo.getText().equals("") || mercanciaVaria.getText().equals("") || adminFijo.getText().equals("") ||
                adminVaria.getText().equals("") || ventaVaria.getText().equals("") || textVentas.getText().equals("")
                || textUtilidad.getText().equals("") || unidadesVendidas.getText().equals("") || unidadesAntes.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Se han detectado valores nulos \n","Verifique los datos ingresados", 0);
        else
        {
            try
            {
                setOperaciones();
                setA();
                setB();
                setBloquear();  
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Ha ocurrido un error, se han detectado valores nulos: \n" + e ,"Verifique los datos ingresados", 0);
            }
        }  
    }//GEN-LAST:event_botonCalcularPMouseClicked

    private void verFormularioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_verFormularioItemStateChanged
        if(verFormulario.isSelected())
        {
            vf.setVisible(true);
        }
        else
        {
            vf.dispose();
        }
    }//GEN-LAST:event_verFormularioItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adminFijo;
    private javax.swing.JTextField adminVaria;
    private javax.swing.JButton botonAbrirArchivo;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonCalcularP;
    private javax.swing.JButton botonCalcularS;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonInicializar;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField mercanciaFijo;
    private javax.swing.JTextField mercanciaVaria;
    private javax.swing.JTextField textUtilidad;
    private javax.swing.JTextField textVentas;
    private javax.swing.JTextField totalAdmin;
    private javax.swing.JTextField totalCostos;
    private javax.swing.JTextField totalFijo;
    private javax.swing.JTextField totalGasto;
    private javax.swing.JTextField totalMercancia;
    private javax.swing.JTextField totalPunto;
    private javax.swing.JTextField totalUtilidad;
    private javax.swing.JTextField totalVaria;
    private javax.swing.JTextField unidadesAntes;
    private javax.swing.JTextField unidadesVendidas;
    private javax.swing.JTextField ventaFijo;
    private javax.swing.JTextField ventaVaria;
    private javax.swing.JToggleButton verFormulario;
    // End of variables declaration//GEN-END:variables
    GetOperaciones gop;
    NumberFormat formatoImporte;
    NumberFormat formatoNumero;
    private VentanaFormulario vf;
}
