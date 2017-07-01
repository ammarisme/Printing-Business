/*
 * copyright Ammar Bin Ameerdeen
 * All rights reserved
 */
package printare_system;

import java.awt.Color;
import java.awt.Component;
import java.awt.IllegalComponentStateException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.styles.RoundedBalloonStyle;



/**
 *
 * @author Ammar Bin Ameerdeen
 */
public class Animate {

        public static final int RUN_TIME = 2000;
        public Timer timer ;
        
        private JPanel panel;
        private Color color;
        private PointerInfo p;
        private final Color originalColor ;
        private long startTime;
        private final Point originalLocation;
        private final int originalWidth ;
        private final int originalHeight ;
        private int animationId ;
        private BalloonTip balloon;
        private Notifications notifications;
        // animation 1 - for main UI shirtcut boxes
        public Animate(JPanel panel, Color from) {
            animationId =1 ;
            this.panel = panel;
            this.color = from ;
            p = MouseInfo.getPointerInfo();
            originalColor = panel.getBackground();
            originalLocation = panel.getLocation();
            originalWidth = panel.getWidth();
            originalHeight = panel.getHeight();
        }
        
        // animation 2 - for balloon tool tips on error
        public Animate(BalloonTip bTip){
         animationId = 2 ;
         originalColor = bTip.getBackground();
         originalLocation = bTip.getLocation();
         originalWidth = bTip.getWidth();
         originalHeight = bTip.getHeight();
         color = Color.WHITE ;
         balloon = bTip ;
         bTip.setVisible(true);
         
        }

        // animation 3 - for notification box
        public Animate (Notifications notificationArea){
            animationId = 3;
            notifications =  notificationArea;
            originalColor = notificationArea.getBackground();
            color = originalColor ;
            originalLocation = notificationArea.getLocation();
            originalWidth = notificationArea.getWidth();
            originalHeight = notificationArea.getHeight();
        }
        public void initiateTimer(){
            timer = new Timer(0, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (animationId==1){
                  animateMainUIBoxes(e);      
                    }
                    if (animationId ==2){
                  animateToolTipError(e);
                    }
                    if (animationId == 3){
                  animateNotification(e);
                    }
                  
                  
                }
            });
                    if (animationId == 1){
                        timer.setDelay(20);
                    }
                    if (animationId == 2){
                        timer.setDelay(20);
                    }
                    if (animationId == 3){
                        timer.setDelay(10);
                    } 
        }
        
        public void start() {
            
            initiateTimer();
            timer.setRepeats(true);
            timer.setCoalesce(true);
            timer.setInitialDelay(0);
            timer.setDelay(20);
            startTime = System.currentTimeMillis();
            timer.start();
        }

        public void animateMainUIBoxes(ActionEvent e){
            // color animation
                    int g = color.getGreen();
                    int b = color.getBlue();
                    int r = color.getRed();
                    //[20,214,42] 
                    r = r - 5;
                     b = b - 5;
                             if (r <=20 ){
                                 r = 20 ;
                             }
                             if (b<=42){
                                 b = 42;
                             }
                             if (g >= 214){
                                 g = 214 ;
                             }else{
                                 g = g +5 ;
                             }
                    
                    Color f = new Color(r,g,b);
                    
                    color = new Color(f.getRGB());
                    panel.setBackground(color);
          
                    
                    Point panelLocation = null;
                    Point uLocation=null;
                    Point p=null;
                    
                    try{
                    PointerInfo pInfo = MouseInfo.getPointerInfo();
                    p = pInfo.getLocation();
                    uLocation = panel.getLocationOnScreen();
                    panelLocation = panel.getLocation();
                    
                    }catch(IllegalComponentStateException ex){
               //        ex.printStackTrace();
                        panel.setBackground(originalColor);
                        
                        panel.setSize(originalWidth, originalHeight);
                        panel.setLocation(originalLocation);
                        
                        ((Timer)e.getSource()).stop();
                    }
                    // size animation, collect size and place
                    
                    int width = panel.getWidth();
                    int height = panel.getHeight();
                    
                    // new location and size
                    if ((originalLocation.getX()-10) <= panel.getLocation().getX()){
                    // do the animation
                        try {
                        panel.setLocation(((int) panelLocation.getX()-1),((int) panelLocation.getY()-1));
                        panel.setSize(width+2, height+2);
                        }catch (NullPointerException ex){
                            // ex.printStackTrace();
                        }
                        
                    }
                    try {
                    // if mouse moved out while animation
                    if(!panel.contains((int) (p.getX()-uLocation.getX()),(int) (p.getY()-uLocation.getY()))){
                        
                        panel.setBackground(originalColor);
                        
                        panel.setSize(originalWidth, originalHeight);
                        panel.setLocation(originalLocation);
                        
                        ((Timer)e.getSource()).stop();
                    }
                    if (System.currentTimeMillis() > (startTime + 500)){
                        ((Timer)e.getSource()).stop();

                    }
                    } catch(Exception ex){
                        panel.setSize(originalWidth, originalHeight);
                        panel.setLocation(originalLocation);
                        
                        panel.setBackground(originalColor);
                    }
        }
        
        public void animateToolTipError (ActionEvent e){
                    int g = color.getGreen();
                    int b = color.getBlue();
                    int r = color.getRed();
                     g = g - 100;
                     b = b - 100;
                     
                    Color f = new Color(r,g,b);
                    
                    balloon.setStyle(new RoundedBalloonStyle(5,5,f, f));
                    
                    
                    if (System.currentTimeMillis() > (startTime + 3000)){
                        balloon.setBackground(originalColor);
                        balloon.setVisible(false);
                        ((Timer)e.getSource()).stop();
                    }
        }
        
        public void animateNotification(ActionEvent e){
            // color animation
                    int g = color.getGreen();
                    int b = color.getBlue();
                    int r = color.getRed();
                    //[20,214,42] 
                    r = r - 5;
                    b = b - 5;
                    g = g -5 ; 
                             if (r <=20 ){
                                 r = 20 ;
                             }
                             if (b<=20){
                                 b = 20;
                             }
                             if (g <= 20){
                                 g = 20 ;}
                             
                    Color f = new Color(r,g,b);
                    
                    color = new Color(f.getRGB());
                    
                    // in case if the panel is null
                    try {
                    notifications.setBackground(color);
                    } catch (NullPointerException ex){
                        notifications.showing = false ;
                        ((Timer)e.getSource()).stop();
                    }
                    
                    
                    Point panelLocation = null;
                    Point uLocation=null;
                    Point p=null;
                    
                    // something issue with the mouse location
                    try{
                    PointerInfo pInfo = MouseInfo.getPointerInfo();
                    p = pInfo.getLocation();
                    uLocation = notifications.getLocationOnScreen();

                    
                    }catch(IllegalComponentStateException ex){
                        notifications.setBackground(Theme.NO_NOTIFICATIONS_PANEL_COLOR);
                        
                        notifications.setSize(originalWidth, originalHeight);
                        notifications.setLocation(originalLocation);
                        notifications.showing = false ;
                        ((Timer)e.getSource()).stop();
                    }
                    
                    // size animation, collect size and place
                    int width ;
                    int height ; 
                    
                    
                    
                    width = notifications.getWidth();
                    height = notifications.getHeight();
                    
                    // new location and size
                    if ((originalLocation.getX()-1000) <= notifications.getLocation().getX()){
                    // do the animation
                        try {
                            if (originalLocation.getX() - notifications.getLocation().getX() <= 350){
                                notifications.setLocation(((int) notifications.getLocation().getX()-20),((int) notifications.getLocation().getY()));
                                notifications.setSize(notifications.getWidth()+20, notifications.getHeight()+25);
                            }else{
                                // panel doesn't need to get more bigger
                                notifications.showing = true ;
                            }
                            // again null pointer probably
                        }catch (NullPointerException ex){
                                notifications.setBackground(Theme.NO_NOTIFICATIONS_PANEL_COLOR);
                                notifications.setSize(originalWidth, originalHeight);
                                notifications.setLocation(originalLocation);
                                ((Timer)e.getSource()).stop();
                        }
                        
                    }
                    try {
                    if(!notifications.contains((int) (p.getX()- uLocation.getX()),(int) (p.getY()-uLocation.getY()))){
                        notifications.setBackground(Theme.NO_NOTIFICATIONS_PANEL_COLOR);
                        notifications.setSize(originalWidth, originalHeight);
                        notifications.setLocation(originalLocation);
                        notifications.removeAll();
                        
                        ((Timer)e.getSource()).stop();
                    }
                    } catch(Exception ex){
                        ex.printStackTrace();
                        notifications.setBackground(Theme.NO_NOTIFICATIONS_PANEL_COLOR);
                        
                        notifications.setSize(originalWidth, originalHeight);
                        notifications.setLocation(originalLocation);
                        
                        ((Timer)e.getSource()).stop();
                    }
                      if (System.currentTimeMillis() > (startTime + 400)){
                        ((Timer)e.getSource()).stop();
                        
                    }else{
//                        System.out.println(System.currentTimeMillis());
                          notifications.showing = false ;
                    }
        }
    
}
