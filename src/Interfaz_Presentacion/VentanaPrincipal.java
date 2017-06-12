package Interfaz_Presentacion;

import Balanceada.OrdenamientoBalanceada;
import Directa.OrdenamientoDirecta;
import Natural.OrdenamientoNatural;
import Polifase.OrdenacionPolifase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;


/**
 *
 * @author edwin
 */
public class VentanaPrincipal extends javax.swing.JFrame {

   private OrdenacionPolifase ordenamientoPolifasico;
   private OrdenamientoDirecta ordenamientoDirecta;
   private OrdenamientoNatural ordenamientoNatural;
   private OrdenamientoBalanceada ordenamientoBalanceado;
   private String nombreArchivo="...";
   private int index=0;
   private long tiempoNatural=0;
   private long tiempoDirecto=0;
   private long tiempoPolifasico=0;
   private long tiempoBalanceado=0;
   private int x = 0;
   private Timer timer = null;
   
    public VentanaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboBoxCampo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnExplorador = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        canvas1 = new java.awt.Canvas();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textBalanceado = new javax.swing.JTextField();
        textNatural = new javax.swing.JTextField();
        textDirecto = new javax.swing.JTextField();
        textPolifasico = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        barraProgreso = new javax.swing.JProgressBar();
        jPanel4 = new javax.swing.JPanel();
        btnBalanceado = new javax.swing.JButton();
        btnNatural = new javax.swing.JButton();
        btnDirecto = new javax.swing.JButton();
        btnPolifasico = new javax.swing.JButton();
        txtAbrir = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Métodos de Ordenación Externa");

        jLabel2.setText("Nombre del archivo:");

        jLabel3.setText("Campo:");

        comboBoxCampo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entero", "Texto", "Booleano", "Fecha" }));
        comboBoxCampo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCampoActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Método");

        btnExplorador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/explorador.png"))); // NOI18N
        btnExplorador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExploradorActionPerformed(evt);
            }
        });

        jLabel5.setText("Abrir:");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Tiempo:");

        jLabel7.setText("Balanceado");

        jLabel8.setText("Natural");

        jLabel9.setText("Directo");

        jLabel10.setText("Polifásico");

        textBalanceado.setEditable(false);

        textNatural.setEditable(false);
        textNatural.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNaturalActionPerformed(evt);
            }
        });

        textDirecto.setEditable(false);

        textPolifasico.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(textBalanceado, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textNatural, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(textDirecto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(textPolifasico, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textBalanceado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNatural, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDirecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPolifasico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        barraProgreso.setMaximum(60);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barraProgreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(barraProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnBalanceado.setText("Balanceado");
        btnBalanceado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBalanceadoActionPerformed(evt);
            }
        });

        btnNatural.setText("Natural");
        btnNatural.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNaturalActionPerformed(evt);
            }
        });

        btnDirecto.setText("Directo");
        btnDirecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDirectoActionPerformed(evt);
            }
        });

        btnPolifasico.setText("Polifasico");
        btnPolifasico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPolifasicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBalanceado)
                .addGap(18, 18, 18)
                .addComponent(btnNatural, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDirecto, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPolifasico, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBalanceado)
                    .addComponent(btnNatural)
                    .addComponent(btnDirecto)
                    .addComponent(btnPolifasico))
                .addGap(33, 33, 33))
        );

        txtAbrir.setEditable(false);
        txtAbrir.setText("...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(240, 240, 240)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(2, 2, 2)
                                .addComponent(txtAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnExplorador, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addContainerGap(114, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel5)
                        .addComponent(txtAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnExplorador, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboBoxCampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void funcionalidadBarra(int tiempo){
        
        ActionListener actionListener;
        x=0;
        actionListener = new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                x = x+60;
                barraProgreso.setValue(x);
                if(barraProgreso.getValue()==60){
                    JOptionPane.showMessageDialog(null,"Ordenado Correctamente", "Exito",JOptionPane.CANCEL_OPTION);
                    timer.stop();
                    barraProgreso.setValue(0);
                    
                }
            }
        };
        timer = new Timer(tiempo, actionListener);
        timer.start();
        
    }
    private void btnNaturalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNaturalActionPerformed
       try {
           if(!archivoValido(nombreArchivo)){
               JOptionPane.showMessageDialog(null,"Archivo no valido", "Error",JOptionPane.ERROR_MESSAGE);
           }else{
               long start = System.currentTimeMillis();
               ordenamientoNatural = new OrdenamientoNatural(index, nombreArchivo);
               tiempoNatural = (System.currentTimeMillis() - start);
               funcionalidadBarra((int)tiempoNatural);
               textNatural.setText(Long.toString(tiempoNatural));
           }
       } catch (Exception ex) {
           Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_btnNaturalActionPerformed

    private void comboBoxCampoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCampoActionPerformed
        index = comboBoxCampo.getSelectedIndex();
        
    }//GEN-LAST:event_comboBoxCampoActionPerformed

    private void textNaturalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNaturalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNaturalActionPerformed

    private void btnExploradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExploradorActionPerformed
       nombreArchivo= abrirArchivo();
       txtAbrir.setText(nombreArchivo);
       if(archivoValido(nombreArchivo)){
           System.out.println("Es un archivo valido");
       }else{
           JOptionPane.showMessageDialog(null,"Archivo no valido", "Error",JOptionPane.ERROR_MESSAGE);
       }
       
       
    }//GEN-LAST:event_btnExploradorActionPerformed

    private void btnPolifasicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPolifasicoActionPerformed
        try{
           if(!archivoValido(nombreArchivo)){
               JOptionPane.showMessageDialog(null,"Archivo no valido", "Error",JOptionPane.ERROR_MESSAGE);
           } else{
               long start = System.currentTimeMillis();
               ordenamientoPolifasico = new OrdenacionPolifase();
               ordenamientoPolifasico.sort(index ,nombreArchivo);
               tiempoPolifasico = (System.currentTimeMillis()-start);
               funcionalidadBarra((int)tiempoPolifasico);
               textPolifasico.setText(Long.toString(tiempoPolifasico));
           }
           
        } catch (IOException ex) {
           Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
           Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPolifasicoActionPerformed
    
    private boolean archivoValido(String nombreArch){
        System.out.println(nombreArch);
        return nombreArch.endsWith(".csv");
    }
    private void btnDirectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDirectoActionPerformed
       try {
           if(!archivoValido(nombreArchivo)){
               JOptionPane.showMessageDialog(null,"Archivo no valido", "Error",JOptionPane.ERROR_MESSAGE);
           }else{
                long start = System.currentTimeMillis();
                ordenamientoDirecta = new OrdenamientoDirecta(index, nombreArchivo);
                tiempoDirecto = (System.currentTimeMillis() - start);
                funcionalidadBarra((int)tiempoDirecto);
                textDirecto.setText(Long.toString(tiempoDirecto));
           }
       } catch (IOException ex) {
           Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ParseException ex) {
           Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }//GEN-LAST:event_btnDirectoActionPerformed

    private void btnBalanceadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBalanceadoActionPerformed
        try{
           if(!archivoValido(nombreArchivo)){
               JOptionPane.showMessageDialog(null,"Archivo no valido", "Error",JOptionPane.ERROR_MESSAGE);
           } else{
               long start = System.currentTimeMillis();
               ordenamientoBalanceado = new OrdenamientoBalanceada();
               ordenamientoBalanceado.sort(index ,nombreArchivo);
               tiempoBalanceado = (System.currentTimeMillis()-start);
               funcionalidadBarra((int)tiempoBalanceado);
               textBalanceado.setText(Long.toString(tiempoBalanceado));
           }
           
        } catch (IOException ex) {
           Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
           Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBalanceadoActionPerformed

    private String abrirArchivo() {
        
        JFileChooser file=new JFileChooser();
        file.showOpenDialog(this);
        File abre=file.getSelectedFile();
        return abre.getName();
    }
        
    
    
    
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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraProgreso;
    private javax.swing.JButton btnBalanceado;
    private javax.swing.JButton btnDirecto;
    private javax.swing.JButton btnExplorador;
    private javax.swing.JButton btnNatural;
    private javax.swing.JButton btnPolifasico;
    private java.awt.Canvas canvas1;
    private javax.swing.JComboBox<String> comboBoxCampo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField textBalanceado;
    private javax.swing.JTextField textDirecto;
    private javax.swing.JTextField textNatural;
    private javax.swing.JTextField textPolifasico;
    private javax.swing.JTextField txtAbrir;
    // End of variables declaration//GEN-END:variables

    private ActionListener ActionListener() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
