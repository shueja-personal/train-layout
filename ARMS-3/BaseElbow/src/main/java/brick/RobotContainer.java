package brick;

import java.util.Arrays;
import java.util.List;

import base.BaseSubsystem;
import ev3dev.sensors.Button;
import lejos.hardware.Key;
import system.ArmKeyListener;
import system.ArmSensorListener;
import system.ArmStateMachine;
import system.Subsystem;
import system.ArmStateMachine.ArmState;

public class RobotContainer {

    private static BaseSubsystem base = new BaseSubsystem();
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
       System.out.println("Base Homing");
       home(base);

    }

    public static void robotPeriodic(){
        base.periodic();
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
    }

	public static boolean reachedDestination() {
		return base.isFinished();
	}

}