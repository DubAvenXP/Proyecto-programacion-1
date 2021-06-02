/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminViews;

import main.Main;
import main.User;
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
public class ViewUsers extends javax.swing.JFrame {

    /**
     * Creates new form ViewUsers
     */
    public ViewUsers() {
        initComponents();
        fillJTable();
    }
    
    private void fillJTable(){
        DefaultTableModel defaultTableModel = new DefaultTableModel(
                new String[]{"Id","Username","name","lastname","role","email","phone","address","birthdate","password","dpi"}, 
                Main.users.size()
        );
        jTable1.setModel(defaultTableModel);
        TableModel tableModel = jTable1.getModel();
        
        for (int i = 0; i < Main.users.size(); i++) {
            User user = Main.users.get(i);
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
    
    public void saveFile(File file){
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        
        try {
            fileWriter = new FileWriter(file);
            printWriter = new PrintWriter(fileWriter);
            
            for (User user : Main.users) {
                
                String line = user.getCode()+"|"+user.getUsername()
                        +"|"+user.getName()+"|"+user.getLastname()
                        +"|"+user.getRole()+"|"+user.getEmail()
                        +"|"+user.getPhone()+"|"+user.getAddress()
                        +"|"+user.getBirthdate()+"|"+user.getPassword()
                        +"|"+user.getDpi();
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
            
            Document document = implementation.createDocument(null, "vendedores", null);
            document.setXmlVersion("1.0");
            
            for (User user : Main.users) {
           
                Element vendedora = document.createElement(user.getRole());
                Attr id = document.createAttribute("id");
                id.setTextContent(String.valueOf(user.getCode()));
                vendedora.setAttributeNode(id);

                Element correo = document.createElement("correo");
                Text textCorreo = document.createTextNode(user.getEmail());
                correo.appendChild(textCorreo);
                vendedora.appendChild(correo);
                
                Element usuario = document.createElement("usuario");
                Text textUsuario = document.createTextNode(user.getUsername());
                usuario.appendChild(textUsuario);
                vendedora.appendChild(usuario);
                
                Element rol = document.createElement("rol");
                Text textRol = document.createTextNode(user.getRole());
                rol.appendChild(textRol);
                vendedora.appendChild(rol);


                Element nombre = document.createElement("nombre");
                Text textNombre = document.createTextNode(user.getName());
                nombre.appendChild(textNombre);
                vendedora.appendChild(nombre);


                Element apellido = document.createElement("apellido");
                Text textApellido = document.createTextNode(user.getLastname());
                apellido.appendChild(textApellido);
                vendedora.appendChild(apellido);

                Element fechaNacimiento = document.createElement("fechaNacimiento");
                Text textFechaNacimiento = document.createTextNode(user.getBirthdate());
                fechaNacimiento.appendChild(textFechaNacimiento);
                vendedora.appendChild(fechaNacimiento);

                Element telefono = document.createElement("telefono");
                Text textTelefono = document.createTextNode(user.getPhone());
                telefono.appendChild(textTelefono);
                vendedora.appendChild(telefono);

                Element direccion = document.createElement("direccion");
                Text textDireccion = document.createTextNode(user.getAddress());
                direccion.appendChild(textDireccion);
                vendedora.appendChild(direccion);


                Element password = document.createElement("contraseña");
                Text textPassword = document.createTextNode(user.getPassword());
                password.appendChild(textPassword);
                vendedora.appendChild(password);

                Element dpi = document.createElement("dpi");
                Text textDpi = document.createTextNode(user.getDpi());
                dpi.appendChild(textDpi);
                vendedora.appendChild(dpi);
                
                
                document.getDocumentElement().appendChild(vendedora);
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
        jLabel1 = new javax.swing.JLabel();
        usernameInput = new javax.swing.JTextField();
        goToModify = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        exportUsersXML = new javax.swing.JButton();
        exportUsersCSV = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Modificar usuario:");

        goToModify.setText("ir a modificar");
        goToModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToModifyActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel2.setText("Consulta de usuarios");

        exportUsersXML.setText("Exportar usuarios a XML");
        exportUsersXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportUsersXMLActionPerformed(evt);
            }
        });

        exportUsersCSV.setText("Exportar usuarios a CSV");
        exportUsersCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportUsersCSVActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(goToModify, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(139, 139, 139)
                        .addComponent(exportUsersXML, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(exportUsersCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1091, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(exportUsersCSV, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(exportUsersXML, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(usernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(goToModify, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
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

    private void goToModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToModifyActionPerformed
        // TODO add your handling code here:
        ModifyUsers modifyUsers = new ModifyUsers(usernameInput.getText());
        modifyUsers.setVisible(true);
        modifyUsers.setBounds(0, 0, Main.width, Main.height);
        modifyUsers.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_goToModifyActionPerformed

    private void exportUsersXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportUsersXMLActionPerformed
        // TODO add your handling code here:
        JFileChooser jFileChooser = new JFileChooser();
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Archivos xml", "xml");
        
        jFileChooser.setFileFilter(fileFilter);
        int seleccionar = jFileChooser.showOpenDialog(this);
        
        if (seleccionar == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser.getSelectedFile();
            saveFileXML(file);
        }
    }//GEN-LAST:event_exportUsersXMLActionPerformed

    private void exportUsersCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportUsersCSVActionPerformed
        // TODO add your handling code here:
        JFileChooser jFileChooser = new JFileChooser();
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("Archivos csv", "csv");
        
        jFileChooser.setFileFilter(fileFilter);
        int seleccionar = jFileChooser.showOpenDialog(this);
        
        if (seleccionar == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser.getSelectedFile();
            saveFile(file);
        }
    }//GEN-LAST:event_exportUsersCSVActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exportUsersCSV;
    private javax.swing.JButton exportUsersXML;
    private javax.swing.JButton goToModify;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField usernameInput;
    // End of variables declaration//GEN-END:variables
}
