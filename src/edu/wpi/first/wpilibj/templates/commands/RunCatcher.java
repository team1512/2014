/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.Team1512Joystick;

/**
 *
 * @author robot
 */
public class RunCatcher extends CommandBase {
    /* The catcher class is controlled by xbox #2.
     * It uses a relay to run a motor forward and backward
     */
    
    public RunCatcher() {
        //reserve the catcher system
        requires(catcher);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //the climber is initially off
        SmartDashboard.putString("Catcher: ", "OFF");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //y toggles the climber on/off
        if (oi.xbox2.isButtonPressed(Team1512Joystick.XBOX_BUTTON_X) /* && catcher.getLimTop() == false */)
         {
              catcher.setForward();
                //write the state of the blanket to the Smart Dashboard
                SmartDashboard.putString("Catcher: ", "CLOCKWISE");
                //System.out.println("Climber off");
        } else if (oi.xbox2.isButtonPressed(Team1512Joystick.XBOX_BUTTON_B) /* && catcher.getLimBot() == false */ ) 
        {
              catcher.setBackward();
                //write the state of the blanket to the Smart Dashboard
                SmartDashboard.putString("Catcher: ", "CCLOCKWISE");
                //System.out.println("Climber on");                                   
        }
        else
        {
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
