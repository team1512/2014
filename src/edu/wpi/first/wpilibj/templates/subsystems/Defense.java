/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.*;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author David
 */
public class Defense extends Subsystem {
    Jaguar defenseshooter;
    DigitalInput limTop, limBot;
 
    
    public Defense() {
        defenseshooter = new Jaguar(RobotMap.defense_jag);
        limTop = new DigitalInput(RobotMap.defense_Sensor_Up);
        limBot = new DigitalInput(RobotMap.defense_Sensor_Down);
    }
    
    protected void initDefaultCommand() {
        //this subsystem will look for input from the xbox by default
        //setDefaultCommand(new RunClimber());
    }
    
      //Methods to explicitly set the state of the feeder relay
    public void turnOff() {
        defenseshooter.stopMotor();
        SmartDashboard.putString("Defense Relay: ", "stopped");
    }
    
    public void setForward() {
        defenseshooter.set(0.5);
        SmartDashboard.putString("Defense Relay: ", "forward");
    }
    
    public void setBackward() {
        defenseshooter.set(-0.5);
        SmartDashboard.putString("Defense Relay: ", "backward");
    }
   
    
    
    //get the state of the feeder as a string
    public String getState() {
        return defenseshooter.toString();
    }
    
    public boolean getLimTop() {
        return limTop.get();
    }
    
    public boolean getLimBot() {
        return limBot.get();
    }
    
}
