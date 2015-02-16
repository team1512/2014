package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.Team1512Joystick;

public class RunBlanket extends CommandBase {
    //Uses controller 2

    public RunBlanket() {
        //reserve the blanket
        requires(blanket);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        SmartDashboard.putString("Blanket: ", "OFF");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

        if (oi.xbox2.getRawButton(Team1512Joystick.XBOX_BUTTON_A)) {
            blanket.setForward();
            //write the state of the blanket to the Smart Dashboard
            SmartDashboard.putString("Blanket: ", "CLOCKWISE");
            //System.out.println("Climber off");
        } else if (oi.xbox2.getRawButton(Team1512Joystick.XBOX_BUTTON_Y)) {
            blanket.setBackward();
            //write the state of the blanket to the Smart Dashboard
            SmartDashboard.putString("Blanket: ", "CCLOCKWISE");
            //System.out.println("Climber on");                                   
        } else {
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
        blanket.turnOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        blanket.turnOff();
    }
}
