
package com.frcteam1939.killerrabbit.robot;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import com.frcteam1939.killerrabbit.robot.subsystems.Drivetrain;
import com.frcteam1939.killerrabbit.robot.subsystems.Ears;
import com.frcteam1939.killerrabbit.robot.subsystems.RingLight;
import com.frcteam1939.killerrabbit.robot.subsystems.Shooter;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.vision.VisionThread;


public class Robot extends IterativeRobot {
	
	public static final RingLight ringLight = new RingLight();
	public static final Ears ears = new Ears();
	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Shooter shooter= new Shooter();
	public static OI oi;
	public Pipe pipe = new Pipe();
	public final int IMG_WIDTH = 640;
	public final int IMG_HEIGHT = 480;
	public static double centerX = 0.0;
	public static double angle;
	public static double contours;
	private final Object imgLock = new Object();
	VisionThread vision;
	
	@Override
	public void robotInit() {
		ringLight.turnOn();
		oi = new OI();
		UsbCamera cam = CameraServer.getInstance().startAutomaticCapture();
		cam.setResolution(IMG_WIDTH, IMG_HEIGHT);
		cam.setBrightness(10);
		new VisionThread(cam, pipe, pipeline -> {
			contours = 0;
			angle = 0;
			centerX =0;
			if (pipeline.filterContoursOutput().size() == 2) {
	            Rect r = Imgproc.boundingRect(pipe.filterContoursOutput().get(0));
	            Rect r1 = Imgproc.boundingRect(pipe.filterContoursOutput().get(1));
	            double center = (r.x + (r.x + (r1.x +r1.width)))/2 -IMG_WIDTH/2;
	            //finding the angle
	            double constant = 8.5 / Math.abs(r.x -(r1.x + r1.width) );
				double angleToGoal = 0;
					//Looking for the 2 blocks to actually start trig
				if(pipeline.filterContoursOutput().size() == 2){

					
						// this calculates the distance from the center of goal to center of webcam 
						double distanceFromCenterPixels= (center);
						// Converts pixels to inches using the constant from above.
						double distanceFromCenterInch = distanceFromCenterPixels * constant;
						angleToGoal = Math.atan(distanceFromCenterInch / (5738/Math.abs(r.x -(r1.x + r1.width))));
						angleToGoal = Math.toDegrees(angleToGoal);
						
						// prints angle
				
						}
					
	            
	            synchronized (imgLock) {
	                centerX = center;
	                angle = angleToGoal;
	                contours = pipe.filterContoursOutput().size();
//	                System.out.println("Center X: " +centerX);
	                
	                System.out.println("Distance: " + 5738/Math.abs(r.x -(r1.x + r1.width)));
	                System.out.println("contours: " + contours);
	            }
			}
			
			 
        }).start();
		
		
		
	    
	}
	public void teleopPeriodic() {
		double centerX;
		synchronized (imgLock) {
			centerX = this.centerX;
		}
		if (2 == contours){
		drivetrain.drive(0,0 , centerX * 0.001);
		}
		
	}
	public void autoPeriodic() {
		
		
		
	}
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
