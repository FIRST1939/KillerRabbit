
package com.frcteam1939.killerrabbit.robot;

import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

import com.frcteam1939.killerrabbit.robot.subsystems.Drivetrain;
import com.frcteam1939.killerrabbit.robot.subsystems.Ears;
import com.frcteam1939.killerrabbit.robot.subsystems.RingLight;
import com.frcteam1939.killerrabbit.robot.subsystems.Shooter;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.vision.CameraServer;
import edu.wpi.first.wpilibj.vision.VisionThread;


public class Robot extends IterativeRobot {
	
	public static final RingLight ringLight = new RingLight();
	public static final Ears ears = new Ears();
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Shooter shooter= new Shooter();
	public static OI oi;
	private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;
	
	private VisionThread visionThread;
	private double centerX = 0.0;
	private Mat mat;
	private final Object imgLock = new Object();
	private GRIPipe GP = new GRIPipe();
	


	
	@Override
	public void robotInit() {
		UsbCamera camera = new UsbCamera("cam1", 0);
		CameraServer.getInstance().startAutomaticCapture("cam1");
	    mat = new Mat();
	    
	    visionThread = new VisionThread(camera, new GRIPipe(), pipeline -> {
	    GP.process(mat);
	    });
	    visionThread.start();
		CameraServer.getInstance().startAutomaticCapture();
		
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
