package Presupuestos;

//Cesar Julio Beltran - Costos y presupuestos

import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

public class PanelEjercicioTres extends javax.swing.JPanel 
{

    float mc = 0.0f, nPrec = 0.0f;
    
    public PanelEjercicioTres() 
    {
        initComponents();
        
        formatoImporte = NumberFormat.getCurrencyInstance();
        formatoNumero = NumberFormat.getNumberInstance();
        
        gop = new GetOperaciones(); 
        vf = new VentanaFormulario(3);
        
        spinnerAumento.setEditor(new JSpinner.DefaultEditor(spinnerAumento));
        
        totalMargen.setEditable(false);
        totalPuntoPes.setEditable(false);
        totalPuntoUnid.setEditable(false);
        totalNMargen.setEditable(false);
        totalNPuntoPes.setEditable(false);
        totalNPuntoUnid.setEditable(false);
        
        setBloquear();   
        setInicializar();        
    }
    
    public void setInicializar()
    {
        precioVenta.setText("2000");
        costoVaria.setText("1000");
        costoFijo.setText("1000000");
        spinnerAumento.setValue(25);
    }
    
    public void setBorrar()
    {
        precioVenta.setText(null);
        costoVaria.setText(null);
        costoFijo.setText(null); 
        totalMargen.setText(null);
        totalPuntoPes.setText(null);
        totalPuntoUnid.setText(null);
        totalNMargen.setText(null);
        totalNPuntoPes.setText(null);
        totalNPuntoUnid.setText(null); 
        spinnerAumento.setValue(0);
    }
    
    public void setEditar()
    {
        precioVenta.setEditable(true);
        costoVaria.setEditable(true);
        costoFijo.setEditable(true);  
        spinnerAumento.setEnabled(true);
    }
    
    public void setBloquear()
    {
        precioVenta.setEditable(false);
        costoVaria.setEditable(false);
        costoFijo.setEditable(false);
        spinnerAumento.setEnabled(false);
    }
    
    public void setA()
    {
        float pu = 0.0f;
        
        pu = gop.getEquilibrioUnidad(Float.parseFloat(costoFijo.getText()), Float.parseFloat(costoVaria.getText()), Float.parseFloat(precioVenta.getText()));
    
        totalPuntoUnid.setText(formatoNumero.format(pu));
    }
    
    public void setB()
    {
        float pe = 0.0f;
        
        pe = gop.getEquilibrioPeso(Float.parseFloat(costoFijo.getText()), mc);
        
        totalPuntoPes.setText(formatoImporte.format(pe));
    }
    
    public void setC()
    {
        mc = gop.getMargenContribucion(Float.parseFloat(precioVenta.getText()), Float.parseFloat(costoVaria.getText()));
        
        totalMargen.setText(mc + "");
    }   
    
    public void setAumentarPrecio()
    {
        float por = 0.0f;
        
        por = Float.parseFloat(spinnerAumento.getValue().toString());
        
        por /= 100;
        
        por += 1;
        
        nPrec = Float.parseFloat(precioVenta.getText()) * por;
    }
    
    public void setD()
    {
        float pu = 0.0f;
        
        pu = gop.getEquilibrioUnidad(Float.parseFloat(costoFijo.getText()), Float.parseFloat(costoVaria.getText()), nPrec);
    
        totalNPuntoUnid.setText(formatoNumero.format(pu));
        
        float nmc = 0.0f;
        
        nmc = gop.getMargenContribucion(nPrec, Float.parseFloat(costoVaria.getText()));
        
        totalNMargen.setText(nmc + "");         
        
        float pe = 0.0f;
        
        pe = gop.getEquilibrioPeso(Float.parseFloat(costoFijo.getText()), nmc);
        
        totalNPuntoPes.setText(formatoImporte.format(pe));           
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
        botonInicilizar = new javax.swing.JButton();
        botonCalcularS = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        costoVaria = new javax.swing.JTextField();
        costoFijo = new javax.swing.JTextField();
        precioVenta = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        totalMargen = new javax.swing.JTextField();
        totalPuntoUnid = new javax.swing.JTextField();
        totalNPuntoUnid = new javax.swing.JTextField();
        totalNMargen = new javax.swing.JTextField();
        totalPuntoPes = new javax.swing.JTextField();
        totalNPuntoPes = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        spinnerAumento = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        botonCalcularP = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ejercicio 3");
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

        botonInicilizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iniciar.png"))); // NOI18N
        botonInicilizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonInicilizar.setFocusable(false);
        botonInicilizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonInicilizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonInicilizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonInicilizarMouseClicked(evt);
            }
        });
        jToolBar1.add(botonInicilizar);

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
        jLabel3.setText("Televisores del Norte S.A.");
        add(jLabel3);
        jLabel3.setBounds(0, 74, 730, 30);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(204, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Superestrella");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel6);
        jLabel6.setBounds(0, 0, 120, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("$/CU");
        jLabel5.setToolTipText("");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel5);
        jLabel5.setBounds(120, 0, 110, 30);

        jPanel3.add(jPanel4);
        jPanel4.setBounds(0, 0, 230, 30);

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Precio de venta:");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(jLabel7);
        jLabel7.setBounds(0, 0, 120, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Costos variables:");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(jLabel8);
        jLabel8.setBounds(0, 30, 120, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Costos fijos:");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.add(jLabel4);
        jLabel4.setBounds(0, 60, 120, 30);

        jPanel3.add(jPanel5);
        jPanel5.setBounds(0, 30, 120, 90);

        costoVaria.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        costoVaria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        costoVaria.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                costoVariaKeyTyped(evt);
            }
        });
        jPanel3.add(costoVaria);
        costoVaria.setBounds(120, 60, 110, 30);

        costoFijo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        costoFijo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        costoFijo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                costoFijoKeyTyped(evt);
            }
        });
        jPanel3.add(costoFijo);
        costoFijo.setBounds(120, 90, 110, 30);

        precioVenta.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        precioVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        precioVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                precioVentaKeyTyped(evt);
            }
        });
        jPanel3.add(precioVenta);
        precioVenta.setBounds(120, 30, 110, 30);

        add(jPanel3);
        jPanel3.setBounds(250, 110, 230, 120);

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

        totalMargen.setBackground(new java.awt.Color(255, 255, 0));
        totalMargen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(totalMargen);
        totalMargen.setBounds(140, 270, 110, 30);

        totalPuntoUnid.setBackground(new java.awt.Color(255, 255, 0));
        totalPuntoUnid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(totalPuntoUnid);
        totalPuntoUnid.setBounds(510, 270, 110, 30);

        totalNPuntoUnid.setBackground(new java.awt.Color(255, 255, 0));
        totalNPuntoUnid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(totalNPuntoUnid);
        totalNPuntoUnid.setBounds(510, 340, 110, 30);

        totalNMargen.setBackground(new java.awt.Color(255, 255, 0));
        totalNMargen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(totalNMargen);
        totalNMargen.setBounds(210, 340, 110, 30);

        totalPuntoPes.setBackground(new java.awt.Color(255, 255, 0));
        totalPuntoPes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(totalPuntoPes);
        totalPuntoPes.setBounds(370, 270, 110, 30);

        totalNPuntoPes.setBackground(new java.awt.Color(255, 255, 0));
        totalNPuntoPes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(totalNPuntoPes);
        totalNPuntoPes.setBounds(370, 340, 110, 30);

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Unidades");
        add(jLabel19);
        jLabel19.setBounds(620, 340, 60, 30);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("%:");
        add(jLabel20);
        jLabel20.setBounds(140, 340, 30, 30);
        add(spinnerAumento);
        spinnerAumento.setBounds(80, 340, 60, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Margen de contribucion:");
        add(jLabel9);
        jLabel9.setBounds(190, 320, 160, 20);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Punto de equilibrio:");
        add(jLabel10);
        jLabel10.setBounds(370, 320, 250, 20);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Margen de contribucion:");
        add(jLabel11);
        jLabel11.setBounds(120, 250, 160, 20);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("%");
        add(jLabel21);
        jLabel21.setBounds(250, 270, 20, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Si el precio aumentara ");
        add(jLabel12);
        jLabel12.setBounds(50, 320, 140, 20);

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Unidades");
        add(jLabel22);
        jLabel22.setBounds(620, 270, 60, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Punto de equilibrio:");
        add(jLabel13);
        jLabel13.setBounds(370, 250, 250, 20);

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("%");
        add(jLabel23);
        jLabel23.setBounds(320, 340, 20, 30);

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
        botonCalcularP.setBounds(320, 390, 110, 30);
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

    private void precioVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_precioVentaKeyTyped
    char c = evt.getKeyChar();
    
    if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
        evt.consume();

    if (c == '.' && precioVenta.getText().contains("."))
        evt.consume();
    }//GEN-LAST:event_precioVentaKeyTyped

    private void costoVariaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costoVariaKeyTyped
    char c = evt.getKeyChar();
    
    if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
        evt.consume();

    if (c == '.' && costoVaria.getText().contains("."))
        evt.consume();
    }//GEN-LAST:event_costoVariaKeyTyped

    private void costoFijoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_costoFijoKeyTyped
    char c = evt.getKeyChar();
    
    if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
        evt.consume();

    if (c == '.' && costoFijo.getText().contains("."))
        evt.consume();
    }//GEN-LAST:event_costoFijoKeyTyped

    private void botonEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEditarMouseClicked
        setEditar();
        totalMargen.setText(null);
        totalPuntoPes.setText(null);
        totalPuntoUnid.setText(null);
        totalNMargen.setText(null);
        totalNPuntoPes.setText(null);
        totalNPuntoUnid.setText(null);           
    }//GEN-LAST:event_botonEditarMouseClicked

    private void botonBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBorrarMouseClicked
        setBorrar();
        setBloquear();
    }//GEN-LAST:event_botonBorrarMouseClicked

    private void botonInicilizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonInicilizarMouseClicked
        setBorrar();
        setInicializar();
        setBloquear();
    }//GEN-LAST:event_botonInicilizarMouseClicked

    private void botonCalcularPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCalcularPMouseClicked
        if(precioVenta.getText().equals("") || costoFijo.getText().equals("") || costoVaria.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Se han detectado valores nulos \n","Verifique los datos ingresados", 0);
        else
        {
            try
            {
                setAumentarPrecio();
                setA();
                setC();
                setB();
                setD();
                setBloquear();  
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Ha ocurrido un error, se han detectado valores nulos: \n" + e ,"Verifique los datos ingresados", 0);
            }
        }          
    }//GEN-LAST:event_botonCalcularPMouseClicked

    private void botonCalcularSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCalcularSMouseClicked
        if(precioVenta.getText().equals("") || costoFijo.getText().equals("") || costoVaria.getText().equals(""))
            JOptionPane.showMessageDialog(null,"Se han detectado valores nulos \n","Verifique los datos ingresados", 0);
        else
        {
            try
            {
                setAumentarPrecio();
                setA();
                setC();
                setB();
                setD();
                setBloquear();  
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Ha ocurrido un error, se han detectado valores nulos: \n" + e ,"Verifique los datos ingresados", 0);
            }
        }        
    }//GEN-LAST:event_botonCalcularSMouseClicked

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
    private javax.swing.JButton botonAbrirArchivo;
    private javax.swing.JButton botonBorrar;
    private javax.swing.JButton botonCalcularP;
    private javax.swing.JButton botonCalcularS;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonInicilizar;
    private javax.swing.JTextField costoFijo;
    private javax.swing.JTextField costoVaria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
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
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField precioVenta;
    private javax.swing.JSpinner spinnerAumento;
    private javax.swing.JTextField totalMargen;
    private javax.swing.JTextField totalNMargen;
    private javax.swing.JTextField totalNPuntoPes;
    private javax.swing.JTextField totalNPuntoUnid;
    private javax.swing.JTextField totalPuntoPes;
    private javax.swing.JTextField totalPuntoUnid;
    private javax.swing.JToggleButton verFormulario;
    // End of variables declaration//GEN-END:variables
    GetOperaciones gop;
    NumberFormat formatoImporte;
    NumberFormat formatoNumero;
    private VentanaFormulario vf;
}
