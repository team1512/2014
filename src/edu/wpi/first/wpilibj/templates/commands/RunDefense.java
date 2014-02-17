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
public class RunDefense extends CommandBase {
    /* The defense class is controlled by xbox #2.
     * It uses a relay to run a motor forward and backward
     */
    
    public RunDefense() {
        //reserve the defensive system
        requires(defense);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //the climber is initially off
        SmartDashboard.putString("Defense: ", "OFF");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //y toggles the climber on/off
        if (oi.xbox2.isButtonPressed(Team1512Joystick.XBOX_BUTTON_Y) /*&& defense.getLimTop() == false */)
        //if (oi.stick.getLTRG()) 
        {
              defense.setForward();
              
                //write the state of the blanket to the Smart Dashboard
                SmartDashboard.putString("Defense: ", "CLOCKWISE");
                //System.out.println("Climber off");
        } else if (oi.xbox2.isButtonPressed(Team1512Joystick.XBOX_BUTTON_A) /* && defense.getLimBot() == false */)
        {
              defense.setBackward();
                //write the state of the blanket to the Smart Dashboard
                SmartDashboard.putString("Defense: ", "CCLOCKWISE");
                //System.out.println("Climber on");                                   
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
