package com.testing.testflow;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;
import com.testing.tool.cte.AttributeCte;
import com.testing.tool.cte.ByCte;

public class TFPestanhaDatosSolicitante extends TFInicioRegistroNuevaSolicitud{
	
	protected List<String> pestanhas;
	String numOrden;
	Faker faker;
	
	public TFPestanhaDatosSolicitante() throws IOException, AWTException {
		// TODO Auto-generated constructor stub
		super();
		faker = new Faker(new Locale("es-MX"));
		recursivo.setFaker(faker);
		clickGuardarFormato();
		pestanhas = new ArrayList<>();
		pestanhas = this.listarPestanhasSolicitud();
	}
	
	/**
	 * Método que sirve en todos los formatos y tupas.
	 * Se va actualizando con cada Guardar.
	 * @return
	 */
	public List<String> revisarMensajes() {
		List<WebElement>listaMensajes = driver.findElement(By.className("messageAreaClass")).findElements(By.tagName(ByCte.BY_TAG_LI));
		List<String>mensajes = new ArrayList<>();
		
		for(WebElement we: listaMensajes) {
			String mensaje = we.getText();
			mensajes.add(mensaje);
			System.out.println(mensaje);
		}
		
		return mensajes;
	}
	
	public List<String> listarPestanhasSolicitud() {
		List<String> pestanhas = new ArrayList<>();
		WebElement contTabs = driver.findElement(By.cssSelector("ul[id*=\"maintab\"]"));
		List<WebElement> wePestanhas = contTabs.findElements(By.tagName(ByCte.BY_TAG_SPAN));
		reporte.appendSalto();
		reporte.appendLine("Listado de las pestañas que figuran para este formato:");
		reporte.appendSalto();
		for(WebElement we: wePestanhas) {
			reporte.appendText(we);
			String nombPestanha = we.getText();
			pestanhas.add(nombPestanha);
		}
		return pestanhas;
	}
	
	public void ingresarDatosPestanhaSolicitante() {
		driver.manage().timeouts().implicitlyWait(30000,TimeUnit.SECONDS);
		numOrden = driver.findElement(By.id("numOrden")).getAttribute(AttributeCte.GET_ATTR_VALUE);
		reporte.appendSalto();
		reporte.appendLine("Se ha generado el borrador de orden de solicitud N° " + numOrden);
		reporte.appendSalto();
//		WebElement weCodAut = driver.findElement(By.id("DETALLE.codigoEstablecimiento"));
//		Select codAutorizacion = new Select(weCodAut);
////		List<WebElement> optionsCodAutorizacion = codAutorizacion.getOptions();
//		codAutorizacion.selectByIndex(1);
		driver.manage().timeouts().implicitlyWait(90000000,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(90000000,TimeUnit.SECONDS);
		recursivo.marcarPrimeraOpcionSelect("DETALLE.codigoEstablecimiento");
		
//		WebElement direccion = driver.findElement(By.xpath("//*[@id=\"DETALLE.direccionEstablecimiento\"]"));
		driver.manage().timeouts().implicitlyWait(90000000,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(90000000,TimeUnit.SECONDS);
		recursivo.marcarPrimeraOpcionSelect("DETALLE.idDireccionEstablecimiento");

		driver.manage().timeouts().implicitlyWait(90000000,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(90000000,TimeUnit.SECONDS);
		recursivo.marcarPrimeraOpcionSelect("DETALLE.codigoRegente");

		driver.manage().timeouts().implicitlyWait(90000000,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(90000000,TimeUnit.SECONDS);
		recursivo.marcarPrimeraOpcionSelect("DETALLE.cargoRegente");
	
		driver.manage().timeouts().implicitlyWait(90000000,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(90000000,TimeUnit.SECONDS);
		recursivo.marcarPrimeraOpcionSelect("REPRESENTANTE.id");
		
		switch(tupa) {
		case 72:
			break;
		case 73:
			recursivo.llenarTextboxConUnaPalabra("DETALLE.nroColegiaturaDirector");
			recursivo.llenarTelefono("DETALLE.telefonoDirector");
			recursivo.llenarCorreoElectronico("DETALLE.emailDirector");
			recursivo.llenarTelefono("DETALLE.telefonoRepresentanteLegal");
			recursivo.llenarCorreoElectronico("DETALLE.emailRepresentanteLegal");
			break;
		}
		
	}
	
	public boolean guardarDatosSolicitante() throws IOException {
		ingresarDatosPestanhaSolicitante();
		screenshotter.tomarScreenshot();
		WebElement butGuardarDatosSolicitante = driver.findElement(By.id("grabarDetalleTopButton"));
		butGuardarDatosSolicitante.click();
		if(!saleAlerta()) {
			return false;
		}else {
			return true;
		}
	}
	
	
}
