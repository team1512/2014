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
public class Blanket extends Subsystem {
    Relay blanketshooter;
    DigitalInput limTop, limBot;
 
    
    public Blanket() {
        blanketshooter = new Relay(RobotMap.blanket_relay);
        limTop = new DigitalInput(RobotMap.blanket_Sensor_Up);
        limBot = new DigitalInput(RobotMap.blanket_Sensor_Down);
    }
    
    protected void initDefaultCommand() {
        //this subsystem will look for input from the xbox by default
        setDefaultCommand(new RunBlanket());
    }
    
      //Methods to explicitly set the state of the feeder relay
    public void turnOff() {
        blanketshooter.set(Relay.Value.kOff);
        SmartDashboard.putString("Blanket Relay: ", "OFF");
    }
    
    public void setForward() {
        blanketshooter.set(Relay.Value.kForward);
        SmartDashboard.putString("Blanket Relay: ", "CLOCKWISE");
    }
    
    public void setBackward() {
        blanketshooter.set(Relay.Value.kReverse);
        SmartDashboard.putString("Blanket Relay: ", "CCLOCKWISE");
    }
   
    
    
    //get the state of the feeder as a string
    public String getState() {
        return blanketshooter.get().toString();
    }
    
    public boolean getLimTop() {
        return limTop.get();
    }
    
    public boolean getLimBot() {
        return limBot.get();
    }
    
}
