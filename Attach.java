/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import com.phidgets.SpatialPhidget;
import com.phidgets.event.AttachEvent;

/**
 *
 * @author richardmagnus-george
 */
public class Attach implements com.phidgets.event.AttachListener {

    @Override
    public void attached(AttachEvent ae) {
        SpatialPhidget attached = (SpatialPhidget) ae.getSource();
        System.out.println("A new device has been plugged in!");

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
