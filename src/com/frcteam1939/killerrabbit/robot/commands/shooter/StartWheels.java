package com.frcteam1939.killerrabbit.robot.commands.shooter;

import com.frcteam1939.killerrabbit.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StartWheels extends Command {

    public StartWheels() {
        requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(Robot.shooter.areSpinning()){
    		this.setTimeout(0);
    	}else{
    		this.setTimeout(.25);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.start();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
