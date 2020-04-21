package elbow;

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.actuators.lego.motors.EV3MediumRegulatedMotor;
import system.Subsystem;
import util.MathUtil;


public class ElbowSubsystem implements Subsystem {
    private static final EV3MediumRegulatedMotor ELBOW_ROLL_MEDIUM_MOTOR = new EV3MediumRegulatedMotor(
            ElbowConstants.ELBOW_ROLL_MOTOR_PORT);
    private static final EV3LargeRegulatedMotor ELBOW_PITCH_LARGE_MOTOR = new EV3LargeRegulatedMotor(
            ElbowConstants.ELBOW_PITCH_MOTOR_PORT);

    public ElbowSubsystem() {
        ELBOW_ROLL_MEDIUM_MOTOR.brake();
        ELBOW_ROLL_MEDIUM_MOTOR.setSpeed(1000);
        ELBOW_PITCH_LARGE_MOTOR.brake();
        ELBOW_PITCH_LARGE_MOTOR.setSpeed(1000);
    }
    public void goTo(int pitchOutput, int rollOutput) {
            rollOutput = ((rollOutput + 180) % 360) - 180;
            int rollTargetAngle = (int) (rollOutput * ElbowConstants.ELBOW_ROLL_MOTOR_DEG_PER_OUTPUT_DEG);
            double pitchTargetAngle = (pitchOutput * ElbowConstants.ELBOW_PITCH_MOTOR_DEG_PER_OUTPUT_DEG);
            pitchTargetAngle = (int) MathUtil.clamp(pitchTargetAngle, ElbowConstants.ELBOW_PITCH_OUTPUT_NEG_SOFT_LIM,
                    ElbowConstants.ELBOW_PITCH_OUTPUT_POS_SOFT_LIM);
            
            System.out.println("Elbow Roll going to " + rollTargetAngle + " Pitch going to " + pitchTargetAngle);
            ELBOW_ROLL_MEDIUM_MOTOR.setSpeed(500);
            ELBOW_ROLL_MEDIUM_MOTOR.setAcceleration(50);
            ELBOW_PITCH_LARGE_MOTOR.setSpeed(500);
            ELBOW_PITCH_LARGE_MOTOR.setAcceleration(50);
            ELBOW_PITCH_LARGE_MOTOR.hold();
            ELBOW_ROLL_MEDIUM_MOTOR.hold();
            ELBOW_ROLL_MEDIUM_MOTOR.rotateTo(rollTargetAngle, true);
            ELBOW_PITCH_LARGE_MOTOR.rotateTo((int) pitchTargetAngle, true);
    }

    @Override
    public void periodic(){
    }

    public void home(){
        ELBOW_PITCH_LARGE_MOTOR.resetTachoCount();
        ELBOW_ROLL_MEDIUM_MOTOR.resetTachoCount();
    }

    public boolean isFinished(){
        return !ELBOW_ROLL_MEDIUM_MOTOR.isMoving();// && !ELBOW_PITCH_LARGE_MOTOR.isMoving(); 
    }




}
