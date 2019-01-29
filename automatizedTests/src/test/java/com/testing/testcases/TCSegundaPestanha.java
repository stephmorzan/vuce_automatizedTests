package com.testing.testcases;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

import com.testing.testflow.TFPestanhaSegunda;

public class TCSegundaPestanha {

	TFPestanhaSegunda tester;
	
	public TCSegundaPestanha() throws IOException, AWTException {
		// TODO Auto-generated constructor stub
		tester = new TFPestanhaSegunda();
	}
	
	@Ignore
	@Test
	public void testIngresarDataSegundaPestanha() {
		tester.ingresarDatosPestanhaSegunda();
		System.out.println(tester.getReporte().toString());
		assertTrue(true);
	}
	
	@Test
	public void testGuardarDatosSegundaPestanha() throws IOException {
		boolean resultado = tester.guardarDatosSegunda();
		System.out.println(tester.getReporte().toString());
		assertTrue(resultado);
	}
}
