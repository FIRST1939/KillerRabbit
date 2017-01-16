package com.frcteam1939.killerrabbit.robot.subsystems;

import com.frcteam1939.killerrabbit.robot.RobotMap;
import com.frcteam1939.killerrabbit.robot.commands.drivetrain.DriveByJoystick;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {

	private Talon frontLeft = new Talon(RobotMap.frontLeftTalon);
	private Talon backLeft = new Talon(RobotMap.backLeftTalon);
	private Talon frontRight = new Talon(RobotMap.frontRightTalon);
	private Talon backRight = new Talon(RobotMap.backRightTalon);
	
	private RobotDrive drive = new RobotDrive(frontLeft, backLeft, frontRight, backRight);

	public Drivetrain() {
		drive.setInvertedMotor(MotorType.kFrontRight, true);
		drive.setInvertedMotor(MotorType.kRearRight, true);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new DriveByJoystick());
    }
    
    public void drive(double x, double y, double z){
    	drive.mecanumDrive_Cartesian(x, y, z, 0);
    }
}

