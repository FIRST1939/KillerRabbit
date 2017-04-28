package com.frcteam1939.steamworks2017.robot.commands.vision;

import com.frcteam1939.killerrabbit.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AimBot extends Command {
	@Override
	protected void initialize() {		
	}

	@Override
	protected void execute() {
			System.out.println("Running Aim...");
			double centerX;
			synchronized (Robot.imgLock) {
				centerX = Robot.centerX;
			}
			
			Robot.drivetrain.drive(0,0 , centerX * 0.001);
			
		}
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
	protected void end() {
    }
	protected void interrupted() {
    }
}
