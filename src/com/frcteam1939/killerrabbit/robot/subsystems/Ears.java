package com.frcteam1939.killerrabbit.robot.subsystems;

import com.frcteam1939.killerrabbit.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Ears extends Subsystem {
	
	private DoubleSolenoid left = new DoubleSolenoid(RobotMap.PCM, RobotMap.leftEarA, RobotMap.leftEarB);
	private DoubleSolenoid right = new DoubleSolenoid(RobotMap.PCM, RobotMap.rightEarA, RobotMap.rightEarB);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
    public void initDefaultCommand() {
    	
    }
    
    public void putUp(){
    	left.set(Value.kForward);
    	right.set(Value.kForward);
    }
    
    public void putDown(){
    	left.set(Value.kReverse);
    	right.set(Value.kReverse);
    }
    
}

