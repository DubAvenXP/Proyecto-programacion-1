/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoprogramacioni.adminViews;

import com.mycompany.proyectoprogramacioni.Main;
import com.mycompany.proyectoprogramacioni.Product;
import com.mycompany.proyectoprogramacioni.User;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author dubavenxp
 */
public class ImportProducts extends javax.swing.JFrame {

    private ArrayList<Product> productsToLoad = new ArrayList<Product>();
    private ArrayList<Product> productsWithError = new ArrayList<Product>();
    /**
     * Creates new form ImportProducts
     */
    public ImportProducts() {
        initComponents();
    }

    public void loadFileCSV(File file){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            
            String line;
            
            while((line = bufferedReader.readLine()) != null){
                String arrayOfProduct [] = line.split("\\|");
                                
                if(arrayOfProduct.length == 5){
                    Product product = new Product();
                    product.setCode(Integer.parseInt(arrayOfProduct[0]));
                    product.setName(arrayOfProduct[1]);
                    product.setPrice(Double.parseDouble(arrayOfProduct[2]));
                    product.setQuantity(Integer.parseInt(arrayOfProduct[3]));
                    product.setDescription(arrayOfProduct[4]);
                    productsToLoad.add(product);
                }
            }
            fillJTable(jTable1, productsToLoad);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public void loadFileXML(File file){
        try {
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(file);
            document.getDocumentElement().normalize();
            
            NodeList nodeList = document.getElementsByTagName("producto");
            
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Product product = new Product();
                    product.setCode(Integer.parseInt(element.getAttributeNode("id").getTextContent()));
                    product.setName(element.getElementsByTagName("nombre").item(0).getTextContent());
                    product.setPrice(Double.parseDouble(element.getElementsByTagName("precio").item(0).getTextContent()));
                    product.setQuantity(Integer.parseInt(element.getElementsByTagName("cantidad").item(0).getTextContent()));
                    product.setDescription(element.getElementsByTagName("descripcion").item(0).getTextContent());
                    productsToLoad.add(product);
                }
            }
            fillJTable(jTable1, productsToLoad);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void fillJTable(JTable jTable, ArrayList<Product> products){
        DefaultTableModel defaultTableModel = new DefaultTableModel(
                new String[]{"Id","Producto","Precio","Cantidad","Descripcion"}, 
                products.size()
        );
        
        jTable.setModel(defaultTableModel);
        TableModel tableModel = jTable.getModel();

        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            tableModel.setValueAt(product.getCode(), i, 0);
            tableModel.setValueAt(product.getName(), i, 1);
            tableModel.setValueAt("Q"+ product.getPrice(), i, 2);
            tableModel.setValueAt(product.getQuantity(), i, 3);
            tableModel.setValueAt(product.getDescription(), i, 4);
        }
        
    }
    
    public void clearDuplicates(){
        for (Product product : productsToLoad) {
            int duplicateValuesCounter = 0;
            for (int i = 0; i < productsToLoad.size(); i++) {
               if (product.getName().equals(productsToLoad.get(i).getName())) {
                   duplicateValuesCounter++;
                   if (duplicateValuesCounter >= 2) {
                       productsToLoad.remove(productsToLoad.remove(i));
                   }
               }
           }
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chooseFileCSV = new javax.swing.JButton();
        saveData = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        chooseFileXML = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chooseFileCSV.setText("Importar CSV");
        chooseFileCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileCSVActionPerformed(evt);
            }
        });

        saveData.setText("Guardar");
        saveData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveDataActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("Elementos cargados");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel2.setText("Elementos  fallidos");

        chooseFileXML.setText("Importar XML");
        chooseFileXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileXMLActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel3.setText("Importar productos");

        jMenu1.setText("Regresar");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(chooseFileXML, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chooseFileCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveData, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                    .addComponent(chooseFileCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveData, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chooseFileXML, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        AdminView adminView = new AdminView();
        adminView.setVisible(true);
        adminView.setBounds(0, 0, Main.width, Main.height);
        adminView.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void chooseFileCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileCSVActionPerformed
        // TODO add your handling code here:
        JFileChooser jFileChooser = new JFileChooser();
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Archivos csv", "csv");
        
        jFileChooser.setFileFilter(fileFilter);
        int seleccionar = jFileChooser.showOpenDialog(this);
        
        if (seleccionar == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser.getSelectedFile();
            loadFileCSV(file);
        }
    }//GEN-LAST:event_chooseFileCSVActionPerformed

    private void saveDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveDataActionPerformed
        // TODO add your handling code here:
        try {
            boolean productIsValid = true;
            clearDuplicates();
            for (Product product : productsToLoad) {
                
                for (int i = 0; i < Main.products.size(); i++) {
                    if (product.getName().equals(Main.products.get(i).getName())) {
                        productIsValid = false;
                        break;
                    }
                }

                if (productIsValid) {
                    Main.products.add(product);
                } else {
                    productsWithError.add(product);
                }
            }
            JOptionPane.showMessageDialog(this, "Productos cargados exitosamente");
            productsToLoad.clear();
            fillJTable(jTable1, productsToLoad);
            fillJTable(jTable2, productsWithError);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Hubo un error al cargar los productos, revisa tu archivo");
        }
        
    }//GEN-LAST:event_saveDataActionPerformed

    private void chooseFileXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileXMLActionPerformed
        // TODO add your handling code here:
        JFileChooser jFileChooser = new JFileChooser();
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Archivos xml", "xml");
        
        jFileChooser.setFileFilter(fileFilter);
        int seleccionar = jFileChooser.showOpenDialog(this);
        
        if (seleccionar == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser.getSelectedFile();
            loadFileXML(file);
        }
    }//GEN-LAST:event_chooseFileXMLActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseFileCSV;
    private javax.swing.JButton chooseFileXML;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton saveData;
    // End of variables declaration//GEN-END:variables
}
