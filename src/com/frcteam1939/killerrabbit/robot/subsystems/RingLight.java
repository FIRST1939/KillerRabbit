package com.frcteam1939.killerrabbit.robot.subsystems;

import com.frcteam1939.killerrabbit.robot.RobotMap;
import com.frcteam1939.killerrabbit.robot.ringlight.commands.TurnOff;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class RingLight extends Subsystem {

	private Relay ringLight = new Relay(RobotMap.ringLight);

    public void initDefaultCommand() {
    	setDefaultCommand(new TurnOff());
    }
    
    public void turnOn(){
    	ringLight.set(Relay.Value.kReverse);
    	//ringLight.set(Relay.Value.kOn);
    }
    
    public void turnOff(){
    	ringLight.set(Relay.Value.kForward);
    	//ringLight.set(Relay.Value.kOff);
    }
}

