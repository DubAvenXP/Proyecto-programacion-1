/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminViews;

import main.Main;
import main.User;
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
public class ImportUsers extends javax.swing.JFrame {

    /**
     * Creates new form ImportUsers
     */
    private ArrayList<User> usersToLoad = new ArrayList<User>();
    private ArrayList<User> usersWithError = new ArrayList<User>();
    public ImportUsers() {
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
                String arrayUser [] = line.split("\\|");
                                
                if(arrayUser.length == 11){
                    User user = new User();
                    user.setCode(Integer.parseInt(arrayUser[0]));
                    user.setUsername(arrayUser[1]);
                    user.setName(arrayUser[2]);
                    user.setLastname(arrayUser[3]);
                    user.setRole(arrayUser[4]);
                    user.setEmail(arrayUser[5]);
                    user.setPhone(arrayUser[6]);
                    user.setAddress(arrayUser[7]);
                    user.setBirthdate(arrayUser[8]);
                    user.setPassword(arrayUser[9]);
                    user.setDpi(arrayUser[10]);
                    usersToLoad.add(user);
                }
            }
            fillJTable(jTable1, usersToLoad);
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
            
            NodeList nodeList = document.getElementsByTagName("vendedor");
            
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    User user = new User();
                    user.setCode(Integer.parseInt(element.getAttributeNode("id").getTextContent()));
                    user.setUsername(element.getElementsByTagName("usuario").item(0).getTextContent());
                    user.setName(element.getElementsByTagName("nombre").item(0).getTextContent());
                    user.setLastname(element.getElementsByTagName("apellido").item(0).getTextContent());
                    user.setRole(element.getElementsByTagName("rol").item(0).getTextContent());
                    user.setEmail(element.getElementsByTagName("correo").item(0).getTextContent());
                    user.setPhone(element.getElementsByTagName("telefono").item(0).getTextContent());
                    user.setAddress(element.getElementsByTagName("direccion").item(0).getTextContent());
                    user.setBirthdate(element.getElementsByTagName("fechaNacimiento").item(0).getTextContent());
                    user.setPassword(element.getElementsByTagName("contraseña").item(0).getTextContent());
                    user.setDpi(element.getElementsByTagName("dpi").item(0).getTextContent());
                    usersToLoad.add(user);
                }
            }
            fillJTable(jTable1, usersToLoad);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void fillJTable(JTable jTable, ArrayList<User> users){
        DefaultTableModel defaultTableModel = new DefaultTableModel(
                new String[]{"Id","Username","name","lastname","role","email","phone","address","birthdate","password","DPI"}, 
                users.size()
        );
        
        jTable.setModel(defaultTableModel);
        TableModel tableModel = jTable.getModel();
        
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
               tableModel.setValueAt(user.getCode(), i, 0);
               tableModel.setValueAt(user.getUsername(), i, 1);
               tableModel.setValueAt(user.getName(), i, 2);
               tableModel.setValueAt(user.getLastname(), i, 3);
               tableModel.setValueAt(user.getRole(), i, 4);
               tableModel.setValueAt(user.getEmail(), i, 5);
               tableModel.setValueAt(user.getPhone(), i, 6);
               tableModel.setValueAt(user.getAddress(), i, 7);
               tableModel.setValueAt(user.getBirthdate(), i, 8);
               tableModel.setValueAt(user.getPassword(), i, 9);
               tableModel.setValueAt(user.getDpi(), i, 10);
        }
    }

    public void clearDuplicates(){
        for (User user : usersToLoad) {
            int duplicateValuesCounter = 0;
            for (int i = 0; i < usersToLoad.size(); i++) {
               if (user.getUsername().equals(usersToLoad.get(i).getUsername())) {
                   duplicateValuesCounter++;
                   if (duplicateValuesCounter >= 2) {
                       usersToLoad.remove(usersToLoad.remove(i));
                       
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        chooseFileXML = new javax.swing.JButton();
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

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel1.setText("Elementos cargados");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel2.setText("Elementos  fallidos/duplicados");

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

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel3.setText("Importar usuarios");

        chooseFileXML.setText("Importar XML");
        chooseFileXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseFileXMLActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(144, 144, 144)
                        .addComponent(chooseFileXML, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chooseFileCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(saveData, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(chooseFileCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveData, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chooseFileXML, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(44, 44, 44))
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
        usersToLoad.clear();
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
            boolean userIsValid = true;
            for (User user : usersToLoad) {
                for (int i = 0; i < Main.users.size(); i++) {
                    if (user.getName().equals(Main.users.get(i).getName())) {
                        userIsValid = false;
                        break;
                    }
                }

                if (userIsValid) {
                    Main.users.add(user);
                } else {
                    usersWithError.add(user);
                }
            }
            JOptionPane.showMessageDialog(this, "Usuarios cargados exitosamente");
            usersToLoad.clear();
            fillJTable(jTable1, usersToLoad);
            fillJTable(jTable2, usersWithError);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Hubo un error al cargar los productos, revisa tu archivo");
        }

    }//GEN-LAST:event_saveDataActionPerformed

    private void chooseFileXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseFileXMLActionPerformed
        // TODO add your handling code here:
        usersToLoad.clear();
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
