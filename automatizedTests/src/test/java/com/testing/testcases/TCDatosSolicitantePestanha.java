package com.testing.testcases;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.testing.testflow.TFPestanhaDatosSolicitante;

public class TCDatosSolicitantePestanha {

	TFPestanhaDatosSolicitante tester;
	
	public TCDatosSolicitantePestanha() throws IOException, AWTException {
		// TODO Auto-generated constructor stub
		tester = new TFPestanhaDatosSolicitante();
	}
	
	@Ignore
	@Test
	public void testRevisarMensajes() {
		List<String> resultado = tester.revisarMensajes();
		System.out.println(tester.getReporte().toString());
		assertNotNull(resultado);
	}
	
	
	@Test
	public void testIngresarDatos() throws IOException {
		boolean resultado = tester.guardarDatosSolicitante();
		tester.listarPestanhasSolicitud();
		System.out.println(tester.getReporte().toString());
		assertTrue(resultado);
	}
}
