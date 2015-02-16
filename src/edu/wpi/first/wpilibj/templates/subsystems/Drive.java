/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

//import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author robot
 */
public class Drive extends Subsystem {
    private final double DRIVE_SCALE = 1.0;
    private final double DEADZONE = 0.2;
    
    //rpm of the slowest wheel
    private final double RPM_BASELINE = 3025.22;
    private final double LF_RPM_SCALE = RPM_BASELINE / 3288.47;
    private final double RF_RPM_SCALE = RPM_BASELINE / 3381.72;
    private final double LB_RPM_SCALE = 1;
    private final double RB_RPM_SCALE = RPM_BASELINE / 3449.11;
    
    private Talon lf, lr, rf, rr;
    private Gyro gyro;
    
    public Drive() {
        super();
        lf = new Talon(RobotMap.left_front_jag);
        rf = new Talon(RobotMap.right_front_jag);
        lr = new Talon(RobotMap.left_rear_jag);
        rr = new Talon(RobotMap.right_rear_jag);
        gyro = new Gyro(RobotMap.gyro);
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
        
        
        lf.set((y-rot-x)*LF_RPM_SCALE);
        rf.set((y+rot+x)*RF_RPM_SCALE);
        lr.set((y-rot+x)*LB_RPM_SCALE);
        rr.set((y+rot-x)*RB_RPM_SCALE);
    }
    
    public double getGyroHeading() {
        return gyro.getAngle();
    }
    
    public void zeroGyro() {
        gyro.reset();
    }
}
