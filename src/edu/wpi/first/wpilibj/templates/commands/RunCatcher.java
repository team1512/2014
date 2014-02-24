package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.Team1512Joystick;

public class RunCatcher extends CommandBase {
    //Uses controller 2
    
    public RunCatcher() {
        //reserve the catcher
        requires(catcher);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        SmartDashboard.putString("Catcher: ", "OFF");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        SmartDashboard.putBoolean("LimSwitch", catcher.getLimTop());
        
        if (oi.xbox2.getRawButton(Team1512Joystick.XBOX_BUTTON_X) && !catcher.getLimTop()) {
            catcher.setBackward();
            SmartDashboard.putString("Catcher: ", "FWD (Clockwise)");
        } else if (oi.xbox2.getRawButton(Team1512Joystick.XBOX_BUTTON_B) && !catcher.getLimBot()) {
            catcher.setForward();
            SmartDashboard.putString("Catcher: ", "BWD (CClockwise)");
        } else {
            catcher.turnOff();
            SmartDashboard.putString("Catcher: ", "OFF");
        }

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        catcher.turnOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        catcher.turnOff();
    }
}
