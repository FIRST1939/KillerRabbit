package com.frcteam1939.killerrabbit.robot.subsystems;

import com.frcteam1939.killerrabbit.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RingLight extends Subsystem {

	private Relay ringLight = new Relay(RobotMap.ringLight);

    public void initDefaultCommand() {
    	
    }
    
    public void turnOn(){
    	ringLight.set(Relay.Value.kOn);
    }
    
    public void turnOff(){
    	ringLight.set(Relay.Value.kOff);
    }
}

