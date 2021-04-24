/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoprogramacioni.adminViews;

import com.mycompany.proyectoprogramacioni.Main;
import com.mycompany.proyectoprogramacioni.Product;
import com.mycompany.proyectoprogramacioni.User;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author dubavenxp
 */
public class ViewProducts extends javax.swing.JFrame {

    /**
     * Creates new form ViewProducts
     */
    public ViewProducts() {
        initComponents();
        fillJTable();
    }

    private void fillJTable(){
        DefaultTableModel defaultTableModel = new DefaultTableModel(
                new String[]{"Id","Producto","Precio","Cantidad","Descripcion","Tipo","Marca"}, 
                Main.products.size()
        );
        jTable1.setModel(defaultTableModel);
        TableModel tableModel = jTable1.getModel();
        
        for (int i = 0; i < Main.products.size(); i++) {
            Product product = Main.products.get(i);
            tableModel.setValueAt(product.getCode(), i, 0);
            tableModel.setValueAt(product.getName(), i, 1);
            tableModel.setValueAt("Q"+ product.getPrice(), i, 2);
            tableModel.setValueAt(product.getQuantity(), i, 3);
            tableModel.setValueAt(product.getDescription(), i, 4);
            tableModel.setValueAt(product.getType(), i, 5);
            tableModel.setValueAt(product.getBrand(), i, 6);
        }
        
    }
    
    public void saveFile(File file){
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        
        try {
            fileWriter = new FileWriter(file);
            printWriter = new PrintWriter(fileWriter);
            
            for (Product product : Main.products) {
                
                String line = product.getCode()+"|"+product.getName()
                        +"|"+product.getPrice()+"|"+product.getQuantity()
                        +"|"+product.getDescription()+"|"+product.getType()
                        +"|"+product.getBrand();
                printWriter.println(line);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public void saveFileXML(File file){
        try {
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            
            Document document = implementation.createDocument(null, "productos", null);
            document.setXmlVersion("1.0");
            
            for (Product product : Main.products) {
           
                Element producto = document.createElement("producto");
                Attr id = document.createAttribute("id");
                id.setTextContent(String.valueOf(product.getCode()));
                producto.setAttributeNode(id);
                
                Element nombre = document.createElement("nombre");
                Text textNombre = document.createTextNode(product.getName());
                nombre.appendChild(textNombre);
                producto.appendChild(nombre);
                
                Element precio = document.createElement("precio");
                Text textPrecio = document.createTextNode(String.valueOf(product.getPrice()));
                precio.appendChild(textPrecio);
                producto.appendChild(precio);

                Element cantidad = document.createElement("cantidad");
                Text textCantidad = document.createTextNode(String.valueOf(product.getQuantity()));
                cantidad.appendChild(textCantidad);
                producto.appendChild(cantidad);

                Element descripcion = document.createElement("descripcion");
                Text textDescripcion = document.createTextNode(product.getDescription());
                descripcion.appendChild(textDescripcion);
                producto.appendChild(descripcion);
                
                Element tipo = document.createElement("tipo");
                Text textTipo = document.createTextNode(product.getType());
                tipo.appendChild(textTipo);
                producto.appendChild(tipo);
                
                Element marca = document.createElement("marca");
                Text textMarca = document.createTextNode(product.getBrand());
                marca.appendChild(textMarca);
                producto.appendChild(marca);

                document.getDocumentElement().appendChild(producto);
            }
            
            
            
            Source source = new DOMSource(document);
            Result result = new StreamResult(file);
            
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
         
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        productNameInput = new javax.swing.JTextField();
        goToModify = new javax.swing.JButton();
        exportProductsCSV = new javax.swing.JButton();
        exportProductsXML = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel2.setText("Consulta de productos");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Modificar producto:");

        goToModify.setText("ir a modificar");
        goToModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToModifyActionPerformed(evt);
            }
        });

        exportProductsCSV.setText("Exportar productos a CSV");
        exportProductsCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportProductsCSVActionPerformed(evt);
            }
        });

        exportProductsXML.setText("Exportar productos a XML");
        exportProductsXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportProductsXMLActionPerformed(evt);
            }
        });

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
                .addGap(93, 93, 93)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(goToModify, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(355, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exportProductsXML, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(exportProductsCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(exportProductsCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exportProductsXML, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(productNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(goToModify, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(93, 93, 93))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goToModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToModifyActionPerformed
        // TODO add your handling code here:
        ModifyProducts modifyProducts = new ModifyProducts(productNameInput.getText());
        modifyProducts.setVisible(true);
        modifyProducts.setBounds(0, 0, Main.width, Main.height);
        modifyProducts.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_goToModifyActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        // TODO add your handling code here:
        AdminView adminView = new AdminView();
        adminView.setVisible(true);
        adminView.setBounds(0, 0, Main.width, Main.height);
        adminView.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void exportProductsCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportProductsCSVActionPerformed
        // TODO add your handling code here:
        JFileChooser jFileChooser = new JFileChooser();
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Archivos csv", "csv");
        
        jFileChooser.setFileFilter(fileFilter);
        int seleccionar = jFileChooser.showOpenDialog(this);
        
        if (seleccionar == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser.getSelectedFile();
            saveFile(file);
        }
    }//GEN-LAST:event_exportProductsCSVActionPerformed

    private void exportProductsXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportProductsXMLActionPerformed
        // TODO add your handling code here:
                // TODO add your handling code here:
        JFileChooser jFileChooser = new JFileChooser();
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Archivos xml", "xml");
        
        jFileChooser.setFileFilter(fileFilter);
        int seleccionar = jFileChooser.showOpenDialog(this);
        
        if (seleccionar == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser.getSelectedFile();
            saveFileXML(file);
        }
    }//GEN-LAST:event_exportProductsXMLActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exportProductsCSV;
    private javax.swing.JButton exportProductsXML;
    private javax.swing.JButton goToModify;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField productNameInput;
    // End of variables declaration//GEN-END:variables
}
