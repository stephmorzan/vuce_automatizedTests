package com.testing.testflow;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testing.tool.cte.ByCte;

public class TFPestanhaTercera extends TFPestanhaSegunda{

	public TFPestanhaTercera() throws IOException, AWTException {
		super();
		// TODO Auto-generated constructor stub
		guardarDatosSegunda();
		seleccionarTerceraPestanha();
	}

	protected void seleccionarTerceraPestanha() {
		String textTerceraPestanha = pestanhas.get(2);
		WebElement pestanhaTres = driver.findElement(By.linkText(textTerceraPestanha));
		pestanhaTres.click();
	}

	public void ingresarDatosPestanhaTercera() {

		//aquí comienzan a aparecer las subpestañas
		switch(tupa) {
		case 72:
			String tipoTramite = properties.getTipoTramite().replace('o', 'ó');
			WebElement tbody = null;
			switch(tipoTramite) {
			
			case "Inscripción":
				recursivo.llenarTextboxConUnaPalabra("DETALLE.nombreProducto");
				//aqui está subpartida nacional. acá se debe colocar nombres de frutas

				recursivo.llenarTextboxConUnaPalabra("DETALLE.concentracion");

				recursivo.abrirBuscadorYCambiarAPopup("buscarFormaFarmaceuticaButton");

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

				tbody = driver.findElement(By.id("table_FORMA_FARMACEUTICA")).findElement(By.tagName(ByCte.BY_TAG_TBODY));
				List<WebElement> nombsFormFarmac = tbody.findElements(By.tagName(ByCte.BY_TAG_A));
				//				System.out.println(nombsFormFarmac.size());
				nombsFormFarmac.get(0).click();
				driver.switchTo().parentFrame();

				driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);

				recursivo.marcarOpcionSegunTextoSelect("select_DETALLE_origenProducto", "NACIONAL");

				recursivo.marcarPrimeraOpcionSelect("select_DETALLE_grupoFarmaceutico");

				recursivo.marcarOpcionSegunTextoSelect("DETALLE.condicionVenta", "SIN RECETA MÉDICA");

				recursivo.llenarTextboxConUnaPalabra("DETALLE.formaPresentacion");

				recursivo.marcarPrimeraOpcionSelect("DETALLE.estFarmaceutico");

				recursivo.marcarPrimeraOpcionSelect("DETALLE.sustento");

				recursivo.marcarPrimeraOpcionSelect("DETALLE.formulaCualicuantitativa");

				recursivo.marcarOpcionSegunTextoSelect("DETALLE.esPack", "No");

				recursivo.marcarOpcionSegunTextoSelect("DETALLE.tieneDispMedico", "No");

				recursivo.marcarPrimeraOpcionSelect("DETALLE.unidadTiempoVida");

				recursivo.llenarTextboxConNumerosEnRango("DETALLE.vidaUtil", 6);

				driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
				break;
			case "Reinscripción":
				recursivo.abrirBuscadorYCambiarAPopup("buscarRegistroSanitarioButton");
				WebElement popup_inputNombre = driver.findElement(By.id("nombre"));
				popup_inputNombre.sendKeys("");
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
				
				tbody = driver.findElement(By.id("table_REGISTROS_SANITARIOS")).findElement(By.tagName(ByCte.BY_TAG_TBODY));
				List<WebElement> registrosSan = tbody.findElements(By.tagName(ByCte.BY_TAG_A));
				//				System.out.println(nombsFormFarmac.size());
				registrosSan.get(0).click();
				driver.switchTo().parentFrame();

				driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
				
				recursivo.marcarOpcionSegunTextoSelect("DETALLE.condicionVenta", "CON RECETA MÉDICA");
				recursivo.llenarTextboxConUnaPalabra("DETALLE.formaPresentacion");
				recursivo.marcarPrimeraOpcionSelect("DETALLE.sustento");
				recursivo.marcarPrimeraOpcionSelect("DETALLE.formulaCualicuantitativa");
				recursivo.marcarOpcionSegunTextoSelect("DETALLE.esPack", "No");

				recursivo.marcarOpcionSegunTextoSelect("DETALLE.tieneDispMedico", "No");
				recursivo.llenarTextboxConUnaPalabra("DETALLE.sistemaCodificacion");
				
				recursivo.abrirBuscadorYCambiarAPopup("buscarPartidaArancelariaButton");
				popup_inputDescripcion = driver.findElement(By.id("descripcion"));
				popup_inputDescripcion.sendKeys(faker.lorem().character()+"");
				
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
				
				tbody = driver.findElement(By.id("table_PARTIDA_ARANCELARIA")).findElement(By.tagName(ByCte.BY_TAG_TBODY));
				List<WebElement> subpartidaNac = tbody.findElements(By.tagName(ByCte.BY_TAG_A));
				//				System.out.println(nombsFormFarmac.size());
				subpartidaNac.get(0).click();
				driver.switchTo().parentFrame();

				driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
				break;
			}


			break;

		case 73:
			recursivo.llenarTextboxConUnaPalabra("DETALLE.numeroLote");
			recursivo.llenarTextboxConNumerosEnRango("DETALLE.cantidadUnidades", 5);
			recursivo.llenarTextboxConUnaPalabra("DETALLE.formaPresentacion");

			recursivo.llenarTextboxConUnaPalabra("DETALLE.sistemaIdentificacion");

			recursivo.marcarPrimeraOpcionSelect("DETALLE.pais");

			driver.findElement(By.id("grabarLoteButton")).click();

			driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);

			//Grabar envase inmediato
			recursivo.abrirBuscadorYCambiarAPopup("nuevoEnvaseInmediatoButton");

			recursivo.marcarPrimeraOpcionSelect("ENVASEINMEDIATO.envaseInmediato");

			recursivo.llenarTextboxConUnaPalabra("ENVASEINMEDIATO.tipoTapa");

			driver.findElement(By.id("grabarButton")).click();

			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);

			recursivo.marcarPrimeraOpcionSelect("MATERIALENVASEINM.material");

			recursivo.marcarPrimeraOpcionSelect("MATERIALENVASEINM.color");

			driver.findElement(By.id("nuevoMaterialEnvaseButton")).click();

			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);

			driver.findElement(By.id("cerrarPopUpButton")).click();

			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);

			//Grabar Envase Mediato
			driver.findElement(By.cssSelector("a[rel*=\"tabEnvaseMediato\"]")).click();
			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);

			recursivo.abrirBuscadorYCambiarAPopup("nuevoEnvaseMediatoButton");

			recursivo.marcarPrimeraOpcionSelect("ENVASEMEDIATO.envaseMediato");

			driver.findElement(By.id("grabarButton")).click();

			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);

			recursivo.marcarPrimeraOpcionSelect("MATERIALENVASEMED.material");

			driver.findElement(By.id("nuevoMaterialEnvaseButton")).click();

			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);

			driver.findElement(By.id("cerrarPopUpButton")).click();

			driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);

			break;
		}
	}

	@SuppressWarnings("null")
	public boolean guardarDatosTercera() throws IOException {
		ingresarDatosPestanhaTercera();
		//		screenshotter.tomarScreenshot();
		driver.manage().timeouts().implicitlyWait(20000,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20000,TimeUnit.SECONDS);
		WebElement butGuardarDatosTercera = null;
		switch(tupa) {
		case 72:
			butGuardarDatosTercera = driver.findElement(By.cssSelector("input[value*=\"Guardar Producto\"]"));
			break;
		case 73:
			butGuardarDatosTercera = driver.findElement(By.id("grabarLoteButton"));
			break;
		}

		//		String id = butGuardarDatosTercera.getAttribute("title");
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
		butGuardarDatosTercera.click();
		driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);

		switch(tupa) {
		case 72:
			List<String> subpestanhas = retornarListaSubpestanhas();

			//Mejorar y optimizar este mecanismo para recorrer subpestanhas
			if (subpestanhas != null && !subpestanhas.isEmpty()) {
				WebElement subPestanhaTres;
				//aca solo son las primeras 4 subpestanhas
				for (int i=0; i<4; i++) {
					driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
					String textSubPest = subpestanhas.get(i);
					subPestanhaTres = driver.findElement(By.linkText(textSubPest));
					subPestanhaTres.click();

					switch(textSubPest) {
					case "Sustento de Registro":
						recursivo.marcarPrimeraOpcionSelect("DGM007SUSTENTOREGISTRO.sustentoRegistro");
						driver.findElement(By.id("nuevoDGM007SustentoRegistroButton")).click();
						break;
					case "Fórmula Cualitativa y Cuantitativa":
						recursivo.marcarPrimeraOpcionSelect("tipoSustancia");
						recursivo.abrirBuscadorYCambiarAPopup("nuevaSustanciaButton");
						recursivo.abrirBuscadorYCambiarAPopup("buscarSustanciaButton");

						WebElement popup_inputDescripcion = driver.findElement(By.id("descripcion"));
						popup_inputDescripcion.sendKeys("d");

						start = System.currentTimeMillis();
						reporte.appendLine("Tiempo inicio carga tabla popup = " + start);
						reporte.appendSalto();
						driver.findElement(By.id("buscarButton")).click();

						driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);

						end = System.currentTimeMillis();
						reporte.appendLine("Tiempo fin de carga = " + end);
						reporte.appendSalto();
						reporte.appendLine("Tiempo total de carga: " + (end-start));

						WebElement tbody = driver.findElement(By.id("table_SUSTANCIA")).findElement(By.tagName(ByCte.BY_TAG_TBODY));
						List<WebElement> nombsSustancias = tbody.findElements(By.tagName(ByCte.BY_TAG_A));
						//					System.out.println(nombsFormFarmac.size());
						nombsSustancias.get(0).click();
						driver.switchTo().parentFrame();

						driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);

						recursivo.llenarTextboxConNumero("DGM007PRINCIPIOACTIVO.sustanciaSal");
						recursivo.marcarPrimeraOpcionSelect("DGM007PRINCIPIOACTIVO.unidadMedida");
						driver.findElement(By.id("grabarButton")).click();
						driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
						driver.findElement(By.id("cerrarPopUpButton")).click();

						driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);

						break;
					case "Vía de Administración":
						recursivo.marcarPrimeraOpcionSelect("viaAdministracion");
						driver.findElement(By.id("agregarViaAdmButton")).click();
						break;
					case "Envase Inmediato":
						recursivo.abrirBuscadorYCambiarAPopup("nuevoDGM007EnvaseInmediatoButton");
						recursivo.marcarPrimeraOpcionSelect("DGM007ENVASEINMEDIATO.tipo");
						recursivo.llenarTextboxConUnaPalabra("DGM007ENVASEINMEDIATO.tipoTapa");
						driver.findElement(By.id("grabarButton")).click();
						driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);

						recursivo.abrirBuscadorYCambiarAPopup("buscarMaterialButton");

						WebElement popup_inputNombre = driver.findElement(By.id("nombre"));
						popup_inputNombre.sendKeys("d");

						start = System.currentTimeMillis();
						reporte.appendLine("Tiempo inicio carga tabla popup = " + start);
						reporte.appendSalto();
						driver.findElement(By.id("buscarButton")).click();

						driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);

						end = System.currentTimeMillis();
						reporte.appendLine("Tiempo fin de carga = " + end);
						reporte.appendSalto();
						reporte.appendLine("Tiempo total de carga: " + (end-start));

						tbody = driver.findElement(By.id("table_MATERIALES")).findElement(By.tagName(ByCte.BY_TAG_TBODY));
						List<WebElement> materiales = tbody.findElements(By.tagName(ByCte.BY_TAG_A));
						//					System.out.println(nombsFormFarmac.size());
						materiales.get(0).click();
						driver.switchTo().parentFrame();

						driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);

						recursivo.marcarPrimeraOpcionSelect("color");

						driver.findElement(By.id("agregarDetalleButton")).click();
						driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
						recursivo.marcarPrimeraOpcionSelect("sustento");
						driver.findElement(By.id("agregarSustentoButton")).click();
						driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);

						driver.findElement(By.id("cerrarPopUpButton")).click();

						driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
						break;
					}
				}
				break;
			}

		}

		if(!saleAlerta()) {
			return false;
		}else {
			return true;
		}
	}

	public List<String> retornarListaSubpestanhas() {
		List<String> subpestanhas = new ArrayList<>();
		WebElement contTabs = driver.findElement(By.cssSelector("ul[id$=\""+pestanhas.get(2)+"\"]"));
		List<WebElement> weSubPestanhas = contTabs.findElements(By.tagName(ByCte.BY_TAG_SPAN));
		reporte.appendSalto();
		reporte.appendLine("Lista de subpestañas de la pestaña " + pestanhas.get(2));
		reporte.appendSalto();
		for(WebElement we: weSubPestanhas) {
			reporte.appendText(we);
			String nombPestanha = we.getText();
			subpestanhas.add(nombPestanha);
		}
		return subpestanhas;
	}
}
