package edu.wpi.first.wpilibj.templates.subsystems;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.*;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter extends Subsystem {
    private Jaguar shooter;
    DigitalInput limTop, limBot;
 
    
    public Shooter() {
        shooter = new Jaguar(RobotMap.shooter_jag);        
        limTop = new DigitalInput(RobotMap.shooter_Sensor_Up);
        limBot = new DigitalInput(RobotMap.shooter_Sensor_Down);
    }
    
    protected void initDefaultCommand() {
        //this subsystem will look for input from the xbox by default
        //setDefaultCommand(new RunClimber());
    }
    
      //Methods to explicitly set the state of the feeder relay
    public void active(double speed) {
        shooter.set(speed);
        SmartDashboard.putString("Shooter: ", String.valueOf(speed));
    }
    
    public boolean getLimTop() {
        return limTop.get();
    }
    
    public boolean getLimBot() {
        return limBot.get();
    }
    
}
