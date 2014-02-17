/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.Team1512Joystick;
import java.util.Timer;

/**
 *
 * @author robot
 */
public class RunCatcher extends CommandBase {
    /* The catcher class is controlled by xbox #2.
     * It uses a relay to run a motor forward and backward
     */

    /*//maximum number of seconds the relay is allowed to run
    private static final double TIMEOUT = 5.0;
    //system time the relay started running
    private double relayStartTime;
    //time the relay has to run in the given direction
    private double timeLeft;
    //flags to make relay state persistent
    private boolean relayRunning;
    private boolean relayFwdTimedOut;
    private boolean relayBwdTimedOut;*/

    public RunCatcher() {
        //reserve the catcher system
        requires(catcher);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        //the climber is initially off
        SmartDashboard.putString("Catcher: ", "OFF");
        /*relayRunning = false;
        relayFwdTimedOut = false;
        relayBwdTimedOut = false;
        timeLeft = TIMEOUT;*/
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        SmartDashboard.putBoolean("LimSwitch", catcher.getLimTop());

      //  oi.xbox2.whileButtonPressed(Team1512Joystick.XBOX_BUTTON_X)
        
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
