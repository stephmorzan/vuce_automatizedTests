package com.testing.testflow;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testing.tool.cte.ByCte;

public class TFPestanhaFabricante extends TFPestanhaTercera{

	public TFPestanhaFabricante() throws IOException, AWTException {
		super();
		// TODO Auto-generated constructor stub
		guardarDatosTercera();
		this.seleccionarFabricantePestanha();
	}

	protected void seleccionarFabricantePestanha() {
		String textFabricantePestanha = pestanhas.get(3);
		WebElement pestanhaFabricante = driver.findElement(By.linkText(textFabricantePestanha));
		pestanhaFabricante.click();
	}
	
	public void ingresarDatosPestanhaFabricante() {
		switch(tupa) {
		case 72:
			recursivo.marcarOpcionSegunTextoSelect("DETALLE.origenFabricante", "NACIONAL");
			recursivo.abrirBuscadorYCambiarAPopup("buscarFabricanteButton");
			WebElement popup_inputDescripcion = driver.findElement(By.id("descripcion"));
			popup_inputDescripcion.sendKeys("d");
			
			start = System.currentTimeMillis();
			reporte.appendSalto();
			reporte.appendLine("Tiempo inicio carga tabla popup = " + start);
			reporte.appendSalto();
			driver.findElement(By.id("buscarButton")).click();
			
			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
			
			end = System.currentTimeMillis();
			reporte.appendLine("Tiempo fin de carga tabla popup = " + end);
			reporte.appendSalto();
			reporte.appendLine("Tiempo total de carga tabla popup = " + (end-start));
			
			WebElement tbody = driver.findElement(By.id("table_FABRICANTE")).findElement(By.tagName(ByCte.BY_TAG_TBODY));
			List<WebElement> codsFabricante = tbody.findElements(By.tagName(ByCte.BY_TAG_A));
//			System.out.println(nombsFormFarmac.size());
			codsFabricante.get(0).click();
			driver.switchTo().parentFrame();
			
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
			recursivo.marcarOpcionSegunTextoSelect("DETALLE.esAcondicionadora", "No");
			recursivo.marcarOpcionSegunTextoSelect("DETALLE.esFabricacionEncargo", "No");
			break;
		case 73:
			recursivo.marcarPrimeraOpcionSelect("DETALLE.paisEncargaFabricacion");
			break;
		}
	}
	
	public boolean guardarDatosFabricante() throws IOException {
		ingresarDatosPestanhaFabricante();
		screenshotter.tomarScreenshot();
		driver.manage().timeouts().implicitlyWait(20000,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20000,TimeUnit.SECONDS);
		WebElement butGuardarDatosFabricante = null;
		switch(tupa) {
		case 72:
			butGuardarDatosFabricante = driver.findElement(By.cssSelector("input[value*=\"Guardar Fabricante\"]"));
			break;
		case 73:
			butGuardarDatosFabricante = driver.findElement(By.id("grabarFabricanteButton"));
			break;
		}
		driver.manage().timeouts().implicitlyWait(20000,TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(20000,TimeUnit.SECONDS);
		butGuardarDatosFabricante.click();
		if(!saleAlerta()) {
			return false;
		}else {
			return true;
		}
	}
}
