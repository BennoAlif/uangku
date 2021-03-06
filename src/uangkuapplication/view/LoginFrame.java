/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.view;
import javax.swing.JOptionPane;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uangkuapplication.impl.*;
import uangkuapplication.entity.EntityPengguna;
import uangkuapplication.database.UangkuDatabase;
import uangkuapplication.main.UangkuApplication;
import uangkuapplication.view.MainFrame;

/**
 *
 * @author Kyoto
 */
public class LoginFrame extends javax.swing.JFrame {
        
    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        loginPanel = new javax.swing.JPanel();
        UnameLabel2 = new javax.swing.JLabel();
        PassLabel = new javax.swing.JLabel();
        LoginButton = new javax.swing.JButton();
        txtLoginName = new javax.swing.JTextField();
        txtLoginPass = new javax.swing.JPasswordField();
        registerLabel = new javax.swing.JLabel();
        registerPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtFullname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnDaftar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login/Register");
        setPreferredSize(new java.awt.Dimension(960, 600));
        setResizable(false);

        main.setBackground(new java.awt.Color(255, 229, 153));

        mainPanel.setPreferredSize(new java.awt.Dimension(320, 600));
        mainPanel.setLayout(new java.awt.CardLayout());

        loginPanel.setBackground(new java.awt.Color(255, 255, 255));
        loginPanel.setPreferredSize(new java.awt.Dimension(320, 600));

        UnameLabel2.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        UnameLabel2.setForeground(new java.awt.Color(38, 50, 56));
        UnameLabel2.setText("Nama user  : ");

        PassLabel.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        PassLabel.setForeground(new java.awt.Color(38, 50, 56));
        PassLabel.setText("Kata sandi :");

        LoginButton.setBackground(new java.awt.Color(255, 229, 153));
        LoginButton.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(38, 50, 56));
        LoginButton.setText("Masuk");
        LoginButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        txtLoginName.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        txtLoginName.setForeground(new java.awt.Color(38, 50, 56));
        txtLoginName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 50, 56)));
        txtLoginName.setPreferredSize(new java.awt.Dimension(2, 24));

        txtLoginPass.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        txtLoginPass.setForeground(new java.awt.Color(38, 50, 56));
        txtLoginPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 50, 56)));
        txtLoginPass.setPreferredSize(new java.awt.Dimension(2, 24));
        txtLoginPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginPassActionPerformed(evt);
            }
        });

        registerLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        registerLabel.setForeground(new java.awt.Color(0, 102, 255));
        registerLabel.setText("Belum punya akun?");
        registerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PassLabel)
                            .addComponent(txtLoginPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(UnameLabel2)
                            .addComponent(txtLoginName, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                            .addComponent(LoginButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(registerLabel)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(UnameLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PassLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLoginPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(registerLabel)
                .addContainerGap(243, Short.MAX_VALUE))
        );

        mainPanel.add(loginPanel, "card2");

        registerPanel.setBackground(new java.awt.Color(255, 255, 255));
        registerPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        jLabel2.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(38, 50, 56));
        jLabel2.setText("Nama :");

        txtFullname.setForeground(new java.awt.Color(38, 50, 56));
        txtFullname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 50, 56)));
        txtFullname.setCaretColor(new java.awt.Color(38, 50, 56));
        txtFullname.setPreferredSize(new java.awt.Dimension(6, 24));

        jLabel4.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(38, 50, 56));
        jLabel4.setText("Nama user :");

        txtUsername.setForeground(new java.awt.Color(38, 50, 56));
        txtUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 50, 56)));
        txtUsername.setCaretColor(new java.awt.Color(38, 50, 56));
        txtUsername.setPreferredSize(new java.awt.Dimension(6, 24));

        jLabel6.setFont(new java.awt.Font("Lato", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(38, 50, 56));
        jLabel6.setText("Kata sandi :");

        txtPassword.setForeground(new java.awt.Color(38, 50, 56));
        txtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(38, 50, 56)));
        txtPassword.setCaretColor(new java.awt.Color(38, 50, 56));
        txtPassword.setPreferredSize(new java.awt.Dimension(6, 24));

        btnDaftar.setBackground(new java.awt.Color(255, 229, 153));
        btnDaftar.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        btnDaftar.setForeground(new java.awt.Color(38, 50, 56));
        btnDaftar.setText("Daftar");
        btnDaftar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(38, 50, 56));
        jLabel7.setText("Kembali ke");

        jLabel8.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 255));
        jLabel8.setText("Login");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout registerPanelLayout = new javax.swing.GroupLayout(registerPanel);
        registerPanel.setLayout(registerPanelLayout);
        registerPanelLayout.setHorizontalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPanelLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFullname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnDaftar, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(registerPanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        registerPanelLayout.setVerticalGroup(
            registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registerPanelLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDaftar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(registerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addContainerGap(186, Short.MAX_VALUE))
        );

        mainPanel.add(registerPanel, "card3");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uangkuapplication/view/assets/Group 1.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/uangkuapplication/view/assets/Statistics 1.png"))); // NOI18N

        javax.swing.GroupLayout mainLayout = new javax.swing.GroupLayout(main);
        main.setLayout(mainLayout);
        mainLayout.setHorizontalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainLayout.createSequentialGroup()
                .addGroup(mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18))
                    .addGroup(mainLayout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mainLayout.setVerticalGroup(
            mainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(mainLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registerLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerLabelMouseClicked
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(registerPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_registerLabelMouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();
        
        mainPanel.add(loginPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_jLabel8MouseClicked
    private void loginAction(){
        Pengguna login;
        EntityPengguna pengguna = null;
        

        try {
            login = new Pengguna(UangkuDatabase.getConnection());
            pengguna = login.login(txtLoginName.getText(), new String( txtLoginPass.getPassword()));  
            
            //if(tx.getText().equals(rs.getString("username")) && txt_pass.getText().equals(rs.getString("password")))
            if(pengguna != null){
                
                
                UangkuApplication.prefs.putBoolean("isLoggedIn", true);
                UangkuApplication.prefs.putInt("UserID", pengguna.getUid());
                UangkuApplication.UserID = pengguna.getUid();
                //UangkuApplication.prefs.put("UserFullName", pengguna.getFullname());
                
                //UangkuApplication.prefs.putInt("Uang", pengguna.getUang());
                
                MainFrame.getInstance(pengguna.getFullname()).setVisible(true);
                PemasukanFrame.getInstance();
                PengeluaranFrame.getInstance();
                AnggaranFrame.getInstance();
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Username atau Password salah silakan coba lagi");
            }
            PemasukanFrame.getInstance().deleteInstance();
            PengeluaranFrame.getInstance().deleteInstance();
            AnggaranFrame.getInstance().deleteInstance();
           
            
            
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
       
    }
    private void daftarAction(){
        Pengguna login;
        EntityPengguna pengguna;
        try {
            login = new Pengguna(UangkuDatabase.getConnection());
            pengguna= new EntityPengguna();

            // TODO add your handling code here:
            pengguna.setFullname(txtFullname.getText());
            pengguna.setUsername(txtUsername.getText());
            pengguna.setPassword(new String(txtPassword.getPassword()));
            login.register(pengguna);
            JOptionPane.showMessageDialog(null, "Daftar Sukses");
            mainPanel.removeAll();
            mainPanel.repaint();
            mainPanel.revalidate();

            mainPanel.add(loginPanel);
            mainPanel.repaint();
            mainPanel.revalidate();

        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
            
            
    }
    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        loginAction();
    }//GEN-LAST:event_LoginButtonActionPerformed
    private void btnDaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaftarActionPerformed
        daftarAction();
        
    }//GEN-LAST:event_btnDaftarActionPerformed

    private void txtLoginPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginPassActionPerformed

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel PassLabel;
    private javax.swing.JLabel UnameLabel2;
    private javax.swing.JButton btnDaftar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPanel main;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel registerLabel;
    private javax.swing.JPanel registerPanel;
    private javax.swing.JTextField txtFullname;
    private javax.swing.JTextField txtLoginName;
    private javax.swing.JPasswordField txtLoginPass;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
