package main.java.base;

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import system.Subsystem;
import util.MathUtil;


public class BaseSubsystem implements Subsystem{
    private static final EV3LargeRegulatedMotor BASE_YAW_LARGE_MOTOR = new EV3LargeRegulatedMotor(BaseConstants.BASE_YAW_MOTOR_PORT);
    private static final EV3LargeRegulatedMotor BASE_PITCH_LARGE_MOTOR = new EV3LargeRegulatedMotor(BaseConstants.BASE_PITCH_MOTOR_PORT);

    public BaseSubsystem(){
        BASE_YAW_LARGE_MOTOR.brake();
        BASE_YAW_LARGE_MOTOR.setSpeed(1000);
        BASE_PITCH_LARGE_MOTOR.brake();
        BASE_PITCH_LARGE_MOTOR.setSpeed(1000);
    }
    public void goTo(int yawOutput, int pitchOutput) {
            yawOutput = ((yawOutput + 180) % 360) - 180;
            int yawTargetAngle = (int) (yawOutput * BaseConstants.BASE_YAW_MOTOR_DEG_PER_OUTPUT_DEG);
            int pitchTargetAngle = (int) (pitchOutput * BaseConstants.BASE_PITCH_MOTOR_DEG_PER_OUTPUT_DEG);
            pitchTargetAngle = (int) MathUtil.clamp(pitchTargetAngle, BaseConstants.BASE_PITCH_OUTPUT_NEG_SOFT_LIM,
                    BaseConstants.BASE_PITCH_OUTPUT_POS_SOFT_LIM);
            
            System.out.println("Base Yaw going to " + yawTargetAngle + " Base Pitch going to " + pitchTargetAngle);
            BASE_YAW_LARGE_MOTOR.setSpeed(500);
            BASE_YAW_LARGE_MOTOR.setAcceleration(50);
            BASE_PITCH_LARGE_MOTOR.setSpeed(500);
            BASE_PITCH_LARGE_MOTOR.setAcceleration(50);
            BASE_PITCH_LARGE_MOTOR.hold();
            BASE_YAW_LARGE_MOTOR.hold();
            BASE_YAW_LARGE_MOTOR.rotateTo(yawTargetAngle, true);
            BASE_PITCH_LARGE_MOTOR.rotateTo(pitchTargetAngle, true);
    }

    @Override
    public void periodic(){
    }

    public void home(){
        BASE_PITCH_LARGE_MOTOR.resetTachoCount();
        BASE_YAW_LARGE_MOTOR.resetTachoCount();
    }

    public boolean isFinished(){
        return !BASE_YAW_LARGE_MOTOR.isMoving();// && !BASE_PITCH_LARGE_MOTOR.isMoving(); 
    }




}
