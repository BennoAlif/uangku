/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.view;
import com.github.lgooddatepicker.components.DatePicker;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import uangkuapplication.controller.TransaksiController;
import uangkuapplication.entity.EntityTransaksi;
import uangkuapplication.event.TransaksiListener;
import uangkuapplication.main.UangkuApplication;
import uangkuapplication.model.ModelTransaksi;

import uangkuapplication.view.MainFrame;

/**
 *
 * @author Wildhevire
 */
public class PengeluaranFrame extends javax.swing.JFrame implements TransaksiListener {

    private int idKategori = 0;
    private TransaksiController controller;
    private ModelTransaksi model;

    
    public PengeluaranFrame() {
       
        model = new ModelTransaksi();
        model.setListener(this);
        controller = new TransaksiController();
        controller.setModel(model);
        initComponents();
        for(int i = 0; i<UangkuApplication.kategoriList.size(); i++)
            boxKategori.addItem(UangkuApplication.kategoriList.get(i).getNama_kategori());
        
        
    }
    
    public int getIdKategori() {
        return idKategori;
    }
    public JComboBox<String> getBoxKategori() {
        return boxKategori;
    
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public JTextField getTxtCatatan() {
        return txtCatatan;
    }

    /**
     * Creates new form PengeluaranFrame
     */
    public JTextField getTxtNominal() {    
        return txtNominal;
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
        txtNominal = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        boxKategori = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtCatatan = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        btnSimpanAnggaran = new javax.swing.JButton();
        btnBatalAnggaran = new javax.swing.JButton();
        datePicker = new com.github.lgooddatepicker.components.DatePicker();

        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Tambah Pengeluaran");
        jLabel1.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N

        jLabel2.setText("Rp");
        jLabel2.setFont(new java.awt.Font("Lato", 0, 40)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(235, 87, 87));

        txtNominal.setBorder(null);
        txtNominal.setFont(new java.awt.Font("Lato", 0, 40)); // NOI18N
        txtNominal.setForeground(new java.awt.Color(235, 87, 87));

        boxKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kategori" }));
        boxKategori.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        boxKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxKategoriActionPerformed(evt);
            }
        });

        jLabel3.setText("Catatan");
        jLabel3.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N

        txtCatatan.setBorder(null);

        btnSimpanAnggaran.setText("Simpan");
        btnSimpanAnggaran.setBackground(new java.awt.Color(255, 229, 153));
        btnSimpanAnggaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanAnggaranActionPerformed(evt);
            }
        });

        btnBatalAnggaran.setText("Batal");
        btnBatalAnggaran.setBackground(new java.awt.Color(235, 87, 87));
        btnBatalAnggaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalAnggaranActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCatatan, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNominal))
                    .addComponent(jSeparator1)
                    .addComponent(boxKategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator4)
                    .addComponent(datePicker, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSimpanAnggaran, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(btnBatalAnggaran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(boxKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCatatan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(btnSimpanAnggaran)
                .addGap(18, 18, 18)
                .addComponent(btnBatalAnggaran)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanAnggaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanAnggaranActionPerformed
        // TODO add your handling code here:
        controller.insertPengeluaran(this);
        this.setVisible(false);
    }//GEN-LAST:event_btnSimpanAnggaranActionPerformed

    private void btnBatalAnggaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalAnggaranActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnBatalAnggaranActionPerformed

    private void boxKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxKategoriActionPerformed
        // TODO add your handling code here:
        idKategori = UangkuApplication.findKategoriID(boxKategori.getSelectedItem().toString());

    }//GEN-LAST:event_boxKategoriActionPerformed

   
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
            java.util.logging.Logger.getLogger(PengeluaranFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PengeluaranFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PengeluaranFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PengeluaranFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PengeluaranFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxKategori;
    private javax.swing.JButton btnBatalAnggaran;
    private javax.swing.JButton btnSimpanAnggaran;
    private com.github.lgooddatepicker.components.DatePicker datePicker;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField txtCatatan;
    private javax.swing.JTextField txtNominal;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onChange(ModelTransaksi model) {
        javax.swing.JOptionPane.showMessageDialog(null, "Bisa KONTOL change");
    }

    @Override
    public void onInsert(EntityTransaksi transaksi) {
        //hitung perubahan di uang sekarang disini
        
        javax.swing.JOptionPane.showMessageDialog(null, "Bisa KONTOL pemasukan");
    }


    @Override
    public void onDelete() {
        javax.swing.JOptionPane.showMessageDialog(null, "Bisa KONTOL delete");
    }

    @Override
    public void onUpdate(EntityTransaksi transaksi) {
        javax.swing.JOptionPane.showMessageDialog(null, "Bisa KONTOL update");
    }
}
