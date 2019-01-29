package com.testing.testflow;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testing.base.TestBase;

public class TFLogin extends TestBase{

	String ruc;
	String user;

	public TFLogin() throws IOException, AWTException {
		super();
		// TODO Auto-generated constructor stub
		this.ruc = properties.getLoginRuc();
		this.user = properties.getLoginUser();
	}


	public boolean login() throws IOException, AWTException {
		reporte.appendLine("Estamos en la pagina de login.");
		WebElement campRuc = driver.findElement(By.id("ruc"));
		campRuc.clear();
		campRuc.sendKeys(ruc);

		reporte.appendSalto();
		reporte.append(campRuc);

		WebElement campUser = driver.findElement(By.id("usuario"));
		campUser.clear();
		campUser.sendKeys(user);

		reporte.appendSalto();
		reporte.append(campUser);

//		File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(srcFile, new File("C:/Users/User41/Desktop/screenshot.png"));
		screenshotter.tomarScreenshot();
		driver.findElement(By.id("submit_btn_id")).click();

		reporte.appendSalto();
		reporte.appendLine("Se ha dado click al botón de inicio de sesion.");
		reporte.appendSalto();

		//WebDriverWait wait = new WebDriverWait(driver, 2, 2);

		try {
			/*WebElement nombNuevoUsuario = driver.findElement(By.id("USUARIO.nombre"));*/
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("USUARIO.nombre")));
			reporte.appendLine("Se ha logrado login.");
			reporte.appendSalto();
//			System.out.println("Se reporta error login");
			return false;
		}catch(Exception e) {
//			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("idOpcionesMenu")));
			reporte.appendLine("Se reporta error login.");
			reporte.appendSalto();
//			System.out.println("Se ha logrado login");
			return true;
		}

		//		if(driver.findElements(By.partialLinkText("bienvenido al sistema")).size() >= 0) {
		//			reporte.appendLine("Se reporta error login");
		//			System.out.println("Se reporta error login");
		//			return false;
		//		}else {
		//			reporte.appendLine("Se ha logrado login");
		//			System.out.println("Se ha logrado login");
		//			return true;
		//		}
	}
}
