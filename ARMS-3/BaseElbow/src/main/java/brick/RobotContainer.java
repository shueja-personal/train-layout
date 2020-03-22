package brick;

import base.BaseSubsystem;
import system.ArmStateMachine;

public class RobotContainer {

    private static BaseSubsystem base;
    private static ArmStateMachine stateMachine;
    public static void robotInit(){
       base = new BaseSubsystem();
       stateMachine = new ArmStateMachine(ArmStateMachine.ArmState.HOMED, base);
       System.out.println("Base Homing");
       home(base);
       System.out.println("Going to 90, 90");
       base.goTo(90, 90);
    }

    public static void robotPeriodic(){
        base.periodic();
        stateMachine.periodic();

    }

    public static void home(BaseSubsystem base) {
        base.home();
    }

}