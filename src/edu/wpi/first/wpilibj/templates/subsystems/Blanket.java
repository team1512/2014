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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author David
 */
public class Blanket extends Subsystem {
    //the motor that spins the shooter
    Relay blanketshooter;
    //upper and lower lim switches
    //private DigitalInput limUp, limDown;
    //is the climber on or off
    //private boolean isOn;
    
    public Blanket() {
        blanketshooter = new Relay(RobotMap.blanket_relay);
        //limUp = new DigitalInput(RobotMap.climber_lim_up);
        //limDown = new DigitalInput(RobotMap.climber_lim_down);
        //isOn = false; 
    }
    
    protected void initDefaultCommand() {
        //this subsystem will look for input from the xbox by default
        //setDefaultCommand(new RunClimber());
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

}
