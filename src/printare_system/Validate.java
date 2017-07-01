/*
 * copyright Ammar Bin Ameerdeen
 * All rights reserved
 */
package printare_system;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ammar Bin Ameerdeen
 */
public class Validate {
    
    
    public boolean isInteger (String test){
        Pattern pattern = Pattern.compile("\\d*");
        Matcher matcher=pattern.matcher(test);
        if(matcher.matches()){
            return true ;
        }
        return false ;
    }
    
    public boolean isEmpty(String test){
        if (test.equals("")){
            return true;
        }
        return false ;
    }
    
    public boolean isFloat(String text){
        try {
         float f = Float.parseFloat(text);
        } catch(Exception e){
            return false ;
        }
        return true ;
    }
    
    
    
    
}
