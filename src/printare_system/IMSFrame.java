/*
 * copyright Ammar Bin Ameerdeen
 * All rights reserved
 */
package printare_system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.styles.RoundedBalloonStyle;
import org.jdesktop.swingx.JXLabel;
import org.jdesktop.swingx.JXPanel;

/**
 *
 * @author Ammar Bin Ameerdeen
 * 
 * The parent class for all the frames created within the applications.
 * 
 * Default features must be defined in this class.
 * Features default loaded - backgroundPanel , centerPanel , title, notifications
 * 
 * Connects to the database to fetch notification details.
 * 
 * Theme is loaded in child classes. Because theme requires the particular instance of the child class to manipulate the UI.
 * 
 * 
 */
public class IMSFrame extends javax.swing.JFrame{
    // UI components
    JXPanel backgroundPanel;
    JPanel centerPanel ;
    JXLabel title ;
    public JLabel jLabels[]= new JLabel[0];
    public static Notifications notifications ; // created as static, so can be updated from anywhere in the application
    
    boolean notificationsBox = false ;
   
    // database connection
    Database database ; 
    
    public IMSFrame (){
    super();
    database = new Database();
    database.connect();
    
    title = new JXLabel();
    centerPanel = new JPanel();
    backgroundPanel = new JXPanel();
    // thinking of putting the notification here. Not required now because for now only the home screen needs it
    
    }
    
    /**
     * 
     * @return 
     * the title JLabel - 
     */
    public JXLabel getFrameTitle(){
        return title;
    }
    
    /**
     * 
     * @return 
     * the background panel
     */
    public JXPanel getBackgroundPanel(){ // getBackgroundPanel
        return backgroundPanel ;
    }
    /**
     * 
     * @return 
     * the center panel
     */
    public JPanel getCenterPanel(){
        return centerPanel ;
    }
    
    /**
     * 
     * @return 
     * the notification panel
     *  - This is the only place where notifications panel is being initialized
     *  Initial layout for notification panel is set here.
     * Mouse entered and exited listeners also set here.
     */
    public JPanel getNotificationsPanel(){
        Point p = new Point((int) (30+centerPanel.getWidth()-Theme.NOTIFICATIONS_PANEL_MIN_SIZE.getWidth()),10);
        notifications = new Notifications(this);
        
        
        notifications.setLocation(p);
        notifications.setBackground(Theme.NOTIFICATIONS_PANEL_COLOR);
        notifications.setSize(Theme.NOTIFICATIONS_PANEL_MIN_SIZE);
        notifications.setName("notifications"); // NOI18N
        notifications.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        
        notifications.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                notificationsMouseExited(evt);

            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                notificationsMouseEntered(evt);
                
            }
        });
        return notifications ;
    }
    
    /**
     * 
     * @param evt - Mouse enters the notification panel
     * 
     * This method and the exit method uses notifications.showing boolean value
     * notifications.showing is set to false
     *  When - notification object is initiating.
     *       - notification mouse exit method executed
     *       - notification mouse enter animation exited from any of its nodes
     * 
     * notifications.showing is set true
     * When - notification panel reaches its peak of animation
     * 
     * Notification panel is set to initial size only if Notifications.showing = false 
     * 
     * 
     * if Number of `notified`='0' entries in notification table is 0 and Notifications.showing = false then 
     *  Show a balloon tooltip saying No notifications and return. (Runs in a seperate thread. Be careful when debugging)
     * 
     * if there are notifications and the notification box is not showing, then 
     * Maximize the notifications panel and add notification items to it. Remember both are done simultaniously in different threads.
     * Careful when debugging.
     * 
     * @see notificaationMouseExited()
     */
    
  private void notificationsMouseEntered(java.awt.event.MouseEvent evt) {                                           
      // if no notifications put a balloon tooltip and return
         
      
      if (notifications.showing==false){
        notifications.setSize(Theme.NOTIFICATION_ICON_SIZE_DEFAULT);
        notifications.setLocation(Theme.NOTIFICATION_LOCATION);
        notifications.setBackground(Theme.NO_NOTIFICATIONS_PANEL_COLOR);
        
        if (notifications.getNumberOfNotifications() <= 0){
          
          BalloonTip balloonTip = new BalloonTip(notifications, Theme.NO_NOTIFICATIONS_TEXT);
          balloonTip.setOpacity((float) 0.5);
          balloonTip.setStyle(new RoundedBalloonStyle(5,5,Theme.NOTIFICATIONS_PANEL_COLOR, Theme.NOTIFICATIONS_PANEL_COLOR));
          Animate a = new Animate(balloonTip);
          a.start();
          
          return ;
         }
        
        Animate a = new Animate((Notifications) evt.getComponent());
        a.start();
        updateNotifications();
        }
  }                                          

  /**
   * @param  evt - Mouse exits the panel area - Maybe leaving the region or just entering a child panel
   * 
   * If Mouse is within the bounds, this method is useless
   */
  
    private void notificationsMouseExited(java.awt.event.MouseEvent evt) {                                          
        /*
        This method will execute even if the mouse is moving to a child panel
        below code checks if the mouse is within the BOUNDS of Notifications
        */
        PointerInfo pInfo = MouseInfo.getPointerInfo();
        Point p = pInfo.getLocation();
        Point uLocation = notifications.getLocationOnScreen();
        
        // Mouse is NOT within panel bounds.? If Mouse is within the bounds, this method is useless
        if(!notifications.contains((int) (p.getX()- uLocation.getX()),(int) (p.getY()-uLocation.getY()))){
                        // set notification panel to its default position and size
                        notifications.setSize(Theme.NOTIFICATIONS_PANEL_MIN_SIZE);
                        notifications.setLocation(Theme.NOTIFICATION_LOCATION);
                        notifications.removeAll();
                        
                        // based on the number of notifications remaining, decide the panel color and number of Notifications JLabel
                        if (notifications.getNumberOfNotifications() > 0){
                            // setting background, nuber Of notifications
                            notifications.setBackground(Theme.NOTIFICATIONS_PANEL_COLOR);  
                            JLabel numberOfNotifications = new javax.swing.JLabel();
                            numberOfNotifications.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
                            numberOfNotifications.setText(""+notifications.getNumberOfNotifications()+"");
                            numberOfNotifications.setName("numberOfNotifications"); // NOI18N
                            notifications.add(numberOfNotifications, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
                            revalidate(); // revalidating the frame
                            
                        }else{
                            // setting background to ash. 
                            notifications.setBackground(Theme.NO_NOTIFICATIONS_PANEL_COLOR);
                        }
                        
                        // we have a small box in the corner. So notification.showing is false.
                        notifications.showing = false ;
                        revalidate(); // revalidating the frame
                        return;
                    }
    }
    
    /**
     * this method should only execute when Notification.showing = true or its on the way expanding
     * I didn't check here, because in case if it is expanding, it is in a different thread.
     * 
     * Fetches all the unnotified notifications from the table
     * NOTIFICATION DATA WON'T BE MANIPULATED ON READ - ITS A POLICY
     * So, put the whole thing when entering to the database.
     * 
     * @see mouse enter method
     */
    
    public void updateNotifications(){
        try {
            
            notifications.removeAll(); // resetting the notification panel

            //fetching notifications from database
            String query = "SELECT * FROM `notification` WHERE `notified`='0'";
            ResultSet rs = database.statement.executeQuery(query);

            // adds notification items to the notifiaction panel. No manipulations to data in the table (y)
            while(rs.next()){
                notifications.addNotificationItem(rs.getString("title"), rs.getString("text"),this, rs.getInt("id"));
            }
            notifications.nextItemLocation = new Point(20,20); // This can be put in the beggining of the method also. Denotes the position from where notifications will be listed
        } catch (SQLException ex) {
            // Logger.getLogger(IMSFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // There was some dumpable methods here, on mouse exit method. That is implemented above
}

