package brick;

import java.util.Arrays;
import java.util.List;

import base.BaseSubsystem;
import elbow.ElbowSubsystem;
import ev3dev.sensors.Button;
import lejos.hardware.Key;
import system.ArmKeyListener;
import system.ArmSensorListener;
import system.ArmStateMachine;
import system.Subsystem;

public class RobotContainer {

    private static BaseSubsystem base = new BaseSubsystem();
    private static ElbowSubsystem elbow = new ElbowSubsystem();
    public static ArmStateMachine stateMachine = new ArmStateMachine(ArmStateMachine.ArmState.HOMED);
    public static ArmSensorListener sensorListener = new ArmSensorListener();
    private static final List<Key> BUTTONS_FOR_LISTENERS = Arrays.asList(new Key[] {
        Button.UP,
        Button.DOWN,
        Button.LEFT,
        Button.RIGHT,
        Button.ENTER
    });
    public RobotContainer(){
        robotInit();
    }
    
    public static void robotInit(){

       configureButtons();
       System.out.println("Base, Elbow Homing");
       home(base, elbow);

    }

    public static void robotPeriodic(){
        base.periodic();
        elbow.periodic();
        sensorListener.periodic();
        stateMachine.periodic();

    }

    public static void home(Subsystem... subsystems) {
        for (Subsystem subsystem : subsystems) {
            subsystem.home();
        }
    }

    public static void configureButtons(){
        BUTTONS_FOR_LISTENERS.forEach((key) -> {
            key.addKeyListener(new ArmKeyListener(key));
            System.out.println("Listener registered for "+ key.getName());
        });
    }
    public static void goTo(int[] array){
        base.goTo(array[0], array[1]);
        elbow.goTo(array[2], array[3]);
    }

	public static boolean reachedDestination() {
		return base.isFinished();
	}

}
