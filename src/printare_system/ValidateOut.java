/*
 * copyright Ammar Bin Ameerdeen
 * All rights reserved
 */
package printare_system;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JTextField;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.styles.RoundedBalloonStyle;
import net.java.balloontip.utils.ToolTipUtils;

/**
 *
 * @author Ammar Bin Ameerdeen
 */
public class ValidateOut {
    public boolean valid ;
    BalloonTip balloonTip;
    float opacity ;
    Color color ;
    public ValidateOut(){
        valid = true ;
        opacity =(float) 0.7 ; // balloontip opacity
        color = new Color(255,200,200);
    }
    
    public void validateIntTextBox(JTextField jtf){
         Validate v = new Validate();

        
        if (!v.isInteger(jtf.getText())){
            BalloonTip balloonTip = new BalloonTip(jtf, "Please enter only numbers, eg :- 230");
            balloonTip.setStyle(new RoundedBalloonStyle(5,5,color, color));
            balloonTip.setOpacity(opacity);
            
            ToolTipUtils.balloonToToolTip(balloonTip, 0, 2000);
            balloonTip.setVisible(true);
            jtf.setText("");
            valid= false;
            return ;
        }
        else if (v.isEmpty(jtf.getText())){
            BalloonTip balloonTip = new BalloonTip(jtf, "Please enter the quantity eg :- 230");
            balloonTip.setStyle(new RoundedBalloonStyle(5,5,color,color));
            balloonTip.setOpacity(opacity);
            
            ToolTipUtils.balloonToToolTip(balloonTip, 0, 3000);
            balloonTip.setVisible(true);
            jtf.setText("");
            valid= false;
            return ;
        }
    }
    
      public void validateNonEmptyTextBox(String text, JComponent jtf){
         Validate v = new Validate();
        
        if (v.isEmpty(text)){
            BalloonTip balloonTip = new BalloonTip(jtf, "This field cannot be left empty");
            balloonTip.setStyle(new RoundedBalloonStyle(5,5,color,color));
            balloonTip.setOpacity(opacity);
            
            ToolTipUtils.balloonToToolTip(balloonTip, 0, 3000);
            balloonTip.setVisible(true);
            valid= false;
            return ;
        }
    }
    public void validateFloatTextBox(JTextField jtf){
         Validate v = new Validate();

        
        if (!v.isFloat(jtf.getText())){
            BalloonTip balloonTip = new BalloonTip(jtf, "Please enter only numbers, eg :- 230.00");
            balloonTip.setStyle(new RoundedBalloonStyle(5,5,color,color));
            balloonTip.setOpacity(opacity);
            
            ToolTipUtils.balloonToToolTip(balloonTip, 0, 3000);
            balloonTip.setVisible(true);
//            Animate a = new Animate(balloonTip);
//            a.start();
            jtf.setText("");
            valid= false;
            return ;
        }
        else if (v.isEmpty(jtf.getText())){
            BalloonTip balloonTip = new BalloonTip(jtf, "Please enter a number eg :- 260.00");
            balloonTip.setStyle(new RoundedBalloonStyle(5,5,color,color));
            balloonTip.setOpacity(opacity);
            
            ToolTipUtils.balloonToToolTip(balloonTip, 0, 3000);
            balloonTip.setVisible(true);
            jtf.setText("");
            valid= false;
            return ;
        }
    }
    
    public void validateDate(JDateChooser date){
        if (date.getDate() == null){
            BalloonTip balloonTip = new BalloonTip(date, "Please select date");
            balloonTip.setStyle(new RoundedBalloonStyle(5,5,color,color));
            balloonTip.setOpacity(opacity);
            
            ToolTipUtils.balloonToToolTip(balloonTip, 0, 3000);
            balloonTip.setVisible(true);
            valid= false;
            return ;
        }
    }
    
    
}
