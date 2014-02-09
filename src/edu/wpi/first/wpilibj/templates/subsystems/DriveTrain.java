/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

//import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author robot
 */
public class DriveTrain extends Subsystem {
    private final double DRIVE_SCALE = 0.7;
    private final double DEADZONE = 0.2;
    
    private Talon lf, lr, rf, rr;
    
    public DriveTrain() {
        super();
        lf = new Talon(RobotMap.left_front_jag);
        rf = new Talon(RobotMap.right_front_jag);
        lr = new Talon(RobotMap.left_rear_jag);
        rr = new Talon(RobotMap.right_rear_jag);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /*public void mecanum(double x, double y, double rot) {
        drive.mecanumDrive_Cartesian(x * DRIVE_SCALE,
                y * DRIVE_SCALE, rot, 0);
    }*/
    
    public void mecanum(double x, double y, double rot) {
        if (Math.abs(x) <= DEADZONE) x = 0.0;
        if (Math.abs(y) <= DEADZONE) y = 0.0;
        if (Math.abs(rot) <= DEADZONE) rot = 0.0;
/*
        2/1/14 TAW
        Here's what I found
       
        lf.set(y+rot-x);
        rf.set(y-rot+x);
        lr.set(y+rot+x);
        rr.set(y-rot-x);
        
        and I found documentation that suggests it should be:
        lf.set(y+rot+x);
        rf.set(y-rot-x);
        lr.set(y+rot-x);
        rr.set(y-rot+x);
        
        Also, it drives too fast, so I tried the DRIVE_SCALE idea and I changed DEADZONE from 
            .1 to .2
          */
        /*
         * 2/4/14 Sam C
         * Seems like the wheels were rewired, I've labelled the motors and wires
         */
        y=y*DRIVE_SCALE;
        x=x*DRIVE_SCALE;
        rot=rot*DRIVE_SCALE;
        
        
        lf.set(y+rot-x);
        rf.set(y-rot+x);
        lr.set(y+rot+x);
        rr.set(y-rot-x);
    }
}
