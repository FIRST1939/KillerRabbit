package com.frcteam1939.killerrabbit.robot;

import com.frcteam1939.killerrabbit.robot.commands.ears.EarsDown;
import com.frcteam1939.killerrabbit.robot.commands.ears.EarsUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {

	public final Joystick left = new Joystick(0);
	public final Joystick right = new Joystick(1);
	
	{
		JoystickButton up = new JoystickButton(Robot.oi.left, 11);
		up.whenPressed(new EarsUp());
		JoystickButton down = new JoystickButton(Robot.oi.left, 10);
		down.whenPressed(new EarsDown());
	}

}
