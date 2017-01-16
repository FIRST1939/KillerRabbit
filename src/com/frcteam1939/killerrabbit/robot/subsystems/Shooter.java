package com.frcteam1939.killerrabbit.robot.subsystems;

import com.frcteam1939.killerrabbit.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

	private Talon front = new Talon(RobotMap.frontShooterTalon);
	private Talon back = new Talon(RobotMap.backShooterTalon);
	private DoubleSolenoid solenoid = new DoubleSolenoid(RobotMap.PCM, RobotMap.shooterA, RobotMap.shooterB);
	private boolean spinning = false;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    
    }
    
    public void start(){
    	spinning = true;
		front.set(1);
		back.set(1);
    }
    
    public void stop(){
    	spinning = false;
		front.set(0);
		back.set(0);
    }
    
    public void push(){
		solenoid.set(Value.kForward);
    }
    
    public void retract(){
		solenoid.set(Value.kReverse);
    }
        
    public boolean areSpinning(){
    	return spinning;
    }
    
}