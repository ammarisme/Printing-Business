/*
 * copyright Ammar Bin Ameerdeen
 * All rights reserved
 */
package printare_system;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.IllegalComponentStateException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.styles.RoundedBalloonStyle;



/**
 *
 * @author Ammar Bin Ameerdeen
 */
public class AnimateCenterPanel {

        public static final int RUN_TIME = 2000;
        public Timer timer ;
        
        private JPanel panel;
        private Color color;
        private PointerInfo p;
        private final Color originalColor ;
        private long startTime;
        private final Point originalLocation;
        private final Dimension originalSize ;
        private int animationId ;
        private Component comp;
        private IMSFrame frame ;
        
        Point location;
        Point stopLocation ;
        // animation 1 - for main UI shirtcut boxes
        public AnimateCenterPanel(JPanel centerPanel, boolean toRight, Point stop, IMSFrame parent) {
         // collecting initial information
            frame = parent ;
            stopLocation = stop ;
               if (toRight){
            animationId = 1;       
               }else{
                   animationId = 2; 
               }
            panel = centerPanel;

            originalColor =    panel.getBackground();
            originalLocation = panel.getLocation();
            originalSize = panel.getSize();
            panel.setLocation(frame.centerPanel.getWidth(),panel.getY());
            
            location  = originalLocation ;
        }
        
        public AnimateCenterPanel(JButton button){
        originalColor =     button.getBackground();
        originalLocation = button.getLocation();
        originalSize = button.getSize();
        
        comp = (Component) button;
        animationId = 3 ;
        
        color = originalColor;
        }
        
        public void initiateTimer(){
            timer = new Timer(0, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (animationId==1){
                  slideRight(e);
                    }
                  if (animationId==2){
                  slideLeft(e);
                    }
                  if (animationId == 3){
                  blinkGreen(e);
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
            startTime = System.currentTimeMillis();
            timer.start();
            
        }
        
        public void slideRight (ActionEvent e){
                    // animation
                   location = new Point((int) location.getLocation().getX()+80,(int) location.getLocation().getY());
                   panel.setLocation(location);
                   
                   
                   
                   if (location.getX()>= stopLocation.getX()){
                       panel.setLocation(stopLocation);
                       
                       ((Timer)e.getSource()).stop();
                   }
                    if (System.currentTimeMillis() > (startTime + 3000)){
                       // at the event of time running out
                        
                        ((Timer)e.getSource()).stop();
                    }
        }
        
        public void slideLeft (ActionEvent e){
                 //animation
                   location = new Point((int) location.getLocation().getX()-80,(int) location.getLocation().getY());
                   panel.setLocation(location);
                   
                   
                 if(location.getX() <= stopLocation.getX()){
                     panel.setLocation(stopLocation);
                      ((Timer)e.getSource()).stop();
                 }
                 
                    if (System.currentTimeMillis() > (startTime + 3000)){
                       // at the event of time running out
                        ((Timer)e.getSource()).stop();
                    }
        }
        
        public void blinkGreen (ActionEvent e){
                    int r = color.getBlue() -1;
                    int g = color.getGreen();
                    int b = color.getBlue()-1;
                    
                    color = new Color(r,g,b);
                    comp.setBackground(color);
                    
                    if (System.currentTimeMillis() > (startTime + 1000)){
                       // at the event of time running out
                        comp.setBackground(Theme.BUTTON_COLOR);
                        ((Timer)e.getSource()).stop();
                    }
        }
       
        
    
}