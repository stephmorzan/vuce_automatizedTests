package com.testing.tool;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ReporteTool {

	private LineBuilderStringTool contenido;

	private Date tiempo;
	private String producto;
	private String version;
	private String codActa;
	private String formato;
	private String nroTupa;
	private String casoDePrueba;
	private String autor;
	private String unidOrg;
	private List<String> urlOrigen;
	private List<String> urlDestino;
	

	public ReporteTool(Date tiempo) {
		super();
		this.tiempo = tiempo;
		contenido = new LineBuilderStringTool();
	}

	/**
	 * metodo que define la cabecera del reporte
	 * 
	 * @return
	 */
	public String getCabecera() {
		LineBuilderStringTool contenido = new LineBuilderStringTool();
		contenido.appendLine("Fecha    :" + tiempo.toString());
		contenido.appendLine("Hora     :" + tiempo.toString());
		contenido.appendSalto();
		contenido.appendLine("Autor \t: " + autor);
		contenido.appendLine("Código Acta \t: " + codActa);
		contenido.appendLine("Formato \t: " + formato);
		contenido.appendLine("Nro Tupa \t: " + nroTupa);
		contenido.appendLine("Versión \t: " + version);
		contenido.appendLine("********************************************************************");
		contenido.appendSalto();
		return contenido.toString();
	}

	/**
	 * metodo que define el pie del reporte
	 * 
	 * @return
	 */
	public String getPie() {
		LineBuilderStringTool contenido = new LineBuilderStringTool();
		contenido.appendSalto();
		contenido.appendLine("********************************************************************");
		contenido.appendLine("Unidad organizativa    : " + unidOrg);
		contenido.appendSalto();
		contenido.appendLine("Inspira IT Consulting. Todos los Derechos Reservados.");
		return contenido.toString();
	}

	public LineBuilderStringTool getContenido() {
		return contenido;
	}

	public void setContenido(LineBuilderStringTool asdf) {
		this.contenido = asdf;
	}

	public Date getTiempo() {
		return tiempo;
	}

	public void setTiempo(Date tiempo) {
		this.tiempo = tiempo;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getCasoDePrueba() {
		return casoDePrueba;
	}

	public void setCasoDePrueba(String casoDePrueba) {
		this.casoDePrueba = casoDePrueba;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public List<String> getUrlOrigen() {
		return urlOrigen;
	}

	public void setUrlOrigen(List<String> urlOrigen) {
		this.urlOrigen = urlOrigen;
	}

	public List<String> getUrlDestino() {
		return urlDestino;
	}

	public void setUrlDestino(List<String> urlDestino) {
		this.urlDestino = urlDestino;
	}

	public String getCodActa() {
		return codActa;
	}

	public void setCodActa(String codActa) {
		this.codActa = codActa;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getNroTupa() {
		return nroTupa;
	}

	public void setNroTupa(String nroTupa) {
		this.nroTupa = nroTupa;
	}

	public String getUnidOrg() {
		return unidOrg;
	}

	public void setUnidOrg(String unidOrg) {
		this.unidOrg = unidOrg;
	}

	
	
	/**
	 * metodo delegado
	 * 
	 * @param str
	 */
	public void append(String str) {
		contenido.append(str);
	}

	/**
	 * metodo delegado
	 * 
	 * @param str
	 */
	public void appendLine(String str) {
		contenido.appendLine(str);
	}

	/**
	 * metodo delegado
	 */
	public void appendSalto() {
		contenido.appendSalto();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String resultado = "";
		resultado = getCabecera() + contenido.toString() + getPie();
		return resultado;
	}

	public void append(WebElement webElement) {
		contenido.append(webElement.getTagName() + "\t" +
				webElement.getAttribute("id") + " \t: " + webElement.getAttribute("value"));
		contenido.appendSalto();
	}
	
	public void appendText(WebElement input) {
		String tagName = input.getTagName();
		if(tagName.equalsIgnoreCase("select")) {
			contenido.append(input.getTagName() + "\t" +
					input.getAttribute("id") + "\t : \t" + (new Select(input)).getFirstSelectedOption().getText());
			contenido.appendSalto();
		}else {
			contenido.append(input.getTagName() + "\t" +
				input.getAttribute("id") + "\t : \t" + input.getText());
		contenido.appendSalto();
		}
		
	}
	
	
//	public void appendSelectedText(WebElement campUsuario) {
//		contenido.append(campUsuario.getTagName() + "\t" +
//				campUsuario.getAttribute("id") + " \t: " + ((Select)campUsuario).getFirstSelectedOption());
//		contenido.appendSalto();
//	}
	
}
