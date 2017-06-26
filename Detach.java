/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import com.phidgets.SpatialPhidget;
import com.phidgets.event.DetachEvent;

/**
 *
 * @author richardmagnus-george
 */
public class Detach implements com.phidgets.event.DetachListener{

    @Override
    public void detached(DetachEvent de) {
        SpatialPhidget detached = (SpatialPhidget) de.getSource();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
