/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import com.phidgets.PhidgetException;
import com.phidgets.SpatialPhidget;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author richardmagnus-george
 */
public class Motion extends Thread{

    public synchronized void motionEvent() throws InterruptedException {
        try {
            SpatialPhidget spatial = new SpatialPhidget();
            Attach attach_listener = new Attach();
            Detach detach_listener = new Detach();
            ErrorHandler error_listener = new ErrorHandler();
            DataListener spatialData_listener = new DataListener();

            spatial.addAttachListener(attach_listener);
            spatial.addDetachListener(detach_listener);
            spatial.addErrorListener(error_listener);
            spatial.addSpatialDataListener(spatialData_listener);
            spatial.openAny();
            
            
            int counter = 1;
            while (counter == 1) 
            {

            }

        } catch (PhidgetException ex) {
            Logger.getLogger(Motion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void run(){
        try {
            Motion motion = new Motion();
            motion.motionEvent();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Motion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
