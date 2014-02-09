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
public class RunBlanket extends CommandBase {
    /* The blanket class is controlled by xbox #2.
     * It uses a relay to run a motor forward and backward
     */
    
    public RunBlanket() {
        //reserve the blanket
        requires(blanket);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //the climber is initially off
        SmartDashboard.putString("Blanket: ", "OFF");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //y toggles the climber on/off
        if (oi.stick.getLTRG()) 
        {
              blanket.setForward();
                //write the state of the blanket to the Smart Dashboard
                SmartDashboard.putString("Blanket: ", "CLOCKWISE");
                //System.out.println("Climber off");
        } else if (oi.stick.getRTRG())
        {
              blanket.setBackward();
                //write the state of the blanket to the Smart Dashboard
                SmartDashboard.putString("Blanket: ", "CCLOCKWISE");
                //System.out.println("Climber on");                                   
        }
        else
        {
            blanket.turnOff();
            SmartDashboard.putString("Blanket: ", "OFF");
        }
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        // blanket.turnOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        //blanket.turnOff();
    }
}
