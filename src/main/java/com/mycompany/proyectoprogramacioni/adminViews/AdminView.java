/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoprogramacioni.adminViews;

import com.mycompany.proyectoprogramacioni.Login;
import com.mycompany.proyectoprogramacioni.Main;
import com.mycompany.proyectoprogramacioni.adminViews.CreateUser;

/**
 *
 * @author dubavenxp
 */
public class AdminView extends javax.swing.JFrame {

    /**
     * Creates new form AdminLogin
     */
    public AdminView() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        createUsers = new javax.swing.JMenuItem();
        modifyUsers = new javax.swing.JMenuItem();
        viewUsers = new javax.swing.JMenuItem();
        exportUsers = new javax.swing.JMenuItem();
        importUsers = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        createProduct = new javax.swing.JMenuItem();
        modifyProduct = new javax.swing.JMenuItem();
        viewProduct = new javax.swing.JMenuItem();
        exportProducts = new javax.swing.JMenuItem();
        ImportProducts = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        logout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setText("Universidad: Mariano Galvez");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel2.setText("Nombre: Alejandro Sebastian Dubon Estrada");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel3.setText("Carnet: 3190-20-921");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel4.setText("Curso: Programacion I");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel5.setText("Tercer Semestre");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel6.setText("Mi perfil");

        jMenu1.setText("Usuarios");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });

        createUsers.setText("Crear usuarios");
        createUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createUsersMouseClicked(evt);
            }
        });
        createUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUsersActionPerformed(evt);
            }
        });
        jMenu1.add(createUsers);

        modifyUsers.setText("Modificar usuarios");
        modifyUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyUsersActionPerformed(evt);
            }
        });
        jMenu1.add(modifyUsers);

        viewUsers.setText("Consultar usuarios");
        viewUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewUsersMouseClicked(evt);
            }
        });
        viewUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewUsersActionPerformed(evt);
            }
        });
        jMenu1.add(viewUsers);

        exportUsers.setText("Exportar usuarios");
        exportUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportUsersActionPerformed(evt);
            }
        });
        jMenu1.add(exportUsers);

        importUsers.setText("Importar usuarios");
        importUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importUsersActionPerformed(evt);
            }
        });
        jMenu1.add(importUsers);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Productos");

        createProduct.setText("Crear producto");
        createProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createProductMouseClicked(evt);
            }
        });
        createProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createProductActionPerformed(evt);
            }
        });
        jMenu2.add(createProduct);

        modifyProduct.setText("Modificar producto");
        modifyProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifyProductMouseClicked(evt);
            }
        });
        modifyProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyProductActionPerformed(evt);
            }
        });
        jMenu2.add(modifyProduct);

        viewProduct.setText("Consultar productos");
        viewProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewProductMouseClicked(evt);
            }
        });
        viewProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewProductActionPerformed(evt);
            }
        });
        jMenu2.add(viewProduct);

        exportProducts.setText("Exportar productos");
        exportProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportProductsActionPerformed(evt);
            }
        });
        jMenu2.add(exportProducts);

        ImportProducts.setText("Importar productos");
        ImportProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportProductsActionPerformed(evt);
            }
        });
        jMenu2.add(ImportProducts);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Despacho compras");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Mi perfil");
        jMenuBar1.add(jMenu4);

        logout.setText("Cerrar sesion");
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
        });
        jMenuBar1.add(logout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(282, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createUsersMouseClicked
        // TODO add your handling code here:
   
    }//GEN-LAST:event_createUsersMouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1MouseClicked

    private void createUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUsersActionPerformed
        // TODO add your handling code here:
        CreateUser createUser = new CreateUser();
        createUser.setVisible(true);
        createUser.setBounds(0, 0, Main.width, Main.height);
        createUser.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_createUsersActionPerformed

    private void modifyUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyUsersActionPerformed
        // TODO add your handling code here:
        ModifyUsers modifyUsers = new ModifyUsers();
        modifyUsers.setVisible(true);
        modifyUsers.setBounds(0, 0, Main.width, Main.height);
        modifyUsers.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_modifyUsersActionPerformed

    private void viewUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewUsersMouseClicked
        // TODO add your handling code here:Ajd22es57103!
    }//GEN-LAST:event_viewUsersMouseClicked

    private void viewUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewUsersActionPerformed
        // TODO add your handling code here:
        ViewUsers viewUsers = new ViewUsers();
        viewUsers.setVisible(true);
        viewUsers.setBounds(0, 0, Main.width, Main.height);
        viewUsers.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_viewUsersActionPerformed

    private void importUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importUsersActionPerformed
        // TODO add your handling code here:
        ImportUsers importUsers = new ImportUsers();
        importUsers.setVisible(true);
        importUsers.setBounds(0, 0, Main.width, Main.height);
        importUsers.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_importUsersActionPerformed

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        login.setBounds(0, 0, Main.width, Main.height);
        login.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_logoutMouseClicked

    private void createProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createProductMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_createProductMouseClicked

    private void modifyProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyProductMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_modifyProductMouseClicked

    private void viewProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewProductMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_viewProductMouseClicked

    private void createProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createProductActionPerformed
        // TODO add your handling code here:
        CreateProducts createProducts = new CreateProducts();
        createProducts.setVisible(true);
        createProducts.setBounds(0, 0, Main.width, Main.height);
        createProducts.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_createProductActionPerformed

    private void modifyProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyProductActionPerformed
        // TODO add your handling code here:
        ModifyProducts modifyProducts = new ModifyProducts();
        modifyProducts.setVisible(true);
        modifyProducts.setBounds(0, 0, Main.width, Main.height);
        modifyProducts.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_modifyProductActionPerformed

    private void viewProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewProductActionPerformed
        // TODO add your handling code here:
        ViewProducts viewProducts = new ViewProducts();
        viewProducts.setVisible(true);
        viewProducts.setBounds(0, 0, Main.width, Main.height);
        viewProducts.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_viewProductActionPerformed

    private void exportProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportProductsActionPerformed
        // TODO add your handling code here:
        ViewProducts viewProducts = new ViewProducts();
        viewProducts.setVisible(true);
        viewProducts.setBounds(0, 0, Main.width, Main.height);
        viewProducts.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_exportProductsActionPerformed

    private void ImportProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportProductsActionPerformed
        // TODO add your handling code here:
        ImportProducts importProducts = new ImportProducts();
        importProducts.setVisible(true);
        importProducts.setBounds(0, 0, Main.width, Main.height);
        importProducts.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_ImportProductsActionPerformed

    private void exportUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportUsersActionPerformed
        // TODO add your handling code here:
        ViewUsers viewUsers = new ViewUsers();
        viewUsers.setVisible(true);
        viewUsers.setBounds(0, 0, Main.width, Main.height);
        viewUsers.setLocationRelativeTo(null);
        this.dispose();
        
    }//GEN-LAST:event_exportUsersActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ImportProducts;
    private javax.swing.JMenuItem createProduct;
    private javax.swing.JMenuItem createUsers;
    private javax.swing.JMenuItem exportProducts;
    private javax.swing.JMenuItem exportUsers;
    private javax.swing.JMenuItem importUsers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu logout;
    private javax.swing.JMenuItem modifyProduct;
    private javax.swing.JMenuItem modifyUsers;
    private javax.swing.JMenuItem viewProduct;
    private javax.swing.JMenuItem viewUsers;
    // End of variables declaration//GEN-END:variables
}
