package com.frcteam1939.killerrabbit.robot;

import com.frcteam1939.killerrabbit.robot.commands.shooter.PushFrisbee;
import com.frcteam1939.killerrabbit.robot.commands.shooter.RetractFrisbee;
import com.frcteam1939.killerrabbit.robot.commands.shooter.Shoot;
import com.frcteam1939.killerrabbit.robot.commands.shooter.StartWheels;
import com.frcteam1939.killerrabbit.robot.commands.shooter.StopWheels;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

	public final Joystick left = new Joystick(0);
	public final Joystick right = new Joystick(1);

	{
		JoystickButton shoot = new JoystickButton(left, 1);
		shoot.whenPressed(new Shoot());
		
		JoystickButton push = new JoystickButton(left, 3);
		push.whenPressed(new PushFrisbee());
		
		JoystickButton retract = new JoystickButton(left, 2);
		retract.whenPressed(new RetractFrisbee());
		
		JoystickButton startWheels = new JoystickButton(left, 4);
		startWheels.whenPressed(new StartWheels());
		
		JoystickButton stopWheels = new JoystickButton(left, 5);
		stopWheels.whenPressed(new StopWheels());
		

	}
	
}
