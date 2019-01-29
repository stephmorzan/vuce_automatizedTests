package com.testing.testcases;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.junit.Test;

import com.testing.testflow.TFPestanhaTercera;

public class TCTerceraPestanha {

	TFPestanhaTercera tester;
	
	public TCTerceraPestanha() throws IOException, AWTException {
		// TODO Auto-generated constructor stub
		tester = new TFPestanhaTercera();
	}
	
	@Test
	public void testIngresarDatos() throws IOException {
		boolean resultado = tester.guardarDatosTercera();
//		tester.ingresarDatosPestanhaTercera();
		System.out.println(tester.getReporte().toString());
//		assertTrue(true);
		assertTrue(resultado);
	}
	
	
	public void testSoloIngresarDatos() {
		tester.ingresarDatosPestanhaTercera();
		System.out.println(tester.getReporte().toString());
		assertTrue(true);
	}
}
