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
import javax.swing.JSpinner;

public class PanelEjercicioCinco extends javax.swing.JPanel 
{
    float mA = 0.0f;
    float mB = 0.0f;
    float mC = 0.0f;
    float pA = 0.0f;
    float pB = 0.0f;
    float pC = 0.0f;
    float unid = 0.0f;    
    
    public PanelEjercicioCinco() 
    {
        initComponents();
        
        formatoImporte = NumberFormat.getCurrencyInstance();
        formatoNumero = NumberFormat.getNumberInstance();        
        
        gop = new GetOperaciones();        
        vf = new VentanaFormulario(5);   
        
        spinnerCapital.setEditor(new JSpinner.DefaultEditor(spinnerCapital));
        spinnerUtilidad.setEditor(new JSpinner.DefaultEditor(spinnerUtilidad));
        tasaImpositiva.setEditor(new JSpinner.DefaultEditor(tasaImpositiva));
        
        ponderadoA.setEditable(false);
        totalUnidadA.setEditable(false);  
        margenA.setEditable(false);
        ponderadoB.setEditable(false);
        totalUnidadB.setEditable(false);
        margenB.setEditable(false);
        ponderadoC.setEditable(false);
        totalUnidadC.setEditable(false);
        margenC.setEditable(false);
        unidadesDespues.setEditable(false);
        
        setBloquear();   
        setInicializar();         
    }
    
    public void setInicializar()
    {
        participacionA.setText("40");
        precioA.setText("30");
        variaA.setText("13");
        participacionB.setText("15");
        precioB.setText("50");
        variaB.setText("20");
        participacionC.setText("45");
        precioC.setText("10");
        variaC.setText("5");    
        costoFijo.setText("100000");
        capital.setText("150000");
        spinnerCapital.setValue(15);
        spinnerUtilidad.setValue(20);
        tasaImpositiva.setValue(28);        
    }
    
    public void setBorrar()
    {
        participacionA.setText(null);
        precioA.setText(null);
        variaA.setText(null);
        margenA.setText(null);
        ponderadoA.setText(null);
        totalUnidadA.setText(null);

        participacionB.setText(null);
        precioB.setText(null);
        variaB.setText(null);
        margenB.setText(null);
        ponderadoB.setText(null);
        totalUnidadB.setText(null);
        
        participacionC.setText(null);
        precioC.setText(null);
        variaC.setText(null);
        margenC.setText(null);
        ponderadoC.setText(null);
        totalUnidadC.setText(null);     
        
        costoFijo.setText(null);
        capital.setText(null);
        
        spinnerCapital.setValue(0);
        spinnerUtilidad.setValue(0);
        tasaImpositiva.setValue(0);
        
        unidadesDespues.setText(null);
    }
    
    public void setEditar()
    {
        participacionA.setEditable(true);
        precioA.setEditable(true);
        variaA.setEditable(true);
        participacionB.setEditable(true);
        precioB.setEditable(true);
        variaB.setEditable(true);
        participacionC.setEditable(true);
        precioC.setEditable(true);
        variaC.setEditable(true);   
        costoFijo.setEditable(true);
        capital.setEditable(true);
        spinnerCapital.setEnabled(true);
        spinnerUtilidad.setEnabled(true);
        tasaImpositiva.setEnabled(true);       
    }
    
    public void setBloquear()
    {
        participacionA.setEditable(false);
        precioA.setEditable(false);
        variaA.setEditable(false);
        participacionB.setEditable(false);
        precioB.setEditable(false);
        variaB.setEditable(false);
        participacionC.setEditable(false);
        precioC.setEditable(false);
        variaC.setEditable(false);  
        costoFijo.setEditable(false);
        capital.setEditable(false);
        spinnerCapital.setEnabled(false);
        spinnerUtilidad.setEnabled(false);
        tasaImpositiva.setEnabled(false);               
    }
    
    public void setMargen()
    {        
        mA = Float.parseFloat(precioA.getText()) - Float.parseFloat(variaA.getText());
        
        margenA.setText(formatoImporte.format(mA));  
        
        mB = Float.parseFloat(precioB.getText()) - Float.parseFloat(variaB.getText());
        
        margenB.setText(formatoImporte.format(mB));      
        
        mC = Float.parseFloat(precioC.getText()) - Float.parseFloat(variaC.getText());
        
        margenC.setText(formatoImporte.format(mC));         
    }
    
    public void setPonderado()
    {
        float porA = 0.0f;
        
        porA = Float.parseFloat(participacionA.getText()) / 100;
        
        pA = mA * porA;
        
        ponderadoA.setText(formatoImporte.format(pA));
        
        float porB = 0.0f;
        
        porB = Float.parseFloat(participacionB.getText()) / 100;
        
        pB = mB * porB;
        
        ponderadoB.setText(formatoImporte.format(pB)); 
        
        float porC = 0.0f;
        
        porC = Float.parseFloat(participacionC.getText()) / 100;
        
        pC = mC * porC;
        
        ponderadoC.setText(formatoImporte.format(pC));        
    }
    
    public void setA()
    {
        float act = 0.0f;
        
        float porCap = 0.0f;
        
        porCap = Float.parseFloat(spinnerCapital.getValue().toString()) / 100;
        
        act = Float.parseFloat(capital.getText()) + (Float.parseFloat(capital.getText()) * porCap);
        
        float porUt = 0.0f;
        
        porUt = Float.parseFloat(spinnerUtilidad.getValue().toString()) / 100;
        
        float uD = 0.0f;
        
        uD = act * porUt;
        
        float temp = 0.0f;
        
        temp = pA + pB + pC;
        
        temp *= 100;
        
        float tempT = 0.0f;
        
        tempT = Float.parseFloat(tasaImpositiva.getValue().toString()) + 10;
        
        unid = gop.getUtilidadDespuesImpuestos(Float.parseFloat(costoFijo.getText()), uD, tempT, temp);
        
        unidadesDespues.setText(formatoNumero.format(unid));
    }
    
    public void setB()
    {
        float unA = 0.0f;
        
        float tempA = 0.0f;
        
        tempA = Float.parseFloat(participacionA.getText()) / 100;
        
        unA = unid * tempA;
        
        totalUnidadA.setText(formatoNumero.format(unA));
        
        float unB = 0.0f;
        
        float tempB = 0.0f;
        
        tempB = Float.parseFloat(participacionB.getText()) / 100;
        
        unB = unid * tempB;
        
        totalUnidadB.setText(formatoNumero.format(Math.ceil(unB)));   
        
        float unC = 0.0f;
        
        float tempC = 0.0f;
        
        tempC = Float.parseFloat(participacionC.getText()) / 100;
        
        unC = unid * tempC;
        
        totalUnidadC.setText(formatoNumero.format(Math.ceil(unC)));        
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
        jToolBar1 = new javax.swing.JToolBar();
        botonAbrirArchivo = new javax.swing.JButton();
        verFormulario = new javax.swing.JToggleButton();
        botonEditar = new javax.swing.JButton();
        botonBorrar = new javax.swing.JButton();
        botonInicializar = new javax.swing.JButton();
        botonCalcularS = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        totalUnidadC = new javax.swing.JTextField();
        participacionA = new javax.swing.JTextField();
        precioA = new javax.swing.JTextField();
        variaA = new javax.swing.JTextField();
        margenA = new javax.swing.JTextField();
        ponderadoA = new javax.swing.JTextField();
        totalUnidadA = new javax.swing.JTextField();
        participacionB = new javax.swing.JTextField();
        precioB = new javax.swing.JTextField();
        variaB = new javax.swing.JTextField();
        margenB = new javax.swing.JTextField();
        ponderadoB = new javax.swing.JTextField();
        totalUnidadB = new javax.swing.JTextField();
        participacionC = new javax.swing.JTextField();
        precioC = new javax.swing.JTextField();
        variaC = new javax.swing.JTextField();
        margenC = new javax.swing.JTextField();
        ponderadoC = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        costoFijo = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        botonCalcularP = new javax.swing.JButton();
        spinnerUtilidad = new javax.swing.JSpinner();
        jLabel24 = new javax.swing.JLabel();
        tasaImpositiva = new javax.swing.JSpinner();
        jLabel25 = new javax.swing.JLabel();
        capital = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        spinnerCapital = new javax.swing.JSpinner();
        jLabel27 = new javax.swing.JLabel();
        unidadesDespues = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ejercicio 5");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 0, 160, 40);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iconoo.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(670, 0, 40, 40);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 730, 40);

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Zapaterias El Romance S.A.");
        add(jLabel3);
        jLabel3.setBounds(0, 74, 730, 30);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Damas");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel12);
        jLabel12.setBounds(370, 0, 140, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Niños");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel14);
        jLabel14.setBounds(510, 0, 140, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Caballeros");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel15);
        jLabel15.setBounds(230, 0, 140, 30);

        jPanel3.add(jPanel4);
        jPanel4.setBounds(0, 0, 650, 30);

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Participacion de mercado:");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(jLabel7);
        jLabel7.setBounds(0, 0, 230, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Precio de venta:");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(jLabel8);
        jLabel8.setBounds(0, 30, 230, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Costos variables:");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(jLabel9);
        jLabel9.setBounds(0, 60, 230, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Margen de contribucion ponderado:");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(jLabel10);
        jLabel10.setBounds(0, 120, 230, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Margen de contribucion:");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(jLabel11);
        jLabel11.setBounds(0, 90, 230, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Unidades que debe vender:");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(jLabel6);
        jLabel6.setBounds(0, 150, 230, 30);

        jPanel3.add(jPanel5);
        jPanel5.setBounds(0, 30, 230, 180);

        totalUnidadC.setBackground(new java.awt.Color(255, 255, 0));
        totalUnidadC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalUnidadC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(totalUnidadC);
        totalUnidadC.setBounds(510, 180, 140, 30);

        participacionA.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        participacionA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        participacionA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                participacionAKeyTyped(evt);
            }
        });
        jPanel3.add(participacionA);
        participacionA.setBounds(230, 30, 140, 30);

        precioA.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        precioA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        precioA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioAKeyTyped(evt);
            }
        });
        jPanel3.add(precioA);
        precioA.setBounds(230, 60, 140, 30);

        variaA.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        variaA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        variaA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                variaAKeyTyped(evt);
            }
        });
        jPanel3.add(variaA);
        variaA.setBounds(230, 90, 140, 30);

        margenA.setBackground(new java.awt.Color(255, 204, 204));
        margenA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        margenA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(margenA);
        margenA.setBounds(230, 120, 140, 30);

        ponderadoA.setBackground(new java.awt.Color(204, 255, 204));
        ponderadoA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ponderadoA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(ponderadoA);
        ponderadoA.setBounds(230, 150, 140, 30);

        totalUnidadA.setBackground(new java.awt.Color(255, 255, 0));
        totalUnidadA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalUnidadA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(totalUnidadA);
        totalUnidadA.setBounds(230, 180, 140, 30);

        participacionB.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        participacionB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        participacionB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                participacionBKeyTyped(evt);
            }
        });
        jPanel3.add(participacionB);
        participacionB.setBounds(370, 30, 140, 30);

        precioB.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        precioB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        precioB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioBKeyTyped(evt);
            }
        });
        jPanel3.add(precioB);
        precioB.setBounds(370, 60, 140, 30);

        variaB.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        variaB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        variaB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                variaBKeyTyped(evt);
            }
        });
        jPanel3.add(variaB);
        variaB.setBounds(370, 90, 140, 30);

        margenB.setBackground(new java.awt.Color(255, 204, 204));
        margenB.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        margenB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(margenB);
        margenB.setBounds(370, 120, 140, 30);

        ponderadoB.setBackground(new java.awt.Color(204, 255, 204));
        ponderadoB.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ponderadoB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(ponderadoB);
        ponderadoB.setBounds(370, 150, 140, 30);

        totalUnidadB.setBackground(new java.awt.Color(255, 255, 0));
        totalUnidadB.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalUnidadB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(totalUnidadB);
        totalUnidadB.setBounds(370, 180, 140, 30);

        participacionC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        participacionC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        participacionC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                participacionCKeyTyped(evt);
            }
        });
        jPanel3.add(participacionC);
        participacionC.setBounds(510, 30, 140, 30);

        precioC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        precioC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        precioC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioCKeyTyped(evt);
            }
        });
        jPanel3.add(precioC);
        precioC.setBounds(510, 60, 140, 30);

        variaC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        variaC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        variaC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                variaCKeyTyped(evt);
            }
        });
        jPanel3.add(variaC);
        variaC.setBounds(510, 90, 140, 30);

        margenC.setBackground(new java.awt.Color(255, 204, 204));
        margenC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        margenC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(margenC);
        margenC.setBounds(510, 120, 140, 30);

        ponderadoC.setBackground(new java.awt.Color(204, 255, 204));
        ponderadoC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ponderadoC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(ponderadoC);
        ponderadoC.setBounds(510, 150, 140, 30);

        add(jPanel3);
        jPanel3.setBounds(40, 110, 650, 210);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("despues de impuestos:");
        add(jLabel13);
        jLabel13.setBounds(530, 330, 140, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Costos fijos:");
        add(jLabel16);
        jLabel16.setBounds(180, 340, 110, 30);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Tasa impositiva:");
        add(jLabel17);
        jLabel17.setBounds(300, 340, 100, 30);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Capital");
        add(jLabel18);
        jLabel18.setBounds(40, 330, 50, 30);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("%");
        add(jLabel23);
        jLabel23.setBounds(510, 330, 20, 30);

        costoFijo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                costoFijoKeyTyped(evt);
            }
        });
        add(costoFijo);
        costoFijo.setBounds(200, 370, 90, 30);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Utilidad");
        add(jLabel19);
        jLabel19.setBounds(410, 330, 50, 30);

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
        botonCalcularP.setBounds(600, 380, 100, 30);
        add(spinnerUtilidad);
        spinnerUtilidad.setBounds(460, 330, 50, 30);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Unidades");
        add(jLabel24);
        jLabel24.setBounds(510, 370, 60, 30);
        add(tasaImpositiva);
        tasaImpositiva.setBounds(320, 370, 50, 30);

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("%");
        add(jLabel25);
        jLabel25.setBounds(370, 370, 20, 30);

        capital.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                capitalKeyTyped(evt);
            }
        });
        add(capital);
        capital.setBounds(60, 370, 100, 30);

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("$");
        add(jLabel26);
        jLabel26.setBounds(180, 370, 20, 30);
        add(spinnerCapital);
        spinnerCapital.setBounds(90, 330, 50, 30);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("%:");
        add(jLabel27);
        jLabel27.setBounds(140, 330, 30, 30);

        unidadesDespues.setBackground(new java.awt.Color(255, 255, 0));
        unidadesDespues.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(unidadesDespues);
        unidadesDespues.setBounds(410, 370, 100, 30);

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("$");
        add(jLabel28);
        jLabel28.setBounds(40, 370, 20, 30);
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

    private void participacionAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_participacionAKeyTyped
        char c = evt.getKeyChar();
    
        if (((c < '0') || (c > '9')))
            evt.consume();
    }//GEN-LAST:event_participacionAKeyTyped

    private void participacionBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_participacionBKeyTyped
        char c = evt.getKeyChar();
    
        if (((c < '0') || (c > '9')))
            evt.consume();
    }//GEN-LAST:event_participacionBKeyTyped

    private void participacionCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_participacionCKeyTyped
        char c = evt.getKeyChar();
    
        if (((c < '0') || (c > '9')))
            evt.consume();
    }//GEN-LAST:event_participacionCKeyTyped

    private void precioAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioAKeyTyped
        char c = evt.getKeyChar();
    
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
            evt.consume();

        if (c == '.' && precioA.getText().contains("."))
            evt.consume();
    }//GEN-LAST:event_precioAKeyTyped

    private void variaAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_variaAKeyTyped
        char c = evt.getKeyChar();
    
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
            evt.consume();

        if (c == '.' && variaA.getText().contains("."))
            evt.consume();
    }//GEN-LAST:event_variaAKeyTyped

    private void precioBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioBKeyTyped
        char c = evt.getKeyChar();
    
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
            evt.consume();

        if (c == '.' && precioB.getText().contains("."))
            evt.consume();
    }//GEN-LAST:event_precioBKeyTyped

    private void variaBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_variaBKeyTyped
        char c = evt.getKeyChar();
    
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
            evt.consume();

        if (c == '.' && variaB.getText().contains("."))
            evt.consume();
    }//GEN-LAST:event_variaBKeyTyped

    private void precioCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioCKeyTyped
        char c = evt.getKeyChar();
    
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
            evt.consume();

        if (c == '.' && precioC.getText().contains("."))
            evt.consume();
    }//GEN-LAST:event_precioCKeyTyped

    private void variaCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_variaCKeyTyped
        char c = evt.getKeyChar();
    
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
            evt.consume();

        if (c == '.' && variaC.getText().contains("."))
            evt.consume();
    }//GEN-LAST:event_variaCKeyTyped

    private void capitalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_capitalKeyTyped
        char c = evt.getKeyChar();
    
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
            evt.consume();

        if (c == '.' && capital.getText().contains("."))
            evt.consume();
    }//GEN-LAST:event_capitalKeyTyped

    private void costoFijoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costoFijoKeyTyped
        char c = evt.getKeyChar();
    
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
            evt.consume();

        if (c == '.' && costoFijo.getText().contains("."))
            evt.consume();
    }//GEN-LAST:event_costoFijoKeyTyped

    private void botonEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEditarMouseClicked
        setEditar();
        ponderadoA.setText(null);
        totalUnidadA.setText(null);
        margenA.setText(null);
        ponderadoB.setText(null);
        totalUnidadB.setText(null);
        margenB.setText(null);
        ponderadoC.setText(null);
        totalUnidadC.setText(null);
        margenC.setText(null);
        unidadesDespues.setText(null);        
    }//GEN-LAST:event_botonEditarMouseClicked

    private void botonBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBorrarMouseClicked
        setBorrar();
        setBloquear();
    }//GEN-LAST:event_botonBorrarMouseClicked

    private void botonInicializarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonInicializarMouseClicked
        setBorrar();
        setInicializar();
        setBloquear();
    }//GEN-LAST:event_botonInicializarMouseClicked

    private void botonCalcularPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCalcularPMouseClicked
        if(participacionA.getText().equals("") || participacionB.getText().equals("") || participacionC.getText().equals("") || capital.getText().equals("")
             || precioA.getText().equals("") || precioB.getText().equals("") || precioC.getText().equals("")
                || variaA.getText().equals("") || variaB.getText().equals("") || variaC.getText().equals("") || costoFijo.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Se han detectado valores nulos \n","Verifique los datos ingresados", 0);
        else
        {
            try
            {
                setMargen();
                setPonderado();
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

    private void botonCalcularSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCalcularSMouseClicked
        if(participacionA.getText().equals("") || participacionB.getText().equals("") || participacionC.getText().equals("") || capital.getText().equals("")
             || precioA.getText().equals("") || precioB.getText().equals("") || precioC.getText().equals("")
                || variaA.getText().equals("") || variaB.getText().equals("") || variaC.getText().equals("") || costoFijo.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Se han detectado valores nulos \n","Verifique los datos ingresados", 0);
        else
        {
            try
            {
                setMargen();
                setPonderado();
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAbrirArchivo;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonCalcularP;
    private javax.swing.JButton botonCalcularS;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonInicializar;
    private javax.swing.JTextField capital;
    private javax.swing.JTextField costoFijo;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField margenA;
    private javax.swing.JTextField margenB;
    private javax.swing.JTextField margenC;
    private javax.swing.JTextField participacionA;
    private javax.swing.JTextField participacionB;
    private javax.swing.JTextField participacionC;
    private javax.swing.JTextField ponderadoA;
    private javax.swing.JTextField ponderadoB;
    private javax.swing.JTextField ponderadoC;
    private javax.swing.JTextField precioA;
    private javax.swing.JTextField precioB;
    private javax.swing.JTextField precioC;
    private javax.swing.JSpinner spinnerCapital;
    private javax.swing.JSpinner spinnerUtilidad;
    private javax.swing.JSpinner tasaImpositiva;
    private javax.swing.JTextField totalUnidadA;
    private javax.swing.JTextField totalUnidadB;
    private javax.swing.JTextField totalUnidadC;
    private javax.swing.JTextField unidadesDespues;
    private javax.swing.JTextField variaA;
    private javax.swing.JTextField variaB;
    private javax.swing.JTextField variaC;
    private javax.swing.JToggleButton verFormulario;
    // End of variables declaration//GEN-END:variables
    GetOperaciones gop;
    NumberFormat formatoImporte;
    NumberFormat formatoNumero;    
    private VentanaFormulario vf;
}
