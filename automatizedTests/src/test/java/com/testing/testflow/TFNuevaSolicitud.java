package com.testing.testflow;

import java.awt.AWTException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.testing.tool.cte.AttributeCte;
import com.testing.tool.cte.ByCte;
import com.testing.tool.cte.RegexCte;

public class TFNuevaSolicitud extends TFPrincipal{

	Select comboEntidad;
	String entidad;

	String formato;
	int tupa;
	
	long start;

	public TFNuevaSolicitud() throws IOException, AWTException {
		super();
		// TODO Auto-generated constructor stub
		seleccionarPestanaNuevaSolicitud();
	}


	private boolean seleccionarEntidad() {
		comboEntidad.selectByVisibleText(entidad);
		return true;
	}

	public boolean buscarTupaYFormato(String tupa, String formato) throws IOException {
		boolean found;
		found = buscarEnListado(tupa, formato);
		if(found==false) {
			WebElement weEntidad;
			weEntidad = driver.findElement(By.id("entidad"));
			comboEntidad = new Select(weEntidad);
			entidad = "DIGEMID";
			seleccionarEntidad();
			screenshotter.tomarScreenshot();
			found = buscarEnUltimasOperaciones(tupa, formato);
		}
		return found;
	}

//	public void validarCampos() {
//		WebElement thead = driver.findElement(By.tagName("thead"));
//		List<WebElement> cabeceras = thead.findElements(By.tagName("span"));
//
//		for (WebElement we: cabeceras) {
//			System.out.println(we.getText());
//		}
//	}

	private boolean buscarEnUltimasOperaciones(String tupa, String formato) throws IOException {
		boolean encontrado = false;
		boolean endTable = false;

		WebElement next;

		List<WebElement> filas;
		WebElement foundFormTupa = null;
		Iterator<WebElement> iFilas;


		while(encontrado==false && endTable == false) {
			WebElement tbody = driver.findElement(By.tagName(ByCte.BY_TAG_TBODY));
			filas = tbody.findElements(By.tagName(ByCte.BY_TAG_TR));
			iFilas = filas.iterator();
			while (iFilas.hasNext() && encontrado==false) {
				WebElement we = iFilas.next();
				List<WebElement> celdas = we.findElements(By.tagName(ByCte.BY_TAG_TD));
				String tablaTupa = celdas.get(0).getText();
				String tablaFormato = celdas.get(1).getText();
				if(tablaTupa.equalsIgnoreCase(tupa) && tablaFormato.equalsIgnoreCase(formato)) {
					foundFormTupa = celdas.get(2).findElement(By.tagName(ByCte.BY_TAG_A));
					encontrado=true;
					reporte.appendLine("Se encontró el formato y tupa en la tabla.");
					reporte.appendSalto();
				}
			}
			if(encontrado==false) {
				next = driver.findElement(By.xpath("//*[@id=\"cont\"]/form/p/span[1]/b[3]"));
				String disable = next.getAttribute(AttributeCte.GET_ATTR_CLASS);
				if(!disable.contains("disabled")) {
					reporte.appendLine("Se está yendo a la siguiente página");
					next.click();
					driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				}else {
					endTable = true;
					reporte.appendLine("No existe ese formato y/o tupa.");
				}
			}

		}

		if(encontrado==true) {
			this.tupa = Integer.parseInt(tupa);
			this.formato = formato;
			start = System.currentTimeMillis();
			reporte.appendSalto();
			reporte.appendLine("Tiempo inicio carga pagina web = " + start);
			foundFormTupa.click();
			screenshotter.tomarScreenshot();
		}

		return encontrado;

	}

	private boolean buscarEnListado(String tupa, String formato) throws IOException {
		
		boolean found = false;
		String regexFormato = RegexCte.RGX_FORMATO;
		String regexTupa = RegexCte.RGX_TUPA;
		Pattern p;
		Matcher m;
		String butFormato = "";
		String butTupa = "";
		List<WebElement> ultOperaciones = driver.findElements(By.className("op_freq_tupa"));
		Iterator<WebElement> iUltOperaciones = ultOperaciones.iterator();
		reporte.appendSalto();
		reporte.appendLine("Listado de las últimas operaciones realizadas");
		reporte.appendSalto();

		while (iUltOperaciones.hasNext() && found==false) {
			WebElement temp = iUltOperaciones.next();
			String formatoTupa = temp.getText();
			reporte.appendLine(formatoTupa);
			p = Pattern.compile(regexFormato);
			m = p.matcher(formatoTupa);

			if(m.find()) {
				butFormato = m.group().trim();
			}

			p = Pattern.compile(regexTupa);
			m = p.matcher(formatoTupa);

			if(m.find()) {
				butTupa = m.group().trim();
			}

			if(butFormato.equalsIgnoreCase(formato) && butTupa.equalsIgnoreCase(tupa)) {
				this.tupa = Integer.parseInt(tupa);
				this.formato = formato;
				reporte.appendSalto();
				reporte.appendLine("Se encontró el formato y tupa entre las últimas operaciones.");
				start = System.currentTimeMillis();
				reporte.appendSalto();
				reporte.appendLine("Tiempo inicio carga pagina web = " + start);
				temp.click();
				screenshotter.tomarScreenshot();
				found=true;
			}
		}

		return found;
	}
	
}
