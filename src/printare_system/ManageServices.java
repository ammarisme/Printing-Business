/*
 * copyright Ammar Bin Ameerdeen
 * All rights reserved
 */
package printare_system;

import java.awt.Color;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Ammar Bin Ameerdeen
 */
public class ManageServices extends IMSFrame {
    private boolean update;
    private Database database;
    Common common ;
    Frame main ;

    /**
     * Creates new form Template_printare
     */
    public ManageServices(java.awt.Frame parent, boolean modal) {
        super();
        initComponents();
        
        database = new Database();
        database.connect();
        
        main = parent ;
        
        common = new Common();
        update = false ;
        
        serviceCategory.setModel(common.getComboBoxModel("service_category", "name"));
        updateServiceTable();
        
        Theme theme = new Theme();
        theme.setTheme(this);
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        super.windowClosing(e);
                        main.setVisible(true);                        
                        dispose();
                    }
                });
        
        AutoCompleteDecorator.decorate(serviceCategory);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = getBackgroundPanel();
        title = getFrameTitle();
        centerPanel =  getCenterPanel();
        jPanel1 = new javax.swing.JPanel();
        serviceName = new javax.swing.JTextField();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jLabel1 = new javax.swing.JLabel();
        servicePrice = new javax.swing.JTextField();
        serviceAction = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        serviceCategory = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        serviceDescription = new javax.swing.JTextArea();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        serviceTable = new org.jdesktop.swingx.JXTable();
        editMode = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        backgroundPanel.setBackground(new java.awt.Color(20, 214, 42));
        backgroundPanel.setName("backgroundPanel"); // NOI18N
        backgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setText("Manage Services");
        title.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        title.setName("title"); // NOI18N
        backgroundPanel.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 42, -1, -1));

        centerPanel.setName("centerPanel"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fill Product details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        serviceName.setName("serviceName"); // NOI18N

        jXLabel2.setText("ServiceName");
        jXLabel2.setName("jXLabel2"); // NOI18N

        jLabel1.setText("Price");
        jLabel1.setName("jLabel1"); // NOI18N

        servicePrice.setName("servicePrice"); // NOI18N

        serviceAction.setBackground(Theme.BUTTON_COLOR);
        serviceAction.setText("Add Service");
        serviceAction.setName("serviceAction"); // NOI18N
        serviceAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviceActionActionPerformed(evt);
            }
        });

        jLabel2.setText("Category");
        jLabel2.setName("jLabel2"); // NOI18N

        serviceCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        serviceCategory.setName("serviceCategory"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        serviceDescription.setColumns(20);
        serviceDescription.setRows(5);
        serviceDescription.setName("serviceDescription"); // NOI18N
        jScrollPane2.setViewportView(serviceDescription);

        jXLabel3.setText("Description");
        jXLabel3.setName("jXLabel3"); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jXLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel1)
                            .add(jLabel2))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, serviceName)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, servicePrice)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, serviceCategory, 0, 220, Short.MAX_VALUE)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(jXLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(0, 0, Short.MAX_VALUE)
                .add(serviceAction, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 157, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(serviceName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jXLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(servicePrice, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(serviceCategory, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jXLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(serviceAction, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(0, 0, Short.MAX_VALUE))))
        );

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        serviceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Service Name", "Price", "Category", "Description"
            }
        ));
        serviceTable.setName("serviceTable"); // NOI18N
        serviceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                serviceTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(serviceTable);

        editMode.setForeground(Theme.FONT_COLOR);
        editMode.setText("Edit mode enabled");
        editMode.setName("editMode"); // NOI18N
        editMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editModeActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout centerPanelLayout = new org.jdesktop.layout.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(centerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(centerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(editMode))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                .addContainerGap())
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(centerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(centerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(centerPanelLayout.createSequentialGroup()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(centerPanelLayout.createSequentialGroup()
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(editMode)
                        .add(43, 43, 43))))
        );

        backgroundPanel.add(centerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 103, 970, -1));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(backgroundPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 1016, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(backgroundPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     public boolean validateInput(){
        ValidateOut vOut= new ValidateOut();
        vOut.validateIntTextBox(servicePrice);
        return vOut.valid;
    }
     
     /*
     if (!validateInputA()){
            return ;
        }
     */
    private void serviceActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serviceActionActionPerformed
        if (!validateInput()){
            return ;
        }
        if (update){
            editProduct();
        }
        else{
            addProduct();
        }
    }//GEN-LAST:event_serviceActionActionPerformed

    private void editProduct(){
         try {
               if(!update){
                   return;
               }
               
               String name = serviceName.getText();
               String newPrice = servicePrice.getText();
               String newCategory = (String) serviceCategory.getSelectedItem();
               String newDescription = serviceDescription.getText();
               
               // update the database table
               String update = "UPDATE `service` SET `price`='"+newPrice+"', `description`='"+newDescription+"' , `service_category_name`='"+newCategory+"' WHERE `name`='"+name+"'" ;
               database.statement.executeUpdate(update);
               
               updateServiceTable();
           } catch (SQLException ex) {
               Logger.getLogger(ManageProducts.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
    
    private void addProduct(){
          try {
        String entry = "INSERT INTO `service` (`name` , `price`, `description`, `cost`,`service_category_name`) VALUES ('"+serviceName.getText()+"','"+servicePrice.getText()+"','"+serviceDescription.getText()+"','0','"+serviceCategory.getSelectedItem()+"')";
        System.out.println(entry);
        database.statement.executeUpdate(entry);
        
        updateServiceTable();
        
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    private void updateServiceTable(){
            try {
        String query = "SELECT `name`,`price`, `service_category_name`,`description` FROM `service` " ;
        ResultSet rs = database.statement.executeQuery(query);
        
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Service Name");
        tableModel.addColumn("Price");
        tableModel.addColumn("Category");
        tableModel.addColumn("Description");
        while(rs.next()){
            Vector v = new Vector();
            v.add(rs.getString("name"));
            v.add(rs.getString("price"));
            v.add(rs.getString("service_category_name"));
            v.add(rs.getString("description"));
            
            tableModel.addRow(v);
        }
        
        serviceTable.setModel(tableModel);
        
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    private void editModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editModeActionPerformed
        //
        // activate the update mode
        if (editMode.isSelected()){
            update = true;
            // change the addButton
            serviceAction.setBackground(Color.orange);
            serviceAction.setText("Update Service");
            serviceName.setEnabled(false);
        }else{
            update = false ;
            // change the action Button
            serviceAction.setBackground(new Color(127,175,126));
            serviceAction.setText("Add Service");
            serviceName.setEnabled(true);
        }

    }//GEN-LAST:event_editModeActionPerformed

    private void serviceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_serviceTableMouseClicked
        if (!update){
            return ;
        }
        int row = serviceTable.getSelectedRow();
        String name = (String) serviceTable.getValueAt(row, 0);
        String priceOfProduct = (String) serviceTable.getValueAt(row, 1);
        String categoryName = (String) serviceTable.getValueAt(row, 2);
        String descriptionText = (String) serviceTable.getValueAt(row, 3);
        
        serviceName.setText(name);
        servicePrice.setText(priceOfProduct);
        serviceCategory.setSelectedItem(categoryName);
        serviceDescription.setText(descriptionText);
        
    }//GEN-LAST:event_serviceTableMouseClicked

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
            java.util.logging.Logger.getLogger(ManageServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageServices.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ManageServices dialog = new ManageServices(new javax.swing.JFrame(), true);
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public org.jdesktop.swingx.JXPanel backgroundPanel;
    public javax.swing.JPanel centerPanel;
    public javax.swing.JCheckBox editMode;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public org.jdesktop.swingx.JXLabel jXLabel2;
    public org.jdesktop.swingx.JXLabel jXLabel3;
    public javax.swing.JButton serviceAction;
    public javax.swing.JComboBox serviceCategory;
    public javax.swing.JTextArea serviceDescription;
    public javax.swing.JTextField serviceName;
    public javax.swing.JTextField servicePrice;
    public org.jdesktop.swingx.JXTable serviceTable;
    public org.jdesktop.swingx.JXLabel title;
    // End of variables declaration//GEN-END:variables
}
