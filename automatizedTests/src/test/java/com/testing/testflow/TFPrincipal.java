package com.testing.testflow;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testing.tool.cte.ByCte;
import com.testing.tool.cte.AttributeCte;

public class TFPrincipal extends TFLogin{

	protected final List<WebElement> opcionesMenu;
	
	public TFPrincipal() throws IOException, AWTException {
		super();
		login();
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		opcionesMenu=driver.findElement(By.id("idOpcionesMenu")).findElements(By.tagName(ByCte.BY_TAG_A));
	}

	@Ignore
	@Test
	public void seleccionarPestanaNuevaSolicitud() {
		seleccionarPestana("nuevaOrden");
		reporte.appendLine("Se seleccionó pestaña Nueva Solicitud.");
	}

	@Ignore
	@Test
	public void seleccionarPestanaSuce() {
		seleccionarPestana("listarOrdenes");
		reporte.appendLine("Se seleccionó pestaña SUCE.");
	}
	
	@Ignore
	@Test
	public void seleccionarPestanaDocsResolutivos() {
		seleccionarPestana("listarDocumentosResolutivos");
		reporte.appendLine("Se seleccionó pestaña Documentos Resolutivos.");
	}	

	@Ignore
	@Test
	public void seleccionarPestanaConsultaTecnica() {
		seleccionarPestana("listarConsultas");
		reporte.appendLine("Se seleccionó pestaña Consulta Técnica.");
	}

	@Ignore
	@Test
	public void seleccionarPestanaServicios() {
		seleccionarPestana("servicios");
		reporte.appendLine("Se seleccionó pestaña Servicios.");
	}
	
	private void seleccionarPestana(String href) {
		Iterator<WebElement> i = opcionesMenu.iterator();
		boolean selected = false;
		while(i.hasNext() && selected == false) {
			WebElement we = i.next();
			if(we.getAttribute(AttributeCte.GET_ATTR_HREF).contains(href)) {
				we.click();
				selected = true;
			}
		}
	}
}
