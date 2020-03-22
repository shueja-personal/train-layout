package system;

import base.BaseSubsystem;

public class ArmStateMachine {
    public static enum ArmState {
        HOMED,
        SORT,
        STORE,
        MOVING,
        MANUAL
    }
    private static ArmState currentState;
    private static ArmState targetState;
    public ArmStateMachine(ArmState initialState, BaseSubsystem base){
        currentState = initialState;
    }
    public ArmState getCurrentState(){
        return currentState;
    }

    public void periodic(){
        
    }
}