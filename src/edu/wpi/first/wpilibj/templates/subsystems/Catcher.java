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

/**
 *
 * @author David
 */
public class Catcher extends Subsystem {
    Relay catchershooter;
    DigitalInput limTop, limBot;
 
    
    public Catcher() {
        catchershooter = new Relay(RobotMap.catcher_relay);
        limTop = new DigitalInput(RobotMap.catcher_Sensor_Up);
        limBot = new DigitalInput(RobotMap.catcher_Sensor_Down);
    }
    
    protected void initDefaultCommand() {
        //this subsystem will look for input from the xbox by default
        //setDefaultCommand(new RunClimber());
    }
    
      //Methods to explicitly set the state of the feeder relay
    public void turnOff() {
        catchershooter.set(Relay.Value.kOff);
        SmartDashboard.putString("Catcher Relay: ", "OFF");
    }
    
    public void setForward() {
        catchershooter.set(Relay.Value.kForward);
        SmartDashboard.putString("Catcher Relay: ", "CLOCKWISE");
    }
    
    public void setBackward() {
        catchershooter.set(Relay.Value.kReverse);
        SmartDashboard.putString("Catcher Relay: ", "CCLOCKWISE");
    }
   
    
    
    //get the state of the feeder as a string
    public String getState() {
        return catchershooter.get().toString();
    }
    
    public boolean getLimTop() {
        return !limTop.get();
    }
    
    public boolean getLimBot() {
        return !limBot.get();
    }
    
}
