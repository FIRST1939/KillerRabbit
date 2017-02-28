package com.frcteam1939.killerrabbit.robot.commands.ears;

import com.frcteam1939.killerrabbit.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class EarsDown extends Command {

    public EarsDown() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (Robot.ears);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.ears.putDown();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
