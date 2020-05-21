package main.java.base;

import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;

public class BaseConstants{
    public static final double BASE_YAW_MOTOR_DEG_PER_OUTPUT_DEG = 24.0/8.0 * 12.0/20.0;
    public static final Port BASE_YAW_MOTOR_PORT = MotorPort.A;
    public static final double BASE_YAW_OUTPUT_NEG_SOFT_LIM = -180 * BASE_YAW_MOTOR_DEG_PER_OUTPUT_DEG;
    public static final double BASE_YAW_OUTPUT_POS_SOFT_LIM = 180 * BASE_YAW_MOTOR_DEG_PER_OUTPUT_DEG;

    public static final double BASE_PITCH_MOTOR_DEG_PER_OUTPUT_DEG = 56.0/12.0;
    public static final Port BASE_PITCH_MOTOR_PORT = MotorPort.B;
    public static final double BASE_PITCH_OUTPUT_NEG_SOFT_LIM = -10 * BASE_PITCH_MOTOR_DEG_PER_OUTPUT_DEG;
    public static final double BASE_PITCH_OUTPUT_POS_SOFT_LIM = 90 * BASE_PITCH_MOTOR_DEG_PER_OUTPUT_DEG;

}