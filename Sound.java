/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import com.phidgets.SpatialPhidget;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author richardmagnus-george
 */
public class Sound extends Thread implements SerialPortEventListener 
{
    SerialPort serialPort;
    private List<Double> newFre = new ArrayList();
    int counter = 0;
    private static final String portName = "/dev/tty.usbmodem1421"; // port for Mac OS X
    /**
     * A BufferedReader which will be fed by a InputStreamReader converting the
     * bytes into characters making the displayed results code page independent
     */
    private BufferedReader input;
    /**
     * The output stream to the port
     */
    private OutputStream output;
    /**
     * Milliseconds to block while waiting for port open
     */
    private static final int TIME_OUT = 2000;
    /**
     * Default bits per second for COM port.
     */
    private static final int DATA_RATE = 115200;

    private static List<Condition> conditions;

    public void initialize() {
        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        //First, Find an instance of serial port.
        while (portEnum.hasMoreElements()) 
        {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            if (currPortId.getName().equals(portName)) {
                portId = currPortId;
                break;
            }
        }
        if (portId == null) {
            System.out.println("Could not find COM port.");
            return;
        }

        try {
            // open serial port, and use class name for the appName.
            serialPort = (SerialPort) portId.open(this.getClass().getName(),TIME_OUT);
            // set port parameters
            serialPort.setSerialPortParams(DATA_RATE,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
            // open the streams
            input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
            output = serialPort.getOutputStream();
            // add event listeners
            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
  
    //This should be called when you stop using the port. 
    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    public synchronized void serialEvent(SerialPortEvent oEvent) //read data from serial port into a method for processing
    {
        if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                String inputLine = input.readLine();
                System.out.println("Frequency : " + inputLine);
                //Thread t = new Thread((Runnable) new Motion());
                //t.start();
                if (Integer.parseInt(inputLine) > 3) {
                    newFre.add(Double.parseDouble(inputLine));//add values to list
                    counter++;
                }
                if (counter == 10) {
                    processSound(newFre);
                }
                //put method (condition)
                //input line will be paramter for method if this matches threshhold
                //System.out.println(inputLine);
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
        // Ignore all the other eventTypes, but you should consider the other ones.
    }
    
    public boolean processSound(List<Double> value) {
        double frequency = 0;
        double average = 0;
        double minimum = 0; 
         double maximum = 0;
        for (Double getValue : value) //extra values from list
        {
            frequency += getValue;
        }
        System.out.println("size: " + newFre.size());
        average = frequency / newFre.size();
        System.out.println("Average: " + average);
        counter = 0;
        newFre.clear(); //clear list
        for (Condition condition : conditions) {
            minimum = condition.getMin();
            maximum = condition.getMax();
            
        }
        if ((average >= minimum) && (average <= maximum)) {
                //implementation
                return true;
                //System.out.println(condition.getName());
                //Notification SendEmail = new Notification("r.magnus-george@hotmail.co.uk", "Test", condition.getName());
            }
        else
            return false;
    }

    public void run(){
        Sound sound = new Sound();
        sound.initialize();
    }
}
