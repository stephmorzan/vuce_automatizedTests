package com.testing.testcases;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;

import org.junit.Test;

import com.testing.testflow.TFNuevaSolicitud;

public class TCNuevaSolicitud {

	TFNuevaSolicitud tester;
	
	public TCNuevaSolicitud() throws IOException, AWTException {
		// TODO Auto-generated constructor stub
		tester = new TFNuevaSolicitud();
	}
	
	@Test
	public void testSeleccionarNuevaSolicitud() throws IOException {
		boolean resultado = tester.buscarTupaYFormato("abc","DGM078");
		System.out.println(tester.getReporte().toString());
		assertTrue(resultado);
	}
	
}
