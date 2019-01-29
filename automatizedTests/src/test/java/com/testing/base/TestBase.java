package com.testing.base;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;

import com.testing.propertiesReader.PropertiesFileReader;
import com.testing.tool.ReporteTool;

public class TestBase {

	protected WebDriver driver;
	protected final String baseUrl;
	
	protected MetodosRecursivos recursivo;
	
	protected PropertiesFileReader properties;
	
	protected Screenshotter screenshotter;
	
	protected ReporteTool reporte;
	
	public TestBase() throws IOException, AWTException {
		// TODO Auto-generated constructor stub
		reporte = new ReporteTool(new Date());
		screenshotter = new Screenshotter();
		properties = new PropertiesFileReader();
		baseUrl = properties.getUrlBase();
		reporte.setCodActa(properties.getCodActa());
		reporte.setFormato(properties.getFormatoActa());
		reporte.setNroTupa(properties.getNroTupaActa());
		reporte.setVersion(properties.getVersionActa());
		reporte.setUnidOrg(properties.getUnidadOrgActa());
		reporte.setAutor(System.getProperty("autor"));
		setUp();
	}

	/**
	 * Metodo que abre la pagina web en Chrome
	 * @throws IOException
	 */
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver", "../automatizedTests/src/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		recursivo = new MetodosRecursivos(driver, reporte);
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
	}
	
	/**
	 * Método que abre la pagina web en Firefox
	 * @return
	 */
//	@Test
//	public void setUpFirefox() {
//		System.setProperty("webdriver.gecko.driver", "../automatizedTests/src/drivers/geckodriver.exe");
//		driver = new FirefoxDriver();
//		driver.get(baseUrl);
//	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public ReporteTool getReporte() {
		return reporte;
	}

	public void setReporte(ReporteTool reporte) {
		this.reporte = reporte;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public Screenshotter getScreenshotter() {
		return screenshotter;
	}

	public void setScreenshotter(Screenshotter screenshotter) {
		this.screenshotter = screenshotter;
	}
	
	protected boolean saleAlerta() {
		try {
			TargetLocator switchTo = driver.switchTo();
			Alert alert = switchTo.alert();
			String text = alert.getText();
			reporte.appendSalto();
			reporte.appendLine("Alerta:\n" + text);
			return true;
		} catch (NoAlertPresentException alEx) {
			reporte.appendSalto();
			reporte.appendLine("No aparecio ninguna alerta.");
			return false;
		}
	}
	
}
