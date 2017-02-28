package com.frcteam1939.steamworks2017.robot.commands.vision;

import com.frcteam1939.killerrabbit.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SendCenter extends Command {
	@Override
	protected void initialize() {
		
		SmartDashboard.putNumber("SendCenter", Robot.centerX);
		
	}

	@Override
	protected void execute() {
		SmartDashboard.putNumber("Send Center	", Robot.centerX);
		
	}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
