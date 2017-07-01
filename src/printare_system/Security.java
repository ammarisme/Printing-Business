/*
 * copyright Ammar Bin Ameerdeen
 * All rights reserved
 */
package printare_system;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ammar Bin Ameerdeen
 * 
 * For software security and anti piracy functions
 */


public class Security {
    Database database ;
    
    
/**
 * requires a proper database connection to use this class
 */    
    public Security (){
         database = new Database();
         database.connect();
    }
    
/**
 * This function can be modified to improve the security check
 * 
 * Checks the database if the id of row where name is print is larger than 0
 * if it is equals or less than 0 software is not authorized.
 *  else software is authorized
 * 
 * Requires a proper database connection to execute this function. If there is no database connection, software is considered
 * unauthorized.
 * @since release 1.0
 */
    public boolean isAuthorized(){
        try {
            String query = "SELECT `id` FROM `business` WHERE `name`='print'";
            ResultSet rs = database.statement.executeQuery(query);
            int id = 0;
            rs.next();
            id = rs.getInt("id");
            if ( id <= 0){
                return false ;
            }
            else{
            String update = "UPDATE `business` SET `id` = "+(--id)+" WHERE `name`='print'";
            database.statement.executeUpdate(update);
            return true ;
            }
            
        } catch (SQLException ex) {
         //   Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
            return false ;
        }
    }
    
    // There was an unistall function here. if throws an error. Please call the uninstall function from Database class.
}
