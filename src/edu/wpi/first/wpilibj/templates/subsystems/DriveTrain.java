/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author robot
 */
public class DriveTrain extends Subsystem {
    private final double DRIVE_SCALE = 0.7;
    private final double DEADZONE = 0.1;
    
    private Jaguar lf, lr, rf, rr;
    private RobotDrive drive;
    
    public DriveTrain() {
        super();
        lf = new Jaguar(RobotMap.left_front_jag);
        rf = new Jaguar(RobotMap.right_front_jag);
        lr = new Jaguar(RobotMap.left_rear_jag);
        rr = new Jaguar(RobotMap.right_rear_jag);
        //drive = new RobotDrive(lf, rf, lr, rr);
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
        lf.set(y+rot-x);
        rf.set(y-rot+x);
        lr.set(y+rot+x);
        rr.set(y-rot-x);
    }
}
