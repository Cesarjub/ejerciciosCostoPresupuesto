package Presupuestos;

//Cesar Julio Beltran - Costos y Presupuestos

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class PanelEjercicioUno extends javax.swing.JPanel 
{
       float op1 = 0.0f;
       float op2 = 0.0f;
       float op3 = 0.0f;
       float op4 = 0.0f;
    
    public PanelEjercicioUno() 
    {
        initComponents();
        
        formatoImporte = NumberFormat.getCurrencyInstance();
        
        vf = new VentanaFormulario(1);
        gop = new GetOperaciones();
        
        //Tabla de operaciones
        th1 = tablaOperaciones.getTableHeader();        
        
        setBloquear(false);
        
        DefaultTableCellRenderer renderer1 = (DefaultTableCellRenderer) 
                tablaOperaciones.getTableHeader().getDefaultRenderer(); 
        
        renderer1.setHorizontalAlignment(0);        
        
        th1.setReorderingAllowed(false);

        th1.setFont(new Font("Calibri", Font.PLAIN, 13));
        
        th1.setForeground(Color.BLACK);  
        
        th1.setResizingAllowed(false);

        dtm1.fireTableDataChanged();

        tablaOperaciones.setModel(dtm1); 
        
        setInicializar();
        
        //Tabla de resultado
        th2 = tablaResultado.getTableHeader();        
        
        dtm2 = new DefaultTableModel(filas2, columnas2)
        {
            public boolean isCellEditable(int fil, int col)
            {
                return false;
            }
        };   
        
        DefaultTableCellRenderer renderer2 = (DefaultTableCellRenderer) 
                tablaResultado.getTableHeader().getDefaultRenderer(); 
        
        renderer2.setHorizontalAlignment(0);        
        
        th2.setReorderingAllowed(false);

        th2.setFont(new Font("Calibri", Font.PLAIN, 13));
        
        th2.setForeground(Color.BLACK);  
        
        th2.setResizingAllowed(false);

        dtm2.fireTableDataChanged();

        tablaResultado.setModel(dtm2); 
        
        textCostoFijo.setEditable(false);
        textUD.setEditable(false);
        
        resulUOp.setEditable(false);
        resulUDI.setEditable(false);
        
        spinnerTasa.setEditor(new JSpinner.DefaultEditor(spinnerTasa));
        spinnerUtilidad.setEditor(new JSpinner.DefaultEditor(spinnerUtilidad));
        
        spinnerTasa.setEnabled(false);
        spinnerUtilidad.setEnabled(false);
    }
    
    public void setInicializar()
    {
        dtm1.addRow(new Object[] {"25.00", "20.00"});
        dtm1.addRow(new Object[] {"30.00", "40.00"});
        dtm1.addRow(new Object[] {"50.00", "30.00"});
        dtm1.addRow(new Object[] {"22.00", "10.00"});
        
        tablaOperaciones.setModel(dtm1);
        
        textCostoFijo.setText("4500200");
        textUD.setText("1000000");
        
        spinnerTasa.setValue(38);
        spinnerUtilidad.setValue(25);
    }
    
    public void setModificar()
    {
        textCostoFijo.setEditable(true);
        textUD.setEditable(true);
        
        spinnerTasa.setEnabled(true);
        spinnerUtilidad.setEnabled(true);
    }
    
    public void setBorrar()
    {        
        int a = tablaOperaciones.getRowCount()-1;
        
        for (int i = a; i >= 0; i--) 
        {
            dtm1.removeRow(dtm1.getRowCount()-1);             
        }
        
        tablaOperaciones.setModel(dtm1);
        
        textCostoFijo.setText(null);
        textUD.setText(null); 
        
        spinnerTasa.setValue(0);
        spinnerUtilidad.setValue(0);
    }
    
    public void setBloquear(boolean op)
    {
        dtm1 = new DefaultTableModel(filas1, columnas1)
        {
            public boolean isCellEditable(int fil, int col)
            {
                return op;
            }
        };   

        dtm1.fireTableStructureChanged();
        
        tablaOperaciones.setModel(dtm1);
        
        textCostoFijo.setEditable(false);
        textUD.setEditable(false);  
        
        spinnerTasa.setEnabled(false);
        spinnerUtilidad.setEnabled(false);
    }
    
    public void setBorrarResultado()
    {
        int a = tablaResultado.getRowCount()-1;
        
        for (int i = a; i >= 0; i--) 
        {
            dtm2.removeRow(dtm2.getRowCount()-1);             
        }
        
        tablaResultado.setModel(dtm2);
        
        resulUOp.setText(null);
        
        resulUDI.setText(null);
    }
    
    public void setA()
    { 
        float temp1 = 0.0f;
        
        temp1 = Float.parseFloat((String)dtm1.getValueAt(0, 0)) * Float.parseFloat((String)dtm1.getValueAt(0, 1));
        
        temp1 /= 100;
        
        op1 = gop.getEquilibrioPeso(Float.parseFloat(textCostoFijo.getText().toString()), temp1);
        
        float temp2 = 0.0f;
        
        temp2 = Float.parseFloat((String)dtm1.getValueAt(1, 0)) * Float.parseFloat((String)dtm1.getValueAt(1, 1));
        
        temp2 /= 100;        
        
        op2 = gop.getEquilibrioPeso(Float.parseFloat(textCostoFijo.getText().toString()), temp2);
        
        float temp3 = 0.0f;
        
        temp3 = Float.parseFloat((String)dtm1.getValueAt(2, 0)) * Float.parseFloat((String)dtm1.getValueAt(2, 1));
        
        temp3 /= 100;            
        
        op3 = gop.getEquilibrioPeso(Float.parseFloat(textCostoFijo.getText().toString()), temp3);
        
        float temp4 = 0.0f;
        
        temp4 = Float.parseFloat((String)dtm1.getValueAt(3, 0)) * Float.parseFloat((String)dtm1.getValueAt(3, 1));
        
        temp4 /= 100;           
        
        op4 = gop.getEquilibrioPeso(Float.parseFloat(textCostoFijo.getText().toString()), temp4);

        dtm2.addRow(new Object[] {formatoImporte.format(op1)});
        dtm2.addRow(new Object[] {formatoImporte.format(op2)});
        dtm2.addRow(new Object[] {formatoImporte.format(op3)});
        dtm2.addRow(new Object[] {formatoImporte.format(op4)});
       
        tablaResultado.setModel(dtm2);
    }
    
    public void setB()
    {
        float result = 0.0f;
        
        float suma = 0.0f, mc = 0.0f;

        suma = op1 + op2 + op3 + op4;

        for (int i = 0; i < tablaOperaciones.getRowCount(); i++) 
        {
            mc += Float.parseFloat(dtm1.getValueAt(i, 0).toString());
        }  
        
        result = gop.getMargenSobreVentas(suma, Float.parseFloat(spinnerUtilidad.getValue().toString()), mc);
        
        resulUOp.setText(formatoImporte.format(result));
    }
    
    public void setC()
    {
        int result = 0;
        
        float suma = 0.0f;
        float tasa = Float.parseFloat(spinnerTasa.getValue().toString());
        
        for (int i = 0; i < tablaOperaciones.getRowCount(); i++) 
        {
            suma += Float.parseFloat(dtm1.getValueAt(i, 0).toString());
        }     
       
        result = gop.getUtilidadDespuesImpuestos(Float.parseFloat(textCostoFijo.getText()), Float.parseFloat(textUD.getText()), tasa, suma);
        
        resulUDI.setText(formatoImporte.format(result));
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
        botonIniciar = new javax.swing.JButton();
        botonCalcularS = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaOperaciones = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaResultado = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        textCostoFijo = new javax.swing.JTextField();
        botonCalcularP = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        resulUOp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        spinnerUtilidad = new javax.swing.JSpinner();
        textUD = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        resulUDI = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        spinnerTasa = new javax.swing.JSpinner();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ejercicio 1");
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
        botonAbrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbrirArchivoActionPerformed(evt);
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

        botonIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/iniciar.png"))); // NOI18N
        botonIniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonIniciar.setFocusable(false);
        botonIniciar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonIniciar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonIniciarMouseClicked(evt);
            }
        });
        jToolBar1.add(botonIniciar);

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
        jLabel3.setText("Jimenez comercial");
        add(jLabel3);
        jLabel3.setBounds(0, 74, 730, 30);

        tablaOperaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Margen de contribucion", "Participacion en Vtas. totales"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaOperaciones.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaOperaciones.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tablaOperacionesKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tablaOperaciones);
        if (tablaOperaciones.getColumnModel().getColumnCount() > 0) {
            tablaOperaciones.getColumnModel().getColumn(0).setResizable(false);
            tablaOperaciones.getColumnModel().getColumn(1).setResizable(false);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(140, 120, 400, 110);

        tablaResultado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Punto de equilibrio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaResultado.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaResultado.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablaResultado);
        if (tablaResultado.getColumnModel().getColumnCount() > 0) {
            tablaResultado.getColumnModel().getColumn(0).setResizable(false);
        }

        add(jScrollPane2);
        jScrollPane2.setBounds(560, 120, 140, 110);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Costos fijos:");
        add(jLabel4);
        jLabel4.setBounds(20, 250, 80, 30);

        textCostoFijo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textCostoFijoKeyTyped(evt);
            }
        });
        add(textCostoFijo);
        textCostoFijo.setBounds(120, 250, 120, 30);

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
        botonCalcularP.setBounds(450, 360, 90, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Utilidad de operacion de");
        add(jLabel5);
        jLabel5.setBounds(270, 250, 150, 30);

        resulUOp.setBackground(new java.awt.Color(255, 255, 0));
        resulUOp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        add(resulUOp);
        resulUOp.setBounds(520, 250, 130, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("%:");
        add(jLabel6);
        jLabel6.setBounds(490, 250, 20, 30);
        add(spinnerUtilidad);
        spinnerUtilidad.setBounds(430, 250, 60, 30);

        textUD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textUDKeyTyped(evt);
            }
        });
        add(textUD);
        textUD.setBounds(120, 300, 120, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("UDI:");
        add(jLabel7);
        jLabel7.setBounds(30, 300, 70, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Tasa:");
        add(jLabel8);
        jLabel8.setBounds(40, 350, 70, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Utilidad despues de impuestos:");
        add(jLabel9);
        jLabel9.setBounds(260, 300, 200, 30);

        resulUDI.setBackground(new java.awt.Color(255, 255, 0));
        resulUDI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        resulUDI.setSelectedTextColor(new java.awt.Color(255, 51, 51));
        add(resulUDI);
        resulUDI.setBounds(470, 300, 120, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("$");
        add(jLabel12);
        jLabel12.setBounds(100, 250, 20, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("$");
        add(jLabel13);
        jLabel13.setBounds(100, 300, 20, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("%");
        add(jLabel14);
        jLabel14.setBounds(180, 350, 20, 30);
        add(spinnerTasa);
        spinnerTasa.setBounds(120, 350, 60, 30);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Linea blanca"},
                {"Herramientas"},
                {"Accesorios"},
                {"Electronica"}
            },
            new String [] {
                "Departamentos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setResizable(false);
        }

        add(jScrollPane3);
        jScrollPane3.setBounds(30, 120, 120, 110);
    }// </editor-fold>//GEN-END:initComponents

    private void botonIniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonIniciarMouseClicked
        setBloquear(false);
        setBorrarResultado();
        setBorrar();
        setInicializar();
    }//GEN-LAST:event_botonIniciarMouseClicked

    private void botonEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEditarMouseClicked
        Object lineaUno = dtm1.getValueAt(0, 0);
        Object lineaDos = dtm1.getValueAt(0, 1);
        
        Object herrUno = dtm1.getValueAt(1, 0);
        Object herrDos = dtm1.getValueAt(1, 1);
        
        Object accUno = dtm1.getValueAt(2, 0);
        Object accDos = dtm1.getValueAt(2, 1);
        
        Object elecUno = dtm1.getValueAt(3, 0);
        Object elecDos = dtm1.getValueAt(3, 1);
        
        String cf = textCostoFijo.getText();
        String ud = textUD.getText();
        
        Object ts = spinnerTasa.getValue();
        Object ut = spinnerUtilidad.getValue();
        
        setBloquear(true);
        setModificar();
        setBorrarResultado();
        setBorrar();
        
        dtm1.addRow(new Object[] {lineaUno, lineaDos});
        dtm1.addRow(new Object[] {herrUno, herrDos});
        dtm1.addRow(new Object[] {accUno, accDos});
        dtm1.addRow(new Object[] {elecUno, elecDos});
        
        tablaOperaciones.setModel(dtm1);
        
        textCostoFijo.setText(cf);
        textUD.setText(ud);
        
        spinnerTasa.setValue(ts);
        spinnerUtilidad.setValue(ut);
    }//GEN-LAST:event_botonEditarMouseClicked

    private void botonBorrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonBorrarMouseClicked
        setBloquear(false);
        setBorrarResultado();
        setBorrar();
        
        dtm1.addRow(new Object[] {"0", "0"});
        dtm1.addRow(new Object[] {"0", "0"});
        dtm1.addRow(new Object[] {"0", "0"});
        dtm1.addRow(new Object[] {"0", "0"});
        
        tablaOperaciones.setModel(dtm1);
    }//GEN-LAST:event_botonBorrarMouseClicked

    private void textCostoFijoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textCostoFijoKeyTyped
    char c = evt.getKeyChar();
    
    if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
        evt.consume();

    if (c == '.' && textCostoFijo.getText().contains("."))
        evt.consume();
    }//GEN-LAST:event_textCostoFijoKeyTyped

    private void textUDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textUDKeyTyped
    char c = evt.getKeyChar();
    
    if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != '.'))
        evt.consume();

    if (c == '.' && textUD.getText().contains("."))
        evt.consume();
    }//GEN-LAST:event_textUDKeyTyped

    private void tablaOperacionesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaOperacionesKeyTyped
        char car = evt.getKeyChar();
        
        if((car<'0' || car>'9')) 
            evt.consume();
    }//GEN-LAST:event_tablaOperacionesKeyTyped

    private void botonCalcularPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCalcularPMouseClicked
        int bnd = 0;
        
        for (int i = 0; i < dtm1.getRowCount(); i++) 
        {
            if(dtm1.getValueAt(i, 0).toString().equals("0")||dtm1.getValueAt(i, 0).toString().equals("00")||dtm1.getValueAt(i, 0).toString().equals("0.0"))
                bnd ++;
        }
        
        if(bnd <= 0)
        {
            try
            {
                setBorrarResultado();
                setA();
                setB();
                setC();    
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Ha ocurrido un error, se han detectado valores nulos: \n" + e ,"Verifique los datos ingresados", 0);
            }
        }
        else
            JOptionPane.showMessageDialog(null,"Se han detectado valores nulos.","Verifique los datos ingresados", 0);
                        
    }//GEN-LAST:event_botonCalcularPMouseClicked

    private void botonCalcularSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCalcularSMouseClicked
        int bnd = 0;
        
        for (int i = 0; i < dtm1.getRowCount(); i++) 
        {
            if(dtm1.getValueAt(i, 0).toString().equals("0")||dtm1.getValueAt(i, 0).toString().equals("00")||dtm1.getValueAt(i, 0).toString().equals("0.0"))
                bnd ++;
        }
        
        if(bnd <= 0)
        {
            try
            {
                setBorrarResultado();
                setA();
                setB();
                setC();    
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Ha ocurrido un error, se han detectado valores nulos: \n" + e ,"Verifique los datos ingresados", 0);
            }
        }
        else
            JOptionPane.showMessageDialog(null,"Se han detectado valores nulos.","Verifique los datos ingresados", 0);
              
    }//GEN-LAST:event_botonCalcularSMouseClicked

    private void botonAbrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAbrirArchivoActionPerformed
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
    }//GEN-LAST:event_botonAbrirArchivoActionPerformed

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
    private javax.swing.JButton botonIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField resulUDI;
    private javax.swing.JTextField resulUOp;
    private javax.swing.JSpinner spinnerTasa;
    private javax.swing.JSpinner spinnerUtilidad;
    private javax.swing.JTable tablaOperaciones;
    private javax.swing.JTable tablaResultado;
    private javax.swing.JTextField textCostoFijo;
    private javax.swing.JTextField textUD;
    private javax.swing.JToggleButton verFormulario;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel dtm1, dtm2;
    private JTableHeader th1, th2; 
    private GetOperaciones gop;
    private VentanaFormulario vf;
    
    NumberFormat formatoImporte;
    
    String filas1 [][] = {};
    String columnas1 [] = {"Margen de contribucion", "Participacion en Vtas. totales"};  
    
    String filas2 [][] = {};
    String columnas2 [] = {"Punto de equilibrio"};  
}
