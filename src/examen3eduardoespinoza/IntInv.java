/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package examen3eduardoespinoza;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Edu
 */
public class IntInv extends javax.swing.JFrame {
FileWriter Texto=null;
 PrintWriter pw = null;
  boolean EstaProd = false;
  DefaultTableModel dataModel = new DefaultTableModel();
  String Esta = "";



  
    public IntInv() {
        initComponents();
        String[] columnas = new String[]{"CODIGO", "DESCRIPCION","CANTIDAD","TIPO","ACTIVO","PRECIO"};
        dataModel.setColumnIdentifiers(columnas);
        TablaProductos.setModel(dataModel);
    }
  public void TotalPrecio(){
        float Numero1=0, Numero2=0, Total=0;
        Numero1 = Float.parseFloat(TCanP.getText());
        Numero2 = Float.parseFloat(TPreP.getText());
        Total = Numero1 * Numero2;
        TPreP.setText(String.valueOf(Total));
  }   
    
 public void ConsultaTenerProducto() {
  if (BSI.isSelected()) {
            EstaProd = true;
            if (EstaProd == true) {
                Esta = BSI.getText();
            }
        } else if (BNO.isSelected()) {
            EstaProd = false;
            if (EstaProd == false) {
                Esta = BNO.getText();
            }
        }
 }
 
 public void Agregar() {
     TotalPrecio();
 ConsultaTenerProducto();
 dataModel.addRow(new Object[]{TCodP.getText(), TDescP.getText(),TCanP.getText(),ComboTipos.getItemAt(0),Esta,TPreP.getText()});
 }
 public void modificar() {
TotalPrecio();
        int fila = TablaProductos.getSelectedRow();
            dataModel.setValueAt(TCodP.getText(), fila, 0);
        dataModel.setValueAt( TDescP.getText(), fila, 1);
        dataModel.setValueAt(TCanP.getText(), fila, 2);
        ConsultaTenerProducto() ;
        dataModel.setValueAt(ComboTipos.getItemAt(0), fila, 3);
        dataModel.setValueAt(Esta, fila, 4);
        dataModel.setValueAt(TPreP, fila, 5);
 }
    public void Eliminar() {
        int fila = TablaProductos.getSelectedRow();
        dataModel.removeRow(fila); }
 
 
 public void Salvar_Datos() {
 ClsProducto.SetGuardar_Datos(Integer.valueOf(TCodP.getText()), Integer.valueOf(TCanP.getText()), TDescP.getText(), Integer.valueOf(TPreP.getText()), EstaProd);
 try{
   Texto = new FileWriter("C:/temp/articulo/"+TDescP.getText()+".txt");
   pw = new PrintWriter(Texto);
           pw.println("Codigo: " + TCodP.getText());
           pw.println("Cantidad: " + TCanP.getText());
           pw.println("Descripcion: " + TDescP.getText());
           pw.println("Precio: " +TPreP.getText());
            if(null!=Texto){
            Texto.close();
            }
   }
 catch(Exception e){e.printStackTrace();} 
 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TCodP = new javax.swing.JTextField();
        TCanP = new javax.swing.JTextField();
        TDescP = new javax.swing.JTextField();
        ComboTipos = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TPreP = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProductos = new javax.swing.JTable();
        BAg = new javax.swing.JButton();
        BBor = new javax.swing.JButton();
        BMod = new javax.swing.JButton();
        BReporte = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        BSI = new javax.swing.JRadioButton();
        BNO = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("CONTROL DE INVENTARIO");

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Edu\\Desktop\\output-onlinepngtools.png")); // NOI18N

        jLabel2.setText("Codigo");

        jLabel4.setText("Cantidad");

        jLabel5.setText("Descripcion");

        ComboTipos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desechables", "comestibles", "abarrotes", "ropa" }));

        jLabel6.setText("Tipo");

        jLabel7.setText("Precio");

        TablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(TablaProductos);

        BAg.setText("Agregar");
        BAg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAgActionPerformed(evt);
            }
        });

        BBor.setText("Borrar");
        BBor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBorActionPerformed(evt);
            }
        });

        BMod.setText("Modificar");
        BMod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BModActionPerformed(evt);
            }
        });

        BReporte.setText("Reporte");
        BReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BReporteActionPerformed(evt);
            }
        });

        jLabel8.setText("(Tambien guardar txt)");

        jLabel9.setText("Activo");

        buttonGroup1.add(BSI);
        BSI.setText("Si");

        buttonGroup1.add(BNO);
        BNO.setText("No");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TCanP))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(TCodP, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jLabel5))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TDescP, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ComboTipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(TPreP))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BSI)
                                        .addGap(30, 30, 30)
                                        .addComponent(BNO)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap(85, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BBor, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BAg, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BMod)
                    .addComponent(BReporte))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(TCodP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(TCanP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(TDescP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboTipos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(TPreP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BSI)
                                .addComponent(BNO)))
                        .addGap(20, 20, 20)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BMod)
                            .addComponent(BAg))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BReporte)
                            .addComponent(BBor))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BReporteActionPerformed
this.hide();
        new ReporteProd().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_BReporteActionPerformed

    private void BAgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAgActionPerformed
    Salvar_Datos();
    Agregar();
    
    }//GEN-LAST:event_BAgActionPerformed

    private void BModActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BModActionPerformed
        modificar();
    }//GEN-LAST:event_BModActionPerformed

    private void BBorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBorActionPerformed
        Eliminar();
    }//GEN-LAST:event_BBorActionPerformed

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
            java.util.logging.Logger.getLogger(IntInv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IntInv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IntInv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IntInv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IntInv().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAg;
    private javax.swing.JButton BBor;
    private javax.swing.JButton BMod;
    private javax.swing.JRadioButton BNO;
    private javax.swing.JButton BReporte;
    private javax.swing.JRadioButton BSI;
    private javax.swing.JComboBox<String> ComboTipos;
    private javax.swing.JTextField TCanP;
    private javax.swing.JTextField TCodP;
    private javax.swing.JTextField TDescP;
    private javax.swing.JTextField TPreP;
    private javax.swing.JTable TablaProductos;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
