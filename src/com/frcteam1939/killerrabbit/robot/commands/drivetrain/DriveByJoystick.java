package com.frcteam1939.killerrabbit.robot.commands.drivetrain;

import com.frcteam1939.killerrabbit.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class DriveByJoystick extends Command {

    public DriveByJoystick() {
    	requires(Robot.drivetrain);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	Robot.drivetrain.drive(Robot.oi.left.getX(), Robot.oi.left.getY(), Robot.oi.right.getX());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
