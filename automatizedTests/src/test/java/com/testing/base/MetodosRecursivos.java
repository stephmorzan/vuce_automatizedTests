package com.testing.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;
import com.testing.tool.ReporteTool;

public class MetodosRecursivos {

	WebDriver driver;
	Faker faker;
	ReporteTool reporte;
	
	public MetodosRecursivos() {
		// TODO Auto-generated constructor stub
	}
	
	
	public MetodosRecursivos(WebDriver driver, ReporteTool reporte) {
		super();
		this.driver = driver;
		this.reporte = reporte;
	}

	public void llenarTextboxConUnaPalabra(String id) {
		WebElement webElement;
		webElement = driver.findElement(By.id(id));
		webElement.sendKeys(faker.lorem().word());
		reporte.append(webElement);
	}

	public void llenarTextboxConNumero(String id) {
		WebElement webElement;
		webElement = driver.findElement(By.id(id));
		webElement.sendKeys(faker.number().randomDigitNotZero()+"");
		reporte.append(webElement);
	}

	public void llenarTextboxConNumerosEnRango(String id, int max) {
		WebElement webElement;
		webElement = driver.findElement(By.id(id));
		webElement.sendKeys(faker.number().numberBetween(1, max)+"");
		reporte.append(webElement);
	}
	
	public void llenarCorreoElectronico(String id) {
		WebElement webElement;
		webElement = driver.findElement(By.id(id));
		webElement.sendKeys(faker.internet().emailAddress());
		reporte.append(webElement);
	}
	
	public void llenarTelefono(String id) {
		WebElement webElement;
		webElement = driver.findElement(By.id(id));
		webElement.sendKeys(faker.phoneNumber().phoneNumber());
		reporte.append(webElement);
	}
	
	public void marcarPrimeraOpcionSelect(String id) {
		WebElement webElement;
		Select select;
		driver.manage().timeouts().implicitlyWait(900000000,TimeUnit.SECONDS);
		webElement = driver.findElement(By.id(id));
		select = new Select(webElement);
		select.selectByIndex(1);
		reporte.appendText(webElement);
	}
	
	public void marcarUnaOpcionSelect(String id, int index) {
		WebElement webElement;
		Select select;
		driver.manage().timeouts().implicitlyWait(900000000,TimeUnit.SECONDS);
		webElement = driver.findElement(By.id(id));
		select = new Select(webElement);
		select.selectByIndex(index);
		reporte.appendText(webElement);
	}
	
	public void marcarOpcionSegunTextoSelect(String id, String opcion) {
		WebElement webElement;
		Select select;
		driver.manage().timeouts().implicitlyWait(900000000,TimeUnit.SECONDS);
		webElement = driver.findElement(By.id(id));
		select = new Select(webElement);
		select.selectByVisibleText(opcion);
		reporte.appendText(webElement);
	}
	
	public void abrirBuscadorYCambiarAPopup(String id) {
		WebElement buscador = driver.findElement(By.id(id));
		buscador.click();
		reporte.appendLine("Sistema está pasando a Ventana Emergente.");
		WebElement iframe = driver.findElement(By.cssSelector("#popupFrame"));
		driver.switchTo().frame(iframe);
	}

	public void abrirEnlaceYCambiarAPopup(WebElement a) {
		a.click();
		reporte.appendLine("Sistema está pasando a Ventana Emergente.");
		WebElement iframe = driver.findElement(By.cssSelector("#popupFrame"));
		driver.switchTo().frame(iframe);
	}
	

	public WebDriver getDriver() {
		return driver;
	}


	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}


	public Faker getFaker() {
		return faker;
	}


	public void setFaker(Faker faker) {
		this.faker = faker;
	}
	
	
}
