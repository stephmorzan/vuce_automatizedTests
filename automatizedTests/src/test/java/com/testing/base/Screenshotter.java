package com.testing.base;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Screenshotter {

	Robot robot;
	String filePath;
	String desktopPath;
	
	public Screenshotter() throws AWTException {
		// TODO Auto-generated constructor stub
		robot = new Robot();
		desktopPath = System.getProperty("user.home") + "/Desktop";;
		filePath = desktopPath + "/TestEvidences - "+System.currentTimeMillis();
		new File(filePath).mkdir();
	}
	
	public void tomarScreenshot() throws IOException {
		BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(screenShot, "png", new File(filePath+"/screenshot"+ System.currentTimeMillis() +".png"));
	}

	public Robot getRobot() {
		return robot;
	}

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getDesktopPath() {
		return desktopPath;
	}

	public void setDesktopPath(String desktopPath) {
		this.desktopPath = desktopPath;
	}
	
	
}
