/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import com.phidgets.event.ErrorEvent;
import com.phidgets.event.ErrorListener;

/**
 *
 * @author richardmagnus-george
 */
public class ErrorHandler implements ErrorListener{

    @Override
    public void error(ErrorEvent ee) {
        System.out.println(ee.toString());
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
