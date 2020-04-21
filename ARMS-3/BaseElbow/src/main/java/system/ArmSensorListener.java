package system;

import brick.RobotContainer;
import ev3dev.sensors.ev3.EV3TouchSensor;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.SensorMode;
import system.ArmStateMachine.ArmState;

public class ArmSensorListener{
    public EV3TouchSensor touchSensorToggleMode = new EV3TouchSensor(SensorPort.S1);
    public SensorMode touchSensorToggleModeSampleProvider = touchSensorToggleMode.getTouchMode();
    public boolean touchSensorToggleModeLastValue = touchSensorToggleMode.isPressed();

    public void periodic(){
        if(touchSensorToggleMode.isPressed() && touchSensorToggleModeLastValue == false){
            switch (RobotContainer.stateMachine.getCurrentState()){
                case HOMED:
                    RobotContainer.stateMachine.setTargetState(ArmState.SORT);
					break;
                case SORT:
                    RobotContainer.stateMachine.setTargetState(ArmState.STORE);
					break;
                case STORE:
                    RobotContainer.stateMachine.setTargetState(ArmState.HOMED);
					break;
				default:
					break;

            }
            
        }
        touchSensorToggleModeLastValue = touchSensorToggleMode.isPressed();
    }
}