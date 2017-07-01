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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Ammar Bin Ameerdeen
 */
public class ManageProducts extends IMSFrame{

       Common common ;
       boolean update;
       Database database;
       Frame main;
    /**
     * Creates new form Template_printare
     */
    public ManageProducts(java.awt.Frame parent, boolean modal) {
        super();
        
        main = parent ;
        initComponents();
        
        common = new Common();
        update = false ;
        database = new Database();
        database.connect();
        
        category.setModel(common.getComboBoxModel("product_category", "name")) ;
        
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
        updateProductTable();
        
        AutoCompleteDecorator.decorate(category);
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
        title =  getFrameTitle();
        centerPanel = getCenterPanel();
        jPanel1 = new javax.swing.JPanel();
        productName = new javax.swing.JTextField();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jLabel1 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        productAction = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        category = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        jLabel3 = new javax.swing.JLabel();
        minimumStock = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        productTable = new org.jdesktop.swingx.JXTable();
        editMode = new javax.swing.JCheckBox();
        updateWebsite = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        backgroundPanel.setBackground(new java.awt.Color(20, 214, 42));
        backgroundPanel.setName("backgroundPanel"); // NOI18N
        backgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setText("Manage Products");
        title.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        title.setName("title"); // NOI18N
        backgroundPanel.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 42, -1, -1));

        centerPanel.setName("centerPanel"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Fill Product details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        productName.setName("productName"); // NOI18N

        jXLabel2.setText("Product Name");
        jXLabel2.setName("jXLabel2"); // NOI18N

        jLabel1.setText("Price");
        jLabel1.setName("jLabel1"); // NOI18N

        price.setName("price"); // NOI18N
        price.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                priceFocusLost(evt);
            }
        });

        productAction.setBackground(Theme.BUTTON_COLOR);
        productAction.setText("Add >>");
        productAction.setName("productAction"); // NOI18N
        productAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productActionActionPerformed(evt);
            }
        });

        jLabel2.setText("Category");
        jLabel2.setName("jLabel2"); // NOI18N

        category.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Database Error" }));
        category.setName("category"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        description.setColumns(20);
        description.setRows(5);
        description.setName("description"); // NOI18N
        jScrollPane2.setViewportView(description);

        jXLabel3.setText("Description");
        jXLabel3.setName("jXLabel3"); // NOI18N

        jLabel3.setText("Minimum stock");
        jLabel3.setName("jLabel3"); // NOI18N

        minimumStock.setName("minimumStock"); // NOI18N

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
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, productName)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, price)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, category, 0, 227, Short.MAX_VALUE)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(jXLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(productAction, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 179, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jLabel3)
                        .add(18, 18, 18)
                        .add(minimumStock)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(productName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jXLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(price, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(category, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jXLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(88, 88, 88)
                        .add(jLabel3)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(minimumStock, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 30, Short.MAX_VALUE)
                        .add(productAction, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(27, 27, 27))))
        );

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Price", "Category", "Description", "Stock", "Min.Stock"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productTable.setName("productTable"); // NOI18N
        productTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productTable);

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
                .add(21, 21, 21)
                .add(centerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(centerPanelLayout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(editMode)
                        .add(90, 90, 90)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 591, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(centerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(centerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(centerPanelLayout.createSequentialGroup()
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(25, 25, 25)
                        .add(editMode))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE))
                .add(8, 8, 8))
        );

        backgroundPanel.add(centerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 103, -1, 450));

        updateWebsite.setBackground(Theme.BUTTON_COLOR);
        updateWebsite.setText("Update Online Database");
        updateWebsite.setName("updateWebsite"); // NOI18N
        updateWebsite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateWebsiteMouseClicked(evt);
            }
        });
        updateWebsite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateWebsiteActionPerformed(evt);
            }
        });
        backgroundPanel.add(updateWebsite, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, -1, 50));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(backgroundPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(backgroundPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 594, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     
     public boolean validateInput(){
        ValidateOut vOut= new ValidateOut();
        vOut.validateFloatTextBox(price);
        return vOut.valid;
    }
    private void productActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productActionActionPerformed
    if (!validateInput()){
            return ;
        }
        if (update){
            editProduct();
        }
        else{
            addProduct();
        }
         
    }//GEN-LAST:event_productActionActionPerformed

    private void editModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editModeActionPerformed
        // 
          // activate the update mode
        if (editMode.isSelected()){
            update = true;
            // change the addButton
            productAction.setBackground(Color.orange);
            productAction.setText("Update Product");
            productName.setEnabled(false);
        }else{
            update = false ;
            // change the action Button
            productAction.setBackground(new Color(127,175,126));
            productAction.setText("Add Product");
            productName.setEnabled(true);
        }
        
       
    }//GEN-LAST:event_editModeActionPerformed

    private void productTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productTableMouseClicked
        if (!update){
            return ;
        }
        int row = productTable.getSelectedRow();
        String name = (String) productTable.getValueAt(row, 0);
        String priceOfProduct = (String) productTable.getValueAt(row, 1);
        String categoryName = (String) productTable.getValueAt(row, 2);
        String descriptionText = (String) productTable.getValueAt(row, 3);
        String minStock = (String) new String(""+ productTable.getValueAt(row, 4));
        
        productName.setText(name);
        price.setText(priceOfProduct);
        category.setSelectedItem(categoryName);
        description.setText(descriptionText);
        minimumStock.setText(minStock);
    }//GEN-LAST:event_productTableMouseClicked

    private void priceFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_priceFocusLost
         ValidateOut vOut = new ValidateOut();
       vOut.validateFloatTextBox((JTextField) evt.getComponent());
    }//GEN-LAST:event_priceFocusLost

    private void updateWebsiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateWebsiteMouseClicked
         try {
             // flush the table
            HttpConnection hConnection1 = new HttpConnection();
            hConnection1.sendGet("http://localhost/flush.php", "");
             
            String query = "SELECT * FROM `product`";
            ResultSet rs = database.statement.executeQuery(query);
            
            while(rs.next()){
             HttpConnection hConnection = new HttpConnection();
            hConnection.sendGet("http://localhost/update.php?data=",new String("'"+rs.getString("name")+"',"+"'"+rs.getInt("price")+"',"+"'"+rs.getString("description")+"',"+"'"+rs.getInt("stock")+"',"+"'"+rs.getInt("cost")+"',"+"'"+rs.getString("product_category_name")+"',"+"'"+rs.getInt("minimum_stock")+"'"));
            }
            
        } catch (Exception ex) {
           //  Logger.getLogger(NewClass1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_updateWebsiteMouseClicked

    private void updateWebsiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateWebsiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateWebsiteActionPerformed

    private void editProduct(){
           try {
               if(!update){
                   return;
               }
               
               String name = productName.getText();
               String newPrice = price.getText();
               String newCategory = (String) category.getSelectedItem();
               String newDescription = description.getText();
               
               // update the database table
               String update = "UPDATE `product` SET `price`='"+newPrice+"', `description`='"+newDescription+"' , `product_category_name`='"+newCategory+"',`minimum_stock`='"+minimumStock.getText()+"' WHERE `name`='"+name+"'" ;
               database.statement.executeUpdate(update);
               
               updateProductTable();
           } catch (SQLException ex) {
               Logger.getLogger(ManageProducts.class.getName()).log(Level.SEVERE, null, ex);
           }
    }
    
    private void addProduct(){
        try {
        String entry = "INSERT INTO `product` (`name` , `price`, `description`, `stock`, `cost`,`product_category_name`,`minimum_stock`) VALUES ('"+productName.getText()+"','"+price.getText()+"','"+description.getText()+"','0','0','"+category.getSelectedItem()+"','"+minimumStock.getText()+"')";
        System.out.println(entry);
        database.statement.executeUpdate(entry);
        
        updateProductTable();
        
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    private void updateProductTable(){
        try {
        String query = "SELECT `name`,`price`, `product_category_name`,`description`,`stock`,`minimum_stock` FROM `product` " ;
        ResultSet rs = database.statement.executeQuery(query);
        
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Product Name");
        tableModel.addColumn("Price");
        tableModel.addColumn("Category");
        tableModel.addColumn("Description");
        tableModel.addColumn("Stock");
        tableModel.addColumn("Min.Stock");
        
        while(rs.next()){
            Vector v = new Vector();
            v.add(rs.getString("name"));
            v.add(rs.getString("price"));
            v.add(rs.getString("product_category_name"));
            v.add(rs.getString("description"));
            v.add(rs.getInt("stock"));
            v.add(rs.getInt("minimum_stock"));
            tableModel.addRow(v);
        }
        
        productTable.setModel(tableModel);
        
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
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
            java.util.logging.Logger.getLogger(ManageProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                ManageProducts dialog = new ManageProducts(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public org.jdesktop.swingx.JXPanel backgroundPanel;
    public javax.swing.JComboBox category;
    public javax.swing.JPanel centerPanel;
    public javax.swing.JTextArea description;
    public javax.swing.JCheckBox editMode;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public org.jdesktop.swingx.JXLabel jXLabel2;
    public org.jdesktop.swingx.JXLabel jXLabel3;
    public javax.swing.JTextField minimumStock;
    public javax.swing.JTextField price;
    public javax.swing.JButton productAction;
    public javax.swing.JTextField productName;
    public org.jdesktop.swingx.JXTable productTable;
    public org.jdesktop.swingx.JXLabel title;
    public javax.swing.JButton updateWebsite;
    // End of variables declaration//GEN-END:variables
}
