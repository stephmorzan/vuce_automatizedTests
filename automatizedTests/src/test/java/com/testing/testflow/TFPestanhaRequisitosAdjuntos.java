package com.testing.testflow;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testing.tool.cte.ByCte;

public class TFPestanhaRequisitosAdjuntos extends TFPestanhaFabricante{

	public TFPestanhaRequisitosAdjuntos() throws IOException, AWTException {
		super();
		// TODO Auto-generated constructor stub
		guardarDatosFabricante();
		this.seleccionarRequisitosAdjuntosPestanha();
	}
	
	protected void seleccionarRequisitosAdjuntosPestanha() {
		String textReqAdjPestanha = pestanhas.get(4);
		WebElement pestanhaReqAdj = driver.findElement(By.linkText(textReqAdjPestanha));
		pestanhaReqAdj.click();
	}
	
	public List<String> listarRequisitosAdjuntos() {
		WebElement tbody = driver.findElement(By.cssSelector("table[id*=\"_ADJUNTO_REQUERIDO\"]")).findElement(By.tagName(ByCte.BY_TAG_TBODY));
		List<WebElement> filas = tbody.findElements(By.tagName(ByCte.BY_TAG_TR));
		List<WebElement> requisitos = tbody.findElements(By.tagName(ByCte.BY_TAG_A));
		List<String> obligatorios = new ArrayList<>();
		Iterator<WebElement> iFilas = filas.iterator();
		reporte.appendSalto();
		reporte.appendLine("Lista de Requisitos Adjuntos del Formato " + this.formato);
		reporte.appendSalto();
		
		String obligatorio = "";
		WebElement requisito = null;
		
		int cont = 0;
		
		while(iFilas.hasNext()) {
			WebElement we = iFilas.next();
			List<WebElement> celdas = we.findElements(By.tagName(ByCte.BY_TAG_TD));
			obligatorio = celdas.get(0).getText();
			requisito = requisitos.get(cont);
			reporte.appendLine(obligatorio + " \t" + requisito.getText());
			obligatorios.add(obligatorio);
			cont++;
		}
		
		return obligatorios;
		
	}
	
	public void adjuntarArchivos() {
		List<String> obligatorios  = listarRequisitosAdjuntos();
		String obligatorio = "";
		int cantReqs = obligatorios.size();
		int cont=0;
		
		for(int i=0; i<cantReqs; i++) {
			obligatorio = obligatorios.get(i);
			WebElement tbody = driver.findElement(By.cssSelector("table[id*=\"_ADJUNTO_REQUERIDO\"]")).findElement(By.tagName(ByCte.BY_TAG_TBODY));
			List<WebElement> requisitos = tbody.findElements(By.tagName(ByCte.BY_TAG_A));
			if(obligatorio.contains("Si")) {
//				reporte.appendSalto();
//				reporte.appendLine("Se va a adjuntar archivo para el sgte requisito:");
				WebElement we = requisitos.get(i);
//				reporte.appendLine(we.getText());
				recursivo.abrirEnlaceYCambiarAPopup(we);
				String path = screenshotter.getDesktopPath() + "\\test.pdf";
				WebElement subirDoc = driver.findElement(By.name("archivo"));
				driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		        subirDoc.sendKeys(path);
		        driver.findElement(By.id("cargarButton")).click();
		        driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
				
				driver.findElement(By.id("cerrarPopUpButton")).click();
				cont++;
				driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
//				reporte.appendLine("Se ha adjuntado exitosamente archivo test.pdf para este requisito");
			}
		}
		
		reporte.appendSalto();
		reporte.appendLine("Cantidad de requisitos que sí requieren adjuntar archivos: " + 
		cont + " de " + cantReqs);
		reporte.appendSalto();
	}
	
	public void obtenerNotasDeRequisitos() {
//		WebElement contenedor = driver.findElement(By.id("tabAdjuntos"));
		WebElement campoNotas = driver.findElement(By.cssSelector("div[style*=\"color:red; text-align:left;padding:10px;\"]"));
		List<WebElement> divsNotas = campoNotas.findElements(By.tagName(ByCte.BY_TAG_DIV));
		reporte.appendSalto();
		reporte.appendLine("Lista de notas ubicadas al final de la página:");
		reporte.appendSalto();
		for (WebElement we : divsNotas) {
			reporte.appendLine(we.getText());
		}
	}
	
	public boolean sePuedeTransmitir() {
		adjuntarArchivos();
		switch(tupa) {
		case 72:
			obtenerNotasDeRequisitos();
			break;
		}
		
		WebElement butTransmitir = driver.findElement(By.id("transButton"));
		if(butTransmitir.isEnabled()) {
			reporte.appendSalto();
			reporte.appendLine("Se ha habilitado botón Transmitir.");
			reporte.appendSalto();
			reporte.appendLine("Se va a transmitir la Orden N° " + numOrden);
			return true;
		}else {
			reporte.appendSalto();
			reporte.appendLine("NO está activo botón Transmitir.");
			return false;
		}
	}

	public void transmitirSolicitud(WebElement butTransmitir) {
		butTransmitir.click();
		revisarMensajes();
	}
}
