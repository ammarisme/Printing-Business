/*
 * copyright Ammar Bin Ameerdeen
 * All rights reserved
 */
package printare_system;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Ammar Bin Ameerdeen
 */
public class Common {
    Database database;
//    public static final Color BUTTON_COLOR = new Color(68,124,74);

    public Common(){
        database = new Database();
        database.connect();
        
    }
    public DefaultComboBoxModel getComboBoxModel(String tableName , String columnName){
        DefaultComboBoxModel result = new DefaultComboBoxModel();
        try {
            String query = "SELECT `"+columnName+"` FROM `"+tableName+"`";
            ResultSet rs = database.statement.executeQuery(query);
            
            Vector v = new Vector();
            while(rs.next()){
                v.add(rs.getString(columnName));
            }
            
           result = new DefaultComboBoxModel(v);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public DefaultTableModel updateTableModel(DefaultTableModel tableModel, Vector v){
        tableModel.addRow(v);
        return tableModel;
    }
    
    public String getFormatDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
        
     public int getId(String pk, String table){
         try {
             String query ="SELECT max(`"+pk+"`) FROM `"+table+"`";
             ResultSet rs = database.statement.executeQuery(query);
             rs.next();
             
             return (rs.getInt("max(`"+pk+"`)"));
         } catch (SQLException ex) {
             Logger.getLogger(GRN.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return 0;
    }
     
    public DefaultTableModel getTable(String [] uiColumns, String [] dbColumns, String dbTable, String conditions , String orderBy){
        // create columns
        DefaultTableModel tableModel = new DefaultTableModel();
        for (int i=0; i< uiColumns.length ; i++){
            tableModel.addColumn(uiColumns[i]);
        }
        
        // creating from columns - assuming dbColumns.length>=0
        String fromColumns = "`"+dbColumns[0]+"`";
        for (int i = 1;i < dbColumns.length ; i++){
            fromColumns=fromColumns+",`"+dbColumns[i]+"`";
        }
        
        // create query 
        String query = "SELECT "+fromColumns+ " FROM `"+dbTable+"`";
        if (conditions!=null){
            query = query + " WHERE "+conditions ;
        }
        if (orderBy!=null){
            query = query + " ORDER BY "+ orderBy ;
        }
        
        
        
        try {
            //System.out.println(query);
            ResultSet rs = database.statement.executeQuery(query);
            //looping rows
            while(rs.next()){ // if an error jumps check lengths of uiColumn and dbColumn arrays
                // looping columns
        Vector v = new Vector();
                for (int k=0; k< dbColumns.length ; k++){
                v.add(rs.getObject(dbColumns[k])); // this k must not excceed rs column count
             }
             tableModel.addRow(v);
            }
          
            return tableModel;
        } catch (SQLException ex) {
            Logger.getLogger(Common.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
public void insertIntoTable(String table, String [] columns , String []values){
    String insert = "INSERT INTO "+table+" ";
    
    // columns
    int i = 0 ;
    insert = insert + "(`"+columns[i]+"`";
    for (i=1 ; i < columns.length;i++){
        insert = insert + ",`"+columns[i]+"`";
    }
    insert = insert +")";
    
    i = 0 ;
    insert = insert + " VALUES ('"+values[i]+"'";
    for (i=1 ; i < values.length;i++){
        insert = insert + ",'"+values[i]+"'";
    }
    insert = insert +")";
    if (database.connection!=null){
        database.connect();
    }
        try {
            database.statement.executeUpdate(table);
        } catch (SQLException ex) {
            Logger.getLogger(Common.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
}     
}
