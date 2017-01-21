package com.frcteam1939.killerrabbit.robot.ringlight.commands;

import com.frcteam1939.killerrabbit.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnOn extends Command {

    public TurnOn() {
    	requires(Robot.ringLight);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.ringLight.turnOn();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
