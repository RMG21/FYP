/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import com.phidgets.PhidgetException;
import com.phidgets.SpatialPhidget;
import com.phidgets.event.SpatialDataEvent;
import com.phidgets.event.SpatialDataListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;

/**
 *
 * @author richardmagnus-george
 */
public class DataListener implements SpatialDataListener {

    double xA, yA, zA;
    int seconds = 0;//timer
    int counter = 0;
//Timer timer = new Timer();
//TimerTask task = new TimerTask()
//                    {
//                        public void run() {
//                            seconds++; //timer.equals(5)
////                            while ((xA > -10 && xA < 10) && (yA > -10 && yA < 10) && (zA >-10 && zA <10) && seconds > 1)
////                            {
////                                System.out.println("Hand detected in mouth area");
////                                
////                            }
//                        }
//                        public void start()
//                        {
//                        timer.scheduleAtFixedRate(task, 1, 1000);
//                         };
//                    };

    @Override
    public void data(SpatialDataEvent sde) {
        SpatialPhidget spatial = (SpatialPhidget) sde.getSource();

        try {
            if (spatial.getAccelerationAxisCount() > 0) {
                xA = sde.getData()[0].getAcceleration()[0];
                yA = sde.getData()[0].getAcceleration()[1];
                zA = sde.getData()[0].getAcceleration()[2];

                //implement if statements on the conditions here
                System.out.println("X-Axis: " + xA + "\nY-Axis: " + yA + "\nZ-Axis: " + zA + "\n\n");
                Thread.sleep(1000);

//                while ((xA < 1) && ( yA < 1) && ( zA > 1)) //xA > -0.4 && xA < 0.3) && (yA > -0.6 && yA < -0.7) && (zA >0.6 && zA <0.7
//                {
//            
//                    System.out.println("Hand detected in mouth area");
//                    System.out.println("X-Axis: " + xA + "\nY-Axis: " + yA + "\nZ-Axis: " + zA + "\n\n");
//                    Thread.sleep(1500);
//                    
//                    
//                }
                
                
                if ((xA > -0.35 && xA <= 0) && (yA > -0.5 && yA <= 0) && (zA >= 0.85)) {
                        counter++;
                        System.out.println("hand found");
                        //Thread.sleep(1000);
                    }
                    if (counter == 5) {
                        System.out.println("hand confirm");
                        counter = 0;
                    }
                    
//                for (int i = 0; i < 5; i++) {
//                    
//                }

            }

        } catch (PhidgetException ex) {
            Logger.getLogger(DataListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(DataListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
