package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.Team1512Joystick;

public class RunShooter extends CommandBase {
    //Uses controller 2
    
    public RunShooter() {
        //reserve the blanket
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        SmartDashboard.putString("Shooter: ", "OFF");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        shooter.active(oi.xbox2.getYL());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
         blanket.turnOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        blanket.turnOff();
    }
}
