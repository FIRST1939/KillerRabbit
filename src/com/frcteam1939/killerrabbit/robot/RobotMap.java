package com.frcteam1939.killerrabbit.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// PWM
	public static final int frontLeftTalon = 0;
	public static final int backLeftTalon = 1;
	public static final int frontRightTalon = 2;
	public static final int backRightTalon = 3;
	public static final int frontShooterTalon = 4;
	public static final int backShooterTalon = 5;

	// PCM
	public static final int PCM = 0;
	public static final int leftEarA = 4;
	public static final int leftEarB = 5;
	public static final int rightEarA = 0;
	public static final int rightEarB = 1;
	public static final int shooterA = 6;
	public static final int shooterB = 7;

}
