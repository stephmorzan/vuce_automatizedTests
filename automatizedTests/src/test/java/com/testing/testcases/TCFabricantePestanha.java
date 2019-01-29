package com.testing.testcases;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

import com.testing.testflow.TFPestanhaFabricante;

public class TCFabricantePestanha {
	
	TFPestanhaFabricante tester;
	
	public TCFabricantePestanha() throws IOException, AWTException {
		// TODO Auto-generated constructor stub
		tester = new TFPestanhaFabricante();
	}

	@Test
	public void testGuardarDatosPestFabricante() throws IOException {
		boolean resultado = tester.guardarDatosFabricante();
		System.out.println(tester.getReporte().toString());
		assertTrue(resultado);
	}
	
	@Ignore
	@Test
	public void testIngresarDatosPestFabricante() {
		tester.ingresarDatosPestanhaFabricante();
		System.out.println(tester.getReporte().toString());
		assertTrue(true);
	}
	
}
