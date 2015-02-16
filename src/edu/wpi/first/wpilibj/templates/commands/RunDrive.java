package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.Team1512Joystick;

public class RunDrive extends CommandBase {
    //Uses controller 1
    
    public RunDrive() {
        //reserve the drive
        requires(drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        SmartDashboard.putString("Driver: ", "OFF");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drive.mecanum(oi.xbox1.getXL(), oi.xbox1.getYL(), oi.xbox1.getXR());
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
