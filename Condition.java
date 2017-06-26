/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author richardmagnus-george
 */
public class Condition {

    public String getName() {
        return Name;
    }

    public double getMin() {
        return Min;
    }

    public double getMax() {
        return Max;
    }

    private int ID;
    private String Name;
    private double Min;
    private double Max;

    public Condition() {
        this.ID = ID;
        this.Name = Name;
        this.Min = Min;
        this.Max = Max;
    }
    
    
    public void setID(int ID)
    {
        this.ID = ID;
    }
    public void setName(String Name)
    {
        this.Name = Name;
    }
    public void setMin(double Min)
    {
        this.Min = Min;
    }
    public void setMax(double Max)
    {
        this.Max = Max;
    }
    
    public int getID()
    {
        return ID;
    }
}
