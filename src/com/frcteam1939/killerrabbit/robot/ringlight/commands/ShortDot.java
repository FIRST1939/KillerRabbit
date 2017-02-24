package com.frcteam1939.killerrabbit.robot.ringlight.commands;

import com.frcteam1939.killerrabbit.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShortDot extends Command {
	public ShortDot() {
    	requires(Robot.ringLight);
    }

    protected void initialize() {
    	Robot.ringLight.turnOn();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Robot.ringLight.turnOff();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }   

    protected void execute() {
    	
    }
    

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
