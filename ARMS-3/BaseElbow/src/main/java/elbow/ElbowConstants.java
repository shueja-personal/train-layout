package elbow;

import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;

public class ElbowConstants {
    public static final double ELBOW_ROLL_MOTOR_DEG_PER_OUTPUT_DEG = 1; 
    public static final Port ELBOW_ROLL_MOTOR_PORT = MotorPort.D;
    public static final double ELBOW_ROLL_OUTPUT_NEG_SOFT_LIM = -180 * ELBOW_ROLL_MOTOR_DEG_PER_OUTPUT_DEG;
    public static final double ELBOW_ROLL_OUTPUT_POS_SOFT_LIM = 180 * ELBOW_ROLL_MOTOR_DEG_PER_OUTPUT_DEG;

    public static final double ELBOW_PITCH_MOTOR_DEG_PER_OUTPUT_DEG = 28.0/20.0; //T
    public static final Port ELBOW_PITCH_MOTOR_PORT = MotorPort.C;
    public static final double ELBOW_PITCH_OUTPUT_NEG_SOFT_LIM = -90 * ELBOW_PITCH_MOTOR_DEG_PER_OUTPUT_DEG;
    public static final double ELBOW_PITCH_OUTPUT_POS_SOFT_LIM = 90 * ELBOW_PITCH_MOTOR_DEG_PER_OUTPUT_DEG;
}