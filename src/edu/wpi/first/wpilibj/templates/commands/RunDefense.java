package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.Team1512Joystick;

public class RunDefense extends CommandBase {
    //Uses controller 2
    
    public RunDefense() {
        //reserve the defensive
        requires(defense);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        SmartDashboard.putString("Defense: ", "OFF");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //y toggles the climber on/off
        if (oi.xbox1.isButtonPressed(Team1512Joystick.XBOX_BUTTON_Y))
        {
              defense.setForward();
              
                //write the state of the blanket to the Smart Dashboard
                SmartDashboard.putString("Defense: ", "CLOCKWISE");
        } else if (oi.xbox1.isButtonPressed(Team1512Joystick.XBOX_BUTTON_A) && defense.getLimBot() == false )
        {
              defense.setBackward();
                //write the state of the blanket to the Smart Dashboard
                SmartDashboard.putString("Defense: ", "CCLOCKWISE");
        }
        else
        {
            defense.turnOff();
            SmartDashboard.putString("Defense: ", "OFF");
        }
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        defense.turnOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        defense.turnOff();
    }
}
