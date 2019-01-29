package com.testing.testcases;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.junit.Test;

import com.testing.testflow.TFInicioRegistroNuevaSolicitud;

public class TCInicioRegistro {

	TFInicioRegistroNuevaSolicitud tester;
	
	public TCInicioRegistro() throws IOException, AWTException {
		// TODO Auto-generated constructor stub
		tester = new TFInicioRegistroNuevaSolicitud();
	}
	
	@Test
	public void testDos(){
		tester.clickGuardarFormato();
		System.out.println(tester.getReporte().toString());
		assertTrue(true);
	}
}
