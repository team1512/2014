package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    //PWMs:
    public static final int left_front_jag = 1;
    public static final int right_front_jag = 2;
    public static final int left_rear_jag = 3;
    public static final int right_rear_jag = 4;
    public static final int shooter_jag = 5;
    
    //Relays:
    public static final int blanket_relay = 1;//eskimo-blanket ball holder/raiser
    public static final int defense_relay = 2; //lead screw to raise/lower defense arm
    public static final int catcher_relay = 3; //open/close catcher arms
    public static final int collector_relay = 4; //run collector wheels
    
    //Digital Inputs:
    public static final int blanket_Sensor_Up = 1;
    public static final int blanket_Sensor_Down = 2;
    public static final int defense_Sensor_Up = 3;
    public static final int defense_Sensor_Down = 4;
    public static final int catcher_Sensor_Up = 5;
    public static final int catcher_Sensor_Down = 6;
    public static final int shooter_Sensor_Up = 7;
    public static final int shooter_Sensor_Down = 8;
}
