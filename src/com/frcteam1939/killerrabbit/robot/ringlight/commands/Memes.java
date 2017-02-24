package com.frcteam1939.killerrabbit.robot.ringlight.commands;


import com.frcteam1939.killerrabbit.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Memes extends Command {
	public Memes() {
    	requires(Robot.ringLight);
    }

    protected void initialize() {
    }

    protected void execute() {
    	while (true){
    		new ShortDot();
    		new LongDot();
    		new ShortDot();
    		new ShortDot();
    		new LongDot();
    		new ShortDot();
    		new LongDot();
    		new LongDot();
    		new ShortDot();
    		new LongDot();
    		new ShortDot();
    		
    		
    		    	}
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
