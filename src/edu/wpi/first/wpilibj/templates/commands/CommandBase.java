package edu.wpi.first.wpilibj.templates.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.subsystems.*;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    static Drive drive = new Drive();
    static Blanket blanket = new Blanket();
    static Defense defense = new Defense();
    static Catcher catcher = new Catcher();
    static Shooter shooter = new Shooter();
    static Collector collector = new Collector();
    
    public static void init() {
        /**
         * This MUST be here. If the OI creates Commands (which it very likely
         * will), constructing it during the construction of CommandBase (from
         * which commands extend), subsystems are not guaranteed to be
         * yet. Thus, their requires() statements may grab null pointers. Bad
         * news. Don't move it.
         */
        oi = new OI();
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
