package Presupuestos;

//Cesar Julio Beltran - Costos y Presupuestos

import com.sun.awt.AWTUtilities;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class VentanaCargaSistema extends javax.swing.JFrame 
{
    
    public VentanaCargaSistema() 
    {
        initComponents();
        
        //
        this.setLocationRelativeTo(null); 
        
        //
        AWTUtilities.setWindowOpaque(this, false);        
        
        al = new ActionListener() 
        {
        
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                //
                x += 1;
                
                //
                barraDeProgreso.setValue(x);   
                
                //
                if(barraDeProgreso.getValue() == 1)
                    mostrarCarga.setText("Cargando");
                if(barraDeProgreso.getValue() == 20)
                    mostrarCarga.setText("Cargando recursos");
                if(barraDeProgreso.getValue() == 45)
                    mostrarCarga.setText("Iniciando componentes");
                if(barraDeProgreso.getValue() == 65)
                    mostrarCarga.setText("Inciando proyecto");
                if(barraDeProgreso.getValue() == 80)
                    mostrarCarga.setText("Abriendo proyecto");
                if(barraDeProgreso.getValue() == 100)
                {
                    dispose();
                    VentanaPrincipalSistema vps = new VentanaPrincipalSistema();
                    vps.setVisible(true);
                    tm.stop();
                }
            }
        };
        
        //
        tm = new Timer(100, al); //80
        
        // 
        tm.start(); 
        
        //Icono de la Ventana
        try{
            Image image = new ImageIcon(this.getClass().getResource("/Imagenes/iconoSistema.png")).getImage(); 
            this.setIconImage(image);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Existe un error: " + e,"Icono de la ventana+", 2);
        }   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagenCarga = new javax.swing.JLabel();
        mostrarCarga = new javax.swing.JLabel();
        barraDeProgreso = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Presupuestos");
        setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        setName("frameCargaSistema"); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(null);

        imagenCarga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagenCarga.png"))); // NOI18N
        getContentPane().add(imagenCarga);
        imagenCarga.setBounds(10, 0, 260, 270);

        mostrarCarga.setFont(new java.awt.Font("Arial Nova Light", 1, 12)); // NOI18N
        mostrarCarga.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mostrarCarga.setText("Cargando...");
        getContentPane().add(mostrarCarga);
        mostrarCarga.setBounds(20, 270, 240, 20);
        getContentPane().add(barraDeProgreso);
        barraDeProgreso.setBounds(10, 270, 260, 20);

        setBounds(0, 0, 280, 296);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VentanaCargaSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCargaSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCargaSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCargaSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaCargaSistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraDeProgreso;
    private javax.swing.JLabel imagenCarga;
    private javax.swing.JLabel mostrarCarga;
    // End of variables declaration//GEN-END:variables
    private Timer tm;
    private ActionListener al;
    private int x;  
}
