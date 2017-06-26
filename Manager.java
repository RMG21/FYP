/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author richardmagnus-george
 */
import com.phidgets.PhidgetException;
import com.phidgets.SpatialPhidget;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaapplication3.Attach;
import javaapplication3.Condition;
import javaapplication3.DataListener;
import javaapplication3.Detach;
import javaapplication3.ErrorHandler;
import javaapplication3.Motion;
import javaapplication3.Sound;
import javaapplication3.Notification;
import javaapplication3.ReadCondition;

public class Manager //implements SerialPortEventListener 
{
 //   private SpatialPhidget spatial;
 //   private Attach attach_listener;
 //   private Detach detach_listener;
 //   private ErrorHandler error_listener;
 //   private DataListener spatialData_listener;
 //   SerialPort serialPort;
 //   private List<Double> newFre = new ArrayList();
 //   int counter = 0;
 //   private static final String portName = "/dev/tty.usbmodem1421"; // port for Mac OS X
    /**
     * A BufferedReader which will be fed by a InputStreamReader converting the
     * bytes into characters making the displayed results code page independent
     */
 //   private BufferedReader input;
    /**
     * The output stream to the port
     */
 //   private OutputStream output;
    /**
     * Milliseconds to block while waiting for port open
     */
 //   private static final int TIME_OUT = 2000;
    /**
     * Default bits per second for COM port.
     */
 //   private static final int DATA_RATE = 115200;

 //   private static List<Condition> conditions;

//    public void initialize() {
//        CommPortIdentifier portId = null;
//        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();
//
//        //First, Find an instance of serial port.
//        while (portEnum.hasMoreElements()) 
//        {
//            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
//            if (currPortId.getName().equals(portName)) {
//                portId = currPortId;
//                break;
//            }
//        }
//        if (portId == null) {
//            System.out.println("Could not find COM port.");
//            return;
//        }
//
//        try {
//            // open serial port, and use class name for the appName.
//            serialPort = (SerialPort) portId.open(this.getClass().getName(),TIME_OUT);
//            // set port parameters
//            serialPort.setSerialPortParams(DATA_RATE,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
//            // open the streams
//            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
//            output = serialPort.getOutputStream();
//            // add event listeners
//            serialPort.addEventListener(this);
//            serialPort.notifyOnDataAvailable(true);
//        } catch (Exception e) {
//            System.err.println(e.toString());
//        }
//    }
  
    //This should be called when you stop using the port. 
//    public synchronized void close() {
//        if (serialPort != null) {
//            serialPort.removeEventListener();
//            serialPort.close();
//        }
//    }
//
//    public synchronized void serialEvent(SerialPortEvent oEvent) //read data from serial port into a method for processing
//    {
//        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
//            try {
//                String inputLine = input.readLine();
//                System.out.println(inputLine);
//                //Thread t = new Thread((Runnable) new Motion());
//                //t.start();
//                if (Integer.parseInt(inputLine) > 3) {
//                    newFre.add(Double.parseDouble(inputLine));//add values to list
//                    counter++;
//                }
//                if (counter == 10) {
//                    process(newFre);
//                }
//                //put method (condition)
//                //input line will be paramter for method if this matches threshhold
//                //System.out.println(inputLine);
//            } catch (Exception e) {
//                System.err.println(e.toString());
//            }
//        }
//        // Ignore all the other eventTypes, but you should consider the other ones.
//    }

    public static void main(String[] args) throws Exception {
    
    //Creating an object of the first thread        
    Motion motion = new Motion();              

    //Creating an object of the Second thread       
    Sound sound = new Sound();               

    //Starting the first thread         
    motion.start();                

    //Starting the second thread        
    sound.start();   
        
        // System.loadLibrary("rxtxSerial");
//        ReadCondition readConditions = new ReadCondition();
//        conditions = readConditions.read();
//
//        Manager main = new Manager();
//        //only 1 will run at a time
//        main.initialize();
//        //main.motionEvent();
//        
//        
//        Thread t = new Thread() {
//            public void run() {
//                //the following line will keep this app alive for 1000 seconds,
//                //waiting for events to occur and responding to them (printing incoming messages to console).
//                try {
//                    Thread.sleep(1000000);
//                } catch (InterruptedException ie) {
//                }
//            }
//        };
//        t.start();
//        System.out.println("Started");
//        
//    }
} // this was added to fix bracket error

//    public synchronized void motionEvent()
//    {
//        try {
//           SpatialPhidget  spatial = new SpatialPhidget();
//           Attach  attach_listener = new Attach();
//           Detach detach_listener = new Detach();
//           ErrorHandler error_listener = new ErrorHandler();
//           DataListener spatialData_listener = new DataListener();
//
//            spatial.addAttachListener(attach_listener);
//            spatial.addDetachListener(detach_listener);
//            spatial.addErrorListener(error_listener);
//            spatial.addSpatialDataListener(spatialData_listener);
//            spatial.openAny();
//            int counter = 1;
//            while (counter == 1)
//            {
//                Thread.sleep(200);
//            }
//
//        } catch (PhidgetException ex) {
//            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
    
    
//    private void processFrequency(String value) throws InterruptedException {
//        double frequency = Double.parseDouble(value);
//
//        double average;
//        
//        for(int i = 0; i< 14; i++)
//        {
//            newFre.add(frequency);
//            Thread.sleep(1000);
//        }
//        
//        for(Double s : newFre)
//        {
//            System.out.println(s);
//        }
//        for (Condition condition : conditions) {
//            double minimum = condition.getMin();
//            double maximum = condition.getMax();
//            if ((frequency >= minimum) && (frequency <= maximum)) {
//                //implementation
//                System.out.println(condition.getName());
//                Notification SendEmail = new Notification("r.magnus-george@hotmail.co.uk", "Test", condition.getName());
//            }
//        }
//    }

//    public void process(List<Double> value) {
//        double frequency = 0;
//        double average = 0;
//        double minimum = 0; 
//         double maximum = 0;
//        for (Double getValue : value) //extra values from list
//        {
//            frequency += getValue;
//        }
//        System.out.println("size: " + newFre.size());
//        average = frequency / newFre.size();
//        System.out.println("Average: " + average);
//        counter = 0;
//        newFre.clear(); //clear list
//        for (Condition condition : conditions) {
//            minimum = condition.getMin();
//            maximum = condition.getMax();
//            if ((average >= minimum) && (average <= maximum)) {
//                //implementation
//                System.out.println(condition.getName());
//                Notification SendEmail = new Notification("r.magnus-george@hotmail.co.uk", "Test", condition.getName());
//            }
//        }
//        
//    }

}


