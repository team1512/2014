/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.*;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Collector extends Subsystem {
    Relay collector;
    DigitalInput limTop, limBot;
 
    
    public Collector() {
        collector = new Relay(RobotMap.collector_relay);
    }
    
    protected void initDefaultCommand() {
        //this subsystem will look for input from the xbox by default
        setDefaultCommand(new RunBlanket());
    }
    
      //Methods to explicitly set the state of the feeder relay
    public void turnOff() {
        collector.set(Relay.Value.kOff);
        SmartDashboard.putString("Blanket Relay: ", "OFF");
    }
    
    public void setForward() {
        collector.set(Relay.Value.kForward);
        SmartDashboard.putString("Blanket Relay: ", "CLOCKWISE");
    }
    
    public void setBackward() {
        collector.set(Relay.Value.kReverse);
        SmartDashboard.putString("Blanket Relay: ", "CCLOCKWISE");
    }
   
    
    
    //get the state of the feeder as a string
    public String getState() {
        return collector.get().toString();
    }
    
    public boolean getLimTop() {
        return limTop.get();
    }
    
    public boolean getLimBot() {
        return limBot.get();
    }
    
}
