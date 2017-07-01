/*
 * copyright Ammar Bin Ameerdeen
 * All rights reserved
 */
package printare_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Ammar Bin Ameerdeen
 */

public class Database {
    // strings below are self explanatory
 public static final String databaseName="printare" ; 
 public static final String databasePassword="root";
 public static final String databaseUsername="root" ;
 public static final String databaseHost="localhost" ;
 public static final String databasePort="3306" ;
 public Connection connection;
 public Statement statement ;
 
 
 /**
 This class contains all the database constants and functions.
 * * TODO : implement developer and production modes for error handling
 */
 public Database(){
 }
 
 
 /**
  * Drop all the tables of the database. List of tables need to be 
  * entered in the method manually.
  */
 public void uninstall(){
 dropTable("services_of_sale");
 dropTable("service_sale");
 dropTable("service");
 dropTable("service_category");
 dropTable("material_print");
 dropTable("print_order");
 dropTable("material_of_load");
 dropTable("material_load");
 dropTable("supplier");
 dropTable("product_of_sale");
 dropTable("card_sold");
 dropTable("reload_sent");
 dropTable("card");
 dropTable("network_b");
 dropTable("project");
 dropTable("payment");
 dropTable("material_detail");
 dropTable("item_sale");
 dropTable("order");
 dropTable("customer");
 dropTable("product_in_grn");
 dropTable("grn");
 dropTable("product");
 dropTable("product_category");
 dropTable("utility_bill");
 dropTable("business");
 dropTable("notification");
 }
     
 
 /**
  * @param table
  * the table to drop
  * 
  * Connects to the database if not already connected. Drops the table if it exists.
  * Logger is disabled in the production release. Please enable in developer mode.
 */
 public void dropTable(String table){
     try {
         String update = "DROP TABLE IF EXISTS `"+table+"`";
         if (connection==null){
             connect();
         }
         statement.executeUpdate(update);
     } catch (SQLException ex) {
         // Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
     }
 }
 
 /**
  * Connects to the database defined as a constant
  * 
  * @return
  *  true - connection was successful
  *  false- connection failed. 
  *     Check server , database constants
  *     there is a connection exception or connection didn't succeed but no exception either!
  * @exception  SQLException
  */
 public boolean connect (){
     try {
         connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databaseName, databaseUsername, databasePassword);
        
         statement = connection.createStatement(); 
        
         if (connection !=null){
            return true;
        }
     } catch (SQLException ex) {
        // Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
         return false;
     }
     return false;
 }
 
/**
 * Disconnects the database connection if there is already a connection
 * 
 * @return 
 * true - there was a connection and it is disconnected
 * false - there was no connection to disconnect
 *       - there was a connection, an exception formed when closing it
 */
 public boolean disconnect(){
     try {
         if (connection!=null){
         connection.close();    
         return true ;
         }else{
         return false ;
         }
         
         
     } catch (SQLException ex) {
       //   Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
         return false ;
     }
 }
 
 
 /**
  * Installing the database
  * Attempts to connect to the database without a database name. If there is already a connection then continue with that connection.
  * 
  * step 1 - create data definition
  * step 2 - populate the database with initial data
  * 
  * SQL script -
    *    is taken from Script.java
    *    each and every statement needs to be delimited using ";"
  */
 public void install(){
     try {
         if (connection==null){
                 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/?user="+databaseUsername+"&password="+databasePassword);
             }
        Statement statement = connection.createStatement();
         
        Script sql = new Script();
        String s [] =sql.script.split(";");
        
        for (int i=0; i< s.length; i++) {
         //   System.out.println(s[i]);
            statement.executeUpdate(s[i]);
        }
        s = sql.data.split(";");
        for (int i=0; i< s.length; i++) {
        //    System.out.println(s[i]);
            statement.executeUpdate(s[i]);
        }        
     } catch (SQLException ex) {
       //  Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
     }
 }
 
 public Vector getColumn(String column, String table, String condition , String orderBy){
     String query = "SELECT "+column+" FROM "+table ;
     if (condition!=null){
         query = query + " WHERE "+condition+" " ;
     }
     if (orderBy!=null){
         query= " ORDER BY "+orderBy ;
     }
     if(connection==null){
         System.out.println("Not connected to "+databaseName);
         return null;
     }
     try {
         ResultSet rs = statement.executeQuery(query);
         
         Vector v = new Vector();
         while(rs.next()){
             v.add(rs.getObject(column));
         }
         
         return v;
     } catch (SQLException ex) {
         Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
     }
  return null;

 }
}
