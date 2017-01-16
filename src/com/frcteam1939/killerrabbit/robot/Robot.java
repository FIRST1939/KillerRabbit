
package com.frcteam1939.killerrabbit.robot;

import com.frcteam1939.killerrabbit.robot.subsystems.Ears;
import com.frcteam1939.killerrabbit.robot.subsystems.Drivetrain;
import com.frcteam1939.killerrabbit.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {

	public static final Ears ears = new Ears();
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Shooter shooter= new Shooter();
	public static OI oi;

	
	@Override
	public void robotInit() {
		oi = new OI();
	}

	
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	
	@Override
	public void autonomousInit() {

	}

	
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {

	}


	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}


	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
