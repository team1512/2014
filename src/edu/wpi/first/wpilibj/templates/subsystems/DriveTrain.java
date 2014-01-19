/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.Drive;

/**
 *
 * @author robot
 */
public class DriveTrain extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    private final double MOTOR_SCALE = 0.7;
    
    private Jaguar left = new Jaguar(RobotMap.leftJag);
    private Jaguar right = new Jaguar(RobotMap.rightJag);
    private RobotDrive drive = new RobotDrive(left, right);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new Drive());
    }
    
    public void tank(double leftStick, double rightStick) {
        drive.tankDrive(leftStick * MOTOR_SCALE, rightStick * MOTOR_SCALE);
    }
}
