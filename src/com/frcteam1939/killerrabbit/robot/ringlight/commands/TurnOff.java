package com.frcteam1939.killerrabbit.robot.ringlight.commands;

import com.frcteam1939.killerrabbit.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnOff extends Command {

    public TurnOff() {
    	requires(Robot.ringLight);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.ringLight.turnOff();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
