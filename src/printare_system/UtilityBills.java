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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author Ammar Bin Ameerdeen
 */
public class UtilityBills extends IMSFrame {
    Database database;
    Frame  main;
    private boolean update;
    /**
     * Creates new form Template_printare
     */
    public UtilityBills(java.awt.Frame parent, boolean modal) {
        super();
        initComponents();
        database = new Database();
        database.connect();
        
        update = false;
        main = parent;
        
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
        // set UI
        loadBillsComboBox();
        updateBillsTable();
        
        AutoCompleteDecorator.decorate(this.billType);
        
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
        centerPanel = getCenterPanel();
        billType = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        accountNumber = new javax.swing.JTextField();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jLabel1 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        process = new javax.swing.JButton();
        billPaid = new javax.swing.JCheckBox();
        editMode = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        billsTable = new org.jdesktop.swingx.JXTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        backgroundPanel.setBackground(new java.awt.Color(20, 214, 42));
        backgroundPanel.setName("backgroundPanel"); // NOI18N
        backgroundPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setText("Utility Bills");
        title.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        title.setName("title"); // NOI18N
        backgroundPanel.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 42, -1, -1));

        centerPanel.setName("centerPanel"); // NOI18N

        billType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "database error" }));
        billType.setName("billType"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Bill payment to System", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12))); // NOI18N
        jPanel1.setName("jPanel1"); // NOI18N

        accountNumber.setName("accountNumber"); // NOI18N

        jXLabel2.setText("Account Number");
        jXLabel2.setName("jXLabel2"); // NOI18N

        jLabel1.setText("Amount");
        jLabel1.setName("jLabel1"); // NOI18N

        amount.setName("amount"); // NOI18N
        amount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                amountFocusLost(evt);
            }
        });

        process.setBackground(Theme.BUTTON_COLOR);
        process.setText("Add Bill to System");
        process.setName("process"); // NOI18N
        process.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processActionPerformed(evt);
            }
        });

        billPaid.setText("Bill paid");
        billPaid.setName("billPaid"); // NOI18N

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(billPaid)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 96, Short.MAX_VALUE)
                        .add(process, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 165, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jXLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel1))
                        .add(18, 18, 18)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(accountNumber)
                            .add(amount))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(accountNumber, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jXLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(amount, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(process, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 58, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(billPaid))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        editMode.setForeground(Theme.FONT_COLOR);
        editMode.setText("Enable Update Mode");
        editMode.setName("editMode"); // NOI18N
        editMode.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                editModeStateChanged(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        billsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "S.No", "Bill type", "Date", "Account Number", "Amount", "Paid"
            }
        ));
        billsTable.setName("billsTable"); // NOI18N
        billsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(billsTable);

        org.jdesktop.layout.GroupLayout centerPanelLayout = new org.jdesktop.layout.GroupLayout(centerPanel);
        centerPanel.setLayout(centerPanelLayout);
        centerPanelLayout.setHorizontalGroup(
            centerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(centerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(centerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(editMode)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, billType, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 222, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                .add(18, 18, 18))
        );
        centerPanelLayout.setVerticalGroup(
            centerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, centerPanelLayout.createSequentialGroup()
                .add(21, 21, 21)
                .add(centerPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(centerPanelLayout.createSequentialGroup()
                        .add(billType, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 194, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(editMode)
                .add(25, 25, 25))
        );

        backgroundPanel.add(centerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 103, -1, -1));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(backgroundPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(backgroundPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void processActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processActionPerformed
        // add entry to payment table
         if (!validateInput()){
            return ;
        }
         if (Integer.parseInt(amount.getText())==0){
         return ;
     }
        if (!update){
        String status ="pending";
        if (billPaid.isSelected()){
            status = "paid";
        }
        try {
        String entry = "INSERT INTO `payment` (`status`,`amount`,`account_number`,`utility_bill_type`) VALUES('"+status+"','"+amount.getText()+"','"+accountNumber.getText()+"','"+billType.getSelectedItem()+"')";
        database.statement.executeUpdate(entry);
        
        updateBillsTable();
        
        System.out.println("payment done :"+status);
        }catch(SQLException e){
            e.printStackTrace();
        }
        }else{
            // the update action
        String status ="pending";
        if (billPaid.isSelected()){
            status = "paid";
        }
        try {
        String entry = "UPDATE `payment` SET `status`='"+status+"' , `amount`='"+amount.getText()+"', `account_number`='"+accountNumber.getText()+"' WHERE `id`='"+billsTable.getValueAt( billsTable.getSelectedRow(),0)+"'";
        
        database.statement.executeUpdate(entry);
        
        updateBillsTable();
        
        System.out.println("payment done :"+status);
        }catch(SQLException e){
            e.printStackTrace();
        }    
        }
    }//GEN-LAST:event_processActionPerformed

    private void amountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_amountFocusLost
          ValidateOut vOut = new ValidateOut();
       vOut.validateFloatTextBox((JTextField) evt.getComponent());
    }//GEN-LAST:event_amountFocusLost

    private void editModeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_editModeStateChanged
         // if selected enable edit mode
        if(editMode.isSelected()){
            update = true ;
            // change the Button
            process.setBackground(Color.orange);
            process.setText("Update Bill Payment");
            
            
        }
        else{
            update = false ;
            process.setBackground(Theme.BUTTON_COLOR);
            process.setText("Add Bill to System");
            
            
        }
    }//GEN-LAST:event_editModeStateChanged

    private void billsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billsTableMouseClicked
        // TODO add your handling code here:
        if (update){
            int row = billsTable.getSelectedRow();
            accountNumber.setText((String) billsTable.getValueAt(row, 3));
            amount.setText((String) billsTable.getValueAt(row, 4));
            String status = (String) billsTable.getValueAt(row, 5);
            
            if (status.equals("paid")){
                billPaid.setSelected(true);
            }
            else{
                billPaid.setSelected(false);
            }
        }else{
            // show balloon tool tip
        }
    }//GEN-LAST:event_billsTableMouseClicked

    public void loadBillsComboBox(){
        try {
        String query = "SELECT `type` FROM `utility_bill`";
        ResultSet rs = database.statement.executeQuery(query);
        
        Vector billTypes = new Vector();
        while(rs.next()){
            billTypes.add(rs.getString("type"));
        }
        
        billType.setModel(new DefaultComboBoxModel(billTypes));
        
        } catch(SQLException ex){
        ex.printStackTrace();
        }
    }
    
    public void updateBillsTable(){
        try{
        String query = "SELECT * FROM `payment`";
        ResultSet rs = database.statement.executeQuery(query);
        
        DefaultTableModel tableModel = new DefaultTableModel();
        
        // add columns to table model
        tableModel.addColumn("id");
        tableModel.addColumn("Bill Type");
        tableModel.addColumn("Date");
        tableModel.addColumn("Account Number");
        tableModel.addColumn("Amount");
        tableModel.addColumn("Paid");
        
        
        // add rows
        Vector rows = new Vector();
        while(rs.next()){
            rows.add(rs.getInt("id"));
            rows.add(rs.getString("utility_bill_type"));
            rows.add(rs.getString("date"));
            rows.add(rs.getString("account_number"));
            rows.add(rs.getString("amount"));
            rows.add(rs.getString("status"));
            
            tableModel.addRow(rows);
            // nullify the vector
            rows = new Vector();
        }
        
        billsTable.setModel(tableModel);
        }catch(SQLException ex){
        ex.printStackTrace();
        }
    }
      public boolean validateInput(){
        ValidateOut vOut= new ValidateOut();
        vOut.validateFloatTextBox(amount);
        return vOut.valid;
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
            java.util.logging.Logger.getLogger(UtilityBills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UtilityBills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UtilityBills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UtilityBills.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UtilityBills dialog = new UtilityBills(new javax.swing.JFrame(), true);
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField accountNumber;
    public javax.swing.JTextField amount;
    public org.jdesktop.swingx.JXPanel backgroundPanel;
    public javax.swing.JCheckBox billPaid;
    public javax.swing.JComboBox billType;
    public org.jdesktop.swingx.JXTable billsTable;
    public javax.swing.JPanel centerPanel;
    public javax.swing.JCheckBox editMode;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public org.jdesktop.swingx.JXLabel jXLabel2;
    public javax.swing.JButton process;
    public org.jdesktop.swingx.JXLabel title;
    // End of variables declaration//GEN-END:variables
}
