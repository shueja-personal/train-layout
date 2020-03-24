package system;

import java.util.Arrays;
import java.util.List;

import brick.RobotContainer;
import ev3dev.sensors.Button;
import lejos.hardware.Key;
import lejos.hardware.KeyListener;
import system.ArmStateMachine.ArmState;

public class ArmKeyListener implements KeyListener{


        public ArmKeyListener(final Key registeredForKey) {
            
        }

        @Override
        public void keyPressed(final Key key) {
            switch(key.getId()) {
                case Key.ENTER:
                    RobotContainer.stateMachine.setTargetState(ArmState.HOMED);
                    System.out.println("Enter pressed");
                    break;
                case Key.LEFT:
                    RobotContainer.stateMachine.setTargetState(ArmState.SORT);
                    System.out.println("Left pressed");
                    break;
            }
        }
        @Override
        public void keyReleased(final Key key) {
            
        }
}    