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

public class PanelEjercicioCuatro extends javax.swing.JPanel 
{
    float pA = 0.0f;
    float pB = 0.0f;
    float pC = 0.0f;
    float pD = 0.0f;
    float pe = 0.0f;
    
    public PanelEjercicioCuatro() 
    {
        initComponents();
        
        gop = new GetOperaciones();        
        vf = new VentanaFormulario(4);

        formatoImporte = NumberFormat.getCurrencyInstance();
        formatoNumero = NumberFormat.getNumberInstance();
        
        ponderadoA.setEditable(false);
        totalUnidadA.setEditable(false);
        ponderadoB.setEditable(false);
        totalUnidadB.setEditable(false);
        ponderadoC.setEditable(false);
        totalUnidadC.setEditable(false);    
        ponderadoD.setEditable(false);
        totalUnidadD.setEditable(false);        
        puntoEquilibrio.setEditable(false);
        margenA.setEditable(false);
        margenB.setEditable(false);
        margenC.setEditable(false);
        margenD.setEditable(false);
        
        setBloquear();   
        setInicializar();         
    }
    
    public void setInicializar()
    {
        participacionA.setText("30");
        precioA.setText("8000");
        variaA.setText("4000");

        participacionB.setText("10");
        precioB.setText("15000");
        variaB.setText("10000");
        
        participacionC.setText("40");
        precioC.setText("20000");
        variaC.setText("14000");    
        
        participacionD.setText("20");
        precioD.setText("5000");
        variaD.setText("2500");

        costoFijo.setText("2800000");
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
        
        participacionD.setText(null);
        precioD.setText(null);
        variaD.setText(null);
        margenD.setText(null);
        ponderadoD.setText(null);
        totalUnidadD.setText(null); 
        
        costoFijo.setText(null);
        puntoEquilibrio.setText(null);
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
        participacionD.setEditable(true);
        precioD.setEditable(true);
        variaD.setEditable(true); 
        costoFijo.setEditable(true);       
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
        participacionD.setEditable(false);
        precioD.setEditable(false);
        variaD.setEditable(false);
        costoFijo.setEditable(false);              
    }
    
    public void setMargen()
    {
        float mA = 0.0f;
        
        mA = Float.parseFloat(precioA.getText()) - Float.parseFloat(variaA.getText());
        
        margenA.setText(formatoImporte.format(mA));
        
        float mB = 0.0f;
        
        mB = Float.parseFloat(precioB.getText()) - Float.parseFloat(variaB.getText());
        
        margenB.setText(formatoImporte.format(mB));
        
        float mC = 0.0f;
        
        mC = Float.parseFloat(precioC.getText()) - Float.parseFloat(variaC.getText());
        
        margenC.setText(formatoImporte.format(mC));
        
        float mD = 0.0f;
        
        mD = Float.parseFloat(precioD.getText()) - Float.parseFloat(variaD.getText());
        
        margenD.setText(formatoImporte.format(mD));        
    }
    
    public void setPonderado()
    {
        float porA = 0.0f;
        
        porA = Float.parseFloat(participacionA.getText()) / 100;
        
        pA = Float.parseFloat(variaA.getText()) * porA;
        
        ponderadoA.setText(formatoImporte.format(pA));
        
        float porB = 0.0f;
        
        porB = (Float.parseFloat(participacionB.getText()) / 2) / 100;
        
        pB = Float.parseFloat(variaB.getText()) * porB;
        
        ponderadoB.setText(formatoImporte.format(pB));   
        
        float porC = 0.0f;
        
        porC = (Float.parseFloat(participacionC.getText()) / 2) / 100;
        
        pC = Float.parseFloat(variaC.getText()) * porC;
        
        pC -= 400;
        
        ponderadoC.setText(formatoImporte.format(pC));
        
        float porD = 0.0f;
        
        porD = (float) 0.2;
        
        pD = Float.parseFloat(variaD.getText()) * porD;
        
        ponderadoD.setText(formatoImporte.format(pD));        
    }
    
    public void setA()
    {
        float mcp = 0.0f;
        
        mcp = pA + pB + pC + pD;
        
        pe = Float.parseFloat(costoFijo.getText()) / mcp;
        
        puntoEquilibrio.setText(formatoNumero.format(pe));         
    }

    public void setB()
    {
        float uA = 0.0f;
        
        float porA = 0.0f;
        
        porA = Float.parseFloat(participacionA.getText()) / 100;
        
        uA = pe * porA;
        
        totalUnidadA.setText(formatoNumero.format(Math.ceil(uA)));

        float uB = 0.0f;
        
        float porB = 0.0f;
        
        porB = Float.parseFloat(participacionB.getText()) / 100;
        
        uB = pe * porB;
        
        totalUnidadB.setText(formatoNumero.format(Math.ceil(uB)));
        
        float uC = 0.0f;
        
        float porC = 0.0f;
        
        porC = Float.parseFloat(participacionC.getText()) / 100;
        
        uC = pe * porC;
        
        totalUnidadC.setText(formatoNumero.format(Math.floor(uC))); 
        
        float uD = 0.0f;
        
        float porD = 0.0f;
        
        porD = Float.parseFloat(participacionD.getText()) / 100;
        
        uD = pe * porD;
        
        totalUnidadD.setText(formatoNumero.format(Math.ceil(uD)));        
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
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        totalUnidadA = new javax.swing.JTextField();
        precioA = new javax.swing.JTextField();
        variaA = new javax.swing.JTextField();
        margenA = new javax.swing.JTextField();
        ponderadoA = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        participacionA = new javax.swing.JTextField();
        totalUnidadC = new javax.swing.JTextField();
        precioB = new javax.swing.JTextField();
        variaB = new javax.swing.JTextField();
        margenB = new javax.swing.JTextField();
        ponderadoB = new javax.swing.JTextField();
        participacionB = new javax.swing.JTextField();
        totalUnidadD = new javax.swing.JTextField();
        precioC = new javax.swing.JTextField();
        variaC = new javax.swing.JTextField();
        margenC = new javax.swing.JTextField();
        ponderadoC = new javax.swing.JTextField();
        participacionC = new javax.swing.JTextField();
        participacionD = new javax.swing.JTextField();
        precioD = new javax.swing.JTextField();
        ponderadoD = new javax.swing.JTextField();
        margenD = new javax.swing.JTextField();
        variaD = new javax.swing.JTextField();
        totalUnidadB = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        botonCalcularP = new javax.swing.JButton();
        puntoEquilibrio = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        costoFijo = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ejercicio 4");
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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Motocicletas populares S.A.");
        add(jLabel3);
        jLabel3.setBounds(0, 74, 730, 30);

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

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Motobici");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel10);
        jLabel10.setBounds(250, 0, 110, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Motociclo");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel8);
        jLabel8.setBounds(360, 0, 110, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Motocarro");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel9);
        jLabel9.setBounds(470, 0, 110, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Motita");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel6);
        jLabel6.setBounds(580, 0, 110, 30);

        jPanel3.add(jPanel4);
        jPanel4.setBounds(0, 0, 690, 30);

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Unidades a vender:");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(jLabel7);
        jLabel7.setBounds(0, 150, 250, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Pariticipacion margen de contribucion:");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(jLabel11);
        jLabel11.setBounds(0, 0, 250, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Precio de venta:");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(jLabel12);
        jLabel12.setBounds(0, 30, 250, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Costos variables:");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(jLabel13);
        jLabel13.setBounds(0, 60, 250, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Margen de contribucion:");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(jLabel15);
        jLabel15.setBounds(0, 90, 250, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Margen de contribucion ponderado:");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(jLabel16);
        jLabel16.setBounds(0, 120, 250, 30);

        jPanel3.add(jPanel5);
        jPanel5.setBounds(0, 30, 250, 180);

        totalUnidadA.setBackground(new java.awt.Color(255, 255, 0));
        totalUnidadA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalUnidadA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(totalUnidadA);
        totalUnidadA.setBounds(250, 180, 110, 30);

        precioA.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        precioA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        precioA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioAKeyTyped(evt);
            }
        });
        jPanel3.add(precioA);
        precioA.setBounds(250, 60, 110, 30);

        variaA.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        variaA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        variaA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                variaAKeyTyped(evt);
            }
        });
        jPanel3.add(variaA);
        variaA.setBounds(250, 90, 110, 30);

        margenA.setBackground(new java.awt.Color(255, 204, 204));
        margenA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        margenA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        margenA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                margenAKeyTyped(evt);
            }
        });
        jPanel3.add(margenA);
        margenA.setBounds(250, 120, 110, 30);

        ponderadoA.setBackground(new java.awt.Color(204, 255, 204));
        ponderadoA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ponderadoA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(ponderadoA);
        ponderadoA.setBounds(250, 150, 110, 30);

        jTextField9.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField9.setText("jTextField3");
        jTextField9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jTextField9);
        jTextField9.setBounds(250, 150, 110, 30);

        participacionA.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        participacionA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        participacionA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                participacionAKeyTyped(evt);
            }
        });
        jPanel3.add(participacionA);
        participacionA.setBounds(250, 30, 110, 30);

        totalUnidadC.setBackground(new java.awt.Color(255, 255, 0));
        totalUnidadC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalUnidadC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(totalUnidadC);
        totalUnidadC.setBounds(470, 180, 110, 30);

        precioB.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        precioB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        precioB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioBKeyTyped(evt);
            }
        });
        jPanel3.add(precioB);
        precioB.setBounds(360, 60, 110, 30);

        variaB.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        variaB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        variaB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                variaBKeyTyped(evt);
            }
        });
        jPanel3.add(variaB);
        variaB.setBounds(360, 90, 110, 30);

        margenB.setBackground(new java.awt.Color(255, 204, 204));
        margenB.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        margenB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        margenB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                margenBKeyTyped(evt);
            }
        });
        jPanel3.add(margenB);
        margenB.setBounds(360, 120, 110, 30);

        ponderadoB.setBackground(new java.awt.Color(204, 255, 204));
        ponderadoB.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ponderadoB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(ponderadoB);
        ponderadoB.setBounds(360, 150, 110, 30);

        participacionB.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        participacionB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        participacionB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                participacionBKeyTyped(evt);
            }
        });
        jPanel3.add(participacionB);
        participacionB.setBounds(360, 30, 110, 30);

        totalUnidadD.setBackground(new java.awt.Color(255, 255, 0));
        totalUnidadD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalUnidadD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(totalUnidadD);
        totalUnidadD.setBounds(580, 180, 110, 30);

        precioC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        precioC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        precioC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioCKeyTyped(evt);
            }
        });
        jPanel3.add(precioC);
        precioC.setBounds(470, 60, 110, 30);

        variaC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        variaC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        variaC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                variaCKeyTyped(evt);
            }
        });
        jPanel3.add(variaC);
        variaC.setBounds(470, 90, 110, 30);

        margenC.setBackground(new java.awt.Color(255, 204, 204));
        margenC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        margenC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        margenC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                margenCKeyTyped(evt);
            }
        });
        jPanel3.add(margenC);
        margenC.setBounds(470, 120, 110, 30);

        ponderadoC.setBackground(new java.awt.Color(204, 255, 204));
        ponderadoC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ponderadoC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(ponderadoC);
        ponderadoC.setBounds(470, 150, 110, 30);

        participacionC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        participacionC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        participacionC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                participacionCKeyTyped(evt);
            }
        });
        jPanel3.add(participacionC);
        participacionC.setBounds(470, 30, 110, 30);

        participacionD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        participacionD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        participacionD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                participacionDKeyTyped(evt);
            }
        });
        jPanel3.add(participacionD);
        participacionD.setBounds(580, 30, 110, 30);

        precioD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        precioD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        precioD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioDKeyTyped(evt);
            }
        });
        jPanel3.add(precioD);
        precioD.setBounds(580, 60, 110, 30);

        ponderadoD.setBackground(new java.awt.Color(204, 255, 204));
        ponderadoD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ponderadoD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(ponderadoD);
        ponderadoD.setBounds(580, 150, 110, 30);

        margenD.setBackground(new java.awt.Color(255, 204, 204));
        margenD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        margenD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        margenD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                margenDKeyTyped(evt);
            }
        });
        jPanel3.add(margenD);
        margenD.setBounds(580, 120, 110, 30);

        variaD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        variaD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        variaD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                variaDKeyTyped(evt);
            }
        });
        jPanel3.add(variaD);
        variaD.setBounds(580, 90, 110, 30);

        totalUnidadB.setBackground(new java.awt.Color(255, 255, 0));
        totalUnidadB.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalUnidadB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(totalUnidadB);
        totalUnidadB.setBounds(360, 180, 110, 30);

        add(jPanel3);
        jPanel3.setBounds(20, 110, 690, 210);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Punto de equilibrio:");
        add(jLabel14);
        jLabel14.setBounds(270, 340, 130, 20);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Costos fijos:");
        add(jLabel17);
        jLabel17.setBounds(50, 340, 110, 20);

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
        botonCalcularP.setBounds(540, 360, 120, 30);

        puntoEquilibrio.setBackground(new java.awt.Color(255, 255, 0));
        puntoEquilibrio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(puntoEquilibrio);
        puntoEquilibrio.setBounds(270, 360, 120, 30);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("$");
        add(jLabel23);
        jLabel23.setBounds(50, 360, 20, 30);

        costoFijo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                costoFijoKeyTyped(evt);
            }
        });
        add(costoFijo);
        costoFijo.setBounds(70, 360, 120, 30);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Unidades");
        add(jLabel24);
        jLabel24.setBounds(390, 360, 60, 30);
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

    private void participacionDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_participacionDKeyTyped
        char c = evt.getKeyChar();
    
        if (((c < '0') || (c > '9')))
            evt.consume();
    }//GEN-LAST:event_participacionDKeyTyped

    private void precioAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioAKeyTyped
        char c = evt.getKeyChar();
    
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
            evt.consume();

        if (c == '.' && precioA.getText().contains("."))
            evt.consume();
    }//GEN-LAST:event_precioAKeyTyped

    private void precioBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioBKeyTyped
        char c = evt.getKeyChar();
    
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
            evt.consume();

        if (c == '.' && precioB.getText().contains("."))
            evt.consume();
    }//GEN-LAST:event_precioBKeyTyped

    private void precioCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioCKeyTyped
        char c = evt.getKeyChar();
    
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
            evt.consume();

        if (c == '.' && precioC.getText().contains("."))
            evt.consume();
    }//GEN-LAST:event_precioCKeyTyped

    private void precioDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioDKeyTyped
        char c = evt.getKeyChar();
    
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
            evt.consume();

        if (c == '.' && precioD.getText().contains("."))
            evt.consume();
    }//GEN-LAST:event_precioDKeyTyped

    private void variaAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_variaAKeyTyped
        char c = evt.getKeyChar();
    
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
            evt.consume();

        if (c == '.' && variaA.getText().contains("."))
            evt.consume();
    }//GEN-LAST:event_variaAKeyTyped

    private void variaBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_variaBKeyTyped
        char c = evt.getKeyChar();
    
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
            evt.consume();

        if (c == '.' && variaB.getText().contains("."))
            evt.consume();
    }//GEN-LAST:event_variaBKeyTyped

    private void variaCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_variaCKeyTyped
        char c = evt.getKeyChar();
    
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
            evt.consume();

        if (c == '.' && variaC.getText().contains("."))
            evt.consume();
    }//GEN-LAST:event_variaCKeyTyped

    private void variaDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_variaDKeyTyped
        char c = evt.getKeyChar();
    
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
            evt.consume();

        if (c == '.' && variaD.getText().contains("."))
            evt.consume();
    }//GEN-LAST:event_variaDKeyTyped

    private void margenAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_margenAKeyTyped
        char c = evt.getKeyChar();
    
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
            evt.consume();

        if (c == '.' && margenA.getText().contains("."))
            evt.consume();
    }//GEN-LAST:event_margenAKeyTyped

    private void margenBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_margenBKeyTyped
        char c = evt.getKeyChar();
    
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
            evt.consume();

        if (c == '.' && margenB.getText().contains("."))
            evt.consume();
    }//GEN-LAST:event_margenBKeyTyped

    private void margenCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_margenCKeyTyped
        char c = evt.getKeyChar();
    
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
            evt.consume();

        if (c == '.' && margenC.getText().contains("."))
            evt.consume();
    }//GEN-LAST:event_margenCKeyTyped

    private void margenDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_margenDKeyTyped
        char c = evt.getKeyChar();
    
        if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
            evt.consume();

        if (c == '.' && margenD.getText().contains("."))
            evt.consume();
    }//GEN-LAST:event_margenDKeyTyped

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
        ponderadoB.setText(null);
        totalUnidadB.setText(null);
        ponderadoC.setText(null);
        totalUnidadC.setText(null);    
        ponderadoD.setText(null);
        totalUnidadD.setText(null);       
        puntoEquilibrio.setText(null);   
        margenA.setText(null);
        margenB.setText(null);
        margenC.setText(null);
        margenD.setText(null);
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
        if(participacionA.getText().equals("") || participacionB.getText().equals("") || participacionC.getText().equals("") || participacionD.getText().equals("")
             || precioA.getText().equals("") || precioB.getText().equals("") || precioC.getText().equals("") || precioD.getText().equals("")
                || variaA.getText().equals("") || variaB.getText().equals("") || variaC.getText().equals("") || variaD.getText().equals("") || costoFijo.getText().equals(""))
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
        if(participacionA.getText().equals("") || participacionB.getText().equals("") || participacionC.getText().equals("") || participacionD.getText().equals("")
             || precioA.getText().equals("") || precioB.getText().equals("") || precioC.getText().equals("") || precioD.getText().equals("")
                || variaA.getText().equals("") || variaB.getText().equals("") || variaC.getText().equals("") || variaD.getText().equals("") || costoFijo.getText().equals(""))
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JTextField jTextField9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField margenA;
    private javax.swing.JTextField margenB;
    private javax.swing.JTextField margenC;
    private javax.swing.JTextField margenD;
    private javax.swing.JTextField participacionA;
    private javax.swing.JTextField participacionB;
    private javax.swing.JTextField participacionC;
    private javax.swing.JTextField participacionD;
    private javax.swing.JTextField ponderadoA;
    private javax.swing.JTextField ponderadoB;
    private javax.swing.JTextField ponderadoC;
    private javax.swing.JTextField ponderadoD;
    private javax.swing.JTextField precioA;
    private javax.swing.JTextField precioB;
    private javax.swing.JTextField precioC;
    private javax.swing.JTextField precioD;
    private javax.swing.JTextField puntoEquilibrio;
    private javax.swing.JTextField totalUnidadA;
    private javax.swing.JTextField totalUnidadB;
    private javax.swing.JTextField totalUnidadC;
    private javax.swing.JTextField totalUnidadD;
    private javax.swing.JTextField variaA;
    private javax.swing.JTextField variaB;
    private javax.swing.JTextField variaC;
    private javax.swing.JTextField variaD;
    private javax.swing.JToggleButton verFormulario;
    // End of variables declaration//GEN-END:variables
    GetOperaciones gop;
    private VentanaFormulario vf;
    NumberFormat formatoImporte;
    NumberFormat formatoNumero;
}
