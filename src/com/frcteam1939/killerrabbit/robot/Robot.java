
package com.frcteam1939.killerrabbit.robot;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import com.frcteam1939.killerrabbit.robot.subsystems.Drivetrain;
import com.frcteam1939.killerrabbit.robot.subsystems.Ears;
import com.frcteam1939.killerrabbit.robot.subsystems.RingLight;
import com.frcteam1939.killerrabbit.robot.subsystems.Shooter;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.MjpegServer;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode;
import edu.wpi.cscore.VideoSource;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.vision.USBCamera;


public class Robot extends IterativeRobot {
	
	public static final RingLight ringLight = new RingLight();
	public static final Ears ears = new Ears();
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Shooter shooter= new Shooter();
	public static OI oi;
	public Pipe pipe = new Pipe();
	
	@Override
	public void robotInit() {
		ringLight.turnOn();
		oi = new OI();
		new Thread(() -> {
            UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
            System.out.println("GOT CAMERA");
            camera.setResolution(320, 240);
            camera.setBrightness(10);
            CvSink cvSink = CameraServer.getInstance().getVideo();
            CvSource outputStream = CameraServer.getInstance().putVideo("Processed", 320, 240);
            Mat source = new Mat();
            while(!Thread.interrupted()) {
               
                if (!source.empty()){
                	 cvSink.grabFrame(source);
	                pipe.process(source);
	                System.out.println("Processed Image");
	                outputStream.putFrame(pipe.hsvThresholdOutput());
            	}
            }
        }).start();
	    
	}
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}


	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
