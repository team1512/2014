package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.DriverStation;

public class Auto extends CommandBase {
    DriverStation ds;
    //points
    
    public Auto() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        ds = DriverStation.getInstance();
        //init network table
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //grab latest points from NetworkTable
        //if points is not empty initially, score
        //else wait 6 seconds, then score
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !ds.isAutonomous();
    }

    // Called once after isFinished returns true
    protected void end() {
        ds.release();

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
