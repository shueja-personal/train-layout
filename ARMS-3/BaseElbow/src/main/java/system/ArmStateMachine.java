package system;

import base.BaseSubsystem;
import brick.RobotContainer;

public class ArmStateMachine {
    public static enum ArmState {
        HOMED,
        SORT,
        STORE,
        MOVING,
        MANUAL;

        public static int[] getDirArrays(ArmState state) throws IllegalArgumentException{
            int[] dirArray;
            switch (state) {
                case HOMED:
                dirArray =  new int[] {0, 0, 0, 0, 0, 0, 0};
					break;
                case SORT:
                    dirArray = new int[] {90, 45, 0, 0, 0, 0, 0};
					break;
                case STORE:
                    dirArray = new int[] {-90, -45, 0, 0, 0, 0, 0};
					break;
                default:
                    throw new IllegalArgumentException("state must be one of HOMED, SORT, STORE. Given " + state);
            }        
            return dirArray;
        }
    }
    private static ArmState currentState;
    private static ArmState targetState;
    public ArmStateMachine(ArmState initialState){
        currentState = initialState;
        targetState = initialState;
    }
    public ArmState getCurrentState(){
        return currentState;
    }

    public void periodic(){
        if(currentState != targetState && currentState != ArmState.MOVING) {
            currentState = ArmState.MOVING;
            System.out.println("Moving to " + targetState);
        }
        else if (RobotContainer.reachedDestination()) {
            currentState = targetState;
            
        }
        System.out.println(currentState);
    }

    public boolean setTargetState(ArmState state){
        if(state != ArmState.MOVING){
            targetState = state;
        }
        else {
            System.out.println("Cannot set target state to MOVING"); 
            return false;
        }    
        if(state == ArmState.MANUAL){
            //TODO Implement manual control
            return false;
        }
        else{ //look up the target angles and tell the subsystems to go to them
            try{
                System.out.println("Going to state " + state);
                int[] targetArray = ArmState.getDirArrays(state);
                RobotContainer.goTo(targetArray);
                return true;
            } catch (IllegalArgumentException e) {
                return false;
            }
            
        }

    }
}